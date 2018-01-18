<%@tag pageEncoding='UTF-8'%>
<%@attribute name='label' required='true' type='String'%>
<%@attribute name='value' required='true' type='Object'%>
<p>
	<label>${label}:</label> <span class="value">${value}</span>
</p>
