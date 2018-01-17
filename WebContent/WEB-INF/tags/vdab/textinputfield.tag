<%@tag description='text field onderdeel van een form' pageEncoding='UTF-8'%>
<%@attribute name='label' required='true' type='java.lang.String'%>
<%@attribute name='name' required='true' type='java.lang.String'%>
<%@attribute name='value' required='false' type='java.lang.String'%>
<p>
	<label for='${name}'>${label}:</label> <input type='text' name='${name}' maxlength='45' value='${value}' required />
</p>
