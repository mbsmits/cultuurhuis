<%@tag pageEncoding='UTF-8'%>
<%@attribute name='label' required='true' type='String'%>
<%@attribute name='name' required='true' type='String'%>
<%@attribute name='value' required='true' type='String'%>
<p>
	<label for='${name}'>${label}:</label> <input type='password'
		name='${name}' maxlength='45' value='${value}' required />
</p>
