// Система Склада
/*
По классам раскидать +
добавить абстракцию +
переопределения Хэшкодом и Икуалс +
наследование добавить +
Использовать Мап +
ООП +
Сериализация объектов ?
*/
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.io.Serializable;


class Storage extends AbstractStorage implements Serializable {
    private Map<String, Item> storage = new HashMap<>();

    public void addItem(String name, int quantity) {
        if (storage.containsKey(name.toLowerCase())) {
            storage.get(name.toLowerCase()).addAmount(quantity);
        } else {
            storage.put(name.toLowerCase(), new Item(name, quantity));
        }
    }

    public void findItem(String name) {
        Item item = storage.get(name.toLowerCase());
        if (item != null) {
            System.out.println("Найден: " + item);
        } else {
            System.out.println("Товар \"" + name + "\" не найден на складе");
        }
    }

    public void printItems() {
        if (storage.isEmpty()) {
            System.out.println("Склад пуст");
        } else {
            for (Item item : storage.values()) {
                System.out.println(item);
            }
        }
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(this);
            System.out.println("Склад сохранён в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка сохранения: " + e.getMessage());
        }
    }

    public static Storage loadFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (Storage) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Не удалось загрузить склад: " + e.getMessage());
            return new Storage();
        }
    }
}

