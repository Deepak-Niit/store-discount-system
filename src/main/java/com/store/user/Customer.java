package com.store.user;

import java.time.LocalDate;

import com.store.constant.Constants;
import com.store.model.Product;
import com.store.util.DiscountCalculator;
import com.store.util.PropertyReader;
import com.store.util.YearsCalculator;

public class Customer extends User {

    private static final int HUNDRED = 100;
    private int discountRate;

    public Customer(int discountRate, LocalDate registeredDate) {
	super(discountRate, registeredDate);
	this.discountRate = discountRate;
    }

    @Override
    public double calculateDiscountPrice(Product product) {

	double discountedPrice = product.getPrice();
	int years = YearsCalculator.getYears(registeredDate);
	int yearThreasHold = parseInt(PropertyReader.getProperty().getProperty(Constants.CUSTOMER_YEARS_THRESHOLD));
	int discountEveryPrice = parseInt(PropertyReader.getProperty().getProperty(Constants.DISCOUNT_EVERY_PRICE));

	if (!product.isGrocery() && years > yearThreasHold) {
	    discountedPrice = DiscountCalculator.calculateDiscount(product, discountRate);
	} else if (product.getPrice() > discountEveryPrice) {
	    discountedPrice = calculateOffAmount(product);
	}
	return discountedPrice;
    }

    /*
     * Calculate off price on every 100 only for customer
     */
    private double calculateOffAmount(Product product) {
	int discountEveryPrice = parseInt(
		PropertyReader.getProperty().getProperty(Constants.DISCOUNT_ON_EVERY_HUNDRED));
	double price = product.getPrice();
	int hundredMultiple = (int) (price / HUNDRED);
	return price - (hundredMultiple * discountEveryPrice);
    }

    private int parseInt(String inputString) {
	return Integer.parseInt(inputString);
    }

}
