package com.ecomm.DAO;

import java.util.List;

import com.ecomm.model.Customer;
import com.ecomm.model.CartItem;
import com.ecomm.model.CustomerOrder;
import com.ecomm.model.User;

public interface CartItemDAO {
	void addToCart(CartItem cartItem);
	User getUser(String email);
	List<CartItem>  getCart(String email);//select * from cartitem where user_email=?
	void removeCartItem(int cartItemId);
	CustomerOrder createCustomerOrder(CustomerOrder customerOrder);	
}
