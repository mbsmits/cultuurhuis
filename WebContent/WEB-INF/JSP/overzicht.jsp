<%@page
	contentType='text/html'
	pageEncoding='UTF-8'
%>
<%@taglib
	uri='http://vdab.be/tags'
	prefix='vdab'
%>
<%@taglib
	prefix='c'
	uri='http://java.sun.com/jsp/jstl/core'
%>
<%@taglib
	prefix='fmt'
	uri='http://java.sun.com/jsp/jstl/fmt'
%>
<!doctype html>
<html lang='nl'>
<vdab:head title='Het CultuurHuis: Overzicht' />
<body>
	<header>
		<vdab:title
			title='Het CultuurHuis: Overzicht'
			image='bevestig'
		/>
		<vdab:menu />
	</header>
	<section>
		Gelukte reserveringen:
		<table>
			<tr>
				<th>Datum</th>
				<th>Title</th>
				<th>Uitvoerders</th>
				<th>Prijs (€)</th>
				<th>Plaatsen</th>
			</tr>
		</table>
		Mislukte reserveringen:
		<table>
			<tr>
				<th>Datum</th>
				<th>Title</th>
				<th>Uitvoerders</th>
				<th>Prijs (€)</th>
				<th>Plaatsen</th>
				<th>Vrije plaatsen</th>
			</tr>
		</table>
	</section>
</body>
</html>
