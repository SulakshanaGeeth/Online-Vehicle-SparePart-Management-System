package com.oop.inventory;

public class Purchase {

		private int Customer_id;
		private String Customer_name;
		private String email;
		private int prod_id;
		private String prod_name;
		private int unitPrice;
		private int qty;
		private int total;
		
		public Purchase() {
			
		}
		
		
		
		public Purchase(int customer_id, String customer_name, String email, int prod_id, String prod_name,
				int unitPrice, int qty, int total) {

			Customer_id = customer_id;
			Customer_name = customer_name;
			this.email = email;
			this.prod_id = prod_id;
			this.prod_name = prod_name;
			this.unitPrice = unitPrice;
			this.qty = qty;
			this.total = total;
		}




		public int getCustomer_id() {
			return Customer_id;
		}
		public void setCustomer_id(int customer_id) {
			Customer_id = customer_id;
		}
		public String getCustomer_name() {
			return Customer_name;
		}
		public void setCustomer_name(String customer_name) {
			Customer_name = customer_name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getProd_id() {
			return prod_id;
		}
		public void setProd_id(int prod_id) {
			this.prod_id = prod_id;
		}
		public String getProd_name() {
			return prod_name;
		}
		public void setProd_name(String prod_name) {
			this.prod_name = prod_name;
		}

		public int getUnitPrice() {
			return unitPrice;
		}

		public void setUnitPrice(int unitPrice) {
			this.unitPrice = unitPrice;
		}

		public int getQty() {
			return qty;
		}

		public void setQty(int qty) {
			this.qty = qty;
		}

		public int getTotal() {
			return total;
		}

		public void setTotal(int total) {
			this.total = total;
		}

		
		

	}
