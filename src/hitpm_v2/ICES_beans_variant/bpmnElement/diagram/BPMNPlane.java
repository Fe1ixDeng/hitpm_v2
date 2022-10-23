import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

public class BPMNPlane {
    @JacksonXmlProperty(isAttribute = true)
    private String id = "BPMNPlane_bplane";
    @JacksonXmlProperty(isAttribute = true)
    private String bpmnElement = "bplane";

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "bpmndi:BPMNEdge")
    private List<BPMNEdge> bpmnEdge = new ArrayList<>();
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "bpmndi:BPMNShape")
    private List<BPMNShape> bpmnShape = new ArrayList<>();

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
