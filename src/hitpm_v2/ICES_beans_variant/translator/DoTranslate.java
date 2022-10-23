import hitpm_v2.ICES_beans_variant.Activity;

import java.util.ArrayList;
import java.util.List;

public class DoTranslate {
    public Definitions translate(){
        TestGenerateGraph testGenerateGraph = new TestGenerateGraph();
        List<Activity> activityList = testGenerateGraph.getFullList();
        Definitions definitions = new Definitions();
        Process process = new Process("p1", "processOne");
        BPMNDiagram bpmnDiagram = new BPMNDiagram("bd1");
        definitions.setProcess(process);
        definitions.setBpmnDiagram(bpmnDiagram);

        int i = 0;  //id和name的分配器
        for (Activity activity:
             activityList) {
            if(activity.getName().equals("Apply Repair")){  //第一个
                process.setStartEvent(new StartEvent(process.getId()+"_StartEvent", process.getName()+"_StartEvent"));
                process.getSequenceFlow().add(new SequenceFlow(process.getId()+"_SF"+i+"_"+1, process.getName()+"_SF_"+i+"_"+1, process.getId()+"_StartEvent", process.getId()+"_UserTask_"+i));
                process.getUserTask().add(new UserTask(process.getId()+"_UserTask_"+i, process.getName()+"_StartEvent"+i));
                int j = i+1;
                process.getSequenceFlow().add(new SequenceFlow(process.getId()+"_SF"+i+"_"+2, process.getName()+"_SF"+i+"_"+2, process.getId()+"_UserTask_"+i, process.getId()+"_UserTask_"+j));

                bpmnDiagram.getBpmnPlane().getBpmnShape().add(new BPMNShape(process.getId()+"_StartEvent", process.getId()+"_StartEvent", new Bounds(30.0, 30.0, i, 100.0)));

//                bpmnDiagram.getBpmnPlane().getBpmnEdgeList().add();
//                bpmnDiagram.getBpmnPlane().getBpmnEdgeList().add();

            } else if (activity.getName().equals("Archive")) {  //最后一个
                process.getUserTask().add(new UserTask(process.getId()+ "_UserTask_"+i, process.getName()+"_UserTask_"+i));
                process.getSequenceFlow().add(new SequenceFlow(process.getId()+"_SF"+i+"_"+1, process.getName()+"_SF"+i+"_"+1, process.getId()+ "_UserTask_"+i, process.getId()+"_EndEvent"));
                process.setEndEvent(new EndEvent(process.getId()+"_EndEvent", process.getName()+"_EndEvent"));

                double jj = 30.0 + i*50.0;
                bpmnDiagram.getBpmnPlane().getBpmnShape().add(new BPMNShape(process.getId()+"_UserTask_"+i, process.getId()+"_UserTask_"+i, new Bounds(30,29,23,24)));

//                bpmnDiagram.getBpmnPlane().getBpmnEdgeList().add();

            } else if (activity.isLastNotFakeCircular()) {  //循环分支时的那一个
                /*----------xml上半部分----------------------------------------------------*/
                process.getUserTask().add(new UserTask(process.getId()+"_UserTask_"+i, process.getName()+"_userTask_"+i));
                process.getSequenceFlow().add(new SequenceFlow(process.getId()+"_SF"+i+"_"+1, process.getName()+"_SF"+i+"_"+1, process.getId()+"_UserTask_"+i, process.getId()+"_ExclusiveGateway"));
                process.setExclusiveGateway(new ExclusiveGateway(process.getId()+"_ExclusiveGateway"));
                int j = i+2;
                int k = i+1;
                process.getSequenceFlow().add(new SequenceFlow(process.getId()+"_SF"+i+"_main_"+2, process.getName()+"_SF"+i+"_"+2,process.getId()+"_ExclusiveGateway",process.getId()+"_UserTask_"+j));
                process.getSequenceFlow().add(new SequenceFlow(process.getId()+"_SF"+i+"_else_"+3, process.getName()+"_SF"+i+"_"+3,process.getId()+"_ExclusiveGateway",process.getId()+"_UserTask_"+k));
                /*-----------edge---------------------------------------------------*/
                BPMNEdge bpmnEdge1 = new BPMNEdge("", "");
                List<waypoint> waypointList = new ArrayList<>();
                waypointList.add(new waypoint(1.0, 1.0));
                bpmnEdge1.setWaypointList(waypointList);
                bpmnDiagram.getBpmnPlane().getBpmnEdge().add(bpmnEdge1);
                /*-----------shape---------------------------------------------------*/
                BPMNShape bpmnShape1 = new BPMNShape("" ,"", new Bounds(30.0, 30.0, i, 100.0));
                Bounds bounds1 = new Bounds(80, 80, 80 ,80);
                bpmnShape1.setBounds(bounds1);
                bpmnDiagram.getBpmnPlane().getBpmnShape().add(new BPMNShape("", "", new Bounds(30.0, 30.0, i, 100.0)));
                bpmnDiagram.getBpmnPlane().getBpmnShape().add(new BPMNShape("", "", new Bounds(30.0, 30.0, i, 100.0)));
                /*--------------------------------------------------------------*/
            }else { //一般的
                process.getUserTask().add(new UserTask(process.getId()+"_UserTask_"+i, process.getName()+"_UserTask_"+i));
                int j = i+1;
                process.getSequenceFlow().add(new SequenceFlow(process.getId()+"_SF"+i+"_"+2, process.getName()+"_SF"+i+"_"+2, process.getId()+"_UserTask_"+i, process.getId()+"_UserTask_"+j));

                double jj = 30.0 + i*50.0;
                bpmnDiagram.getBpmnPlane().getBpmnShape().add(new BPMNShape(process.getId()+"_UserTask_"+i, process.getId()+"_UserTask_"+i, new Bounds(30.0,30.0,jj,100.0)));

//                bpmnDiagram.getBpmnPlane().getBpmnEdgeList().add();
            }
            i++;
        }

        return definitions;
    }
}
