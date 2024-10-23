package Creational.FactoryPattern;

public class Client {

    public static void main(String[] arrs) {
        CreatorProductA creatorProductA = new CreatorProductA();
        creatorProductA.operation();

        CreatorProductB creatorProductB = new CreatorProductB();
        creatorProductB.operation();
    }
}
