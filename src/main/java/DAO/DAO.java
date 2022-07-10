
package DAO;

import helpers.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import model.Account;
import model.Product;


public class DAO {
    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;
    
    public List<Account> getAllAccount() throws SQLException
    {
	List<Account> list = new ArrayList<>();
	String sql = "select * from ACCOUNT";
	
	try {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();               

			
            while (rs.next())
            {
                list.add((Account) new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getBoolean(5)));
            }
            return list;
        } 
	catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void addAccount(String username, String password, String fullname, String role, String status)
    {
	String sql = "INSERT INTO ACCOUNT\n" +
                    "VALUES (?, ?, ?, ?, ?);";
	
	try 
        {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(sql);
	    stm.setString(1, username);
            stm.setString(2, password);
            stm.setString(3, fullname);
            stm.setString(4, role);
            stm.setString(5, status);
            stm.executeUpdate();
        } 
	catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Account getAccount(String username)
    {
	String sql = "select * from account where username = ?";
	try 
        {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(sql);
	    stm.setString(1, username);
            rs = stm.executeQuery();               
            while (rs.next())
            {
                return (Account)new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getBoolean(5));  
            }
        } 
	catch (Exception e) {
            e.printStackTrace();
        }
	return null;
    }
    
    public Product getProduct(String productId)
    {
        System.out.println("Begin getProduct");
	String sql = "select * from PRODUCT where ProductID = ?";
	try 
        {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(sql);
	    stm.setString(1, productId);
            rs = stm.executeQuery();               
            while (rs.next())
            {
                return (Product)new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getDate(7));  
            }
        } 
	catch (Exception e) {
            e.printStackTrace();
        }
	return null;
    }
    
    public void updateAccount(String username, String password, String fullname, String role, String status)
    {
	String sql = "UPDATE ACCOUNT\n" +
                    "SET Password = ?, Fullname = ?, Role = ?, Status = ?\n" +
                    "WHERE Username = ?;";
	
	try 
        {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(sql);
	    stm.setString(1, password);
            stm.setString(2, fullname);
            stm.setString(3, role);
            stm.setString(4, status);
            stm.setString(5, username);
                        
            stm.executeUpdate();

        } 
	catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateProduct(String productId, String productName, String quantity, String price, String image, String userCreate, Date dateCreate)
    {
        if (!image.equals(""))
        {
            String sql = "UPDATE PRODUCT\n" +
                        "SET ProductName = ?, Quantity = ?, Price = ?, Image = ?, UserCreate = ?, DateCreate = ?\n" +
                        "WHERE ProductID = ?;";

            try 
            {
                con = DBUtils.makeConnection();
                stm = con.prepareStatement(sql);
                stm.setString(1, productName);
                stm.setString(2, quantity);
                stm.setString(3, price);
                stm.setString(4, image);
                stm.setString(5, userCreate);
                stm.setDate(6, dateCreate);
                stm.setString(7, productId);

                stm.executeUpdate();

            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            String sql = "UPDATE PRODUCT\n" +
                        "SET ProductName = ?, Quantity = ?, Price = ?, UserCreate = ?, DateCreate = ?\n" +
                        "WHERE ProductID = ?;";

            try 
            {
                con = DBUtils.makeConnection();
                stm = con.prepareStatement(sql);
                stm.setString(1, productName);
                stm.setString(2, quantity);
                stm.setString(3, price);
                stm.setString(4, userCreate);
                stm.setDate(5, dateCreate);
                stm.setString(6, productId);
                

                stm.executeUpdate();
            } 
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public void deleteAccount(String username)
    {
	String sql = "DELETE FROM ACCOUNT WHERE username = ?";
	
	try 
        {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(sql);
	    stm.setString(1, username);                     
            stm.executeUpdate();

        } 
	catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteProduct(String productId)
    {
	String sql = "DELETE FROM PRODUCT WHERE ProductID = ?";
	
	try 
        {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(sql);
	    stm.setString(1, productId);                     
            stm.executeUpdate();

        } 
	catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
    public List<Product> getAllProduct()
    {
	List<Product> list = new ArrayList<>();
	String sql = "select * from PRODUCT";
	
	try {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();               

			
            while (rs.next())
            {
                list.add((Product) new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getDate(7)));
            }
            return list;
        } 
	catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public void addProduct(String productName, String quantity, String price, String image, String userCreate, Date dateCreate)
    {
	String sql = "INSERT INTO PRODUCT\n" +
                    "VALUES (?, ?, ?, ?, ?, ?);";
	
	try 
        {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(sql);
	    stm.setString(1, productName);
            stm.setString(2, quantity);
            stm.setString(3, price);
            stm.setString(4, image);
            stm.setString(5, userCreate);
            stm.setDate(6, dateCreate);
            
            stm.executeUpdate();
        } 
	catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Account login(String username, String password)
    {
        String sql = "select * from ACCOUNT where Username = ? and Password = ?";
	try 
        {
            con = DBUtils.makeConnection();
            stm = con.prepareStatement(sql);
	    stm.setString(1, username);
            stm.setString(2, password);
            rs = stm.executeQuery();               
            while (rs.next())
            {
                return (Account)new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getBoolean(5));  
            }
        } 
	catch (Exception e) {
            e.printStackTrace();
        }
	return null;
    }
}
