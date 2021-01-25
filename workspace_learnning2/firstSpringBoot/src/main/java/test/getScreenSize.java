package test;

import java.awt.Dimension;
import java.awt.Toolkit;

public class getScreenSize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dimension screenSize   =   Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		System.out.println("width:"+width+"height:"+height);

		// 屏幕的物理大小还需要知道屏幕的dpi 意思是说一英寸多少个象素
		double dpi = Toolkit.getDefaultToolkit().getScreenResolution();
		System.out.println("dpi:"+dpi);

		// 然后用象素除以dpi 就可以得到多少英寸了，在英寸转厘米
		// 1英寸(in)=2.54厘米(cm)

		double w = width/dpi;
		double h = height/dpi;

		System.out.println("width:" + w + "英寸");
		System.out.println("height:" + h + "英寸");

		double big = Math.sqrt(Math.pow(w, 2) + Math.pow(h, 2));

		System.out.println(big + "英寸");
	}

}
