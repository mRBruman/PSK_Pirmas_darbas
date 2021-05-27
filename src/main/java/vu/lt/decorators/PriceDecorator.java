package vu.lt.decorators;

import vu.lt.usecases.IRandomNumberGenerator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.Random;

@Decorator
public class PriceDecorator implements IRandomNumberGenerator {

    @Inject
    @Delegate
    @Any
    private IRandomNumberGenerator numberGenerator;

    public Integer generatePrice() {
        Integer result = numberGenerator.generatePrice();
        int valueToAdd = new Random().nextInt(1000) + 100;
        return result + valueToAdd;
    }
}
