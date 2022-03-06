<jsp:useBean id='adminBean' scope='request' class='com.thinking.machine.hr.beans.AdminBean'/>
<jsp:setProperty name='adminBean' property='*'/>
<jsp:forward page='/Login'/>