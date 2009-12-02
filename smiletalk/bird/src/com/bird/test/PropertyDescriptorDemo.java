package com.bird.test;

import java.awt.Color;
import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

import com.bird.domain.UserBean;

/**
 * PropertyDescriptor£∫ Ù–‘√Ë ˆ∑˚Demo
 * 
 * @author 2009.12.2
 */
public class PropertyDescriptorDemo {

	public static void main(String[] args) throws Exception {
		UserBean bean = new UserBean();
		Map propName = new HashMap();
		propName.put("userName", "su");
		propName.put("email", "21");
		PropertyDescriptorDemo t = new PropertyDescriptorDemo();
		t.setProperties(bean, propName);

		System.out.println(bean.getUserName() + ":" + bean.getEmail());

	}

	public static void setProperties(Object bean, Map properties) {
		try {
			for (Iterator iter = properties.keySet().iterator(); iter.hasNext();) {
				String propName = (String) iter.next();

				PropertyDescriptor descriptor = new PropertyDescriptor(
						propName, bean.getClass());

				Class propertyType = descriptor.getPropertyType();

				Object value = decode(propertyType, (String) properties
						.get(propName));
				descriptor.getWriteMethod()
						.invoke(bean, new Object[] { value });

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Object decode(Class type, String value) throws Exception {
		if (type.getName().equals("java.lang.String")) {
			return value;
		}
		if (type.getName().equals("boolean")) {
			return Boolean.valueOf(value);
		}
		if (type.getName().equals("int")) {
			return Integer.valueOf(value);
		}
		if (type.getName().equals("long")) {
			return Long.valueOf(value);
		}
		if (type.getName().equals("float")) {
			return Float.valueOf(value);
		}
		if (type.getName().equals("double")) {
			return Double.valueOf(value);
		}
		if (type.getName().equals("java.awt.Color")) {
			StringTokenizer tokens = new StringTokenizer(value, ",");
			int red = Integer.parseInt(tokens.nextToken());
			int green = Integer.parseInt(tokens.nextToken());
			int blue = Integer.parseInt(tokens.nextToken());
			return new Color(red, green, blue);
		}
		if (type.getName().equals("java.lang.Class")) {
			return Class.forName(value);
		}
		return null;
	}
}
