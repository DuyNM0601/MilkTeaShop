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
import javax.naming.NamingException;
import sample.dto.User;
import sample.utils.DBUtils;

/**
 *
 * @author duy
 */
public class userDAO {
     public static final String LOGIN = "select fullName, roleID from tblUsers\n"
            + "where userID = ? and password = ?";
    public static final String SEARCH = "select userID,fullName,roleID from tblUsers\n"
            + "where fullName like ? ";
    public static final String DELETE = "delete tblUsers where userID = ?";
    public static final String UPDATE = "update tblUsers set fullName = ?,roleID = ? where userID = ?";
    public static final String CHECK_DUPPLIDATE = "SELECT fullName from tblUsers where userID = ?";
    public static final String INSERT = "insert into tblUsers(userID, fullName, roleID,password) values(?,?,?,?)";
     private static final String CHECK_EXISTED = "SELECT userID FROM tblUsers where userID =?";
     private static final String SEARCHUSER = "select top 2 userID,fullName,roleID from tblUsers";
    public User checkLogin(String userID, String password) throws SQLException {
        User user = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                pst = cn.prepareStatement(LOGIN);
                pst.setString(1, userID);
                pst.setString(2, password);   
                rs = pst.executeQuery();
                if (rs.next()) {
                    String fullname = rs.getString("fullName");
                    String roleid = rs.getString("roleID");
                    user = new User(userID, fullname, roleid, password);
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
            if (rs != null) {
                rs.close();
            }
        }
        return user;
    }

   public List getListUser(String search) throws SQLException {
        List list = new ArrayList();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                pst = cn.prepareStatement(SEARCH);
                pst.setString(1, "%"+search+"%");
                rs = pst.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String fullname = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    String password = "***";
                    User user = new User(userID, fullname, roleID, password);
                    list.add(user);
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
            if (rs != null) {
                rs.close();
            }
        }
        return list;
    }

    public boolean delete(String userid) throws SQLException {
        boolean check = false;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn=DBUtils.getConnection();
            if(cn!=null){
                pst = cn.prepareStatement(DELETE);
                pst.setString(1, userid);
                check = pst.executeUpdate()>0?true:false;
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
            if (rs != null) {
                rs.close();
            }
        }
        
        
        return check;
    }

        public boolean update(User user) throws SQLException {
        boolean checkupdate = false;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn=DBUtils.getConnection();
            if(cn!=null){
                pst = cn.prepareStatement(UPDATE);
                pst.setString(1, user.getFullname());
                pst.setString(2, user.getRoleID());
                pst.setString(3, user.getUserID());
                checkupdate = pst.executeUpdate()>0?true:false;
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
            if (rs != null) {
                rs.close();
            }
        }
        
        
        return checkupdate;
    }

    public boolean checkDupplicate(String userID) throws SQLException {
        boolean check = false;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                pst = cn.prepareStatement(CHECK_DUPPLIDATE);
                pst.setString(1, userID);
                rs = pst.executeQuery();
                if (rs.next()) {
                    check = true;
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
            if (rs != null) {
                rs.close();
            }
        }
        return check;
    }

    public boolean insert(User newUser) throws SQLException {
        boolean checkupdate = false;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn=DBUtils.getConnection();
            if(cn!=null){
                pst = cn.prepareStatement(INSERT);
                 pst.setString(1, newUser.getUserID());
                pst.setString(2, newUser.getFullname());
                pst.setString(3, newUser.getRoleID());
                pst.setString(4, newUser.getPassword());
                
                checkupdate = pst.executeUpdate()>0?true:false;
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
        
        
        return checkupdate;
    }

    public boolean insertV2(User newUser) throws SQLException, ClassNotFoundException, NamingException {
        boolean checkupdate = false;
        Connection cn = null;
        PreparedStatement pst = null;
       
        try {
            cn=DBUtils.getConnection();
            if(cn!=null){
                pst = cn.prepareStatement(INSERT);
                 pst.setString(1, newUser.getUserID());
                pst.setString(2, newUser.getFullname());
                pst.setString(3, newUser.getRoleID());
                pst.setString(4, newUser.getPassword());
                
                checkupdate = pst.executeUpdate()>0?true:false;
            }
        } finally {
            
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        
        
        return checkupdate;
    }

   public boolean chechExisted(String userID) throws SQLException {
        boolean check = false;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();

            ptm = conn.prepareStatement(CHECK_EXISTED);
            ptm.setString(1, userID);

            rs = ptm.executeQuery();
            if (rs.next()) {
                check = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return check;

    }

    public List<User> getUser() throws SQLException {
     
        List<User> list = new ArrayList();
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                pst = cn.prepareStatement(SEARCHUSER);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("userID");
                    String fullName = rs.getString("fullName");
                    String roleID = rs.getString("roleID");
                    String password = "***";
                    User user = new User(userID, fullName, roleID, password);
                    list.add(user);
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

}
