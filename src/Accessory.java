// Interface for Accessories
interface Accessory {
    String getName();
    void applyEffect(Character character); // เพิ่ม effect ให้กับ Character เพิ่มค่าความสามารถ (attributes) เช่น เพิ่ม Strength, Agility หรือ Intelligence
    void removeEffect(Character character); // ถูกใช้เมื่อ Accessory ถูกถอดออกจาก Character จะเอา effect ที่เกิดจากการใส่อุปกรณ์นั้นๆออก โดยการลดหรือย้อนกลับการเปลี่ยนแปลงที่เกิดขึ้นกับ Character
}
