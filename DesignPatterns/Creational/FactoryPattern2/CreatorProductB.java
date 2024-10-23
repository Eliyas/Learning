package Creational.FactoryPattern2;

public class CreatorProductB  extends Creator {

    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
