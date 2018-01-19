<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<c:set var='titel' value='Reserveren' />
<vdab:head title='${titel}' />
<body>
	<vdab:header title='${titel}' image='reserveren' />
	<form id='reserveerform'>
		<vdab:field label='Voorstelling' value='${voorstelling.titel}' />
		<vdab:field label='Uitvoerders' value='${voorstelling.uitvoerders}' />
		<vdab:field label='Datum' value='${voorstelling.datum}' />
		<vdab:field label='Prijs' value='${voorstelling.prijs}' />
		<vdab:field label='Vrije plaatsen' value='${voorstelling.vrijePlaatsen}' />
		<vdab:numberinputfield label='Plaatsen' name='plaatsen' />
		<p>
			<input type='hidden' name='voorstellingsid' value='${voorstelling.id}' /> <input id='reserveerknop' type='submit'
				value='Reserveren' formmethod='post' formaction='mandje.htm'
			>
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
