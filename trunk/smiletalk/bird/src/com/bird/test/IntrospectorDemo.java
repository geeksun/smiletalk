package com.bird.test;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

/**
 * ��ʡ��ʾ����: ��ĳ������������������ƺ�ֵ����ӡ����
 * @author liudong
 * url: http://www.blogjava.net/wiflish/archive/2007/03/05/101964.html
 */
public class IntrospectorDemo {
	String name;
	String height;
	
    public static void main(String[] args) throws Exception{
        IntrospectorDemo demo = new IntrospectorDemo();
        demo.setName( "Winter Lau" );        
        demo.setHeight(null);

        // �������Ѹ��������Ҳ�г����Ļ���
        // �� getBeanInfo �ĵڶ���������д�������Ϣ
        BeanInfo bi = Introspector.getBeanInfo(demo.getClass(), Object.class );
        PropertyDescriptor[] props = bi.getPropertyDescriptors();
        for ( int i=0;i<props.length;i++){
            String name = props[i].getName();
            Object value = props[i].getReadMethod().invoke(demo, null );
            System.out.println(name+ ":" + value);
            if(value==null){
            	props[i].getReadMethod().invoke(name, "");
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this .name = name;
    }

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
}
