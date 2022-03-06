
<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<tm:Guard>
<jsp:forward page='/loginPage.jsp'/>
</tm:Guard>

<!DOCTYPE html>
<html lang='en'>
<head>
<title>HR application</title>
<link rel='stylesheet' type='text/css' href='/styletwo/css/styles.css'>
</head>
<body>
<!--main container start-->
<div class = 'main-container'>
<!--header container start-->
<div class = 'header'>
<a href='/styletwo/index.jsp'><img src='/styletwo/images/logo4.svg' height='50' class = 'logo'></a>
<div class = 'brand-name'>Employeeify</div>
<div style='float:right;margin-right:10px;margin-top:10px'>
<img src='/styletwo/images/user_icon.svg' height='30'/>
<b style='color:#E0FFFF; font-family:"Comic Sans MS"'>${username}</b>
&nbsp;
<a href='/styletwo/Logout'><b style='color:#AFEEEE; font-family:"Comic Sans MS"'>logout</b></a>


</div>
</div><!--header container end-->
<!--mid container start-->
<div class = 'mid-container'>
<!--left panel start-->
<div class = 'left-panel'>

<tm:If condition='${module==DESIGNATION}'>
<b>Designations</b><br>
</tm:If>
<tm:If condition='${module!=DESIGNATION}'>
<a href='/styletwo/Designations.jsp' style='color:#E0FFF'>Designations</a><br>
</tm:If>
<tm:If condition='${module==EMPLOYEE}'>
<b>Employees</b><br>
</tm:If>
<tm:If condition='${module!=EMPLOYEE}'>
<a href='/styletwo/Employees.jsp' style='color:#E0FFF'>Employees</a><br>
</tm:If>
<tm:If condition='${module!=HOME}'>
<a href='/styletwo/index.jsp' style='color:#E0FFF'>Home</a>
</tm:If>

</div><!--left panel end-->
<!--right panel start-->
<div class = 'right-panel'>