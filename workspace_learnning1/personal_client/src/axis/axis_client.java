package axis;

import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

public class axis_client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String endpoint = "http://localhost:8080/personal_service/ws/file/FileUploadIServiceService";
		String namespaceURI = "http://cxf.WebService/";
		String methodname = "getName";
		Service service1 = new Service();
		try {
			
			Call call = (Call)service1.createCall();
			call.setTargetEndpointAddress(endpoint);
			call.setOperation(new QName(namespaceURI),methodname );
			call.addParameter("name", XMLType.XSD_STRING, ParameterMode.IN);
			call.setReturnType(XMLType.XSD_STRING);
			Object invoke = call.invoke(new Object[]{"tt"});
			System.out.println(invoke);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
