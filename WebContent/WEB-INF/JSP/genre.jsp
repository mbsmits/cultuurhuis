<%@page
	contentType='text/html'
	pageEncoding='UTF-8'
	session='false'
%>
<%@taglib
	uri='http://vdab.be/tags'
	prefix='vdab'
%>
<%@taglib
	prefix='c'
	uri='http://java.sun.com/jsp/jstl/core'
%>
<!doctype html>
<html lang='nl'>
<head>
<vdab:head title='${genre.naam}' />
</head>
<body>
	<vdab:menu />
	<h1>Voorstellingen</h1>
	<ul class='zebra'>
		<c:forEach
			var='voorstelling'
			items='${voorstellingen}'
		>
			<li>
				${voorstelling.titel}
			</li>
		</c:forEach>
	</ul>
</body>
</html>
