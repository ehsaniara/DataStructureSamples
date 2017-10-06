package com.ehsaniara.design.decorator;

/**
 * Created by Ehsaniara (Jay.Ara) on 10/1/17.
 * From http://www.ehsaniara.com
 */
public abstract class CarDecorator implements Car {

    protected Car car;

    public CarDecorator(Car c) {
        this.car = c;
    }

    @Override
    public  void assemble() {
        this.car.assemble();
    }
}
