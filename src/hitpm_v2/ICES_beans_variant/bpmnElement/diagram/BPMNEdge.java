package hitpm_v2.ICES_beans_variant.bpmnElement.diagram;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

public class BPMNEdge {
    @JacksonXmlProperty(isAttribute = true)
    private String id;
    @JacksonXmlProperty(isAttribute = true)
    private String bpmnElement;
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "omgdi:waypoint")
    private List<waypoint> waypointList = new ArrayList<>();

    public BPMNEdge(String bpmnElement, String id) {
        this.bpmnElement = bpmnElement;
        this.id = id;
    }

    public String getBpmnElement() {
        return bpmnElement;
    }

    public void setBpmnElement(String bpmnElement) {
        this.bpmnElement = bpmnElement;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<waypoint> getWaypointList() {
        return waypointList;
    }

    public void setWaypointList(List<waypoint> waypointList) {
        this.waypointList = waypointList;
    }
}
