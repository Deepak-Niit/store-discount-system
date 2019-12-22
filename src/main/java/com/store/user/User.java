package com.store.user;

import java.time.LocalDate;

import com.store.model.Product;

public abstract class User {

	protected LocalDate registeredDate;
	protected int discountRate;

	public User(int discountRate, LocalDate registeredDate) {
		this.discountRate = discountRate;
		this.registeredDate = registeredDate;
	}

	public abstract double calculateDiscountPrice(Product product);

}
