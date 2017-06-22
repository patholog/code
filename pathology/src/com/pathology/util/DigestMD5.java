package com.pathology.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class DigestMD5 {
	private static MessageDigest messageDigest;   
    private static String result = "";   
    private  static byte[] args = null; 
    
    
    /**
     * 密码 MD5
     * @param userpass
     * @return
     */
    
    public static String getDigestPassWord(String userpass) {   
        try {  
        	 BASE64Encoder base64encoder = new BASE64Encoder();
			 String base64 = base64encoder.encode(userpass.getBytes("UTF-8"));
    		 userpass = userpass+base64;		
            // 生成MessageDigest对象,传入所用算法的参数(MD5)   
            messageDigest = MessageDigest.getInstance("MD5");   
            // 使用 getBytes( )方法生成字符串数组   
            messageDigest.update(userpass.getBytes("UTF-8"));  
            //messageDigest.update(userpass.getBytes("GBK"));   
            // 执行MessageDigest对象的digest( )方法完成计算，计算的结果通过字节类型的数组返回   
            args = messageDigest.digest();   
        } catch (NoSuchAlgorithmException e) {   
            e.printStackTrace();   
        } catch (UnsupportedEncodingException ee) {   
            ee.printStackTrace();   
        } finally {   
            messageDigest.reset();   
        }   
  
        // 将结果转换成字符串   
        result = "";// result清空，否则它会自动累加！！！   
        for (int i = 0; i < args.length; i++) {   
            result += Integer.toHexString((0x000000ff & args[i]) | 0xffffff00)   
                    .substring(6);   
        } 
        return result;   
    }  
    
    
    /**
     * 域名 MD5
     * @param userpass
     * @return
     */
    
    public static  String getDigestDomainCode(String domain_name) {   
        try {  
        	 if (domain_name != null && !domain_name.equals("")){
	        	//不带种子：
	        	//此种方式将会返回随机的数字，每次运行结果不一样
	        	 java.util.Random r=new java.util.Random(); 
	        	 // System.out.println(r.nextInt());
	        	 domain_name += domain_name+r.nextInt();
	    		
	            // 生成MessageDigest对象,传入所用算法的参数(MD5)   
	            messageDigest = MessageDigest.getInstance("MD5");   
	            // 使用 getBytes( )方法生成字符串数组   
	            messageDigest.update(domain_name.getBytes("UTF-8"));  
	            //messageDigest.update(userpass.getBytes("GBK"));   
	            // 执行MessageDigest对象的digest( )方法完成计算，计算的结果通过字节类型的数组返回   
	            args = messageDigest.digest();  
           }
        } catch (NoSuchAlgorithmException e) {   
            e.printStackTrace();   
        } catch (UnsupportedEncodingException ee) {   
            ee.printStackTrace();   
        } finally {   
            messageDigest.reset();   
        }   
  
        // 将结果转换成字符串   
        result = "";// result清空，否则它会自动累加！！！   
        for (int i = 0; i < args.length; i++) {   
            result += Integer.toHexString((0x000000ff & args[i]) | 0xffffff00)   
                    .substring(6);   
        }   
        return result;   
    }   
}
