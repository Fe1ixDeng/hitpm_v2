package hitpm_v2.ICES_beans_variant.bpmnElement.process;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ExclusiveGateway extends Element{
    @JacksonXmlProperty(isAttribute = true)
    String id;
    @JacksonXmlProperty(isAttribute = true)
    String name;

    public ExclusiveGateway(String id) {
        this.id = id;
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
}
