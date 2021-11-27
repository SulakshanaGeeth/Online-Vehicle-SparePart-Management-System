package com.oop.inventory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.oop.util.DBConnect;

public class Senddata {
	
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet re = null;
	
	
	public ArrayList<Product> getProducts(String catag) {
    	
    	    	
    	ArrayList<Product> prod = new ArrayList<>();
    	
	    	try {
	    		
	    		con = DBConnect.getConnection();
	    		st = con.createStatement();
	    		String sql = "select * from product where Prod_cat='"+catag+"'";
	    		re = st.executeQuery(sql);
	    		
	    		while(re.next()) {
	    			int pid = re.getInt(1);
	    			String pname = re.getString(3);
	    			String details = re.getString(4);
	    			String img = re.getString(5);
	    			int price = re.getInt(6);
	    			
	    			Product product = new Product(pid, catag, pname, details, img, price);
	    			prod.add(product);
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
	    	return prod;	
	    }
	
	
	public ArrayList<Purchase> getCustomerPurchase(int cusID) {
    	
    	
    	ArrayList<Purchase> purc = new ArrayList<>();
    	
	    	try {
	    		
	    		con = DBConnect.getConnection();
	    		st = con.createStatement();
	    		String sql = "SELECT * FROM purchase WHERE Customer_id="+cusID+"";
	    		re = st.executeQuery(sql);
	    		
	    		while(re.next()) {
	    			int cid = re.getInt(2);
	    			String cname = re.getString(3);
	    			String cemail = re.getString(4);
	    			int pid = re.getInt(5);
	    			String pname = re.getString(6);
	    			int unitPrice = re.getInt(7);
	    			int qty = re.getInt(8);
	    			int ptotal = re.getInt(9);
	    			
	    			Purchase purchase = new Purchase(cid, cname, cemail, pid, pname, unitPrice, qty, ptotal);
	    			purc.add(purchase);
	    			
	    		}
	    		
	    	}
	    	catch(Exception e) {
	    		e.printStackTrace();
	    	}	
	    	return purc;	
	    }
	
		
		
		public void addPurchase(Purchase p1) {
			
			try {
				con = DBConnect.getConnection();
				st = con.createStatement();
				int i = st.executeUpdate("INSERT INTO purchase (Customer_id, Customer_name, email, prod_ID, prod_name, unit_price, qty, total) VALUES ("+p1.getCustomer_id()+", '"+p1.getCustomer_name()+"','"+p1.getEmail()+"',"+p1.getProd_id()+",'"+p1.getProd_name()+"',"+p1.getUnitPrice()+","+p1.getQty()+","+p1.getTotal()+")");
				
				if(i>0) {
					System.out.println("Insert success");	
				}
				else {
					System.out.println("Someting went wrong");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error"+e.getMessage());
			}
		}
		
		public void DeletePurchase(int Prod) {
			
			try {
				con = DBConnect.getConnection();
				st = con.createStatement();
				
				int i = st.executeUpdate("DELETE FROM purchase WHERE prod_ID="+Prod+"");
				
				if(i>0) {
					System.out.println("Insert success");	
				}
				else {
					System.out.println("Someting went wrong");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error"+e.getMessage());
			}
		}
		
		public void addOrder(Order o1){
			
			try {
				
				con = DBConnect.getConnection();
				st = con.createStatement();
			
				st.executeUpdate("INSERT INTO cus_order (Cus_ID, Ord_Date, total) VALUES ("+o1.getCus_ID()+",CURDATE(),"+o1.getTotal()+")");
				
				
			} catch (Exception e) {
				System.out.println("Error"+e.getMessage());
			}
		}
		
		
		public ArrayList<Product> getProduct(int Pid) {
	    	
	    	
	    	ArrayList<Product> prodc = new ArrayList<>();
	    	
		    	try {
		    		
		    		con = DBConnect.getConnection();
		    		st = con.createStatement();
		    		String sql = "SELECT * FROM product WHERE Prod_id="+Pid+"";
		    		re = st.executeQuery(sql);
		    		
		    		while(re.next()) {
		    			int pid = re.getInt(1);
		    			String pname = re.getString(3);
		    			String details = re.getString(4);
		    			String img = re.getString(5);
		    			int price = re.getInt(6);
		    			
		    			Product product = new Product(pid, sql, pname, details, img, price); 
		    			prodc.add(product);
		    			
		    		}
		    		
		    	}
		    	catch(Exception e) {
		    		e.printStackTrace();
		    	}	
		    	return prodc;	
		    }
		
		public void UpdateProduct(Purchase p2) {
			
			try {
				con = DBConnect.getConnection();
				st = con.createStatement();
				
				int i = st.executeUpdate("UPDATE purchase SET qty="+p2.getQty()+",total="+p2.getTotal()+" WHERE prod_id="+p2.getProd_id()+"");
				
				if(i>0) {
					System.out.println("Insert success");	
				}
				else {
					System.out.println("Someting went wrong");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error"+e.getMessage());
			}
		}
	}
