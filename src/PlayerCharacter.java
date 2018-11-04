import java.util.Scanner;

/**
 * PlayerCharacter.java
 *
 * PlayerCharacter object that can be used to fight against other knights
 *
 * */
public class PlayerCharacter implements Character {
  private String name;
  private Weapon myWeapon;
  private Armor myArmor;
  private int health;
  private int age;
  private int gold;
  private final int GOLD_MULTIPLIER = 100;
  private final int HEALTH_MULTIPLIER = 50;
  private final int AGE_MULTIPLIER = 47;
  private final Scanner keyboardInput = new Scanner(System.in);

  /**
    * ctor automatically initializes some knight attributes if the knight is auto-generated
    */
  public PlayerCharacter() {
    setHealth((int) ((Math.random() * HEALTH_MULTIPLIER) + 50));
    setGold((int) ((Math.random() * GOLD_MULTIPLIER) + 20));
    setAge((int) ((Math.random() * AGE_MULTIPLIER) + 18));
  }

  public int attack(NonPlayerCharacter npc) {
    System.out.printf("\n%s strikes the %s with his %s, ", name, npc.getName(), myWeapon.getName());
    /*
     * when calculating damage amount include difference in the weapon strength vs opponent armor strength
     * damage is 5-13 hit points +/- the modifier
     */
    int modifier = myWeapon.getAttackPower() - npc.getDefenseLevel();
    if (modifier < 1) { //  if a weak weapon is up again powerful armor, just default to 1 instead of a negative
      modifier = 1;
    }

    int damage = ((int)(((Math.random() * 8) + modifier + 5)));
    System.out.printf("causing %d damage!\n", damage);

    return damage;
  }

  /**
   *  Allows the player to select a weapon, interactively
   */
  public void chooseWeaponInteractively() {
    int userSelection = 0;
    do {
      System.out.println("\nSelect your weapon! (Choose number):\n" +
              "1) Long Sword\n" +
              "2) Battle Axe\n" +
              "3) Nunchuks\n" +
              "\nYour choice my liege?: ");
      try {
        userSelection = keyboardInput.nextInt();
      } catch (Exception ex) {
        System.out.println("Enter an integer between 1 and 3.\n" + "(" + ex + ")");
      }
    }
    while (userSelection < 0 || userSelection > 3);

    generateWeapon(userSelection);
  }

  /**
   *  Generates a weapon for the player based on a provided integer.
   *  Integer value is the attack power of the weapon.
   *
   * @param weaponNumber an integer that corresponds with the desired weapon
   */
  private void generateWeapon(int weaponNumber) {
    switch (weaponNumber) {
      case 1:
        this.myWeapon = new Weapon("Long Sword", 4);
        break;
      case 2:
        this.myWeapon = new Weapon("Battle Axe", 5);
        break;
      case 3:
        this.myWeapon = new Weapon("Nunchuks", 3);
        break;
      default:
        System.out.print("\nError while choosing auto weapon\n");
        System.exit(1);
    }
  }

  /**
   * Selects a random weapon for the player
   */
  public void chooseWeaponAutomatically() {
    int randomNumber = ((int) ((Math.random() * 3) + 1));
    generateWeapon(randomNumber);
  }

  /**
   *  Allows the player to select a armor, interactively
   */
  public void chooseArmorInteractively() {
    int userSelection = 0;
    do {
      System.out.println("\nSelect your armor! (Choose number):\n" +
              "1) Chain Mail\n" +
              "2) Plate Armor\n" +
              "3) Mithril Coat\n" +
              "\nYour selection, sire?: ");
      try {
        userSelection = keyboardInput.nextInt();
      } catch (Exception ex) {
        System.out.println("Enter an integer between 1 and 3.\n" + "(" + ex + ")");
      }
    }
    while (userSelection < 0 || userSelection > 3);

    generateArmor(userSelection);
  }

  /**
   *  Generates armor for the player based on provided integer
   *
   * @param armorNumber a unique integer that corresponds with the desired weapon
   */
  private void generateArmor(int armorNumber) {
    switch (armorNumber) {
      case 1:
        this.myArmor = new Armor("Chain Mail", 3);
        break;
      case 2:
        this.myArmor = new Armor("Plate Armor", 4);
        break;
      case 3:
        this.myArmor = new Armor("Mithril Coat", 5);
        break;
      default:
        System.out.println("An unexpected error occurred while choosing armor. Exiting program.");
        System.exit(1);
    }
  }

  /**
   * Selects a random armor for the player
   */
  public void chooseArmorAutomatically() {
    int randomNumber = ((int) ((Math.random() * 3) + 1));
    generateArmor(randomNumber);
  }

  /**
   * Automatically generate names for knights
   */
  public void chooseNameAutomatically() {
    int randomNumber = ((int) ((Math.random() * 5) + 1));
    switch (randomNumber) {
      case 1:
        setName("Sir Lancelot");
        break;
      case 2:
        setName("Sir Loin");
        break;
      case 3:
        setName("Sir Tificate");
        break;
      case 4:
        setName("Lord Vader");
        break;
      case 5:
        setName("Baron Crumpet");
        break;
      default:
        System.out.print("An unexpected error occurred while generating a name. Exiting program.");
        System.exit(1);
    }
  }

  @Override
  public void printStats() {
    System.out.println("\nName: " + getName() +
            "\nHealth: " + getHealth() +
            "\nAge: " + getAge() +
            "\nGold: $" + getGold() +
            "\nWeapon: " + myWeapon.getName() +
            "\nArmor: " + myArmor.getName());
  }

  public int getDefenseLevel() {
    return myArmor.getDefenseLevel();
  }

  public String getWeapon() {
    return myWeapon.getName();
  }

  public String getArmor() {
    return myArmor.getName();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getHealth() {
    return health;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getGold() {
    return gold;
  }

  public void setGold(int gold) {
    this.gold = gold;
  }





  /*

  */
}


