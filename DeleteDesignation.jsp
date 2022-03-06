<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Guard>
<jsp:forward page='/loginPage.jsp'/>
</tm:Guard>
<tm:Module name='DESIGNATION'/>
<jsp:useBean id='designationBean' scope='request' class='com.thinking.machine.hr.beans.DesignationBean'/>
<jsp:setProperty name='designationBean' property='code'/>
<jsp:forward page='/DeleteDesignation' />