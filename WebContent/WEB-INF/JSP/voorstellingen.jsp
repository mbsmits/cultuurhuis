<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<c:set var='titel' value='Voorstellingen' />
<vdab:head title='${titel}' />
<body>
	<vdab:header title='${titel}' image='voorstellingen' showVoorstellingenLink='false' showMandjeLink='true' showBevestigLink ='true'/>
	<section>
		<c:if test='${! empty genre}'>
			<vdab:voorstellingen titel='${genre.naam} voorstellingen'
				voorstellingen='${voorstellingen}' />
		</c:if>
	</section>
</body>
</html>
