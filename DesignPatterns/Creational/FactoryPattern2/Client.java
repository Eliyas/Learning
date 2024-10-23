package Creational.FactoryPattern2;

public class Client {

    public static void main(String[] arrs) {
        CreatorProductA creatorProductA = new CreatorProductA();
        Product productA = creatorProductA.createProduct();
        productA.doOperation();

        CreatorProductB creatorProductB = new CreatorProductB();
        Product productB = creatorProductB.createProduct();
        productB.doOperation();
    }
}
