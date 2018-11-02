/*
Monster.java

The Monster class allows the play to select how many random monsters they
want to fight in JavaBean Forest.

Each monster has multiple attack types, with different damage multipliers. The
weapons are selected at random.

Each of the enemies has a random amount of treasure. After each battle, the player
knight will take the treasure and update his gold_ member variable.

*/


public abstract class Monster implements Player {
  // placeholders that will be extended by subclasses
  String name_ = null;
  int health_ = 0;
  int gold_ = 0;
  final int defense_ = 0;

  // constructor intentionally left blank
  Monster() {
  }

  public abstract int fight(Knight k);



  public void printStats() {
        /* I used toString() for the name. I could have used toString()
        for the rest, but I used getters because they include some
        formatting to make it look nicer. I hope that's OK  */

    System.out.println("\nMonster Name: " + name_);
    System.out.println("Monster Health: " + getHealth());
    System.out.println("Monster Gold: $" + getGold());
    System.out.println("Monster Weapon: " + getWeapon());
    System.out.println("Monster Armor: " + getArmor());
  }


  public static Monster getRandomMonster() {

    // creates random monster object for knight to fight
    System.out.print("\ngetRandomMonster()\n");
    int monsterChooser = ((int) ((Math.random() * 3) + 1));

    switch (monsterChooser) {
      case 1: {
        return new Hobgoblin();
      }
      case 2: {
        return new Bugbear();
      }
      case 3: {
        return new Balrog();
      }
      default:
        System.out.print("\nError while generating monster. Exiting\n");
    }
// should not get here -- but adding this to satisfy the return value requirement
    return new Hobgoblin();
  }


  // setters
  public abstract void setAutoWeapon();

  public void setHealth(int health) {
    this.health_ -= health;
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
    return "";
  }

  String getArmor() {
    return "";
  }
}

