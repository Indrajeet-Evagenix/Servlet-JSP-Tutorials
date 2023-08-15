package com.Servlets;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateCoversion {

	public static Date parseUserInput(String userInput) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return dateFormat.parse(userInput);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static java.sql.Date convertToSqlDate(Date utilDate) {
		return new java.sql.Date(utilDate.getTime());
	}

}
