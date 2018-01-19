<%@tag pageEncoding='UTF-8'%>
<%@attribute name='label' required='true' type='String'%>
<%@attribute name='name' required='true' type='String'%>
<%@attribute name='value' required='false' type='Long'%>
<p>
	<label for='${name}'>${label}:</label> <input type='number' name='${name}' min='0' max='99999999999' value='${value}'
		required
	/>
</p>
