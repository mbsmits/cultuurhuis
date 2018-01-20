<%@tag pageEncoding='UTF-8'%>
<%@attribute name='label' required='true' type='String'%>
<%@attribute name='name' required='true' type='String'%>
<%@attribute name='minValue' required='false' type='Long'%>
<%@attribute name='maxValue' required='false' type='Long'%>
<%@attribute name='value' required='false' type='Long'%>
<p>
	<label for='${name}'>${label}:</label> <input type='number'
		name='${name}' min='${empty minValue ? 0 : minValue}'
		max='${empty maxValue ? 99999999999 : maxValue}' value='${value}'
		required />
</p>
