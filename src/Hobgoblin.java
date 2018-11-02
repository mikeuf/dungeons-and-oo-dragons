/*
Hobgoblin.java

A hobgoblin is intended to be a weak monster. It is also the Foolish Consistency of Little Minds.

Possible weapons include:
        HOBSLAP(2, "Hob-slap"),
        RUSTY_DAGGER(3, "Rusty Dagger");

Armor type:
        GARBAGE_BAG(2, "Hefty garbage bag with holes cut-out for arms");

*/

public class Hobgoblin extends Monster {

  enum Weapon {
        /* the number next to the weapon is the damage multiplier.
        Generally, "NOTHING" should not actually appear. */

    NOTHING(1, "Nothing"),
    HOBSLAP(2, "Hob-slap"),
    RUSTY_DAGGER(3, "Rusty Dagger");

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

    GARBAGE_BAG();

    private final String mixedCaps_;

    Armor() {
      this.mixedCaps_ = "Hefty garbage bag with holes cut-out for arms";
    }

    String getMixedCaps() {
      return mixedCaps_;
    }

  }

  private Weapon weapon_ = Weapon.NOTHING;
  private final Armor armor_ = Armor.GARBAGE_BAG;


  // constructor
  public Hobgoblin() {
    System.out.print("\nHobgoblin()\n");
    name_ = "Hobgoblin";
    health_ = (int) ((Math.random() * 10) + 5);
    gold_ = (int) ((Math.random() * 100) + 10);
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
        weapon_ = Weapon.HOBSLAP;
        break;

      case 2:
        weapon_ = Weapon.RUSTY_DAGGER;
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
