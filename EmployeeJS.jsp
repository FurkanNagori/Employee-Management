<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<script>
var employee;
<tm:EntityList populatorClass='com.thinking.machine.hr.bl.EmployeeBl' populatorMethod='getAll' name='eBean'>
employee = new Employee();
employee.employeeId="${eBean.employeeId}";
employee.name="${eBean.name}";
employee.designationCode=${eBean.designationCode};
employee.designation="${eBean.title}";
employee.dateOfBirth="${eBean.dateOfBirth}";
employee.gender="${eBean.gender}";
employee.isIndian=${eBean.isIndian};
employee.basicSalary=${eBean.basicSalary};
employee.panNumber="${eBean.panNumber}";
employee.aadharCardNumber="${eBean.aadharCardNumber}";
employees[${SerialNumber-1}] = employee;
</tm:EntityList>
</script>