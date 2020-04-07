package testprocess;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jbpm.api.Configuration;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.task.Task;
import org.junit.Test;
/**
 * 组任务与分配
 * @author Administrator
 *
 */
public class ProcessTest2 {
	   private static ProcessEngine processEngine = Configuration.getProcessEngine();  
	   
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
	        Map<String, Object> variables = new HashMap<String, Object>();  
	        variables.put("manager", "王经理");  
	        variables.put("userIds", "小A,小B,小C,小D");  
	    ProcessInstance pi = processEngine.getExecutionService().startProcessInstanceByKey("test", variables);  
	        System.out.println("流程实例启动完毕：processInstanceId = " + pi.getId());  
	    }  
	  
	    // 查询组任务列表  
	    @Test  
	    public void testFindMyGroupTaskList() throws Exception {  
	        String userId = "王工程师";  
	        // String userId = "赵工程师";  
	        // 查询  
	        // List<Task> list = processEngine.getTaskService().findGroupTasks(userId);  
	        // 分页  
	        List<Task> list = processEngine.getTaskService()//  
	                .createTaskQuery()//  
	                .candidate(userId)// 指定候选人，这是查询组任务  
	                .page(0, 100)// 分页  
	                .list();  
	  
	        // 显示  
	        System.out.println("====== " + userId + "的个人任务列表 ======");  
	        for (Task task : list) {  
	            System.out.println("id=" + task.getId()//  
	                    + ", name=" + task.getName()//  
	                    + ", assignee=" + task.getAssignee()//  
	                    + ", createTime=" + task.getCreateTime()//  
	                    + ", executionId=" + task.getExecutionId());  
	        }  
	    }  
	  
	    // 拾取任务  
	    @Test  
	    public void testTakeTask() throws Exception {  
	        String taskId = "310009";  
	        String userId = "王工程师";  
	        processEngine.getTaskService().takeTask(taskId, userId);  
	    }  
	  
	    // 查询个人任务列表  
	    @Test  
	    public void testFindMyPersonalTaskList() throws Exception {  
	        String userId = "王工程师";  
	  
	        // 查询  
	        // List<Task> list = processEngine.getTaskService().findPersonalTasks(userId);  
	        // 分页  
	        List<Task> list = processEngine.getTaskService()//  
	                .createTaskQuery()//  
	                .assignee(userId)// 指定办理人条件  
	                .page(0, 100)// 分页  
	                .list();  
	  
	        // 显示  
	        System.out.println("====== " + userId + "的个人任务列表 ======");  
	        for (Task task : list) {  
	            System.out.println("id=" + task.getId()//  
	                    + ", name=" + task.getName()//  
	                    + ", assignee=" + task.getAssignee()//  
	                    + ", createTime=" + task.getCreateTime()//  
	                    + ", executionId=" + task.getExecutionId());  
	        }  
	    }  
	  
	    // 直接指定任务的办理人  
	    @Test  
	    public void testAssignTask() throws Exception {  
	        String taskId = "310009";  
	        // String userId = null; // 退回到组任务列表  
	        String userId = "赵工程师";  
	        processEngine.getTaskService().assignTask(taskId, userId);  
	    }  
	  
	}  

