package hitpm_v2.ICES_beans_variant.bpmnElement.process;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class EndEvent extends Element{
    @JacksonXmlProperty(isAttribute = true)
    private String id;
    @JacksonXmlProperty(isAttribute = true)
    private String name;

    public EndEvent(String id, String name) {
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
}
