package com.ecomm.DAO;

import com.ecomm.model.Customer;

public interface CustomerDAO {
	void registerCustomer(Customer customer);
	boolean isEmailUnique(String email);
}
