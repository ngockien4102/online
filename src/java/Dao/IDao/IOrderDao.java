/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao.IDao;

import Model.CartContact;
import Model.DashBoardMKT;
import Model.Orders;
import Model.OrderSale;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author MSII
 */
public interface IOrderDao {

    // Add new product to cart
    public void insertCart(int pID, int accountID, int quality);

    // update quantity in cart
    public void UpdateCart(String OrderId, String Quantity);

    // Check if the product is already in the cart or not with the status of unpaid
    public Orders checkOrder(int ProductId, int PersonId);

    //List all products added to cart
    public List<CartContact> ListCart(int personId, int status);

    //cart checkout
    public void payCart(String orderId, int status);

    // delete product in cart
    public void deleteOrder(String orderId);

    // cart detail
    public CartContact CartContacts(int orderId);

    // myorder detail
    public CartContact OrderContacts(int orderId);

    // the trend of new customers by day for the last 7 days 
    public List<DashBoardMKT> dashboardTrendMKT(String date);

    // count custom regist in 7 date
    public DashBoardMKT dashboardCustomMKT(String date);

    //count post in 7 date
    public DashBoardMKT dashboardPostMKT(String date);

    //count product in 7 date
    public DashBoardMKT dashboardProductMKT(String date);

    //count feedback in 7 date
    public DashBoardMKT dashboardFeedBackMKT(String date);

    // Show the trend of success/total orders, and the revenues trends top 5
    public List<OrderSale> StatisticsRevenuesTrends(int saleId, Date startDate, Date endDate, int Orderstatus);

    // Search orderList follow orderId, nameCustomer and Paging
    public List<OrderSale> SearchOrderListPaging(int saleId, int orderId, String name, String sort, int index,
            Date startDate, Date endDate, int Orderstatus);

    //Get end page
    public int getNumberEndPageOrderList();

    // get Order Sale by Order id
    public OrderSale GetOrderDetailbyOrderId(int oid);

    //Update Order follow order status & the sale notes
    public void UpdateOrderSale(OrderSale orderSale);

    // -- Statistics of new orders
    public List<OrderSale> StatisticsAmountOrder(Date startDate, Date endDate);

    //Revenues by product categories
    public List<OrderSale> StatisticsRevenuesCategory(Date startDate, Date endDate);

    // Customers newly registered
    public int StatisticsUserRegistered(Date startDate, Date endDate);
    // Customers newly bought
    public int StatisticsNewBought(Date startDate, Date endDate);
    
    //feedbacks (average star: total, by product categories
    public List<OrderSale> StatisticsAveStar(Date startDate, Date endDate);
    //Top most ordered products
    public List<OrderSale> StatisticsTopOrder(Date startDate, Date endDate);
}
