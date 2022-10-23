import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class BPMNShape {
    @JacksonXmlProperty(isAttribute = true)
    private String id;
    @JacksonXmlProperty(isAttribute = true)
    private String bpmnElement;
    @JacksonXmlProperty(localName = "omgdc:Bounds")
    private Bounds bounds;

    public BPMNShape(String bpmnElement, String id, Bounds bounds) {
        this.bpmnElement = bpmnElement;
        this.id = id;
        this.bounds = bounds;
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

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }
}
