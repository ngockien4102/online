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
public class Marketing {
    private int marketingId;
    private int accountId;
    private String firstName; 
    private String lastName;  
    private String phone;
    private String address;
    private int gender; 
    private String birthdate;
    private float salary;
    private int yearOfExp;  
    private String startDate;
    private String endDate;     
    private String cccd; 
    private String Img;
    private int status;

    public Marketing() {
    }

    public Marketing(int accountId, String firstName, String lastName, String phone, String address, int gender, String birthdate, String cccd, String Img) {
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.birthdate = birthdate;
        this.cccd = cccd;
        this.Img = Img;
    }



    public Marketing(int marketingId, int accountId, String firstName, String lastName, String phone, String address, int gender, String birthdate, float salary, int yearOfExp, String startDate, String endDate, String cccd, String Img) {
        this.marketingId = marketingId;
        this.accountId = accountId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.birthdate = birthdate;
        this.salary = salary;
        this.yearOfExp = yearOfExp;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cccd = cccd;
        this.Img = Img;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getMarketingId() {
        return marketingId;
    }

    public void setMarketingId(int marketingId) {
        this.marketingId = marketingId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getYearOfExp() {
        return yearOfExp;
    }

    public void setYearOfExp(int yearOfExp) {
        this.yearOfExp = yearOfExp;
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

    public String getImg() {
        return Img;
    }

    public void setImg(String Img) {
        this.Img = Img;
    }

    @Override
    public String toString() {
        return "Marketing{" + "marketingId=" + marketingId + ", accountId=" + accountId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", address=" + address + ", gender=" + gender + ", birthdate=" + birthdate + ", salary=" + salary + ", yearOfExp=" + yearOfExp + ", startDate=" + startDate + ", endDate=" + endDate + ", cccd=" + cccd + ", Img=" + Img + '}';
    }

}
