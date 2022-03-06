<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<jsp:useBean id='messageBean' scope='request' class='com.thinking.machine.hr.beans.MessageBean' />

<jsp:include page='/MasterPageTopSection.jsp'/>
<h2>${messageBean.heading}</h2><br>
	<h3 style='color:#006400'>${messageBean.message}</h3>
	<tm:If condition ='${messageBean.generateButtons}'>
	<table>
	<tr>
	<td> 
		<form action ='/styletwo/${messageBean.buttonOneAction}'>
	    <button style='background-color:#AFEEEE'>${messageBean.buttonOneText}</button>
		</form>
    </td>
	<tm:If condition ='${messageBean.generateTwoButtons}'>
	<td>
		<form action ='/styletwo/${messageBean.buttonTwoAction}'>
	    <button style='background-color:#AFEEEE'>${messageBean.buttonTwoText}</button>
		</form>
	</td>
	</tm:If>
	</tr>
	</table>
	</tm:If>
<jsp:include page='/MasterPageBottomSection.jsp'/>