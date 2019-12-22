package com.store.user;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

import com.store.exception.PriceException;
import com.store.fatory.USER_TYPE;
import com.store.fatory.UserFactory;
import com.store.model.Product;

public class AffiliateTest {

	private User affiliate = null;

	@Before
	public void setUp() {
		LocalDate registredDate = LocalDate.of(2019, Month.MAY, 19);
		affiliate = UserFactory.getUSer(USER_TYPE.AFFILIATE, registredDate);
	}

	@Test // Case-2 - Affiliate user will get 10% discount
	public void testCalculateDiscountPrice() {
		Product product = getProduct(false, "product01", 100, 1002);
		double result = affiliate.calculateDiscountPrice(product);
		assertEquals(90, result, 0.0);
	}

	@Test // Case-5 - User will not get any discount if product is grocery
	public void testCalculateDiscountPriceForGroceries() {
		Product product = getProduct(true, "product01", 100, 1002);
		double result = affiliate.calculateDiscountPrice(product);
		assertEquals(100, result, 0.0);
	}

	@Test(expected = PriceException.class)
	public void testWillThrowExceptionIfPriceIsZero() {
		Product product = getProduct(false, "product01", 0.0, 1002);
		affiliate.calculateDiscountPrice(product);
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
