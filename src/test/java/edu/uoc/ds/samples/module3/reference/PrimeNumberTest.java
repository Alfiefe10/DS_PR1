package edu.uoc.ds.samples.module3.reference;

import edu.uoc.ds.util.Utils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static edu.uoc.ds.samples.module3.reference.PrimeNumber.isPrime;

public class PrimeNumberTest {

    @Test
    public void test() {
        Assert.assertTrue(isPrime(2));
        Assert.assertTrue(isPrime(3));
        Assert.assertFalse(isPrime(4));
        Assert.assertTrue(isPrime(5));
        Assert.assertFalse(isPrime(6));
        Assert.assertTrue(isPrime(7));
        Assert.assertFalse(isPrime(8));
    }

    public static void main(String[] args) {
        String str;
        long max;
        try {
            str = Utils.readString("Enter an integer: ", System.in);
            try {
                max = Long.parseLong(str);
                for (int i = 2; i < max; i++)
                    if (isPrime(i))
                        System.out.print(i + " ");
            } catch (NumberFormatException e) {
                System.out.println("The string entered is not an integer: " + str);
                System.out.println("Run the program again");
            }
        } catch (IOException e) {
            System.out.println("Problem with input, aborting the program25");
        }
    }

}
