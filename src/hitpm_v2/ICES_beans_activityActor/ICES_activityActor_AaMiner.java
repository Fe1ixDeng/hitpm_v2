package hitpm_v2.ICES_beans_activityActor;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;
import org.deckfour.xes.model.XAttributeMap;
import org.deckfour.xes.model.XLog;
import org.deckfour.xes.model.XTrace;
import javax.servlet.jsp.JspWriter;

public class ICES_activityActor_AaMiner {
	public static HashMap<String, ArrayList<String>> spvmMiner(JspWriter out, XLog log)
			throws IOException, ParseException{
		HashMap<String, ArrayList<String>>  processValue = mineProcessValue(log);
		
		return processValue;
		
		}

	private static StringBuffer convertValueSetToString(Set<String> valDimension) {
		StringBuffer valString = new StringBuffer();
		if(valDimension.size()>0&&!valDimension.isEmpty())
			valString.append(valDimension.toString());
		else
			valString.append("");
		return valString;
	}
	
	private static HashMap<String, ArrayList<String>>  mineProcessValue(XLog log) throws IOException, ParseException {

		HashMap<String, ArrayList<String>> tempProcessValue = new HashMap<String, ArrayList<String>>();

		String activityName;
		ArrayList<String> actorName = new ArrayList<String>();
		
		for (XTrace trace : log) {
			if (!trace.isEmpty()) {
				for (int i = 0; i < trace.size(); i++) {
					XAttributeMap xMap = trace.get(i).getAttributes();
					
					if (xMap.size() > 3) {
						for (Entry e : xMap.entrySet()) {
							if (e.getKey().toString().equals("concept:name")||e.getKey().toString().equals("lifecycle:transition")||e.getKey().toString().equals("time:timestamp")) {}
							else{

							activityName = xMap.get("concept:name").toString();
							
							
							if(!tempProcessValue.containsKey(activityName)) {
							tempProcessValue.put(activityName, new ArrayList<String>());
							actorName = tempProcessValue.get(activityName);
							}else {
								actorName = tempProcessValue.get(activityName);
							}
							if(e.getKey().toString().equals("org:resource")||e.getKey().toString().equals("org:role")) {

								String temp = e.getValue().toString();
								if(!actorName.contains(temp))
								{
									actorName.add(temp);
								}
								
							}

						}
						}
					}
				}
			}
		}
		return tempProcessValue;
	}

		

	public static String aListConvert11(Set<String> set) {
		return "[" + String.join(",", set) + "]";
	}
}