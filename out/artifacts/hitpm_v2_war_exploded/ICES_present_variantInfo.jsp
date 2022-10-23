<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<jsp:useBean id="ICES_beans_variant" class="hitpm_v2.ICES_beans_variant.ShowVariant_String" scope="session"/>
	<jsp:useBean id="ICES_beans_trace" class="hitpm_v2.ICES_beans_processLog.ICES_processLog_TraceStatistics" scope="session"/>

</head>
<body>
 <table border="1" style="width: 100%; " data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-14" data-genuitec-path="/HITpm/WebRoot/pmResults/Trace.jsp">
      	<caption style="font-size: 25px; " >Variant Information</caption>
		<tr>
		  <td align="center">Variant Kind</td>
		</tr>
    	<%
    	ICES_beans_variant.varientSprint(out,ICES_beans_variant.getLog(),ICES_beans_trace.printTraceTable1(out,ICES_beans_trace.getLog()));
    	%>
    </table>
</body>
</html>