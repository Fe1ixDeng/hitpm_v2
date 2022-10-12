package hitpm_v2.ICES_beans_variant;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.jsp.JspWriter;

import org.deckfour.xes.model.XAttributeMap;
import org.deckfour.xes.model.XLog;
import org.deckfour.xes.model.XTrace;

import hitpm_v2.ICES_beans_xml.ICES_xml_parser;

public class ShowVarient_String {

	private XLog log;
	
	public void setLog(XLog log) {
		this.log = log;
	}
	public XLog getLog() {
		return this.log;
	}
	public List<String> originProcesses;
	
  
    public List<String> getOriginProcesses() {
		return originProcesses;
	}
	public void setOriginProcesses(List<String> originProcesses) {
		this.originProcesses = originProcesses;
	}
	public static void varientSprint(JspWriter out,XLog log, List<String> originProcesses)throws Exception{
	//	out.println("<tr>"+"<td>"+ originProcesses +"</td>"+"</tr>");

    	// List<String> originProcesses = new ArrayList<>();
    	 //originProcesses.add("Apply Repair-->User Identification-->Intelligent Response-->Manual Interaction-->Release Order-->Order Assignment-->Repair-->Test Repair-->Restart Repair-->Repair-->Test Repair-->Restart Repair-->Repair-->Test Repair-->Success-->Service Evaluation-->Archive");
 //   	 originProcesses.add("Apply Repair-->User Identification-->Intelligent Response-->Manual Interaction-->Release Order-->Order Assignment-->Repair-->Test Repair-->Success-->Service Evaluation-->Archive");
 //   	 originProcesses.add("Apply Repair-->User Identification-->Intelligent Response-->Manual Interaction-->Service Evaluation-->Archive");
//    	 originProcesses.add("Apply Repair-->User Identification-->Intelligent Response-->Manual Interaction-->Release Order-->Order Assignment-->Repair-->Test Repair-->Restart Repair-->Repair-->Test Repair-->Success-->Service Evaluation-->Archive");
//    	 originProcesses.add("Apply Repair-->User Identification-->Intelligent Response-->Manual Interaction-->Release Order-->Order Assignment-->Repair-->Test Repair-->Restart Repair-->Repair-->Test Repair-->Restart Repair-->Repair-->Test Repair-->Renew-->Service Evaluation-->Archive");

    	        //执行功能
    	        MineCircularRelationship mineCircularRelationship = new MineCircularRelationship();
    	        for(int i = 1; i<originProcesses.size(); i++)//for (String originProcess: originProcesses)
    	         {
    	            String variant_String = mineCircularRelationship.showVariant(originProcesses.get(i));
    	            out.println("<tr>"+"<td>"+ variant_String +"</td>"+"</tr>");
    	        }

//
   
	}
    

}