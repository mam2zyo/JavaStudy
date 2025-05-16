package generics.ex042502;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Feeder<T> {

    public void feedAnimals(List<? super Animal> animals) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        animals.add(dog);
        animals.add(cat);

        animals.stream()
                .map(a -> (Animal)a)
                .forEach(a -> a.feed());
    }

    public static void main(String[] args) {
        Feeder<Animal> feeder = new Feeder<>();
        List<Object> animals = new ArrayList<>();

        feeder.feedAnimals(animals);
    }
}