<%@tag pageEncoding='UTF-8'%>
<%@attribute name='value' required='true' type='java.util.Date'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<fmt:formatDate pattern="yyyy/MM/dd HH:mm" value='${value}' />
<!-- type='both' dateStyle='short' timeStyle='short'  -->