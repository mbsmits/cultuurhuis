<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<c:set var='titel' value='Problemen bij ophalen data' />
<vdab:head title='${titel}' />
<body>
	<vdab:header title='${titel}' image='datafout' />
	<section>We kunnen de gevraagde data niet ophalen wegens een
		technische storing. Gelieve de helpdesk te contacteren.</section>
</body>
</html>