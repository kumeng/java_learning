/**
 * 
 */
package utils;

import java.security.MessageDigest;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public abstract class Coder {

	/**
	 * BASE64解密。
	 * 
	 * @param cipherText
	 *            密文
	 * @return 明文
	 * @throws Exception
	 *             解密失败
	 */
	public static byte[] decryptBASE64(String cipherText) throws Exception {
		return (new BASE64Decoder()).decodeBuffer(cipherText);
	}

	/**
	 * 默认的String 与 Byte[] 互转是存在问题的 ： 即 一个 Byte[] 数组转换为 一个 str 后，
	 * str.getbytes()返回的 字节组，与 原先的数组不同
	 * 
	 * 可用base64编码解决
	 */

	/**
	 * BASE64加密。<br>
	 * BASE64：严格地说，属于编码格式，而非加密算法。<br>
	 * 按照RFC2045的定义，Base64被定义为：Base64内容传送编码被设计用来把任意序列的8位字节描述为一种不易被人直接识别的形式。<br>
	 * 常见于邮件、HTTP加密，截取HTTP信息，你就会发现登录操作的用户名、密码字段通过BASE64加密的。
	 * 
	 * @param plainData
	 *            明文
	 * @return 密文
	 * @throws Exception
	 *             加密失败
	 */
	public static String encryptBASE64(byte[] plainData) throws Exception {
		return (new BASE64Encoder()).encodeBuffer(plainData);
	}

	/**
	 * MD5加密。<br>
	 * MD5 -- message-digest algorithm 5 （信息-摘要算法）缩写，广泛用于加密和解密技术，常用于文件校验。<br>
	 * 通常我们不直接使用该方法加密，通常将MD5产生的字节数组交给BASE64再加密一把，得到相应的字符串。
	 * 
	 * @param plainData
	 *            明文数据
	 * @return 密文
	 * @throws Exception
	 *             加密失败
	 */
	public static byte[] encryptMD5(byte[] plainData) throws Exception {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		md5.update(plainData);
		return md5.digest();
	}

	/**
	 * MD5加密。
	 * 
	 * @param plainText
	 *            明文
	 * @return 密文
	 * @see #encryptMD5(byte[])
	 */
	public static String encryptMD5(String plainText) throws Exception {
		byte[] digest = Coder.encryptMD5(plainText.getBytes());
		return Coder.encryptBASE64(digest);
	}

	/**
	 * SHA加密。<br>
	 * SHA(Secure Hash Algorithm，安全散列算法），数字签名等密码学应用中重要的工具，被广泛地应用于电子商务等信息安全领域。
	 * <br>
	 * 虽然，SHA与MD5通过碰撞法都被破解了，但是SHA仍然是公认的安全加密算法，较之MD5更为安全。
	 * 
	 * @param plainData
	 *            明文数据
	 * @return 密文
	 * @throws Exception
	 *             加密失败
	 */
	public static byte[] encryptSHA(byte[] plainData) throws Exception {
		MessageDigest sha = MessageDigest.getInstance("SHA");
		sha.update(plainData);
		return sha.digest();
	}

	/**
	 * SHA加密。
	 * 
	 * @param plainText
	 *            明文
	 * @return 密文
	 * @see #encryptSHA(byte[])
	 */
	public static String encryptSHA(String plainText) throws Exception {
		byte[] digest = Coder.encryptSHA(plainText.getBytes());
		return Coder.encryptBASE64(digest);
	}

	/**
	 * MAC算法可选以下多种算法
	 * 
	 * <pre>
	 * HmacMD5   
	 * HmacSHA1   
	 * HmacSHA256   
	 * HmacSHA384   
	 * HmacSHA512
	 * </pre>
	 */
	public static final String KEY_MAC = "HmacMD5";

	/**
	 * 初始化HMAC密钥，用该方法来构建密钥
	 * 
	 * @return 密钥
	 * @throws Exception
	 *             失败
	 */
	public static String initMacKey() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);
		SecretKey secretKey = keyGenerator.generateKey();
		return encryptBASE64(secretKey.getEncoded());
	}

	/**
	 * HMAC加密。<br>
	 * HMAC(Hash Message Authentication Code，散列消息鉴别码，基于密钥的Hash算法的认证协议。<br>
	 * 消息鉴别码实现鉴别的原理是，用公开函数和密钥产生一个固定长度的值作为认证标识，用这个标识鉴别消息的完整性。<br>
	 * 使用一个密钥生成一个固定大小的小数据块，即MAC，并将其加入到消息中，然后传输。接收方利用与发送方共享的密钥进行鉴别认证等。
	 * 
	 * @param plainData
	 *            明文数据
	 * @param key
	 *            密钥
	 * @return 密文
	 * @throws Exception
	 *             加密失败
	 */
	public static byte[] encryptHMAC(byte[] plainData, String key) throws Exception {
		SecretKey secretKey = new SecretKeySpec(decryptBASE64(key), KEY_MAC);
		Mac mac = Mac.getInstance(secretKey.getAlgorithm());
		mac.init(secretKey);
		return mac.doFinal(plainData);
	}

	/**
	 * 获取解密后内容
	 * 
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public static String getSrouceCode(String code) throws Exception {
		byte[] output = Coder.decryptBASE64(code);
		String outputStr = new String(output);
		return outputStr;
	}

	/**
	 * 测试
	 * 
	 * @param args
	 * @throws Exception
	 *             测试失败
	 */
	public static void main(String[] args) throws Exception {
		// String inputStr1 = "xzswb@cdrcb.com";
		// System.out.println("原文:" + inputStr1);
		//
		// byte[] inputData = inputStr1.getBytes();
		// String code = Coder.encryptBASE64(inputData);
		// System.out.println("BASE64加密后:" + code);
		//
		// byte[] output = Coder.decryptBASE64(inputStr1);
		// String outputStr = new String(output);
		// System.out.println("BASE64解密后:" + outputStr);
	}
}
