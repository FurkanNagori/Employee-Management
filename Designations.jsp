<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='DESIGNATION'/>
<jsp:include page='/MasterPageTopSection.jsp'/>
<h1>Designations</h1>
<div style='	height:40vh;border:1px solid black;margin-top:8px;margin-right:665px;margin-left:8px;overflow:scroll'>
<table border='1px solid black'>
<thead>
<tr>
<th colspan='4' style='text-align:right;padding:3px'><a href='/styletwo/DesignationAddForm.jsp'style='color:#2F4F4F'>Add new Designation</a></th>
</tr>
<tr style='background-color:#2F4F4F'>
<th style='width:60px;text-align:center;color:#E0FFFF'>S.no</th>
<th style='width:300px;text-align:center;color:#E0FFFF'>Designations</th>
<th style='width:150px;text-align:center;color:#E0FFFF'>Edit</th>
<th style='width:150px;text-align:center;color:#E0FFFF'>Delete</th>
</tr>
</thead>
<tbody>
<tm:EntityList populatorClass='com.thinking.machine.hr.bl.DesignationBl' populatorMethod='getAll' name='dBean'>
<tr>
<td style='width:60px;text-align:right'>${SerialNumber}.</td>
<td style='width:300px;text-align:center;background-color:#2F4F4F;color:#E0FFFF'>${dBean.title}</td>
<td style='width:100px;text-align:center'><a href='/styletwo/EditDesignation?code=${dBean.code}'style='color:#2F4F4F'><b>edit</b></a></td>
<td style='width:100px;text-align:center;background-color:#2F4F4F'><a href='/styletwo/ConfirmDeleteDesignation?code=${dBean.code}'style='color:#E0FFFF'><b>delete</b></a></td>
</tr>
</tm:EntityList>
</tbody>
</table>
</div>
<jsp:include page='/MasterPageBottomSection.jsp'/>