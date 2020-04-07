package WebService.cxf;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlMimeType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.ws.soap.MTOM;

/**
 *cxf文件传输接口
 * @author 20171230
 *
 */

@MTOM   //注意点一  开启文件传输 支持
@WebService(serviceName="fileUploadIService3",targetNamespace="file3")
public interface FileUploadIService {	
	/**
	 * 简单测试文件传输。。实际工作，肯定要考虑附件管理的问题。。最好把文件的信息(路径，文件名，上传人等)写到数据库，，通过主键id来取文件
	 * @param path
	 * @return
	 */
	@WebResult(name="dataHandler")
	@XmlMimeType(value="*/*")  //注意点二  设置mime类型    任意类型
	public DataHandler downFile(@WebParam(name="path")String path);
	
	 //注意点三 上传时 文件数据也要  设置mime类型    任意类型
	public void   uploadFile(@WebParam(name="dataHandler")@XmlMimeType(value="*/*")DataHandler dataHandler,@WebParam(name="path")String path);
	
	@WebResult(name="returnstr")
	@WebMethod
	public String getName(@WebParam(name="name")String name);
}
