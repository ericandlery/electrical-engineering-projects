package test.bean;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.Test;

import model.bean.rc.GridBean;

public class TestBeanWrapper {
	
	@Test
	public void test() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		GridBean bg=new GridBean();
		bg.setHeight(56);
		bg.setWidth(78);
		
		Class<?> c=Class.forName("model.bean.rc.GridBean");
		System.out.println(c);
		
		Field[] fields=c.getDeclaredFields();
//		Method[] methods=c.getMethods();
		Method getter=null;
		Method setter=null;
		
		for(Field field:fields) {
			if(field.getModifiers()==Modifier.PRIVATE) {
				String fieldName=field.getName();
				System.out.println(fieldName);
				fieldName=fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
				System.out.println(fieldName);
				getter=c.getMethod("get"+fieldName);
				setter=c.getMethod("set"+fieldName,field.getType());
				System.out.println(getter);
				System.out.println(setter);
				Object s=setter.invoke(bg,12345);
				Object o=getter.invoke(bg);
				System.out.println("Setter="+s);
				System.out.println("Getter="+o);
			}
		}
		
	}

}
