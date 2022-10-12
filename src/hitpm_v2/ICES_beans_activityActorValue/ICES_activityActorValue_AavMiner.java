package hitpm_v2.ICES_beans_activityActorValue;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.deckfour.xes.model.XLog;

import hitpm_v2.ICES_beans_activityActorValue.ICES_activityActorValue_ActorValue;
import hitpm_v2.ICES_beans_activityActorValue.ICES_activityActorValue_ProcessValue;

public class ICES_activityActorValue_AavMiner {
	
	List<Map> list=new ArrayList<Map>();

	public List<Map> getData() {
		
		return list;
	}
	public void setList(List<Map> list)
	{
		this.list=list;
	}
	public List<Map> pvMiner(XLog log)
			throws IOException, ParseException{
		HashMap<String, HashMap<String,ICES_activityActorValue_ActorValue>>  processValue = ICES_activityActorValue_ProcessValue.mineProcessValue(log);
		
		for(String activity: processValue.keySet()) {

			
			int i = 0;
			Map<String, String> dataMap=new HashMap<String, String>();	        
			dataMap.put("activity", activity);
			list.add(dataMap);
			
			for(String actor: processValue.get(activity).keySet()) {


				StringBuffer inValueBuffer1=ICES_activityActorValue_ProcessValue.convertValueSetToString(processValue.get(activity).get(actor).inValue.getTs());
				StringBuffer inValueBuffer2	=ICES_activityActorValue_ProcessValue.convertValueSetToString(processValue.get(activity).get(actor).inValue.getExpr());
				StringBuffer inValueBuffer3		=ICES_activityActorValue_ProcessValue.convertValueSetToString(processValue.get(activity).get(actor).inValue.getProfit());
				String inValue1 = new String(inValueBuffer1);
				String inValue2= new String(inValueBuffer2);
				String inValue3 = new String(inValueBuffer3);
				
				StringBuffer outValueBuffer1=ICES_activityActorValue_ProcessValue.convertValueSetToString(processValue.get(activity).get(actor).outValue.getTs());
				StringBuffer outValueBuffer2		=ICES_activityActorValue_ProcessValue.convertValueSetToString(processValue.get(activity).get(actor).outValue.getExpr());
				StringBuffer outValueBuffer3		=ICES_activityActorValue_ProcessValue.convertValueSetToString(processValue.get(activity).get(actor).outValue.getProfit());
				String outValue1 = new String(outValueBuffer1);
				String outValue2= new String(outValueBuffer2);
				String outValue3 = new String(outValueBuffer3);

				i++;//0714
				
				
				
				Map<String, String> dataMap1=new HashMap<String, String>();	        
				
		        dataMap1.put("actor", actor);
		        dataMap1.put("invalue", inValue1+","+inValue2+","+inValue3);
		        dataMap1.put("outvalue", outValue1+","+outValue2+","+outValue3);
		        list.add(dataMap1);
			
			}

		}

		return list;
			
		}
	
	public int getActorNum(int j){
		Map dataMap = list.get(j);
		if (!dataMap.containsKey("activity")){
			return 0;
		}
		String activity;
    	activity = dataMap.get("activity").toString();
    	int actorNum=0;
    	for(int i = j+1; i < list.size(); i++){
    		dataMap= list.get(i);
    		if (!dataMap.containsKey("activity")){
    			actorNum++;
    		}
    		else
    			break;
    	}
        
		return actorNum;
		
	}
	
	
}