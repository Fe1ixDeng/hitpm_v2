package hitpm_v2.ICES_beans_variant.list.test;

import hitpm_v2.ICES_beans_variant.Activity;
import hitpm_v2.ICES_beans_variant.list.Variant_String2Thing;

import java.util.List;

public class TestGenerateGraph {
    public static void main(String[] args) {
        Variant_String2Thing variant_string2Thing = new Variant_String2Thing();
        List<Activity> activityList = variant_string2Thing.splitVariant("Apply Repair-->User Identification-->Intelligent Response-->Manual Interaction-->Release Order-->Order Assignment-->[Repair-->Test Repair-->(Restart Repair)]-->Success-->Service Evaluation-->Archive", "-->");
    }

    public List<Activity> getFullList(String originalProcess) {
        Variant_String2Thing variant_string2Thing = new Variant_String2Thing();
        List<Activity> activityList = variant_string2Thing.splitVariant(originalProcess, "-->");
       return variant_string2Thing.setGraph(activityList);
    }

}
