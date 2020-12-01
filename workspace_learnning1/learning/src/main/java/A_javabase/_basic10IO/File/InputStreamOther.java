package A_javabase._basic10IO.File;

public class InputStreamOther {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void tes1(){
		/**
		 * //		java.io.PipedInputStream  java.io.PipedOutputStream
		 * 成对存在，对接传递字节
		 */
		
	}
	public void tes2(){
		/**
		 * //		java.io.SequenceInputStream  队列输入流，
		 *
		 */
		
	}	
	public void tes3(){
		/**
		 * //		java.io.StringBufferInputStream 建议不用，
		 *
		 */
		java.io.ByteArrayOutputStream byteout = new java.io.ByteArrayOutputStream();
		java.io.ByteArrayInputStream  byteintput = new java.io.ByteArrayInputStream(new byte[1024]);
	}		

}
