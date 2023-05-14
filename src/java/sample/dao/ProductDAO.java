/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import sample.dto.Cart;
import sample.dto.Product;
import sample.utils.DBUtils;

/**
 *
 * @author duy
 */
public class ProductDAO {

    public static final String SEARCH = "select productID,name,price,quantity from tblProducts";
    public static final String GET_PRODUCT = "select name,price from tblProducts where productID = ?";
    public static final String GET_PRODUCT2 = "select name,price,quantity from tblProducts where productID = ?";
    public static final String UPDATE = "update tblProducts set quantity = ? where productID = ?";

    public List<Product> getListProduct() throws SQLException {
        List<Product> list = new ArrayList();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                pst = cn.prepareStatement(SEARCH);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String name = rs.getString("name");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    Product pr = new Product(productID, name, price, quantity);
                    list.add(pr);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public Product getProduct(String productID, int quantity) throws SQLException {
        Product pr = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                pst = cn.prepareStatement(GET_PRODUCT);
                pst.setString(1, productID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    float price = Float.parseFloat(rs.getString("price"));
                    pr = new Product(productID, name, price, quantity);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cn != null) {
                cn.close();
            }
            if (pst != null) {
                pst.close();
            }
        }

        return pr;

    }

    public Product checkOrder(String productID) throws SQLException {

        Product pr = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                pst = cn.prepareStatement(GET_PRODUCT2);
                pst.setString(1, productID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    pr = new Product(productID, name, price, quantity);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cn != null) {
                cn.close();
            }
            if (pst != null) {
                pst.close();
            }
        }

        return pr;

    }

    public boolean checkQuantity(Cart cart) throws SQLException {
        boolean check = false;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = DBUtils.getConnection();
            for (Product pr : cart.getCart().values()) {
                Product p = checkOrder(pr.getProductID());
                int checkQuantity = p.getQuantity() - pr.getQuantity();

                if (cn != null) {
                    pst = cn.prepareStatement(UPDATE);
                    pst.setInt(1, checkQuantity);
                    pst.setString(2, pr.getProductID());
                    check = pst.executeUpdate() > 0 ? true : false;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (cn != null) {
                cn.close();
            }
            if (pst != null) {
                pst.close();
            }
        }
        return check;
    }

}


