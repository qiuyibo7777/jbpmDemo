package com.jbpm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jbpm.api.Configuration;
import org.jbpm.api.Execution;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;
import org.jbpm.api.model.ActivityCoordinates;
import org.jbpm.api.task.Task;
import org.jbpm.pvm.internal.processengine.SpringProcessEngine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jbpm.entity.AskFor;
import com.jbpm.entity.AskForTask;

public class TaskOperateService {
	
	private ProcessEngine processEngine = null;
	private RepositoryService repositoryService = null;
	private ExecutionService executionService = null;
	private ProcessInstance processInstance = null;
	private Execution execution = null;
	private TaskService taskService = null;
	private List<Task> taskList = null;
	private Task task = null;
	
	public TaskOperateService(String flowFileName){
		initProcess();
		repositoryService = processEngine.getRepositoryService();
		executionService = processEngine.getExecutionService();
		taskService = processEngine.getTaskService();
		String porcessDeploymentId = repositoryService.createDeployment().addResourceFromClasspath("askFor.jpdl.xml").addResourceFromClasspath("askFor.png").deploy();
		System.out.println("部署流程ID："+porcessDeploymentId);
	}
	
	/**
	 * 初始ProcessEngine
	 * 流程引擎(ProcessEngine), 服务接口可以从 ProcessEngine中获得，它是从 Configuration 构建的
	 * 配合spring，从spring中获取
	 */
	public void initProcess(){
		processEngine = new Configuration().buildProcessEngine();
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		processEngine=(ProcessEngine) ctx.getBean("processEngine",SpringProcessEngine.class);
	}
	
	/**
	 * 通过任务的名字获取该名字的所有任务列表
	 * @param name
	 * @return
	 */
	public List<Map<String,Object>> getTasks(String name){
		taskList = taskService.findPersonalTasks(name);
		return task2Map(taskList);
	}
	
	public List<Map<String,Object>> task2Map(List<Task> taskList){
		 List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		 for(int i=0;i<taskList.size();i++){
			 Map<String,Object> map = new HashMap<String,Object>();
			 Task t = taskList.get(i);
			 map.put("id", t.getId());
			 map.put("name", t.getName());
			 map.put("assignee", t.getAssignee());
			 map.put("createTime", t.getCreateTime());
			 map.put("duedate", t.getDuedate());
			 map.put("priority", t.getPriority());
			 map.put("description", t.getDescription());
			 list.add(map);
		 }
		 return list;
	}
	
	/**
	 * 得到task的细节
	 * @param id
	 * @return
	 */
	public Map<String,Object> taskDetail(String taskId){
		Set<String> set = taskService.getVariableNames(taskId);
		Map<String, Object> map = taskService.getVariables(taskId, set);
		return map;
	}
	
	/**
	 * 添加task
	 * @param map
	 */
	public void addTask(Map<String,Object> map){
		//获取任务列表，因为我们在填写请假单的时候是分配给“Illidan”的，见askFor.jpdl.xml
		processInstance = executionService.startProcessInstanceByKey("askFor");
		taskList = taskService.findPersonalTasks("Illidan");
		//根据任务列表获取任务
		task = taskList.get(0);
		//把设置好的变量放到任务服务里面并根据任务ID结束任务
		taskService.setVariables(task.getId(), map);
		taskService.completeTask(task.getId());
	}
	
	/**
	 * 批准
	 */
	public void confirmTask(String taskId){
		task = taskService.getTask(taskId);
		execution = executionService.findExecutionById(task.getExecutionId());
		if(execution.getProcessInstance().isActive("boss apply")){
			taskService.completeTask(taskId, "boss agree");
		}else if(execution.getProcessInstance().isActive("manager apply")){
			String variable = (String) taskService.getVariable(taskId,"leaveDay");
			if(Integer.valueOf(variable) > 3){
				taskService.completeTask(taskId, "day>3");
			}else{
				taskService.completeTask(taskId,"manager agree");
			}
		}
	}
	
	/**
	 * 不批准
	 */
	public void rejectTask(String taskId){
		task = taskService.getTask(taskId);
		execution = executionService.findExecutionById(task.getExecutionId());
		if(execution.getProcessInstance().isActive("boss apply")){
			taskService.completeTask(taskId,"boss deagree");
		}else if(execution.getProcessInstance().isActive("manager apply")){
			taskService.completeTask(taskId,"manager deagree");
		}
	}
	/*
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	    ProcessEngine processEngine = (ProcessEngine)ctx.getBean("processEngine",SpringProcessEngine.class);
		RepositoryService repositoryService = processEngine.getRepositoryService();
		ExecutionService executionService = processEngine.getExecutionService();
		String taskId = "100008";
		String processInstanceId =processEngine.getTaskService().getTask(taskId).getExecutionId();
		ProcessInstance processInstance = executionService.findProcessInstanceById(processInstanceId);		
		Set<String> activityNames = processInstance.findActiveActivityNames();			
		ActivityCoordinates ac = repositoryService.getActivityCoordinates(processInstance.getProcessDefinitionId(),activityNames.iterator().next());
		System.out.println(ac.getX()+"~~~~~~~");
		System.out.println(ac.getY()+"*******");
	}
	*/
}
