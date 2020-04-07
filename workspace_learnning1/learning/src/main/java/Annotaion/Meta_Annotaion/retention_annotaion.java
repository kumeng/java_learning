package Annotaion.Meta_Annotaion;

/**
 *      @Retention

        定义了该Annotation被保留的时间长短：某些Annotation仅出现在源代码中，而被编译器丢弃；
        而另一些却被编译在class文件中；编译在class文件中的Annotation可能会被虚拟机忽略，
        而另一些在class被装载时将被读取（请注意并不影响class的执行，因为Annotation与class在使用上是被分离的）
        
        。使用这个meta-Annotation可以对 Annotation的“生命周期”限制。

        作用：表示需要在什么级别保存该注释信息，用于描述注解的生命周期（即：被描述的注解在什么范围内有效）

        RetentionPoicy取值

                1.SOURCE:在源文件中有效（即源文件保留）

                2.CLASS:在class文件中有效（即class保留）

                3.RUNTIME:在运行时有效（即运行时保留）
 * @author Administrator
 *
 */
public class retention_annotaion {

}
