package com.store.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.store.dao.DiscountDao;
import com.store.fatory.USER_TYPE;
import com.store.fatory.UserFactory;
import com.store.model.Product;
import com.store.user.User;

public class DiscountCalculatorServiceImplTest {

	@Mock
	private DiscountDao discountDao;
	private CalculateDiscountService calculateDiscountService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		calculateDiscountService = new DiscountCalculatorServiceImpl();
		ReflectionTestUtils.setField(calculateDiscountService, "discountDao", discountDao);
	}

	@Test
	public void testCalculate() {
		LocalDate registredDate = LocalDate.of(2019, Month.MAY, 19);
		User employee = UserFactory.getUSer(USER_TYPE.EMPLOYEE, registredDate);
		Product product = getProduct(false, "product02", 100, 1002);
		Mockito.when(discountDao.calculateDiscountForGroceries(employee, product)).thenReturn(new Double(70));
		double result = calculateDiscountService.calculate(employee, product);
		assertEquals(70, result, 0.0);
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
