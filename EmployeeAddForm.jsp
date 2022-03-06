<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm'%>
<tm:Module name='EMPLOYEE'/>
<jsp:useBean id='employeeBean' scope='request' class='com.thinking.machine.hr.beans.EmployeeBean' />
<jsp:useBean id='errorBean' scope='request' class='com.thinking.machine.hr.beans.ErrorBean' />
<jsp:include page = '/MasterPageTopSection.jsp'/>
<script src='/styletwo/js/EmployeeAddForm.js'></script>
<h2>Employee (Add Module)</h2>
<span class = 'error'>
<jsp:getProperty name='errorBean' property='error' />
</span>
<form method='post' action='/styletwo/AddEmployee.jsp' onsubmit='return validateForm(this)'>
<tm:UId/>
<table>
<tr>
<td style='color:#2F4F4F'><b>Name</b></td>
<td><input type='text' id='name' name='name' value='${employeeBean.name}' maxlength='50' size='30' style='background-color:#AFEEEE'>
<span id='nameErrorSection' class='error'></span></td>
</tr>

<tr>
<td style='color:#2F4F4F'><b>Designation</b></td>
<td><select style='background-color:#AFEEEE' id='designationCode' name='designationCode'>
<option value='-1' style='color:#2F4F4F'>&lt;Select Designation&gt;</option>
<tm:EntityList populatorClass='com.thinking.machine.hr.bl.DesignationBl' populatorMethod='getAll' name='dBean'>
<b><option value='${dBean.code}'>${dBean.title}</option></b>
</tm:EntityList>
</select>
<span id='designationCodeErrorSection' class='error'></span>
</td>
</tr>

<tr>
<td style='color:#2F4F4F'><b>Date of birth</b></td>
<td><input type='date' id='dateOfBirth' name='dateOfBirth' value='${employeeBean.dateOfBirth}' style='background-color:#AFEEEE'>
<span id='dateOfBirthErrorSection' class='error'></span></td>
</tr>

<tr>
<td style='color:#2F4F4F'><b>Gender</b></td>
<td><input type='radio' id='male' name='gender' value='M'> <b style='color:#2F4F4F'>Male</b>
<input type='radio' id='female' name='gender' value='F'> <b style='color:#2F4F4F'>Female</b>
<span id='genderErrorSection' class='error'></span>
</td>
</tr>

<tr>
<td style='color:#2F4F4F'><b>Indian ?</b></td>
<td><input type='checkbox' id='isIndian' name='isIndian' value='true'>
</td>
</tr>

<tr>
<td style='color:#2F4F4F'><b>Basic salary</b></td>
<td><input type='text' style='text-align:right; background-color:#AFEEEE' id='basicSalary' name='basicSalary' value='${employeeBean.basicSalary}' maxlength='12' size='13'>
<span id='basicSalaryErrorSection' class='error'></span>
</td>
</tr>

<tr>
<td style='color:#2F4F4F'><b>Pan card number</b></td>
<td><input type='text' id='panNumber' name='panNumber' value='${employeeBean.panNumber}' maxlength='15' size='16' style='background-color:#AFEEEE'>
<span id='panNumberErrorSection' class='error'></span></td>
</tr>

<tr>
<td style='color:#2F4F4F'><b>Aadhar card number</b></td>
<td><input type='text' id='aadharCardNumber' name='aadharCardNumber' value='${employeeBean.aadharCardNumber}' maxlength='15' size='16' style='background-color:#AFEEEE'>
<span id='aadharCardNumberErrorSection' class='error'></span></td>
</tr>

<tr>
<td colspan='2'><button  style='background-color:#AFEEEE' type='submit'>Add</button>
&nbsp;&nbsp;
<form>
 <input style='background-color:#AFEEEE' type="button" value="Go back!" onclick="history.back()">
</form></td>
</tr>
</table>
<jsp:include page='/MasterPageBottomSection.jsp'/>