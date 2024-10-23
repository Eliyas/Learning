package Creational.FactoryPattern;

public class CreatorProductB  extends Creator {

    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
