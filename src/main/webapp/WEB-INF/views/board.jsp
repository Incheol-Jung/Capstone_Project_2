<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Board Page</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/bootstrap.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/board.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/stimenu.css" />
	<link href='http://fonts.googleapis.com/css?family=PT+Sans+Narrow&v1' rel='stylesheet' type='text/css' />
	<link href='http://fonts.googleapis.com/css?family=Wire+One&v1' rel='stylesheet' type='text/css' />

	<link href='http://fonts.googleapis.com/css?family=Raleway:400,300,700' rel='stylesheet' type='text/css'>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/cs-select.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/cs-skin-elastic.css" />
</head>
<body >
<div style="width:100%; font-size:12px; padding:15px; text-align:right; color:#fff; background-color:#000; ">
	<% if( session.getAttribute("userEmail") != null ) { %>
		Hello ${username}.&nbsp;
	<%} else{ %>
		LOGIN &nbsp;
	<% } %> 
	MY ACCOUNT &nbsp; 
</div>
<div style="width:1000px; margin:0 auto;">
<div class="board_top_bg">
	<ul id="sti-menu" class="sti-menu">
		<li data-hovercolor="#37c5e9">
			<a href="#">
				<h2 data-type="mText" class="sti-item">Advanced Patient Care</h2>
				<h3 data-type="sText" class="sti-item">Personalized to your needs</h3>
				<span data-type="icon" class="sti-icon sti-icon-care sti-item"></span>
			</a>
		</li>
		<li data-hovercolor="#ff395e">
			<a href="#">
				<h2 data-type="mText" class="sti-item">Alternative Medicine</h2>
				<h3 data-type="sText" class="sti-item">Holistic approaches</h3>
				<span data-type="icon" class="sti-icon sti-icon-alternative sti-item"></span>
			</a>
		</li>
		<li data-hovercolor="#57e676">
			<a href="#">
				<h2 data-type="mText" class="sti-item">Modern Info Center</h2>
				<h3 data-type="sText" class="sti-item">Educating you</h3>
				<span data-type="icon" class="sti-icon sti-icon-info sti-item"></span>
			</a>
		</li>
		<li data-hovercolor="#d869b2">
			<a href="#">
				<h2 data-type="mText" class="sti-item">Future Family Planning</h2>
				<h3 data-type="sText" class="sti-item">For a healthier future</h3>
				<span data-type="icon" class="sti-icon sti-icon-family sti-item"></span>
			</a>
		</li>
		<li data-hovercolor="#ffdd3f">
			<a href="#">
				<h2 data-type="mText" class="sti-item">Advanced Technology</h2>
				<h3 data-type="sText" class="sti-item">From the latest research</h3>
				<span data-type="icon" class="sti-icon sti-icon-technology sti-item"></span>
			</a>
		</li>
	</ul>
	
</div>
<form action="board" method="get">
	<div>
		<div style="float:left;">
			<div style="float:left;">
				<section>
					<select name="s_category" class="cs-select cs-skin-elastic" style="width: 100px;border: 1px solid #ccc;">
						<option value="title" data-class="flag-france" selected>Title</option>
						<option value="content" data-class="flag-brazil">Content</option>
						<option value="writer" data-class="flag-argentina">Writer</option>
					</select>
				</section>
			</div>
			<div style="float:left; margin-top:4px">
				<input type="search" name="s_keyword" style="border: 1px solid #ccc; font-size:9px; padding:5px 8px; min-width: 160px; " placeholder="Search Keyword" >
				<input type="submit" style="display:none; background-image:url('${pageContext.request.contextPath}/resources/style/images/glyphicons_027_search.png')">
				<a href="#"><img src="${pageContext.request.contextPath}/resources/style/images/glyphicons_027_search.png" style="width: 15px; margin-left: 5px;"/></a>
			</div>
		</div>
		<div style="float:right;">
			<button class="myButton" style="font-size: 12px;padding: 3px 10px;">Add to list</button>
		</div>
	</div>
</form>
<table class="table table-hover" id="board_table">
	<tr>
		<th style="width:10%;">No.</th>
		<th style="width:50%;">Title</th>
		<th style="width:20%;">Writer</th>
		<th style="width:10%;">Hits</th>
		<th style="width:10%;">Review</th>
	</tr>
	<c:forEach var="board" items="${list}" begin="${page_begin}" end="${page_end}">
		<tr>
			<td>${board.getBoardID()}</td>
			<td>${board.getTitle()}</td>
			<td>${board.getB_userID()}</td>
			<td>${board.getCount()}</td>
			<td>${board.getR_count()}</td>
		</tr>
	</c:forEach>
</table>
<div style="width:1000px; text-align:center;">
<c:forEach var="page_num" items="${page_list}">
	<a class="myButton" href="./board?pageNum=${page_num.getNumber()}&s_keyword=${s_keyword}&s_category=${s_category}">${page_num.getNumber()}</a>&nbsp;
</c:forEach>
</div>


<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/style/js/jquery.iconmenu.js"></script>
<script type="text/javascript">
	$(function() {
		$('#sti-menu').iconmenu({
			animMouseenter	: {
				'mText' : {speed : 400, easing : 'easeOutBack', delay : 200, dir : -1},
				'sText' : {speed : 400, easing : 'easeOutBack', delay : 400, dir : -1},
				'icon'  : {speed : 400, easing : 'easeOutBack', delay : 0, dir : -1}
			},
			animMouseleave	: {
				'mText' : {speed : 200, easing : 'easeInExpo', delay : 150, dir : 1},
				'sText' : {speed : 200, easing : 'easeInExpo', delay : 300, dir : 1},
				'icon'  : {speed : 200, easing : 'easeInExpo', delay : 0, dir : 1}
			}
		});
	});
</script>
<script src="${pageContext.request.contextPath}/resources/style/js/classie.js"></script>
<script src="${pageContext.request.contextPath}/resources/style/js/selectFx.js"></script>
<script>
	(function() {
		[].slice.call( document.querySelectorAll( 'select.cs-select' ) ).forEach( function(el) {	
			new SelectFx(el);
		} );
	})();
</script>
</div>
<div style="height:100px; margin-bottom:30px;">
</div>
</body>
</html>


