// Interface for RPG Characters
interface Character {
    String getName();
    int getLevel();
    String useAbility(String abilityName);
    void equipAccessory(Accessory accessory); // ติดตั้งหรือใส่อุปกรณ์ให้กับตัวละคร โดยจะเพิ่มอุปกรณ์เข้าไปในรายการอุปกรณ์ที่ตัวละครสามารถใช้ได้
    void unequipAccessory(Accessory accessory); // ถอดอุปกรณ์ออกจากตัวละคร จะทำการลบอุปกรณ์ออกจากรายการอุปกรณ์และลบผลกระทบที่เกิดขึ้นจากการสวมใส่อุปกรณ์นั้น
    int getEnergy();
}
