// Concrete Character: Mage
class Mage implements Character {
    private String name;
    private int level;
    private int strength = 3; // พลังโจมตี
    private int intelligence = 12; // พลังเวทมนตร์
    private int agility = 6; // ความเร็วและการหลบหลีก
    private int energy = 100; // พลังงาน
    private Accessory equippedAccessory; // อุปกรณ์ที่ติดตั้ง

    // Constructor
    public Mage(String name, int level) {
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

    // ใช้ Ability โดยลดพลังงาน
    @Override
    public String useAbility(String abilityName) {
        int energyCost = 10; // พลังงานที่ใช้
        if (energy >= energyCost) {
            energy -= energyCost;
            return name + " casts " + abilityName + " as a Mage!";
        }
        return name + " doesn't have enough energy to cast " + abilityName + "!";
    }

    // ลดพลังงาน
    public void reduceEnergy(int amount) {
        energy = Math.max(0, energy - amount);
    }

    // เพิ่มพลังงาน
    public void increaseEnergy(int amount) {
        energy = Math.min(100, energy + amount);
    }

    // ฟื้นฟูพลังงาน
    public void regenerateEnergy() {
        increaseEnergy(5); // ฟื้นฟู 5 หน่วย
    }

    @Override
    public int getEnergy() {
        return energy; // คืนค่าพลังงาน
    }

    // ปรับค่าความสามารถพื้นฐาน
    public void increaseStrength(int amount) { strength += amount; }
    public void increaseIntelligence(int amount) { intelligence += amount; }
    public void increaseAgility(int amount) { agility += amount; }

    @Override
    public void equipAccessory(Accessory accessory) {
        if (equippedAccessory != null) {
            unequipAccessory(equippedAccessory); // ถอดอุปกรณ์ที่ติดตั้งอยู่
        }
        equippedAccessory = accessory;
        accessory.applyEffect(this); // ใช้ผลของอุปกรณ์ใหม่
    }

    @Override
    public void unequipAccessory(Accessory accessory) {
        if (equippedAccessory == accessory) {
            accessory.removeEffect(this); // ถอดผลกระทบของอุปกรณ์
            equippedAccessory = null;
        }
    }

    @Override
    public String toString() {
        return String.format(
                "Mage{name='%s', level=%d, strength=%d, intelligence=%d, agility=%d, energy=%d}",
                name, level, strength, intelligence, agility, energy
        );
    }
}
