package hitpm_v2.ICES_beans_activityActorValue;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.deckfour.xes.model.XAttribute;
import org.deckfour.xes.model.XAttributeList;
import org.deckfour.xes.model.XAttributeMap;
import org.deckfour.xes.model.XLog;
import org.deckfour.xes.model.XTrace;
import org.processmining.models.graphbased.directed.petrinet.Petrinet;
import org.processmining.models.graphbased.directed.petrinet.PetrinetNode;


//import org.processmining.newpackage.plugins.ActorValue;
//import org.processmining.newpackage.plugins.ValueElement;
import javax.servlet.jsp.JspWriter;

public class ICES_activityActorValue_ProcessValue {
	public static void spvmMiner(JspWriter out, XLog log)
			throws IOException, ParseException{
		HashMap<String, HashMap<String,ICES_activityActorValue_ActorValue>>  processValue = mineProcessValue(log);
		//添加流程价值哈希表
		
		for(String activity: processValue.keySet()) {
			//System.out.println("----/test--Activity= "+activity);
			out.print("<br><br>");	
			/* System. */out.print(activity+"= { ");	//0714
			int i = 0;//0714
			
			for(String actor: processValue.get(activity).keySet()) {
				/*System.out.println("----Actor= "+actor);
				System.out.println("---valueIn (ts): "+processValue.get(activity).get(actor).inValue.getTs());
				System.out.println("---valueIn (expr): "+processValue.get(activity).get(actor).inValue.getExpr());
				System.out.println("---valueOIn (Profit): "+processValue.get(activity).get(actor).inValue.getProfit());
				System.out.println("---valueOut (ts): "+processValue.get(activity).get(actor).outValue.getTs());
				System.out.println("---valueOut (expr): "+processValue.get(activity).get(actor).outValue.getExpr());
				System.out.println("---valueOut (Profit): "+processValue.get(activity).get(actor).outValue.getProfit());
				*/
				/*System.out.println("---valueIn (ts): "+processValue.get(activity).get(actor).inValue.getTs()
						+"--- (expr): "+processValue.get(activity).get(actor).inValue.getExpr()
						+"--- (Profit): "+processValue.get(activity).get(actor).inValue.getProfit());
				System.out.println("---valueOut (ts): "+processValue.get(activity).get(actor).outValue.getTs()
						+"--- (expr): "+processValue.get(activity).get(actor).outValue.getExpr()
						+"--- (Profit): "+processValue.get(activity).get(actor).outValue.getProfit());
				System.out.println();*/
				if(i>0) {
//					System.out.print("    "+actor+"= { ");
					out.print("<br>"+"    "+actor+"= { ");
				}else 
					out.print(actor+"= { ");
				out.print("inValue = ("+convertValueSetToString(processValue.get(activity).get(actor).inValue.getTs())+", "
						+convertValueSetToString(processValue.get(activity).get(actor).inValue.getExpr())+", "
						+convertValueSetToString(processValue.get(activity).get(actor).inValue.getProfit())
						+")");
				out.println();out.print("<br>"+"&nbsp&nbsp");
				out.print("    \t"+"    outValue = ("+convertValueSetToString(processValue.get(activity).get(actor).outValue.getTs())+", "
						+convertValueSetToString(processValue.get(activity).get(actor).outValue.getExpr())+", "
						+convertValueSetToString(processValue.get(activity).get(actor).outValue.getProfit())
						+")");
				out.println("} ");
				i++;//0714
				}
			//System.out.println("test0713--1");
			out.println("}");//0714
		}
		//将活动-参与者-价值 根据不同维度输出，
		
		}
	
	public static StringBuffer convertValueSetToString(Set<String> valDimension) {
		StringBuffer valString = new StringBuffer();
		/*if(valDimension.size()==1) {
			for(String s:valDimension)
				valString.append(s);
		}else */if(valDimension.size()>0&&!valDimension.isEmpty())
			valString.append(valDimension.toString());
		else
			valString.append("");
		return valString;
	}
	
	public static HashMap<String, HashMap<String,ICES_activityActorValue_ActorValue>>  mineProcessValue(XLog log) throws IOException, ParseException {
		//Write w = new Write();
		// TODO Auto-generated method stub
		HashMap<String, HashMap<String,ICES_activityActorValue_ActorValue>> tempProcessValue = new HashMap<String, HashMap<String,ICES_activityActorValue_ActorValue>>();
		HashMap<String, ICES_activityActorValue_ActorValue> actorValueMap;
		String activityName, actorName;
		ICES_activityActorValue_ActorValue tempActorValueMap;
		
		//HashMap<String,Set<String>> tmpBenifitValue = new HashMap<String, Set<String>>();//暂时存储利益相关信息
		//Set<String> tmpBenifitSet = new HashSet<String>();//暂时存储具体利益
		ArrayList<Double> evaluationValue = new ArrayList<Double>(5);//存储评价价值进行平均值计算！
		evaluationValue.add(0.0);evaluationValue.add(0.0);evaluationValue.add(0.0);evaluationValue.add(0.0);evaluationValue.add(0.0);
		
		for (XTrace trace : log) {//给valueMap赋值
			if (!trace.isEmpty()) {
				for (int i = 0; i < trace.size(); i++) {
					XAttributeMap xMap = trace.get(i).getAttributes();
					
					if (xMap.size() > 3) {//20211201:4改成3
						for (Entry e : xMap.entrySet()) {//attribute
//							if (!unuse.contains(e.getKey().toString())) {
							if (e.getKey().toString().equals("concept:name")||e.getKey().toString().equals("lifecycle:transition")||e.getKey().toString().equals("time:timestamp")) {}
							else{
							actorValueMap = new HashMap();
							activityName = xMap.get("concept:name").toString();
							
							/*价值指标映射初始化*/
							if(!tempProcessValue.containsKey(activityName)) {
								tempProcessValue.put(activityName, actorValueMap);
							}else {//或者获取活动对应的参与者价值
								actorValueMap = tempProcessValue.get(activityName);
							}
							//添加参与者，并初始化添加参与者-价值映射
							if(e.getKey().toString().equals("org:resource")||e.getKey().toString().equals("org:role")) {
								//w.rwFile("e-value=="+e.getValue().toString());
								actorName = e.getValue().toString();
								if(!actorValueMap.keySet().contains(actorName))
									actorValueMap.put(actorName, new ICES_activityActorValue_ActorValue());
							}
							//指向当前活动对应的参与者 创造的价值
							if(xMap.get("org:resource")!=null) {
								tempActorValueMap = tempProcessValue.get(activityName).get(xMap.get("org:resource").toString());
							}else if((xMap.get("org:resource")==null && (xMap.get("org:role")!=null))) {
								tempActorValueMap = tempProcessValue.get(activityName).get(xMap.get("org:role").toString());
							}else {
								tempActorValueMap=new ICES_activityActorValue_ActorValue();
								tempActorValueMap.inValue = new ICES_activityActorValue_ValueElement();
								tempActorValueMap.outValue = new ICES_activityActorValue_ValueElement();
							}
							if(tempActorValueMap==null) {
								tempActorValueMap=new ICES_activityActorValue_ActorValue();
								tempActorValueMap.inValue = new ICES_activityActorValue_ValueElement();
								tempActorValueMap.outValue = new ICES_activityActorValue_ValueElement();
							}
							
							String atrributeName_temp = e.getKey().toString();// 储存属性名
							String atrributeName = atrributeName_temp;
							if(true) {
								if (atrributeName.equals("payment")) {
									
									tempActorValueMap.outValue.addProfit("payment: "+e.getValue().toString());
								}
								
								/* 添加expr维度价值 */
								
								if (atrributeName.equals("evaluation")) {
									//w.rwFile(e.getValue().toString());//测试嵌套属性识别
									
									XAttributeList attriList = (XAttributeList) e.getValue();
									int tempCount = 0;
									Double numbersCount = evaluationValue.get(4);//找到计算有多少个评价价值的存储值
									for(XAttribute serVal:attriList.getCollection()) {
										//不是地址传递吗？
										Double tmpStore = evaluationValue.get(tempCount);
										//w.rwFile(" content: "+serVal.toString()+" ; Class: "+serVal.toString().getClass());
										Double tmpValue = Double.parseDouble(serVal.toString());
										tmpStore += tmpValue;
										evaluationValue.set(tempCount, tmpStore);
										tempCount++;
									}
									numbersCount++;
									evaluationValue.set(4, numbersCount);
								}
								
							}
							if (atrributeName.equals("productState")) {
								tempActorValueMap.outValue.addExpr(e.getValue().toString());//产品状态应该是输出哇！
							}else if (atrributeName.equals("knowledgeShare")) {
								tempActorValueMap.inValue.addExpr(e.getValue().toString());
							}else if (atrributeName.equals("price:type")) {
								tempActorValueMap.outValue.addProfit(e.getValue().toString());
							}
							else if (atrributeName.equals("product:warranty")) {
								tempActorValueMap.outValue.addProfit(e.getValue().toString());
							}else if (atrributeName.equals("product:errorCode")) {
//								tempActorValueMap.inValue.addExpr(e.getValue().toString());
								tempActorValueMap.outValue.addExpr(e.getValue().toString());
							}else if (atrributeName.equals("part:partModel")) {
								tempActorValueMap.inValue.addExpr(e.getValue().toString());
							}else if (atrributeName.equals("netPoint")) {
								tempActorValueMap.inValue.addTs("netPoint:"+e.getValue().toString());
							}
							else if (atrributeName.equals("performance:level")) {
								tempActorValueMap.outValue.addExpr("level"+e.getValue().toString());
							}
							else if (atrributeName.equals("product:status")) {
								tempActorValueMap.outValue.addExpr(e.getValue().toString());
							}
//							else if (atrributeName.equals("payment")) {
//								 tempActorValueMap.outValue.addExpr("payment: "+e.getValue().toString()); }
							else if (atrributeName.equals("numberRestartRepairs")) {
								tempActorValueMap.inValue.addExpr("numberRestartRepairs:"+e.getValue().toString());
							}else if (atrributeName.equals("numberRepairs")) {
								tempActorValueMap.inValue.addExpr("numberRepairs:"+e.getValue().toString());
							}
							else if (atrributeName.equals("product:productType")) {
								tempActorValueMap.inValue.addExpr(e.getValue().toString());
//								tempActorValueMap.outValue.addExpr(e.getValue().toString());
							}
							else if (atrributeName.equals("part:inStock")) {
								tempActorValueMap.outValue.addExpr(e.getValue().toString());
							}
							else if (atrributeName.equals("serviceType")) {
								tempActorValueMap.outValue.addExpr(e.getValue().toString());
							}
							else if (atrributeName.equals("stockLoc")) {
								tempActorValueMap.outValue.addTs(e.getValue().toString());
							}
							else if (atrributeName.equals("customerFeature")) {
								tempActorValueMap.inValue.addExpr(e.getValue().toString());
							}
							else if (atrributeName.equals("address")) {
								tempActorValueMap.outValue.addTs(e.getValue().toString());
							}
							else if (atrributeName.equals("payment(renew)")) {
//								tempActorValueMap = tempProcessValue.get(activityName).get(xMap.get("org:role").toString());
								tempActorValueMap.outValue.addProfit(e.getValue().toString());
							}
						}
						}
					}
				}
			}
		}
		ICES_activityActorValue_ActorValue tempActorValueMap1;
		HashMap<String, HashMap<String, List<Long>>> timeMapWithActor=findtime(log,tempProcessValue);		
		
		
		for (String activity:tempProcessValue.keySet()) {
			String tt = activity.toString();
			for (String name:tempProcessValue.get(activity).keySet()) {
				String tName = name + "," + tt;
				if (!timeMapWithActor.get(tt).get(name).isEmpty()) {
					long temp1 = 0L, size = 0;
					List<Long> timeList = timeMapWithActor.get(tt).get(name);
					;
					size = timeList.size();
					for (Long l : timeList) {
						temp1 += l;
					}
					double avg = temp1 / size;
					String tValue = "AvgTime:" + millisToStringShort(avg);// 添加时间
					tempActorValueMap1 = tempProcessValue.get(activity).get(name);
					tempActorValueMap1.inValue.addTs("AvgTime: "+millisToStringShort(avg));

				}
			}
		}
		
		
		//w.rwFile("evaluation List0716---:"+evaluationValue);
					for(int tmpi=0;tmpi<4;tmpi++) {
						//evaluationValue.set(tmpi, (Double.parseDouble(new DecimalFormat("#.##").format(evaluationValue.get(tmpi)/evaluationValue.get(3)))));
						tempProcessValue.get("Service Evaluation").get("Customer").inValue.addExpr(new DecimalFormat("#.##").format(evaluationValue.get(tmpi)/evaluationValue.get(4)));
						//w.rwFile("0716test evaluation---processValue: "+evaluationValue.get(tmpi)+"--"+evaluationValue.get(3));
						//w.rwFile("0716test evaluationAvg---processValue: "+new DecimalFormat("#.##").format(evaluationValue.get(tmpi)/evaluationValue.get(3)));
						
					}
					//w.rwFile("0716test evalList---:"+tempProcessValue.get("Service Evaluation"));
					//tempProcessValue.get("Service Evaluation").get("Customer").inValue.addExpr(Double.parseDouble(new DecimalFormat("#.##").format(evaluationValue.get(tmpi)/evaluationValue.get(3))));
					
					
		
		return tempProcessValue;
	}

	
	/* 重寫的含actor的時間統計timeMap */
	static HashMap<String, HashMap<String, List<Long>>> findtime(XLog log, HashMap<String,HashMap<String,ICES_activityActorValue_ActorValue>> processValue)
			throws ParseException {
		HashMap<String, HashMap<String, List<Long>>> timeMapWithActor = new HashMap<String, HashMap<String, List<Long>>>();
		HashMap<String, HashMap<String, String>> tempState = new HashMap<String, HashMap<String, String>>();//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷timemap时锟斤拷时锟斤拷录锟斤拷前锟铰硷拷锟角匡拷始锟斤拷锟角斤拷锟斤拷
		HashMap<String, HashMap<String, Long>> temp = new HashMap<String, HashMap<String, Long>>();//锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷timemap时锟斤拷时锟斤拷录锟斤拷前锟铰硷拷锟斤拷时锟斤拷锟�
		String time = "";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		List<String> actor = new ArrayList<>();
		for(String activity:processValue.keySet()) {
			for(String tempactor:processValue.get(activity).keySet()) {
				

				if (!actor.contains(tempactor))
					actor.add(tempactor);

				
				
				}
			}
			for(String activity:processValue.keySet()) {
				HashMap<String, List<Long>> actorlisttemp = new HashMap<String, List<Long>>();
			for (String actorlist : actor) {
				actorlisttemp.put(actorlist, new ArrayList<>());
			}
			timeMapWithActor.put(activity, actorlisttemp);
			System.out.println(activity+"|"+actorlisttemp);
		}
		
		
		
		for (XTrace trace : log) {// 锟斤拷valueMap锟斤拷值resource
			if (!trace.isEmpty()) {
				for (int i = 0; i < trace.size(); i++) {
					XAttributeMap xMap = trace.get(i).getAttributes();
					String key = xMap.get("concept:name").toString();// 锟斤拷锟斤拷迁锟斤拷锟斤拷为key
					// zy锟睫改猴拷timeMap锟斤拷actor
					time = xMap.get("time:timestamp").toString().replace("T", " ");// zy锟斤拷锟斤拷志锟斤拷时锟斤拷锟斤拷锟絫去锟斤拷
					HashMap<String, List<Long>> tempList = timeMapWithActor.get(key);// zy锟斤拷锟斤拷锟斤拷锟斤拷指锟斤拷map锟叫的碉拷前锟斤拷迁锟铰碉拷actor锟斤拷map
					if (xMap.containsKey("org:resource")) {
						String actorKey = xMap.get("org:resource").toString();
						List<Long> timeList = tempList.get(actorKey);
						if (xMap.get("lifecycle:transition") != null) {
							if (!temp.containsKey(key)) {
								HashMap<String, Long> tempMap = new HashMap<String, Long>();
								tempMap.put(actorKey, format.parse(time).getTime());
								temp.put(key, tempMap);
								HashMap<String, String> tempMap3 = new HashMap<String, String>();
								tempMap3.put(actorKey, xMap.get("lifecycle:transition").toString());
								tempState.put(key, tempMap3);
							} else if (!temp.get(key).containsKey(actorKey)) {
								HashMap<String, Long> tempMap2 = new HashMap<String, Long>();
								tempMap2.put(actorKey, format.parse(time).getTime());
								temp.put(key, tempMap2);
								HashMap<String, String> tempMap3 = new HashMap<String, String>();
								tempMap3.put(actorKey, xMap.get("lifecycle:transition").toString());
								tempState.put(key, tempMap3);
							} else if (!tempState.get(key).get(actorKey).equals("complete")) {
								timeList.add(format.parse(time).getTime() - temp.get(key).get(actorKey));
								temp.remove(key);
							}
						}
					}
				}
			}
			temp.clear();
		}
		for (XTrace trace : log) {// 锟斤拷valueMap锟斤拷值role
			if (!trace.isEmpty()) {
				for (int i = 0; i < trace.size(); i++) {
					XAttributeMap xMap = trace.get(i).getAttributes();
					String key = xMap.get("concept:name").toString();// 锟斤拷锟斤拷迁锟斤拷锟斤拷为key
					// zy锟睫改猴拷timeMap锟斤拷actor
					time = xMap.get("time:timestamp").toString().replace("T", " ");// zy锟斤拷锟斤拷志锟斤拷时锟斤拷锟斤拷锟絫去锟斤拷
					HashMap<String, List<Long>> tempList = timeMapWithActor.get(key);// zy锟斤拷锟斤拷锟斤拷锟斤拷指锟斤拷map锟叫的碉拷前锟斤拷迁锟铰碉拷actor锟斤拷map
					if (xMap.containsKey("org:role")) {
						String actorKey = xMap.get("org:role").toString();
						List<Long> timeList = tempList.get(actorKey);
						if (xMap.get("lifecycle:transition") != null) {
							if (!temp.containsKey(key)) {
								HashMap<String, Long> tempMap = new HashMap<String, Long>();
								tempMap.put(actorKey, format.parse(time).getTime());
								temp.put(key, tempMap);
								HashMap<String, String> tempMap3 = new HashMap<String, String>();
								tempMap3.put(actorKey, xMap.get("lifecycle:transition").toString());
								tempState.put(key, tempMap3);
							} else if (!temp.get(key).containsKey(actorKey)) {
								HashMap<String, Long> tempMap2 = new HashMap<String, Long>();
								tempMap2.put(actorKey, format.parse(time).getTime());
								temp.put(key, tempMap2);
								HashMap<String, String> tempMap3 = new HashMap<String, String>();
								tempMap3.put(actorKey, xMap.get("lifecycle:transition").toString());
								tempState.put(key, tempMap3);
							} else if (!tempState.get(key).get(actorKey).equals("complete")) {
								timeList.add(format.parse(time).getTime() - temp.get(key).get(actorKey));
								temp.remove(key);
							}
						}
					}
				}
			}
			temp.clear();
			}
		return timeMapWithActor;
	}

	public static StringBuffer millisToStringShort(double avg) {
		StringBuffer sb = new StringBuffer();
		long millis = 1;
		long seconds = 1000 * millis;
		long minutes = 60 * seconds;
		long hours = 60 * minutes;
		long days = 24 * hours;
		if (avg / days >= 1)
			sb.append((int) (avg / days) + " d ");
		if (avg % days / hours >= 1)
			sb.append((int) (avg % days / hours) + " h ");
		if (avg % days % hours / minutes >= 1)
			sb.append((int) (avg % days % hours / minutes) + " m ");
		if (avg % days % hours % minutes / seconds >= 1)
			sb.append((int) (avg % days % hours % minutes / seconds) + " s ");
		if (avg % days % hours % minutes % seconds / millis >= 1)
			sb.append((int) (avg % days % hours % minutes % seconds / millis) + " ms ");
		return sb;
	}
		
//	String与 set或者List实现字符串相加
	public static String aListConvert11(Set<String> set) {
		return "[" + String.join(",", set) + "]";
	}
}