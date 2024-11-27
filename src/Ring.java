// Concrete Accessory: Ring
class Ring implements Accessory {
    private String name;
    private int strengthBonus; // โบนัสเพิ่มให้กับ Strength ของตัวละคร
    private int intelligenceBonus; // โบนัสที่เพิ่มให้กับ Intelligence ของตัวละคร

    public Ring(String name, int strengthBonus, int intelligenceBonus) {
        this.name = name;
        this.strengthBonus = strengthBonus;
        this.intelligenceBonus = intelligenceBonus;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void applyEffect(Character character) {
        if (character instanceof Warrior) { // จะตรวจสอบว่า character เป็นอ็อบเจ็กต์ของคลาส Warrior หรือไม่
            ((Warrior) character).increaseStrength(strengthBonus); // หากตัวละครเป็น Warrior แหวนจะเพิ่ม strength โดยการเรียกฟังก์ชัน increaseStrength จะเพิ่มค่า strengthBonus ให้กับตัวละคร
        } else if (character instanceof Mage) {
            ((Mage) character).increaseIntelligence(intelligenceBonus); // หากตัวละครเป็น Mage แหวนจะเพิ่ม intelligence โดยการเรียก increaseIntelligence ซึ่งจะเพิ่มค่า intelligenceBonus ให้กับตัวละคร
        }
    }

    @Override
    public void removeEffect(Character character) { // ยกเลิกผลของแหวนเมื่อถูกถอดออกจากตัวละคร
        if (character instanceof Warrior) {
            ((Warrior) character).increaseStrength(-strengthBonus);
        } else if (character instanceof Mage) {
            ((Mage) character).increaseIntelligence(-intelligenceBonus);
        }
    }
    // หากตัวละครเป็น Warrior ฟังก์ชันจะลดค่า strength โดยการเรียก increaseStrength(-strengthBonus) ซึ่งจะทำการลบค่าพลังโจมตีที่เพิ่มขึ้น
    // หากตัวละครเป็น Mage ฟังก์ชันจะลดค่า intelligence โดยการเรียก increaseIntelligence(-intelligenceBonus) ซึ่งจะทำการลบค่าปัญญาที่เพิ่มขึ้น
}

 // * instanceof ถูกใช้เพื่อตรวจสอบว่าอ็อบเจ็กต์ character เป็นอินสแตนซ์ของคลาส Warrior หรือ Mage หรือไม่