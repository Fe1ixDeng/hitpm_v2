import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(namespace = "http://www.omg.org/spec/BPMN/20100524/MODEL")
public class Definitions {
    private Process process;
    @JacksonXmlProperty(localName = "bpmndi:BPMNDiagram")
    private BPMNDiagram bpmnDiagram;

    @JacksonXmlProperty(isAttribute = true)
    private String xmlns = "http://www.omg.org/spec/BPMN/20100524/MODEL";
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:xsi")
    private String xsi = "http://www.w3.org/2001/XMLSchema-instance";
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:xsd")
    private String xsd="http://www.w3.org/2001/XMLSchema";
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:activiti")
    private String activiti="http://activiti.org/bpmn";
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:bpmndi")
    private String bpmndi="http://www.omg.org/spec/BPMN/20100524/DI";
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:omgdc")
    private String omgdc="http://www.omg.org/spec/DD/20100524/DC";
    @JacksonXmlProperty(isAttribute = true, localName = "xmlns:omgdi")
    private String omgdi="http://www.omg.org/spec/DD/20100524/DI";
    @JacksonXmlProperty(isAttribute = true)
    private String typeLanguage="http://www.w3.org/2001/XMLSchema";
    @JacksonXmlProperty(isAttribute = true)
    private String expressionLanguage="http://www.w3.org/1999/XPath";
    @JacksonXmlProperty(isAttribute = true)
    private String targetNamespace="http://www.activiti.org/processdef";
    @JacksonXmlProperty(isAttribute = true)
    private String exporter="Camunda Modeler";
    @JacksonXmlProperty(isAttribute = true)
    private String exporterVersion="5.0.0";

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public BPMNDiagram getBpmnDiagram() {
        return bpmnDiagram;
    }

    public void setBpmnDiagram(BPMNDiagram bpmnDiagram) {
        this.bpmnDiagram = bpmnDiagram;
    }
}
