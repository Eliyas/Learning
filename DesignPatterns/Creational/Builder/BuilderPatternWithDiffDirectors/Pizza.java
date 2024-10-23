package Creational.Builder.BuilderPatternWithDiffDirectors;

// Product
public class Pizza {
    private final String dough;
    private final String sauce;
    private final String topping;

    // Private constructor to prevent direct instantiation
    public Pizza(PizzaBuilder builder) {
        this.dough = builder.dough;
        this.sauce = builder.sauce;
        this.topping = builder.topping;
    }

    @Override
    public String toString() {
        return "Pizza with " + dough + ", " + sauce + ", and " + topping;
    }

    // Getters (optional, if needed)
    public String getDough() {
        return dough;
    }

    public String getSauce() {
        return sauce;
    }

    public String getTopping() {
        return topping;
    }
}
