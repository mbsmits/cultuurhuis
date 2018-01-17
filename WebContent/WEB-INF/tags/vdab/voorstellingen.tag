<%@tag description='text field onderdeel van een form' pageEncoding='UTF-8'%>
<%@attribute name='titel' required='true' type='java.lang.String'%>
<%@attribute name='voorstellingen' required='true' type='java.util.SortedSet'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<section>
	${titel}:
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
				<td>
					<fmt:formatNumber value='${voorstelling.prijs}' />
				</td>
				<td>
					<c:if test='${voorstelling.reserveerbaar}'>
						<a href='reserveren.htm'>Reserveren</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</section>