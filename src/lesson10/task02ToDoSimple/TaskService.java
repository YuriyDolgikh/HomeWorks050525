package lesson10.task02ToDoSimple;

import utils.UserInput;

public class TaskService {
    UserInput userInput = new UserInput();

    public Task newTask(){
        String name = userInput.inputText("Please enter the task name :");
        String description = userInput.inputText("Please enter the description :");
        return new Task(name, description);
    }

}
