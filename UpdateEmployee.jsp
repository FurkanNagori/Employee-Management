<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Guard>
<jsp:forward page='/loginPage.jsp'/>
</tm:Guard>
<tm:Module name='EMPLOYEE'/>
<jsp:useBean id='employeeBean' scope='request' class='com.thinking.machine.hr.beans.EmployeeBean'/>
<jsp:setProperty name='employeeBean' property='*'/>
<jsp:forward page='/UpdateEmployee' />