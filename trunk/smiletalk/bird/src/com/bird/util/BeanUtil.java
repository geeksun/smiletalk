package com.bird.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.bird.domain.UserBean;

/**
 * Bean工具类
 * @author jzq
 *  2009-12-2
 */
public class BeanUtil {
	
	
	/**
	 * @param obj
	 *  对对象中的null属性进行处理
	 * @throws ClassNotFoundException 
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws IllegalArgumentException 
	 */
	public static void handle(Object obj) throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException{
		System.out.println(obj.toString());
		Class cla = obj.getClass();
		System.out.println(cla.getName());
		String className = cla.getName();
		/*Method[] methods = cla.getMethods();
		Field[] fields = cla.getFields();
		for(Field field:fields){
			System.out.println(field.getName());
			System.out.println(field.toString());
		}*/
		
		Object o = null;
	   //通过类加载器获得Car类对象
	   ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
	   Class clazz = classLoader.loadClass(className);
	 
	   //获得类的默认构造器对象并通过它实例化Car
	   Constructor cons=clazz.getDeclaredConstructor((Class[])null);
	   o = cons.newInstance();
	 
	   //通过方法名与参数类型获得对象中的方法
	   /*Method SetName = clazz.getMethod("SetName",String.class);*/
	   //反射调用实例中的方法
	 /*  SetName.invoke(car,"宝马"); 
	   Method SetColor=clazz.getMethod("SetColor",String.class);
	   SetColor.invoke(car,"红色");
	   Method SetPrice=clazz.getMethod("SetPrice",Double.class);
	   SetPrice.invoke(car,new Double(100)); */
	   
	   Field[] fields = clazz.getFields();
	   for(Field field:fields){
			System.out.println(field.getName());
			System.out.println(field.toString());
			
	   }
	   
	   Method[] methods = clazz.getMethods();
		for(Method method:methods){
			System.out.println(method.getName());
			//System.out.println(method.toString());
		}
	   
		
	}
	
	

	/**
	 * @param args
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws NoSuchMethodException 
	 * @throws ClassNotFoundException 
	 * @throws IllegalArgumentException 
	 * @throws SecurityException
	 */
	public static void main(String[] args) throws SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
		UserBean userBean = new UserBean();
		userBean.setUserId(3);
		userBean.setEmail(null);
		userBean.setBirthday("123");
		userBean.setIsActive(null);
		//handle(userBean);
		JsonUtil.object2json(userBean);
		System.out.println(JsonUtil.object2json(userBean));
		
	}

}
