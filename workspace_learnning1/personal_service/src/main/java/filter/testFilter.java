package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class testFilter implements Filter {
	
	private  final Logger log =  LoggerFactory.getLogger(testFilter.class);
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
		log.info("destroy run.."+System.currentTimeMillis());
				
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("doFilter run.."+System.currentTimeMillis());
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
		log.info("init run..InitParameterNames:"+System.currentTimeMillis()+arg0.getInitParameterNames().toString());
		
	}

}
