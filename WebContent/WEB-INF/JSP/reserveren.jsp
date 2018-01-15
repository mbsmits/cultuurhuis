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
<vdab:head title='Het CultuurHuis: Voorstellingen' />
</head>
<body>
	<h1>Het CultuurHuis: Voorstellingen</h1>
	<img
		src='images/voorstellingen.png'
		alt='voorstellingen'
	>
	<h2>Genres</h2>
	<ol>
		<c:forEach
			var='genre'
			items='${genres}'
		>
			<li>
				<a href='voorstellingen.htm?genreid=${genreid}'> ${genre.naam}</a>
			</li>
		</c:forEach>
	</ol>
</body>
</html>
