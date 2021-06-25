package StepDef;

public enum Sorts {
    По_умолчанию(101),
    Дешевле(1),
    Дороже(2),
    По_дате(104);
    private int value;

    Sorts(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
