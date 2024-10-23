package Creational.FactoryPattern;

abstract class Creator {

    public abstract Product createProduct();

    public void operation() {
        Product product = createProduct();
        product.doOperation();
    }

}
