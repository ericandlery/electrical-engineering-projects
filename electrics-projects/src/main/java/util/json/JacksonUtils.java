package util.json;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtils {
	
	private static ObjectMapper om;
	
	static {
		om=new ObjectMapper();
	}
	
	private JacksonUtils() {}
	
	/*Convert List to Json String*/
	public static String listToJson(List<?> list) {
		try {
			return om.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			throw new RuntimeException("JacksonUtils Failed.");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("jso");
	}

}
