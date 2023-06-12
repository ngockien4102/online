/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.IDao;

import Model.Slider;
import java.util.List;

/**
 *
 * @author MSII
 */
public interface ISliderDao {
    // List  all Slider
    public List<Slider> ListAllSlider();
    // list all slider in mkt
    public List<Slider> ListAllSliderMKT();
    // person create
    public List<Slider> ListPersonCreate(int personId);
    // List follow Slider
    public List<Slider> SliderSatus(int status);
    // search title slider
    public List<Slider> SeachTitleSilder(String title);
    // slider detail
    public Slider SliderDetail(int sliderId);
    // edit slider mkt
    public void UpdateSlider(String Title, String Img, String Describes, String startdate, String enddate, int sliderId);
}
