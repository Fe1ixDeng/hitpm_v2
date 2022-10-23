import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class waypoint {
    @JacksonXmlProperty(isAttribute = true)
    private double x;
    @JacksonXmlProperty(isAttribute = true)
    private double y;

    public waypoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
