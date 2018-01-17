<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!doctype html>
<html lang='nl'>
<c:set var='titel' value='Bevestiging reservaties' />
<vdab:head title='${titel}' />
<body>
	<vdab:header title='${titel}' image='bevestig' />
	<section>
		<form>
			<h2>Stap 1: Wie ben je?</h2>
			<vdab:textinputfield label='Gebruikersnaam' name='gebruikersnaam' value='...' />
			<vdab:passwordinputfield label='Paswoord' name='paswoord' value='...' />
			<p>
				<input type='submit' value='Zoek me op' formmethod='post' formaction='bevestigingreservaties.htm'>
			</p>
			<p>
				<input type='submit' value='Ik ben nieuw' formmethod='post' formaction='nieweklant.htm'>
			</p>
			Joske Vermeulen ...
			<h2>Stap 2: Bevestigen</h2>
			<p>
				<input type='submit' value='Bevestigen' formmethod='post' formaction='overzicht.htm'>
			</p>
		</form>
	</section>
	<vdab:footer />
</body>
</html>
