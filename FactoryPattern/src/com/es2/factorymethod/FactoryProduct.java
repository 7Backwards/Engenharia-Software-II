package com.es2.factorymethod;

public abstract class FactoryProduct {

    public static Product makeProduct(String type)
            throws UndefinedProductException {

        switch (type) {
            case "Computer":
                return new Computer();
            case "Software":
                return new Software();
            default:
                throw new UndefinedProductException();
        }
    }

}
