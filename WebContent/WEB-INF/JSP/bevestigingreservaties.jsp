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
<vdab:head title='Het CultuurHuis: Bevestiging reservaties' />
<body>
	<vdab:title
		title='Het CultuurHuis: Bevestiging reservaties'
		image='bevestig'
	/>
	<vdab:menu />
	<form>
		<h2>Stap 1: Wie ben je?</h2>
		Gebruikersnaam:
		<br>
		<input type='text'></input>
		<br>
		<br>
		Paswoord:
		<br>
		<input type='password'></input>
		<br>
		<br>
		<input type='button'>
		<input type='button'>
		Joske Vermeulen ...
		<h2>Stap 2: Bevestigen</h2>
		<input type='button'>
	</form>
	<vdab:footer />
</body>
</html>
