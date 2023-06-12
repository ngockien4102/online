/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Context.ContextDB;
import Dao.IDao.IOrderDao;
import Model.CartContact;
import Model.DashBoardMKT;
import Model.Orders;
import Model.OrderSale;
import java.sql.Connection;
import java.sql.Date;
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
public class OrderDao extends ContextDB implements IOrderDao {

    @Override
    public void insertCart(int PersonId, int ProductId, int Quantity) {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "INSERT INTO orders (PersonId, ProductId, OrderDate, Quantity, Status) VALUES (?, ?, SYSDATE(), ?, 0);";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, PersonId);
            ps.setInt(2, ProductId);
            ps.setInt(3, Quantity);
            ps.executeUpdate();
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        }
    }

    @Override
    public void UpdateCart(String OrderId, String Quantity) {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "update orders set Quantity = ? where OrderId = ?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setString(1, Quantity);
            ps.setString(2, OrderId);
            ps.executeUpdate();
        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        }
    }

    @Override
    public Orders checkOrder(int ProductId, int PersonId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select o.* from orders o\n"
                + "where  o.status = 0\n"
                + "and o.ProductId = ?\n"
                + "and o.PersonId = ?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, ProductId);
            ps.setInt(2, PersonId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Orders orders = new Orders();
                orders.setOrderId(rs.getInt("orderId"));
                orders.setPersonId(rs.getInt("personId"));
                orders.setProductId(rs.getInt("productId"));
                orders.setOrderDate(rs.getString("orderDate"));
                orders.setQuantity(rs.getInt("quantity"));
                orders.setStatus(rs.getInt("status"));
                return orders;
            }

        } catch (SQLException e) {
            // Handle any exceptions that occur
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, e);
        } finally {
        }
        return null;
    }

    @Override
    public List<CartContact> ListCart(int personId, int status) {
        List<CartContact> list = new ArrayList<CartContact>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT o.*, p.img1, p.NameProduct, p.price, \n"
                + "    b.Discount, \n"
                + "    p.price * o.quantity AS total, p.Quantity AS pquantity,\n"
                + "    CASE \n"
                + "        WHEN s.StartDate IS NULL or s.enddate >= o.OrderDate THEN '1'\n"
                + "        ELSE '0'\n"
                + "    END AS IsOnDiscount\n"
                + "FROM orders o\n"
                + "INNER JOIN products p ON o.ProductId = p.ProductId\n"
                + "LEFT JOIN blog b ON p.ProductId = b.ProductId\n"
                + "LEFT JOIN slider s ON b.SliderId = s.SliderId\n"
                + "where o.status = ? and o.PersonId = ?;";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, status);
            ps.setInt(2, personId);
            rs = ps.executeQuery();
            while (rs.next()) {
                CartContact cart = new CartContact();
                cart.setOrderId(rs.getInt("orderId"));
                cart.setPersonId(rs.getInt("personId"));
                cart.setProductId(rs.getInt("productId"));
                cart.setOrderDate(rs.getString("orderDate"));
                cart.setQuantity(rs.getInt("quantity"));
                cart.setStatus(rs.getInt("status"));
                cart.setImg1(rs.getString("img1"));
                cart.setNameProduct(rs.getString("nameProduct"));
                cart.setTotal(rs.getFloat("total"));
                cart.setPrice(rs.getFloat("price"));
                cart.setDiscount(rs.getFloat("discount"));
                cart.setPquantity(rs.getInt("pquantity"));
                cart.setIsOnDiscount(rs.getInt("isOnDiscount"));
                list.add(cart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }

    @Override
    public CartContact CartContacts(int orderId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT o.*, p.img1, p.NameProduct, p.price, \n"
                + "    b.Discount, \n"
                + "    p.price * o.quantity AS total, p.Quantity AS pquantity,\n"
                + "    CASE \n"
                + "        WHEN s.StartDate IS NULL or s.enddate >= o.OrderDate THEN '1'\n"
                + "        ELSE '0'\n"
                + "    END AS IsOnDiscount\n"
                + "FROM orders o\n"
                + "INNER JOIN products p ON o.ProductId = p.ProductId\n"
                + "LEFT JOIN blog b ON p.ProductId = b.ProductId\n"
                + "LEFT JOIN slider s ON b.SliderId = s.SliderId\n"
                + "where o.status = 0 and o.orderId = ?;";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();
            while (rs.next()) {
                CartContact cart = new CartContact();
                cart.setOrderId(rs.getInt("orderId"));
                cart.setPersonId(rs.getInt("personId"));
                cart.setProductId(rs.getInt("productId"));
                cart.setOrderDate(rs.getString("orderDate"));
                cart.setQuantity(rs.getInt("quantity"));
                cart.setStatus(rs.getInt("status"));
                cart.setImg1(rs.getString("img1"));
                cart.setNameProduct(rs.getString("nameProduct"));
                cart.setTotal(rs.getFloat("total"));
                cart.setPrice(rs.getFloat("price"));
                cart.setDiscount(rs.getFloat("discount"));
                cart.setPquantity(rs.getInt("pquantity"));
                cart.setIsOnDiscount(rs.getInt("isOnDiscount"));
                return cart;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public void payCart(String orderId, int status) {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "update orders set status = ?, orderDate = sysdate() where orderId = ?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, status);
            ps.setString(2, orderId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(String orderId) {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "delete from orders where orderId=?";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setString(1, orderId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    @Override
    public CartContact OrderContacts(int orderId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT o.*, p.img1, p.NameProduct, p.price, \n"
                + "    b.Discount, \n"
                + "    p.price * o.quantity AS total, p.Quantity AS pquantity,\n"
                + "    CASE \n"
                + "        WHEN s.StartDate IS NULL or s.enddate >= o.OrderDate THEN '1'\n"
                + "        ELSE '0'\n"
                + "    END AS IsOnDiscount\n"
                + "FROM orders o\n"
                + "INNER JOIN products p ON o.ProductId = p.ProductId\n"
                + "LEFT JOIN blog b ON p.ProductId = b.ProductId\n"
                + "LEFT JOIN slider s ON b.SliderId = s.SliderId\n"
                + "where o.status != 0 and o.orderId = ?;";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();
            while (rs.next()) {
                CartContact cart = new CartContact();
                cart.setOrderId(rs.getInt("orderId"));
                cart.setPersonId(rs.getInt("personId"));
                cart.setProductId(rs.getInt("productId"));
                cart.setOrderDate(rs.getString("orderDate"));
                cart.setQuantity(rs.getInt("quantity"));
                cart.setStatus(rs.getInt("status"));
                cart.setImg1(rs.getString("img1"));
                cart.setNameProduct(rs.getString("nameProduct"));
                cart.setTotal(rs.getFloat("total"));
                cart.setPrice(rs.getFloat("price"));
                cart.setDiscount(rs.getFloat("discount"));
                cart.setPquantity(rs.getInt("pquantity"));
                cart.setIsOnDiscount(rs.getInt("isOnDiscount"));
                return cart;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    @Override
    public List<DashBoardMKT> dashboardTrendMKT(String date) {
        List<DashBoardMKT> list = new ArrayList<DashBoardMKT>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "SELECT o.ProductId, p.NameProduct, COUNT(*) AS count, o.OrderDate\n"
                + "FROM orders o\n"
                + "JOIN products p ON o.ProductId = p.ProductId\n"
                + "WHERE o.OrderDate BETWEEN DATE_SUB(?, INTERVAL 1 WEEK) AND ?\n"
                + "GROUP BY o.ProductId\n"
                + "order by o.OrderDate\n"
                + "desc \n"
                + "limit 3;";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setString(1, date);
            ps.setString(2, date);
            rs = ps.executeQuery();
            while (rs.next()) {
                DashBoardMKT boardMKT = new DashBoardMKT();
                boardMKT.setProductId(rs.getInt("productId"));
                boardMKT.setNameProduct(rs.getString("nameProduct"));
                boardMKT.setCount(rs.getInt("count"));
                boardMKT.setOrderDate(rs.getString("orderDate"));
                list.add(boardMKT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public DashBoardMKT dashboardCustomMKT(String date) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select count(*) count\n"
                + "from person p, account a\n"
                + "where a.Role = 3 and a.AccountId = p.AccountId and p.StartDate BETWEEN DATE_SUB(?, INTERVAL 1 WEEK) AND ?;";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setString(1, date);
            ps.setString(2, date);
            rs = ps.executeQuery();
            while (rs.next()) {
                DashBoardMKT boardMKT = new DashBoardMKT();
                boardMKT.setCount(rs.getInt("count"));
                return boardMKT;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public DashBoardMKT dashboardPostMKT(String date) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select count(*) count\n"
                + "from blog b\n"
                + "where b.DateSubmit BETWEEN DATE_SUB(?, INTERVAL 1 WEEK) AND ?;";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setString(1, date);
            ps.setString(2, date);
            rs = ps.executeQuery();
            while (rs.next()) {
                DashBoardMKT boardMKT = new DashBoardMKT();
                boardMKT.setCount(rs.getInt("count"));
                return boardMKT;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public DashBoardMKT dashboardProductMKT(String date) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select count(*) count\n"
                + "from products p\n"
                + "where p.createDate BETWEEN DATE_SUB(?, INTERVAL 1 WEEK) AND ?;";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setString(1, date);
            ps.setString(2, date);
            rs = ps.executeQuery();
            while (rs.next()) {
                DashBoardMKT boardMKT = new DashBoardMKT();
                boardMKT.setCount(rs.getInt("count"));
                return boardMKT;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public DashBoardMKT dashboardFeedBackMKT(String date) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select count(*) count\n"
                + "from feedback f\n"
                + "where f.dateFeedBack BETWEEN DATE_SUB(?, INTERVAL 1 WEEK) AND ?;";
        try {
            con = connection;
            ps = con.prepareStatement(query);
            ps.setString(1, date);
            ps.setString(2, date);
            rs = ps.executeQuery();
            while (rs.next()) {
                DashBoardMKT boardMKT = new DashBoardMKT();
                boardMKT.setCount(rs.getInt("count"));
                return boardMKT;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<OrderSale> StatisticsRevenuesTrends(int saleId, Date startDate, Date endDate, int Orderstatus) {
        Connection con = null;
        List<OrderSale> list = new ArrayList<OrderSale>();
        String query = "with x as(SELECT o.OrderId, p.Img1, p.NameProduct, o.OrderDate, p.PersonId as saleId, "
                + "o.Status, o.Quantity,pe.PersonId as customerId,pe.FirstName, pe.LastName,\n"
                + "SUM(CASE WHEN (s.StartDate <= NOW()) AND (s.EndDate >= NOW()) THEN (p.Price * ((100 - b.Discount)/100))*o.Quantity ELSE p.Price*o.Quantity END) as total_cost\n"
                + "FROM addresscustomer as a\n"
                + "left join orders as o on a.OrderId = o.OrderId\n"
                + "left join person as pe on a.PersonId = pe.PersonId\n"
                + "join products as p on o.ProductId = p.ProductId\n"
                + "LEFT JOIN blog AS b ON p.ProductId = b.ProductId\n"
                + "LEFT JOIN slider AS s ON b.SliderId = s.SliderId\n"
                + "where p.PersonId = ?\n"
                + "group by p.NameProduct, o.OrderDate, p.PersonId, o.Status, o.Quantity, p.Img1, pe.FirstName,"
                + "o.OrderId, pe.LastName, pe.PersonId\n"
                + "order by total_cost desc\n"
                + ")\n"
                + "select * from x\n"
                + "where 1=1";
        if (startDate != null) {
            query += " and OrderDate >= '" + startDate + "'";
        }
        if (endDate != null) {
            query += " and OrderDate <= '" + endDate + "'";
        }
        if (startDate == null && endDate == null) {
            query += " and OrderDate BETWEEN DATE_SUB(NOW(), INTERVAL 7 DAY) AND NOW()";
        }
        query += Orderstatus != 0 ? " and Status = " + Orderstatus + " limit 5" : " and Status = 4 limit 5";

        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, saleId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderSale orderSale = new OrderSale();

                orderSale.setOrderId(rs.getInt("orderId"));
                orderSale.setImg1(rs.getString("img1"));
                orderSale.setNameProduct(rs.getString("nameProduct"));
                orderSale.setOrderDate(rs.getString("orderDate"));
                orderSale.setSaleId(rs.getInt("saleId"));
                orderSale.setStatus(rs.getInt("status"));
                orderSale.setQuantity(rs.getInt("quantity"));
                orderSale.setCustomerId(rs.getInt("customerId"));
                orderSale.setFirstName(rs.getString("firstName"));
                orderSale.setLastName(rs.getString("lastName"));
                orderSale.setTotal_cost(rs.getFloat("total_cost"));

                list.add(orderSale);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<OrderSale> SearchOrderListPaging(int saleId, int orderId, String name, String sort, int index,
            Date startDate, Date endDate, int Orderstatus) {
        Connection con = null;
        List<OrderSale> list = new ArrayList<OrderSale>();
        String query = "with x as(SELECT o.OrderId, p.Img1, p.NameProduct, o.OrderDate, p.PersonId as saleId, "
                + "o.Status, o.Quantity,pe.PersonId as customerId,pe.FirstName, pe.LastName,\n"
                + "SUM(CASE WHEN (s.StartDate <= NOW()) AND (s.EndDate >= NOW()) THEN (p.Price * ((100 - b.Discount)/100))*o.Quantity ELSE p.Price*o.Quantity END) as total_cost\n"
                + "FROM addresscustomer as a\n"
                + "left join orders as o on a.OrderId = o.OrderId\n"
                + "left join person as pe on a.PersonId = pe.PersonId\n"
                + "join products as p on o.ProductId = p.ProductId\n"
                + "LEFT JOIN blog AS b ON p.ProductId = b.ProductId\n"
                + "LEFT JOIN slider AS s ON b.SliderId = s.SliderId\n"
                + "where p.PersonId = ?\n"
                + "group by p.NameProduct, o.OrderDate, p.PersonId, o.Status, o.Quantity, p.Img1, pe.FirstName,"
                + "o.OrderId, pe.LastName, pe.PersonId\n"
                + ")\n"
                + "select * from x\n"
                + "where 1=1";
        if (startDate != null) {
            query += " and OrderDate >= '" + startDate + "'";
        }
        if (endDate != null) {
            query += " and OrderDate <= '" + endDate + "'";
        }
        if (Orderstatus != 0) {
            query += " and Status = " + Orderstatus;
        }
        if (orderId != 0) {
            query += " and OrderId = " + orderId;
        }
        if (name != null && !name.equals("")) {
            query += " and FirstName like '%" + name + "%' or LastName like '%" + name + "%'";
        }
        if (sort != null && sort.equals("orderD_asc")) {
            query += " order by OrderDate asc";
        }
        if (sort != null && sort.equals("orderD_desc")) {
            query += " order by OrderDate desc";
        }
        if (sort != null && sort.equals("status_asc")) {
            query += " order by Status asc";
        }
        if (sort != null && sort.equals("status_desc")) {
            query += " order by Status desc";
        }
        query += " LIMIT 5 OFFSET " + ((index - 1) * 5);
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, saleId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderSale orderSale = new OrderSale();

                orderSale.setOrderId(rs.getInt("orderId"));
                orderSale.setImg1(rs.getString("img1"));
                orderSale.setNameProduct(rs.getString("nameProduct"));
                orderSale.setOrderDate(rs.getString("orderDate"));
                orderSale.setSaleId(rs.getInt("saleId"));
                orderSale.setStatus(rs.getInt("status"));
                orderSale.setQuantity(rs.getInt("quantity"));
                orderSale.setCustomerId(rs.getInt("customerId"));
                orderSale.setFirstName(rs.getString("firstName"));
                orderSale.setLastName(rs.getString("lastName"));
                orderSale.setTotal_cost(rs.getFloat("total_cost"));

                list.add(orderSale);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public int getNumberEndPageOrderList() {
        Connection con = null;
        String query = "with x as(SELECT o.OrderId, p.Img1, p.NameProduct, o.OrderDate, p.PersonId as saleId,\n"
                + "o.Status, o.Quantity,pe.PersonId as customerId,pe.FirstName, pe.LastName,\n"
                + "SUM(CASE WHEN (s.StartDate <= NOW()) AND (s.EndDate >= NOW()) THEN (p.Price * ((100 - b.Discount)/100))*o.Quantity ELSE p.Price*o.Quantity END) as total_cost\n"
                + "FROM addresscustomer as a\n"
                + "left join orders as o on a.OrderId = o.OrderId\n"
                + "left join person as pe on a.PersonId = pe.PersonId\n"
                + "join products as p on o.ProductId = p.ProductId\n"
                + "LEFT JOIN blog AS b ON p.ProductId = b.ProductId\n"
                + "LEFT JOIN slider AS s ON b.SliderId = s.SliderId\n"
                + "where p.PersonId = 2\n"
                + "group by p.NameProduct, o.OrderDate, p.PersonId, o.Status, o.Quantity, p.Img1, pe.FirstName,\n"
                + "o.OrderId, pe.LastName, pe.PersonId)\n"
                + "select COUNT(*) from x";
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
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return 0;
    }

    @Override
    public OrderSale GetOrderDetailbyOrderId(int oid) {
        Connection con = null;
        String query = "with x as(SELECT o.OrderId, p.Img1, p.NameProduct, o.OrderDate, p.PersonId as saleId, o.Status, o.Quantity,\n"
                + " pe.PersonId as customerId,pe.FirstName, pe.LastName,\n"
                + "SUM(CASE WHEN (s.StartDate <= NOW()) AND (s.EndDate >= NOW()) THEN (p.Price * ((100 - b.Discount)/100))*o.Quantity ELSE p.Price*o.Quantity END) as total_cost,\n"
                + "c.NameCategory, p.Price, pe.Gender, a.Address, pe.Phone, acc.Email, o.notes\n"
                + "FROM addresscustomer as a\n"
                + "left join orders as o on a.OrderId = o.OrderId\n"
                + "left join person as pe on a.PersonId = pe.PersonId\n"
                + "join account as acc on pe.AccountId = acc.AccountId\n"
                + "join products as p on o.ProductId = p.ProductId\n"
                + "join category as c on p.CategoryId = c.CategoryId\n"
                + "LEFT JOIN blog AS b ON p.ProductId = b.ProductId\n"
                + "LEFT JOIN slider AS s ON b.SliderId = s.SliderId\n"
                + "group by p.NameProduct, o.OrderDate, p.PersonId, o.Status, o.Quantity, p.Img1, pe.FirstName, o.OrderId, \n"
                + "pe.LastName, pe.PersonId, c.NameCategory, p.Price, pe.Gender, a.Address, pe.Phone, acc.Email, o.notes)\n"
                + "select * from x\n"
                + "where OrderId = ?";
        try {
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, oid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderSale orderSale = new OrderSale();

                orderSale.setOrderId(rs.getInt("orderId"));
                orderSale.setImg1(rs.getString("img1"));
                orderSale.setNameProduct(rs.getString("nameProduct"));
                orderSale.setOrderDate(rs.getString("orderDate"));
                orderSale.setSaleId(rs.getInt("saleId"));
                orderSale.setStatus(rs.getInt("status"));
                orderSale.setQuantity(rs.getInt("quantity"));
                orderSale.setCustomerId(rs.getInt("customerId"));
                orderSale.setFirstName(rs.getString("firstName"));
                orderSale.setLastName(rs.getString("lastName"));
                orderSale.setTotal_cost(rs.getFloat("total_cost"));
                orderSale.setNameCategory(rs.getString("nameCategory"));
                orderSale.setPrice(rs.getFloat("price"));
                orderSale.setGender(rs.getInt("gender"));
                orderSale.setAddress(rs.getString("address"));
                orderSale.setPhone(rs.getString("phone"));
                orderSale.setEmail(rs.getString("email"));
                orderSale.setNotes(rs.getString("notes"));

                return orderSale;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void UpdateOrderSale(OrderSale orderSale) {
        Connection con = null;
        String query = "UPDATE `onlineshop`.`orders` SET `Status` = ?, `notes` = ? WHERE (`OrderId` = ?)";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, orderSale.getStatus());
            ps.setString(2, orderSale.getNotes());
            ps.setInt(3, orderSale.getOrderId());

            ps.executeUpdate();
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<OrderSale> StatisticsAmountOrder(Date startDate, Date endDate) {
        Connection con = null;
        List<OrderSale> list = new ArrayList<OrderSale>();
        String query = "SELECT\n"
                + "case\n"
                + "	when status = 2 then \"CANCEL\"\n"
                + "    when status = 3 then \"PROGRESS\"\n"
                + "    ELSE \"Done\"\n"
                + "End as status_Order,\n"
                + "COUNT(*) AS count\n"
                + "FROM orders\n"
                + "WHERE  Status IN (2, 3, 4) and 1=1";
        if (startDate != null) {
            query += " and OrderDate >= '" + startDate + "'";
        }
        if (endDate != null) {
            query += " and OrderDate <= '" + endDate + "'";
        }
        if (startDate == null && endDate == null) {
            query += " and OrderDate BETWEEN DATE_SUB(NOW(), INTERVAL 7 DAY) AND NOW()";
        }
        query += " GROUP BY status";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderSale orderSale = new OrderSale();

                orderSale.setStatus_Order(rs.getString("status_Order"));
                orderSale.setCount(rs.getInt("count"));

                list.add(orderSale);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<OrderSale> StatisticsRevenuesCategory(Date startDate, Date endDate) {
        Connection con = null;
        List<OrderSale> list = new ArrayList<OrderSale>();
        String query = "SELECT c.NameCategory,\n"
                + "SUM(CASE WHEN (s.StartDate <= NOW()) AND (s.EndDate >= NOW()) THEN (p.Price * ((100 - b.Discount)/100))*o.Quantity ELSE p.Price*o.Quantity END) as total_cost\n"
                + "FROM addresscustomer as a\n"
                + "left join orders as o on a.OrderId = o.OrderId\n"
                + "join products as p on o.ProductId = p.ProductId\n"
                + "join category as c on p.CategoryId = c.CategoryId\n"
                + "LEFT JOIN blog AS b ON p.ProductId = b.ProductId\n"
                + "LEFT JOIN slider AS s ON b.SliderId = s.SliderId\n"
                + "where 1=1";
        if (startDate != null) {
            query += " and OrderDate >= '" + startDate + "'";
        }
        if (endDate != null) {
            query += " and OrderDate <= '" + endDate + "'";
        }
        if (startDate == null && endDate == null) {
            query += " and OrderDate BETWEEN DATE_SUB(NOW(), INTERVAL 7 DAY) AND NOW()";
        }
        query += "group by c.NameCategory";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderSale orderSale = new OrderSale();

                orderSale.setNameCategory(rs.getString("NameCategory"));
                orderSale.setTotal_cost(rs.getFloat("total_cost"));

                list.add(orderSale);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public int StatisticsUserRegistered(Date startDate, Date endDate) {
        Connection con = null;
        String query = "select count(*) from person\n"
                + "where 1=1";
        if (startDate != null) {
            query += " and StartDate >= '" + startDate + "'";
        }
        if (endDate != null) {
            query += " and StartDate <= '" + endDate + "'";
        }
        if (startDate == null && endDate == null) {
            query += " and StartDate BETWEEN DATE_SUB(NOW(), INTERVAL 7 DAY) AND NOW()";
        }
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public int StatisticsNewBought(Date startDate, Date endDate) {
        Connection con = null;
        String query = "SELECT \n"
                + "  COUNT(DISTINCT(pe.PersonId)) AS new_customers_bought\n"
                + "FROM person as pe\n"
                + "join orders as o on pe.PersonId = o.PersonId\n"
                + "where 1=1";
        if (startDate != null) {
            query += " and o.OrderDate >= '" + startDate + "'";
        }
        if (endDate != null) {
            query += " and o.OrderDate <= '" + endDate + "'";
        }
        if (startDate == null && endDate == null) {
            query += " and o.OrderDate BETWEEN DATE_SUB(NOW(), INTERVAL 7 DAY) AND NOW()";
        }
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public List<OrderSale> StatisticsAveStar(Date startDate, Date endDate) {
        Connection con = null;
        List<OrderSale> list = new ArrayList<OrderSale>();
        String query = "SELECT c.NameCategory, ROUND(AVG(f.RankStar), 1) AS AverageRankStar\n"
                + "FROM feedback f\n"
                + "INNER JOIN products p ON f.productId = p.productId\n"
                + "INNER JOIN category c ON c.CategoryId = p.CategoryId\n"
                + "where 1=1";
        if (startDate != null) {
            query += " and f.dateFeedBack >= '" + startDate + "'";
        }
        if (endDate != null) {
            query += " and f.dateFeedBack <= '" + endDate + "'";
        }
        if (startDate == null && endDate == null) {
            query += " and f.dateFeedBack BETWEEN DATE_SUB(NOW(), INTERVAL 7 DAY) AND NOW()";
        }
        query += "GROUP BY c.NameCategory";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderSale orderSale = new OrderSale();

                orderSale.setNameCategory(rs.getString("NameCategory"));
                orderSale.setAverageRankStar(rs.getFloat("AverageRankStar"));

                list.add(orderSale);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<OrderSale> StatisticsTopOrder(Date startDate, Date endDate) {
        Connection con = null;
        List<OrderSale> list = new ArrayList<OrderSale>();
        String query = "SELECT p.NameProduct, SUM(o.Quantity) AS count\n"
                + "FROM orders o\n"
                + "JOIN products p ON o.ProductId = p.ProductId\n"
                + "where o.Status = 4 and 1=1";
        if (startDate != null) {
            query += " and o.OrderDate >= '" + startDate + "'";
        }
        if (endDate != null) {
            query += " and o.OrderDate <= '" + endDate + "'";
        }
        if (startDate == null && endDate == null) {
            query += " and o.OrderDate BETWEEN DATE_SUB(NOW(), INTERVAL 7 DAY) AND NOW()";
        }
        query += "GROUP BY p.NameProduct order by count desc";
        try {
            // Open the database connection
            con = connection;
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderSale orderSale = new OrderSale();

                orderSale.setNameProduct(rs.getString("nameProduct"));
                orderSale.setCount(rs.getInt("count"));

                list.add(orderSale);
            }
        } catch (SQLException ex) {
            // Handle any exceptions that occur
            Logger.getLogger(OrderDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
