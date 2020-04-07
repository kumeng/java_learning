package WebService.cxf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.jws.WebService;

import FileUtils.fileCopy;

@WebService(endpointInterface="WebService.cxf.FileUploadIService")
public class FileUploadService implements FileUploadIService {

	@Override
	public DataHandler downFile(String path) {
		// TODO Auto-generated method stub
		
		File file = new File(path);
		FileDataSource  fileDataSource = new FileDataSource(file);
		DataHandler  datahanlder = new DataHandler(fileDataSource);
		return datahanlder;
	}

	@Override
	public void uploadFile(DataHandler dataHandler, String path) {
		// TODO Auto-generated method stub
		File file = new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
		try {
			FileOutputStream outPutstream = new FileOutputStream(file);
			InputStream inputStream = dataHandler.getInputStream();
			fileCopy.copy(inputStream, outPutstream);			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String getName(String name) {
		// TODO Auto-generated method stub
		return name.concat("whtfunck");
	}

}
