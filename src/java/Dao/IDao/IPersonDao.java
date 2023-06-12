/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.IDao;

import Model.Account;
import Model.Person;
import java.util.List;

/**
 *
 * @author MSII
 */
public interface IPersonDao {

    // output information of customer and sale
    public Person ProfilePerson(int accountId);

    // register customer and sale
    public void RegisterSale(int accountId, String Img, String firstName, String lastName, String phone, String address, int gender, String birthdate, String cccd);

    // update profile of customer
    public void UpdateProfileCustomer(int personId, String img, String firstName, String lastName, String birthDate, String phone);

    // Search User List follow fullname, email, phone, gender,role,status and Paging
    public List<Person> SearchUserListPaging(String name, String email, String Phone, int gender,
            int role, int status, String sort, int index);

    //Get end page
    public int getNumberEndPageUserList();
    //Add a new User
    public void AddNewUser(Account account, Person person);
    //view user by userid
    public Person viewUserbyID(int id);
    //Update role & status of User
    public void UpdateUser(Person person, Account account);
}
