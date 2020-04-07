package utils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class UtilsImage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		 TODO Auto-generated method stub
/*		new UtilsImage().pressText("我是测试水印文字","/home/zcbase/nfs/2017/12/13/16pic_1647532_b_1513214676015.jpg", "/home/zcbase/nfs/2017/12/13/new.jpg", "default", Font.BOLD, 38, Color.WHITE, 0, 0, 0.4f);
		*/
//		16pic_1647532_b - 副本.bmp
		new UtilsImage().pressImage("/home/zcbase/nfs/2017/12/13/16pic_1647532_b - 副本.bmp"
//				/farms2/src/main/webapp/home/zcbase/nfs/xzyzgl/yingmowhite.jpg
				,"/home/zcbase/nfs/2017/12/13/yingmowhite.jpg"
				,"/home/zcbase/nfs/2017/12/13/new电饭锅2.jpg"
				,"jpg",0.5,0.5,0.9f);
		
	}
	public void pressText(String pressText,String srcImageFile,String destImageFile,String suffix,
			String fontName,int fontStyle,int fontsize,Color color,int x,int y,float alpha){
		
		try {
			File imgsrc = new File(srcImageFile);
			
			Image src = ImageIO.read(imgsrc);
			int width = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage  bfimg = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			Graphics2D  g = bfimg.createGraphics();
			g.drawImage(src, 0, 0, width, height, null);
			g.setColor(color);			
			g.setFont(new java.awt.Font(fontName,fontStyle,fontsize));
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));			
			int wh = width- getLength(pressText)*fontsize-x;
			int ht = height-fontsize-y;
			if(wh<1||ht<1){
				throw new IOException("图片太小或者，水印文字过长");
			} 
			g.drawString(pressText, wh/2, ht/2);			
			g.dispose();
			ImageIO.write( bfimg, suffix,new File(destImageFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
/**
 * 	在图片上画上水印图片
 * @param srcImageFile  原始图片
 * @param opImageFile    要附贴的图片
 * @param destImageFile   产生的目标图片
 * @param subffix        目标图片后缀
 * @param color         颜色
 * @param d  偏移量   百分比的实际值，，例：100%:1,50%:0.5
 * @param f  意义同x，   x/y 方向同数学上的x/y轴 
 * @param alpha         透明度
 */
	public void pressImage(String srcImageFile,String opImageFile,String destImageFile
			,String suffix,double d,double f,float alpha){
		
		try {
			File imgsrc = new File(srcImageFile);
			Image src = ImageIO.read(imgsrc);
			int width = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage  bfimg = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			Graphics2D  g = bfimg.createGraphics();
			g.drawImage(src, 0, 0, width, height, null);
			
			File imgop = new File(opImageFile);		
			Image op = ImageIO.read(imgop);	
			int width_op = op.getWidth(null);
			int height_op = op.getHeight(null);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			int wh = (int) (d*(width- width_op));
			int ht = (int) (f*(height-height_op));
			if(wh<0||ht<0||wh>width||ht>height){
				throw new IOException("图片太小限制或者偏移量超出限制");
			}	
			g.drawImage(op, wh, ht, width_op, height_op, null);
			g.dispose();
			ImageIO.write(bfimg,suffix,new File(destImageFile));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}	
	public void pressImage(File imgsrc,String opImageFile,File destImageFile
			,String suffix,double d,double f,float alpha){
		
		try {
			Image src = ImageIO.read(imgsrc);
			int width = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage  bfimg = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			Graphics2D  g = bfimg.createGraphics();
			g.drawImage(src, 0, 0, width, height, null);
			
			File imgop = new File(opImageFile);	
			if(!imgop.exists()){
				throw new IOException(opImageFile+"文件不存在");
			}
			Image op = ImageIO.read(imgop);	
			int width_op = op.getWidth(null);
			int height_op = op.getHeight(null);
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			int wh = (int) (d*(width- width_op));
			int ht = (int) (f*(height-height_op));
			if(wh<0||ht<0||wh>width||ht>height){
				throw new IOException("图片太小限制或者偏移量超出限制");
			}	
			g.drawImage(op, wh, ht, width_op, height_op, null);
			g.dispose();
			ImageIO.write(bfimg,suffix,destImageFile);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}		
	public void pressText(String pressText,File imgsrc,String subffix,File destImageFile,
			String fontName,int fontStyle,int fontsize,Color color,int x,int y,float alpha){
		
		try {			
			Image src = ImageIO.read(imgsrc);
			int width = src.getWidth(null);
			int height = src.getHeight(null);
			BufferedImage  bfimg = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
			Graphics2D  g = bfimg.createGraphics();
			g.drawImage(src, 0, 0, width, height, null);
			g.setColor(color);			
			g.setFont(new java.awt.Font(fontName,fontStyle,fontsize));
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			int wh = width- getLength(pressText)*fontsize-x;
			int ht = height-fontsize-y;
			if(wh<1||ht<1){
				throw new IOException("图片太小或者，水印文字过长");
			}
			g.drawString(pressText, wh/2, ht/2);
			g.dispose();
			ImageIO.write( bfimg, subffix,destImageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}	
    /**
     * 计算text的长度（一个中文算两个字符）
     * @param text
     * @return
     */
    public final static int getLength(String text) {
        int length = 0;
        for (int i = 0; i < text.length(); i++) {
            if (new String(text.charAt(i) + "").getBytes().length > 1) {
                length += 2;
            } else {
                length += 1;
            }
        }
        return length / 2;
    }	
}
