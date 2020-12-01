package init;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

public class SpringApplicationContext implements ApplicationContext {

	public Environment getEnvironment() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean containsBeanDefinition(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public <A extends Annotation> A findAnnotationOnBean(String arg0, Class<A> arg1)
			throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return null;
	}

	public int getBeanDefinitionCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String[] getBeanDefinitionNames() {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getBeanNamesForAnnotation(Class<? extends Annotation> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getBeanNamesForType(Class<?> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String[] getBeanNamesForType(Class<?> arg0, boolean arg1, boolean arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Map<String, T> getBeansOfType(Class<T> arg0) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> Map<String, T> getBeansOfType(Class<T> arg0, boolean arg1, boolean arg2) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> arg0) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean containsBean(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public String[] getAliases(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getBean(String arg0) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T getBean(Class<T> arg0) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T getBean(String arg0, Class<T> arg1) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getBean(String arg0, Object... arg1) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T getBean(Class<T> arg0, Object... arg1) throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}

	public Class<?> getType(String arg0) throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isPrototype(String arg0) throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isSingleton(String arg0) throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isTypeMatch(String arg0, Class<?> arg1) throws NoSuchBeanDefinitionException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsLocalBean(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public BeanFactory getParentBeanFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMessage(MessageSourceResolvable arg0, Locale arg1) throws NoSuchMessageException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMessage(String arg0, Object[] arg1, Locale arg2) throws NoSuchMessageException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMessage(String arg0, Object[] arg1, String arg2, Locale arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	public void publishEvent(ApplicationEvent arg0) {
		// TODO Auto-generated method stub

	}

	public Resource[] getResources(String arg0) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	public ClassLoader getClassLoader() {
		// TODO Auto-generated method stub
		return null;
	}

	public Resource getResource(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getApplicationName() {
		// TODO Auto-generated method stub
		return null;
	}

	public AutowireCapableBeanFactory getAutowireCapableBeanFactory() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public ApplicationContext getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getStartupDate() {
		// TODO Auto-generated method stub
		return 0;
	}

}
