<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='EMPLOYEE'/>
<link rel='stylesheet' type='text/css' href='/styletwo/css/Employees.css'>
<jsp:include page='/MasterPageTopSection.jsp'/>
<script src='/styletwo/js/Employees.js'></script>
<h1 style='text-align:left'>Employees</h1>
<div class='EmployeeGrid'>
<table border='1' id='employeesGridTable'>
<thead>
<tr>
<th colspan='6' class='TopTableRow'><a href='/styletwo/EmployeeAddForm.jsp'><b style='color:#2F4F4F'>Add new Employee</b></a></th>
</tr>
<tr>
<th class='SnoInTable'>S.no</th>
<th class='IdInTable'>Id.</th>
<th class='NameInTable'>Name</th>
<th class='DesignationInTable'>Designation</th>
<th class='EditLinkInTable'>Edit</th>
<th class='DeleteLinkInTable'>Delete</th>
</tr>
</thead>
<tbody>

<tr style='cursor:pointer'>
<td style='text-align:right' placeHolderId='serialNumber'></td>
<td style='text-align:center;background:#2F4F4F;color:#E0FFFF' placeHolderId='employeeId'></td>
<td style='text-align:center' placeHolderId='name'></td>
<td style='text-align:center;background:#2F4F4F;color:#E0FFFF' placeHolderId='title'></td>
<td style='text-align:center' placeHolderId='editOption'></td>
<td style='text-align:center;background:#2F4F4F' placeHolderId='deleteOption'></td>
</tr>

</tbody>
</table>
</div>
<!--Panel section starts here-->
<div class='panelSection'>
<label style='background:#2F4F4F;color:#E0FFFF;padding-left:5px;padding-right:5px;margin-top:8px;margin-left:8px;'>Details</label>
<table border='0' width='100%'>
<tr>
<td><b style='color:#2F4F4F'>Employee Id : </b><span id='detailPanel_employeeId' style='margin-right:30px'></span></td>
<td><b style='color:#2F4F4F'>Name : </b><span id='detailPanel_name' style='margin-right:30px'></span></td>
<td><b style='color:#2F4F4F'>Designation : </b><span id='detailPanel_designation' style='margin-right:30px'></span></td>
</tr>
<tr>
<td><b style='color:#2F4F4F'>Date of Birth : </b><span id='detailPanel_dateOfBirth' style='margin-right:30px'></span></td>
<td><b style='color:#2F4F4F'>Gender : </b><span id='detailPanel_gender' style='margin-right:30px'></span></td>
<td><b style='color:#2F4F4F'>Is indian : </b><span id='detailPanel_isIndian' style='margin-right:30px'></span></td>
</tr>
<tr>
<td><b style='color:#2F4F4F'>Basic salary : </b><span id='detailPanel_basicSalary' style='margin-right:30px'></span></td>
<td><b style='color:#2F4F4F'>Pan card no. : </b><span id='detailPanel_panNumber' style='margin-right:30px'></span></td>
<td><b style='color:#2F4F4F'>Aadhar card no. : </b><span id='detailPanel_aadharCardNumber' style='margin-right:30px'></span></td>
</tr>
</table>
</div>
<!--Panel section ends here-->
<jsp:include page='/MasterPageBottomSection.jsp'/>