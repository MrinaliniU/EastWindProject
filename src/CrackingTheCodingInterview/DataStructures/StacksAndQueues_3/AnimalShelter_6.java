package CrackingTheCodingInterview.DataStructures.StacksAndQueues_3;
/*
    An animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" basis.
    People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select
    whether they would prefer a dog or a cat (and will receive the oldest animal of that type). They cannot
    select which specific animal they would like. Create the data structures to maintain this system and implement
    operations such as "enqueue", dequeueAny, dequeueDog and dequeueCat. You may use the built-in LinkedList
    dataStructure.
 */
import java.util.*;
public class AnimalShelter_6 {
    LinkedList<Long> dogs;
    LinkedList<Long> cats;
    long latestAnimal;
    AnimalShelter_6(){
        this.dogs = new LinkedList<>();
        this.cats = new LinkedList<>();
        latestAnimal = Long.MIN_VALUE;
    }
    void enqueue(String animal){
        if(animal.equalsIgnoreCase("cat")) cats.add(latestAnimal++);
        else if(animal.equalsIgnoreCase("dog")) dogs.add(latestAnimal++);
    }
    String dequeueAny(){
        if(dogs.isEmpty() && cats.isEmpty()) return "No Animals in Shelter";
        if(dogs.isEmpty()){
            cats.removeFirst();
            return "cat";
        }
        else if(cats.isEmpty()){
            dogs.removeFirst();
            return "dog";
        }else{
            String result = dogs.getFirst() < cats.getFirst() ? "dog" : "cat";
            if(result.equals("dog")) dogs.removeFirst();
            else cats.removeFirst();
            return result;
        }
    }
    String dequeueDog(){
        if(dogs.isEmpty()) return "No Dogs in Shelter";
        dogs.removeFirst();
        return "dog";
    }
    String dequeueCat(){
        if(cats.isEmpty()) return "No Cats in Shelter";
        cats.removeFirst();
        return "cat";
    }

    public static void main(String[] args){
        AnimalShelter_6 a6 = new AnimalShelter_6();
        a6.enqueue("dog");
        a6.enqueue("dog");
        a6.enqueue("cat");
        a6.enqueue("cat");
        a6.enqueue("dog");
        a6.enqueue("dog");
        a6.enqueue("dog");
        a6.enqueue("cat");
        a6.enqueue("dog");
        System.out.println("Adopt any animal --- " + a6.dequeueAny()); // dog
        System.out.println("Adopt any cat --- " + a6.dequeueCat()); // cat
        System.out.println("Adopt any animal --- " + a6.dequeueAny()); // dog
        System.out.println("Adopt any dog --- " + a6.dequeueDog()); // dog
        a6.enqueue("cat");
        System.out.println("Adopt any animal --- " + a6.dequeueAny()); // cat
        System.out.println("Adopt any animal --- " + a6.dequeueAny()); // dog
        a6.enqueue("dog");
        System.out.println("Adopt any animal --- " + a6.dequeueAny()); // dog
        System.out.println("Adopt any animal --- " + a6.dequeueAny()); // cat
        a6.enqueue("dog");
        System.out.println("Adopt any animal --- " + a6.dequeueAny()); // dog
        System.out.println("Adopt any animal --- " + a6.dequeueAny()); // cat
    }
}
