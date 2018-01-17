<%@tag description='text field onderdeel van een form' pageEncoding='UTF-8'%>
<%@attribute name='titel' required='true' type='java.lang.String'%>
<%@attribute name='reservaties' required='true' type='java.util.SortedSet'%>
<%@attribute name='gelukt' required='false' type='java.lang.Boolean'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<p>${titel}:
<table>
	<tr>
		<th>Datum</th>
		<th>Title</th>
		<th>Uitvoerders</th>
		<th>Prijs (€)</th>
		<th>Plaatsen</th>
	</tr>
	<c:forEach var='reservatie' items='${reservaties}'>
		<tr>
			<td>${reservatie.voorstelling.datum}</td>
			<td>
				<c:out value='${reservatie.voorstelling.titel}' />
			</td>
			<td>
				<c:out value='${reservatie.voorstelling.uitvoerders}' />
			</td>
			<td>${reservatie.voorstelling.prijs}</td>
			<td>${reservatie.plaatsen}</td>
			<c:if test='${!gelukt}'>
				<td>${reservatie.voorstelling.vrijePlaatsen}</td>
			</c:if>
		</tr>
	</c:forEach>
</table>
</p>