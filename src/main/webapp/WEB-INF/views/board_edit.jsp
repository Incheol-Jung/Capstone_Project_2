<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Board Edit Page</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/board.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/stimenu.css" />
	<link href='http://fonts.googleapis.com/css?family=PT+Sans+Narrow&v1' rel='stylesheet' type='text/css' />
	<link href='http://fonts.googleapis.com/css?family=Wire+One&v1' rel='stylesheet' type='text/css' />

	<link href='http://fonts.googleapis.com/css?family=Raleway:400,300,700' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/cs-select.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/cs-skin-elastic.css" />
	<style type="text/css">
		/* ###### White / Pink #########*/
		.white-pink {
		    margin-left:auto;
		    margin-right:auto;
		    max-width: 500px;
		    background: #FFF;
		    padding: 30px 30px 20px 30px;
		    box-shadow: rgba(187, 187, 187, 1) 0 0px 20px -1px;
		    -webkit-box-shadow: rgba(187, 187, 187, 1) 0 0px 20px -1px;
		    font: 12px Arial, Helvetica, sans-serif;
		    color: #666;
		    border-radius: 100px;
		    -webkit-border-radius: 10px;
		    margin-top:100px;
		}
		.white-pink h1 {
		    font: 24px "Trebuchet MS", Arial, Helvetica, sans-serif;
		    padding: 0px 0px 10px 40px;
		    display: block;
		    border-bottom: 1px solid #F5F5F5;
		    margin: -10px -30px 10px -30px;
		    color: #969696;
		}
		.white-pink h1>span {
		    display: block;
		    font-size: 11px;
		    color: #C4C2C2;
		}
		.white-pink label {
		    display: block;
		    margin: 0px 0px 5px;
		}
		.white-pink label>span {
		    float: left;
		    width: 20%;
		    text-align: right;
		    padding-right: 10px;
		    margin-top: 10px;
		    color: #969696;
		}
		.white-pink input[type="text"], .white-pink input[type="email"], .white-pink textarea,.white-pink select{
		    color: #555;
		    width: 70%;
		    padding: 3px 0px 3px 5px;
		    margin-top: 2px;
		    margin-right: 6px;
		    margin-bottom: 5px;
		    border: 1px solid #e5e5e5;
		    background: #fbfbfb;
		    height: 25px;
		    line-height:15px;
		    outline: 0;
		    -webkit-box-shadow: inset 1px 1px 2px rgba(200,200,200,0.2);
		    box-shadow: inset 1px 1px 2px rgba(200,200,200,0.2);
		    
		}
		.white-pink textarea{
		    height:100px;
		    padding: 5px 0px 0px 5px;
		    width: 70%;
		    max-width:70%;
		}
		.white-pink .button {
		    -moz-box-shadow:inset 0px 1px 0px 0px #97c4fe;
		    -webkit-box-shadow:inset 0px 1px 0px 0px #97c4fe;
		    box-shadow:inset 0px 1px 0px 0px #97c4fe;
		    background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #3d94f6), color-stop(1, #1e62d0));
		    background:-moz-linear-gradient(top, #3d94f6 5%, #1e62d0 100%);
		    background:-webkit-linear-gradient(top, #3d94f6 5%, #1e62d0 100%);
		    background:-o-linear-gradient(top, #3d94f6 5%, #1e62d0 100%);
		    background:-ms-linear-gradient(top, #3d94f6 5%, #1e62d0 100%);
		    background:linear-gradient(to bottom, #3d94f6 5%, #1e62d0 100%);
		    filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#3d94f6', endColorstr='#1e62d0',GradientType=0);
		    background-color:#3d94f6;
		    -moz-border-radius:6px;
		    -webkit-border-radius:6px;
		    border-radius:6px;
		    border:1px solid #337fed;
		    display:inline-block;
		    cursor:pointer;
		    color:#ffffff;
		    font-family:arial;
		    font-size:15px;
		    font-weight:bold;
		    padding:6px 24px;
		    text-decoration:none;
		    text-shadow:0px 1px 0px #1570cd;
		}
		.white-pink .button:hover {
		    background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #1e62d0), color-stop(1, #3d94f6));
		    background:-moz-linear-gradient(top, #1e62d0 5%, #3d94f6 100%);
		    background:-webkit-linear-gradient(top, #1e62d0 5%, #3d94f6 100%);
		    background:-o-linear-gradient(top, #1e62d0 5%, #3d94f6 100%);
		    background:-ms-linear-gradient(top, #1e62d0 5%, #3d94f6 100%);
		    background:linear-gradient(to bottom, #1e62d0 5%, #3d94f6 100%);
		    filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#1e62d0', endColorstr='#3d94f6',GradientType=0);
		    background-color:#1e62d0;
		}
		.white-pink .button:active {
		    position:relative;
    		top:1px;
		}
		.white-pink select {
		    background: url('down-arrow.png') no-repeat right, -moz-linear-gradient(top, #FBFBFB 0%, #E9E9E9 100%);
		    background: url('down-arrow.png') no-repeat right, -webkit-gradient(linear, left top, left bottom, color-stop(0%,#FBFBFB), color-stop(100%,#E9E9E9));
		    text-indent: 0.01px;
		    text-overflow: '';
		    width: 70%;
		    line-height: 15px;
		    height: 30px;
		}
		
	</style>
</head>
<body>
	<div>
		<form action="addboard" method="post" class="White-Pink">
			<h1>Post a sign
        		<span>Please fill all the texts in the fields. </span>
		    </h1>
		    <label>
		        <span>Title :</span>
		        <input id="name" type="text" name="title" placeholder="Title" value="${title}">
		    </label>
		    <label>
		        <span>Category :</span>
		        <select name="categoryid" value="${categoryid}">
		        	<c:forEach var="category" items="${list}" >
		        		<option value="${category.getCategoryID()}" ${category.getCategoryID() == categoryid ? 'selected' : ''}>${category.getCategoryName()}</option>
		        	</c:forEach>
		        </select>
		    </label>
		    <label>
		        <span>Content :</span>
		        <textarea id="message" name="content" placeholder="please Write a Content">${content}</textarea>
		    </label> 
		    <label>
		        <span>&nbsp;</span> 
		        <input type="submit" class="button" value="Submit" /> 
		    </label>
		    <div style="display:hidden">
		    	<input type="hidden" name="userid" value="${userid}">
		    	<input type="hidden" name="boardid" value="${boardid}">
		    </div>    
		</form>
	</div>
</body>
</html>


