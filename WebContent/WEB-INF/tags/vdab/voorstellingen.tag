<%@tag pageEncoding='UTF-8'%>
<%@attribute name='titel' required='true' type='String'%>
<%@attribute name='voorstellingen' required='true' type='Iterable'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<section>
	<h2>${titel}</h2>
	<table>
		<tr>
			<th>Datum</th>
			<th>Title</th>
			<th>Uitvoerders</th>
			<th>Prijs</th>
			<th>Vrije plaatsen</th>
			<th>&nbsp;</th>
		</tr>
		<c:forEach var='voorstelling' items='${voorstellingen}'>
			<tr>
				<td><vdab:datum value='${voorstelling.utilDatum}' /></td>
				<td><c:out value='${voorstelling.titel}' /></td>
				<td><c:out value='${voorstelling.uitvoerders}' /></td>
				<td><vdab:bedrag value='${voorstelling.prijs}' /></td>
				<td>${voorstelling.vrijePlaatsen}</td>
				<td><c:if test='${voorstelling.reserveerbaar}'>
						<a href='reserveren.htm?voorstellingsid=${voorstelling.id}'>Reserveren</a>
					</c:if></td>
			</tr>
		</c:forEach>
	</table>
</section>