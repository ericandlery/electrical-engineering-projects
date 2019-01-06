package util.bean;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

/**
 * Useful JavaBean Utils
 * @author Adam31
 */
public class BeanWrapperUtils {
	
	private static final String GETTER="get";
	private static final String SETTER="set";
	
	/**
	 * This method is used to wrap all the parameters from requests into a specific JavaBean.
	 */
	public static Object wrapBeanFromReq(Object bean,HttpServletRequest req) {
//		System.out.println("Wrapper");
		
		String beanName=bean.getClass().getName();
		Class<?> clazz=null;
		Iterator<String> paraNames=null;
		String paraName=null;
		Object param=null;
		Field[] fields=null;
		String fieldName=null;
		Class<?> fieldType=null;
		Method[] methods=null;
		Method getter=null;
		Method setter=null; 
		
		/*Analyze JavaBean class.*/
		try {
			clazz=Class.forName(beanName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Class Not Found. Bean's name="+beanName);
		}
//		System.out.println("Class Name="+clazz);
		
		/*Get all fields.*/
		fields=clazz.getDeclaredFields();
		/*Get all methods in order to deal with getters and setters.*/
		methods=clazz.getMethods();
		
		paraNames=req.getParameterNames().asIterator();
		/*Process each parameter.*/
		while(paraNames.hasNext()) {
			paraName=paraNames.next();
//			System.out.println(paraName);
			
			/*Check if the bean is eligible for handling these parameters.*/
			for(Field field:fields) {
				fieldName=field.getName();
//				System.out.println(fieldName);
				
				if(field.getModifiers()==Modifier.PRIVATE && fieldName.equals(paraName)) {
//					System.out.println(field+" is eligible with "+paraName);
					fieldType=field.getType();
//					System.out.println(fieldType);
					
					/*Verify getter and setter methods.*/
					fieldName=fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
//					System.out.println("##"+fieldName);
					try {
						getter=null;
						setter=null;
//						System.out.println("XXX="+GETTER+fieldName+" "+SETTER+fieldName);
						getter=clazz.getMethod(GETTER+fieldName);
						setter=clazz.getMethod(SETTER+fieldName,fieldType);
					} catch (NoSuchMethodException | SecurityException e) {
//						e.printStackTrace();
//						System.out.println("No proper getter and setter, continue with next field.");
						continue;
					}
					
//					System.out.println("req para value="+req.getParameter(paraName));
					try {
						param=convertType(req.getParameter(paraName),fieldType);
						/*Continue if the param can be converted.*/
						if(null!=param) {
							setter.invoke(bean,convertType(req.getParameter(paraName),fieldType));
//							System.out.println("getter="+getter.invoke(bean));
						}else {
							continue;
						}
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
						throw new RuntimeException("Getter or Setter not working properly.");
					}

				}else {
//					System.out.println("No field can be found, continue with next field.");
					continue;
				}
			}
			
		}
		
		return bean;
		
//		System.out.println("Wrapper END");
	}
	
	/**
	 * Type converter, to check which parameter the setter method should use.
	 */
	private static Object convertType(String paramStr,Class<?> type) {
//		System.out.println("param="+param);
//		System.out.println("type="+type);
		
		Object param=null;
		
		if(Integer.class.equals(type)) {
			try {
			param=Integer.valueOf(paramStr);
			}catch(NumberFormatException e) {
				e.printStackTrace();
			}
		}else if(String.class.equals(type)) {
			param=String.valueOf(paramStr);
		}
		
		/*Return param if successfully converted.*/
//		if(null!=param) {
			return param;
//		}else {
//			throw new RuntimeException("Param conversion failed.");
//			return null;
//		}
		
	}

}
