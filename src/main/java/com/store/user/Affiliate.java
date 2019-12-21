package com.store.user;

import java.time.LocalDate;

import com.store.model.Product;

public class Affiliate extends User {

	private int discountRate;

	public Affiliate(int discountRate, LocalDate registeredDate) {
		super(discountRate, registeredDate);
		this.discountRate = discountRate;
	}

	

	public int getDiscountRate() {
		return discountRate;
	}

	@Override
	public double calculateDiscountPrice(Product product) {
		double discountedPrice = 0;

		if (!product.isGrocery()) {
			discountedPrice = product.getPrice() - (product.getPrice() * discountRate / 100);
		}
		return discountedPrice;
	}

}
