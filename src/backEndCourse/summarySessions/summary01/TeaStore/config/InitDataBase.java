package backEndCourse.summarySessions.summary01.TeaStore.config;

import backEndCourse.summarySessions.summary01.TeaStore.entity.Manufacturer;
import backEndCourse.summarySessions.summary01.TeaStore.entity.Tea;
import backEndCourse.summarySessions.summary01.TeaStore.entity.TypeOfTea;

public class InitDataBase {

    public static Manufacturer[] getSimpleManufacturers() {
        Manufacturer[] simpleManufacturers =  new Manufacturer[5];
        simpleManufacturers[0] = new Manufacturer(12, "Lipton", "Comment 1");
        simpleManufacturers[1] = new Manufacturer(13, "Tess", "Comment 2");
        simpleManufacturers[2] = new Manufacturer(14, "Ahmad", "Comment 3");
        simpleManufacturers[3] = new Manufacturer(15, "Greenfield", "Comment 4");
        simpleManufacturers[4] = new Manufacturer(16, "Dilmah", "Comment 5");
        return simpleManufacturers;
    }

    public static TypeOfTea[] getsimpleTypeOfTea() {
        TypeOfTea[] simpleTypeOfTea =new TypeOfTea[4];
        simpleTypeOfTea[0] = new TypeOfTea(101, "Black", "Comment 133");
        simpleTypeOfTea[1] = new TypeOfTea(102, "Green", "Comment 152");
        simpleTypeOfTea[2] = new TypeOfTea(103, "Herbal ", "Comment 153");
        simpleTypeOfTea[3] = new TypeOfTea(104, "Fruit", "Comment 154");
        return  simpleTypeOfTea;
    }

    public static Tea[] getsimpleTea() {
        Tea[] simpleTea = new Tea[14];
        simpleTea[0] = new Tea(1, getSimpleManufacturers()[0], getsimpleTypeOfTea()[0], "English Breakfast");
        simpleTea[1] = new Tea(2, getSimpleManufacturers()[0], getsimpleTypeOfTea()[1], "Sencha");
        simpleTea[2] = new Tea(3, getSimpleManufacturers()[0], getsimpleTypeOfTea()[2], "Chamomile");
        simpleTea[3] = new Tea(4, getSimpleManufacturers()[1], getsimpleTypeOfTea()[0], "Earl Grey");
        simpleTea[4] = new Tea(5, getSimpleManufacturers()[1], getsimpleTypeOfTea()[3], "Apple");
        simpleTea[5] = new Tea(6, getSimpleManufacturers()[2], getsimpleTypeOfTea()[2], "Hibiscus");
        simpleTea[6] = new Tea(7, getSimpleManufacturers()[3], getsimpleTypeOfTea()[0], "Irish Breakfast");
        simpleTea[7] = new Tea(8, getSimpleManufacturers()[3], getsimpleTypeOfTea()[1], "Gyokuro");
        simpleTea[8] = new Tea(9, getSimpleManufacturers()[3], getsimpleTypeOfTea()[3], "Mixed fruit");
        simpleTea[9] = new Tea(10, getSimpleManufacturers()[4], getsimpleTypeOfTea()[0], "Darjeeling");
        simpleTea[10] = new Tea(11, getSimpleManufacturers()[4], getsimpleTypeOfTea()[0], "Earl Grey");
        simpleTea[11] = new Tea(12, getSimpleManufacturers()[4], getsimpleTypeOfTea()[1], "Dragon Well");
        simpleTea[12] = new Tea(13, getSimpleManufacturers()[4], getsimpleTypeOfTea()[3], "Mixed fruit");
        simpleTea[13] = new Tea(14, getSimpleManufacturers()[4], getsimpleTypeOfTea()[3], "Apple");
        return simpleTea;
    }
}
