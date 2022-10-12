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
	    <th>日志总体信息</th>
	  </tr>
	  <tr>
	    <td>流程：<%out.print(log);%>
	    </td>
	  </tr>
	  	  <tr>
	    <td>实例：<%out.print(traceNum);%>
	    </td>
	  </tr>
	  	  <tr>
	    <td>事件：<%out.print(eventNum);%>
	    </td>
	  </tr>
	  	  <tr>
	    <td>事件种类：<%out.print(eventKind);%>
	    </td>
	  </tr>
	  	  <tr>
	    <td>参与者：<%out.print(actor);%>
	    </td>
	  </tr>
	  	  <tr>
	    <td>开始时间：<%out.print(startTime);%>
	    </td>
	  </tr>
	  	  <tr>
	    <td>结束时间：<%out.print(endTime);%>
	    </td>
	  </tr>
	 </table>
</body>
</html>