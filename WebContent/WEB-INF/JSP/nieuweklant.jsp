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
<vdab:head title='Het CultuurHuis: Nieuwe Klant' />
<body>
	<vdab:title
		title='Het CultuurHuis: Nieuwe Klant'
		image='nieuweklant'
	/>
	<vdab:menu />
	<form
		method='post'
		action='bevestigingreservaties.htm'
	>
		<p>
			<label for='voornaam'>Voornaam:</label>
			<input name='voornaam' />
		</p>
		<p>
			<label for='familienaam'>Familienaam:</label>
			<input name='familienaam' />
		</p>
		<p>
			<label for='straat'>Straat:</label>
			<input name='straat' />
		</p>
		<p>
			<label for='huisnr'>Huisnr.:</label>
			<input name='huisnr' />
		</p>
		<p>
			<label for='postcode'>Postcode:</label>
			<input name='postcode' />
		</p>
		<p>
			<label for='gemeente'>Gemeente:</label>
			<input name='gemeente' />
		</p>
		<p>
			<label for='paswoord'>Paswoord:</label>
			<input
				type='password'
				name='paswoord'
			/>
		</p>
		<p>
			<label for='paswoord2'>Herhaal paswoord:</label>
			<input
				type='password'
				name='paswoord2'
			/>
		</p>
		<p>
			<input
				type='submit'
				value='OK'
			/>
		</p>
	</form>
	<ul>
		<li>Error 1</li>
		<li>Error 2</li>
	</ul>
</body>
</html>
