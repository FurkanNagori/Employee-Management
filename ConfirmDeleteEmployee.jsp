<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='EMPLOYEE'/>
<jsp:useBean id='employeeBean' scope='request' class='com.thinking.machine.hr.beans.EmployeeBean' />
<jsp:include page='/MasterPageTopSection.jsp'/>
<h2>Employee (Delete Module)</h2><br>
<form method='post' action='/styletwo/DeleteEmployee.jsp' onsubmit='return validateForm(this)'>
<input type="hidden" name="employeeId" id="employeeId" value="${employeeBean.employeeId}">  
<table>
<tbody>
<tr>
<td><b style='color:#2F4F4F'>Employee Id : </b></td><td>${employeeBean.employeeId}</td>
</tr>
<tr>
<td><b style='color:#2F4F4F'>Name : </b></td><td>${employeeBean.name}</td>
</tr>
<tr>
<td><b style='color:#2F4F4F'>Designation : </b></td><td>${employeeBean.title}</td>
</tr>
<tr>
<td><b style='color:#2F4F4F'>Gender : </b></td><td>${employeeBean.gender}</td>
</tr>
<tr>
<td><b style='color:#2F4F4F'>Date of Birth : </b></td><td>${employeeBean.dateOfBirth}</td>
</tr>
<tr>
<td><b style='color:#2F4F4F'>Basic Salary : </b></td><td>${employeeBean.basicSalary}</td>
</tr>
<tr>
<td><b style='color:#2F4F4F'>Pan number : </b></td><td>${employeeBean.panNumber}</td>
</tr>
<tr>
<td><b style='color:#2F4F4F'>Aadhar card number : </b></td><td>${employeeBean.aadharCardNumber}</td>
</tr>
</tbody>
</table>
<br>
<b style='color:#A52A2A'>Are you sure !</b><br>
Delete Employee
<span style='color:#A52A2A'>
<b><jsp:getProperty name='employeeBean' property='name' /></b>
</span>



&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<button type='submit' style='background-color:#AFEEEE'>Yes</button>

<form>
 <input type="button" style='background-color:#AFEEEE' value="Go back!" onclick="history.back()">
</form>


<jsp:include page='/MasterPageBottomSection.jsp'/>