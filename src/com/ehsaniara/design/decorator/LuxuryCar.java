package com.ehsaniara.design.decorator;

/**
 * Created by Ehsaniara (Jay.Ara) on 10/1/17.
 * From http://www.ehsaniara.com
 */
public class LuxuryCar extends CarDecorator {
    public LuxuryCar(Car c) {
        super(c);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print(" Adding features of Luxury Car.");
    }
}
