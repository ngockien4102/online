/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Context.ContextDB;
import Model.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Dao.IDao.IPersonDao;
import Model.Account;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MSII
 */
public class PersonDao extends ContextDB implements IPersonDao {

    @Override
    public Person ProfilePerson(int accountId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select p.*, a.email, a.password from Person p, Account a where p.accountID = ? and a.accountID = p.accountID and p.status = 1";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, accountId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Person person = new Person();
                person.setPersonId(rs.getInt("personId"));
                person.setAccountId(rs.getInt("accountId"));
                person.setImg(rs.getString("img"));
                person.setFirstName(rs.getString("firstName"));
                person.setLastName(rs.getString("lastName"));
                person.setBirthDate(rs.getString("birthDate"));
                person.setPhone(rs.getString("phone"));
                person.setAddress(rs.getString("address"));
                person.setGender(rs.getInt("gender"));
                person.setStartDate(rs.getString("startDate"));
                person.setEndDate(rs.getString("endDate"));
                person.setCccd(rs.getString("cccd"));
                person.setEmail(rs.getString("email"));
                person.setPassword(rs.getString("password"));
                return person;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return null;
    }

    @Override
    public void RegisterSale(int accountId, String Img, String firstName, String lastName, String phone, String address, int gender, String birthdate, String cccd) {
        Connection con = null;
        String query = "INSERT INTO sale (AccountId, Img, FirstName, LastName, BirthDate, Phone, Address, Gender, StartDate, EndDate, CCCD) VALUES (" + accountId + ", '" + Img + "', '" + firstName + "', '" + lastName + "', '" + birthdate + "', '" + phone + "', '" + address + "', " + gender + ", CURRENT_DATE(), DATE_ADD(CURRENT_DATE(), INTERVAL 1 YEAR), '" + cccd + "')";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Close the database connection, even if an exception occurred
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void UpdateProfileCustomer(int personId, String img, String firstName, String lastName, String birthDate, String phone) {
        Connection con = null;
        String query = "update Person set firstname = ? , lastname = ?, phone = ? , birthdate = ?, Img = ? where personId = ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, phone);
            ps.setString(4, birthDate);
            ps.setString(5, img);
            ps.setInt(6, personId);

            ps.executeUpdate();
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Close the database connection, even if an exception occurred
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<Person> SearchUserListPaging(String name, String email, String Phone,
            int gender, int role, int status, String sort, int index) {
        Connection con = null;
        List<Person> list = new ArrayList<Person>();
        String query = "SELECT p.*, a.Email, a.Role \n"
                + "FROM person as p\n"
                + "join account as a on p.AccountId = a.AccountId\n"
                + "where 1=1";
        if (gender != 2) {
            query += " and p.Gender = " + gender;
        }
        if (role != 0) {
            query += " and a.Role = " + role;
        }
        if (status != 2) {
            query += " and p.Status = " + status;
        }
        if (name != null && !name.equals("")) {
            query += " and p.FirstName like '%" + name + "%' or p.LastName like '%" + name + "%'";
        }
        if (email != null && !email.equals("")) {
            query += " and a.Email like '%" + email + "%'";
        }
        if (Phone != null && !Phone.equals("")) {
            query += " and p.Phone like '%" + Phone + "%'";
        }
        //sort id
        if (sort != null && sort.equals("Id_asc")) {
            query += " order by p.PersonId asc";
        }
        if (sort != null && sort.equals("Id_desc")) {
            query += " order by p.PersonId desc";
        }
        //sort full name
        if (sort != null && sort.equals("name_asc")) {
            query += " order by p.FirstName asc, p.LastName asc";
        }
        if (sort != null && sort.equals("name_desc")) {
            query += " order by p.FirstName desc, p.LastName desc";
        }
        //sort gender
        if (sort != null && sort.equals("gender_asc")) {
            query += " order by p.Gender asc";
        }
        if (sort != null && sort.equals("gender_desc")) {
            query += " order by p.Gender desc";
        }
        //sort email
        if (sort != null && sort.equals("email_asc")) {
            query += " order by a.Email asc";
        }
        if (sort != null && sort.equals("email_desc")) {
            query += " order by a.Email desc";
        }
        //sort phone
        if (sort != null && sort.equals("phone_asc")) {
            query += " order by p.Phone asc";
        }
        if (sort != null && sort.equals("phone_desc")) {
            query += " order by p.Phone desc";
        }
        //sort role
        if (sort != null && sort.equals("role_asc")) {
            query += " order by a.Role asc";
        }
        if (sort != null && sort.equals("role_desc")) {
            query += " order by a.Role desc";
        }
        //sort status
        if (sort != null && sort.equals("status_asc")) {
            query += " order by p.Status asc";
        }
        if (sort != null && sort.equals("status_desc")) {
            query += " order by p.Status desc";
        }
        //Paging
        query += " LIMIT 5 OFFSET " + ((index - 1) * 5);
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Person person = new Person();

                person.setPersonId(rs.getInt("personId"));
                person.setAccountId(rs.getInt("accountId"));
                person.setImg(rs.getString("img"));
                person.setFirstName(rs.getString("firstName"));
                person.setLastName(rs.getString("lastName"));
                person.setBirthDate(rs.getString("birthDate"));
                person.setPhone(rs.getString("phone"));
                person.setAddress(rs.getString("address"));
                person.setGender(rs.getInt("gender"));
                person.setStartDate(rs.getString("startDate"));
                person.setEndDate(rs.getString("endDate"));
                person.setCccd(rs.getString("cccd"));
                person.setStatus(rs.getInt("status"));
                person.setEmail(rs.getString("email"));
                person.setRole(rs.getInt("role"));

                list.add(person);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public int getNumberEndPageUserList() {
        Connection con = null;
        String query = "SELECT count(*) \n"
                + "FROM person as p\n"
                + "join account as a on p.AccountId = a.AccountId";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int totalItem = rs.getInt(1);
                int endPage = 0;
                endPage = totalItem / 5;
                if (totalItem % 5 != 0) {
                    endPage++;
                }
                return endPage;
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    @Override
    public void AddNewUser(Account account, Person person) {
        Connection con = null;
        try {
            //add new account
            String sql = "INSERT INTO `onlineshop`.`account` (`Email`, `Password`, `Role`) VALUES (?, '', ?)";
            con = connection;
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, account.getEmail());
            ps.setInt(2, account.getRole());

            ps.executeUpdate();
            //take id new a account
            String sql2 = "SELECT AccountId FROM account\n"
                    + "order by AccountId desc\n"
                    + "limit 1;";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ResultSet rs2 = ps2.executeQuery();
            if (rs2.next()) {
                int accountId = rs2.getInt(1);
                //add new student
                String sql3 = "INSERT INTO `onlineshop`.`person` (`AccountId`, `Img`, `FirstName`,"
                        + " `LastName`, `BirthDate`, `Phone`, `Address`, `Gender`, `StartDate`, "
                        + "`EndDate`, `CCCD`, `Status`) VALUES (" + accountId + ", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1)";
                PreparedStatement ps3 = con.prepareStatement(sql3);

                ps3.setString(1, person.getImg());
                ps3.setString(2, person.getFirstName());
                ps3.setString(3, person.getLastName());
                ps3.setString(4, person.getBirthDate());
                ps3.setString(5, person.getPhone());
                ps3.setString(6, person.getAddress());
                ps3.setInt(7, person.getGender());
                ps3.setString(8, person.getStartDate());
                ps3.setString(9, person.getEndDate());
                ps3.setString(10, person.getCccd());

                ps3.executeUpdate();
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Person viewUserbyID(int id) {
        Connection con = null;
        String query = "SELECT p.*, a.Email, a.Role \n"
                + "FROM person as p\n"
                + "join account as a on p.AccountId = a.AccountId\n"
                + "where p.PersonId = ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Person person = new Person();

                person.setPersonId(rs.getInt("personId"));
                person.setAccountId(rs.getInt("accountId"));
                person.setImg(rs.getString("img"));
                person.setFirstName(rs.getString("firstName"));
                person.setLastName(rs.getString("lastName"));
                person.setBirthDate(rs.getString("birthDate"));
                person.setPhone(rs.getString("phone"));
                person.setAddress(rs.getString("address"));
                person.setGender(rs.getInt("gender"));
                person.setStartDate(rs.getString("startDate"));
                person.setEndDate(rs.getString("endDate"));
                person.setCccd(rs.getString("cccd"));
                person.setStatus(rs.getInt("status"));
                person.setEmail(rs.getString("email"));
                person.setRole(rs.getInt("role"));

                return person;
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    @Override
    public void UpdateUser(Person person, Account account) {
        Connection con = null;
        //Update Status
        String query = "UPDATE `onlineshop`.`person` SET `Status` = ? WHERE (`PersonId` = ?)";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, person.getStatus());
            ps.setInt(2, person.getPersonId());

            ps.executeUpdate();
            
            //Update Role
            String query2 = "UPDATE `onlineshop`.`account` SET `Role` = ? WHERE (`AccountId` = ?);";
            PreparedStatement ps2 = con.prepareStatement(query2);

            ps2.setInt(1, account.getRole());
            ps2.setInt(2, account.getAccountId());

            ps2.executeUpdate();
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(PersonDao.class.getName()).log(Level.SEVERE, null, e);
        }
    }

}
