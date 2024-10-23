package Creational.Builder.BuilderPatternWithDiffDirectors;

public class Client {
    public static void main(String[] args) {

        PizzaDirector pizzaDirector = new SpicyPizzaDirector();
        Pizza spicyPizza = pizzaDirector.buildPizza();

        System.out.println(spicyPizza);     // Output: Pizza with pan baked, hot, and pepperoni + salami
    }
}

