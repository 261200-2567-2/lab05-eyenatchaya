// Concrete Character: Warrior นักรบ
class Warrior implements Character {
    private String name;
    private int level;
    private int strength = 10;
    private int intelligence = 5;
    private int agility = 7;
    private Accessory equippedAccessory; // เก็บอุปกรณ์ที่ติดตั้ง

    public Warrior(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String useAbility(String abilityName) {
        return "Used " + abilityName + " as a Warrior!";
    }

    public void increaseStrength(int amount) {
        strength += amount;
    }

    public void increaseIntelligence(int amount) {
        intelligence += amount;
    }

    public void increaseAgility(int amount) {
        agility += amount;
    }

    @Override
    public void equipAccessory(Accessory accessory) {
        if (equippedAccessory != null) {
            unequipAccessory(equippedAccessory); // ถ้ามีอุปกรณ์ติดตั้งแล้วให้ถอดก่อน
        }
        equippedAccessory = accessory;
        accessory.applyEffect(this); // ติดตั้งอุปกรณ์ใหม่
    }

    @Override
    public void unequipAccessory(Accessory accessory) {
        if (equippedAccessory == accessory) {
            accessory.removeEffect(this); // ถอดอุปกรณ์ออก
            equippedAccessory = null;
        }
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", strength=" + strength +
                ", intelligence=" + intelligence +
                ", agility=" + agility +
                '}';
    }
}
