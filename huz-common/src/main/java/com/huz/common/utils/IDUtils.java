/* 
 * @Project: huz-common 
 * @Title IDUtils.java 
 * @Package com.huz.common.utils 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author huz    
 * @date 2017年8月29日 下午2:49:52 
 * @version V1.0   
 */
package com.huz.common.utils;
import java.util.Random;
/** 
 * @ClassName: IDUtils 
 * @Description: 各种id生成策略
 * @author huz 
 * @date 2017年8月29日 下午2:49:52
 * 
 */
public class IDUtils {
	/**
	 * 图片名生成
	 */
	public static String genImageName() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		String str = millis + String.format("%03d", end3);
		
		return str;
	}
	
	/**
	 * 商品id生成
	 */
	public static long genItemId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}
	
	public static void main(String[] args) {
		for(int i=0;i< 100;i++)
		System.out.println(genItemId());
	}
}
