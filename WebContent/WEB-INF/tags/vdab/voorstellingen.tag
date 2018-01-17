<%@tag description='text field onderdeel van een form' pageEncoding='UTF-8'%>
<%@attribute name='titel' required='true' type='java.lang.String'%>
<%@attribute name='voorstellingen' required='true' type='java.util.SortedSet'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<section>
	<h2>${titel}</h2>
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
				<td>
					<fmt:formatDate type='both' dateStyle='short' timeStyle='short' value='${voorstelling.utilDatum}' />
				</td>
				<td>
					<c:out value='${voorstelling.titel}' />
				</td>
				<td>
					<c:out value='${voorstelling.uitvoerders}' />
				</td>
				<td>
					&euro; <fmt:formatNumber minFractionDigits='2' maxFractionDigits='2' value='${voorstelling.prijs}' />
				</td>
				<td>${voorstelling.vrijePlaatsen}</td>
				<td>
					<c:if test='${voorstelling.reserveerbaar}'>
						<a href='reserveren.htm'>Reserveren</a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
</section>