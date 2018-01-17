<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<c:set var='titel' value='Problemen bij ophalen data' />
<vdab:head title='${titel}' />
<body>
	<vdab:header title='${titel}' image='datafout' />
	<section>
		We kunnen de gevraagde data niet ophalen wegens een technische storing. Gelieve de webbeheerder: <a
			href=”//mailto:mbsmits.vdab@gmail.com”
		>Marc Smits</a> te contacteren.
	</section>
	<vdab:footer />
</body>
</html>