package backEndCourse.summarySessions.summary01.TeaStore.repository;


import backEndCourse.summarySessions.summary01.TeaStore.entity.Manufacturer;

import java.util.Arrays;

public class ManufacturerRepository {

    private final Manufacturer[] manufacturers;
    private int itemCounter = 0;

    public ManufacturerRepository(int maxSize) {
        this.manufacturers = new Manufacturer[maxSize];
    }

    public boolean add(Manufacturer manufacturer) {
        if(itemCounter < manufacturers.length) {
            manufacturers[itemCounter++] = manufacturer;
            return true;
        }
        return false;
    }

    public Manufacturer[] findAll() {
        return Arrays.copyOf(manufacturers, itemCounter);
    }

    public Manufacturer findById(int id) {
        for(Manufacturer manufacturer : findAll()) {
            if(manufacturer.getId() == id) {
                return manufacturer;
            }
        }
        return null;
    }

    public Manufacturer findByName(String name) {
        for(Manufacturer manufacturer : findAll()) {
            if(manufacturer.getName().equalsIgnoreCase(name)) {
                return manufacturer;
            }
        }
        return null;
    }

    public Manufacturer[] findByPartOfComment(String textToFind) {
        int counter = 0;
        for(Manufacturer manufacturer : findAll()) {
            if (manufacturer.getComment().toLowerCase().contains(textToFind.toLowerCase())) {
                counter++;
            }
        }
        Manufacturer[] manufacturers = new Manufacturer[counter];
        int index = 0;
        for(Manufacturer manufacturer : findAll()) {
            if(manufacturer.getComment().toLowerCase().contains(textToFind.toLowerCase())) {
                manufacturers[index++] = manufacturer;
            }
        }
        return manufacturers;
    }

    public void updateNameById(int id, String name) {
        Manufacturer itemToUpdate = findById(id);
        if(itemToUpdate == null || findByName(name) != null) {
            return;
        }
        itemToUpdate.setName(name);
    }

    public void updateCommentById(int id, String comment) {
        Manufacturer itemToUpdate = findById(id);
        if(itemToUpdate == null) {
            return;
        }
        itemToUpdate.setComment(comment);
    }

    public boolean deleteById(int id) {
        int indexToDelete = -1;
        for (int i = 0; i < itemCounter; i++) {
            if (manufacturers[i].getId() == id) {
                indexToDelete = i;
                break;
            }
        }
        if (indexToDelete == -1) {
            return false;
        }
        if (itemCounter == 1){
            manufacturers[0] = null;
            itemCounter = 0;
        }

        for (int i = indexToDelete + 1; i < itemCounter; i++) {
            manufacturers[i-1] = manufacturers[i];
        }
        manufacturers[itemCounter-1] = null;
        itemCounter--;
        return true;
    }

    public void sortByName() {
        for (int i = 0; i < itemCounter - 1; i++) {
            for (int j = i + 1; j < itemCounter; j++) {
                if (manufacturers[i].getName().compareTo(manufacturers[j].getName()) > 0) {
                    Manufacturer temp = manufacturers[i];
                    manufacturers[i] = manufacturers[j];
                    manufacturers[j] = temp;
                }
            }
        }
    }
}
