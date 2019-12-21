package com.store.user;

import java.time.LocalDate;

import com.store.constant.Constants;
import com.store.model.Product;
import com.store.util.PropertyReader;
import com.store.util.YearsCalculator;

public class Customer extends User {

	private int discountRate;

	public Customer(int discountRate, LocalDate registeredDate) {
		super(discountRate, registeredDate);
		this.discountRate = discountRate;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	@Override
	public double calculateDiscountPrice(Product product) {

		double discountedPrice = 0;
		int years = YearsCalculator.getYears(getRegisteredDate());
		int yearThreasHold = parseInt(PropertyReader.getProperty().getProperty(Constants.CUSTOMER_YEARS_THRESHOLD));
		int discountEveryPrice = parseInt(PropertyReader.getProperty().getProperty(Constants.DISCOUNT_EVERY_PRICE));

		if (!product.isGrocery() && years > yearThreasHold) {
			discountedPrice = product.getPrice() - (product.getPrice() * discountRate / 100);
		} else if (product.getPrice() > discountEveryPrice) {
			discountedPrice = calculateOffAmount(product);
		}
		return discountedPrice;
	}

	/*
	 * Calculate off price on every 100 (normal or groceries)
	 */
	private double calculateOffAmount(Product product) {
		int discountEveryPrice = parseInt(PropertyReader.getProperty().getProperty(Constants.DISCOUNT_ON_EVERY_HUNDRED));
		double price = product.getPrice();
		double hundredMultiple = price / 100;
		return price - (hundredMultiple * discountEveryPrice);
	}

	private int parseInt(String inputString) {
		return Integer.parseInt(inputString);
	}

}
