import java.util.Scanner;
import java.lang.Math;
import java.util.Random;

public class primality {
  public static void main(String[] args) {
    System.out.println("Enter a value to check primality:");
    Scanner valueIn = new Scanner(System.in);
    Random rand = new Random();
    String valueString = valueIn.next();
    double value = Integer.parseInt(valueString);
    // value to be tested for being prime

    double i = 0;

    boolean isComposite = false;

    while (isComposite == false) {
      i++;

      //fermat's little theorem
      //a ^ (p - 1) should be congruent to 1 mod p
      //p is the value from the user
      //a is the witness number

      double witness = rand.nextInt(3) + 2;
      //System.out.println(witness);
      //System.out.println("\n");

      while (true) {
        if ((witness % value) != 0) {
          break;
        }
        else {
          witness = rand.nextInt(3) + 2;

        }
      }

      double powerVal = Math.pow(witness, (value - 1));
      //double fullPowerVal = Double.parseDouble(powerVal);


      //System.out.println(powerVal);
      //System.out.println("\n");

      double modVal = powerVal % value;
      //System.out.println(modVal);
      //System.out.println("\n");

      if (modVal != 1 && i <= 10) {
        System.out.println("This is a composite number.");
        isComposite = true;
      }
      else if (modVal == 1 && i > 10) {
        System.out.println("This might be a prime.");
        break;
      }
    }

  }
}
