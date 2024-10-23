package Creational.Builder.BuilderPatternWithDiffDirectors;

public class SpicyPizzaDirector implements PizzaDirector {
    private final PizzaBuilder pizzaBuilder;

    public SpicyPizzaDirector() {
        this.pizzaBuilder = new PizzaBuilder();
    }

    public Pizza buildPizza() {
        return pizzaBuilder
                .setDough("pan baked")
                .setSauce("hot")
                .setTopping("pepperoni + salami")
                .build();
    }
}
