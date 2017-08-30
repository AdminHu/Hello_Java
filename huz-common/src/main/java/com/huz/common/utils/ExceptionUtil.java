/* 
 * @Project: huz-common 
 * @Title ExceptionUtil.java 
 * @Package com.huz.common.utils 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author huz    
 * @date 2017年8月29日 下午2:44:01 
 * @version V1.0   
 */
package com.huz.common.utils;
import java.io.PrintWriter;
import java.io.StringWriter;
/** 
 * @ClassName: ExceptionUtil 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author huz 
 * @date 2017年8月29日 下午2:44:01
 * 
 */
public class ExceptionUtil {
	/**
	 * 
	 * @Title: getStackTrace 
	 * @Description: 获取异常的堆栈信息
	 * @param t
	 * @return String
	 */
	public static String getStackTrace(Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		try {
			t.printStackTrace(pw);
			return sw.toString();
		} finally {
			pw.close();
		}
	}
}
