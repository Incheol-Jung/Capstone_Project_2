<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Main Page</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/board.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/stimenu.css" />
	<link href='http://fonts.googleapis.com/css?family=PT+Sans+Narrow&v1' rel='stylesheet' type='text/css' />
	<link href='http://fonts.googleapis.com/css?family=Wire+One&v1' rel='stylesheet' type='text/css' />

	<link href='http://fonts.googleapis.com/css?family=Raleway:400,300,700' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/cs-select.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/cs-skin-elastic.css" />
</head>
<style>
	.header{width:100%;font-size:12px;padding:15px;text-align:right;color:#fff;background-color:#000;}
	.left_side{float:left;width:300px;height:100%;background-color:green;padding:20px}
	.left_side .lst_cate{list-style: none;padding: 0px;line-height: 30px;}
	.right_side{float:right;width:900px;background-color:pink;padding:20px;}
	.right_side .lst_npr{float:left;background-color:gray;padding:15px;}
	.right_side .lst_buser{float:left;margin-left:20px;background-color:red;padding:15px;}
	.right_side .lst_bpr{display:inline-block;width:100%;margin-top:20px;background-color:#f0f0f0;padding:15px;}
	.lst_buser:after{display: block;overflow: hidden;clear: both;height: 0;content: '';}
</style>
<body style="width:1200px;margin:0 auto">
	<div class="header">
		<% if( session.getAttribute("userEmail") != null ) { %>
			Hello ${username}.&nbsp;
		<%} else{ %>
			LOGIN &nbsp;
		<% } %> 
		MY ACCOUNT &nbsp; 
	</div>
	<div class="left_side">
		<input type="text" class="sch">left_search
		<ul class="lst_cate">
			<li>Web Project</li>
			<li>Hardware</li>
			<li>Software</li>
			<li>Mobile application</li>
			<li>thesis</li>
		</ul>
	</div>
	<div class="right_side">

			<div class="lst_npr">
				<table>
					<tr>
						<th style="width:250px;">Title</th>
						<th>Category</th>
						<th style="width:120px;">UserName</th>
					</tr>
					<tr>
						<td>Time Capsule</td>
						<td>Web application</td>
						<td>bluesky6096</td>
					</tr>
					<tr>
						<td>Time Capsule</td>
						<td>Web application</td>
						<td>bluesky6096</td>
					</tr>
					<tr>
						<td>Time Capsule</td>
						<td>Web application</td>
						<td>bluesky6096</td>
					</tr>
				</table>
			</div>
			<div class="lst_buser">
				<table>
					<tr>
						<th>UserName</th>
						<th>Level</th>
						<th>Comment Count</th>
					</tr>
					<tr>
						<td>bluesky6096</td>
						<td>Silver</td>
						<td>584</td>
					</tr>
					<tr>
						<td>jic761</td>
						<td>Gold</td>
						<td>96</td>
					</tr>
					<tr>
						<td>dkfdnd80</td>
						<td>silver</td>
						<td>100</td>
					</tr>
				</table>
			</div>

		<div class="lst_bpr">
			<table>
				<tr>
					<th style="width:250px;">Title</th>
					<th style="width:120px;">UserName</th>
					<th>Count</th>
					<th>Review Count</th>
					<th>Like</th>
				</tr>
				<tr>
					<td>Capstone Project2</td>
					<td>steve</td>
					<td>80</td>
					<td>120</td>
					<td>50</td>
				</tr>
				<tr>
					<td>Capstone Project2</td>
					<td>steve</td>
					<td>80</td>
					<td>120</td>
					<td>50</td>
				</tr>
				<tr>
					<td>Capstone Project2</td>
					<td>steve</td>
					<td>80</td>
					<td>120</td>
					<td>50</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>


