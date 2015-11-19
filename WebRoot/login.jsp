<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>网络管理系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	

<link rel="stylesheet" type="text/css" href="jquery/themes/cupertino/easyui.css">
<link rel="stylesheet" type="text/css" href="resource/css/login.css">
<script type="text/javascript" src="jquery/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="jquery/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="js/cookie.js"></script>
<script type="text/javascript" src="js/login/login.js"></script>
  </head>
  <body   style="overflow:hidden" onload="document.f.username.focus()">
  <form action="" method="post" name="f">
   <table width="100%"  height="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="561" style="background:url(resource/images/lbg.gif)"><table width="940"  border="0" align="center" cellpadding="0" cellspacing="0">
          <tr>
            <td height="238" style="background:url(resource/images/login01.jpg)">&nbsp;</td>
          </tr>
          <tr>
            <td height="190"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="208" height="190" style="background:url(resource/images/login02.jpg)">&nbsp;</td>
                <td width="518" style="background:url(resource/images/login03.jpg)"><table width="320" border="0" align="center" cellpadding="0" cellspacing="0">
                  <tr>
                    <td width="40" height="37"><img src="resource/images/user.gif" width="30" height="30"></td>
                    <td width="38" height="37"><font>用&nbsp;&nbsp;户</font></td>
                    <td width="242" height="37"><input type="text" name="username" id="username" style="width:175px; height:28px; line-height:34px; background:url(resource/images/inputbg.gif) repeat-x; border:solid 1px #d1d1d1; font-size:12pt; font-family:Verdana, Geneva, sans-serif; font-weight: bold;"><span id ="registe" class="loginspan">注册帐号?</span></td>
                  </tr>
                  <tr>
                    <td height="36"><img src="resource/images/password.gif" width="28" height="32"></td>
                    <td height="36"><font>密&nbsp;&nbsp;码</font></td>
                    <td height="36"><input type="password" name="password" id="password" style="width:175px; height:28px; line-height:34px; background:url(resource/images/inputbg.gif) repeat-x; border:solid 1px #d1d1d1; font-family:Verdana, Geneva, sans-serif;font-size:10pt;font-weight: bold;  "><span id = "forget" class="loginspan">找回密码?</span></td>
                
                  </tr>
                 <tr>
                    <td height="36"><img src="resource/images/map.png" width="25" height="25"></td>
                    <td height="36"  align="right"><font>验证码</font></td>
                    <td height="36">
                    <table><tr><td  height="36">
                   		 <input type="text"  maxlength=4 name ="authcode"   id="authcode" style="width:92px; height:28px; line-height:34px; background:url(resource/images/inputbg.gif) repeat-x; border:solid 1px #d1d1d1; font-size:12pt;font-weight: bold;font-family:Verdana, Geneva, sans-serif; " />  </td>       
                  	<td  height="36" width="76" id="codecusor"></td>
                   <td  height="36"> &nbsp;</td>
                   	 </tr>
                   	 </table>
                    </td>
                  </tr> 
                  <tr>
                  <!-- 只能尝试把cookie交给过滤器处理 -->
                 <td height="9"><img src="resource/images/pencil-and-ruler.png" width="25" height="25"></td>
                  <td height="9"   align="right"><font>记住我</font></td>
                  <td align="left" height="9">	
                  <select   name="remenberme" id ="remenberme"  style="color:green;" >
										<option>浏览器进程</option>
										<option>一小时</option>
										<option>一天</option>
										<option >一个月</option>
										<option>永久</option>
							    	</select>
				</td>
                  
                  </tr>
                  <tr>
                    <td height="40">&nbsp;</td>
                    <td height="40">&nbsp;</td>
                    <td height="40" align="center"><input type="button" class="btn"  id="button"  value="登  录" onmouseover="this.style.backgroundPosition='left -40px'" onmouseout="this.style.backgroundPosition='left top'" /></td>
                 
                  </tr>
                  <tr><td colspan="3" align="center"><span id ="message" style="margin-top:6px; font-size: 12px;color:red;" ></span></td></tr>
                </table></td>
                <td width="214" style="background:url(resource/images/login04.jpg)" >&nbsp;</td>
              </tr>
            </table></td>
          </tr>
          <tr>
            <td height="133" style="background:url(resource/images/login05.jpg)">
              &nbsp;
              </td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</form>
	<div id="registe_dialog"  style ="padding-left:50px;padding-right: 50px;padding-top: 15px;padding-bottom: 2px; ">
	    <form id="registe_form" method="post" >
	        <table>
	         <tr height="5px"><td colspan="4"><font>---基本信息---</font></td></tr>
	         <tr height="8px">
	       <tr>
	      		 <td> <label for="name" >用户名</label></td>
	            <td> <input class="easyui-validatebox" type="text"  name="name" id="regite_username" style="width:150px;margin-right: 20px;"  data-options="required:true"/></td>
	          	<td><label for="password">密&nbsp;&nbsp;码</label></td>
	          	<td> <input class="easyui-validatebox" type="password"  id ="registepassword" style="width:150px"  name="password" data-options="required:true"/></td>
	         </tr>
	         <tr height="5px"/>
	         <tr>
	           <td> <label for="repassword">确认密码</label></td>
	           <td> <input class="easyui-validatebox" type="password"style="width:150px" id ="repassword"  name="repassword"  required="required" validType="equals['#registepassword']"/></td>
	            <td> <label for="email">邮&nbsp;&nbsp;箱</label></td>
	            <td><input class="easyui-validatebox" type="text" name="email" style="width:150px" data-options="validType:'email',required:true" /></td>
	           </tr> 
	           <tr height="5px"/>
	           <tr>
	           <td> <label for="sex">性&nbsp;&nbsp;别</label></td>
	          	 <td>
	          	  <input type="radio" name ="sex" checked="checked" value="男" /> <label for="sex" style="color: black;">男</label>
	          	  <input type="radio"  value="女" name ="sex" /><label for="sex" style="color: black;">女</label>
	           	</td>
	           	    <td> <label for="age">年&nbsp;&nbsp;龄</label></td>
	          	 <td>
	          	  <input class="easyui-numberspinner" type="text" name="age"  data-options="min:0,value:0" />
	           	</td>
	           </tr> 
	           <tr height="5px"/>
	           <tr>
	       <td> <label for="realName">真实姓名</label></td>
	            <td><input class="easyui-validatebox" type="text" name="realName" style="width:150px"  data-options="required:true" /></td>
	            <td> <label for="phone">电话号码</label></td>
	            <td><input class="easyui-numberbox" type="text" name="phone"  style="width:150px"  data-options="min:0" /></td>
	           </tr> 
	           <tr height="5px"/>
	             <tr>
	           <td> <label for="birthday">出身年月</label></td>
	           <td> <input class="easyui-datebox" type="text"  name="birthday" data-options="editable:false"  style="width:150px;"/></td>
	            <td> <label for="address">家庭住址</label></td>
	            <td><input class="easyui-validatebox" type="text" name="address" style="width:150px"  data-options="required:false" /></td>
	           </tr> 
	             <tr height="5px"/>
	             <tr>
	           <td> <label for="idCard">身份证号码</label></td>
	           <td> <input class="easyui-numberbox" type="text" style="width:150px"   name="idCard" style="width:150px;"/></td>
	            <td> <label for="code">验证码</label></td>
	            <td>
	             <table><tr height="30">
	             		<td >
                   		 <input type="text"   name ="authcode"   id="authcode"  class="easyui-validatebox"  style="width:70px;" data-options="required:true"  />
                   		   </td>       
                  		<td height="30" id="codecusor"></td>
                   	 </tr>
                   	 </table>
	            </td>
	           </tr> 
	            <tr height="5px"/>
	            <tr height="5px"><td colspan="4"><font>---安全问题---</font></td></tr>
	            <tr height="8px"/>
	            	 <tr>
			           <td> <label for="securityQuestionOne">安全问题1</label></td>
			           <td>
			           	<select  name="securityQuestionOne"   style="width:150px;height: 20px;font-size: 13px;font-family: 微软雅黑;"  >
										<option>你父亲的生日</option>
										<option>你母亲的生日</option>
										<option>你的生日</option>
										<option >你配偶的名字</option>
										<option>你最喜欢什么</option>
							   </select>
			           	</td>
		            <td><label for="securityQuestionTwo">安全问题2</label></td>
		            <td>
		            	<select   name="securityQuestionTwo"    style="width:150px;height: 20px;font-size: 10px;font-size: 13px;font-family: 微软雅黑;" >
										<option>你父亲的生日</option>
										<option>你母亲的生日</option>
										<option>你的生日</option>
										<option >你配偶的名字</option>
										<option>你最喜欢什么</option>
							   </select>
		            	</td>
	           </tr>
	           <tr height="5px"/>
	           	 <tr>
			           <td> <label for="securitAnswerOne">答案</label></td>
			           <td><input class="easyui-validatebox" type="text" style="width:150px" name="securitAnswerOne"  data-options="required:true" />
			           	</td>
		            <td><label for="securitAnswerTwo">答案</label></td>
		            <td>
		            <input class="easyui-validatebox" type="text" style="width:150px" name="securitAnswerTwo"  data-options="required:true" />
		            	</td>
	           </tr>
	           <tr height="8px"><td colspan="4" align="center">
	           	<div  id="error_div" >
	           		<table>
	           			<tr>
	           		<td><img src ="resource/images/warning.png" style="display: none"/></td>
	           		<td><span class ="error-msg"></span></td>
	           		</tr>
	           		</table>
	           		</div>
	           	</td></tr>
	           </table>
	    </form>
	</div>
	<div id ="forgetPass_win" style ="padding-top: 15px;padding-left:39px;">
		<form id="forgetPass_form">
			<label for="name">用户名</label><br/>
			<div  id ="f_name">
				<table>
	           		<tr>
	           		<td><input type="text" name="name" style="width:150px" /></td>
	           		<td><img src ="resource/images/warning.png" style="display: none"/></td>
	           		<td><span class ="error-msg" style="display: none"></span></td>
	           		</tr>
	      </table>
			</div>
			<label for="password">新密码</label><br/>
			<div id="f_pwd">
			<table>
			<tr>
			<td><input type="password" name="password" style="width:150px"/></td>
			<td><img src ="resource/images/warning.png" style="display: none"/></td>
	          <td><span class ="error-msg" style="display: none"></span></td>
			</tr>
			</table>
			</div>
			<div>
			<label for="repassword">确认密码</label><br/>
			</div>
			<div id ="f_repwd">
			<table><tr><td>
			<input type="password" name="repassword" style="width:150px"  />
			</td>
			<td><img src ="resource/images/warning.png" style="display: none"/></td>
	          <td><span class ="error-msg" style="display: none"></span></td>
			</tr></table>
			</div>
			<label for="securityQuestionOne">安全问题1</label><br/>
			<div>
			<table><tr><td>
			<select  name="securityQuestionOne"   style="width:150px;height: 20px;font-size: 13px;font-family: 微软雅黑;"  >
										<option>你父亲的生日</option>
										<option>你母亲的生日</option>
										<option>你的生日</option>
										<option >你配偶的名字</option>
										<option>你最喜欢什么</option>
			</select>
			</td></tr></table>
			</div>
			<label for="securitAnswerOne">答案</label><br/>
			<div  id ="f_one">
				<table>
	           		<tr>
	           		<td><input  type="text" name="securitAnswerOne" style="width:150px"  /></td>
	           		<td><img  src ="resource/images/warning.png" style="display: none"/></td>
	           		<td><span class ="error-msg" style="display: none"></span></td>
	           		</tr>
	      </table>
			</div>
			<label for="securityQuestionTwo">安全问题2</label><br/>
			<div>
			<table><tr><td>
			<select  name="securityQuestionTwo"   style="width:150px;height: 20px;font-size: 13px;font-family: 微软雅黑;"  >
										<option>你父亲的生日</option>
										<option>你母亲的生日</option>
										<option>你的生日</option>
										<option >你配偶的名字</option>
										<option>你最喜欢什么</option>
			</select>
			</td></tr></table>
			</div>
			<label for="securitAnswerTwo">答案</label><br/>
			<div  id ="f_two">
				<table>
	           		<tr>
	           		<td><input type="text" name="securitAnswerTwo" style="width:150px"  /></td>
	           		<td><img src ="resource/images/warning.png" style="display: none"/></td>
	           		<td><span class ="error-msg" style="display: none"></span></td>
	           		</tr>
	      </table>
			</div>
			<br/>
			
		</form>
	</div>
  </body>
</html>
