<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Trace.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

	<jsp:useBean id="ICES_beans_trace" class="hitpm_v2.ICES_beans_processLog.ICES_processLog_TraceStatistics" scope="session"/>
	<jsp:useBean id="ICES_beans_variant" class="hitpm_v2.ICES_beans_variant.ShowVariant_String" scope="session"/>

  
  <body>

    <table border="1" style="width: 100%; " data-genuitec-lp-enabled="false" data-genuitec-file-id="wc3-14" data-genuitec-path="/HITpm/WebRoot/pmResults/Trace.jsp">
      	<caption style="font-size: 25px; " >Trace Information</caption>
		<tr>
		  <td align="center">Process Instance Type</td>
		  <td align="center">Quantity</td>
		  <td align="center">percent of the total number of processes</td>
		</tr>
    	<%
    	ICES_beans_trace.printTraceTable(out, ICES_beans_trace.getLog());
    	%>
    </table>
  </body>
</html>
