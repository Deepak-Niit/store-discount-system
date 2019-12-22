package com.store.user;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

import com.store.fatory.USER_TYPE;
import com.store.fatory.UserFactory;
import com.store.model.Product;

public class EmployeeTest {

	private User employee = null;

	@Before
	public void setUp() {
		LocalDate registredDate = LocalDate.of(2019, Month.MAY, 19);
		employee = UserFactory.getUSer(USER_TYPE.EMPLOYEE, registredDate);
	}

	@Test // Case-1 - Employee will get 30% discount
	public void testCalculateDiscountPrice() {
		Product product = getProduct(false, "product01", 100, 1002);
		double result = employee.calculateDiscountPrice(product);
		assertEquals(70, result, 0.0);
	}
	
	@Test // Case-5 - Employee will not get any discount on grocery product
	public void testCalculateDiscountPriceForGrocery() {
		Product product = getProduct(true, "product01", 450, 1002);
		double result = employee.calculateDiscountPrice(product);
		assertEquals(450, result, 0.0);
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
