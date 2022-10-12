package hitpm_v2.ICES_beans_xes2bpmn.value;

import java.io.IOException;
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

import hitpm_v2.ICES_beans_xes2bpmn.value.ActorValue;
import hitpm_v2.ICES_beans_xes2bpmn.value.ValueElement;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class myPV {
	
	public HashMap<String, String> convert(XLog log) throws IOException, ParseException
	{
		HashMap<String, String> aav=new HashMap<String, String>();
		HashMap<String, HashMap<String,ActorValue>> tempProcessValue=mineProcessValue(log);
		for (String activity : tempProcessValue.keySet()) {
			
			String activityID=toPinyin(activity.replaceAll("\\s*", ""));
			
			aav.put(activityID, getString(tempProcessValue, activity));
		}
		//System.out.println(aav);
		return aav;
	}
	
	//��ö�Ӧ����ַ����������ߡ����������ֵ��
	public String getString(HashMap<String, HashMap<String,ActorValue>> tempProcessValue,
			String activity)
	{
//		String temp;
		StringBuffer buffer = new StringBuffer("");
		HashMap<String,ActorValue> map = tempProcessValue.get(activity);
		for (String key : map.keySet()) {
			String temp;
			ActorValue actorValue = map.get(key);
			ValueElement inValue = actorValue.inValue;
			ValueElement outValue = actorValue.outValue;
			temp=key+"\n"+"-输入价值("+inValue.getValue()+")"+"\n"
			+"-输出价值("+outValue.getValue()+")"+"\n";
			buffer.append(temp);
		}
		return buffer.toString();
	}
	
	public HashMap<String, HashMap<String,ActorValue>>  mineProcessValue(XLog log) throws IOException, ParseException {
		//Write w = new Write();
		// TODO Auto-generated method stub
		HashMap<String, HashMap<String,ActorValue>> tempProcessValue = new HashMap<String, HashMap<String,ActorValue>>();
		HashMap<String, ActorValue> actorValueMap;
		String activityName, actorName;
		ActorValue tempActorValueMap;
		
		//HashMap<String,Set<String>> tmpBenifitValue = new HashMap<String, Set<String>>();//��ʱ�洢���������Ϣ
		//Set<String> tmpBenifitSet = new HashSet<String>();//��ʱ�洢��������
		ArrayList<Double> evaluationValue = new ArrayList<Double>(5);//�洢���ۼ�ֵ����ƽ��ֵ���㣡
		evaluationValue.add(0.0);evaluationValue.add(0.0);evaluationValue.add(0.0);evaluationValue.add(0.0);evaluationValue.add(0.0);
		
		for (XTrace trace : log) {//��valueMap��ֵ
			if (!trace.isEmpty()) {
				for (int i = 0; i < trace.size(); i++) {
					XAttributeMap xMap = trace.get(i).getAttributes();
					
					if (xMap.size() > 3) {//20211201:4�ĳ�3
						for (Entry e : xMap.entrySet()) {//attribute
//							if (!unuse.contains(e.getKey().toString())) {
							if (e.getKey().toString().equals("concept:name")||e.getKey().toString().equals("lifecycle:transition")||e.getKey().toString().equals("time:timestamp")) {}
							else{
							actorValueMap = new HashMap();
							activityName = xMap.get("concept:name").toString();
							
							/*��ֵָ��ӳ���ʼ��*/
							if(!tempProcessValue.containsKey(activityName)) {
								tempProcessValue.put(activityName, actorValueMap);
							}else {//���߻�ȡ���Ӧ�Ĳ����߼�ֵ
								actorValueMap = tempProcessValue.get(activityName);
							}
							//��Ӳ����ߣ�����ʼ����Ӳ�����-��ֵӳ��
							if(e.getKey().toString().equals("org:resource")||e.getKey().toString().equals("org:role")) {
								//w.rwFile("e-value=="+e.getValue().toString());
								actorName = e.getValue().toString();
								if(!actorValueMap.keySet().contains(actorName))
									actorValueMap.put(actorName, new ActorValue());
							}
							//ָ��ǰ���Ӧ�Ĳ����� ����ļ�ֵ
							if(xMap.get("org:resource")!=null) {
								tempActorValueMap = tempProcessValue.get(activityName).get(xMap.get("org:resource").toString());
							}else if((xMap.get("org:resource")==null && (xMap.get("org:role")!=null))) {
								tempActorValueMap = tempProcessValue.get(activityName).get(xMap.get("org:role").toString());
							}else {
								tempActorValueMap=new ActorValue();
								tempActorValueMap.inValue = new ValueElement();
								tempActorValueMap.outValue = new ValueElement();
							}
							if(tempActorValueMap==null) {
								tempActorValueMap=new ActorValue();
								tempActorValueMap.inValue = new ValueElement();
								tempActorValueMap.outValue = new ValueElement();
							}
							
							String atrributeName_temp = e.getKey().toString();// ����������

							String atrributeName = atrributeName_temp;

							if(true) {
								if (atrributeName.equals("payment")) {
									
									tempActorValueMap.outValue.addProfit("支付: "+e.getValue().toString());
								}
								
								
								if (atrributeName.equals("evaluation")) {
									//w.rwFile(e.getValue().toString());//����Ƕ������ʶ��
									
									XAttributeList attriList = (XAttributeList) e.getValue();
									int tempCount = 0;
									Double numbersCount = evaluationValue.get(4);//�ҵ������ж��ٸ����ۼ�ֵ�Ĵ洢ֵ
									for(XAttribute serVal:attriList.getCollection()) {
										//���ǵ�ַ������
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
								tempActorValueMap.outValue.addExpr(e.getValue().toString());//��Ʒ״̬Ӧ��������ۣ�
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
								tempActorValueMap.inValue.addTs("网点:"+e.getValue().toString());
							}
							else if (atrributeName.equals("performance:level")) {
								tempActorValueMap.outValue.addExpr("等级"+e.getValue().toString());
							}
							else if (atrributeName.equals("product:status")) {
								tempActorValueMap.outValue.addExpr(e.getValue().toString());
							}
//							else if (atrributeName.equals("payment")) {
//								 tempActorValueMap.outValue.addExpr("payment: "+e.getValue().toString()); }
							else if (atrributeName.equals("numberRestartRepairs")) {
								tempActorValueMap.inValue.addExpr("重新维修的次数:"+e.getValue().toString());
							}else if (atrributeName.equals("numberRepairs")) {
								tempActorValueMap.inValue.addExpr("维修次数:"+e.getValue().toString());
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
		
		ActorValue tempActorValueMap1;
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
					String tValue = "AvgTime:" + millisToStringShort(avg);// ���ʱ��
					tempActorValueMap1 = tempProcessValue.get(activity).get(name);
					tempActorValueMap1.inValue.addTs("AvgTime: "+millisToStringShort(avg));

				}
			}
		}	
		return tempProcessValue;
	}
	
	static HashMap<String, HashMap<String, List<Long>>> findtime(XLog log, HashMap<String,HashMap<String,ActorValue>> processValue)
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
	
	
	public StringBuffer millisToStringShort(double avg) {
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
		
//	String�� set����Listʵ���ַ������
	public String aListConvert11(Set<String> set) {
		return "[" + String.join(",", set) + "]";
	}
	  public String toPinyin(String hanzi) {
	      //输出格式设置
	      HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();

	      format.setCaseType(HanyuPinyinCaseType.LOWERCASE);

	      /**
	       * 输出音标设置
	       *
	       * WITH_TONE_MARK:直接用音标符（必须设置WITH_U_UNICODE，否则会抛出异常）
	       * WITH_TONE_NUMBER：1-4数字表示音标
	       * WITHOUT_TONE：没有音标
	       */
	      format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);

	      char[] hanYuArr = hanzi.trim().toCharArray();
	      StringBuilder pinYin = new StringBuilder();

	      try {
	          for (int i = 0, len = hanYuArr.length; i < len; i++) {
	              //匹配是否是汉字
	              if (Character.toString(hanYuArr[i]).matches("[\\u4E00-\\u9FA5]+")) {
	                  //如果是多音字，返回多个拼音，这里只取第一个
	                  String[] pys = PinyinHelper.toHanyuPinyinStringArray(hanYuArr[i], format);
	                  pinYin.append(pys[0]).append("");
	              } else {
	                  pinYin.append(hanYuArr[i]).append("");
	              }
	          }
	      } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
	          badHanyuPinyinOutputFormatCombination.printStackTrace();
	      }
	      return pinYin.toString();
	  }
}