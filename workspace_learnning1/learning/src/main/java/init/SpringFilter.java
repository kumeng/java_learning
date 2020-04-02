package init;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

public class SpringFilter implements Filter {

	private final Logger   log = (Logger) LoggerFactory.getLogger(this.getClass());
	
	public void destroy() {
		// TODO Auto-generated method stub
		
		log.debug("destroy");
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.debug("doFilter");
		arg2.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		log.warn("init");
		log.trace("init");
		log.info("init");
		log.error("init");
		log.debug("init"+ arg0.getFilterName());
		ServletContext servletContext = arg0.getServletContext();
		System.out.println(servletContext.toString()); 
	}

}
