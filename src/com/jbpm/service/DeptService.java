package com.jbpm.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.jbpm.dao.DeptDao;

public class DeptService {
	
	public DeptDao dao = new DeptDao();
	
	public JSONArray deptTree(){
		String childId = "deptId";
		String parentId = "pId";
		JSONArray jsonArray = dao.queryDept("0");
		JSONArray result = dao.generate(jsonArray,parentId,childId);
		return result;
	}
	
	public List<Map<String,Object>> findDept(String deptId){
		 List<Map<String,Object>> depts = dao.findDept(deptId);
		 return depts;
	}
}
