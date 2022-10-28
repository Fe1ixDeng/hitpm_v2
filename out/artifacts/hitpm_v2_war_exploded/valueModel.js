var Str = `<?xml version='1.0' encoding='UTF-8'?>
<bpmn2:definitions xmlns="http://www.omg.org/spec/BPMN/20100524/MODEL" xmlns:bpmn2="http://www.omg.org/spec/BPMN/20100524/MODEL" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:activiti="http://activiti.org/bpmn" xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI" xmlns:omgdc="http://www.omg.org/spec/DD/20100524/DC" xmlns:omgdi="http://www.omg.org/spec/DD/20100524/DI" typeLanguage="http://www.w3.org/2001/XMLSchema" expressionLanguage="http://www.w3.org/1999/XPath" targetNamespace="http://www.activiti.org/test">
  <bpmn2:process id="my-process" isExecutable="true">
    <bpmn2:startEvent id="Start"/>
    <bpmn2:endEvent id="End"/>
    <bpmn2:userTask id="ApplyRepair" name="ApplyRepair"/>
    <bpmn2:userTask id="UserIdentification" name="UserIdentification"/>
    <bpmn2:exclusiveGateway id="GatewayXorS1"/>
    <bpmn2:userTask id="IntelligentResponse" name="IntelligentResponse"/>
    <bpmn2:userTask id="ManualInteraction" name="ManualInteraction"/>
    <bpmn2:exclusiveGateway id="GatewayXorS2"/>
    <bpmn2:userTask id="ReleaseOrder" name="ReleaseOrder"/>
    <bpmn2:userTask id="OrderAssignment" name="OrderAssignment"/>
    <bpmn2:exclusiveGateway id="GatewayXorS3"/>
    <bpmn2:userTask id="Repair" name="Repair"/>
    <bpmn2:userTask id="TestRepair" name="TestRepair"/>
    <bpmn2:userTask id="RestartRepair" name="RestartRepair"/>
    <bpmn2:exclusiveGateway id="GatewayXorS4"/>
    <bpmn2:userTask id="Success" name="Success"/>
    <bpmn2:userTask id="Renew" name="Renew"/>
    <bpmn2:userTask id="ServiceEvaluation" name="ServiceEvaluation"/>
    <bpmn2:userTask id="Archive" name="Archive"/>
    <bpmn2:sequenceFlow id="StartApplyRepair" sourceRef="Start" targetRef="ApplyRepair"/>
    <bpmn2:sequenceFlow id="ApplyRepairUserIdentification" sourceRef="ApplyRepair" targetRef="UserIdentification"/>
    <bpmn2:sequenceFlow id="UserIdentificationGatewayXorS1" sourceRef="UserIdentification" targetRef="GatewayXorS1"/>
    <bpmn2:sequenceFlow id="GatewayXorS1GatewayXorS2" sourceRef="GatewayXorS1" targetRef="GatewayXorS2"/>
    <bpmn2:sequenceFlow id="GatewayXorS1IntelligentResponse" sourceRef="GatewayXorS1" targetRef="IntelligentResponse"/>
    <bpmn2:sequenceFlow id="IntelligentResponseManualInteraction" sourceRef="IntelligentResponse" targetRef="ManualInteraction"/>
    <bpmn2:sequenceFlow id="ManualInteractionGatewayXorS2" sourceRef="ManualInteraction" targetRef="GatewayXorS2"/>
    <bpmn2:sequenceFlow id="GatewayXorS2ServiceEvaluation" sourceRef="GatewayXorS2" targetRef="ServiceEvaluation"/>
    <bpmn2:sequenceFlow id="GatewayXorS2ReleaseOrder" sourceRef="GatewayXorS2" targetRef="ReleaseOrder"/>
    <bpmn2:sequenceFlow id="ReleaseOrderOrderAssignment" sourceRef="ReleaseOrder" targetRef="OrderAssignment"/>
    <bpmn2:sequenceFlow id="OrderAssignmentRepair" sourceRef="OrderAssignment" targetRef="Repair"/>
    <bpmn2:sequenceFlow id="GatewayXorS3GatewayXorS4" sourceRef="GatewayXorS3" targetRef="GatewayXorS4"/>
    <bpmn2:sequenceFlow id="GatewayXorS3RestartRepair" sourceRef="GatewayXorS3" targetRef="RestartRepair"/>
    <bpmn2:sequenceFlow id="RepairTestRepair" sourceRef="Repair" targetRef="TestRepair"/>
    <bpmn2:sequenceFlow id="TestRepairGatewayXorS3" sourceRef="TestRepair" targetRef="GatewayXorS3"/>
    <bpmn2:sequenceFlow id="RestartRepairRepair" sourceRef="RestartRepair" targetRef="Repair"/>
    <bpmn2:sequenceFlow id="GatewayXorS4Renew" sourceRef="GatewayXorS4" targetRef="Renew"/>
    <bpmn2:sequenceFlow id="GatewayXorS4Success" sourceRef="GatewayXorS4" targetRef="Success"/>
    <bpmn2:sequenceFlow id="SuccessServiceEvaluation" sourceRef="Success" targetRef="ServiceEvaluation"/>
    <bpmn2:sequenceFlow id="RenewServiceEvaluation" sourceRef="Renew" targetRef="ServiceEvaluation"/>
    <bpmn2:sequenceFlow id="ServiceEvaluationArchive" sourceRef="ServiceEvaluation" targetRef="Archive"/>
    <bpmn2:sequenceFlow id="ArchiveEnd" sourceRef="Archive" targetRef="End"/>
    <bpmn2:textAnnotation id="ManualInteractionvalue">
      <bpmn2:text>Staff2
-杈撳叆浠峰��(ts:[AvgTime: 19 m 26 s 629 ms ]expr:[]profit:[])
-杈撳嚭浠峰��(ts:[address3, address2, address1]expr:[]profit:[0, 555.21])
Staff3
-杈撳叆浠峰��(ts:[AvgTime: 20 m 17 s 672 ms ]expr:[]profit:[])
-杈撳嚭浠峰��(ts:[address3, address2, address1]expr:[]profit:[0, 89.12, 522.7])
Staff1
-杈撳叆浠峰��(ts:[AvgTime: 21 m 12 s 60 ms ]expr:[]profit:[])
-杈撳嚭浠峰��(ts:[address3, address2, address1]expr:[]profit:[0, 54.19, 803.83, 793.49, 312.36])
Customer
-杈撳叆浠峰��(ts:[AvgTime: 20 m 16 s 26 ms ]expr:[]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[])
</bpmn2:text>
    </bpmn2:textAnnotation>
    <bpmn2:association id="ManualInteraction2value" sourceRef="ManualInteraction" targetRef="ManualInteractionvalue" associationDirection="None"/>
    <bpmn2:textAnnotation id="Archivevalue">
      <bpmn2:text>System
-杈撳叆浠峰��(ts:[]expr:[缁翠慨娆℃暟:3, 缁翠慨娆℃暟:2, 缁翠慨娆℃暟:1, 缁翠慨娆℃暟:0]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[Fixed]profit:[])
</bpmn2:text>
    </bpmn2:textAnnotation>
    <bpmn2:association id="Archive2value" sourceRef="Archive" targetRef="Archivevalue" associationDirection="None"/>
    <bpmn2:textAnnotation id="ReleaseOrdervalue">
      <bpmn2:text>Staff2
-杈撳叆浠峰��(ts:[]expr:[ES1, ES0, ES3, ES2, ES5, ES4, ES7, ES6, ES9, ES8]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[])
Staff3
-杈撳叆浠峰��(ts:[]expr:[ES1, ES0, ES3, ES2, ES5, ES4, ES7, ES6, ES9, ES8]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[])
Staff1
-杈撳叆浠峰��(ts:[]expr:[ES1, ES0, ES3, ES2, ES5, ES4, ES7, ES6, ES9, ES8]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[])
</bpmn2:text>
    </bpmn2:textAnnotation>
    <bpmn2:association id="ReleaseOrder2value" sourceRef="ReleaseOrder" targetRef="ReleaseOrdervalue" associationDirection="None"/>
    <bpmn2:textAnnotation id="OrderAssignmentvalue">
      <bpmn2:text>Engineer7
-杈撳叆浠峰��(ts:[缃戠偣:3, 缃戠偣:2, 缃戠偣:1, 缃戠偣:4]expr:[Handbook]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[Repairement, Fastening, Adjustment, Replenishment, Repairing, Cleaning]profit:[])
Engineer6
-杈撳叆浠峰��(ts:[缃戠偣:3, 缃戠偣:2, 缃戠偣:1, 缃戠偣:4]expr:[Handbook]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[Repairement, Fastening, Adjustment, Replenishment, Cleaning, Repairing]profit:[])
Engineer5
-杈撳叆浠峰��(ts:[缃戠偣:3, 缃戠偣:2, 缃戠偣:1, 缃戠偣:4]expr:[Handbook]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[Repairement, Adjustment, Fastening, Replenishment, Repairing, Cleaning]profit:[])
Engineer4
-杈撳叆浠峰��(ts:[缃戠偣:3, 缃戠偣:2, 缃戠偣:1, 缃戠偣:4]expr:[Handbook]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[Repairement, Fastening, Adjustment, Replenishment, Repairing, Cleaning]profit:[])
Engineer3
-杈撳叆浠峰��(ts:[缃戠偣:3, 缃戠偣:2, 缃戠偣:1, 缃戠偣:4]expr:[Handbook]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[Repairement, Adjustment, Fastening, Replenishment, Repairing, Cleaning]profit:[])
Engineer2
-杈撳叆浠峰��(ts:[缃戠偣:3, 缃戠偣:2, 缃戠偣:1, 缃戠偣:4]expr:[Handbook]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[Repairement, Adjustment, Fastening, Replenishment, Cleaning, Repairing]profit:[])
Engineer1
-杈撳叆浠峰��(ts:[缃戠偣:3, 缃戠偣:2, 缃戠偣:1, 缃戠偣:4]expr:[Handbook]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[Repairement, Adjustment, Fastening, Replenishment, Repairing, Cleaning]profit:[])
</bpmn2:text>
    </bpmn2:textAnnotation>
    <bpmn2:association id="OrderAssignment2value" sourceRef="OrderAssignment" targetRef="OrderAssignmentvalue" associationDirection="None"/>
    <bpmn2:textAnnotation id="ServiceEvaluationvalue">
      <bpmn2:text>Customer
-杈撳叆浠峰��(ts:[]expr:[]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[])
</bpmn2:text>
    </bpmn2:textAnnotation>
    <bpmn2:association id="ServiceEvaluation2value" sourceRef="ServiceEvaluation" targetRef="ServiceEvaluationvalue" associationDirection="None"/>
    <bpmn2:textAnnotation id="Successvalue">
      <bpmn2:text>Customer
-杈撳叆浠峰��(ts:[]expr:[]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[])
Engineer7
-杈撳叆浠峰��(ts:[]expr:[]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[鏀粯: 0, 鏀粯: 92.76, 鏀粯: 803.83])
Engineer6
-杈撳叆浠峰��(ts:[]expr:[]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[鏀粯: 0, 鏀粯: 555.21, 鏀粯: 522.7])
Engineer5
-杈撳叆浠峰��(ts:[]expr:[]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[鏀粯: 0, 鏀粯: 793.49])
Engineer4
-杈撳叆浠峰��(ts:[]expr:[]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[鏀粯: 0])
Engineer3
-杈撳叆浠峰��(ts:[]expr:[]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[鏀粯: 0, 鏀粯: 312.36])
Engineer2
-杈撳叆浠峰��(ts:[]expr:[]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[鏀粯: 0, 鏀粯: 89.12])
Engineer1
-杈撳叆浠峰��(ts:[]expr:[]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[鏀粯: 0, 鏀粯: 54.19])
</bpmn2:text>
    </bpmn2:textAnnotation>
    <bpmn2:association id="Success2value" sourceRef="Success" targetRef="Successvalue" associationDirection="None"/>
    <bpmn2:textAnnotation id="RestartRepairvalue">
      <bpmn2:text>Engineer7
-杈撳叆浠峰��(ts:[]expr:[閲嶆柊缁翠慨鐨勬鏁�:1, 閲嶆柊缁翠慨鐨勬鏁�:2]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[])
Engineer6
-杈撳叆浠峰��(ts:[]expr:[閲嶆柊缁翠慨鐨勬鏁�:1, 閲嶆柊缁翠慨鐨勬鏁�:2]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[])
Engineer5
-杈撳叆浠峰��(ts:[]expr:[閲嶆柊缁翠慨鐨勬鏁�:1]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[])
Engineer4
-杈撳叆浠峰��(ts:[]expr:[閲嶆柊缁翠慨鐨勬鏁�:1]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[])
Engineer3
-杈撳叆浠峰��(ts:[]expr:[閲嶆柊缁翠慨鐨勬鏁�:1, 閲嶆柊缁翠慨鐨勬鏁�:2]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[])
Engineer2
-杈撳叆浠峰��(ts:[]expr:[閲嶆柊缁翠慨鐨勬鏁�:1, 閲嶆柊缁翠慨鐨勬鏁�:2]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[])
Engineer1
-杈撳叆浠峰��(ts:[]expr:[閲嶆柊缁翠慨鐨勬鏁�:1]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[])
</bpmn2:text>
    </bpmn2:textAnnotation>
    <bpmn2:association id="RestartRepair2value" sourceRef="RestartRepair" targetRef="RestartRepairvalue" associationDirection="None"/>
    <bpmn2:textAnnotation id="IntelligentResponsevalue">
      <bpmn2:text>Customer
-杈撳叆浠峰��(ts:[AvgTime: 13 m 11 s 975 ms ]expr:[]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[])
ChatRobot
-杈撳叆浠峰��(ts:[AvgTime: 13 m 11 s 975 ms ]expr:[]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[])
</bpmn2:text>
    </bpmn2:textAnnotation>
    <bpmn2:association id="IntelligentResponse2value" sourceRef="IntelligentResponse" targetRef="IntelligentResponsevalue" associationDirection="None"/>
    <bpmn2:textAnnotation id="TestRepairvalue">
      <bpmn2:text>Engineer7
-杈撳叆浠峰��(ts:[AvgTime: 13 m 59 s 634 ms ]expr:[缁翠慨娆℃暟:3, 缁翠慨娆℃暟:2, 缁翠慨娆℃暟:1]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[unfixed, fixed]profit:[])
Engineer6
-杈撳叆浠峰��(ts:[AvgTime: 14 m 17 s 892 ms ]expr:[缁翠慨娆℃暟:3, 缁翠慨娆℃暟:2, 缁翠慨娆℃暟:1]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[unfixed, fixed]profit:[])
Engineer5
-杈撳叆浠峰��(ts:[AvgTime: 12 m 5 s 257 ms ]expr:[缁翠慨娆℃暟:2, 缁翠慨娆℃暟:1]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[unfixed, fixed]profit:[])
Engineer4
-杈撳叆浠峰��(ts:[AvgTime: 13 m 31 s 483 ms ]expr:[缁翠慨娆℃暟:2, 缁翠慨娆℃暟:1]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[unfixed, fixed]profit:[])
Engineer3
-杈撳叆浠峰��(ts:[AvgTime: 12 m 45 s 840 ms ]expr:[缁翠慨娆℃暟:3, 缁翠慨娆℃暟:2, 缁翠慨娆℃暟:1]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[unfixed, fixed]profit:[])
Engineer2
-杈撳叆浠峰��(ts:[AvgTime: 13 m 21 s 43 ms ]expr:[缁翠慨娆℃暟:3, 缁翠慨娆℃暟:2, 缁翠慨娆℃暟:1]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[unfixed, fixed]profit:[])
Engineer1
-杈撳叆浠峰��(ts:[AvgTime: 13 m 27 s 109 ms ]expr:[缁翠慨娆℃暟:2, 缁翠慨娆℃暟:1]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[unfixed, fixed]profit:[])
</bpmn2:text>
    </bpmn2:textAnnotation>
    <bpmn2:association id="TestRepair2value" sourceRef="TestRepair" targetRef="TestRepairvalue" associationDirection="None"/>
    <bpmn2:textAnnotation id="Repairvalue">
      <bpmn2:text>Engineer7
-杈撳叆浠峰��(ts:[AvgTime: 33 m 51 s 715 ms ]expr:[P005, P004, P007, P006, P001, P003, P002, P010, P009, P008]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[inStock]profit:[])
Engineer6
-杈撳叆浠峰��(ts:[AvgTime: 31 m 30 s 345 ms ]expr:[P005, P004, P007, P006, P001, P003, P002, P010, P009, P008]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[inStock]profit:[])
Engineer5
-杈撳叆浠峰��(ts:[AvgTime: 32 m 58 s 338 ms ]expr:[P005, P004, P007, P006, P001, P003, P002, P010, P009, P008]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[inStock]profit:[])
Engineer4
-杈撳叆浠峰��(ts:[AvgTime: 32 m 3 s 40 ms ]expr:[P005, P004, P007, P006, P001, P003, P002, P010, P009, P008]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[inStock]profit:[])
Engineer3
-杈撳叆浠峰��(ts:[AvgTime: 32 m 20 s 411 ms ]expr:[P005, P004, P007, P006, P001, P003, P002, P010, P009, P008]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[inStock]profit:[])
Engineer2
-杈撳叆浠峰��(ts:[AvgTime: 34 m 54 s 153 ms ]expr:[P005, P004, P007, P006, P001, P003, P002, P010, P009, P008]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[inStock]profit:[])
Engineer1
-杈撳叆浠峰��(ts:[AvgTime: 35 m 31 s 800 ms ]expr:[P005, P004, P007, P006, P001, P003, P002, P010, P009, P008]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[inStock]profit:[])
</bpmn2:text>
    </bpmn2:textAnnotation>
    <bpmn2:association id="Repair2value" sourceRef="Repair" targetRef="Repairvalue" associationDirection="None"/>
    <bpmn2:textAnnotation id="UserIdentificationvalue">
      <bpmn2:text>User System
-杈撳叆浠峰��(ts:[]expr:[ES1, ES0, ES3, ES2, ES5, ES4, ES7, ES6, ES9, ES8]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[in, out])
</bpmn2:text>
    </bpmn2:textAnnotation>
    <bpmn2:association id="UserIdentification2value" sourceRef="UserIdentification" targetRef="UserIdentificationvalue" associationDirection="None"/>
    <bpmn2:textAnnotation id="ApplyRepairvalue">
      <bpmn2:text>Service Market Application
-杈撳叆浠峰��(ts:[]expr:[PT002, PT003, PT001, PT004, PT005]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[E005, E006, E007, E008, E009, E010, E001, E002, E003, E004]profit:[])
Customer
-杈撳叆浠峰��(ts:[]expr:[]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[])
Service APP Application
-杈撳叆浠峰��(ts:[]expr:[PT002, PT003, PT001, PT004, PT005]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[E005, E006, E007, E008, E009, E010, E001, E002, E003, E004]profit:[])
Electronic Warranty Card Application
-杈撳叆浠峰��(ts:[]expr:[PT002, PT003, PT001, PT004, PT005]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[E005, E006, E007, E008, E009, E010, E001, E002, E003, E004]profit:[])
Intelligent Network Device Application
-杈撳叆浠峰��(ts:[]expr:[PT002, PT003, PT001, PT004, PT005]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[E005, E006, E007, E008, E009, E010, E001, E002, E003, E004]profit:[])
</bpmn2:text>
    </bpmn2:textAnnotation>
    <bpmn2:association id="ApplyRepair2value" sourceRef="ApplyRepair" targetRef="ApplyRepairvalue" associationDirection="None"/>
    <bpmn2:textAnnotation id="Renewvalue">
      <bpmn2:text>Customer
-杈撳叆浠峰��(ts:[]expr:[]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[])
Engineer7
-杈撳叆浠峰��(ts:[]expr:[PT003]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[0])
Engineer6
-杈撳叆浠峰��(ts:[]expr:[PT005]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[0])
Engineer3
-杈撳叆浠峰��(ts:[]expr:[PT002, PT004, PT005]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[0])
Engineer2
-杈撳叆浠峰��(ts:[]expr:[PT004]profit:[])
-杈撳嚭浠峰��(ts:[]expr:[]profit:[0])
</bpmn2:text>
    </bpmn2:textAnnotation>
    <bpmn2:association id="Renew2value" sourceRef="Renew" targetRef="Renewvalue" associationDirection="None"/>
  </bpmn2:process>
  <bpmndi:BPMNDiagram id="BPMNDiagram_my-process">
    <bpmndi:BPMNPlane bpmnElement="my-process" id="BPMNPlane_my-process">
      <bpmndi:BPMNShape bpmnElement="ManualInteraction" id="BPMNShape_ManualInteraction">
        <omgdc:Bounds height="60.0" width="100.0" x="620.0" y="180.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="Archive" id="BPMNShape_Archive">
        <omgdc:Bounds height="60.0" width="100.0" x="2000.0" y="104.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="ReleaseOrder" id="BPMNShape_ReleaseOrder">
        <omgdc:Bounds height="60.0" width="100.0" x="860.0" y="180.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="Start" id="BPMNShape_Start">
        <omgdc:Bounds height="30.0" width="30.0" x="0.0" y="139.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="OrderAssignment" id="BPMNShape_OrderAssignment">
        <omgdc:Bounds height="60.0" width="100.0" x="1010.0" y="185.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="ServiceEvaluation" id="BPMNShape_ServiceEvaluation">
        <omgdc:Bounds height="60.0" width="100.0" x="1850.0" y="102.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="Success" id="BPMNShape_Success">
        <omgdc:Bounds height="60.0" width="100.0" x="1700.0" y="100.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="GatewayXorS2" id="BPMNShape_GatewayXorS2">
        <omgdc:Bounds height="40.0" width="40.0" x="770.0" y="125.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="GatewayXorS3" id="BPMNShape_GatewayXorS3">
        <omgdc:Bounds height="40.0" width="40.0" x="1460.0" y="140.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="RestartRepair" id="BPMNShape_RestartRepair">
        <omgdc:Bounds height="60.0" width="100.0" x="1550.0" y="250.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="GatewayXorS1" id="BPMNShape_GatewayXorS1">
        <omgdc:Bounds height="40.0" width="40.0" x="380.0" y="128.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="IntelligentResponse" id="BPMNShape_IntelligentResponse">
        <omgdc:Bounds height="60.0" width="100.0" x="470.0" y="180.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="End" id="BPMNShape_End">
        <omgdc:Bounds height="30.0" width="30.0" x="2150.0" y="119.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="GatewayXorS4" id="BPMNShape_GatewayXorS4">
        <omgdc:Bounds height="40.0" width="40.0" x="1580.0" y="110.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="Repair" id="BPMNShape_Repair">
        <omgdc:Bounds height="60.0" width="100.0" x="1160.0" y="190.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="TestRepair" id="BPMNShape_TestRepair">
        <omgdc:Bounds height="60.0" width="100.0" x="1310.0" y="130.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="UserIdentification" id="BPMNShape_UserIdentification">
        <omgdc:Bounds height="60.0" width="100.0" x="230.0" y="122.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="ApplyRepair" id="BPMNShape_ApplyRepair">
        <omgdc:Bounds height="60.0" width="100.0" x="80.0" y="124.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="Renew" id="BPMNShape_Renew">
        <omgdc:Bounds height="60.0" width="100.0" x="1700.0" y="260.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="ManualInteractionvalue" id="BPMNShape_ManualInteractionvalue">
        <omgdc:Bounds height="800.0" width="150.0" x="670.0" y="340.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="Archivevalue" id="BPMNShape_Archivevalue">
        <omgdc:Bounds height="800.0" width="150.0" x="2050.0" y="264.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="ReleaseOrdervalue" id="BPMNShape_ReleaseOrdervalue">
        <omgdc:Bounds height="800.0" width="150.0" x="910.0" y="340.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="OrderAssignmentvalue" id="BPMNShape_OrderAssignmentvalue">
        <omgdc:Bounds height="800.0" width="150.0" x="1060.0" y="345.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="ServiceEvaluationvalue" id="BPMNShape_ServiceEvaluationvalue">
        <omgdc:Bounds height="800.0" width="150.0" x="1900.0" y="262.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="Successvalue" id="BPMNShape_Successvalue">
        <omgdc:Bounds height="800.0" width="150.0" x="1750.0" y="260.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="RestartRepairvalue" id="BPMNShape_RestartRepairvalue">
        <omgdc:Bounds height="800.0" width="150.0" x="1600.0" y="410.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="IntelligentResponsevalue" id="BPMNShape_IntelligentResponsevalue">
        <omgdc:Bounds height="800.0" width="150.0" x="520.0" y="340.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="TestRepairvalue" id="BPMNShape_TestRepairvalue">
        <omgdc:Bounds height="800.0" width="150.0" x="1360.0" y="290.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="Repairvalue" id="BPMNShape_Repairvalue">
        <omgdc:Bounds height="800.0" width="150.0" x="1210.0" y="350.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="UserIdentificationvalue" id="BPMNShape_UserIdentificationvalue">
        <omgdc:Bounds height="800.0" width="150.0" x="280.0" y="282.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="ApplyRepairvalue" id="BPMNShape_ApplyRepairvalue">
        <omgdc:Bounds height="800.0" width="150.0" x="130.0" y="284.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNShape bpmnElement="Renewvalue" id="BPMNShape_Renewvalue">
        <omgdc:Bounds height="800.0" width="150.0" x="1750.0" y="420.0"/>
      </bpmndi:BPMNShape>
      <bpmndi:BPMNEdge bpmnElement="OrderAssignmentRepair" id="BPMNEdge_OrderAssignmentRepair">
        <omgdi:waypoint x="1110.0" y="215.0"/>
        <omgdi:waypoint x="1122.0" y="215.0"/>
        <omgdi:waypoint x="1122.0" y="220.0"/>
        <omgdi:waypoint x="1160.0" y="220.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="SuccessServiceEvaluation" id="BPMNEdge_SuccessServiceEvaluation">
        <omgdi:waypoint x="1800.0" y="130.0"/>
        <omgdi:waypoint x="1812.0" y="130.0"/>
        <omgdi:waypoint x="1812.0" y="132.0"/>
        <omgdi:waypoint x="1850.0" y="132.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="StartApplyRepair" id="BPMNEdge_StartApplyRepair">
        <omgdi:waypoint x="30.0" y="154.0"/>
        <omgdi:waypoint x="80.0" y="154.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="ManualInteractionGatewayXorS2" id="BPMNEdge_ManualInteractionGatewayXorS2">
        <omgdi:waypoint x="720.0" y="210.0"/>
        <omgdi:waypoint x="732.0" y="210.0"/>
        <omgdi:waypoint x="732.0" y="145.0"/>
        <omgdi:waypoint x="770.0" y="145.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="GatewayXorS4Success" id="BPMNEdge_GatewayXorS4Success">
        <omgdi:waypoint x="1620.0" y="122.5"/>
        <omgdi:waypoint x="1662.0" y="122.5"/>
        <omgdi:waypoint x="1662.0" y="130.0"/>
        <omgdi:waypoint x="1700.0" y="130.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="GatewayXorS3GatewayXorS4" id="BPMNEdge_GatewayXorS3GatewayXorS4">
        <omgdi:waypoint x="1500.0" y="152.5"/>
        <omgdi:waypoint x="1512.0" y="152.5"/>
        <omgdi:waypoint x="1512.0" y="130.0"/>
        <omgdi:waypoint x="1580.0" y="130.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="GatewayXorS1GatewayXorS2" id="BPMNEdge_GatewayXorS1GatewayXorS2">
        <omgdi:waypoint x="420.0" y="140.5"/>
        <omgdi:waypoint x="432.0" y="140.5"/>
        <omgdi:waypoint x="432.0" y="145.0"/>
        <omgdi:waypoint x="770.0" y="145.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="GatewayXorS1IntelligentResponse" id="BPMNEdge_GatewayXorS1IntelligentResponse">
        <omgdi:waypoint x="420.0" y="155.5"/>
        <omgdi:waypoint x="432.0" y="155.5"/>
        <omgdi:waypoint x="432.0" y="210.0"/>
        <omgdi:waypoint x="470.0" y="210.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="IntelligentResponseManualInteraction" id="BPMNEdge_IntelligentResponseManualInteraction">
        <omgdi:waypoint x="570.0" y="210.0"/>
        <omgdi:waypoint x="620.0" y="210.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="GatewayXorS3RestartRepair" id="BPMNEdge_GatewayXorS3RestartRepair">
        <omgdi:waypoint x="1500.0" y="167.5"/>
        <omgdi:waypoint x="1512.0" y="167.5"/>
        <omgdi:waypoint x="1512.0" y="280.0"/>
        <omgdi:waypoint x="1550.0" y="280.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="ArchiveEnd" id="BPMNEdge_ArchiveEnd">
        <omgdi:waypoint x="2100.0" y="134.0"/>
        <omgdi:waypoint x="2150.0" y="134.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="ApplyRepairUserIdentification" id="BPMNEdge_ApplyRepairUserIdentification">
        <omgdi:waypoint x="180.0" y="154.0"/>
        <omgdi:waypoint x="192.0" y="154.0"/>
        <omgdi:waypoint x="192.0" y="152.0"/>
        <omgdi:waypoint x="230.0" y="152.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="GatewayXorS4Renew" id="BPMNEdge_GatewayXorS4Renew">
        <omgdi:waypoint x="1620.0" y="137.5"/>
        <omgdi:waypoint x="1662.0" y="137.5"/>
        <omgdi:waypoint x="1662.0" y="290.0"/>
        <omgdi:waypoint x="1700.0" y="290.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="UserIdentificationGatewayXorS1" id="BPMNEdge_UserIdentificationGatewayXorS1">
        <omgdi:waypoint x="330.0" y="152.0"/>
        <omgdi:waypoint x="342.0" y="152.0"/>
        <omgdi:waypoint x="342.0" y="148.0"/>
        <omgdi:waypoint x="380.0" y="148.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="ReleaseOrderOrderAssignment" id="BPMNEdge_ReleaseOrderOrderAssignment">
        <omgdi:waypoint x="960.0" y="210.0"/>
        <omgdi:waypoint x="972.0" y="210.0"/>
        <omgdi:waypoint x="972.0" y="215.0"/>
        <omgdi:waypoint x="1010.0" y="215.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="GatewayXorS2ServiceEvaluation" id="BPMNEdge_GatewayXorS2ServiceEvaluation">
        <omgdi:waypoint x="810.0" y="137.5"/>
        <omgdi:waypoint x="822.0" y="137.5"/>
        <omgdi:waypoint x="822.0" y="132.0"/>
        <omgdi:waypoint x="1850.0" y="132.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="GatewayXorS2ReleaseOrder" id="BPMNEdge_GatewayXorS2ReleaseOrder">
        <omgdi:waypoint x="810.0" y="152.5"/>
        <omgdi:waypoint x="822.0" y="152.5"/>
        <omgdi:waypoint x="822.0" y="210.0"/>
        <omgdi:waypoint x="860.0" y="210.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="RestartRepairRepair" id="BPMNEdge_RestartRepairRepair">
        <omgdi:waypoint x="1550.0" y="292.5"/>
        <omgdi:waypoint x="1538.0" y="292.5"/>
        <omgdi:waypoint x="1538.0" y="220.0"/>
        <omgdi:waypoint x="1160.0" y="220.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="RepairTestRepair" id="BPMNEdge_RepairTestRepair">
        <omgdi:waypoint x="1260.0" y="207.5"/>
        <omgdi:waypoint x="1272.0" y="207.5"/>
        <omgdi:waypoint x="1272.0" y="160.0"/>
        <omgdi:waypoint x="1310.0" y="160.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="TestRepairGatewayXorS3" id="BPMNEdge_TestRepairGatewayXorS3">
        <omgdi:waypoint x="1410.0" y="160.0"/>
        <omgdi:waypoint x="1460.0" y="160.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="RenewServiceEvaluation" id="BPMNEdge_RenewServiceEvaluation">
        <omgdi:waypoint x="1800.0" y="290.0"/>
        <omgdi:waypoint x="1812.0" y="290.0"/>
        <omgdi:waypoint x="1812.0" y="132.0"/>
        <omgdi:waypoint x="1850.0" y="132.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="ServiceEvaluationArchive" id="BPMNEdge_ServiceEvaluationArchive">
        <omgdi:waypoint x="1950.0" y="132.0"/>
        <omgdi:waypoint x="1962.0" y="132.0"/>
        <omgdi:waypoint x="1962.0" y="134.0"/>
        <omgdi:waypoint x="2000.0" y="134.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="ManualInteraction2value" id="BPMNEdge_ManualInteraction2value">
        <omgdi:waypoint x="670.0" y="240.0"/>
        <omgdi:waypoint x="670.0" y="340.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="Archive2value" id="BPMNEdge_Archive2value">
        <omgdi:waypoint x="2050.0" y="164.0"/>
        <omgdi:waypoint x="2050.0" y="264.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="ReleaseOrder2value" id="BPMNEdge_ReleaseOrder2value">
        <omgdi:waypoint x="910.0" y="240.0"/>
        <omgdi:waypoint x="910.0" y="340.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="OrderAssignment2value" id="BPMNEdge_OrderAssignment2value">
        <omgdi:waypoint x="1060.0" y="245.0"/>
        <omgdi:waypoint x="1060.0" y="345.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="ServiceEvaluation2value" id="BPMNEdge_ServiceEvaluation2value">
        <omgdi:waypoint x="1900.0" y="162.0"/>
        <omgdi:waypoint x="1900.0" y="262.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="Success2value" id="BPMNEdge_Success2value">
        <omgdi:waypoint x="1750.0" y="160.0"/>
        <omgdi:waypoint x="1750.0" y="260.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="RestartRepair2value" id="BPMNEdge_RestartRepair2value">
        <omgdi:waypoint x="1600.0" y="310.0"/>
        <omgdi:waypoint x="1600.0" y="410.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="IntelligentResponse2value" id="BPMNEdge_IntelligentResponse2value">
        <omgdi:waypoint x="520.0" y="240.0"/>
        <omgdi:waypoint x="520.0" y="340.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="TestRepair2value" id="BPMNEdge_TestRepair2value">
        <omgdi:waypoint x="1360.0" y="190.0"/>
        <omgdi:waypoint x="1360.0" y="290.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="Repair2value" id="BPMNEdge_Repair2value">
        <omgdi:waypoint x="1210.0" y="250.0"/>
        <omgdi:waypoint x="1210.0" y="350.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="UserIdentification2value" id="BPMNEdge_UserIdentification2value">
        <omgdi:waypoint x="280.0" y="182.0"/>
        <omgdi:waypoint x="280.0" y="282.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="ApplyRepair2value" id="BPMNEdge_ApplyRepair2value">
        <omgdi:waypoint x="130.0" y="184.0"/>
        <omgdi:waypoint x="130.0" y="284.0"/>
      </bpmndi:BPMNEdge>
      <bpmndi:BPMNEdge bpmnElement="Renew2value" id="BPMNEdge_Renew2value">
        <omgdi:waypoint x="1750.0" y="320.0"/>
        <omgdi:waypoint x="1750.0" y="420.0"/>
      </bpmndi:BPMNEdge>
    </bpmndi:BPMNPlane>
  </bpmndi:BPMNDiagram>
</bpmn2:definitions>`