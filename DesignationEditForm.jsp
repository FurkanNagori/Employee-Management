<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='DESIGNATION'/>
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machine.hr.beans.DesignationBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machine.hr.beans.ErrorBean' />
<script src='/styletwo/js/DesignationAddForm.js'>
 </script>
<jsp:include page='/MasterPageTopSection.jsp'/>
<h2>Designation (Edit Module)</h2><br>
<span class = 'error'>
<jsp:getProperty name='errorBean' property='error' />
</span>

<form method='post' action='/styletwo/EditDesignation.jsp' onsubmit='return validateForm(this)'>
<input type="hidden" name="code" id="code" value="${designationBean.code}">  
Designation
<input type='text' id='title' name='title' maxlength='35' size='36' value='${designationBean.title}' style='background-color:#AFEEEE'>
<span id='titleErrorSection' class = 'error'></span><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button type='submit' style='background-color:#AFEEEE'>Update</button>

<form>
 <input type="button" style='background-color:#AFEEEE' value="Go back!" onclick="history.back()">
</form>


<jsp:include page='/MasterPageBottomSection.jsp'/>