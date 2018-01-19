<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<c:set var='titel' value='Pagina niet gevonden' />
<vdab:head title='${titel}' />
<body>
	<vdab:header title='${titel}' image='fout' />
	<section>De pagina die u zocht bestaat niet op onze website.</section>
</body>
</html>
