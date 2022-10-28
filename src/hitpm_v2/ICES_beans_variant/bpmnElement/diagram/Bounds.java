package hitpm_v2.ICES_beans_variant.bpmnElement.diagram;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Bounds {
    @JacksonXmlProperty(isAttribute = true)
    private double height;
    @JacksonXmlProperty(isAttribute = true)
    private double width;
    @JacksonXmlProperty(isAttribute = true)
    private double x;
    @JacksonXmlProperty(isAttribute = true)
    private double y;

    public Bounds(double height, double width, double x, double y) {
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public double getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
