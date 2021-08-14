package tictactoe;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s11 = " ";
        String s12 = " ";
        String s13 = " ";
        String s21 = " ";
        String s22 = " ";
        String s23 = " ";
        String s31 = " ";
        String s32 = " ";
        String s33 = " ";
        String y;
        String x;
        int cou = 0;
        int em = 9;
        String cell;

        System.out.println("---------");
        System.out.println("| " + s11 + " " + s12 + " " + s13 + " |");
        System.out.println("| " + s21 + " " + s22 + " " + s23 + " |");
        System.out.println("| " + s31 + " " + s32 + " " + s33 + " |");
        System.out.println("---------");

        while (true) {
            String[] ar1 = {s11, s12, s13};
            String[] ar2 = {s21, s22, s23};
            String[] ar3 = {s31, s32, s33};
            String[] ar4 = {s11, s21, s31};
            String[] ar5 = {s12, s22, s32};
            String[] ar6 = {s13, s23, s33};
            String[] ar7 = {s11, s22, s33};
            String[] ar8 = {s13, s22, s31};
            String[] arX = {"X", "X", "X"};
            String[] arO = {"O", "O", "O"};

            boolean winO1 = Arrays.equals(ar1, arO) || Arrays.equals(ar2, arO) || Arrays.equals(ar3, arO) || Arrays.equals(ar4, arO);
            boolean winO2 = Arrays.equals(ar5, arO) || Arrays.equals(ar6, arO) || Arrays.equals(ar7, arO) || Arrays.equals(ar8, arO);
            boolean winX1 = Arrays.equals(ar1, arX) || Arrays.equals(ar2, arX) || Arrays.equals(ar3, arX) || Arrays.equals(ar4, arX);
            boolean winX2 = Arrays.equals(ar5, arX) || Arrays.equals(ar6, arX) || Arrays.equals(ar7, arX) || Arrays.equals(ar8, arX);
            boolean lost = !winO1 && !winO2 && !winX1 && !winX2;

            if (winO1 || winO2) {
                System.out.println("O wins");
                break;
            } else if (winX1 || winX2) {
                System.out.println("X wins");
                break;
            } else if (lost & em == 0) {
                System.out.println("Draw");
                break;
            } else  {
                while (true) {
                    System.out.print("Enter the coordinates: ");
                    y = scanner.next();
                    if (!y.matches("[0-9]")) {
                        System.out.println("You should enter numbers!");
                    } else {
                        x = scanner.next();
                        if (!y.matches("[0-9]") || !x.matches("[0-9]")) {
                            System.out.println("You should enter numbers!");
                        } else if (y.matches("[4-9]") || x.matches("[4-9]") || y.equals("0") || x.equals("0")) {
                            System.out.println("Coordinates should be from 1 to 3!");
                        } else if ((y.equals("1") && x.equals("1") && s11 != " ") || (y.equals("1") && x.equals("2") && s12 != " ") ||
                                (y.equals("1") && x.equals("3") && s13 != " ") || (y.equals("2") && x.equals("1") && s21 != " ") ||
                                (y.equals("2") && x.equals("2") && s22 != " ") || (y.equals("2") && x.equals("3") && s23 != " ") ||
                                (y.equals("3") && x.equals("1") && s31 != " ") || (y.equals("3") && x.equals("2") && s32 != " ") ||
                                (y.equals("3") && x.equals("3") && s33 != " ")) {

                            System.out.println("This cell is occupied! Choose another one!");
                        } else if ((y.equals("1") && x.equals("1") && s11 == " ") || (y.equals("1") && x.equals("2") && s12 == " ") ||
                                (y.equals("1") && x.equals("3") && s13 == " ") || (y.equals("2") && x.equals("1") && s21 == " ") ||
                                (y.equals("2") && x.equals("2") && s22 == " ") || (y.equals("2") && x.equals("3") && s23 == " ") ||
                                (y.equals("3") && x.equals("1") && s31 == " ") || (y.equals("3") && x.equals("2") && s32 == " ") ||
                                (y.equals("3") && x.equals("3") && s33 == " ")) {
                            cou++;
                            em--;
                            break;
                        }
                    }
                }

                if (cou % 2 == 0) {
                    cell = "O";
                } else {
                    cell = "X";
                }

                if (y.equals("1") && x.equals("1")) {
                    s11 = cell;
                } else if (y.equals("1") && x.equals("2")) {
                    s12 = cell;
                } else if (y.equals("1") && x.equals("3")) {
                    s13 = cell;
                } else if (y.equals("2") && x.equals("1")) {
                    s21 = cell;
                } else if (y.equals("2") && x.equals("2")) {
                    s22 = cell;
                } else if (y.equals("2") && x.equals("3")) {
                    s23 = cell;
                } else if (y.equals("3") && x.equals("1")) {
                    s31 = cell;
                } else if (y.equals("3") && x.equals("2")) {
                    s32 = cell;
                } else if (y.equals("3") && x.equals("3")) {
                    s33 = cell;
                }
            }
            System.out.println("---------");
            System.out.println("| " + s11 + " " + s12 + " " + s13 + " |");
            System.out.println("| " + s21 + " " + s22 + " " + s23 + " |");
            System.out.println("| " + s31 + " " + s32 + " " + s33 + " |");
            System.out.println("---------");
        }
    }
}

