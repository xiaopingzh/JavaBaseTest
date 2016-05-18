package com.ping.base;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 过滤特殊字符 
 * Unicode字符集
 * 字符四字节UTF-8编码
 * @author zhangxiaoping
 *
 * 2015年6月2日 上午10:49:53
 */
public class StringPatterTest {
	
	static public String filterOffUtf8Mb4(String text) throws UnsupportedEncodingException {
        byte[] bytes = text.getBytes("utf-8");
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        int i = 0;
        while (i < bytes.length) {
            short b = bytes[i];
            if (b > 0) {
                buffer.put(bytes[i++]);
                continue;
            }
            b += 256;
            if ((b ^ 0xC0) >> 4 == 0) {
                buffer.put(bytes, i, 2);
                i += 2;
            }
            else if ((b ^ 0xE0) >> 4 == 0) {
                buffer.put(bytes, i, 3);
                i += 3;
            }
            else if ((b ^ 0xF0) >> 4 == 0) {
                i += 4;
            }
        }
        buffer.flip();
        return new String(buffer.array(), "utf-8");
	}
	
	public final static String filterEmoji(String text){
    	if(text ==null || text.length()<1){
    		return text;
    	}
		  Matcher matcher=emoji.matcher(text);
		  if(matcher.find()){
			  text = matcher.replaceAll("");
		  }
		  return text;
    }
    
    public final static boolean containEmoji(String text) {
	    if(text==null || text.length()<1){
	    	return false;
	    }
	    Matcher matcher=emoji.matcher(text);
	    return (matcher.find()?true:false);
   }
   
    /*emoji表情，空格，tab*/
   private final static Pattern   emoji=Pattern.compile ("[\\u0009\\u000a\\u000d\\u0020]|[\\ue001-\\ue05a]|[\\ue101-\\ue15a]|[\\ue201-\\ue253]|[\\ue301-\\ue34d]|[\\ue401-\\ue44c]|[\\ue501-\\ue537]|[\\xC2-\\xDF][\\x80-\\xBF]|\\xF0[\\x90-\\xBF][\\x80-\\xBF]{2}|\\xE0[\\xA0-\\xBF][\\x80-\\xBF]|[\\xE1-\\xEC\\xEE\\xEF][\\x80-\\xBF]{2}|[\\xF1-\\xF3][\\x80-\\xBF]{3}|\\xF4[\\x80-\\x8F][\\x80-\\xBF]{2}|\\xED[\\x80-\\x9F][\\x80-\\xBF]|[\\xE1-\\xEC\\xEE\\xEF][\\x80-\\xBF]{2}", Pattern.UNICODE_CASE|Pattern.CASE_INSENSITIVE);
 
   
   public void charByteLength(String str){
	  try {
		  /**
		   * char 是16位Unicode编码 即2字节
		   */
		 char[] chars = str.toCharArray();
		 for(int i=0;i<chars.length;i++){
			 char mychar = chars[i];
			 System.out.println(mychar);
		 } 
		  
		byte[] bytes = str.getBytes("UTF-8");
		for(int i=0;i<bytes.length;i++){
			System.out.println(bytes[i]);
		}
		System.out.println(bytes.toString());
	  } catch (Exception e) {
		e.printStackTrace();
	  }
   }
   
   
   public static void main(String[] args) {
	   /**
	    * 输入法表情 4字节
	    */
	   new StringPatterTest().charByteLength("😊");
	   
//	   String s="\u0009中国你\\xF0好\\xC2\\x80234as,asdf.asdf@3%^((2)&)&!$#%^.__-";
//	   String s = "\\xF0\\x9F\\x87\\xAE\\xF0\\x9F";
//	   try {
//		   System.out.println(filterOffUtf8Mb4(s));
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
	   
//	   System.out.println(filterEmoji(s));
//	   System.out.println(s);
   }
}
