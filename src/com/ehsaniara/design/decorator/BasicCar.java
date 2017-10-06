package com.ehsaniara.design.decorator;

/**
 * Created by Ehsaniara (Jay.Ara) on 10/1/17.
 * From http://www.ehsaniara.com
 */
public class BasicCar implements Car {

    @Override
    public void assemble() {
        System.out.print("Basic Car.");
    }
}
