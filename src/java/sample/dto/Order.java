/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.dto;


import java.sql.Date;

/**
 *
 * @author duy
 */
public class Order {
   private int orderID;
   private String userID;
   private Date orderDate;
  

    public Order() {
    }

    public Order(int orderID, String userID, Date orderDate) {
        this.orderID = orderID;
        this.userID = userID;
        this.orderDate = orderDate;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

}
