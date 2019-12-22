package com.store.fatory;

import java.time.LocalDate;
import java.util.Properties;

import com.store.constant.Constants;
import com.store.user.Affiliate;
import com.store.user.Employee;
import com.store.user.Customer;
import com.store.user.User;
import com.store.util.PropertyReader;

public class UserFactory {

	private UserFactory() {
	}

	public static User getUSer(USER_TYPE userType, LocalDate registerDate) {
		int discountRate = 0;
		Properties prop = PropertyReader.getProperty();
		switch (userType) {
		case EMPLOYEE:
			discountRate = Integer.parseInt(prop.getProperty(Constants.EMPLOYEE_DISCOUNT_RATE));
			return new Employee(discountRate, registerDate);
		case AFFILIATE:
			discountRate = Integer.parseInt(prop.getProperty(Constants.AFFILIATE_DISCOUNT_RATE));
			return new Affiliate(discountRate, registerDate);
		case CUSTOMER:
			discountRate = Integer.parseInt(prop.getProperty(Constants.NORMAL_USER_DISCOUNT_RATE));
			return new Customer(discountRate, registerDate);

		default:
			return null;
		}

	}

}
