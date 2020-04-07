package FileUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class fileCopy {
	public static void copy(InputStream inputStream,OutputStream outputStream) throws IOException{
		BufferedInputStream  buffer = new BufferedInputStream(inputStream);
		int d=-1;
		while((d=buffer.read())!=-1){
			outputStream.write(d);
		}
		if(inputStream!=null){
			inputStream.close();
		}
		if(outputStream!=null){
			outputStream.close();
		}
	}
}
