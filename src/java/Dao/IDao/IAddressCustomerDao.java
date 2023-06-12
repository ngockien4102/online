/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.IDao;

import Model.AddressCustomer;
import java.util.List;

/**
 *
 * @author MSII
 */
public interface IAddressCustomerDao {
    // list of addresses of that customer who have purchased
    public AddressCustomer CartAddress(int orderId);
    // Add new customer address
    public void insertAddress(int PersonId, String orderId, String address, String notes) ;
    // Show address customer
    public AddressCustomer Address(int OrderId);
}
