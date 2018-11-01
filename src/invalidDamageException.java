/*
invalidDamageException.java

Custom exception to reject negative damage during fights
*/


public class invalidDamageException extends RuntimeException {
  public static void getMessage(int val) {
    System.out.printf("\n%d is invalid. Value cannot be a negative integer.\n", val);
  }

}
