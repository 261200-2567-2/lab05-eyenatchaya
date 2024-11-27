// Concrete Character: Mage
// Mage (นักเวทย์) ที่มีความสามารถในการใช้เวทมนตร์ (Ability) และมีการปรับสเตตัส เช่น Strength, Intelligence, และ Agility
class Mage implements Character {
    private String name;
    private int level;
    private int strength = 3; // พลังในการโจมตี
    private int intelligence = 12; // ใช้เวทมนตร์และเพิ่มพลังในการใช้สกิลหรือมานา
    private int agility = 6; // ความคล่องแคล่วและความเร็วของตัวละคร รวมถึงการหลบหลีกและการโจมตีที่รวดเร็ว
    private Accessory equippedAccessory; // เก็บอุปกรณ์ที่ติดตั้ง

    // นักเวทย์
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

    //  Ability Method
    @Override
    public String useAbility(String abilityName) { // ใช้ความสามารถ (Ability) ของ Mage
        return "Used " + abilityName + " as a Mage!"; //  ถ้าเรียก useAbility("Fireball") ฟังก์ชันจะคืนค่าเป็น "Used Fireball as a Mage!"
    }

    // เพิ่มค่า Strength ให้กับตัวละคร
    // เช่น ถ้า strength = 10 และเรียก increaseStrength(5), strength จะเพิ่มเป็น 15
    public void increaseStrength(int amount) { strength += amount; }

    // เพิ่มค่า Intelligence ให้กับตัวละคร
    public void increaseIntelligence(int amount) {
        intelligence += amount;
    }

    // เพิ่มค่า Agility ให้กับตัวละคร
    public void increaseAgility(int amount) {
        agility += amount;
    }

    @Override
    public void equipAccessory(Accessory accessory) { // ติดตั้งอุปกรณ์ใหม่
        if (equippedAccessory != null) {
            unequipAccessory(equippedAccessory); // ถ้ามีอุปกรณ์ติดตั้งแล้วให้ถอดก่อน
        }
        equippedAccessory = accessory;
        accessory.applyEffect(this); // ติดตั้งอุปกรณ์ใหม่
    }

    // ถอดอุปกรณ์ที่กำลังใช้ออก
    // การถอดอุปกรณ์จะทำการถอดผลกระทบผ่านฟังก์ชัน removeEffect
    @Override
    public void unequipAccessory(Accessory accessory) {
        if (equippedAccessory == accessory) {
            accessory.removeEffect(this); // ถอดอุปกรณ์ออก
            equippedAccessory = null;
        }
    }

    @Override
    public String toString() { // แสดงข้อมูลของตัวละครในรูปแบบของข้อความ
        return "Mage{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", strength=" + strength +
                ", intelligence=" + intelligence +
                ", agility=" + agility +
                '}';
    }
}
