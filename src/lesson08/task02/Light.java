package lesson08.task02;

public class Light {
    private String location;
    private int brightness;
    private boolean isOn;

    public Light(String location, int brightness, boolean isOn) {
        this.location = location;
        this.brightness = brightness;
        this.isOn = isOn;
    }

    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    public boolean isOn() {
        return isOn;
    }
    public void setOn(boolean on) {
        isOn = on;
    }

    @Override
    public String toString() {
        return "Light{" +
                "location='" + location + '\'' +
                ", brightness=" + brightness +
                ", isOn=" + isOn +
                '}';
    }
}
