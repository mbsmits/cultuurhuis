<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<c:set var='titel' value='Reserveren' />
<vdab:head title='${titel}' />
<body>
	<vdab:header title='${titel}' image='reserveren' />
	<form id='reserveerform' method='post'>
		<p>
			Voorstelling<br> <b>${voorstelling.titel}</b>
		</p>
		<p>
			Uitvoerders<br> <b>${voorstelling.uitvoerders}</b>
		</p>
		<p>
			Datum<br> <b><vdab:datum value='${voorstelling.utilDatum}' /></b>
		</p>
		<p>
			Prijs<br> <b><vdab:bedrag value='${voorstelling.prijs}' /></b>
		</p>
		<p>
			Vrije plaatsen<br> <b>${voorstelling.vrijePlaatsen}</b>
		</p>
		<vdab:numberinputfield label='Plaatsen' name='plaatsen' minValue='1' maxValue='${voorstelling.vrijePlaatsen}'
			value='${plaatsen}'
		/>
		<p>
			<input type='hidden' name='voorstellingId' value='${voorstelling.id}' /> <input id='reserveerknop' type='submit'
				value='Reserveren'
			> ${fout}
		</p>
	</form>
	<script>
		document.getElementById('reserveerform').onsubmit = function() {
			if (!navigator.cookieEnabled) {
				alert("Dit werkt enkel als cookies aanstaan");
				return false;
			}
			document.getElementById('reserveerknop').disabled = true;
		};
	</script>
</body>
</html>
