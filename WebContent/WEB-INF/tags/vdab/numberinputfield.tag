<%@tag description='text field onderdeel van een form' pageEncoding='UTF-8'%>
<%@attribute name='label' required='true' type='java.lang.String'%>
<%@attribute name='name' required='true' type='java.lang.String'%>
<%@attribute name='value' required='false' type='java.lang.Long'%>
<p>
	<label for='${name}'>${label}:</label> <input type='number' name='${name}' min='0' max='99999999999' value='${value}'
		required
	/>
</p>
