<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="head.jsp" %>
<script>
	$(function(){
		$.ajax({
			type:"GET",
			url:"servlet/RunServlet",
			data:{"method":"showInfo"},
			dataType:"json",
			success:function(returnData){
				$(returnData).each(function(index,item){
					var date = new Date(item.jointime);
                	var y = date.getFullYear();
                	var m = date.getMonth()+1;
                	var d = date.getDate();
                	var dateShow = y+"-"+m+"-"+d;
                	console.log(dateShow);
		          	 var tr="<tr><td>"+item.eid+"</td><td>"+item.ename+"</td><td>"+item.job+"</td><td>"+item.dpetno+"</td><td>"+item.dname+"</td><td>"+dateShow+"</td><td><a href='javascript:deleteOne("+item.eid+")'>删除</a>&nbsp;&nbsp<a href='javascript:updateOne("+item.eid+")'>更新</a></td></tr>"
		          	 $("#tab").append(tr);
		           });
			}
			/* 	 */
		})
		
		$("#form").hide()
	});
	
	function deleteOne(obj){
		$.ajax({
			type:"GET",
			url:"servlet/RunServlet",
			data:{"id":obj,"method":"deleteOne"},
			dataType:"json",
			success:function(returnData){
				window.location.reload();
			}
		})
	}
	
	function updateOne(obj){
		$.ajax({
			type:"GET",
			url:"servlet/RunServlet",
			data:{"id":obj,"method":"updateOne"},
			dataType:"json",
			success:function(returnData){
			
				$(returnData).each(function(index,item){
					$("#form").show();
					$("#form #id").val(item.eid);
					$("#form #name").val(item.ename);
		          	 $("#form #name").val(item.ename);
		          	 $("#form #job").val(item.job);
		          	 $("#form #dpet").val(item.dpetno);
		           });
			}
		})
	}
	
	function updateTrue(){
		console.log('sfdsfs')
		$.ajax({
			type:"GET",
			url:"servlet/RunServlet",
			data:{"eid":$("#form #id").val(),"ename":$("#form #name").val(),"job":$("#form #job").val(),"dpet":$("#form #dpet").val(),"method":"updateTrue"},
			dataType:"json",
			success:function(returnData){
				window.location.reload();
				alert(returnData.massage)
			}
		})
	}
</script>	
</head>
<body>
	<table border="1" id="tab" style="text-align:center" width='800px'>
		<tr>
			<th>id</th>
			<th>姓名</th>
			<th>工作</th>
			<th>部门编号</th>
			<th>所在部门</th>
			<th>入职日期</th>
			<th>操作</th>
			
		</tr>
	</table>
	<p></p>
	<p></p>
	<form id="form">
		<input type="hidden" id="id" value=''>
		姓名:<input type='text' id='name' value=''><br><br>
		岗位:<input type='text' id='job' value=''><br><br>
		部门:<input type='text' id='dpet' value=''><br><br>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" id="commit" value="提交" onclick="javascript:updateTrue()">
	</form>
	
</body>
</html>