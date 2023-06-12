/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.IDao;

import Model.Account;
import Model.Person;

/**
 *
 * @author MSII
 */
public interface IAccountDao {
    // check email and pass
    public Account checkLogin (String email, String password);
    // check email null or !null
    public Account checkAccount (String email);
    // register new accout
    public void Register(String email, String password, Person person);
    // Change password
    public void ChangePass(String pass, int accountID);
    // check that email to send newpass
    public Account getCustomerByEmail(String email);
    // new password for forgetpass
    public void NewPass(String passwork, String email);
}
