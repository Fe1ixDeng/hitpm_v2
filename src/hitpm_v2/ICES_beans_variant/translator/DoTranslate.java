package hitpm_v2.ICES_beans_variant.translator;

import hitpm_v2.ICES_beans_variant.Activity;
import hitpm_v2.ICES_beans_variant.bpmnElement.Definitions;
import hitpm_v2.ICES_beans_variant.bpmnElement.diagram.*;
import hitpm_v2.ICES_beans_variant.bpmnElement.process.Process;
import hitpm_v2.ICES_beans_variant.bpmnElement.process.*;
import hitpm_v2.ICES_beans_variant.list.test.TestGenerateGraph;

import java.util.List;

public class DoTranslate {
    public Definitions translate(String originalProcess){
        TestGenerateGraph testGenerateGraph = new TestGenerateGraph();
        List<Activity> activityList = testGenerateGraph.getFullList(originalProcess);
        System.out.println(originalProcess);
        Definitions definitions = new Definitions();
        Process process = new Process("p1", "processOne");
        BPMNDiagram bpmnDiagram = new BPMNDiagram("bd1");
        definitions.setProcess(process);
        definitions.setBpmnDiagram(bpmnDiagram);

        double defaultY = 300.0;
        int i = 1;  //id和name的分配器
        int firstCircular = 9999;
        double xOfFirstCircular = 100;
        boolean passCircular = false;
        for (Activity activity:
             activityList) {
            if(activity.getName().equals("Apply Repair")){  //第一个
                /*----------xml上半部分----------------------------------------------------*/
                process.setStartEvent(new StartEvent(process.getId()+"_StartEvent", null));
                process.getSequenceFlow().add(new SequenceFlow(process.getId()+"_SF"+i+"_"+1, null, process.getId()+"_StartEvent", process.getId()+"_UserTask_"+i));
                process.getUserTask().add(new UserTask(process.getId()+"_UserTask_"+i, activity.getName()));
                int j = i+1;
                process.getSequenceFlow().add(new SequenceFlow(process.getId()+"_SF"+i+"_"+2, null, process.getId()+"_UserTask_"+i, process.getId()+"_UserTask_"+j));
                /*-----------shape---------------------------------------------------*/
                bpmnDiagram.getBpmnPlane().getBpmnShape().add(new BPMNShape(process.getId()+"_StartEvent", "BPMNShape_" + process.getId()+"_StartEvent", new Bounds(30.0, 30.0, 100.0, defaultY+25.0)));
                bpmnDiagram.getBpmnPlane().getBpmnShape().add(new BPMNShape(process.getId()+"_UserTask_"+i, "BPMNShape_" + process.getId()+"_UserTask_"+i, new Bounds(80.0, 80.0, 150.0, defaultY)));
                /*-----------edge---------------------------------------------------*/
                BPMNEdge bpmnEdge1 = new BPMNEdge(process.getId()+"_SF"+i+"_"+1, "BPMNShape_" + process.getId()+"_SF"+i+"_"+1);
                bpmnEdge1.getWaypointList().add(new waypoint(130.0, defaultY+40.0));
                bpmnEdge1.getWaypointList().add(new waypoint(150.0, defaultY+40.0));
                bpmnDiagram.getBpmnPlane().getBpmnEdge().add(bpmnEdge1);

                BPMNEdge bpmnEdge2 = new BPMNEdge(process.getId()+"_SF"+i+"_"+2, "BPMNShape_" + process.getId()+"_SF"+i+"_"+2);
                bpmnEdge2.getWaypointList().add(new waypoint(230.0, defaultY+40.0));
                bpmnEdge2.getWaypointList().add(new waypoint(250.0, defaultY+40.0));
                bpmnDiagram.getBpmnPlane().getBpmnEdge().add(bpmnEdge2);
                /*--------------------------------------------------------------*/
            } else if (activity.getName().equals("Archive")) {  //最后一个
                /*----------xml上半部分----------------------------------------------------*/
                process.getUserTask().add(new UserTask(process.getId()+ "_UserTask_"+i, activity.getName()));
                process.getSequenceFlow().add(new SequenceFlow(process.getId()+"_SF"+i+"_"+1, null, process.getId()+ "_UserTask_"+i, process.getId()+"_EndEvent"));
                process.setEndEvent(new EndEvent(process.getId()+"_EndEvent", null));
                /*-----------shape---------------------------------------------------*/
                double jj = 250.0 + (i-2)*140.0;
                double jjj = 250.0 + (i-2)*140.0+40+20;
                if(passCircular){
                    bpmnDiagram.getBpmnPlane().getBpmnShape().add(new BPMNShape(process.getId()+"_UserTask_"+i, "BPMNShape_" + process.getId()+"_UserTask_"+i, new Bounds(80.0,80.0,jjj,defaultY)));
                    bpmnDiagram.getBpmnPlane().getBpmnShape().add(new BPMNShape(process.getId()+"_EndEvent", "BPMNShape_" + process.getId()+"_EndEvent", new Bounds(30.0,30.0,jjj+100,defaultY+25.0)));
                }else {
                    bpmnDiagram.getBpmnPlane().getBpmnShape().add(new BPMNShape(process.getId()+"_UserTask_"+i, "BPMNShape_" + process.getId()+"_UserTask_"+i, new Bounds(80.0,80.0,jj,defaultY)));
                    bpmnDiagram.getBpmnPlane().getBpmnShape().add(new BPMNShape(process.getId()+"_EndEvent", "BPMNShape_" + process.getId()+"_EndEvent", new Bounds(30.0,30.0,jj+100,defaultY+25.0)));
                }
                /*-----------edge---------------------------------------------------*/
                if (passCircular){
                    BPMNEdge bpmnEdge1 = new BPMNEdge(process.getId()+"_SF"+i+"_"+1, "BPMNShape_" + process.getId()+"_SF"+i+"_"+1);
                    bpmnEdge1.getWaypointList().add(new waypoint(jjj+80, defaultY+40.0));
                    bpmnEdge1.getWaypointList().add(new waypoint(jjj+100, defaultY+40.0));
                    bpmnDiagram.getBpmnPlane().getBpmnEdge().add(bpmnEdge1);
                }else {
                    BPMNEdge bpmnEdge1 = new BPMNEdge(process.getId()+"_SF"+i+"_"+1, "BPMNShape_" + process.getId()+"_SF"+i+"_"+1);
                    bpmnEdge1.getWaypointList().add(new waypoint(jj+80, defaultY+40.0));
                    bpmnEdge1.getWaypointList().add(new waypoint(jj+100, defaultY+40.0));
                    bpmnDiagram.getBpmnPlane().getBpmnEdge().add(bpmnEdge1);
                }
                /*--------------------------------------------------------------*/
            } else if (activity.isLastNotFakeCircular()) {  //循环分支时的那一个
                /*----------xml上半部分----------------------------------------------------*/
                process.getUserTask().add(new UserTask(process.getId()+"_UserTask_"+i, activity.getName()));
                process.getSequenceFlow().add(new SequenceFlow(process.getId()+"_SF"+i+"_"+1, null, process.getId()+"_UserTask_"+i, process.getId()+"_ExclusiveGateway"));
                process.setExclusiveGateway(new ExclusiveGateway(process.getId()+"_ExclusiveGateway"));
                int j = i+2;
                process.getSequenceFlow().add(new SequenceFlow(process.getId()+"_SF"+i+"_main_"+2, null,process.getId()+"_ExclusiveGateway",process.getId()+"_UserTask_"+j));
                process.getSequenceFlow().add(new SequenceFlow(process.getId()+"_SF"+i+"_else_"+3, null,process.getId()+"_ExclusiveGateway",process.getId()+"_UserTask_"+"Else"));
                /*-----------shape---------------------------------------------------*/
                double jj = 250.0 + (i-2)*140.0;
                bpmnDiagram.getBpmnPlane().getBpmnShape().add(new BPMNShape(process.getId()+"_UserTask_"+i, "BPMNShape_" + process.getId()+"_UserTask_"+i, new Bounds(80.0,120.0, jj,defaultY)));
                bpmnDiagram.getBpmnPlane().getBpmnShape().add(new BPMNShape(process.getId()+"_ExclusiveGateway", "BPMNShape_" + process.getId()+"_ExclusiveGateway", new Bounds(40.0,40.0, jj+140,defaultY+20.0)));
                /*-----------edge---------------------------------------------------*/
                BPMNEdge bpmnEdge1 = new BPMNEdge(process.getId()+"_SF"+i+"_"+1, "BPMNShape_" + process.getId()+"_SF"+i+"_"+1);
                bpmnEdge1.getWaypointList().add(new waypoint(jj+120, defaultY+40.0));
                bpmnEdge1.getWaypointList().add(new waypoint(jj+140, defaultY+40.0));
                bpmnDiagram.getBpmnPlane().getBpmnEdge().add(bpmnEdge1);

                BPMNEdge bpmnEdge2 = new BPMNEdge(process.getId()+"_SF"+i+"_main_"+2, "BPMNShape_" + process.getId()+"_SF"+i+"_main_"+2);
                bpmnEdge2.getWaypointList().add(new waypoint(jj+180, defaultY+40.0));
                bpmnEdge2.getWaypointList().add(new waypoint(jj+200, defaultY+40.0));
                bpmnDiagram.getBpmnPlane().getBpmnEdge().add(bpmnEdge2);

                BPMNEdge bpmnEdge3 = new BPMNEdge(process.getId()+"_SF"+i+"_else_"+3, "BPMNShape_" + process.getId()+"_SF"+i+"_else_"+3);
                bpmnEdge3.getWaypointList().add(new waypoint(jj+160, defaultY+60.0));
                bpmnEdge3.getWaypointList().add(new waypoint(jj+160, defaultY+170.0));
                bpmnEdge3.getWaypointList().add(new waypoint(jj+120, defaultY+170.0));
                bpmnDiagram.getBpmnPlane().getBpmnEdge().add(bpmnEdge3);
                /*--------------------------------------------------------------*/
            } else if (activity.isFakeCircular()) {
                i--;
                passCircular = true;
                /*----------xml上半部分----------------------------------------------------*/
                process.getUserTask().add(new UserTask(process.getId()+"_UserTask_"+"Else", activity.getName()));
                int j = i+1;
                process.getSequenceFlow().add(new SequenceFlow(process.getId()+"_SF_"+"Else"+"_"+1, null, process.getId()+"_UserTask_"+"Else", process.getId()+"_UserTask_"+firstCircular));
                /*-----------shape---------------------------------------------------*/
                bpmnDiagram.getBpmnPlane().getBpmnShape().add(new BPMNShape(process.getId()+"_UserTask_"+"Else", "BPMNShape_" + process.getId()+"_UserTask_"+"Else", new Bounds(80.0,120.0, 250.0 + (i-2)*140.0,defaultY+130.0)));
                /*-----------edge---------------------------------------------------*/
                BPMNEdge bpmnEdge1 = new BPMNEdge(process.getId()+"_SF_"+"Else"+"_"+1, "BPMNShape_" + process.getId()+"_SF_"+"Else"+"_"+1);
                bpmnEdge1.getWaypointList().add(new waypoint(250.0 + (i-2)*140.0, defaultY+170.0));
                bpmnEdge1.getWaypointList().add(new waypoint(xOfFirstCircular+60, defaultY+170.0));
                bpmnEdge1.getWaypointList().add(new waypoint(xOfFirstCircular+60, defaultY+80.0));
                bpmnDiagram.getBpmnPlane().getBpmnEdge().add(bpmnEdge1);
                /*--------------------------------------------------------------*/
            } else { //一般的
                if (activity.isFirstCircular()){
                    firstCircular = i;
                    xOfFirstCircular = 250.0 + (i-2)*140.0;
                }
                /*----------xml上半部分----------------------------------------------------*/
                process.getUserTask().add(new UserTask(process.getId()+"_UserTask_"+i, activity.getName()));
                int j = i+1;
                process.getSequenceFlow().add(new SequenceFlow(process.getId()+"_SF"+i+"_"+1, null, process.getId()+"_UserTask_"+i, process.getId()+"_UserTask_"+j));
                /*-----------shape---------------------------------------------------*/
                double jj = 250.0 + (i-2)*140.0;
                double jjj = 250.0 + (i-2)*140.0+40+20;
                if (passCircular)
                    bpmnDiagram.getBpmnPlane().getBpmnShape().add(new BPMNShape(process.getId()+"_UserTask_"+i, "BPMNShape_" + process.getId()+"_UserTask_"+i, new Bounds(80.0,120.0, jjj,defaultY)));
                else
                    bpmnDiagram.getBpmnPlane().getBpmnShape().add(new BPMNShape(process.getId()+"_UserTask_"+i, "BPMNShape_" + process.getId()+"_UserTask_"+i, new Bounds(80.0,120.0, jj,defaultY)));
                /*-----------edge---------------------------------------------------*/
                BPMNEdge bpmnEdge1 = new BPMNEdge(process.getId()+"_SF"+i+"_"+1, "BPMNShape_" + process.getId()+"_SF"+i+"_"+1);
                if (passCircular){
                    bpmnEdge1.getWaypointList().add(new waypoint(jjj+120, defaultY+40.0));
                    bpmnEdge1.getWaypointList().add(new waypoint(jjj+140, defaultY+40.0));
                }else{
                    bpmnEdge1.getWaypointList().add(new waypoint(jj+120, defaultY+40.0));
                    bpmnEdge1.getWaypointList().add(new waypoint(jj+140, defaultY+40.0));
                }
                bpmnDiagram.getBpmnPlane().getBpmnEdge().add(bpmnEdge1);
                /*--------------------------------------------------------------*/
            }
            i++;
        }

        return definitions;
    }
}
