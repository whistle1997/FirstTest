<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>会员登录</title>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css" />
<script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 引入自定义css文件 style.css -->
<link rel="stylesheet" href="css/style.css" type="text/css" />

<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}
</style>

<script type="text/javascript">
      function add(){
    	  var value = parseInt($("#buyNum").val());
    	  $("#buyNum").val(value+1);
      }
      function jian(){
    	  var value = parseInt($("#buyNum").val());
    	  if(value>1){
    		  $("#buyNum").val(value-1);  
    	  } 
      }
      
      function addCart(){
    	  var count = parseInt($("#buyNum").val());
    	  var pid =parseInt($("#pid").val());
    	  var price =parseInt($("#shopprice").val());
    	  window.location.href="cart/addCartitem?pid="+pid+"&count="+count+"&price="+price;    	  
         /*  $.ajax({
        	  type:'POST',
        	  url:'servlet/CartItemServlet',
        	  data:{"method":"addCartItem","pid":pid,"count":count,"price":price},
        	  dataType:'json',
        	  success:function(returnData){
        		  console.info(returnData)
        	  },
        	  error:function(){
        		  
        	  }
          });  */
      }
      

</script>

</head>

<body>
	<!-- 引入header.jsp -->
	<jsp:include page="/header.jsp"></jsp:include>
    <input type="hidden" value="123" id="hd">
    
	<div class="container">
		<div class="row">
			<div
				style="border: 1px solid #e4e4e4; width: 930px; margin-bottom: 10px; margin: 0 auto; padding: 10px; margin-bottom: 10px;">
				<a href="./index.htm">&nbsp;&nbsp;&gt;</a> <a href="./蔬菜分类.htm">&nbsp;&nbsp;&gt;</a>
				
			</div>

			<div style="margin: 0 auto; width: 950px;">
			    <input type="hidden" id="pid" value="${one.pid}">
			    <input type="hidden" id="shopprice" value="${one.shopprice}">
			
				<div class="col-md-6">
					<img style="opacity: 1; width: 400px; height: 350px;" title=""
						class="medium"
						src="${pageContext.request.contextPath }/${one.pimage}">
				</div>

				<div class="col-md-6">
					<div>
						<strong>${one.pname }</strong>
					</div>
					<div style="border-bottom: 1px dotted #dddddd; width: 350px; margin: 10px 0 10px 0;">
						<div>编号:${one.pid }</div>
					</div>

					<div style="margin: 10px 0 10px 0;">
						 优购价: <strong style="color: #ef0101;">￥:${one.shopprice }元/份</strong> 参 考 价：
						<del>￥${one.marketprice}元/份</del>
					</div>

					<div style="margin: 10px 0 10px 0;">
						促销: <a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)"
							style="background-color: #f07373;">限时抢购</a>
							抢购时间 (2018-10-15 ~ 2018-10-18)
					</div>

					<div
						style="padding: 10px; border: 1px solid #e7dbb1; width: 330px; margin: 15px 0 10px 0;; background-color: #fffee6;">
						<div style="margin: 5px 0 10px 0;">白色</div>
						<div
							style="border-bottom: 1px solid #faeac7; margin-top: 20px; padding-left: 10px;">
							购买数量: 
							<input id="buyNum" name="buyNum" value="1" maxlength="4" size="10" type="text">
							<input type="button" value="+" onclick="add()" >
							<input type="button" value="-" onclick="jian()">
						</div>

						<div style="margin: 20px 0 10px 0;; text-align: center;">
							<a href="javascript:void(0);" onclick="addCart()">
							 <input style="background: url('./images/product.gif') no-repeat scroll 0 -600px rgba(0, 0, 0, 0); height: 36px; width: 127px;"
								value="加入购物车" type="button">
							</a> 
						</div>
					</div>
					<div>
						<a href="javascript:window.history.go(-1)">返回继续浏览</a>
					</div>
				</div>
			</div>
			<div class="clear"></div>
			<div style="width: 950px; margin: 0 auto;">
				<div
					style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
					<strong>商品介绍</strong>
				</div>

               <c:forEach items="${one.prodetails}" var="prodetail">
					<div>                    
	                    <img src="${pageContext.request.contextPath }/${prodetail.imagepath}">
					</div>
				</c:forEach> 

				<div
					style="background-color: #d3d3d3; width: 930px; padding: 10px 10px; margin: 10px 0 10px 0;">
					<strong>商品参数</strong>
				</div>
				<div style="margin-top: 10px; width: 900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th colspan="2">基本参数</th>
							</tr>
							<tr>
								<th width="10%">级别</th>
								<td width="30%">标准</td>
							</tr>
							<tr>
								<th width="10%">标重</th>
								<td>${one.weight}</td>
							</tr>
							<tr>
								<th width="10%">浮动</th>
								<td>${one.floated}</td>
							</tr>
						</tbody>
					</table>
				</div>


                 <!--  商品评价区域 -->
				 <div style="background-color: #d3d3d3; width: 900px;">
					<table class="table table-bordered">
						<tbody>
							<tr class="active">
								<th><strong>商品评论</strong></th>
							</tr>
						<c:if test="${empty one.evaluates}">
                                    <th>暂无商品评论信息 <a>[该商品暂无评论]</a></th>        
                                </c:if>
                                <c:if test="${!empty one.evaluates}">
                                
	                                <c:forEach items="${one.evaluates}" var="el">
								       <tr class="warning">
									         <th>${el.uid}发表的评论:<br>${el.dis}</th>         												
								       </tr>
								    </c:forEach>
							    </c:if>	
						</tbody>
					</table>
				</div> 

				
			</div>

		</div>
	</div>


	<!-- 引入footer.jsp -->
	<jsp:include page="/footer.jsp"></jsp:include>

</body>

</html>