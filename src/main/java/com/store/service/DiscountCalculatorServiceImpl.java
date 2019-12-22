package com.store.service;

import com.store.dao.DiscountDao;
import com.store.dao.DiscountDaoImpl;
import com.store.model.Product;
import com.store.user.User;

public class DiscountCalculatorServiceImpl implements CalculateDiscountService {

    private DiscountDao discountDao;

    public double calculate(User user, Product product) {
	discountDao = new DiscountDaoImpl();
	return discountDao.calculateDiscountForGroceries(user, product);

    }

}