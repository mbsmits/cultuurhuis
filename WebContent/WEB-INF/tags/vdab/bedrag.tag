<%@tag pageEncoding='UTF-8'%>
<%@attribute name='value' required='true' type='java.math.BigDecimal'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<span>&euro;<fmt:formatNumber minFractionDigits='2' maxFractionDigits='2' value='${value}' /></span>
