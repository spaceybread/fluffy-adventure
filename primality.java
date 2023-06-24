import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
import java.math.BigInteger;

public class primality {
  public static void main(String[] args) {
    System.out.println("Enter a value to check primality:");
    Scanner valueIn = new Scanner(System.in);
    Random rand = new Random();
    String valueString = valueIn.next();
    int valForMod = Integer.parseInt(valueString);
    BigInteger value = new BigInteger(valueString);
    // value to be tested for being prime

    int i = 0;

    boolean isComposite = false;

    while (isComposite == false) {
      i++;

      //fermat's little theorem
      //a ^ (p - 1) should be congruent to 1 mod p
      //p is the value from the user
      //a is the witness number

      int witRan = rand.nextInt(3) + 2;
      //System.out.println(witness);
      //System.out.println("\n");

      while (true) {
        if ((witRan % valForMod) != 0) {
          break;
        }
        else {
          witRan = rand.nextInt(3) + 2;

        }
      }

      BigInteger witness = BigInteger.valueOf(witRan);

      //BigInteger powerVal = Math.pow(witness, (value - 1));
      //double fullPowerVal = Double.parseDouble(powerVal);


      //System.out.println(powerVal);
      //System.out.println("\n");

      BigInteger minusOne = BigInteger.valueOf(-1);

      BigInteger modVal = witness.modPow(value.add(minusOne), value);
      //System.out.println(modVal);
      //System.out.println("\n");



      //System.out.println(modVal.equals(BigInteger.ONE));

      if (modVal.equals(BigInteger.ONE) && i > 10) {
        System.out.println("This might be a prime.");
        break;
      }

      else if ((!modVal.equals(BigInteger.ONE)) && i <= 10) {
        System.out.println("This is a composite number.");
        isComposite = true;
      }
    }

  }
}
