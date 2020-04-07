package testprocess;

import org.jbpm.api.model.OpenExecution;
import org.jbpm.api.task.Assignable;
import org.jbpm.api.task.AssignmentHandler;
/**
 * 分配任务
 * @author Administrator
 *
 */
public class AssignmentHandlerImpl implements AssignmentHandler {

	@Override
	public void assign(Assignable assignable, OpenExecution execution)
			throws Exception {
		// TODO Auto-generated method stub
        System.out.println("---> AssignmentHandlerImpl.assign()");  
        // 计算办理人  
        String userId = "李经理--";  
  
        // 分配个人任务  
        assignable.setAssignee(userId); // 指定个人任务的办理人  
  
        // // 分配组任务  
        // assignable.addCandidateUser("小A"); // 添加一个候选人（组任务）  
        // assignable.addCandidateUser("小B"); // 添加一个候选人（组任务）  
        // assignable.addCandidateUser("小C"); // 添加一个候选人（组任务）  
	}

}
