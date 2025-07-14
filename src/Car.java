// Система Склада

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item{
    private String name;
    private int amount;

    public Item(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void addAmount(int amount){
        this.amount += amount;
    }

    @Override
    public String toString() {
        return "Название: " + name + " " + "Количетсво: " + amount;
    }
}

class Storage {
    private List<Item> storage = new ArrayList<>();

    public void showItem() {
        if (storage.isEmpty()) {
            System.out.println("Пусто");
        }
        for (Item i : storage) {
            System.out.println(i);
        }
    }

    public void findItem(String name) {
        for (Item i : storage) {
            if (i.getName().equalsIgnoreCase(name)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("Товар не найден");
    }

    public void addItem(String name, int amount) {
        for (Item i : storage) {
            if (i.getName().equalsIgnoreCase(name)) {
                i.addAmount(amount);
            }
        }
        storage.add(new Item(name, amount));
    }

    public static void main(String[] args) {
        Storage storage1 = new Storage();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n    Система управления складом");
            System.out.println("1. Добавить товар");
            System.out.println("2. Показать все товары");
            System.out.println("3. Найти товар");
            System.out.println("4. Выйти");
            System.out.print("Выберите опцию: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите название товара: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите количество: ");
                    int amount = scanner.nextInt();
                    storage1.addItem(name, amount);
                    break;
                case 2:
                    storage1.showItem();
                    break;
                case 3:
                    System.out.print("Введите название товара: ");
                    String searchName = scanner.nextLine();
                    storage1.findItem(searchName);
                    break;
                case 4:
                    System.out.println("Выход из программы");
                    return;
                default:
                    System.out.println("Неверная опция");
            }
        }
    }
}
