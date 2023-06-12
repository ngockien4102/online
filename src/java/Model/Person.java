/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author MSII
 */
public class Person {

    private int personId;
    private int accountId;
    private String img;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String phone;
    private String address;
    private int gender;
    private String startDate;
    private String endDate;
    private String cccd;
    private String email;
    private String password;
    private int role;
    private int status;

    public Person() {
    }

    public Person(String img, String firstName, String lastName, String birthDate, String phone, String address, int gender, String startDate, String endDate, String cccd) {
        this.img = img;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cccd = cccd;
    }

    public Person(int personId, int status) {
        this.personId = personId;
        this.status = status;
    }

    public Person(int personId, int accountId, String img, String firstName, String lastName, String birthDate, String phone, String address, int gender, String startDate, String endDate, String cccd, String email, String password, int role, int status) {
        this.personId = personId;
        this.accountId = accountId;
        this.img = img;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cccd = cccd;
        this.email = email;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public Person(String img, String firstName, String lastName, String birthDate, String phone, int gender) {
        this.img = img;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.phone = phone;
        this.gender = gender;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" + "personId=" + personId + ", accountId=" + accountId + ", img=" + img + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", phone=" + phone + ", address=" + address + ", gender=" + gender + ", startDate=" + startDate + ", endDate=" + endDate + ", cccd=" + cccd + ", email=" + email + ", password=" + password + ", role=" + role + ", status=" + status + '}';
    }

}
