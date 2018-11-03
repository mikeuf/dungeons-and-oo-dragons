/*
Balrog.java

A Balrog is intended to be a powerful monster, with a lot of treasure.

Possible weapons include:
        FEARSOME_FISTS(2, "Fearsome fists"),
        FIERY_FLAIL(5, "Fiery flail");

Armor type:
    Armor armor = Armor.ENCHANTED_HIDE;

*/


public class Balrog extends NonPlayerCharacter {

  /**
   * Weapons available to Balrog
   */
  private enum Weapon {
    // The number next to the weapon is the damage multiplier.
    FEARSOME_FISTS(2, "Fearsome fists"),
    FIERY_FLAIL(5, "Fiery flail");

    }

    int getPower() {
      return power_;
    }

    String getMixedCaps() {
      return mixedCaps_;
    }
  }


  enum Armor {
        /* the number next to the weapon is the defense multiplier.
        Generally, "NOTHING" should not actually appear. */

    ENCHANTED_HIDE();

    private final String mixedCaps_;

    Armor() {
      this.mixedCaps_ = "Enchanted Hide";
    }

    String getMixedCaps() {
      return mixedCaps_;
    }

  }





  // constructor
  public Balrog() {
    name = "Balrog";
    health = (int) ((Math.random() * 100) + 100);
    gold = (int) ((Math.random() * 50000) + 500);
  }





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
