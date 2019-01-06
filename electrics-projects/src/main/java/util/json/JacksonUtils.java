package util.json;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Useful JacksonUtils
 * @author Adam31 
 */
public class JacksonUtils {
	
	private static ObjectMapper om;
	
	static {
		om=new ObjectMapper();
	}
	
	private JacksonUtils() {}
	
	/**
	 * Convert List to Json String
	 */
	public static String listToJson(List<?> list) {
		try {
			return om.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new RuntimeException("JacksonUtils \"listToJson\" Failed.");
		}
	}
	
	/**
	 * Covert Json String to util.Map
	 */
	public static Map jsonToMap(String jsonStr) {
		try {
			return om.readValue(jsonStr,Map.class);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("JacksonUtils \"jsonToMap\" Failed.");
		}
	}
	
	/**
	 * Covert Json String to util.List
	 */
	public static List<?> jsonToList(String jsonStr) {
		try {
			return om.readValue(jsonStr,List.class);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("JacksonUtils \"jsonToList\" Failed.");
		}
	}

}
