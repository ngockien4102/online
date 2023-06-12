/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Context.ContextDB;
import Dao.IDao.IAddressCustomerDao;
import Model.AddressCustomer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSII
 */
public class AddressCustomerDao extends ContextDB implements IAddressCustomerDao {

    @Override
    public AddressCustomer CartAddress(int personId) {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select a.address from AddressCustomer a, person p\n"
                + "where p.PersonId = a.PersonId\n"
                + "and p.PersonId = ?\n"
                + "Order by a.orderId \n"
                + "desc \n"
                + "limit 1";
        try {
            // Open the database connection
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, personId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AddressCustomer address = new AddressCustomer();
                address.setAddress(rs.getString("address"));
                return address;
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        }
        return null;
    }

    @Override
    public AddressCustomer Address(int OrderId) {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "SELECT * FROM addresscustomer\n"
                + "where OrderId = ?;";
        try {
            // Open the database connection
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, OrderId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AddressCustomer address = new AddressCustomer();
                address.setPersonId(rs.getInt("personId"));
                address.setOrderId(rs.getInt("orderId"));
                address.setAddress(rs.getString("address"));
                address.setNotes(rs.getString("notes"));
                return address;
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        }
        return null;
    }

    @Override
    public void insertAddress(int PersonId, String orderId, String address, String notes) {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "insert into addresscustomer (PersonId, OrderId, Address, notes) values (?, ?, ?, ?)";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, PersonId);
            ps.setString(2, orderId);
            ps.setString(3, address);
            ps.setString(4, notes);
            ps.executeUpdate();
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        }
    }

    public static void main(String[] args) {
        AddressCustomerDao acd = new AddressCustomerDao();
        System.out.println(acd.CartAddress(1).toString());
    }
}
