import hitpm_v2.ICES_beans_variant.Activity;

import java.util.List;

public class TestGenerateGraph {
    public static void main(String[] args) {
        Variant_String2Thing variant_string2Thing = new Variant_String2Thing();
        List<Activity> activityList = variant_string2Thing.splitVariant("Apply Repair-->User Identification-->Intelligent Response-->Manual Interaction-->Release Order-->Order Assignment-->[Repair-->Test Repair-->(Restart Repair)]-->Success-->Service Evaluation-->Archive", "-->");


//        Variant_String2Thing variant_string2Thing = new Variant_String2Thing();
//        List<Activity> activityList = variant_string2Thing.splitVariant("Apply Repair-->User Identification-->Intelligent Response-->Manual Interaction-->Release Order-->Order Assignment-->[Repair-->Test Repair-->(Restart Repair)]-->Success-->Service Evaluation-->Archive", "-->");
//        for(Activity activity : variant_string2Thing.setGraph(activityList)){
//            System.out.println("Name:" + activity.getName());
//            if (activity.getMainNext() != null)
//                System.out.println("MainNext:" + activity.getMainNext().getName());
//            else
//                System.out.println("MainNext:" + activity.getMainNext());
//            System.out.println("ElseNext:" + activity.getElseNext());
//            System.out.println("isMain?" + activity.isMain());
//            System.out.println();
//        }
    }

    public List<Activity> getFullList() {
        Variant_String2Thing variant_string2Thing = new Variant_String2Thing();
        List<Activity> activityList = variant_string2Thing.splitVariant("Apply Repair-->User Identification-->Intelligent Response-->Manual Interaction-->Release Order-->Order Assignment-->[Repair-->Test Repair-->(Restart Repair)]-->Success-->Service Evaluation-->Archive", "-->");
       return variant_string2Thing.setGraph(activityList);
    }

}
