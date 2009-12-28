package com.bird.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.ServletRequest;

/**
 * Java bean ����
 * @author ��ѧ��
 * 2009-11-28
 */
public class StringUtil {

	/**
	 * @param str
	 * @return GBK�ַ���
	 */
	public static String converse(String str)
			throws UnsupportedEncodingException {
		return new String(str.getBytes("ISO-8859-1"), "GBK");
	}

	/**
	 * @param request
	 * @param paras
	 * @see �ѱ��Ĳ�����װ��map��
	 */
	public static Map getParameter(ServletRequest request, String[] paras) {
		Map<String, String> map = new HashMap<String, String>();
		if (paras == null || paras.length == 0)
			return map;
		for (int i = 0; i < paras.length; i++) {
			String para = paras[i];
			if (para == null || para.trim().length() == 0)
				continue;
			String value = request.getParameter(para);
			if (value == null || value.trim().length() == 0)
				value = "";
			else
				value = value.trim();
			map.put(para, value);
		}
		return map;
	}

	/**
	 * �ָ��ַ���
	 * @param str String ԭʼ�ַ���
	 * @param splitsign String �ָ���
	 * @return String[] �ָ����ַ�������
	 */
	public static String[] split(String str, String splitsign) {
		int index;
		if (str == null || splitsign == null)
			return null;
		ArrayList al = new ArrayList();
		while ((index = str.indexOf(splitsign)) != -1) {
			al.add(str.substring(0, index));
			str = str.substring(index + splitsign.length());
		}
		al.add(str);
		return (String[]) al.toArray(new String[0]);
	}

	/**
	 * �滻�ַ���
	 * @param from String ԭʼ�ַ���
	 * @param to String Ŀ���ַ���
	 * @param source String ĸ�ַ���
	 * @return String �滻����ַ���
	 */
	public static String replace(String from, String to, String source) {
		if (source == null || from == null || to == null)
			return null;
		StringBuffer bf = new StringBuffer("");
		int index = -1;
		while ((index = source.indexOf(from)) != -1) {
			bf.append(source.substring(0, index) + to);
			source = source.substring(index + from.length());
			index = source.indexOf(from);
		}
		bf.append(source);
		return bf.toString();
	}

	/**
	 * �滻�ַ��������ܹ���HTMLҳ����ֱ����ʾ(�滻˫���ź�С�ں�)
	 * @param str String ԭʼ�ַ���
	 * @return String �滻����ַ���
	 */
	public static String htmlencode(String str) {
		if (str == null) {
			return null;
		}
		return replace("\"", "&quot;", replace("<", "&lt;", str));
	}

	/**
	 * �滻�ַ��������������ת����ԭʼ�루�滻��˫���ź�С�ںţ�
	 * @param str String
	 * @return String
	 */
	public static String htmldecode(String str) {
		if (str == null) {
			return null;
		}
		return replace("&quot;", "\"", replace("&lt;", "<", str));
	}

	private static final String _BR = "<br/>";

	/**
	 * ��ҳ����ֱ����ʾ�ı����ݣ��滻С�ںţ��ո񣬻س���TAB
	 * @param str String ԭʼ�ַ���
	 * @return String �滻����ַ���
	 */
	public static String htmlshow(String str) {
		if (str == null) {
			return null;
		}
		str = replace("<", "&lt;", str);
		str = replace(" ", "&nbsp;", str);
		str = replace("\r\n", _BR, str);
		str = replace("\n", _BR, str);
		str = replace("\t", "&nbsp;&nbsp;&nbsp;&nbsp;", str);
		return str;
	}

	/**
	 * ����ָ���ֽڳ��ȵ��ַ���
	 * @param str String �ַ���
	 * @param length int ָ������
	 * @return String ���ص��ַ���
	 */
	public static String toLength(String str, int length) {
		if (str == null) {
			return null;
		}
		if (length <= 0) {
			return "";
		}
		try {
			if (str.getBytes("GBK").length <= length) {
				return str;
			}
		} catch (Exception ex) {
		}
		StringBuffer buff = new StringBuffer();

		int index = 0;
		char c;
		length -= 3;
		while (length > 0) {
			c = str.charAt(index);
			if (c < 128) {
				length--;
			} else {
				length--;
				length--;
			}
			buff.append(c);
			index++;
		}
		buff.append("...");
		return buff.toString();
	}

	/**
	 * �ж��Ƿ�Ϊ����
	 * @param str ������ַ���
	 * @return ����������true,���򷵻�false
	 */
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}

	/**
	 * �ж��Ƿ�Ϊ������������double��float
	 * @param str ������ַ���
	 * @return �Ǹ���������true,���򷵻�false
	 */
	public static boolean isDouble(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
		return pattern.matcher(str).matches();
	}

	/**
	 * �ж�������ַ����Ƿ����Email��ʽ.
	 * @param str ������ַ���
	 * @return ��Email��ʽ����true,���򷵻�false
	 */
	public static boolean isEmail(String str) {
		Pattern pattern = Pattern
				.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		return pattern.matcher(str).matches();
	}

	/**
	 * �ж�������ַ����Ƿ�Ϊ������
	 * @param str ������ַ���
	 * @return ����Ǵ����ַ���true,���򷵻�false
	 */
	public static boolean isChinese(String str) {
		Pattern pattern = Pattern.compile("[\u0391-\uFFE5]+$");
		return pattern.matcher(str).matches();
	}

	/**
	 * �Ƿ�Ϊ�հ�,����null��""
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * �ж��Ƿ�Ϊ����
	 * @param x
	 * @return
	 */
	public static boolean isPrime(int x) {
		if (x <= 7) {
			if (x == 2 || x == 3 || x == 5 || x == 7)
				return true;
		}
		int c = 7;
		if (x % 2 == 0)
			return false;
		if (x % 3 == 0)
			return false;
		if (x % 5 == 0)
			return false;
		int end = (int) Math.sqrt(x);
		while (c <= end) {
			if (x % c == 0) {
				return false;
			}
			c += 4;
			if (x % c == 0) {
				return false;
			}
			c += 2;
			if (x % c == 0) {
				return false;
			}
			c += 4;
			if (x % c == 0) {
				return false;
			}
			c += 2;
			if (x % c == 0) {
				return false;
			}
			c += 4;
			if (x % c == 0) {
				return false;
			}
			c += 6;
			if (x % c == 0) {
				return false;
			}
			c += 2;
			if (x % c == 0) {
				return false;
			}
			c += 6;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
