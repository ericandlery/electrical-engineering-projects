package test.json;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import util.json.JacksonUtils;

public class TestJackson {
	
	@Test
	public void test() throws JsonParseException, JsonMappingException, IOException {
		
		ObjectMapper om=new ObjectMapper();
		String s = "{\"number\":33,\"team\":[\"mclaren\",\"williams\"],\"name\":\"kimi\"}";
		
		String ss="[{\"44\":\"66\"}]";
		
		System.out.println(om.readValue(ss,List.class));
		
//		System.out.println(s);
//		
//		System.out.println(JacksonUtils.jsonToMap(s));
//		
//		Map map=om.readValue(s,Map.class);
//		System.out.println(map);
//		om.readValue(s,Arrays.class);
		
	}

}
