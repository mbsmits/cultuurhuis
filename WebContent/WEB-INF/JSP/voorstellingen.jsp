<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!doctype html>
<html lang='nl'>
<c:set var='titel' value='Voorstellingen' />
<vdab:head title='${titel}' />
<body>
	<vdab:header title='${titel}' image='voorstellingen' />
	<section>
		<c:if test='${! empty genre}'>
			<vdab:voorstellingen titel='${genre.naam} voorstellingen' voorstellingen='${voorstellingen}' />
		</c:if>
	</section>
	<vdab:footer />
</body>
</html>
