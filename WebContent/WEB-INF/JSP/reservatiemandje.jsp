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
<vdab:head title='Het CultuurHuis: Reservatiemandje' />
<body>
	<header>
		<vdab:title
			title='Het CultuurHuis: Reservatiemandje'
			image='mandje'
		/>
		<vdab:menu />
	</header>
	<section>
		<table>
			<tr>
				<th>Datum</th>
				<th>Title</th>
				<th>Uitvoerders</th>
				<th>Prijs (€)</th>
				<th>Plaatsen</th>
				<th><input
					type='submit'
					value='Verwijderen'
				/></th>
			</tr>
			<tr>
				<td>23/01/10 20:00</td>
				<td>White Light White Heat - The Velvet Underground</td>
				<td>Bea Van der Maat &amp; Dr Kloot Per W</td>
				<td>5,50</td>
				<td>4</td>
				<td><input type='checkbox' /></td>
			</tr>
			<tr>
				<td>23/01/10 20:00</td>
				<td>White Light White Heat - The Velvet Underground</td>
				<td>Bea Van der Maat &amp; Dr Kloot Per W</td>
				<td>5,50</td>
				<td>4</td>
				<td><input type='checkbox' /></td>
			</tr>
			<tr>
				<td>23/01/10 20:00</td>
				<td>White Light White Heat - The Velvet Underground</td>
				<td>Bea Van der Maat &amp; Dr Kloot Per W</td>
				<td>5,50</td>
				<td>4</td>
				<td><input type='checkbox' /></td>
			</tr>
			<tr>
				<td colspan='6'>Te betalen (€): 654,54</td>
			</tr>
		</table>
	</section>
	<vdab:footer />
</body>
</html>
