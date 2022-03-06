
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machine.hr.beans.ErrorBean' />
<!DOCTYPE html>
<html lang='en'>
<head>
<title>HR application</title>
<script>
function validateForm(frm)
{
var username = frm.username.value.trim();
var usernameErrorSection = document.getElementById('usernameErrorSection');
usernameErrorSection.innerHTML='';
var password = frm.password.value.trim();
var passwordErrorSection = document.getElementById("passwordErrorSection");
if(username.length==0)
{
usernameErrorSection.innerHTML='Required';
frm.username.focus();
return false;
}
if(password.length==0)
{
	passwordErrorSection.innerHTML='Required';
	return false;
}
return true;
}
</script>
<link rel='stylesheet' type='text/css' href='/styletwo/css/styles.css'>
</head>
<body>
<!--main container start-->
<div class = 'main-container'>
<!--header container start-->
<div class = 'header'>
<img src='/styletwo/images/logo4.svg' height='50' class = 'logo'>
<div class = 'brand-name'>Employeeify</div>
</div><!--header container end-->
<!--mid container start-->
<div class = 'mid-container'>
<div class='loginPage'>
<form method='post'action='/styletwo/login.jsp' onsubmit='return validateForm(this)'>
<span class = 'error'>
<jsp:getProperty name='errorBean' property='error' />
</span><br><br>

<b>User name</b>
<input type='text' id='username' name='username' maxlength='15'>
<span id='usernameErrorSection' class = 'error'></span><br><br>
&nbsp;
<b>password</b>
<input type='password' id='password' name='password' maxlength='15'>
<span id='passwordErrorSection' class = 'error'></span><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button type='submit'>Login</button>
</form>
</div>
</div><!--mid container end-->
<!--footer container start-->
<div class = 'footer'>
&copy; <b style='font-family:"Comic Sans MS";color:#AFEEEE'>Employeeify</b>
</div><!--footer container end-->
</div><!--main container end-->
</body>
</html>