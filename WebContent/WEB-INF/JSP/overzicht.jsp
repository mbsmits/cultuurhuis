<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<c:set var='titel' value='Overzicht' />
<vdab:head title='${titel}' />
<body>
	<vdab:header title='${titel}' image='bevestig' />
	<section>
		<vdab:reservaties titel='Gelukte reservaties' reservaties='${geluktereservaties}' verwijderbaar='false'
			mislukt='false'
		/>
		<vdab:reservaties titel='Mislukte reservaties' reservaties='${misluktereservaties}' verwijderbaar='false'
			mislukt='true'
		/>
	</section>
</body>
</html>
