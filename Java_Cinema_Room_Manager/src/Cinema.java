import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int row = scan.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seat = scan.nextInt();
        int price;
        int current = 0;
        int count = 0;

        String[][] cinema = new String[row][seat];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < seat; j++) {
                cinema[i][j] = "S";
            }
        }

        while (true) {
            System.out.print("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit\n");
            int choice = scan.nextInt();
            if (choice == 0) {
                break;
            } else if (choice == 1) {
                display(cinema, row, seat);
            } else if (choice == 3) {
                statistics(count, row, seat, current);
            } else {
                while (true) {
                    System.out.println("\nEnter a row number:");
                    int row1 = scan.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    int seat1 = scan.nextInt();
                    if (row1 > row || seat1 > seat) {
                        System.out.println("Wrong input!");
                    } else if (cinema[row1 - 1][seat1 - 1].equals("B")) {
                        System.out.println("That ticket has already been purchased!");
                    } else {
                        cinema[row1 - 1][seat1 - 1] = "B";
                        if (row * row <= 60 || row1 <= row / 2) {
                            price = 10;
                        } else {
                            price = 8;
                        }
                        count++;
                        current += price;
                        System.out.println("Ticket price: $" + price);
                        break;
                    }
                }
            }
        }
    }

    private static void statistics(int count, int row, int seat, int current) {
        int total;
        System.out.println("Number of purchased tickets: " + count);
        if (row * seat <= 60) {
            total = 10 * row * seat;
        } else {
            total = 10 * (row /2 * seat) + 8 * (row - seat /2) * seat;
        }
        System.out.println("Percentage: " + String.format("%.2f",  (count * 100.0 / (row * seat))) + "%");
        System.out.println("Current income: $" + current);
        System.out.println("Total income: $" + total);
    }

    private static void display(String[][] cinema, int row, int seat) {
        System.out.println("\nCinema:");
        System.out.print("  ");
        for (int i = 1; i < seat + 1; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int j = 0; j < row; j++) {
            System.out.print((j + 1) + " ");
            for (int i = 0; i < seat; i++) {
                System.out.print((cinema[j][i] + " "));
            }
            System.out.println();
        }
    }
}
