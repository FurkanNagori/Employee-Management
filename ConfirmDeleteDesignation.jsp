<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='DESIGNATION'/>
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machine.hr.beans.DesignationBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machine.hr.beans.ErrorBean' />
<jsp:include page='/MasterPageTopSection.jsp'/>
<h2>Designation (Delete Module)</h2><br>

<form method='post' action='/styletwo/DeleteDesignation.jsp' onsubmit='return validateForm(this)'>
<input type="hidden" name="code" id="code" value="${designationBean.code}">  
<b style='color:#A52A2A'>Are you sure !</b><br>
Delete 
<span style='color:#A52A2A'>
<b><jsp:getProperty name='designationBean' property='title' /></b>
</span>


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button type='submit' style='background-color:#AFEEEE'>Yes</button>

<form>
 <input type="button" style='background-color:#AFEEEE' value="Go back!" onclick="history.back()">
</form>


<jsp:include page='/MasterPageBottomSection.jsp'/>