package backEndCourse.lesson02.task1;

public class AnimalsDemo {
    public static void main(String[] args) {

        Dog dog1 = new Dog("Richard");
        Dog dog2 = new Dog("Jack");
        Dog dog3 = new Dog("Mick");

        Cat cat1 = new Cat("Tom");
        Cat cat2 = new Cat("Jerry");

        Animal[] animals = {dog1, dog2, dog3, cat1, cat2};

        printOnlyDogs(animals);
    }

    private static void printOnlyDogs(Animal[] animals){
        for(Animal animal : animals){
            if(animal instanceof Dog){
                System.out.println(animal);
            }
        }
    }
}
