package com.store.util;

import com.store.exception.PriceException;
import com.store.model.Product;

public class DiscountCalculator {

    private static final int _100 = 100;

    private DiscountCalculator() {
    }

    public static double calculateDiscount(Product product, int discountRate) {

	double discountedPrice = 0.0;
	if (product.getPrice() > 0) {
	    discountedPrice = product.getPrice() - (product.getPrice() * discountRate / _100);
	} else {
	    throw new PriceException("Price should not be zero");
	}

	return discountedPrice;
    }

}
