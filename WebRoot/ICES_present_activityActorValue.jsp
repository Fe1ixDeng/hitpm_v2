<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="org.deckfour.xes.model.XLog"%>

<jsp:useBean id="ICES_beans_aavMiner" class="hitpm_v2.ICES_beans_activityActorValue.ICES_activityActorValue_AavMiner"/>
<jsp:useBean id="ICES_beans_aav" class="hitpm_v2.ICES_beans_activityActorValue.ICES_activityActorValue_Aavbean" scope="session"/>
<html>
  <head>

    
    <title>ICES_predent_activityActorValue.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
 
  <body>
    
    <%
    	List<Map> list=ICES_beans_aav.getList();
    	System.out.println(list);
     %>
    
	<table border="1" style="width: 100%;">
	<caption style="font-size: 25px; " >活动-参与者-价值</caption>
		<tr>
		  <td>Activity</td>

		  <td>Actor</td>

		  <td>Input Value</td>

		  <td>Output Value</td>

		</tr>
		<%
		try {
			
			
		 ICES_beans_aavMiner.setList(list);
		 String activity;
			for (int j = 0; j < list.size(); j++) {
				out.println("<tr>");
                // 得到要插入的每一条记录
                Map dataMap = list.get(j);

                
                if (dataMap.containsKey("activity")){
                	int actorNum=ICES_beans_aavMiner.getActorNum(j);
//                	System.out.println(actorNum);
					activity=activity = dataMap.get("activity").toString();
                	out.println("<td rowspan=\""+ actorNum+"\" style=\"width: 100px; \" align=\"center\">" + activity +"</td>");
//   		         out.println("<td>"+ activity +"</td>");
                	for(int i=j+1;i<=j+actorNum;i++){
                		Map dataMap1 = list.get(i);
                		String actor = dataMap1.get("actor").toString();
                		String invalue = dataMap1.get("invalue").toString();	
                		String outvalue = dataMap1.get("outvalue").toString();
                		if(!(i==j+1))
                			out.println("<tr>");

	    		        out.println("<td>"+ actor +"</td>");
	    		        out.println("<td>"+ invalue + "</td>");
	    		        out.println("<td>"+ outvalue +"</td>");
	    		        out.println("</tr>");	
                	}
                	
                }
              }
	       
	       		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		%>	

	</table>
  </body>
</html>
