/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.IDao;

import Model.Marketing;
import java.util.List;

/**
 *
 * @author MSII
 */
public interface IMarketingDao {
    public Marketing ProfileMarketing(int accountId);
    public void RegisterMarketing(int accountId, String firstName, String lastName, String phone, String address, int gender, String birthdate, String cccd, String Img);
    //list all the authors who post the post
    public List<Marketing> ListAuthor ();
    // update profile MKT
    public void UpdateMKT(int mktId, String firstName, String lastName, String phone, String address, int gender, String birthdate, String Img);
}
