<%@tag pageEncoding='UTF-8'%>
<%@attribute name='titel' required='true' type='String'%>
<%@attribute name='reservaties' required='true' type='Iterable'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<section>
	<form method='post'>
		${titel}:
		<table>
			<tr>
				<th>Datum</th>
				<th>Titel</th>
				<th>Uitvoerders</th>
				<th>Prijs</th>
				<th>Plaatsen</th>
				<th><input type='submit' value='Verwijderen' formaction='mandje.htm' /></th>
			</tr>
			<c:forEach var='reservatie' items='${reservaties}'>
				<tr>
					<td><vdab:datum value='${reservatie.voorstelling.utilDatum}' /></td>
					<td><c:out value='${reservatie.voorstelling.titel}' /></td>
					<td><c:out value='${reservatie.voorstelling.uitvoerders}' /></td>
					<td><vdab:bedrag value='${reservatie.voorstelling.prijs}' /></td>
					<td>${reservatie.plaatsen}</td>
					<td><input type='checkbox' name='${reservatie.voorstelling.id}' /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
</section>