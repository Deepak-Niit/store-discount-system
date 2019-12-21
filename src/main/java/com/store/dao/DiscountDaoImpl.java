package com.store.dao;

import com.store.model.Product;
import com.store.user.User;

public class DiscountDaoImpl implements DiscountDao{

	public double calculateDiscountForGroceries(User user, Product product) {
		return user.calculateDiscountPrice(product);
	}

}
