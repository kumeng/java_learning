package javabase.security.encrypt;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class AES_encrypt {
	
	static Cipher cipher;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	static void menthod1(String plainstr,String arg0,String arg1) 
			throws NoSuchAlgorithmException, NoSuchPaddingException{
		//传入模式代号
		cipher = Cipher.getInstance(arg0);
		//KeyGenerator     生成密钥
		SecretKey generateKey = KeyGenerator.getInstance(arg1).generateKey();
		System.out.println("密钥："+generateKey+" 长度："+generateKey.getEncoded().length);
	}

}
