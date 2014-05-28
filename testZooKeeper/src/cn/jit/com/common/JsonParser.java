package cn.jit.com.common;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser {
	private final static String	DEFAULT_DATE_FORMAT	= "yyyy-MM-dd-HH:mm:ss-SSS";

	private JsonParser() {}

	public static <T> T jsonToBean(byte[] json, Class<T> className) {
		try {
			if (json == null || json.length == 0) {
				return null;
			}
			ObjectMapper mapper = new ObjectMapper();
			mapper.setDateFormat(new SimpleDateFormat(DEFAULT_DATE_FORMAT));
			return (T) mapper.readValue(json, className);
		} catch (JsonParseException e) {} catch (JsonMappingException e) {} catch (IOException e) {}
		return null;
	}

	public static <T> byte[] beanToJson(T t) {
		if (t == null) {
			return new byte[0];
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat(DEFAULT_DATE_FORMAT));
		try {
			return mapper.writeValueAsBytes(t);
		} catch (JsonProcessingException e) {}
		return null;
	}

}
