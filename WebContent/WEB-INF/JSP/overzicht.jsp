<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!doctype html>
<html lang='nl'>
<c:set var='titel' value='Overzicht' />
<vdab:head title='${titel}' />
<body>
	<vdab:header title='${titel}' image='bevestig' />
	<section>
		<vdab:reservaties titel='Gelukte reservaties' reservaties='${geluktereservaties}' gelukt='true' />
		<vdab:reservaties titel='Mislukte reservaties' reservaties='${misluktereservaties}' gelukt='false' />
	</section>
</body>
</html>
