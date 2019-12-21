package com.store.service;

import com.store.model.Product;
import com.store.user.User;

public interface CalculateDiscountService {
	
	public double calculate(User user, Product product);

}
