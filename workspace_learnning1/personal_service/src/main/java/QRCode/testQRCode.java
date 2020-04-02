package QRCode;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class testQRCode {
	public static void main(String[] args ){
		Writer qw = new QRCodeWriter();
		try {
			 Map<EncodeHintType, String> hints = new HashMap<EncodeHintType, String>();
			 hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
			 String path = "D://test.png"; 
			BitMatrix encode = qw.encode("this fist QRCode ,仙居", BarcodeFormat.QR_CODE, 400, 400,hints);
			File file = new File(path); 
		      writeToFile(encode, "png", file); 
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	private static void writeToFile(BitMatrix encode, String format, File file) throws IOException {
		// TODO Auto-generated method stub
		int width = encode.getWidth();
	     int height = encode.getHeight();
	     BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	     for (int x = 0; x < width; x++) {
	       for (int y = 0; y < height; y++) {
	         image.setRGB(x, y,encode.get(x, y) ? Color.BLACK.getRGB():Color.WHITE.getRGB());
	         
	       }
	     }		
	     ImageIO.write(image, format, file);
	}
	
	
	/**
	 * rgb颜色设置
	 */
/*	每一个rgb颜色都对应一个int数值，所以我们可以这么设置： 
	private static final int default_background_color = Color.rgb(0, 0, 0); 
	如何调用这个颜色值呢？ 
	比如我们要设置背景颜色，则可以使用 
	imageview.setBackgroundColor(Color.parseColor(“#f34649”));

	imageview.setBackgroundColor(Color.rgb(213, 0, 0));

	imageview.setBackgroundColor(default_background_color );

	2. 常用颜色的RGB值

	白色：rgb(255,255,255)

	黑色：rgb(0,0,0)

	红色：rgb(255,0,0)

	绿色：rgb(0,255,0)

	蓝色：rgb(0,0,255)

	青色：rgb(0,255,255)

	紫色：rgb(255,0,255)	*/

}
