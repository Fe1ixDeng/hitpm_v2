package hitpm_v2.ICES_beans_variant.bpmnElement.diagram;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class BPMNDiagram {
    @JacksonXmlProperty(isAttribute = true)
    private String id;
    @JacksonXmlProperty(localName = "bpmndi:BPMNPlane")
    BPMNPlane bpmnPlane = new BPMNPlane();

    public BPMNDiagram(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BPMNPlane getBpmnPlane() {
        return bpmnPlane;
    }

    public void setBpmnPlane(BPMNPlane bpmnPlane) {
        this.bpmnPlane = bpmnPlane;
    }
}
