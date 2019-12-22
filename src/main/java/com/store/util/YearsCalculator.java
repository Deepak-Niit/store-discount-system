package com.store.util;

import java.time.LocalDate;
import java.time.Period;

public class YearsCalculator {

	private YearsCalculator() {

	}

	public static int getYears(LocalDate registeredDate) {

		LocalDate today = LocalDate.now();

		Period age = Period.between(registeredDate, today);
		return age.getYears();
	}

}
