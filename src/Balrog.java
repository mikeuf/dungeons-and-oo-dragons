/*
Balrog.java

A Balrog is intended to be a powerful monster, with a lot of treasure.

Possible weapons include:
        FEARSOME_FISTS(2, "Fearsome fists"),
        FIERY_FLAIL(5, "Fiery flail");

Armor type:
    Armor armor = Armor.ENCHANTED_HIDE;

*/


import java.util.HashMap;
import java.util.Map;

public class Balrog extends NonPlayerCharacter {

  private final int GOLD_MULTIPLIER = 50000;
  private final int HEALTH_MULTIPLIER = 1000;

  private static final Map<String, Integer> weapon;
  static {
    Map<String, Integer> weapon = new HashMap<String, Integer>;
    weapon.put("fearsome fists", 2);
    weapon.put("fiery flail", 5);
    //   weapon = Collections.unmodifiableMap(weapon);
  }

  public Balrog() {
    name = "Balrog";
    health = (int) ((Math.random() * HEALTH_MULTIPLIER) + 100);
    gold = (int) ((Math.random() * GOLD_MULTIPLIER) + 500);
  }

  public void attack(PlayerCharacter pc) {};

  public
  int choice = ((int) ((Math.random() * 2) + 1));
    switch (choice) {
    case 1:
      weapon = Weapon.FEARSOME_FISTS;
      break;

    case 2:
      weapon = Weapon.FIERY_FLAIL;
      break;

    default:
      System.out.print("\nError while choosing auto weapon\n");
      System.exit(1);
  }
}

  /*

  public void generateWeapon() {
    /* auto select a weapon for auto generated knights */
    int choice = ((int) ((Math.random() * 2) + 1));
    switch (choice) {
      case 1:
        weapon = Weapon.FEARSOME_FISTS;
        break;

      case 2:
        weapon = Weapon.FIERY_FLAIL;
        break;

      default:
        System.out.print("\nError while choosing auto weapon\n");
        System.exit(1);
    }
  }
  */


  public String getName() {
    return this.name;
  }

  public int getHealth() {
    return this.health;
  }

  public int getGold() {
    return this.gold;
  }

  public String getWeapon() {
    return this.weapon.getMixedCaps();
  }

  public String getArmor() {
    return this.armor.getMixedCaps();
  }

}
