/**
 * PlayerCharacter.java
 *
 * PlayerCharacter object that can be used to fight against other knights
 *
 * */
public class PlayerCharacter implements Character {

  private String name = null;
  private int health = 0;
  private int age = 0;
  private int gold = 0;
  private Weapon weapon = Weapon.NOTHING;
  private Armor armor = Armor.NOTHING;
  private int fightOrder = 0;

  /**
    * ctor initializes knight attributes if knight is auto-generated
    */
  public PlayerCharacter() {
    setHealth((int) ((Math.random() * 50) + 50));
    setAge((int) ((Math.random() * 47) + 18));
    setGold((int) ((Math.random() * 1000) + 20));
  }

  /**
   * These are the weapons available to the knights.
   * The number next to the weapon is a damage multiplier. A higher number means "more damage."
   * */
  enum Weapon {
    NOTHING(1, "Nothing"),
    SPEAR(2, "Spear"),
    WAR_HAMMER(3, "War Hammer"),
    LONG_SWORD(4, "Long Sword"),
    BATTLE_AXE(5, "Battle Axe");

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

  /**
   * These are the types of armor available to the knights.
   * The number next to the weapon is the defense multiplier.
   * */
  enum Armor {
    NOTHING(1, "Nothing"),
    LEATHER(2, "Leather"),
    CHAIN_MAIL(3, "Chain mail"),
    PLATE_MAIL(4, "Plate mail"),
    MITHRIL(5, "Mithril");

    private final String mixedCaps_;
    private final int defense_;

    Armor(int defense, String mixedCaps) {
      this.defense_ = defense;
      this.mixedCaps_ = mixedCaps;
    }

    String getMixedCaps() {
      return mixedCaps_;
    }
    public int getDefense() {
      return defense_;
    }
  }

  /**
   * The name list for auto-generated knights
   * */
  enum AutoName {
    SIR_LANCELOT("Sir Lancelot"),
    SIR_ARTHUR("Sir Arthur"),
    SIR_LOIN("Sir Loin"),
    SIR_FRY("Sir Fry"),
    BARON_CRUMPET("Baron Crumpet"),
    SIR_TIFICATE("Sir Tificate"),
    LORD_VADER("Lord Vader"),
    GRAND_ADMIRAL_SNOWFLAKE("Grand Admiral Snowflake");

    private final String mixedCaps_;

    AutoName(String mixedCaps) {
      this.mixedCaps_ = mixedCaps;
    }

    String getMixedCaps() {
      return mixedCaps_;
    }
  }


  //setters
  public void setDamage(int damage) {
    setHealth(getHealth() - damage);
  }





  /**
   *  allow user to select weapon
   **/
  public void setWeapon() {
    int choice = 0;
    do {
      System.out.print("\nNow select your weapon! (Choose number):\n" +
              "1) Long Sword\n" +
              "2) Battle Axe\n" +
              "3) Spear\n" +
              "4) Warhammer\n" +
              "Your choice my liege? : ");
      try {
        choice = input.nextInt();
      } catch (Exception ex) {
        System.out.println("Enter an integer between 1 and 4.\n" + "(" + ex + ")");
      }
    }
    while (choice < 0 || choice > 4);

    switch (choice) {
      case 1:
        setWeapon(Weapon.LONG_SWORD);
        break;

      case 2:
        setWeapon(Weapon.BATTLE_AXE);
        break;

      case 3:
        setWeapon(Weapon.SPEAR);
        break;

      case 4:
        setWeapon(Weapon.WAR_HAMMER);
        break;

      default:
        System.out.println("Error while choosing a weapon. Exiting ...");
        System.exit(1);
    }
  }

  public void setFightOrder(int fightOrder) {
    setFightOrder(fightOrder);
  }

  private void takeMonsterGold(NonPlayerCharacter e) {
    System.out.printf("\n\n%s takes the %s's %d gold coins\n" +
            "and hands them to his accountant.\n", this.getName(), e.getName(), e.getGold());
    this.setGold(this.getGold() + e.getGold());
    System.out.printf("\n%s now has $%d.\n", this.getName(), this.getGold());
  }


  public void generateWeapon() {
    /* auto select a weapon for auto generated knights */
    int choice = ((int) ((Math.random() * 4) + 1));
    switch (choice) {
      case 1:
        setWeapon(Weapon.LONG_SWORD);
        break;

      case 2:
        setWeapon(Weapon.BATTLE_AXE);
        break;

      case 3:
        setWeapon(Weapon.SPEAR);
        break;

      case 4:
        setWeapon(Weapon.WAR_HAMMER);
        break;

      default:
        System.out.print("\nError while choosing auto weapon\n");
        System.exit(1);
    }
  }

  public void setAutoArmor() {
    /* auto select armor for auto generated knights */

    int choice = ((int) ((Math.random() * 4) + 1));
    switch (choice) {
      case 1:
        setArmor(Armor.LEATHER);
        break;

      case 2:
        setArmor(Armor.CHAIN_MAIL);
        break;

      case 3:
        setArmor(Armor.PLATE_MAIL);
        break;

      case 4:
        setArmor(Armor.MITHRIL);
        break;

      default:
        System.out.print("\nError while choosing armor\n");
        System.exit(1);
    }
  }

  public void setAutoName() {
    /* auto select name for auto generated knights */

    int choice = ((int) ((Math.random() * 8) + 1));

    switch (choice) {
      case 1:
        setName(AutoName.SIR_LANCELOT.getMixedCaps());
        break;

      case 2:
        setName(AutoName.BARON_CRUMPET.getMixedCaps());
        break;

      case 3:
        setName(AutoName.SIR_ARTHUR.getMixedCaps());
        break;

      case 4:
        setName(AutoName.SIR_LOIN.getMixedCaps());
        break;

      case 5:
        setName(AutoName.SIR_FRY.getMixedCaps());
        break;

      case 6:
        setName(AutoName.SIR_TIFICATE.getMixedCaps());
        break;

      case 7:
        setName(AutoName.LORD_VADER.getMixedCaps());
        break;

      case 8:
        setName(AutoName.GRAND_ADMIRAL_SNOWFLAKE.getMixedCaps());
        break;

      default:
        System.out.print("\nError while choosing auto name\n");
        System.exit(1);
    }
  }

  public void printStats() {
        /* I used toString() for the name. I could have used toString()
        for the rest, but I used getters because they include some
        formatting to make it look nicer. I hope that's OK  */

    System.out.println("\nPlayerCharacter Name: " + getName());
    System.out.println("PlayerCharacter Health: " + getHealth());
    System.out.println("PlayerCharacter Age: " + getAge());
    System.out.println("PlayerCharacter Gold: $" + getGold());
    System.out.println("PlayerCharacter Weapon: " + getWeapon());
    System.out.println("PlayerCharacter Armor: " + getArmor());
  }

  private String getName() {
    return name;
  }

  private void setName(String name) {
    this.name = name;
  }

  private int getHealth() {
    return health;
  }

  private void setHealth(int health) {
    this.health = health;
  }

  private int getAge() {
    return age;
  }

  private void setAge(int age) {
    this.age = age;
  }

  private int getGold() {
    return gold;
  }

  private void setGold(int gold) {
    this.gold = gold;
  }

  private Weapon getWeapon() {
    return weapon;
  }

  private void setWeapon(Weapon weapon) {
    this.weapon = weapon;
  }

  public Armor getArmor() {
    return armor;
  }

  private void setArmor(Armor armor) {
    this.armor = armor;
  }

  private int getFightOrder() {
    return fightOrder;
  }

  private void setFightOrder(int fightOrder) {
    this.fightOrder = fightOrder;
  }


}


