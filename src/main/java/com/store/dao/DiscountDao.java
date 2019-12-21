package com.store.dao;

import com.store.model.Product;
import com.store.user.User;

public interface DiscountDao {

	public double calculateDiscountForGroceries(User user, Product product);

}
