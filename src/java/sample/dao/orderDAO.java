/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import javax.naming.NamingException;
import javax.naming.spi.DirStateFactory;
import javax.naming.spi.DirStateFactory.Result;
import sample.dto.Cart;
import sample.dto.Order;
import sample.dto.Product;
import sample.dto.orderDetail;
import sample.utils.DBUtils;

/**
 *
 * @author duy
 */
public class orderDAO {

    public static final String INSERTORDER = "insert into tblOrders(userID,orderDate)\n"
            + "values (?,?)";
    public static final String SEARCH = "select userID,tblOrderDetails.orderID,productID,quantity,price from tblOrderDetails, tblOrders\n"
            + "where tblOrderDetails.orderID = tblOrders.orderID and userID = ?";
    public static final String INSERTDETAIL = "insert into tblOrderDetails (orderID,productID,price,quantity)\n"
            + "values (?,?,?,?)";
    public static final String SEARCHORDERID = "select top 1 orderID from tblOrders order by orderID desc";
    public static final String SEARCHUSER = "select top 2 userID,fullName,password,roleID,status from tblUsers order by userID desc";
    

    public int insertOrder(String userID, Cart cart) throws ClassNotFoundException, SQLException, NamingException {
        int kq = 0;
        boolean check = false;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Date date = new Date(System.currentTimeMillis());
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                pst = cn.prepareStatement(INSERTORDER);
                pst.setString(1, userID);
                pst.setDate(2, date);
                kq = pst.executeUpdate();
                if (kq > 0) {
                    pst = cn.prepareStatement(SEARCHORDERID);
                    rs = pst.executeQuery();
                    if (rs != null && rs.next()) {
                        int orderID = rs.getInt("orderID");
                        if (cart != null && cart.cart.size() > 0) {
                            for (Product p : cart.getCart().values()) {
                                pst = cn.prepareStatement(INSERTDETAIL);
                                pst.setInt(1, orderID);
                                pst.setString(2, p.getProductID());
                                pst.setDouble(3, p.getPrice());
                                pst.setInt(4, p.getQuantity());
                                kq = pst.executeUpdate();

                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
            if (rs != null) {
                rs.close();
            }

        }

        return kq;
    }

    public List getListOrder(String userID) throws SQLException, ClassNotFoundException, NamingException {
        List list = new ArrayList();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                pst = cn.prepareStatement(SEARCH);
                pst.setString(1, userID);
                rs = pst.executeQuery();
                while (rs.next()) {
                    int orderID = rs.getInt("orderID");
                    String productID = rs.getString("productID");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    orderDetail order = new orderDetail(orderID, productID, price, quantity);
                    list.add(order);
                }
            }
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
            if (rs != null) {
                rs.close();
            }

        }

        return list;
    }

}
