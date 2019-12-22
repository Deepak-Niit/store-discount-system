package com.store.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.store.model.Product;
import com.store.user.User;

public class DiscountDaoImplTest {

	@Mock
	private User affliate;
	private DiscountDao discountDao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		discountDao = new DiscountDaoImpl();

	}

	@Test
	public void test() {
		Product product = getProduct(true, "product02", 100, 1002);
		affliate.calculateDiscountPrice(product);
		Mockito.when(affliate.calculateDiscountPrice(product)).thenReturn(90.0);
		double result = discountDao.calculateDiscountForGroceries(affliate, product);
		assertEquals(90, result, 0.0);

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
