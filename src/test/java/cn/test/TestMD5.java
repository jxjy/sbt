package cn.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

/**
 * MD5加密工具类
 * @author Nothing
 *
 */
public final class TestMD5 {
	
	public static String getMD5(String str){
		// 创建MessageDigest
		MessageDigest md = null;
		StringBuilder res = new StringBuilder();
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			// 获取MD5加密后的字节数组
			byte[] md5Bytes = md.digest();
			for (int i = 0; i < md5Bytes.length; i++){
				int t = md5Bytes[i] & 0xff;
				if (t <= 0xf){
					res.append("0");
				}
				// 转化成16进制
				res.append(Integer.toHexString(t));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return res.toString();
	}
	
	@Test
	public void test(){
		System.out.println(TestMD5.getMD5("1"));
	}
}