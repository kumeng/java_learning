package testprocess;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jbpm.api.Configuration;
import org.jbpm.api.ProcessDefinition;
import org.jbpm.api.ProcessDefinitionQuery;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.task.Task;
import org.junit.Test;

public class testproce {
	private static ProcessEngine  processEngine 
	= new Configuration().setResource("jbpm.cfg.xml").buildProcessEngine();

	@Test
	public void initProcessEngine(){
		processEngine = new Configuration().setResource("jbpm.cfg.xml").buildProcessEngine();
	} 

	// 启动流程实例  
	// jbpm4_execution  
	@Test  
	public void testStartProcessInstance() throws Exception {  
		
		

//	    使用默认的配置文件生成processEngine对象
		//ProcessEngine  processEngine2 = new Configuration().buildProcessEngine();
		// 指定配置文件生成processEngine对象

//		通过默认的配置文件生成单例的processEngine对象
		//ProcessEngine  processEngine3 = Configuration.getProcessEngine();
		
		//发布流程
		deployProcessDefinition();
		
		// 启动流程实例
		//流程实例：代表工作流的一次执行，是一种动态的过程。
		//需要获得流程实例对象的时候
		ProcessInstance   processInstance = processEngine.getExecutionService()
				.startProcessInstanceByKey("TakingLeave");
	}
	
	//流程定义：是这一次流程的步骤的说明,是对工作流程的静态式的说明信息。
    @Test  
    public void deployProcessDefinition()  
    {  
        String reponseStr = processEngine.getRepositoryService()//  
            .createDeployment()//  
            .addResourceFromClasspath("testprocess/请假流程.jpdl.xml")//这里目录需要根据自己的目录确定  
            .setTimestamp(System.currentTimeMillis())
            .deploy();        
        System.out.println(reponseStr);// 10001  
    } 	
    /**
     * 无法获取地址时，比如客户端提交的文件发布流程。
     * name  文件名   eg:请假流程.jpdl.xml
     * file  二进制文件     fdgfdgfgdgt.tmp
     * contentType 文件类型     text/xml
     */
//	public String deploy(String name, File file, String contentType) {
//		String result = null;
//		try {
//			File baseDir = new File(ServletActionContext.getServletContext()
//					.getRealPath(FarmsConstants.file_path_jbpm));
//			// 判断文件存储目录是否存在
//			if (!baseDir.exists()) {
//				baseDir.mkdirs();
//			}
//			File newFile = new File(baseDir, name);
//			FileUtils.copyFile(file, newFile);
//			JBPMWFServiceClient client = new JBPMWFServiceClient(null);
//			ProcessEngine processEngine = client.getProcessEngine();
//			RepositoryService repositoryService = processEngine
//					.getRepositoryService();
//			NewDeployment newDeployment = repositoryService.createDeployment();
//			newDeployment.setName(name);
//			newDeployment.setTimestamp(System.currentTimeMillis());
//			// newDeployment.addResourceFromFile(getFile(name,file,
//			// contentType));
//			client.execute(new AddDeployFileCmd((DeploymentImpl) newDeployment,
//					newFile));
//			result = newDeployment.deploy();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return result;
//	}    
    
	    // 查询任务列表   通过findPersonalTasks("person")可以获得具体的个人的任务列表
	@Test  
	public void findTaskList( ) {  
	 List<Task> taskList = processEngine.getTaskService().findPersonalTasks("员工");  
	 System.out.println("个人任务列表");  
	 System.out.println(taskList);  
	 for(Task task : taskList)  
	 {  
	     System.out.println("id= " + task.getId() + ", name = " + task.getName() + ", assignee = " + task.getAssignee());  
	 }  
	}      
	
	// 查询所有  流程定义
	@Test  
	public void findAll() throws Exception {  
	    // 查询  
	    List<ProcessDefinition> list = processEngine.getRepositoryService()//  
	            .createProcessDefinitionQuery()//  
	            // 过滤条件  
	            // .processDefinitionKey("")//  
	            // .processDefinitionNameLike("%xx%")//  
	            // 排序条件  
	            // .orderAsc(ProcessDefinitionQuery.PROPERTY_KEY)//  
	            // .orderDesc(ProcessDefinitionQuery.PROPERTY_VERSION)//  
	            // 执行查询  
	            // .uniqueResult();  
	            // .count();  
	            // .page(firstResult, maxResults)//  
	            .list();  
	  
	    // 显示  
	    for (ProcessDefinition pd : list) {  
	    System.out.println("id=" + pd.getId()// 格式为：{key}-{version}，用于唯一的标识一个流程定义  
	    + ", name=" + pd.getName()// 流程定义的名称，jpdl.xml中根元素的name属性的值  
	    + ", key=" + pd.getKey()// 流程定义的key，jpdl.xml中根元素的key属性的值，默认是name属性的值  
	    + ", version=" + pd.getVersion()// 自动生成的，同一个名称的第一个为1，以后的自动加1.  
	    + ", deploymentId=" + pd.getDeploymentId()); // 所属的部署对象  
	    }  
	}  
	 // 查询所有最新版本的流程定义  
	@Test  
	public void findAllLatestVersions() throws Exception {  
	    // 查询所有，让所有最大的版本都排到最后面  
	    List<ProcessDefinition> all = processEngine.getRepositoryService()//  
	            .createProcessDefinitionQuery()//  
	            .orderAsc(ProcessDefinitionQuery.PROPERTY_VERSION)//  
	            .list();  
	  
	    // 过滤出所有最新的版本  
	    Map<String, ProcessDefinition> map = new HashMap<String, ProcessDefinition>();  
	    for (ProcessDefinition pd : all) {  
	        map.put(pd.getKey(), pd);  
	    }  
	  
	    // 显示  
	    for (ProcessDefinition pd : map.values()) {  
	    System.out.println("id=" + pd.getId()// 格式为：{key}-{version}，用于唯一的标识一个流程定义  
	    + ", name=" + pd.getName()// 流程定义的名称，jpdl.xml中根元素的name属性的值  
	    + ", key=" + pd.getKey()// 流程定义的key，jpdl.xml中根元素的key属性的值，默认是name属性的值  
	    + ", version=" + pd.getVersion()// 自动生成的，同一个名称的第一个为1，以后的自动加1.  
	    + ", deploymentId=" + pd.getDeploymentId()); // 所属的部署对象  
	    }  
	}  	

	// 删除  流程定义
	@Test  
	public void deleteById() throws Exception {  
	    String deploymentId = "1";  
	  
	    // // 删除指定的部署对象（流程定义），如果有关联的执行信息，就会报错  
	    // processEngine.getRepositoryService().deleteDeployment(deploymentId);  
	  
	    // 删除指定的部署对象（流程定义），如果有关联的执行信息，会被同时删除  
	    processEngine.getRepositoryService().deleteDeploymentCascade(deploymentId);  
	}
	
	// 删除指定key的所有版本的流程定义  
	@Test  
	public void deleteByKey() throws Exception {  
	    // 查询出指定key的所有版本的流程定义  
	    List<ProcessDefinition> list = processEngine.getRepositoryService()//  
	            .createProcessDefinitionQuery()//  
	            .processDefinitionKey("helloworld")//  
	            .list();  
	  
	    // 一一删除  
	    for (ProcessDefinition pd : list) {  
	        processEngine.getRepositoryService().deleteDeploymentCascade(pd.getDeploymentId());  
	    }  
	}  	
	    // 查看流程图（xxx.png）  
	@Test  
	public void getImageResource() throws Exception {  
	   String deploymentId = "50001";  
	   String resourceName = "helloworld/helloworld.png";  
	 
	   // 获取指定部署对象中的所有资源的名称  
	   Set<String> names = processEngine.getRepositoryService().getResourceNames(deploymentId);  
	   System.out.println("所有的资源名称：");  
	   for (String name : names) {  
	       System.out.println("\t" + name);  
	   }  
	 
	   // 获取指定部署对象中的指下资源的内容  
	InputStream in = processEngine.getRepositoryService().getResourceAsStream(deploymentId, resourceName);  
	 
	   // 保存到c盘  
	   OutputStream out = new FileOutputStream("c:/process.png");  
	   for (int b = -1; (b = in.read()) != -1;) {  
	       out.write(b);  
	   }  
	   in.close();  
	   out.close();  
	}  	
	
	// 向后执行一步  
	@Test  
	public void testSignalExecution() throws Exception {  
	    String executionId = "test.130001";  
	    processEngine.getExecutionService().signalExecutionById(executionId);  
	  
	                        // processEngine.getExecutionService().signalExecutionById(executionId, parametersMap);                         // 离开前先设置一些流程变量  
	             // processEngine.getExecutionService().signalExecutionById(executionId, signalName);                            // 使用指定名称的Transition离开本活动  
	     // processEngine.getExecutionService().signalExecutionById(executionId, signalName, parameters)                         // 离开前先设置一些流程变量，再使用指定名称的Transition离开本活动  
	  
	}  	
	
	// 办理任务  
	@Test  
	public void testCompleteTask() throws Exception {  
	    String taskId = "130002";  
	    processEngine.getTaskService().completeTask(taskId);  
	}  
	// 设置流程变量  
	@Test  
	public void testSetVariable() throws Exception {  
	    String executionId = "test.150001";  
	    processEngine.getExecutionService().setVariable(executionId, "请假天数", 15);  
	}  
	// 获取流程变量  
	@Test  
	public void testGetVariable() throws Exception {  
	    String executionId = "test.150001";  
	Integer days = (Integer) processEngine.getExecutionService().getVariable(executionId, "请假天数");  
	    System.out.println("请假天数 = " + days);  
	}  
/*    {  
        ExecutionService executionService = processEngine.getExecutionService();  
        TaskService taskService = processEngine.getTaskService();  
  
        // ============ 设置变量 ========================  
        executionService.setVariable(executionId, name, value); // 设置一个变量  
        executionService.setVariables(executionId, variablesMap); // 设置多个变量  
        taskService.setVariables(taskId, variables); // 设置多个变量  
  
                executionService.startProcessInstanceByKey(processDefinitionKey, variablesMap);                                 // 启动流程实例时，先设置一些变量  
        taskService.completeTask(taskId, variablesMap); // 真正办理完任务前先设置一些变量  
          
          
        // ============ 获取变量 ========================  
        executionService.getVariable(executionId, variableName); // 获取一个变量  
        executionService.getVariableNames(executionId); // 返回Set<String>，是所有变量的名称集合  
        executionService.getVariables(executionId, variableNames);                                                       //获取多个变量，返回Map<String,Object>，表示指定名称的变量信息  
      
        taskService.getVariable(taskId, variableName);  
        taskService.getVariableNames(taskId);  
        taskService.getVariables(taskId, variableNames);  
    }  */	
	 @Test  
	 public void testProcess() throws Exception {  
	     // 部署流程定义  
	     InputStream in = this.getClass().getResourceAsStream("test.jpdl.xml");  
	     String deploymentId = processEngine.getRepositoryService()//      
	             .createDeployment()//  
	             .addResourceFromInputStream("test.jpdl.xml", in)//  
	             .deploy();  
	     System.out.println("部署流程定义完毕：deploymentId = " + deploymentId);  
	   
	     // 启动流程实例  
	     ProcessInstance pi = processEngine.getExecutionService().startProcessInstanceByKey("test");  
	     System.out.println("流程实例启动完毕：processInstanceId = " + pi.getId());  
	   
	     // 完成第一步“提交申请”的任务，要使用指定的Transition离开当前活动  
	     Task task = processEngine.getTaskService()//  
	             .createTaskQuery()// 获取本流程实例中当前情况下仅有的一个任务  
	             .processInstanceId(pi.getId())//  
	             .uniqueResult();  
	   
	     String transitionName1 = "to 部门经理审批";  
	     String transitionName2 = "to 总经理审批";  
	     processEngine.getTaskService().completeTask(task.getId(), transitionName2);                                     // 使用指定名称的Transition离开本活动  
	 }  	
}
