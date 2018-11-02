import java.util.Scanner;

/**
 * Knight.java
 *
 * Knight object that can be used to fight against other knights
 *
 * */
public class Knight {

  private String name_ = null;
  private int health_ = 0;
  private int numBattles_ = 0;
  private int age_ = 0;
  private int gold_ = 0;
  private Weapon weapon_ = Weapon.NOTHING;
  private Armor armor_ = Armor.NOTHING;
  private int fightOrder_ = 0;

  /**
    * ctor initializes knight attributes if knight is auto-generated
    */
  public Knight() {
    setHealth_((int) ((Math.random() * 50) + 50));
    setNumBattles_((int) ((Math.random() * 10) + 1));
    setAge_((int) ((Math.random() * 47) + 18));
    setGold_((int) ((Math.random() * 1000) + 20));
  }

  private String getName_() {
    return name_;
  }

  private void setName_(String name_) {
    this.name_ = name_;
  }

  private int getHealth_() {
    return health_;
  }

  private void setHealth_(int health_) {
    this.health_ = health_;
  }

  private int getNumBattles_() {
    return numBattles_;
  }

  private void setNumBattles_(int numBattles_) {
    this.numBattles_ = numBattles_;
  }

  private int getAge_() {
    return age_;
  }

  private void setAge_(int age_) {
    this.age_ = age_;
  }

  private int getGold_() {
    return gold_;
  }

  private void setGold_(int gold_) {
    this.gold_ = gold_;
  }

  private Weapon getWeapon_() {
    return weapon_;
  }

  private void setWeapon_(Weapon weapon_) {
    this.weapon_ = weapon_;
  }

  public Armor getArmor_() {
    return armor_;
  }

  private void setArmor_(Armor armor_) {
    this.armor_ = armor_;
  }

  private int getFightOrder_() {
    return fightOrder_;
  }

  private void setFightOrder_(int fightOrder_) {
    this.fightOrder_ = fightOrder_;
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


  private final Scanner input = new Scanner(System.in);

  /**
   * Fight another knight
   * */
  public int fight(Knight k) {
    int modifier = 0;

    System.out.printf("\n%s strikes %s with his %s! ",
            this.getName(), k.getName(), this.getWeapon());
    /*
     * when calculating damage amount include difference in the weapon strength vs opponent armor strength
     * damage is 5-13 hit points +/- the modifier
     */
    modifier = getWeapon_().getPower() - k.getArmor_().getDefense();
    int damage = ((int) ((Math.random() * 8 + modifier + 5)));
    System.out.printf("(DAMAGE: %d)\n", damage);

    // apply damage to opponent
    k.setDamage(damage);

    // check to see if the opponent is dead
    if (k.getHealth() < 0) {
      System.out.printf("\n%s hath been slain by %s!", k.getName(), this.getName());
      return 1;
    }
    return 0;
  }

/**
 * Fight a monster
 */
  public int fight(Enemy e) {

        /* print battle-related messages and call the opponent's
        setDamage() method
         */

    int modifier = 0;

    System.out.printf("\n%s strikes the %s with his %s! ",
            this.getName(), e.getName(), this.getWeapon());

    /*
     * when calculating damage amount include difference in the weapon strength vs opponent armor strength
     * damage is 5-13 hit points +/- the modifier
     */
    modifier = getWeapon_().getPower() - e.defense_;

    int damage = ((int) ((Math.random() * 8 + modifier + 5)));

    System.out.printf("(DAMAGE: %d)\n", damage);

    // apply damage to opponent
    e.takeDamage(damage);

    // check to see if the opponent is dead
    if (e.getHealth() < 0) {
      System.out.printf("\nThe %s hath been slain by %s!", e.getName(), this.getName());
      takeEnemyGold(e);
      return 1;
    }
    return 0;
  }


  //setters
  public void setDamage(int damage) {
    setHealth_(getHealth_() - damage);
  }


  public void setName() {
    System.out.print("Enter the name of your Knight: ");
    setName_(input.nextLine());
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
        setWeapon_(Weapon.LONG_SWORD);
        break;

      case 2:
        setWeapon_(Weapon.BATTLE_AXE);
        break;

      case 3:
        setWeapon_(Weapon.SPEAR);
        break;

      case 4:
        setWeapon_(Weapon.WAR_HAMMER);
        break;

      default:
        System.out.println("Error while choosing a weapon. Exiting ...");
        System.exit(1);
    }
  }

  public void setFightOrder(int fightOrder) {
    setFightOrder_(fightOrder);
  }

  private void takeEnemyGold(Enemy e) {
    System.out.printf("\n\n%s takes the %s's %d gold coins\n" +
            "and hands them to his accountant.\n", this.getName(), e.getName(), e.getGold());
    this.setGold_(this.getGold_() + e.getGold());
    System.out.printf("\n%s now has $%d.\n", this.getName(), this.getGold());
  }


  public void setAutoWeapon() {
    /* auto select a weapon for auto generated knights */
    int choice = ((int) ((Math.random() * 4) + 1));
    switch (choice) {
      case 1:
        setWeapon_(Weapon.LONG_SWORD);
        break;

      case 2:
        setWeapon_(Weapon.BATTLE_AXE);
        break;

      case 3:
        setWeapon_(Weapon.SPEAR);
        break;

      case 4:
        setWeapon_(Weapon.WAR_HAMMER);
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
        setArmor_(Armor.LEATHER);
        break;

      case 2:
        setArmor_(Armor.CHAIN_MAIL);
        break;

      case 3:
        setArmor_(Armor.PLATE_MAIL);
        break;

      case 4:
        setArmor_(Armor.MITHRIL);
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
        setName_(AutoName.SIR_LANCELOT.getMixedCaps());
        break;

      case 2:
        setName_(AutoName.BARON_CRUMPET.getMixedCaps());
        break;

      case 3:
        setName_(AutoName.SIR_ARTHUR.getMixedCaps());
        break;

      case 4:
        setName_(AutoName.SIR_LOIN.getMixedCaps());
        break;

      case 5:
        setName_(AutoName.SIR_FRY.getMixedCaps());
        break;

      case 6:
        setName_(AutoName.SIR_TIFICATE.getMixedCaps());
        break;

      case 7:
        setName_(AutoName.LORD_VADER.getMixedCaps());
        break;

      case 8:
        setName_(AutoName.GRAND_ADMIRAL_SNOWFLAKE.getMixedCaps());
        break;

      default:
        System.out.print("\nError while choosing auto name\n");
        System.exit(1);
    }
  }

  // getters
  public String getName() {
    return this.getName_();
  }

  public int getHealth() {
    return this.getHealth_();
  }

  private int getNumBattles() {
    return this.getNumBattles_();
  }

  private int getAge() {
    return this.getAge_();
  }

  public int getGold() {
    return this.getGold_();
  }

  private String getWeapon() {
    return this.getWeapon_().getMixedCaps();
  }

  private String getArmor() {
    return this.getArmor_().getMixedCaps();
  }

  public int getFightOrder() {
    return getFightOrder_();
  }


  public void printKnightStats() {
        /* I used toString() for the name. I could have used toString()
        for the rest, but I used getters because they include some
        formatting to make it look nicer. I hope that's OK  */

    System.out.println("\nKnight Name: " + getName_());
    System.out.println("Knight Health: " + getHealth());
    System.out.println("Knight Battles: " + getNumBattles());
    System.out.println("Knight Age: " + getAge());
    System.out.println("Knight Gold: $" + getGold());
    System.out.println("Knight Weapon: " + getWeapon());
    System.out.println("Knight Armor: " + getArmor());
  }
}


