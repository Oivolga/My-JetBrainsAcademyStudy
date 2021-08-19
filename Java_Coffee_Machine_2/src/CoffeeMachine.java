import java.util.Scanner;

public class CoffeeMachine {
    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int disposableCups = 9;
    private static int cash = 550;

    final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            String string = scanner.next();

            if (string.equals("buy")) {
                buyCoffeeTypes();
            } else if (string.equals("fill")) {
                fillMachine();
            } else if (string.equals("take")) {
                take();
            } else if (string.equals("remaining")) {
                remaining();
            } else if (string.equals("exit")) {
                break;
            }
        }
    }

    public static void take() {
        System.out.printf("I gave you $%d\n", cash);
        cash = 0;
    }

    public static void fillMachine() {
        System.out.println("Write how many ml of water do you want to add: ");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        coffeeBeans += scanner.nextInt();
        System.out.println("Write how disposable cups of coffee do you want to add: ");
        disposableCups += scanner.nextInt();
    }

    public static void buyCoffeeTypes() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        try {
            int coffeeType = scanner.nextInt();

            if (coffeeType == 1) {
                buyCoffee(250, 0, 16, 4);
            } else if (coffeeType == 2) {
                buyCoffee(350, 75, 20, 7);
            } else if (coffeeType == 3) {
                buyCoffee(200, 100, 12, 6);
            } else {
                return;
            }
        } catch (Exception e) {
            return;
        }
    }

    public static void buyCoffee(int w, int m, int cb, int ca) {
        if (w <= water && m <= milk && cb <= coffeeBeans) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= w;
            milk -= m;
            coffeeBeans -= cb;
            cash += ca;
            disposableCups -= 1;
        } else if (w > water) {
            System.out.println("Sorry, not enough water!");
        } else if (m > milk) {
            System.out.println("Sorry, not enough milk!");
        } else if (cb > coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
        }
    }

    public static void remaining() {
        System.out.printf("The coffee machine has:\n" +
                "%d of water\n" +
                "%d of milk\n" +
                "%d of coffee beans\n" +
                "%d of disposable cups\n" +
                "$%d of money\n\n", water, milk, coffeeBeans, disposableCups, cash);
    }
}
