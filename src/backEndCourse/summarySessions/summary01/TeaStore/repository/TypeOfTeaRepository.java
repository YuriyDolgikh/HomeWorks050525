package backEndCourse.summarySessions.summary01.TeaStore.repository;

import backEndCourse.summarySessions.summary01.TeaStore.entity.TypeOfTea;

import java.util.Arrays;

public class TypeOfTeaRepository {

    private final TypeOfTea[] typeOfTeas;
    private int itemCounter = 0;

    public TypeOfTeaRepository(int maxSize) {
        this.typeOfTeas = new TypeOfTea[maxSize];
    }

    public boolean add(TypeOfTea typeOfTea) {
        if (itemCounter < typeOfTeas.length) {
            typeOfTeas[itemCounter++] = typeOfTea;
            return true;
        }
        return false;
    }

    public TypeOfTea[] findAll() {
        return Arrays.copyOf(typeOfTeas, itemCounter);
    }

    public TypeOfTea findById(int id) {
        for (TypeOfTea typeOfTea : findAll()) {
            if (typeOfTea.getId() == id) {
                return typeOfTea;
            }
        }
        return null;
    }

    public TypeOfTea findByTypeName(String name) {
        for (TypeOfTea typeOfTea : findAll()) {
            if (typeOfTea.getTypeName().equalsIgnoreCase(name)) {
                return typeOfTea;
            }
        }
        return null;
    }

    public TypeOfTea[] findByPartOfComment(String textToFind) {
        int counter = 0;
        for (TypeOfTea typeOfTea : findAll()) {
            if (typeOfTea.getComment().toLowerCase().contains(textToFind.toLowerCase())) {
                counter++;
            }
        }
        TypeOfTea[] typeOfTeas = new TypeOfTea[counter];
        int index = 0;
        for (TypeOfTea typeOfTea : findAll()) {
            if (typeOfTea.getComment().toLowerCase().contains(textToFind.toLowerCase())) {
                typeOfTeas[index++] = typeOfTea;
            }
        }
        return typeOfTeas;
    }

    public boolean updateTypeNameById(int id, String name) {
        TypeOfTea itemToUpdate = findById(id);
        if (itemToUpdate == null || findByTypeName(name) != null) {
            return false;
        }
        itemToUpdate.setTypeName(name);
        return true;
    }

    public boolean updateCommentById(int id, String comment) {
        TypeOfTea itemToUpdate = findById(id);
        if (itemToUpdate == null) {
            return false;
        }
        itemToUpdate.setComment(comment);
        return true;
    }

    public boolean deleteById(int id) {
        int indexToDelete = -1;
        for (int i = 0; i < itemCounter; i++) {
            if (typeOfTeas[i].getId() == id) {
                indexToDelete = i;
                break;
            }
        }
        if (indexToDelete == -1) {
            return false;
        }
        if (itemCounter == 1) {
            typeOfTeas[0] = null;
            itemCounter = 0;
        }

        for (int i = indexToDelete + 1; i < itemCounter; i++) {
            typeOfTeas[i - 1] = typeOfTeas[i];
        }
        typeOfTeas[itemCounter - 1] = null;
        itemCounter--;
        return true;
    }

    public void sortByName() {
        for (int i = 0; i < itemCounter - 1; i++) {
            for (int j = i + 1; j < itemCounter; j++) {
                if (typeOfTeas[i].getTypeName().compareTo(typeOfTeas[j].getTypeName()) > 0) {
                    TypeOfTea temp = typeOfTeas[i];
                    typeOfTeas[i] = typeOfTeas[j];
                    typeOfTeas[j] = temp;
                }
            }
        }
    }
}
