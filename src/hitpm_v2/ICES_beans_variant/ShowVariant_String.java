package hitpm_v2.ICES_beans_variant;

import org.deckfour.xes.model.XLog;

import javax.servlet.jsp.JspWriter;
import java.util.List;

public class ShowVariant_String {

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

    	        //执行功能
    	        MineCircularRelationship mineCircularRelationship = new MineCircularRelationship();
    	        for(int i = 1; i<originProcesses.size(); i++)//for (String originProcess: originProcesses)
    	         {
    	            String variant_String = mineCircularRelationship.showVariant(originProcesses.get(i));
    	            out.println("<tr>"+"<td>"+ variant_String +"</td>"+"</tr>");
    	        }
   
	}
	public String variantBack(JspWriter out,XLog log, List<String> originProcesses, int i)throws Exception{

		//执行功能
		MineCircularRelationship mineCircularRelationship = new MineCircularRelationship();
		return mineCircularRelationship.showVariant(originProcesses.get(i));

	}

}