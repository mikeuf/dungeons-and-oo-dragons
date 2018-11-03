/*
NonPlayerCharacter.java

The NonPlayerCharacter class allows the play to select how many random monsters they
want to fight in JavaBean Forest.

Each monster has multiple attack types, with different damage multipliers. The
weapons are selected at random.

Each of the enemies has a random amount of treasure. After each battle, the player
knight will take the treasure and update his gold_ member variable.

*/


public abstract class NonPlayerCharacter implements Character {

  // EMERGENCY EMERGENCY MAY DAY MAY DAY

  // placeholders that will be extended by subclasses
  String name;
  int health;
  int gold;
  final int defense = 0;

  NonPlayerCharacter() {
    this.health = 0;
    this.gold = 0;
  }

  // public abstract int fight(PlayerCharacter k);


  public void printStats() {
        /* I used toString() for the name. I could have used toString()
        for the rest, but I used getters because they include some
        formatting to make it look nicer. I hope that's OK  */

    System.out.println("\nNonPlayerCharacter Name: " + name);
    System.out.println("NonPlayerCharacter Health: " + getHealth());
    System.out.println("NonPlayerCharacter Gold: $" + getGold());
    System.out.println("NonPlayerCharacter Weapon: " + getWeapon());
    System.out.println("NonPlayerCharacter Armor: " + getArmor());
  }



  // setters
  public abstract void generateWeapon();

  public void setHealth(int health) {
    this.health -= health;
  }

  // getters
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
    return "";
  }

  String getArmor() {
    return "";
  }
}

