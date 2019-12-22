package com.store.user;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

import com.store.fatory.USER_TYPE;
import com.store.fatory.UserFactory;
import com.store.model.Product;

public class CustomerTest {
	private User customer = null;

	@Before
	public void setUp() {
		LocalDate registredDate = LocalDate.of(2019, Month.MAY, 19);
		customer = UserFactory.getUSer(USER_TYPE.CUSTOMER, registredDate);
	}

	@Test // case 4 - off price will apply for every 100
	public void testCalculateDiscountPriceForNotGroceries() throws Exception {
		Product product = getProduct(false, "product01", 990, 1001);
		double result = customer.calculateDiscountPrice(product);
		assertEquals(945, result, 0.0);
	}

	@Test // case-3 - User will get 5% discount for more the 2 year customer
	public void testCalculateDiscountPriceForOldCustomer() throws Exception {
		Product product = getProduct(false, "product02", 500, 1002);
		LocalDate registredDate = LocalDate.of(2016, Month.MAY, 01);
		customer = getUserMoreThanTwoYear(registredDate);
		double result = customer.calculateDiscountPrice(product);
		assertEquals(475, result, 0.0);
	}

	@Test // case-4 - User will only get off price for every 100 for grocery will not get
			// % based discount
	public void testNotCalculateDiscountPriceForGrocery() throws Exception {
		Product product = getProduct(true, "product02", 500, 1002);
		LocalDate registredDate = LocalDate.of(2016, Month.MAY, 01);
		customer = getUserMoreThanTwoYear(registredDate);
		double result = customer.calculateDiscountPrice(product);
		assertEquals(475, result, 0.0);
	}
	@Test // case-4 - User will not get Off price Discount if price<100
	public void testUserNotGetOffPriceIfPriceIsLessThanHundred() throws Exception {
		Product product = getProduct(true, "product02", 90, 1002);
		LocalDate registredDate = LocalDate.of(2016, Month.MAY, 01);
		customer = getUserMoreThanTwoYear(registredDate);
		double result = customer.calculateDiscountPrice(product);
		assertEquals(90, result, 0.0);
	}

	private User getUserMoreThanTwoYear(LocalDate registredDate) {
		customer = UserFactory.getUSer(USER_TYPE.CUSTOMER, registredDate);
		return customer;
	}

	private Product getProduct(boolean isGrocery, String name, double price, int id) {
		Product product = new Product();
		product.setGrocery(isGrocery);
		product.setName(name);
		product.setPrdId(id);
		product.setPrice(price);
		return product;
	}

}
