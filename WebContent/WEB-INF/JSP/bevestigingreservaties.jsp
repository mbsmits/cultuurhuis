<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!doctype html>
<html lang='nl'>
<vdab:head title='Het CultuurHuis: Bevestiging reservaties' />
<body>
	<header>
		<vdab:title title='Het CultuurHuis: Bevestiging reservaties' image='bevestig' />
		<vdab:menu />
	</header>
	<section>
		<form>
			<h2>Stap 1: Wie ben je?</h2>
			<vdab:textinputfield label='Gebruikersnaam' name='gebruikersnaam' value='...' />
			<vdab:passwordinputfield label='Paswoord' name='paswoord' value='...' />
			<p>
				<input type='submit' value='Zoek me op'>
			</p>
			<p>
				<input type='submit' value='Ik ben nieuw'>
			</p>
			Joske Vermeulen ...
			<h2>Stap 2: Bevestigen</h2>
			<p>
				<input type='submit' value='Bevestigen'>
			</p>
		</form>
	</section>
	<vdab:footer />
</body>
</html>
