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
public class Account {

    private int accountId;

    private String email;

    private String password;

    private int role;

    public Account() {
    }

    public Account(String email, int role) {
        this.email = email;
        this.role = role;
    }

    public Account(int accountId, int role) {
        this.accountId = accountId;
        this.role = role;
    }

    public Account(int accountId, String email, String password, int role) {
        this.accountId = accountId;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" + "accountId=" + accountId + ", email=" + email + ", password=" + password + ", role=" + role + '}';
    }

}
