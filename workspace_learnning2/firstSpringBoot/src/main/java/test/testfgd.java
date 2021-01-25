package test;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

public class testfgd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = new String("sdf");
		System.out.println(string.toString());
		System.out.println(string.getClass().getClassLoader());

		String2 string2 = new String2("sdf");
		System.out.println(string2.toString());
		System.out.println(string2.getClass().getClassLoader());
		System.out.println(string2.getClass().getClassLoader().getParent());
		System.out.println(string2.getClass().getClassLoader().getParent().getParent());	
		
//		try {
//			Robot robot = new Robot();
////			robot.mouseMove(100, 100);
//			Dimension screenSize   =   Toolkit.getDefaultToolkit().getScreenSize();			
//			Rectangle screenRect = new Rectangle(0,0,(int)screenSize.getWidth(),(int)screenSize.getHeight());
//			BufferedImage bufferedImage = robot.createScreenCapture(screenRect);
//			File file = new File("M:\\test.jpg");
//			OutputStream ot = new FileOutputStream(file);
//			ImageIO.write(bufferedImage, "jpg", ot);
//			 
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
