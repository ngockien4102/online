/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.IDao;

import Model.Feedback;
import java.util.List;

/**
 *
 * @author MSII
 */
public interface IFeedBackDao {
    // check feedback or not
    public Feedback CheckFeedBack(int productId, int personId);
    // feedback product
    public void FeedBackProduct(Feedback feedback);
    // list feedback follow product
    public List<Feedback> ListFeedBack(int productId);
}
