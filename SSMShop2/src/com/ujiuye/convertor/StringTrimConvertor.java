package com.ujiuye.convertor;

import org.springframework.core.convert.converter.Converter;

public class StringTrimConvertor implements Converter<String,String> {

	@Override
	public String convert(String arg0) {
		
		return arg0.trim();
	}

}
