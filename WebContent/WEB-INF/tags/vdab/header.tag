<%@tag pageEncoding='UTF-8'%>
<%@attribute name='title' required='true' type='String'%>
<%@attribute name='image' required='true' type='String'%>
<%@attribute name='genres' required='false' type='Iterable'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<header>
	<h1 class="clearFix">
		<img src='images/${image}.png' alt='${image}'> CULTUURHUIS - ${title}
	</h1>
	<nav>
		<ul>
			<li><a href='voorstellingen.htm'>Voorstellingen</a></li>
			<c:if test='${! empty mandje}'>
				<li><a href='mandje.htm'>Reservatiemandje</a></li>
			</c:if>
			<c:if test='${! empty mandje}'>
				<li><a href='bevestig.htm'>Bevestiging reservaties</a></li>
			</c:if>
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
