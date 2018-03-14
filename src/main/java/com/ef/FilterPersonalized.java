package com.ef;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FilterPersonalized {

	public static boolean filteringByParams(String dateParam, LocalDateTime startDate, LocalDateTime endDate) {

		String formatedDate = dateParam.split("\\|")[0];

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		LocalDateTime date = LocalDateTime.parse(formatedDate, formatter);

		return date.isAfter(startDate) && date.isBefore(endDate);

	}

}
