<%@tag description='geformateerde datum' pageEncoding='UTF-8'%>
<%@attribute name='value' required='true' type='java.util.Date'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<fmt:formatDate type='both' dateStyle='short' timeStyle='short' value='${value}' />
