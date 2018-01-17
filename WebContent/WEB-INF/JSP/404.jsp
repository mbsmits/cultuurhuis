<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<c:set var='titel' value='Pagina niet gevonden' />
<vdab:head title='${titel}' />
<body>
	<header>
		<vdab:title title='${titel}' image='fout' />
		<vdab:menu />
	</header>
	<section>De pagina die u zocht bestaat niet op onze website.</section>
	<vdab:footer />
</body>
</html>
