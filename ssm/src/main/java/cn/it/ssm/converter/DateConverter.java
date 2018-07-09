package cn.it.ssm.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {

	public Date convert(String source) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		try {
			return format.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
