<%@tag pageEncoding='UTF-8'%>
<%@attribute name='label' required='true' type='String'%>
<%@attribute name='name' required='true' type='String'%>
<%@attribute name='value' required='false' type='String'%>
<p>
	<label for='${name}'>${label}:</label> <input type='text' name='${name}' maxlength='45' value='${value}' required />
</p>
