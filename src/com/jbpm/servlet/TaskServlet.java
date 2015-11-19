package com.jbpm.servlet;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;

import com.jbpm.service.DeptService;
import com.jbpm.service.TaskOperateService;

public class TaskServlet  extends HttpServlet{
	private static final String CONTENT_TYPE = "content-type";
	private static final String CONTENT_TYPE_JAVASCRIPT = "text/javascript";
	private static final String ENCODING = "UTF-8";
	private TaskOperateService ts;

	
	private static final long serialVersionUID = 1L;
	
	public void init(ServletConfig config) throws ServletException {
		String flowFileName = config.getServletContext().getInitParameter("workflowFileName");
		System.out.println("flowFileName:--------------:"+flowFileName);
		ts = new TaskOperateService(flowFileName);
	}
	
	public void service(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		response.addHeader(CONTENT_TYPE, CONTENT_TYPE_JAVASCRIPT);
		request.setCharacterEncoding(ENCODING);
		String uri = request.getRequestURI();
		String action = uri.substring(uri.lastIndexOf("/"), uri
				.lastIndexOf("."));
		OutputStreamWriter out = new OutputStreamWriter(response
				.getOutputStream(), ENCODING);
		ObjectMapper objectMapper = new ObjectMapper();
		DeptService ds = new DeptService();
		if (action.equals("/taskList")) {
			try {
				
				String name = request.getParameter("name");
				List<Map<String,Object>> tasks = ts.getTasks(name);
				objectMapper.writeValue(out, tasks);// 用objectMapper的方法
				out.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		}else if(action.equals("/taskDetail")){
			String taskId = request.getParameter("id");
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("success", "true");
			map.put("msg","success");
			map.put("data",ts.taskDetail(taskId));
			objectMapper.writeValue(out, map);// 用objectMapper的方法
			out.close();
		}else if(action.equals("/addTask")){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("name", request.getParameter("name"));
			map.put("time", request.getParameter("time"));
			map.put("leaveDay", request.getParameter("leaveDay"));
			map.put("content", request.getParameter("content"));
			String position  = request.getParameter("position");
			map.put("position", position);
			//判断是否是manager
			if (position.trim().equals("manager")) {
				//"manager"变量名与askFor.jpdl.xml中decision里面的变量一致，同时设置的值也要保持一致
				map.put("manager", "yes");
			} else {
				map.put("manager", "no");
			}
			ts.addTask(map);
			Map<String,Object> res = new HashMap<String,Object>();
			res.put("success", "true");
			res.put("msg","success");
			objectMapper.writeValue(out, res);// 用objectMapper的方法
			out.close();
		}else if(action.equals("/confirmTask")){
			String taskId = request.getParameter("id");
			ts.confirmTask(taskId);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("success", "true");
			map.put("msg","success");
			objectMapper.writeValue(out, map);// 用objectMapper的方法
			out.close();
		}else if(action.equals("/rejectTask")){
			String taskId = request.getParameter("id");
			ts.rejectTask(taskId);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("success", "true");
			map.put("msg","success");
			objectMapper.writeValue(out, map);// 用objectMapper的方法
			out.close();
		}else if(action.equals("/deptView")){
			OutputStreamWriter out1 = new OutputStreamWriter(response
					.getOutputStream(), ENCODING);
			JsonGenerator jsonGenerator = null;
			ObjectMapper objectMapper1 = new ObjectMapper();
			jsonGenerator = objectMapper1.getJsonFactory()
					.createJsonGenerator(out1);
			JSONArray data  = ds.deptTree();
			jsonGenerator.writeObject(data);//用jsonGenerator方法输出
			out.close();
		}else if(action.equals("/deptListView")){
			String deptId = request.getParameter("id");
			List<Map<String, Object>> depts = ds.findDept(deptId);
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("data", depts);
			map.put("success", "true");
			map.put("msg","success");
			objectMapper.writeValue(out, depts);// 用objectMapper的方法
			out.close();
		}
	}
}
