/**
 * Balrog.java
 *
 * A Balrog is intended to be a powerful monster, with a lot of treasure.
 */

public class Balrog extends NonPlayerCharacter {

  private final int GOLD_MULTIPLIER = 500;
  private final int HEALTH_MULTIPLIER = 50;
  private final int ATTACK_MULTIPLIER = 5;
  private final String WEAPON = "fiery flail";
  private final String ARMOR = "enchanted hide";

  public Balrog() {
    name = "Balrog";
    health = (int) ((Math.random() * HEALTH_MULTIPLIER) + 100);
    gold = (int) ((Math.random() * GOLD_MULTIPLIER) + 500);
  }

  public void attack(PlayerCharacter pc) {};

}
