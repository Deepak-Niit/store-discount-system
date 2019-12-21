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

	public User getUSer(USER_TYPE user_Type, LocalDate registeredDate) {
		int discountRate = 0;
		Properties prop = PropertyReader.getProperty();
		switch (user_Type) {
		case EMPLOYEE:
			discountRate = Integer.parseInt(prop.getProperty(Constants.EMPLOYEE_DISCOUNT_RATE));
			return new Employee(discountRate , registeredDate);
		case AFFILIATE:
			discountRate = Integer.parseInt(prop.getProperty(Constants.AFFILIATE_DISCOUNT_RATE));
			return new Affiliate(discountRate , registeredDate);
		case CUSTOMER:
			discountRate = Integer.parseInt(prop.getProperty(Constants.NORMAL_USER_DISCOUNT_RATE));
			return new Customer(discountRate ,  registeredDate);
		}

		return null;
	}

}
