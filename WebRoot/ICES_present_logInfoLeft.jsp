<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<jsp:useBean id="ICES_beans_log" class="hitpm_v2.ICES_beans_processLog.ICES_processLog_logInfo" scope="session"/>

<head><title>处理上传的事件日志</title></head>
  <body>
  
	<%
	int log = ICES_beans_log.getLog();
	int traceNum = ICES_beans_log.getTraceNum();
	int eventNum = ICES_beans_log.getEventNum();
	int eventKind = ICES_beans_log.getEventKind();
	int actor=ICES_beans_log.getActor();
	String startTime=ICES_beans_log.getStartTimeStr();
	String endTime=ICES_beans_log.getEndTimeStr();
	%>
	<table border="1" style="width: 100%; "  target="aframe">
	  <tr>
	    <th>Overall log information</th>
	  </tr>
	  <tr>
	    <td>Process：<%out.print(log);%>
	    </td>
	  </tr>
	  	  <tr>
	    <td>Instance：<%out.print(traceNum);%>
	    </td>
	  </tr>
	  	  <tr>
	    <td>Event：<%out.print(eventNum);%>
	    </td>
	  </tr>
	  	  <tr>
	    <td>Event Type：<%out.print(eventKind);%>
	    </td>
	  </tr>
	  	  <tr>
	    <td>Actor：<%out.print(actor);%>
	    </td>
	  </tr>
	  	  <tr>
	    <td>Start time：<%out.print(startTime);%>
	    </td>
	  </tr>
	  	  <tr>
	    <td>End time：<%out.print(endTime);%>
	    </td>
	  </tr>
	 </table>
</body>
</html>