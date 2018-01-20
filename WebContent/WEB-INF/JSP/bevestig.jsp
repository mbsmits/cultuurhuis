<%@page contentType='text/html' pageEncoding='UTF-8'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<!doctype html>
<html lang='nl'>
<c:set var='titel' value='Bevestiging reservaties' />
<vdab:head title='${titel}' />
<body>
	<vdab:header title='${titel}' image='bevestig' />
	<section>
		<form>
			<h2>Stap 1: Wie ben je?</h2>
			<vdab:textinputfield label='Gebruikersnaam' name='gebruikersnaam'
				value='' />
			<vdab:passwordinputfield label='Paswoord' name='paswoord' value='' />
			<p>
				<input id='zoekmeopknop ' type='submit' value='Zoek me op'
					formmethod='get' formaction='bevestig.htm'
					<c:if test='${not empty klant}'>disabled</c:if>>
			</p>
			<p>
				<input id='ikbennieuwknop' type='submit' value='Ik ben nieuw'
					formmethod='get' formaction='nieuweklant.htm'
					<c:if test='${not empty klant}'>disabled</c:if>>
			</p>
		</form>
		<form id='bevestigform'>
			${klant.voornaam} ${klant.familienaam} ${klant.straat}
			${klant.postcode} ${klant.gemeente}
			<h2>Stap 2: Bevestigen</h2>
			<p>
				<input type='hidden' name='klantId' value='${klant.id}' /> <input
					id='bevestigknop' type='submit' value='Bevestigen'
					formmethod='post' formaction='overzicht.htm'
					<c:if test='${empty klant}'>disabled</c:if>>
			</p>
		</form>
	</section>
	<script>
		document.getElementById('bevestigform').onsubmit = function() {
			if (!navigator.cookieEnabled) {
				alert("Dit werkt enkel als cookies aanstaan");
				return false;
			}
			document.getElementById('bevestigknop').disabled = true;
		};
	</script>
</body>
</html>
