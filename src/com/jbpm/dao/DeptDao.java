package com.jbpm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.jbpm.util.ConnPool;

public class DeptDao {

	public JSONArray queryDept(String startId) {
		final JSONArray result = new JSONArray();
		try {
			Connection conn = ConnPool.getConnection();
			String sql = "select t.dept_id,t.dept_name,t.p_id from dept t start with p_id="
				+ startId
				+ " connect by prior dept_id = p_id order by p_id asc";
			PreparedStatement prep = conn.prepareStatement(sql);
			ResultSet rst = prep.executeQuery();
			while(rst.next()){
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("deptId",rst.getString(1));
				jsonObj.put("text",rst.getString(2));
				jsonObj.put("pId",rst.getString(3));
				if(rst.getString(3).equals("0")){
					jsonObj.put("leaf", "false");
				}
				result.add(jsonObj);
			}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return result;
	}
	
	public JSONArray generate(JSONArray srcArr,String childFlag,String fatherFlag){
		final JSONArray result = new JSONArray(); 
		for(int i=0;i<srcArr.size();i++){
			JSONObject jsonObj1 = (JSONObject)srcArr.get(i);
			String str1 = jsonObj1.get(fatherFlag).toString();
			for(int j=0;j<srcArr.size();j++){
				JSONObject jsonObj2 = (JSONObject)srcArr.get(j); 
				String str2 = jsonObj2.getString(childFlag).toString();
				if(str1.equals(str2)){
					JSONArray children = (JSONArray)jsonObj1.get("children");
					if(children == null){
						children = new JSONArray();
					}
					jsonObj2.put("leaf", "true");
					children.add(jsonObj2);
					jsonObj1.put("children", children);
				}
			}
			if(jsonObj1.get("pId").equals("0")){
				result.add(jsonObj1);
			}
		}
		return result;
	}
	
	public List<Map<String,Object>> findDept(String deptId){
		List<Map<String,Object>> depts = new ArrayList<Map<String,Object>>();
		Connection conn;
		try {
			conn = ConnPool.getConnection();
			PreparedStatement prep = conn.prepareStatement("select * from Dept where dept_id = ?");
			prep.setString(1, deptId);
			ResultSet rst = prep.executeQuery();
			while(rst.next()){
				Map<String,Object> map = new HashMap<String,Object>();
				map.put("dept_id", rst.getInt("dept_id"));
				map.put("dept_name", rst.getString("dept_name"));
				map.put("p_id", rst.getString("p_id"));
				depts.add(map);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return depts;
	}
	
	public static void main(String[] args) {
		DeptDao dao = new DeptDao();
		String childId = "deptId";
		String parentId = "pId";
		JSONArray jsonArray = dao.queryDept("0");
		JSONArray result = dao.generate(jsonArray,parentId,childId);
		System.out.println(result);
	}
}
