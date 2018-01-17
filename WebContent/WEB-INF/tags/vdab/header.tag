<%@tag description='header onderdeel van pagina' pageEncoding='UTF-8'%>
<%@attribute name='title' required='true' type='java.lang.String'%>
<%@attribute name='image' required='true' type='java.lang.String'%>
<%@attribute name='genres' required='false' type='java.util.SortedSet'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<header>
	<h1>
		<img src='images/${image}.png' alt='${image}'>
		CULTUURHUIS - ${title}
	</h1>
	<nav>
		<ul>
			<li>
				<a href='voorstellingen.htm'>Voorstellingen</a>
			</li>
			<li>
				<a href='reservatiemandje.htm'>Reservatiemandje</a>
			</li>
			<li>
				<a href='bevestigingreservaties.htm'>Bevestiging reservaties</a>
			</li>
		</ul>
	</nav>
	<c:if test='${! empty genres}'>
		<nav>
			<h2>Genres</h2>
			<ul>
				<c:forEach var='genre' items='${genres}'>
					<li>
						<a href='voorstellingen.htm?genreid=${genre.id}'> ${genre.naam}</a>
					</li>
				</c:forEach>
			</ul>
		</nav>
	</c:if>
</header>
