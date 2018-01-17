<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!doctype html>
<html lang='nl'>
<c:set var='titel' value='Voorstellingen' />
<vdab:head title='${titel}' />
<body>
	<header>
		<vdab:title title='${titel}' image='voorstellingen' />
		<nav>
			<h2>Genres</h2>
			<ul>
				<c:forEach var='genre' items='${genres}'>
					<li>
						<a href='voorstellingen.htm?genreid=${genre.id}'> ${genre.naam}</a>
					</li>
				</c:forEach>
			</ul>
		</nav>
	</header>
	<section>
		<c:if test='${! empty genre}'>
			<vdab:voorstellingen titel='${genre.naam} voorstellingen' voorstellingen='${voorstellingen}' />
		</c:if>
	</section>
	<vdab:footer />
</body>
</html>
