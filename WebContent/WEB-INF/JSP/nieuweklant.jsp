<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!doctype html>
<html lang='nl'>
<c:set var='titel' value='Nieuwe Klant' />
<vdab:head title='${titel}' />
<body>
	<vdab:header title='${titel}' image='nieuweklant' />
	<section>
		<form method='post'>
			<vdab:textinputfield label='Voornaam' name='voornaam' />
			<vdab:textinputfield label='Familienaam' name='familienaam' />
			<vdab:textinputfield label='Straat' name='straat' />
			<vdab:textinputfield label='Huisnr.' name='huisnr' />
			<vdab:textinputfield label='Postcode' name='postcode' />
			<vdab:textinputfield label='Gemeente' name='gemeente' />
			<vdab:textinputfield label='Gebruikersnaam' name='gebruikersnaam' />
			<vdab:passwordinputfield label='Paswoord' name='paswoord' />
			<vdab:passwordinputfield label='Herhaal paswoord' name='paswoord2' />
			<p>
				<input type='submit' value='OK' formmethod='post' formaction='nieuweklant.htm' />
			</p>
		</form>
		<ul>
			<li>Error 1</li>
			<li>Error 2</li>
		</ul>
	</section>
</body>
</html>
