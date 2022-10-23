import hitpm_v2.ICES_beans_variant.Activity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Variant_String2Thing {
    int firstCircularSeq = 0;
    public List<Activity> splitVariant(String variant, String delimeter){
        List<String> informationList = new ArrayList<>();
        List<Activity> activityList = new ArrayList<>();
        informationList.addAll(Arrays.asList(variant.split(delimeter))); // 分割字符串


        for(String information : informationList){
            if(information.contains("[")){
                information = information.replace("[","");
                Activity activity = new Activity(information, true, false);
                activity.setFirstCircular(true);
                activityList.add(activity);
                firstCircularSeq = activityList.indexOf(activity);
            } else if (information.contains("]")) {
                information = information.replace("]","");
                information = information.replace("(","");
                information = information.replace(")","");
                Activity activity = new Activity(information, true, true);
                activity.setMainNext(activityList.stream().filter(activity1 -> activity1.isFirstCircular()).collect(Collectors.toList()).get(0));
                //循环的回溯流
                activityList.add(activity);
            } else {
                activityList.add(new Activity(information));
            }
        }

        return activityList;
    }

    public List<Activity> setGraph(List<Activity> activityList) {
        for(int i = 0; i < activityList.size()-1; i++){
            activityList.get(i).setMainNext( activityList.get(i+1));
            if(activityList.get(i).isFakeCircular()){
                activityList.get(i).setMain(false);
            } else
                activityList.get(i).setMain(true);
        }
        for(int i = 0; i < activityList.size()-1; i++){
            if(activityList.get(i).isFakeCircular()){
                activityList.get(i-1).setMainNext(activityList.get(i+1));
                activityList.get(i-1).setElseNext((activityList.get(i)));
                activityList.get(i-1).setLastNotFakeCircular(true);
                activityList.get(i).setMainNext(activityList.get(firstCircularSeq));
                System.out.println(firstCircularSeq);
            }
        }

        return activityList;
    }
}
