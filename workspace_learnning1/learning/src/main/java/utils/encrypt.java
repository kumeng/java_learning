package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

/**
 * encrypt加密
 * 
 * @author Administrator
 *
 */
public class encrypt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pwd = "sdkhdQ2";
		encrypt e1 = new encrypt();
		encrypt e2 = new encrypt();
		// 第一次加密
		String enryptionPwd1 = e1.getEnryptionPwd(pwd);
		System.out.println("enryptionPwd1:" + enryptionPwd1);
		// 第二次加密
		String enryptionPwd2 = e2.getEnryptionPwd(pwd);
		System.out.println("enryptionPwd2:" + enryptionPwd2);
		System.out.println(enryptionPwd1.equals(enryptionPwd2));
		// 第三次加密
		String enryptionPwd3 = e1.getEnryptionPwd(pwd);
		System.out.println("enryptionPwd3:" + enryptionPwd3);
		System.out.println(enryptionPwd1.equals(enryptionPwd3));
	}

	/**
	 * 商用加密规则 一般加密2到3次，加密算法顺序不定 密码加言，前后加言 ，主动扩充密码，加大破解难度
	 */
	public String getEnryptionPwd(String pwd) {
		String pwd2 = "FDdsdgh123-d" + pwd + "DKDfd[sarh32";
		// System.out.println(pwd2);
		try {
			// md5 加密
			MessageDigest digest = MessageDigest.getInstance("MD5");
			byte[] digest2 = digest.digest(pwd2.getBytes());

			// char[] encodeHex = Hex.encodeHex(digest2);
			// 转16进制
			return Hex.encodeHexString(digest2);

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Test
	public void testchars2String() {

	}
}
