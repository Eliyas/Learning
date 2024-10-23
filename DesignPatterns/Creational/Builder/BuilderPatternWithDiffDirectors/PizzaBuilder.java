package Creational.Builder.BuilderPatternWithDiffDirectors;

// Builder Class
public class PizzaBuilder {
    String dough;
    String sauce;
    String topping;

    public PizzaBuilder setDough(String dough) {
        this.dough = dough;
        return this;
    }

    public PizzaBuilder setSauce(String sauce) {
        this.sauce = sauce;
        return this;
    }

    public PizzaBuilder setTopping(String topping) {
        this.topping = topping;
        return this;
    }

    public Pizza build() {
        return new Pizza(this);
    }
}
