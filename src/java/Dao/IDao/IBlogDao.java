/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.IDao;

import Model.Blog;
import Model.BlogDetails;
import Model.Post;
import java.util.List;

/**
 *
 * @author MSII
 */
public interface IBlogDao {

    // search title or description
    public List<Blog> searchBlog(String text, int index);

    // List  3 new Blog
    public List<Blog> List3NewBlog();

    // get Blog by id
    public BlogDetails GetBlogbyId(int id);

    //Get end page
    public int getNumberEndPageBlog();

    //list of all blogs for marketing
    public List<Post> ListAllPost();
    
    // view blog details by slider Id
    public BlogDetails ViewBlogbySliderId(int sliderId);
    // view post follow a author
    public List<Post> ListaAuthorPost(int mId);
    // list post follow category
    public List<Post> ListSliderPost(int sId);
    // list post follow status
    public List<Post> ListSstatus(String status);
    //Search post follow title
    public List<Post> SearchPostTitle(String Title);
    // view Post Detail
    public Post PostDetail(int blogId);
    // add post mkt
    public void AddPost(Blog blog);
    //edit post mkt
    public void UpdatePost(String Title, String Img, String Describes, int ProductId, int Discount, int SliderId, int blogId);

}
