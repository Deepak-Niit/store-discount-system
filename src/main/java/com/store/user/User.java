package com.store.user;

import java.time.LocalDate;

import com.store.model.Product;

public abstract class User {

	private LocalDate registeredDate;
	private int discountRate;

	public User(int discountRate, LocalDate registeredDate) {
		this.discountRate = discountRate;
		this.registeredDate = registeredDate;
	}

	public abstract double calculateDiscountPrice(Product price);

	public LocalDate getRegisteredDate() {
		return registeredDate;
	}

	public int getDiscountRate() {
		return discountRate;
	}

}
