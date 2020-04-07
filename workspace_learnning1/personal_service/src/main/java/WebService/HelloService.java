package WebService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.spi.Provider;

@WebService
public class HelloService  implements ServiceHello {

	/**
	 * 供客户端调用
	 * @param name
	 * @return
	 */
	@WebMethod
	public String getName(String name){
		return name+"tttttttt";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endpoint publish = Endpoint.publish("http://localhost:9001/Service/HelloService", new HelloService());
		//默认服务名称  类名 +Service后缀  ，本次默认发布后  服务名称 为{http://WebService/}HelloServiceService
		
//		http://localhost:9001/Service/HelloService  查看发布服务名称，端口信息
//		http://localhost:9001/Service/HelloService?wsdl
		
//		publish.stop();
		System.out.println("HelloService publish success!");
	}

	
	/**
	 * 1、右键编译次服务类 ，成功后
	 * http://localhost:9001/Service/HelloService 发布的路径再加上   ?wsdl  
	 * 既访问 http://localhost:9001/Service/HelloService?wsdl 成功 表示发布成功
	 * 2、创建客户端应用，用以下 命令提示窗口执行生成命令。生成代码到客户端应用
	 * cd  F:\workspace4.5_2\personal_service\WebService\     F:    两个命令在dos环境下切换到 WebService目录下
格式：wsimport -s "src目录" -p “生成类所在包名” -keep “wsdl发布地址”
示例：
wsimport -s F:\\workspace4.5_2\\personal_client\\src -p WebServiceClient -keep http://localhost:9001/Service/HelloService?wsdl

执行后，刷新客户端应用，查看时候成功，并在客户端测试，是否可以访问
	 */
}
