<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<c:set var='titel' value='Pagina niet gevonden' />
<vdab:head title='${titel}' />
<body>
	<vdab:header title='${titel}' image='fout' showVoorstellingenLink='true' showMandjeLink='true' showBevestigLink ='true'/>
	<section>De pagina die u zocht bestaat niet op onze website.</section>
</body>
</html>


