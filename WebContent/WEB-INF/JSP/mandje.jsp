<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<c:set var='titel' value='Reservatiemandje' />
<vdab:head title='${titel}' />
<body>
	<vdab:header title='${titel}' image='mandje' />
	<section>
		<section>
			<form id='verwijderform' method='post'>
				${titel}:
				<table>
					<tr>
						<th>Datum</th>
						<th>Titel</th>
						<th>Uitvoerders</th>
						<th>Prijs</th>
						<th>Plaatsen</th>
						<th><input id='verwijderknop' type='submit' value='Verwijderen' formaction='mandje.htm' /></th>
					</tr>
					<c:forEach var='reservatie' items='${mandje}'>
						<tr>
							<td><vdab:datum value='${reservatie.voorstelling.utilDatum}' /></td>
							<td><c:out value='${reservatie.voorstelling.titel}' /></td>
							<td><c:out value='${reservatie.voorstelling.uitvoerders}' /></td>
							<td><vdab:bedrag value='${reservatie.voorstelling.prijs}' /></td>
							<td>${reservatie.plaatsen}</td>
							<td><input type='checkbox' name='verwijderVoorstelling${reservatie.voorstelling.id}' /></td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</section>
		Te betalen:
		<vdab:bedrag value='${totaal}' />
	</section>
	<script>
		document.getElementById('verwijderform').onsubmit = function() {
			if (!navigator.cookieEnabled) {
				alert("Dit werkt enkel als cookies aanstaan");
				return false;
			}
			document.getElementById('verwijderknop').disabled = true;
		};
	</script>
</body>
</html>
