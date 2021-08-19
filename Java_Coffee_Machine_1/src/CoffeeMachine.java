import java.util.Objects;
import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String choice1 = scanner.next();
            if (Objects.equals(choice1, "exit")) {
                break;
            } else if (Objects.equals(choice1, "remaining")) {
                display(water, milk, beans, cups, money);
            } else if (Objects.equals(choice1, "take")) {
                System.out.println("I gave you $" + money);
                money = 0;
            } else if (Objects.equals(choice1, "fill")) {
                System.out.println("Write how many ml of water you want to add:");
                water += scanner.nextInt();
                System.out.println("Write how many ml of milk you want to add:");
                milk += scanner.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add:");
                beans += scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee you want to add:");
                cups += scanner.nextInt();
            } else if (Objects.equals(choice1, "buy")) {
                while (true) {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String choice2 = scanner.next();
                    if (Objects.equals(choice2, "back")) {
                        break;
                    } else if (Objects.equals(choice2, "1")) {
                        if (water > 250 && beans > 16 && cups > 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 250;
                            beans -= 16;
                            cups -= 1;
                            money += 4;
                            break;
                        } else if (water < 250) {
                            System.out.println("Sorry, not enough water!");
                            break;
                        } else if (beans < 16) {
                            System.out.println("Sorry, not coffee beans!");
                            break;
                        } else if (cups == 0) {
                            System.out.println("Sorry, not disposable cups!");
                            break;
                        }
                    } else if (Objects.equals(choice2, "2")) {
                        if (water > 350 && milk > 75 && beans > 16 && cups > 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 350;
                            milk -= 75;
                            beans -= 20;
                            cups -= 1;
                            money += 7;
                            break;
                        } else if (water < 350) {
                            System.out.println("Sorry, not enough water!");
                            break;
                        } else if (milk < 75) {
                            System.out.println("Sorry, not enough milk!");
                            break;
                        } else if (beans < 20) {
                            System.out.println("Sorry, not coffee beans!");
                            break;
                        } else if (cups == 0) {
                            System.out.println("Sorry, not disposable cups!");
                            break;
                        }
                    } else if (Objects.equals(choice2, "3")) {
                        if (water > 200 && milk > 100 && beans > 12 && cups > 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 200;
                            milk -= 100;
                            beans -= 12;
                            cups -= 1;
                            money += 6;
                            break;
                        } else if (water < 200) {
                            System.out.println("Sorry, not enough water!");
                            break;
                        } else if (milk < 100) {
                            System.out.println("Sorry, not enough milk!");
                            break;
                        } else if (beans < 12) {
                            System.out.println("Sorry, not coffee beans!");
                            break;
                        } else if (cups == 0) {
                            System.out.println("Sorry, not disposable cups!");
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void display(int water, int milk, int beans, int cups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }
}

