package backEndCourse.summarySessions.summary01.TeaStore.entity;


import java.util.Objects;

public class Tea {
    private int id;
    private Manufacturer manufacturer;
    private TypeOfTea type;
    private String variety;

    public Tea(int id, Manufacturer manufacturer, TypeOfTea type, String variety) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.type = type;
        this.variety = variety;
    }

    public int getId() {
        return id;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public TypeOfTea getType() {
        return type;
    }

    public String getVariety() {
        return variety;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setType(TypeOfTea type) {
        this.type = type;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tea tea)) return false;
        return Objects.equals(manufacturer, tea.manufacturer) && Objects.equals(type, tea.type) && Objects.equals(variety, tea.variety);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, type, variety);
    }
}
