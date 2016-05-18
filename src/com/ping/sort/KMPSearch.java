package com.ping.sort;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * KMP算法的实现
 * @author dfeng
 *
 */
public class KMPSearch {

	/**
	 * 判断是否匹配
	 * @param target 目标文本串
	 * @param mode 模式串
	 * @return 匹配结果
	 */
	public static boolean matchString(String target, String mode) {
		//为了和算法保持一致，使index从1开始，增加一前缀
		String newTarget = "x" + target; 
		String newMode = 'x' + mode;
		
		int[] K = calculateK(mode);
		
		int i = 1;
		int j = 1;
		while(i <= target.length() && j <= mode.length()) {
			if (j == 0 || newTarget.charAt(i) == newMode.charAt(j)) {
				i++;
				j++;
			} else {
				j = K[j];
			}
		}
		
		if (j > mode.length()) {
			return true;
		}
		return false;
	}
	
	/*
	 * 计算K值
	 */
	private static int[] calculateK(String mode) {
		//为了和算法保持一致，使index从1开始，增加一前缀
		String newMode = "x" + mode;
		int[] K = new int[newMode.length()];
		int i = 1;
		K[1] = 0;
		int j = 0;
		
		while(i < mode.length()) {
			if (j == 0 || newMode.charAt(i) == newMode.charAt(j)){
				i++;
				j++;
				K[i] = j;
			} else {
				j = K[j];
			}
		}
		
		return K;
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String a = "dbcabcabcabbcabcabcabcab";
//		String b = "cabe";//"ababbaaba";//
//		System.out.println(a.contains(b));
//		System.out.println(KMPSearch.matchString(a, b));

	}

}
