package lesson23.task3.service;

import javaBasicCourse.lesson23.task3.model.Task;
import javaBasicCourse.lesson23.task3.repository.TaskRepository;
import javaBasicCourse.lesson23.task3.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    private TaskService taskService;
    private TaskService taskServiceSmall;

    @BeforeEach
    void setUp() {
        TaskRepository taskRepository = new TaskRepository(6);
        taskService = new TaskService(taskRepository);
        TaskRepository taskRepositorySmall = new TaskRepository(1);
        taskServiceSmall = new TaskService(taskRepositorySmall);
        taskService.fillDbWithExampleData();
    }

    @Test
    void testAddTaskCommonCase() {
        String result = taskServiceSmall.addTask(21, "Go for shopping", "Buy T-Shirt", 2, false);
        assertEquals("Task added successfully", result);
    }

    @Test
    void testAddTaskNoFreeSpace() {
        String resultOk = taskServiceSmall.addTask(21, "Go for shopping", "Buy T-Shirt", 2, false);
        String resultBad = taskServiceSmall.addTask(22, "Call my mom", "Ask for the weekend", 4, false);
        assertEquals("Task added successfully", resultOk);
        assertEquals("No free space in the database", resultBad);
    }

    @Test
    void testAddTaskWhenTitleIsNull() {
        String result = taskServiceSmall.addTask(21, null, "Buy T-Shirt", 2, false);
        assertEquals("Wrong parameters", result);
    }

    @Test
    void testAddTaskWhenDescriptionIsNull() {
        String result = taskServiceSmall.addTask(21, "Go for shopping", null, 2, false);
        assertEquals("Wrong parameters", result);
    }

    @Test
    void testAddTaskWhenTitleIsBlanc() {
        String result = taskServiceSmall.addTask(21, "  ", "Buy T-Shirt", 2, false);
        assertEquals("Wrong parameters", result);
    }

    @Test
    void testAddTaskWhenPriorityIsOutOfRange() {
        String resultOne = taskServiceSmall.addTask(21, "Go for shopping", "No comments", -5, false);
        String resultTwo = taskServiceSmall.addTask(22, "Call my mom", "Ask for the weekend", 15, false);
        assertEquals("Wrong parameters", resultOne);
        assertEquals("Wrong parameters", resultTwo);
    }

    @Test
    void testAddTaskWhenTaskExists() {
        String result = taskService.addTask(21, "Title", "No comments", 9, false);
        assertEquals("Task already exists", result);
    }

    @Test
    void testGetTaskByIdTaskExists() {
        Task task = new Task(21, "Go for shopping", "Buy T-Shirt", 2, false);
        assertEquals(task, taskService.getTaskById(21));
    }

    @Test
    void testGetTaskByIdTaskNotExists() {
        assertNull(taskService.getTaskById(55));
    }

    @Test
    void testGetTasksByTitleExist() {
        Task task1 = new Task(22, "Call my mom", "Ask for the weekend", 4, true);
        Task task2 = new Task(9, "Call my dad", "No comments", 8, false);
        Task[] tasks = {task1, task2};
        assertArrayEquals(tasks, taskService.getTasksByTitle("Call"));
    }

    @Test
    void testGetTasksByTitleNotExist() {
        Task[] tasks = {};
        assertArrayEquals(tasks, taskService.getTasksByTitle("Hello"));
    }

    @Test
    void testGetTasksByTitleNull() {
        assertNull(taskService.getTasksByTitle(null));
    }

    @Test
    void testGetTasksByTitleBlanc() {
        assertNull(taskService.getTasksByTitle(" "));
    }

    @Test
    void testGetTasksByStatus() {
        Task task1 = new Task(22, "Call my mom", "Ask for the weekend", 4, true);
        Task task2 = new Task(31, "Dads birthday", "Buy the flowers", 9, true);
        Task[] tasks = {task1, task2};
        assertArrayEquals(tasks, taskService.getTasksByStatus(true));
    }

    @Test
    void testUpdateTaskStatusByTaskIdTaskExists() {
        String result = taskService.updateTaskStatusByTaskId(21, true);
        assertEquals("Task was updated successfully", result);
    }

    @Test
    void testUpdateTaskStatusByTaskIdTaskNotExists() {
        String result = taskService.updateTaskStatusByTaskId(28, true);
        assertEquals("Task id doesn't exist", result);
    }

    @Test
    void testUpdateTaskPriorityByTaskId() {
    }

    @Test
    void testUpdateTaskPriorityByTaskIdTaskExists() {
        int priorityBevore = taskService.getTaskById(21).getTaskPriority();
        String result = taskService.updateTaskPriorityByTaskId(21, 8);
        int priorityAfter = taskService.getTaskById(21).getTaskPriority();
        assertNotEquals(priorityBevore, priorityAfter);
        assertEquals("Task was updated successfully", result);
    }

    @Test
    void testUpdateTaskPriorityByTaskIdNotExists() {
        String result = taskService.updateTaskPriorityByTaskId(28, 8);
        assertEquals("Task id doesn't exist", result);
    }

    @Test
    void testUpdateTaskPriorityByTaskIdOutOfRange() {
        String result = taskService.updateTaskPriorityByTaskId(21, 10);
        assertEquals("Wrong parameters", result);
    }

    @Test
    void testDeleteTaskByIdTaskExists() {
        int sizeBevor = taskService.findAllTasks().length;
        Task task = taskService.getTaskById(21);
        assertNotNull(task);
        String result = taskService.deleteTaskById(21);
        int sizeAfter = taskService.findAllTasks().length;
        assertEquals("Task was deleted successfully", result);
        assertEquals(1, sizeBevor - sizeAfter);
        assertNull(taskService.getTaskById(21));
    }

    @Test
    void testDeleteTaskByIdTaskNotExists() {
        String result = taskService.deleteTaskById(29);
        assertEquals("Task id doesn't exist", result);
    }

    @Test
    void testFindAllTasks() {
        Task task1 = new Task(11, "Do home task", "Every day", 5, false);
        Task task2 = new Task(21, "Go for shopping", "Buy T-Shirt", 2, false);
        Task task3 = new Task(22, "Call my mom", "Ask for the weekend", 4, true);
        Task task4 = new Task(9, "Call my dad", "No comments", 8, false);
        Task task5 = new Task(31, "Dads birthday", "Buy the flowers", 9, true);
        Task[] tasks = {task1, task2, task3, task4, task5};
        assertArrayEquals(tasks, taskService.findAllTasks());
    }

    @Test
    void testSortSourceDatabaseTasksExist() {
        Task task1 = new Task(11, "Do home task", "Every day", 5, false);
        Task task2 = new Task(21, "Go for shopping", "Buy T-Shirt", 2, false);
        Task task3 = new Task(22, "Call my mom", "Ask for the weekend", 4, true);
        Task task4 = new Task(9, "Call my dad", "No comments", 8, false);
        Task task5 = new Task(31, "Dads birthday", "Buy the flowers", 9, true);
        Task[] tasks = {task5, task4, task1, task3, task2};
        taskService.sortSourceDatabase();
        assertArrayEquals(tasks, taskService.findAllTasks());
    }

    @Test
    void testSortSourceDatabaseIfEmptyDatabase() {
        assertEquals("Database is empty", taskServiceSmall.sortSourceDatabase());
    }

    @Test
    void testFillDbWithExampleData() {
        TaskRepository thisTaskRepository = new TaskRepository(6);
        TaskService thisTaskService = new TaskService(thisTaskRepository);
        int sizeOfArrayBevor = thisTaskService.findAllTasks().length;
        thisTaskService.fillDbWithExampleData();
        int sizeOfArrayAfter = thisTaskService.findAllTasks().length;
        assertEquals(0, sizeOfArrayBevor);
        assertEquals(5, sizeOfArrayAfter);
    }
}