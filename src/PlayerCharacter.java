import java.util.HashMap;
import java.util.Map;
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
//  Map<String, Integer> weapon;
  //Map<String, Integer> armor;

  /**
    * ctor automatically initializes some knight attributes if the knight is auto-generated
    */
  public PlayerCharacter() {
    setHealth((int) ((Math.random() * HEALTH_MULTIPLIER) + 50));
    setGold((int) ((Math.random() * GOLD_MULTIPLIER) + 20));
    setAge((int) ((Math.random() * AGE_MULTIPLIER) + 18));
  }

  @Override
  public int attack(NonPlayerCharacter npc) {
    System.out.printf("\n%s strikes the %s with his %s! ", name, npc.getName(), weapon);

    /*
     * when calculating damage amount include difference in the weapon strength vs opponent armor strength
     * damage is 5-13 hit points +/- the modifier
     */
    int modifier = weapon.get(weapon.) - monst.defense;

    int damage = ((int) ((Math.random() * 8 + modifier + 5)));

    System.out.printf("(DAMAGE: %d)\n", damage);
    return 0;
  }

  /**
   *  Allows the player to select a weapon, interactively
   */
  public void chooseWeaponInteractively() {
    Scanner input = new Scanner(System.in);
    int userChoice = 0;
    do {
      System.out.println("Select your weapon! (Choose number):\n" +
              "1) Long Sword\n" +
              "2) Battle Axe\n" +
              "3) Nunchuks\n" +
              "Your choice my liege? : ");
      try {
        userChoice = input.nextInt();
      } catch (Exception ex) {
        System.out.println("Enter an integer between 1 and 3.\n" + "(" + ex + ")");
      }
    }
    while (userChoice < 0 || userChoice > 3);

    generateWeapon (userChoice);
  }

  /**
   *  Generates a weapon for the player based on a provided integer.
   *  Integer value is the attack power of the weapon.
   *
   * @param weaponNumber
   */
  public void generateWeapon(int weaponNumber) {
    switch (weaponNumber) {
      case 1:
        myWeapon.setName("long sword");
        myWeapon.setAttackPower(4);
        break;
      case 2:
        myWeapon.setName("battle axe");
        myWeapon.setAttackPower(5);
        break;
      case 3:
        myWeapon.setName("nunchuks");
        myWeapon.setAttackPower(3);
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
    Scanner input = new Scanner(System.in);
    int userChoice = 0;
    do {
      System.out.println("Select your armor! (Choose number):\n" +
              "1) Chain Mail\n" +
              "2) Plate Armor\n" +
              "3) Mithril Coat\n" +
              "Your selection, sire? : ");
      try {
        userChoice = input.nextInt();
      } catch (Exception ex) {
        System.out.println("Enter an integer between 1 and 3.\n" + "(" + ex + ")");
      }
    }
    while (userChoice < 0 || userChoice > 3);

    generateWeapon (userChoice);
  }

  /**
   *  Generates armor for the player based on provided integer
   *
   * @param armorNumber
   */
  public void chooseArmorInteractively(int armorNumber) {
    switch (armorNumber) {
      case 1:
        myArmor.setName("chain mail");
        myArmor.setDefenseLevel(3);
        break;
      case 3:
        myArmor.setName("chain mail");
        myArmor.setDefenseLevel(4);
        break;
      case 4:
        myArmor.setName("mithril coat");
        myArmor.setDefenseLevel(5);
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
    chooseArmorAutomatically(randomNumber);
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
    System.out.println("Name: " + getName() +
            "\nHealth: " + getHealth() +
            "\nAge: " + getAge() +
            "\nGold: $" + getGold() +
            "\nWeapon: " + getWeapon() +
            "\nArmor: " + getArmor());
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

  public String getWeapon() {
    return weapon.;
  }

  public Armor getArmor() {
    return armor;
  }

  public void setArmor(Armor armor) {
    this.armor = armor;
  }
}


