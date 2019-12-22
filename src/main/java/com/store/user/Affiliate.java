package com.store.user;

import java.time.LocalDate;

import com.store.model.Product;
import com.store.util.DiscountCalculator;

public class Affiliate extends User {

    private int discountRate;

    public Affiliate(int discountRate, LocalDate registeredDate) {
	super(discountRate, registeredDate);
	this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscountPrice(Product product) {
	double discountedPrice = product.getPrice();

	if (!product.isGrocery()) {
	    discountedPrice = DiscountCalculator.calculateDiscount(product, discountRate);
	}
	return discountedPrice;
    }

}
