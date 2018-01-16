<%@tag description='text field onderdeel van een form' pageEncoding='UTF-8'%>
<%@attribute name='label' required='true' type='java.lang.String'%>
<%@attribute name='value' required='true' type='java.lang.Object'%>
<p>
	<label>${label}:</label>
	<span class="value">${value}</span>
</p>
