package Creational.FactoryPattern2;

public class CreatorProductA extends Creator {

    @Override
    public Product createProduct() {
        return new ProductA();
    }

}
