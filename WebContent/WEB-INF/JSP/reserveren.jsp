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
		<vdab:field label='Voorstelling' value='Moest ik van u zijn' />
		<vdab:field label='Uitvoerders' value='Wouter Deprez' />
		<vdab:field label='Datum' value='18/11/09 20:00' />
		<vdab:field label='Prijs' value='&euro;6,00' />
		<vdab:field label='Vrije plaatsen' value='198' />
		<vdab:numberinputfield label='Plaatsen' name='plaatsen' />
		<p>
			<input type='submit' value='Reserveren' />
		</p>
	</form>
	<vdab:footer />
</body>
</html>
