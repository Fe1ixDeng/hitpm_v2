import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

public class Process {
    @JacksonXmlProperty(isAttribute = true)
    private String id;
    @JacksonXmlProperty(isAttribute = true)
    private String name;
//    @JacksonXmlProperty(isAttribute = true)
//    private Boolean isExecutable = true;

    private StartEvent startEvent;
    private EndEvent endEvent;
    private ExclusiveGateway exclusiveGateway;

    @JacksonXmlElementWrapper(useWrapping = false)
    private List<UserTask> userTask = new ArrayList<>();
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<SequenceFlow> sequenceFlow = new ArrayList<>();

    public Process(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SequenceFlow> getSequenceFlow() {
        return sequenceFlow;
    }

    public void setSequenceFlow(List<SequenceFlow> sequenceFlow) {
        this.sequenceFlow = sequenceFlow;
    }

//    public Boolean getExecutable() {
//        return isExecutable;
//    }
//
//    public void setExecutable(Boolean executable) {
//        isExecutable = executable;
//    }

    public StartEvent getStartEvent() {
        return startEvent;
    }

    public void setStartEvent(StartEvent startEvent) {
        this.startEvent = startEvent;
    }

    public EndEvent getEndEvent() {
        return endEvent;
    }

    public void setEndEvent(EndEvent endEvent) {
        this.endEvent = endEvent;
    }

    public ExclusiveGateway getExclusiveGateway() {
        return exclusiveGateway;
    }

    public void setExclusiveGateway(ExclusiveGateway exclusiveGateway) {
        this.exclusiveGateway = exclusiveGateway;
    }

    public List<UserTask> getUserTask() {
        return userTask;
    }

    public void setUserTask(List<UserTask> userTask) {
        this.userTask = userTask;
    }
}
