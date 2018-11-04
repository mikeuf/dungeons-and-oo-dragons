import java.util.Scanner;

/**
 * PlayerCharacter.java
 *
 * A PlayerCharacter (PC) is a knight that is generated and controlled by the player to fight
 * NonPlayerCharacters (NPCs).
 *
 */
public class PlayerCharacter implements Character {

  private String name;
  private Weapon myWeapon;
  private Armor myArmor;
  private int health;
  private int age;
  private int gold;

  // These are used in the calculations to autogenerate the values for their respective fields
  private final int GOLD_MULTIPLIER = 100;
  private final int HEALTH_MULTIPLIER = 25;
  private final int AGE_MULTIPLIER = 47;
  private final int ATTACK_MODIFIER = 5;
  private final int DEFENSE_MODIFIER = 2;
  private final Scanner keyboardInput = new Scanner(System.in);

  /**
   * Automatically generates a PlayerCharacter with all attributes set, including a name
   */
  public PlayerCharacter() {
    setHealth((int) ((Math.random() * HEALTH_MULTIPLIER) + 25));
    setGold((int) ((Math.random() * GOLD_MULTIPLIER) + 20));
    setAge((int) ((Math.random() * AGE_MULTIPLIER) + 18));
  }

  @Override
  public int attack() {
    int damage = (int)((Math.random() * myWeapon.getAttackPower()) + ATTACK_MODIFIER);
    return damage;
  }

  @Override
  public int defend() {
    int defense = (int)((Math.random() * myArmor.getDefenseLevel()) + DEFENSE_MODIFIER);
    return defense;
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
   * @param weaponNumber The number that will be used to select a weapon. Each weapon corresponds with
   *                     one number.
   */
  private void generateWeapon(int weaponNumber) {
    switch (weaponNumber) {
      case 1:
        this.myWeapon = new Weapon("Long Sword", 8);
        break;
      case 2:
        this.myWeapon = new Weapon("Battle Axe", 10);
        break;
      case 3:
        this.myWeapon = new Weapon("Nunchuks", 6);
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
   * Generates armor for the player based on provided integer
   *
   * @param armorNumber The number that will be used to select an armor type. Each armor type corresponds with
   *                     one number.
   *
   */
  private void generateArmor(int armorNumber) {
    switch (armorNumber) {
      case 1:
        this.myArmor = new Armor("Chain Mail", 6);
        break;
      case 2:
        this.myArmor = new Armor("Plate Armor", 8);
        break;
      case 3:
        this.myArmor = new Armor("Mithril Coat", 10);
        break;
      default:
        System.out.println("An unexpected error occurred while choosing armor. Exiting program.");
        System.exit(1);
    }
  }

  /**
   * Selects a random armor type for the player
   */
  public void chooseArmorAutomatically() {
    int randomNumber = ((int) ((Math.random() * 3) + 1));
    generateArmor(randomNumber);
  }

  /**
   * Automatically generate a name for the PlayerCharacter
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
            "\nWeapon: " + myWeapon.getName() +
            "\nArmor: " + myArmor.getName());
  }

  public String getWeaponName() {
    return myWeapon.getName();
  }

  public String getArmorName() {
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
}
