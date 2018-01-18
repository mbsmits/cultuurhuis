<%@tag pageEncoding='UTF-8'%>
<%@attribute name='title' required='true' type='String'%>
<%@attribute name='image' required='true' type='String'%>
<%@attribute name='genres' required='false' type='Iterable'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='vdab' uri='http://vdab.be/tags'%>
<header>
	<h1 class="clearFix">
		<img src='images/${image}.png' alt='${image}'> CULTUURHUIS - ${title}
	</h1>
	<!--  TODO -->
	<nav>
		<ul>
			<li><a href='voorstellingen.htm'>Voorstellingen</a></li>
			<li><a href='reservatiemandje.htm'>Reservatiemandje</a></li>
			<li><a href='bevestigingreservaties.htm'>Bevestiging reservaties</a></li>
		</ul>
	</nav>
	<c:if test='${! empty genres}'>
		<nav>
			<h2>Genres</h2>
			<ul>
				<c:forEach var='genre' items='${genres}'>
					<li><a href='voorstellingen.htm?genreid=${genre.id}'> ${genre.naam}</a></li>
				</c:forEach>
			</ul>
		</nav>
	</c:if>
</header>
