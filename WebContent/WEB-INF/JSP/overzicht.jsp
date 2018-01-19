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
		<section>
			Gelukte reservaties:
			<table>
				<tr>
					<th>Datum</th>
					<th>Title</th>
					<th>Uitvoerders</th>
					<th>Prijs</th>
					<th>Plaatsen</th>
				</tr>
				<c:forEach var='reservatie' items='${geluktereservaties}'>
					<tr>
						<td><vdab:datum value='${reservatie.voorstelling.utilDatum}' /></td>
						<td><c:out value='${reservatie.voorstelling.titel}' /></td>
						<td><c:out value='${reservatie.voorstelling.uitvoerders}' /></td>
						<td><vdab:bedrag value='${reservatie.voorstelling.prijs}' /></td>
						<td>${reservatie.plaatsen}</td>
					</tr>
				</c:forEach>
			</table>
		</section>
		<section>
			Mislukte reservaties:
			<table>
				<tr>
					<th>Datum</th>
					<th>Title</th>
					<th>Uitvoerders</th>
					<th>Prijs</th>
					<th>Plaatsen</th>
					<th>Vrije plaatsen</th>
				</tr>
				<c:forEach var='reservatie' items='${misluktereservaties}'>
					<tr>
						<td><vdab:datum value='${reservatie.voorstelling.utilDatum}' /></td>
						<td><c:out value='${reservatie.voorstelling.titel}' /></td>
						<td><c:out value='${reservatie.voorstelling.uitvoerders}' /></td>
						<td><vdab:bedrag value='${reservatie.voorstelling.prijs}' /></td>
						<td>${reservatie.plaatsen}</td>
						<td>${reservatie.voorstelling.vrijePlaatsen}</td>
					</tr>
				</c:forEach>
			</table>
		</section>
	</section>
</body>
</html>
