<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!doctype html>
<html lang='nl'>
<vdab:head title='Het CultuurHuis: Overzicht' />
<body>
	<header>
		<vdab:title title='Het CultuurHuis: Overzicht' image='bevestig' />
		<vdab:menu />
	</header>
	<section>
		<vdab:reservaties titel='Gelukte reservaties' reservaties='${geluktereservaties}' gelukt='true' />
		<vdab:reservaties titel='Mislukte reservaties' reservaties='${misluktereservaties}' gelukt='false' />
	</section>
</body>
</html>
