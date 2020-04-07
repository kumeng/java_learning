package Annotaion.My_Annotaion;

import java.lang.reflect.Field;

/**
 * 模拟注解处理器，打印Person信息
 * @author Administrator
 * 
 * 注解处理器类库(java.lang.reflect.AnnotatedElement)
 * 接口主要有如下几个实现类：

        Class：类定义

        Constructor：构造器定义

        Field：累的成员变量定义

        Method：类的方法定义

        Package：类的包定义
        
AnnotatedElement   

接口提供了以下四个方法来访问Annotation的信息：

        方法1：<T extends Annotation> T getAnnotation(Class<T> annotationClass): 
        返回改程序元素上存在的、指定类型的注解，如果该类型注解不存在，则返回null。

        方法2：Annotation[] getAnnotations():
        返回该程序元素上存在的所有注解。

        方法3：boolean is AnnotationPresent(Class<?extends Annotation> annotationClass):
        判断该程序元素上是否包含指定类型的注解，存在则返回true，否则返回false.

        方法4：Annotation[] getDeclaredAnnotations()：
        返回直接存在于此元素上的所有注释。与此接口中的其他方法不同，该方法将忽略继承的注释。
        （如果没有注释直接存在于此元素上，则返回长度为零的一个数组。）该方法的调用者可以随意修改返回的数组；这不会对其他调用者返回的数组产生任何影响。        
 *
 */
public class printPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getInfo(Person.class);
	}

    public static void getInfo(Class<?> clazz) {  
        String profile = "";  
        Field fields[] = clazz.getDeclaredFields();  
        for (Field field : fields) {  
            if (field.isAnnotationPresent(Profile.class)) {  
                Profile arg0 = field.getAnnotation(Profile.class);  
                profile = "[id=" + arg0.id() +  ",gander=" + arg0.gander().toString() + "]";  
                System.out.println("Profile:"+profile);
            }  
        }  
    }  	
}
