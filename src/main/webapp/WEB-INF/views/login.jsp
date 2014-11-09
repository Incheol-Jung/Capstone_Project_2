<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Login</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/demo.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/component.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style/css/content.css" />
	<script src="${pageContext.request.contextPath}/resources/style/js/modernizr.custom.js"></script>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js" type="text/javascript"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>  
</head>
<body>
<h1>
	 &nbsp;
</h1>
	<div class="mockup-content">
		<p>Pea horseradish azuki bean lettuce avocado asparagus okra.</p>
		<div class="morph-button morph-button-modal morph-button-modal-2 morph-button-fixed">
			<button type="button">Sign In</button>
			<div class="morph-content">
				<div>
					<div class="content-style-form content-style-form-1">
						<span class="icon icon-close">Close the dialog</span>
						<h2>Sign In</h2>
						<form action="login">
							<p><input type="button" value="ajax_test" onclick="viewAjaxtest()" /></p>
							<p><label>Email</label><input type="text" id="signin_email" name="userEmail"/></p>
							<p><label>Password</label><input type="password" id="signin_password" name="userPassword"/></p>
							<p><span id="signin_btn" style="display: block;
margin-top: 2.5em;
padding: 1.5em;
width: 100%;
border: none;
background: #e75854;
color: #f9f6e5;
text-transform: uppercase;
letter-spacing: 1px;
font-weight: 800;
font-size: 1.25em;">Sign In</span></p>
							<p${result}></p>
							<p><input type="submit" value="Sign In" id="real_signin_btn" style="display:none;"></p>
						</form>
					</div>
				</div>
			</div>
		</div><!-- morph-button -->
		<strong class="joiner">or</strong>
		<div class="morph-button morph-button-modal morph-button-modal-3 morph-button-fixed">
			<button type="button">Sign up</button>
			<div class="morph-content">
				<div>
					<div class="content-style-form content-style-form-2">
						<span class="icon icon-close">Close the dialog</span>
						<h2>Sign Up</h2>
						<form action="register" method="post">
							<p><label>User Name</label><input type="text" name="userName" id="username"/></p>
							<p><label>Email</label><input type="text" name="userEmail" id="useremail"/></p>
							<p><label>Password</label><input type="password" name="userPassword" id="userpassword"/></p>
							<p><label>Repeat Password</label><input type="password" name="confirm_password" id="userconfirmpassword"/></p>
							<p><span id="signup_btn" style="display: block;
margin-top: 2.5em;
padding: 1.5em;
width: 100%;
border: none;
background: #e75854;
color: #f9f6e5;
text-transform: uppercase;
letter-spacing: 1px;
font-weight: 800;
font-size: 1.25em;">Sign Up</span></p>
							<p><input id="real_signup_btn" type="submit" value="Sign Up" style="display:none;"></p>
						</form>
					</div>
				</div>
			</div>
		</div><!-- morph-button -->
		<p>Kohlrabi radish okra azuki bean corn fava bean mustard tigernut juccama green bean celtuce collard greens avocado quandong.</p>
	</div><!-- /form-mockup -->

<script src="${pageContext.request.contextPath}/resources/style/js/login_classie.js"></script>
<script src="${pageContext.request.contextPath}/resources/style/js/uiMorphingButton_fixed.js"></script>
<script>
	(function() {
		var docElem = window.document.documentElement, didScroll, scrollPosition;

		// trick to prevent scrolling when opening/closing button
		function noScrollFn() {
			window.scrollTo( scrollPosition ? scrollPosition.x : 0, scrollPosition ? scrollPosition.y : 0 );
		}

		function noScroll() {
			window.removeEventListener( 'scroll', scrollHandler );
			window.addEventListener( 'scroll', noScrollFn );
		}

		function scrollFn() {
			window.addEventListener( 'scroll', scrollHandler );
		}

		function canScroll() {
			window.removeEventListener( 'scroll', noScrollFn );
			scrollFn();
		}

		function scrollHandler() {
			if( !didScroll ) {
				didScroll = true;
				setTimeout( function() { scrollPage(); }, 60 );
			}
		};

		function scrollPage() {
			scrollPosition = { x : window.pageXOffset || docElem.scrollLeft, y : window.pageYOffset || docElem.scrollTop };
			didScroll = false;
		};

		scrollFn();

		[].slice.call( document.querySelectorAll( '.morph-button' ) ).forEach( function( bttn ) {
			new UIMorphingButton( bttn, {
				closeEl : '.icon-close',
				onBeforeOpen : function() {
					// don't allow to scroll
					noScroll();
				},
				onAfterOpen : function() {
					// can scroll again
					canScroll();
				},
				onBeforeClose : function() {
					// don't allow to scroll
					noScroll();
				},
				onAfterClose : function() {
					// can scroll again
					canScroll();
				}
			} );
		} );

		// for demo purposes only
		[].slice.call( document.querySelectorAll( 'form button' ) ).forEach( function( bttn ) { 
			bttn.addEventListener( 'click', function( ev ) { ev.preventDefault(); } );
		} );
	})();
</script>
<script>
	$(function(){
		
		$('#username').keydown(function(){
			var username = $('#username').val();
			var username_rex = /[a-z,A-Z,0-9]/g;
			var valid_username = username_rex.test(username);
			if( !valid_username )
				$('#username').css('border','2px solid #e75854');
			else
				$('#username').css('border','2px solid #ebd3bd');
		});
	
		$('#useremail').keyup(function(){
			var email = $('#useremail').val();
			var email_rex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
			var valid_email = email_rex.test(email);
			if( !valid_email )
		    	$('#useremail').css('border','2px solid #e75854');
			else
				$('#useremail').css('border','2px solid #ebd3bd');
		});
		
		$('#userpassword').keyup(function(){
			var password = $('#userpassword').val();
			if(password.length >= 6)
				$('#userpassword').css('border','2px solid #ebd3bd');
			else
				$('#userpassword').css('border','2px solid #e75854');
		});
		
		$('#userconfirmpassword').keyup(function(){
			var password = $('#userpassword').val();
			var confirm_password = $('#userconfirmpassword').val();
			if(password == confirm_password)
				$('#userconfirmpassword').css('border','2px solid #ebd3bd');
			else
				$('#userconfirmpassword').css('border','2px solid #e75854');
		});
		
		$('#signup_btn').click(function(){
			var username = $('#username').val();
			var email = $('#useremail').val();
			var password = $('#userpassword').val();
			var confirm_password = $('#userconfirmpassword').val();
			
			var username_rex = /[a-z,A-Z,0-9]/g;
			var email_rex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
		    
			var valid_username = username_rex.test(username);
			var valid_email = email_rex.test(email);
			var valid_password = false;
			if( password.length >= 6 && password == confirm_password )
				valid_password = true;
			
			if( !valid_username )
		    	$('#username').css('border','2px solid #e75854');
			if( !valid_email )
		    	$('#useremail').css('border','2px solid #e75854');
		    if( !valid_password ){
		    	$('#userpassword').css('border','2px solid #e75854');
		    	$('#userconfirmpassword').css('border','2px solid #e75854');
		    }
		    
		    if( valid_username && valid_email && valid_password)
		    	$('#real_signup_btn').click();
		    
		});
		
		$('#signin_email').keyup(function(){
			var email = $('#signin_email').val();
			var email_rex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
			var valid_email = email_rex.test(email);
			if( !valid_email )
		    	$('#signin_email').css('border','2px solid #e75854');
			else
				$('#signin_email').css('border','2px solid #ebd3bd');
		});
		
		$('#signin_password').keyup(function(){
			var password = $('#signin_password').val();
			var password_rex = /[a-z,A-Z,0-9]/g;
			var valid_password = password_rex.test(password);
			
			if(!password)
				$('#signin_password').css('border','2px solid #e75854');
			else
				$('#signin_password').css('border','2px solid #ebd3bd');
		});
		
		$('#signin_btn').click(function(){
			var email = $('#signin_email').val();
			var password = $('#signin_password').val();
			
			var email_rex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
			var password_rex = /[a-z,A-Z,0-9]/g;
			
			var validemail = email_rex.test(email);
			var validpassword = password_rex.test(password);
			
			if( !validemail )
		    	$('#signin_email').css('border','2px solid #e75854');
		    if( !validpassword )
		    	$('#signin_password').css('border','2px solid #e75854');
			
		});
	});
</script>
<script type="text/javascript">
	function viewAjaxtest(){
		$.ajax({
			type	: "post"
			,url	: "/myapp/ajax_temp"
			,dataType 	: "json"
			,data	: ""
			,success	: function(result){}
			
		});
	}
	
</script>
</body>
</html>
