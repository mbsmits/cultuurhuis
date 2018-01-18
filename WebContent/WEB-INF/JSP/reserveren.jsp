<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<c:set var='titel' value='Reserveren' />
<vdab:head title='${titel}' />
<body>
	<vdab:header title='${titel}' image='reserveren' />
	<form>
		<vdab:field label='Voorstelling' value='${voorstelling.titel}' />
		<vdab:field label='Uitvoerders' value='${voorstelling.uitvoerders}' />
		<vdab:field label='Datum' value='${voorstelling.datum}' />
		<vdab:field label='Prijs' value='${voorstelling.prijs}' />
		<vdab:field label='Vrije plaatsen'
			value='${voorstelling.vrijePlaatsen}' />
		<vdab:numberinputfield label='Plaatsen' name='plaatsen' />
		<p>
			<input type='hidden' name='voorstellingsid'
				value='${voorstelling.id}' /> <input type='submit'
				value='Reserveren' formaction='mandje.htm'>
		</p>
	</form>
	<vdab:footer />
</body>
</html>
