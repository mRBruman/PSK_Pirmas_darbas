package vu.lt.usecases;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class PriceGenerator implements Serializable, IRandomNumberGenerator {
    public Integer generatePrice(){
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e){
            System.out.println("Interrupted");
        }
        return new Random().nextInt(100) + 1;
    }
}
