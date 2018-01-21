<%@tag pageEncoding='UTF-8'%>
<%@attribute name='value' required='true' type='java.math.BigDecimal'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<fmt:formatNumber type='currency' currencySymbol='&euro;' minFractionDigits='2' maxFractionDigits='2' value='${value}' />
