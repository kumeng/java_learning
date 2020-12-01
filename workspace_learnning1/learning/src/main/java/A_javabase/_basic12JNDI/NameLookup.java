package A_javabase._basic12JNDI;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * 访问  命名服务
 * @author Administrator
 *
 */
public class NameLookup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.setProperty("CFX", "fghgfh");
			Context  ctx = new InitialContext(System.getProperties());
			Object lookup = ctx.lookup("CFX");
			System.out.println(lookup);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
