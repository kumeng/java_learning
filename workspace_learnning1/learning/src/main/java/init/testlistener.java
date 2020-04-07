package init;

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

	public void attributeAdded(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		log.info("attributeAdded run  "+arg0.getName());
	}

	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		log.info("attributeRemoved run  "+arg0.getName());
	}

	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		// TODO Auto-generated method stub
		log.info("attributeReplaced run  "+arg0.getName());
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		log.info("contextDestroyed run  "+arg0.getServletContext().getServletContextName());
	}

	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		log.info("contextInitialized run  "+arg0.getServletContext().getServletContextName());
	}

	public void valueBound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		log.info("valueBound run  "+event.getName());
	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		log.info("valueUnbound run  "+event.getName());
	}

	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		log.info("attributeAdded run  "+arg0.getName());
	}

	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		log.info("attributeRemoved run  "+arg0.getName());
	}

	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		log.info("attributeReplaced run  "+arg0.getName());
	}

	public void sessionDidActivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		log.info("sessionDidActivate run  "+arg0.getSession().getId());
	}

	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		log.info("sessionWillPassivate run  "+arg0.getSession().getId());
	}

	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		log.info("sessionCreated run  "+arg0.getSession().getId());
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		log.info("sessionDestroyed run  "+arg0.getSession().getId());
	}


}
