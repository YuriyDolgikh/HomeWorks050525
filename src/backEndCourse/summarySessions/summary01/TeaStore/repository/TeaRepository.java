package backEndCourse.summarySessions.summary01.TeaStore.repository;

import backEndCourse.summarySessions.summary01.TeaStore.entity.Manufacturer;
import backEndCourse.summarySessions.summary01.TeaStore.entity.Tea;
import backEndCourse.summarySessions.summary01.TeaStore.entity.TypeOfTea;

import java.util.Arrays;

public class TeaRepository {

    private final Tea[] teas;
    private int itemCounter = 0;

    public TeaRepository(int maxSize) {
        this.teas = new Tea[maxSize];
    }

    public boolean add(Tea tea) {
        if(itemCounter < teas.length) {
            teas[itemCounter++] = tea;
            return true;
        }
        return false;
    }

    public Tea[] findAll() {
        return Arrays.copyOf(teas, itemCounter);
    }

    public Tea findById(int id) {
        for(Tea tea : findAll()) {
            if(tea.getId() == id) {
                return tea;
            }
        }
        return null;
    }

    public Tea[] findByManufacturer(Manufacturer manufacturer) {
        int counter = 0;
        for(Tea tea : findAll()) {
            if(tea.getManufacturer().equals(manufacturer)) {
                counter++;
            }
        }
        Tea[] teas = new Tea[counter];
        int index = 0;
        for (Tea tea : findAll()) {
            if(tea.getManufacturer().equals(manufacturer)) {
                teas[index++] = tea;
            }
        }
        return teas;
    }

    public Tea[] findByTypeOfTea(TypeOfTea typeOfTea)  {
        int counter = 0;
        for(Tea tea : findAll()) {
            if(tea.getType().equals(typeOfTea)) {
                counter++;
            }
        }
        Tea[] teas = new Tea[counter];
        int index = 0;
        for (Tea tea : findAll()) {
            if(tea.getType().equals(typeOfTea)) {
                teas[index++] = tea;
            }
        }
        return teas;
    }

    public Tea[] findByVariety(String variety) {
        int counter = 0;
        for(Tea tea : findAll()) {
            if(tea.getVariety().toLowerCase().contains(variety.toLowerCase())) {
                counter++;
            }
        }
        Tea[] teas = new Tea[counter];
        int index = 0;
        for (Tea tea : findAll()) {
            if(tea.getVariety().toLowerCase().contains(variety.toLowerCase())) {
                teas[index++] = tea;
            }
        }
        return teas;
    }

    public Tea[] findByManufacturerAndTypeOfTea(Manufacturer manufacturer, TypeOfTea typeOfTea) {
        int counter = 0;
        for(Tea tea : findAll()) {
            if(tea.getManufacturer().equals(manufacturer) && tea.getType().equals(typeOfTea)) {
                counter++;
            }
        }
        Tea[] teas = new Tea[counter];
        int index = 0;
        for (Tea tea : findAll()) {
            if(tea.getManufacturer().equals(manufacturer) && tea.getType().equals(typeOfTea)) {
                teas[index++] = tea;
            }
        }
        return teas;
    }

    public boolean updateManufacturerById(int id, Manufacturer manufacturer) {
        Tea itemToUpdate = findById(id);
        if(itemToUpdate == null) {
            return false;
        }
        itemToUpdate.setManufacturer(manufacturer);
        return true;
    }

    public boolean updateTypeOfTeaById(int id, TypeOfTea typeOfTea) {
        Tea itemToUpdate = findById(id);
        if(itemToUpdate == null) {
            return false;
        }
        itemToUpdate.setType(typeOfTea);
        return true;
    }

    public boolean updateVarietyById(int id, String variety) {
        Tea itemToUpdate = findById(id);
        if(itemToUpdate == null) {
            return false;
        }
        itemToUpdate.setVariety(variety);
        return true;
    }

    public boolean deleteById(int id) {
        int indexToDelete = -1;
        for (int i = 0; i < itemCounter; i++) {
            if (teas[i].getId() == id) {
                indexToDelete = i;
                break;
            }
        }
        if (indexToDelete == -1) {
            return false;
        }
        if (itemCounter == 1){
            teas[0] = null;
            itemCounter = 0;
        }
        for (int i = indexToDelete + 1; i < itemCounter; i++) {
            teas[i-1] = teas[i];
        }
        teas[itemCounter-1] = null;
        itemCounter--;
        return true;
    }

    public void sortByManufacturersNameAndTypeOfTeaName() {
        for (int i = 0; i < itemCounter - 1; i++) {
            for (int j = i + 1; j < itemCounter; j++) {
                if (teas[i].getManufacturer().getName().compareToIgnoreCase(teas[j].getManufacturer().getName()) > 0) {
                    Tea temp = teas[i];
                    teas[i] = teas[j];
                    teas[j] = temp;
                    continue;
                }
                if (teas[i].getManufacturer().getName().compareToIgnoreCase(teas[j].getManufacturer().getName()) == 0) {
                    if (teas[i].getType().getTypeName().compareToIgnoreCase(teas[j].getType().getTypeName()) > 0) {
                        Tea temp = teas[i];
                        teas[i] = teas[j];
                        teas[j] = temp;
                    }
                }
            }
        }
    }
}
