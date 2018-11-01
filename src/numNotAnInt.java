/*
numNotAnInt.java

Custom exception to reject non-ints
*/


public class numNotAnInt extends RuntimeException {
  public static void getMessage(String s) {
    System.out.printf("\nThis does not appear to be a valid integer. \n");
  }

}
