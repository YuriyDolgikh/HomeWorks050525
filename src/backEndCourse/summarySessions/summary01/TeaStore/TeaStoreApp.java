package backEndCourse.summarySessions.summary01.TeaStore;

import backEndCourse.summarySessions.summary01.TeaStore.controller.ManufacturerController;
import backEndCourse.summarySessions.summary01.TeaStore.controller.TeaController;
import backEndCourse.summarySessions.summary01.TeaStore.controller.TypeOfTeaController;
import backEndCourse.summarySessions.summary01.TeaStore.repository.ManufacturerRepository;
import backEndCourse.summarySessions.summary01.TeaStore.repository.TeaRepository;
import backEndCourse.summarySessions.summary01.TeaStore.repository.TypeOfTeaRepository;
import backEndCourse.summarySessions.summary01.TeaStore.service.*;
import backEndCourse.summarySessions.summary01.TeaStore.userInterface.MenuManager;

public class TeaStoreApp {
    public static void main(String[] args) {
        TeaRepository teaRepository = new TeaRepository(15);
        ManufacturerRepository manufacturerRepository = new ManufacturerRepository(6);
        TypeOfTeaRepository typeOfTeaRepository = new TypeOfTeaRepository(5);

        TeaService teaService = new TeaService(teaRepository);
        ManufacturerService manufacturerService = new ManufacturerService(manufacturerRepository);
        TypeOfTeaService typeOfTeaService = new TypeOfTeaService(typeOfTeaRepository);

        manufacturerService.setTeaService(teaService);
        typeOfTeaService.setTeaService(teaService);
        teaService.setManufacturerService(manufacturerService);
        teaService.setTypeOfTeaService(typeOfTeaService);

        ManufacturerController manufacturerController = new ManufacturerController(manufacturerService);
        TypeOfTeaController typeOfTeaController = new TypeOfTeaController(typeOfTeaService);
        TeaController teaController = new TeaController(teaService);

        MenuManager menuManager = new MenuManager(teaController, manufacturerController, typeOfTeaController);
        menuManager.mainMenu();

    }
}
