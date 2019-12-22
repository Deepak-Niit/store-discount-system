package com.store.user;

import java.time.LocalDate;

import com.store.model.Product;
import com.store.util.DiscountCalculator;

public class Employee extends User {

    private int discountRate;

    public Employee(int discountRate, LocalDate registeredDate) {
	super(discountRate, registeredDate);
	this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscountPrice(Product product) {

	double discountPrice = product.getPrice();
	if (!product.isGrocery()) {
	    discountPrice = DiscountCalculator.calculateDiscount(product, discountRate);
	}

	return discountPrice;

    }

}
