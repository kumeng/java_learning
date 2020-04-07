package filter;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class testlistener 
	implements HttpSessionListener,HttpSessionActivationListener
	,HttpSessionAttributeListener,HttpSessionBindingListener
, ServletContextListener ,ServletContextAttributeListener {
	
	private  final Logger log = LoggerFactory.getLogger(testlistener.class);

	private int counts=0;
	
	@Override
	public void attributeAdded(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		log.info("ServletContextAttribute attributeAdded run  "+arg0.getName());
	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		log.info("ServletContextAttribute attributeRemoved run  "+arg0.getName());
	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		log.info("ServletContextAttribute attributeReplaced run  "+arg0.getName());
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		log.info("ServletContext contextDestroyed run  "+arg0.getServletContext().getServletContextName());
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		log.info("ServletContext contextInitialized run  "+arg0.getServletContext().getServletContextName());
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		log.info("HttpSession valueBound run  "+event.getName());
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		log.info("HttpSession valueUnbound run  "+event.getName());
	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		log.info("HttpSession attributeAdded run  "+arg0.getName());
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		log.info("HttpSession attributeRemoved run  "+arg0.getName());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		log.info("HttpSession attributeReplaced run  "+arg0.getName());
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		log.info("HttpSession sessionDidActivate run  "+arg0.getSession().getId());
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		log.info("HttpSession sessionWillPassivate run  "+arg0.getSession().getId());
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		counts++;
		log.info(counts+" HttpSession sessionCreated run  "+arg0.getSession().getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		counts--;
		log.info(counts+"HttpSession sessionDestroyed run  "+arg0.getSession().getId());
	}


}
