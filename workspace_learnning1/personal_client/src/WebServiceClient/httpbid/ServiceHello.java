
package WebServiceClient.httpbid;

import javax.jws.WebMethod;
import javax.jws.WebService;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "HelloService", targetNamespace = "http://WebService/")
public interface ServiceHello {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    public String getName(String arg0);

}
