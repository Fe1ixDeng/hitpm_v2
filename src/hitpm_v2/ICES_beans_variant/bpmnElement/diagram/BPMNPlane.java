import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

public class BPMNPlane {
    @JacksonXmlProperty(isAttribute = true)
    private String bpmnElement;
    @JacksonXmlProperty(isAttribute = true)
    private String id;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "bpmndi:bpmnShape")
    private List<BPMNShape> bpmnShape = new ArrayList<>();
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "bpmndi:bpmnEdge")
    private List<BPMNEdge> bpmnEdge = new ArrayList<>();

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

    public List<BPMNShape> getBpmnShape() {
        return bpmnShape;
    }

    public void setBpmnShape(List<BPMNShape> bpmnShape) {
        this.bpmnShape = bpmnShape;
    }

    public List<BPMNEdge> getBpmnEdge() {
        return bpmnEdge;
    }

    public void setBpmnEdge(List<BPMNEdge> bpmnEdge) {
        this.bpmnEdge = bpmnEdge;
    }
}
