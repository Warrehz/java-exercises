public class TestEdible {
    public static void main(String[] args) {

        Object[] objects = {new Tiger(), new Chicken(), new Apple()};

        for (int i = 0; i < objects.length; i++) {

            if (objects[i] instanceof Edible) {
                System.out.println(((Edible)objects[i]).howToEat());
            }

            if (objects[i] instanceof Animal) {
                System.out.println(((Animal)objects[i]).sound());
            }

        }
    }
}

abstract class Animal {

    private double weight;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public abstract String sound();

}

class Chicken implements Edible {

    @Override
    public String howToEat() {
        return "Chicken: Fry it";
    }

    @Override
    public String sound() {
        return "Chicken: Bawkkkk bawk bawk bawk";
    }

}

class Tiger extends Animal {

    @Override
    public String sound() {
        return "Tiger: Roarrrr!";
    }

}

class Apple implements Edible {

    @Override
    public String howToEat() {
        return "Apple: Make apple pie";
    }

}

public interface Edible {

    public abstract howToEat();
    
}



