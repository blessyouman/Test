import java.io.Serializable;
import java.util.Objects;

class Item implements Serializable {
    private String name;
    private int amount;

    public Item(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

    @Override
    public String toString() {
        return "Название: " + name + " Количество: " + amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        return name.equalsIgnoreCase(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase());
    }
}
