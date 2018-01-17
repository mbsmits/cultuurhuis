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
		<c:if test='${!gelukt}'>
			<h2>${genre.naam}voorstellingen</h2>
			<table>
				<tr>
					<th>Datum</th>
					<th>Title</th>
					<th>Uitvoerders</th>
					<th>Prijs (€)</th>
					<th>Vrije plaatsen</th>
					<th>Reserveren</th>
				</tr>
				<c:forEach var='voorstelling' items='${voorstellingen}'>
					<tr>
						<td>${voorstelling.datum}</td>
						<td>
							<c:out value='${voorstelling.titel}' />
						</td>
						<td>
							<c:out value='${voorstelling.uitvoerders}' />
						</td>
						<td>${voorstelling.prijs}</td>
						<td>${voorstelling.vrijePlaatsen}</td>
						<td>
							<c:if test='${voorstelling.reserveerbaar}'>
								<a href='reserveren.htm'>Reserveren</a>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</section>
	<vdab:footer />
</body>
</html>
