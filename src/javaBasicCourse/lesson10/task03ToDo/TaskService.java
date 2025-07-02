package javaBasicCourse.lesson10.task03ToDo;

import utils.UserInput;

public class TaskService {
    UserInput userInput = new UserInput();

    public Task newTask(){
        String name = userInput.inputText("Please enter the task name :");
        String description = userInput.inputText("Please enter the description :");
        return new Task(name, description);
    }

    public Day createDaysTask(Task task){
        int taskId = userInput.inputInt("Please enter the task id for task [" + task.getTaskName() + "]: ");
        return new Day(taskId, task);
    }

}
