<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ page import="java.util.*"%>

<!DOCTYPE html>
<jsp:useBean id="ICES_beans_aa" class="hitpm_v2.ICES_beans_activityActor.ICES_activityActor_Aabean" scope="session"/>

<html>

<head>
<meta charset="ISO-8859-1">
<title>ICES_present_activityActor.jsp</title>
<body>
	<%
		HashMap<String, ArrayList<String>> dataMap = ICES_beans_aa.getAaHash();
	
	%>
		<table border="1" style="width: 100%;">
		<caption style="font-size: 25px; " >活动-参与者</caption>
		<tr>
		  <th>活动</th>
		  
		  <th>参与者</th>
		  
		</tr>
		<%
		
	    for (String activity : dataMap.keySet()) {
	    	int temp=0;
	    	ArrayList<String> actorList = dataMap.get(activity);
	    	int size = actorList.size();
	    	for (String actor : actorList)
	    	{
	    		out.println("<tr>");
	    		if(temp==0)
	    		{
	    			out.println("<th rowspan="+size+">"+ activity +"</td>");
	    		}
	         	
	         	out.println("<td>"+ actor +"</td>");
	         	out.println("</tr>");
	         	temp=1;
	    	}

        }
        
		%>
	</table>
</body>
</html>