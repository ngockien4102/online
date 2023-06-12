/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Context.ContextDB;
import Dao.IDao.IBlogDao;
import Model.Blog;
import Model.BlogDetails;
import Model.Post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MSII
 */
public class BlogDao extends ContextDB implements IBlogDao {

    @Override
    public List<Blog> List3NewBlog() {
        Connection con = null;
        List<Blog> list = new ArrayList<Blog>();
        String query = "SELECT * FROM blog\n"
                + "order by DateSubmit desc\n"
                + "limit 3";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Blog blog = new Blog();
                blog.setBlogId(rs.getInt("blogId"));
                blog.setTitle(rs.getString("title"));
                blog.setImg(rs.getString("img"));
                blog.setMarketingId(rs.getInt("marketingId"));
                blog.setDescribes(rs.getString("describes"));
                blog.setProductId(rs.getInt("productId"));
                blog.setDiscount(rs.getInt("discount"));
                blog.setSliderId(rs.getInt("sliderId"));
                blog.setDateSubmit(rs.getString("dateSubmit"));

                list.add(blog);
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        }
        return list;
    }

    @Override
    public BlogDetails GetBlogbyId(int id) {
        Connection con = null;
        String query = "SELECT b.*, m.FirstName, m.LastName, m.Img as imgMarketing FROM blog as b join marketing as m on b.MarketingId=m.MarketingId\n"
                + "where BlogId = ?";
        try {
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BlogDetails blog = new BlogDetails();
                blog.setBlogId(rs.getInt("blogId"));
                blog.setTitle(rs.getString("title"));
                blog.setImg(rs.getString("img"));
                blog.setMarketingId(rs.getInt("marketingId"));
                blog.setDescribes(rs.getString("describes"));
                blog.setProductId(rs.getInt("productId"));
                blog.setDiscount(rs.getInt("discount"));
                blog.setSliderId(rs.getInt("sliderId"));
                blog.setDateSubmit(rs.getString("dateSubmit"));
                blog.setFirstName(rs.getString("firstName"));
                blog.setLastName(rs.getString("lastName"));
                blog.setImgMarketing(rs.getString("imgMarketing"));

                return blog;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return null;
    }

    @Override
    public List<Blog> searchBlog(String text, int index) {
        Connection con = null;
        List<Blog> list = new ArrayList<Blog>();
        String query = "with x as (SELECT * FROM blog\n"
                + "ORDER BY DateSubmit DESC\n"
                + "LIMIT 6 OFFSET ?)\n"
                + "select * from x where 1=1";
        if (text != null && !text.equals("")) {
            query += " and Title like '%" + text + "%' or Describes like '%" + text + "%'";
        }
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, (index - 1) * 6);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Blog blog = new Blog();
                blog.setBlogId(rs.getInt("blogId"));
                blog.setTitle(rs.getString("title"));
                blog.setImg(rs.getString("img"));
                blog.setMarketingId(rs.getInt("marketingId"));
                blog.setDescribes(rs.getString("describes"));
                blog.setProductId(rs.getInt("productId"));
                blog.setDiscount(rs.getInt("discount"));
                blog.setSliderId(rs.getInt("sliderId"));
                blog.setDateSubmit(rs.getString("dateSubmit"));

                list.add(blog);
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return list;
    }

    @Override
    public int getNumberEndPageBlog() {
        Connection con = null;
        String query = "SELECT COUNT(*) FROM blog";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int totalItem = rs.getInt(1);
                int endPage = 0;
                endPage = totalItem / 6;
                if (totalItem % 6 != 0) {
                    endPage++;
                }
                return endPage;
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    @Override
    public List<Post> ListAllPost() {
        Connection con = null;
        List<Post> list = new ArrayList<Post>();
        String query = "SELECT b.*, m.firstName, m.lastName, m.img AS mimg, s.title AS stitle, s.img AS simg, s.describes AS sdescribes, s.startDate, s.endDate,\n"
                + "CASE WHEN s.enddate <= sysdate() THEN '0' ELSE '1' END AS statu\n"
                + "FROM Blog b\n"
                + "JOIN Slider s ON b.sliderId = s.sliderId\n"
                + "JOIN Marketing m ON b.marketingId = m.marketingId\n"
                + "ORDER BY b.DateSubmit DESC";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setBlogId(rs.getInt("blogId"));
                post.setTitle(rs.getString("title"));
                post.setImg(rs.getString("img"));
                post.setMarketingId(rs.getInt("marketingId"));
                post.setDescribes(rs.getString("describes"));
                post.setProductId(rs.getInt("productId"));
                post.setDiscount(rs.getInt("discount"));
                post.setSliderId(rs.getInt("sliderId"));
                post.setDateSubmit(rs.getString("dateSubmit"));
                post.setFirstName(rs.getString("firstName"));
                post.setLastName(rs.getString("lastName"));
                post.setMimg(rs.getString("mimg"));
                post.setStitle(rs.getString("stitle"));
                post.setSimg(rs.getString("simg"));
                post.setSdescribes(rs.getString("sdescribes"));
                post.setStartDate(rs.getString("startDate"));
                post.setEndDate(rs.getString("endDate"));
                post.setStatu(rs.getInt("statu"));
                list.add(post);
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        }
        return list;
    }

    @Override
    public Post PostDetail(int blogId) {
        Connection con = null;
        String query = "SELECT b.*, m.firstName, m.lastName, m.img AS mimg, s.title AS stitle, s.img AS simg, s.describes AS sdescribes, s.startDate, s.endDate,\n"
                + "CASE WHEN s.enddate <= sysdate() THEN '0' ELSE '1' END AS statu\n"
                + "FROM Blog b\n"
                + "JOIN Slider s ON b.sliderId = s.sliderId\n"
                + "JOIN Marketing m ON b.marketingId = m.marketingId\n"
                + "WHERE blogId = ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, blogId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setBlogId(rs.getInt("blogId"));
                post.setTitle(rs.getString("title"));
                post.setImg(rs.getString("img"));
                post.setMarketingId(rs.getInt("marketingId"));
                post.setDescribes(rs.getString("describes"));
                post.setProductId(rs.getInt("productId"));
                post.setDiscount(rs.getInt("discount"));
                post.setSliderId(rs.getInt("sliderId"));
                post.setDateSubmit(rs.getString("dateSubmit"));
                post.setFirstName(rs.getString("firstName"));
                post.setLastName(rs.getString("lastName"));
                post.setMimg(rs.getString("mimg"));
                post.setStitle(rs.getString("stitle"));
                post.setSimg(rs.getString("simg"));
                post.setSdescribes(rs.getString("sdescribes"));
                post.setStartDate(rs.getString("startDate"));
                post.setEndDate(rs.getString("endDate"));
                post.setStatu(rs.getInt("statu"));
                return post;
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        }
        return null;
    }

    @Override
    public BlogDetails ViewBlogbySliderId(int sliderId) {
        Connection con = null;
        String query = "SELECT b.*, m.FirstName, m.LastName, m.Img as imgMarketing FROM blog as b\n"
                + "join slider as s on b.SliderId = s.SliderId\n"
                + "join marketing as m on b.MarketingId = m.MarketingId\n"
                + "where s.SliderId = ?";
        try {
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, sliderId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BlogDetails blog = new BlogDetails();
                blog.setBlogId(rs.getInt("blogId"));
                blog.setTitle(rs.getString("title"));
                blog.setImg(rs.getString("img"));
                blog.setMarketingId(rs.getInt("marketingId"));
                blog.setDescribes(rs.getString("describes"));
                blog.setProductId(rs.getInt("productId"));
                blog.setDiscount(rs.getInt("discount"));
                blog.setSliderId(rs.getInt("sliderId"));
                blog.setDateSubmit(rs.getString("dateSubmit"));
                blog.setFirstName(rs.getString("firstName"));
                blog.setLastName(rs.getString("lastName"));
                blog.setImgMarketing(rs.getString("imgMarketing"));

                return blog;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Post> ListaAuthorPost(int mId) {
        Connection con = null;
        List<Post> list = new ArrayList<Post>();
        String query = "SELECT b.*, m.firstName, m.lastName, m.img AS mimg, s.title AS stitle, s.img AS simg, s.describes AS sdescribes, s.startDate, s.endDate,\n"
                + "CASE WHEN s.enddate <= sysdate() THEN '0' ELSE '1' END AS statu\n"
                + "FROM Blog b\n"
                + "JOIN Slider s ON b.sliderId = s.sliderId\n"
                + "JOIN Marketing m ON b.marketingId = m.marketingId\n"
                + "where b.marketingId = ?\n"
                + "ORDER BY b.DateSubmit DESC";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, mId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setBlogId(rs.getInt("blogId"));
                post.setTitle(rs.getString("title"));
                post.setImg(rs.getString("img"));
                post.setMarketingId(rs.getInt("marketingId"));
                post.setDescribes(rs.getString("describes"));
                post.setProductId(rs.getInt("productId"));
                post.setDiscount(rs.getInt("discount"));
                post.setSliderId(rs.getInt("sliderId"));
                post.setDateSubmit(rs.getString("dateSubmit"));
                post.setFirstName(rs.getString("firstName"));
                post.setLastName(rs.getString("lastName"));
                post.setMimg(rs.getString("mimg"));
                post.setStitle(rs.getString("stitle"));
                post.setSimg(rs.getString("simg"));
                post.setSdescribes(rs.getString("sdescribes"));
                post.setStartDate(rs.getString("startDate"));
                post.setEndDate(rs.getString("endDate"));
                post.setStatu(rs.getInt("statu"));
                list.add(post);
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        }
        return list;
    }

    @Override
    public List<Post> ListSliderPost(int sId) {
        Connection con = null;
        List<Post> list = new ArrayList<Post>();
        String query = "SELECT b.*, m.firstName, m.lastName, m.img AS mimg, s.title AS stitle, s.img AS simg, s.describes AS sdescribes, s.startDate, s.endDate,\n"
                + "CASE WHEN s.enddate <= sysdate() THEN '0' ELSE '1' END AS statu\n"
                + "FROM Blog b\n"
                + "JOIN Slider s ON b.sliderId = s.sliderId\n"
                + "JOIN Marketing m ON b.marketingId = m.marketingId\n"
                + "where s.sliderId = ?\n"
                + "ORDER BY b.DateSubmit DESC";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, sId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setBlogId(rs.getInt("blogId"));
                post.setTitle(rs.getString("title"));
                post.setImg(rs.getString("img"));
                post.setMarketingId(rs.getInt("marketingId"));
                post.setDescribes(rs.getString("describes"));
                post.setProductId(rs.getInt("productId"));
                post.setDiscount(rs.getInt("discount"));
                post.setSliderId(rs.getInt("sliderId"));
                post.setDateSubmit(rs.getString("dateSubmit"));
                post.setFirstName(rs.getString("firstName"));
                post.setLastName(rs.getString("lastName"));
                post.setMimg(rs.getString("mimg"));
                post.setStitle(rs.getString("stitle"));
                post.setSimg(rs.getString("simg"));
                post.setSdescribes(rs.getString("sdescribes"));
                post.setStartDate(rs.getString("startDate"));
                post.setEndDate(rs.getString("endDate"));
                post.setStatu(rs.getInt("statu"));
                list.add(post);
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        }
        return list;
    }

    @Override
    public List<Post> ListSstatus(String status) {
        Connection con = null;
        List<Post> list = new ArrayList<Post>();
        String query = "SELECT b.*, m.firstName, m.lastName, m.img AS mimg, s.title AS stitle, s.img AS simg, s.describes AS sdescribes, s.startDate, s.endDate,\n"
                + "CASE WHEN s.enddate <= sysdate() THEN '0' ELSE '1' END AS statu\n"
                + "FROM Blog b\n"
                + "JOIN Slider s ON b.sliderId = s.sliderId\n"
                + "JOIN Marketing m ON b.marketingId = m.marketingId\n"
                + "WHERE CASE WHEN s.enddate <= sysdate() THEN '0' ELSE '1' END IN (?)\n"
                + "ORDER BY b.DateSubmit DESC";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, status);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setBlogId(rs.getInt("blogId"));
                post.setTitle(rs.getString("title"));
                post.setImg(rs.getString("img"));
                post.setMarketingId(rs.getInt("marketingId"));
                post.setDescribes(rs.getString("describes"));
                post.setProductId(rs.getInt("productId"));
                post.setDiscount(rs.getInt("discount"));
                post.setSliderId(rs.getInt("sliderId"));
                post.setDateSubmit(rs.getString("dateSubmit"));
                post.setFirstName(rs.getString("firstName"));
                post.setLastName(rs.getString("lastName"));
                post.setMimg(rs.getString("mimg"));
                post.setStitle(rs.getString("stitle"));
                post.setSimg(rs.getString("simg"));
                post.setSdescribes(rs.getString("sdescribes"));
                post.setStartDate(rs.getString("startDate"));
                post.setEndDate(rs.getString("endDate"));
                post.setStatu(rs.getInt("statu"));
                list.add(post);
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        }
        return list;
    }

    @Override
    public List<Post> SearchPostTitle(String Title) {
        Connection con = null;
        List<Post> list = new ArrayList<Post>();
        String query = "SELECT b.*, m.firstName, m.lastName, m.img AS mimg, s.title AS stitle, s.img AS simg, s.describes AS sdescribes, s.startDate, s.endDate,\n"
                + "CASE WHEN s.enddate <= sysdate() THEN '0' ELSE '1' END AS statu\n"
                + "FROM Blog b\n"
                + "JOIN Slider s ON b.sliderId = s.sliderId\n"
                + "JOIN Marketing m ON b.marketingId = m.marketingId\n"
                + "where b.title like ?\n"
                + "ORDER BY b.DateSubmit DESC;";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, "%" + Title + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
                post.setBlogId(rs.getInt("blogId"));
                post.setTitle(rs.getString("title"));
                post.setImg(rs.getString("img"));
                post.setMarketingId(rs.getInt("marketingId"));
                post.setDescribes(rs.getString("describes"));
                post.setProductId(rs.getInt("productId"));
                post.setDiscount(rs.getInt("discount"));
                post.setSliderId(rs.getInt("sliderId"));
                post.setDateSubmit(rs.getString("dateSubmit"));
                post.setFirstName(rs.getString("firstName"));
                post.setLastName(rs.getString("lastName"));
                post.setMimg(rs.getString("mimg"));
                post.setStitle(rs.getString("stitle"));
                post.setSimg(rs.getString("simg"));
                post.setSdescribes(rs.getString("sdescribes"));
                post.setStartDate(rs.getString("startDate"));
                post.setEndDate(rs.getString("endDate"));
                post.setStatu(rs.getInt("statu"));
                list.add(post);
            }
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(BlogDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        }
        return list;
    }
    @Override
    public void AddPost(Blog blog) {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "INSERT INTO blog (Title, Img, MarketingId, Describes, ProductId, Discount, SliderId, DateSubmit) VALUES (?, ?, ?, ?, ?, ?, ?, sysdate());";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setString(1, blog.getTitle());
            ps.setString(2, blog.getImg());
            ps.setInt(3, blog.getMarketingId());
            ps.setString(4, blog.getDescribes());
            ps.setInt(5, blog.getProductId());
            ps.setInt(6, blog.getDiscount());
            ps.setInt(7, blog.getSliderId());
            ps.executeUpdate();
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        }
    }
    @Override
    public void UpdatePost(String Title, String Img, String Describes, int ProductId, int Discount, int SliderId, int blogId) {
        Connection con = null;
        String query = "update blog set Title = ?, Img = ?, Describes = ?, ProductId = ?, Discount = ?, SliderId = ? where blogId = ?";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, Title);
            ps.setString(2, Img);
            ps.setString(3, Describes);
            ps.setInt(4, ProductId);
            ps.setInt(5, Discount);
            ps.setInt(6, SliderId);
            ps.setInt(7, blogId);
            ps.executeUpdate();
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(MarketingDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            // Close the database connection, even if an exception occurred
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MarketingDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static void main(String[] args) {
        BlogDao b = new BlogDao();
        List<Post> p = b.ListSliderPost(1);
        for (Post post : p) {
            System.out.println(post);
        }
    }
}
