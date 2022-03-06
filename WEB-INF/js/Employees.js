function Employee()
{
this.employeeId="";
this.name="";
this.designationCode=0;
this.designation="";
this.dateOfBirth="";
this.gender="";
this.isIndian=true;
this.basicSalary=0;
this.panNumber="";
this.aadharCardNumber="";
}
var selectedRow = null;
var employees=[];
//aage ka code EmployeesJS.java m hai vha hm employees Array me data bhrege
function selectEmployee(row,employeeId)
{
if(row==selectedRow) return;
if(selectedRow!=null)
{
selectedRow.style.background="#E0FFFF";
selectedRow.style.color="black";
}
row.style.background="#20B2AA";
row.style.color="white";
selectedRow=row;
var i;
for(i=0; i<employees.length; i++)
{
 if(employees[i].employeeId==employeeId) break;
}
var emp=employees[i];
document.getElementById("detailPanel_employeeId").innerHTML=emp.employeeId;
document.getElementById("detailPanel_name").innerHTML=emp.name;
document.getElementById("detailPanel_designation").innerHTML=emp.designation;
document.getElementById("detailPanel_dateOfBirth").innerHTML=emp.dateOfBirth;
document.getElementById("detailPanel_gender").innerHTML=emp.gender;
if(emp.isIndian==true)
{
document.getElementById("detailPanel_isIndian").innerHTML="Yes";
}
else
{
document.getElementById("detailPanel_isIndian").innerHTML="No";
}
document.getElementById("detailPanel_basicSalary").innerHTML=emp.basicSalary;
document.getElementById("detailPanel_panNumber").innerHTML=emp.panNumber;
document.getElementById("detailPanel_aadharCardNumber").innerHTML=emp.aadharCardNumber;
}

function createDynamicRowOnClick(rowAddress,employeeId)
{
	return function()
	{
		selectEmployee(rowAddress,employeeId);
	};
}
function populateEmployeeGridTable()
{
	var employeesGridTable = document.getElementById("employeesGridTable");
	var employeeGridTableBody = employeesGridTable.getElementsByTagName("tbody")[0];
    var employeeGridTableBodyRow = employeeGridTableBody.getElementsByTagName("tr")[0];
	employeeGridTableBodyRow.remove();
	var dynamicRow;
	var dynamicRowCells;
	var cellTemplate;
	var placeHolderFor;
	for(var k=0; k<employees.length; k++)
	{
		dynamicRow = employeeGridTableBodyRow.cloneNode(true);
		employeeGridTableBody.appendChild(dynamicRow);
		dynamicRowCells=dynamicRow.getElementsByTagName("td");
		for(i=0; i<dynamicRowCells.length; i++)
		{
			cellTemplate = dynamicRowCells[i];
			placeHolderFor = cellTemplate.getAttribute("placeHolderId");
			if(placeHolderFor==null) continue;
			if(placeHolderFor=="serialNumber") cellTemplate.innerHTML=(k+1);
			if(placeHolderFor=="employeeId") cellTemplate.innerHTML=employees[k].employeeId;
			if(placeHolderFor=="name") cellTemplate.innerHTML=employees[k].name;
			if(placeHolderFor=="designationCode") cellTemplate.innerHTML=employees[k].designationCode;
			if(placeHolderFor=="title") cellTemplate.innerHTML=employees[k].designation;
		    if(placeHolderFor=="dateOfBirth") cellTemplate.innerHTML=employees[k].dateOfBirth;
			if(placeHolderFor=="gender") cellTemplate.innerHTML=employees[k].gender;
			if(placeHolderFor=="isInidan") cellTemplate.innerHTML=employees[k].isInidan;
		    if(placeHolderFor=="basicSalary") cellTemplate.innerHTML=employees[k].basicSalary;
		    if(placeHolderFor=="panNumber") cellTemplate.innerHTML=employees[k].panNumber;
		    if(placeHolderFor=="aadharCardNumber") cellTemplate.innerHTML=employees[k].aadharCardNumber;
			if(placeHolderFor=="editOption") cellTemplate.innerHTML="<a href='/styletwo/EditEmployee?employeeId="+employees[k].employeeId+"'><b style='color:#2F4F4F'>edit</b></a>";
		    if(placeHolderFor=="deleteOption") cellTemplate.innerHTML="<a href='/styletwo/ConfirmDeleteEmployee?employeeId="+employees[k].employeeId+"'><b style='color:#E0FFFF'>delete</b></a>";
		}
		dynamicRow.onclick = createDynamicRowOnClick(dynamicRow,employees[k].employeeId);
    }
}
window.addEventListener('load',populateEmployeeGridTable);
