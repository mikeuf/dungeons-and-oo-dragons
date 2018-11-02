/*
Bugbear.java

A Bugbear is intended to be a "medium-strength" monster.

Possible weapons include:
        UNCLEAN_CLAWS(2, "Unclean claws"),
        BUGBITE(3, "Bugbite");

Armor type:
        TRASH_CAN_LID(3, "Metal trash can lid for a breastplate, suspended with bungee cords");

*/


public class Bugbear extends Enemy {
  enum Weapon {
        /* the number next to the weapon is the damage multiplier.
        Generally, "NOTHING" should not actually appear. */

    NOTHING(1, "Nothing"),
    UNCLEAN_CLAWS(2, "Unclean claws"),
    BUGBITE(3, "Bugbite");

    private final int power_;
    private final String mixedCaps_;

    Weapon(int power, String mixedCaps) {
      this.power_ = power;
      this.mixedCaps_ = mixedCaps;
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

    TRASH_CAN_LID();

    private final String mixedCaps_;

    Armor() {
      this.mixedCaps_ = "Metal trash can lid for a breastplate, suspended with bungee cords";
    }

    String getMixedCaps() {
      return mixedCaps_;
    }

  }

  private Weapon weapon_ = Weapon.NOTHING;
  private final Armor armor_ = Armor.TRASH_CAN_LID;

  // constructor
  public Bugbear() {
    System.out.print("\nBugbear()\n");
    this.name_ = "Bugbear";
    this.health_ = (int) ((Math.random() * 30) + 20);
    this.gold_ = (int) ((Math.random() * 200) + 20);
  }

  // fighting a Knight
  public int fight(Knight k) {

        /* print battle-related messages and call the opponent's
        setDamage() method
         */

    int modifier = 0;

    System.out.printf("\nThe %s attacks %s with his %s! ",
            this.getName(), k.getName(), this.getWeapon());

    // calculate and report damage amount

    // include difference in the weapon strength vs opponent armor strength
    modifier = weapon_.getPower() - k.getArmor_().getDefense();

    // damage is 5-13 hit points +/- the modifier
    int damage = ((int) ((Math.random() * 8 + modifier + 5)));

    System.out.printf("(DAMAGE: %d)\n", damage);

    // apply damage to opponent
    k.setDamage(damage);

    // check to see if the opponent is dead
    if (k.getHealth() < 0) {
      System.out.printf("\n%s hath been slain by the %s!", k.getName(), this.getName());
      return 1;
    }

    return 0;
  }


  public void setAutoWeapon() {
    /* auto select a weapon for auto generated knights */
    int choice = ((int) ((Math.random() * 2) + 1));
    switch (choice) {
      case 1:
        weapon_ = Weapon.UNCLEAN_CLAWS;
        break;

      case 2:
        weapon_ = Weapon.BUGBITE;
        break;

      default:
        System.out.print("\nError while choosing auto weapon\n");
        System.exit(1);
    }
  }


  // getters
  public String getName() {
    return this.name_;
  }

  public int getHealth() {
    return this.health_;
  }

  public int getGold() {
    return this.gold_;
  }

  public String getWeapon() {
    return this.weapon_.getMixedCaps();
  }

  public String getArmor() {
    return this.armor_.getMixedCaps();
  }


}
