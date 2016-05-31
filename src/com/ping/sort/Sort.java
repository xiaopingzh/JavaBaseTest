package com.ping.sort;

/**
 * 冒泡、快排、希尔
 * @author 
 *
 * 2015年10月26日 下午11:52:01
 */
public class Sort {
	//public static int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51}; 
	public static int a[] = {12,19,24,9,8,29,6,16};
	private static int[] xierb= {5,7,3,21,44,15,13,16,11,29,27};	//用于希尔排序的数组
	
	
	/**
	 * 数组输出
	 * @param a
	 */
	public void printarray(int[] a){
		StringBuffer strbuffer = new StringBuffer();
		for(int i=0;i<a.length;i++){
			strbuffer.append(a[i] + ",");
		}
		System.out.println(strbuffer.toString());
	}
	
	
	/**
	 * 冒泡排序
	 */
	public void test01(){
		int temp = 0;
		for(int i=0;i<a.length;i++){//遍历的次数
			for(int j=a.length-1;j>i;j--){ //在每次遍历的过程中需比较的次数
				if(a[j]<a[j-1]){
					temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
	}
	
	/**
	 * 快速排序
	 * @param array
	 * @param from
	 * @param to
	 */
	 public void quickSort(int array[], int from, int to) {
		 //当起始点< 结束点 时则表示已排序的这部分数据为已经排好序
		 if (from < to) { 
	            int temp = array[to]; 
	            int i = from - 1; //i的作用在于a[i]始终表示的是在该数组中到目前为止和a[j]相隔最近（由左到右的遍历）的且小于temp的数
	            for (int j = from; j < to; j++) { 
	                if (array[j] < temp && i<j) { 
	                    i++; 
	                    int tempValue = array[j]; 
	                    array[j] = array[i]; 
	                    array[i] = tempValue; 
	                } 
	            } 
	            //交换，因为array[i+1]~a[to-1] 都是大于a[to],即temp
	            array[to] = array[i+1]; 
	            array[i+1] = temp; 
	            
	            quickSort(array, from, i); 
	            quickSort(array, i + 1, to); 
	     }
		 printarray(array);
	 }
	
	/**
	 * 希尔排序
	 * @param a
	 * @param n
	 */
	public void shellsort1(int a[], int n){  
	     int i, j, gap;  
	     for (gap = n / 2; gap > 0; gap /= 2){
	    	 for (i = 0; i < gap; i++){        //直接插入排序  
	    		 for (j = i + gap; j < n; j += gap){
	    			 if (a[j] < a[j - gap]){  
	    				 int temp = a[j];  
	    				 int k = j - gap;  
	    				 while (k >= 0 && a[k] > temp){  
	    					 a[k + gap] = a[k];  
	    					 k -= gap;  
	    				 }  
	    				 a[k + gap] = temp;  
	    			 }  
	    		 }   
	    	 }
	    	 printarray(a);
	     }  
	 }  
	 
	 /**
	  * 希尔排序2
	  * @param a
	  * @param n
	  */
	 public void shellsort2(int a[], int n) {  
	     int j, gap;  
	     for (gap = n / 2; gap > 0; gap /= 2){  
	         for (j = gap; j < n; j++){//从数组第gap个元素开始  
	             if (a[j] < a[j - gap]){  
	                 int temp = a[j];  
	                 int k = j - gap;  
	                 while (k >= 0 && a[k] > temp){  
	                     a[k + gap] = a[k];  
	                     k -= gap;  
	                 }  
	                 a[k + gap] = temp;  
	             }
	         }
	     	printarray(a);
	     }
	 } 
	 
	 
	 
	public static void main(String[] args){
		Sort sort = new Sort();
//		sort.shellsort2(xierb,xierb.length);
		sort.quickSort(a, 0, a.length-1);
//		printarray();
	}
	
	
}
