package Creational.FactoryPattern;

public class CreatorProductA extends Creator {

    @Override
    public Product createProduct() {
        return new ProductA();
    }

}
