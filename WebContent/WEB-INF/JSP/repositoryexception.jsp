<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<c:set var='titel' value='Problemen bij ophalen data' />
<vdab:head title='${titel}' />
<body>
	<header>
		<vdab:title title='${titel}' image='datafout' />
		<vdab:menu />
	</header>
	<section>We kunnen de gevraagde data niet ophalen wegens een technische storing. Gelieve de helpdesk te
		contacteren.</section>
	<vdab:footer />
</body>
</html>