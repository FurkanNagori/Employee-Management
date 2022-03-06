<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='DESIGNATION'/>

<jsp:useBean id='designationBean' scope='request' class='com.thinking.machine.hr.beans.DesignationBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machine.hr.beans.ErrorBean' />
<script src='/styletwo/js/DesignationAddForm.js'>
 </script>
<jsp:include page='/MasterPageTopSection.jsp'/>
<h2>Designation (Add Module)</h2><br>
<span class = 'error'>
<jsp:getProperty name='errorBean' property='error' />
</span>
<form method='post' action='/styletwo/AddDesignation.jsp' onsubmit='return validateForm(this)'>
Designation
<tm:UId/>
<input type='text' id='title' name='title' maxlength='35' size='36' value='${designationBean.title}' style='background-color:#AFEEEE'>
<span id='titleErrorSection' class = 'error'></span><br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button type='submit' style='background-color:#AFEEEE'>Add</button>

<form>
 <input type="button" style='background-color:#AFEEEE' value="Go back!" onclick="history.back()">
</form>
<jsp:include page='/MasterPageBottomSection.jsp'/>

