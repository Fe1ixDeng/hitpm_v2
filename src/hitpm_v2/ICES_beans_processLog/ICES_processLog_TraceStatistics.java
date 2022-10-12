package hitpm_v2.ICES_beans_processLog;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.deckfour.xes.model.XAttributeMap;
import org.deckfour.xes.model.XLog;
import org.deckfour.xes.model.XTrace;

import hitpm_v2.ICES_beans_xml.ICES_xml_parser;

import javax.servlet.jsp.JspWriter;

public class ICES_processLog_TraceStatistics {
	
	private XLog log;
	private static List<String> traceList = new ArrayList<>();
	
	public void setLog(XLog log) {
		this.log = log;
	}
	public XLog getLog() {
		return this.log;
	}
	
	public List<String> getTraceList() {
		return traceList;
	}

	public void setTraceList(List<String> traceList) {
		this.traceList = traceList;
	}

	
	
	public static void printTraceTable(JspWriter out, XLog log){

		try {
			ICES_xml_parser myParse=new ICES_xml_parser();
//			List<Map> listSta=new ArrayList<Map>();
//			List<String> list=new ArrayList<String>();
			HashMap<String, Integer> traceValueMap= new HashMap<String, Integer>();
			
			for (XTrace trace : log) {
				String trace_list=getTrace_list(trace);
	
//				list.add(trace_list);
					if(!traceValueMap.containsKey(trace_list)) {
						traceValueMap.put(trace_list, 1);
					}else {
						int num = traceValueMap.get(trace_list);
						num=num+1;
						traceValueMap.replace(trace_list, num);
						
					}
				
				
				
			}
			int logSize=myParse.getLogSize(log);
//			System.out.println(traceValueMap);
//			System.out.print(logSize);
			tracesprint(out,traceValueMap,logSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//.....
	public static List<String> printTraceTable1(JspWriter out, XLog log){
		HashMap<String, Integer> traceValueMap= new HashMap<String, Integer>();
		List<String> processList = new ArrayList<>();
		try {
			ICES_xml_parser myParse=new ICES_xml_parser();
//			List<Map> listSta=new ArrayList<Map>();
//			List<String> list=new ArrayList<String>();
			
			
			for (XTrace trace : log) {
				String trace_list=getTrace_list(trace);
	
//				list.add(trace_list);
					if(!traceValueMap.containsKey(trace_list)) {
						traceValueMap.put(trace_list, 1);
					}else {
						int num = traceValueMap.get(trace_list);
						num=num+1;
						traceValueMap.replace(trace_list, num);
						
					}
				
				
				
			}
			int logSize=myParse.getLogSize(log);
//			System.out.println(traceValueMap);
//			System.out.print(logSize);
		//	tracesprint(out,traceValueMap,logSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String process : traceValueMap.keySet()) {
			processList.add(process);
		}
		return processList;
	}
//	public static List<String> printTraceTable2(JspWriter out, XLog log){
//
//		try {
//			ICES_xml_parser myParse=new ICES_xml_parser();
////			List<Map> listSta=new ArrayList<Map>();
////			List<String> list=new ArrayList<String>();
//			HashMap<String, Integer> traceValueMap= new HashMap<String, Integer>();
//			
//			for (XTrace trace : log) {
//				String trace_list=getTrace_list(trace);
//	
////				list.add(trace_list);
//					if(!traceValueMap.containsKey(trace_list)) {
//						traceList.add(trace_list);
//					}
//			}
//			int logSize=myParse.getLogSize(log);
////			System.out.println(traceValueMap);
////			System.out.print(logSize);
//			tracesprint(out,traceValueMap,logSize);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return traceList;
//	}
	
	public static void tracesprint(JspWriter out,HashMap<String, Integer> traceValueMap,int logSize)throws Exception{
//		out.println("<tr>");
////        out.println("<td align=\"center\">"+ "Trace" +"</td>");
////        out.println("<td align=\"center\">"+ "Num" + "</td>");
////        out.println("<td align=\"center\">"+ "Percentage" +"</td>");
//        
//        out.println("<td align=\"center\">"+ "流程实例" +"</td>");
//        out.println("<td align=\"center\">"+ "数量" + "</td>");
//        out.println("<td align=\"center\">"+ "占流程总数的比例" +"</td>");
//        out.println("</tr>");
        
        for (String trace : traceValueMap.keySet()) {
//            System.out.println("key: " + trace + " value: " + traceValueMap.get(trace));
        	if(!trace.equals("")) {
        		out.println("<td>"+ trace +"</td>");
    	        out.println("<td align=\"center\">"+ traceValueMap.get(trace) + "</td>");
    	        // 鍒涘缓涓�涓暟鍊兼牸寮忓寲瀵硅薄
    	    	NumberFormat numberFormat = NumberFormat.getInstance();
    	    	// 璁剧疆绮剧‘鍒板皬鏁扮偣鍚�2浣�
    	    	numberFormat.setMaximumFractionDigits(2);
    	    	String rate = numberFormat.format((float) traceValueMap.get(trace) / (float) logSize * 100);
//    	        float rate=(float) traceValueMap.get(trace) / (float) logSize;
    	       
    	        out.println("<td align=\"center\">"+ rate+"%</td>");
    	        out.println("</tr>");
        	}
	        	
			
		}
	}
	
	public void tracesMemory(HashMap<String, Integer> traceValueMap)throws Exception{
        for (String trace : traceValueMap.keySet()) {

        	if(!trace.equals("")) {
        		traceList.add(trace);
        	}
		}
	}
	
	public static String getTrace_list(XTrace trace){//寰楀埌瀛楃涓插舰寮忕殑trace娲诲姩鍚嶅簭鍒楋紝trace涓虹┖鍒欒繑鍥炲瓧绗︿覆""
		String trace_list="";
		if (!trace.isEmpty()) {
			//boolean hasManualInteraction = false;
			String lastActivity = "";
			for (int i = 0; i < trace.size(); i++) {
				//if(xMap.get("concept:name").toString().isEqual("manualInteraction")) hasManualInteraction = true;
				XAttributeMap xMap = trace.get(i).getAttributes();
				String activityName = xMap.get("concept:name").toString();
				if(i==2) {
					if(activityName.equals("Release Order")) {
					trace_list="";
					break;
					}
				
				}
				if(i==4) {
					if(activityName.equals("Service Evaluation")) {
					trace_list="";
					break;
					}
				
				}
				if(lastActivity == activityName) {
					continue;
				}
				if(!(i==trace.size()-1)){
					trace_list=trace_list+activityName+"-->";
				}
				else
					trace_list=trace_list+activityName;
				lastActivity = activityName;
			}
			
			//if(hasManualInteraction == false) trace.DELETEITSELF();
	
		}
		 

		return trace_list;
	}

}
