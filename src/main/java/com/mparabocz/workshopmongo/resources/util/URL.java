package com.mparabocz.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;

public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

	public static LocalDate convertDate(String textDate, LocalDate defaultValue) {
		try {
			return LocalDate.parse(textDate);
		} catch (Exception e) {
			return defaultValue;
		}
	}

}
