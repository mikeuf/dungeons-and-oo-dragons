/*
Enemy.java

The Enemy class allows the play to select how many random monsters they
want to fight in JavaBean Forest.

Each enemy has multiple attack types, with different damage multipliers. The
weapons are selected at random.

Each of the enemies has a random amount of treasure. After each battle, the player
knight will take the treasure and update his gold_ member variable.

*/


public abstract class Enemy {
  // placeholders that will be extended by subclasses
  String name_ = null;
  int health_ = 0;
  int gold_ = 0;
  int defense_ = 0;

  // constructor intentionally left blank
  public Enemy() {
  }

  public abstract int fight(Knight k);

  public void takeDamage(int damage) {
        /* subtracts damage from enemy's health count
            throws custom exception if damage received is negative */

    try {
      if (damage > 0) {
        health_ -= damage;
      } else {
        throw (new invalidDamageException());
      }
    } catch (invalidDamageException ex) {
      ex.getMessage();
    }
  }


  public void printEnemyStats() {
        /* I used toString() for the name. I could have used toString()
        for the rest, but I used getters because they include some
        formatting to make it look nicer. I hope that's OK  */

    System.out.println("\nEnemy Name: " + name_);
    System.out.println("Enemy Health: " + getHealth());
    System.out.println("Enemy Gold: $" + getGold());
    System.out.println("Enemy Weapon: " + getWeapon());
    System.out.println("Enemy Armor: " + getArmor());
  }


  public static Enemy getRandomEnemy() {

    // creates random enemy object for knight to fight
    System.out.printf("\ngetRandomEnemy()\n");
    int enemyChooser = ((int) ((Math.random() * 3) + 1));

    switch (enemyChooser) {
      case 1: {
        Enemy e = new Hobgoblin();
        return e;
      }
      case 2: {
        Enemy e = new Bugbear();
        return e;
      }
      case 3: {
        Enemy e = new Balrog();
        return e;
      }
      default:
        System.out.printf("\nError while generating enemy. Exiting\n");
    }
// should not get here -- but adding this to satisfy the return value requirement
    Enemy e = new Hobgoblin();
    return e;
  }


  // setters
  public abstract void setAutoWeapon();


  public void setHealth(int health) {
    health_ = health;
  }


  public void setGold(int gold) {
    gold_ = gold;
  }


  // getters
  public String getName() {
    return this.name_;
  }


  public int getGold() {
    return this.gold_;
  }


  public int getHealth() {
    return this.health_;
  }

  public String getWeapon() {
    return "";
  }

  public String getArmor() {
    return "";
  }
}

