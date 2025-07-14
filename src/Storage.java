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


import java.util.HashMap;
import java.util.Map;


class Storage extends AbstractStorage {
    private Map<String, Item> storage = new HashMap();

    public void addItem(String name, int quantity) {
        if (storage.containsKey(name)) {
            storage.get(name).addAmount(quantity);
        } else {
            storage.put(name, new Item(name, quantity));
        }
    }

    public void findItem(String name) {
        for (String key : storage.keySet()) {
            if (key.equalsIgnoreCase(name)) {
                Item item = storage.get(key);
                System.out.println("Найден: " + item);
                return;
            }
        }
        System.out.println("Товар \"" + name + "\" не найден на складе");
    }


    public void printItems() {
        for (Item item : storage.values()) {
            System.out.println(item);
        }
    }
}
