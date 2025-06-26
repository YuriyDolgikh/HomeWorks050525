package backEndCourse.summarySessions.summary01.TeaStore.entity;

import java.util.Objects;

public class TypeOfTea {

    private final int id;
    private String typeName;
    private String comment;

    public TypeOfTea(int id, String typeName, String comment) {
        this.id = id;
        this.typeName = typeName;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TypeOfTea typeOfTea)) return false;
        return Objects.equals(typeName, typeOfTea.typeName) && Objects.equals(comment, typeOfTea.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeName, comment);
    }

    @Override
    public String toString() {
        return "TypeOfTea{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
