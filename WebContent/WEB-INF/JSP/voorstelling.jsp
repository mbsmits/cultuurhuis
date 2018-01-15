<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib uri='http://vdab.be/tags' prefix='vdab'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<!doctype html>
<html lang='nl'>
<head>
<vdab:head title='${voorstelling.titel}' />
</head>
<body>
	<vdab:menu />
	<c:choose>
		<c:when test='${not empty fout}'>
			<div class='fout'>${fout}</div>
		</c:when>
		<c:when test="${empty voorstelling}">
			<div class='fout'>Voorstelling niet gevonden</div>
		</c:when>
		<c:otherwise>
	
			<h1>${voorstelling.titel}</h1>
			<dl>
				<dt>Uitvoerders</dt>
				<dd>${voorstelling.uitvoerders}</dd>
				<dt>Datum</dt>
				<dd>${voorstelling.datum}</dd>
				<dt>Prijs</dt>
				<dd>${voorstelling.prijs}</dd>
				<dt>Vrije Plaatsen</dt>
				<dd>${voorstelling.vrijePlaatsen</dd>
			</dl>
		</c:otherwise>
	</c:choose>
</body>
</html>
