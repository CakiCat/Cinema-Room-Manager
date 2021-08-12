package cinema;

import java.util.Scanner;

public class Cinema {
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the number of rows:");
        int n = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int m = scanner.nextInt();
        boolean sw = true;
        int countb = 0;

        char[][] cin = new char[n][m];
        for (int i = 0; i < cin.length; i++) {
            for (int j = 0; j < cin[i].length; j++) {
                cin[i][j] = 'S';
            }
        }
        while (sw) {
            printOptions();
            int opt = scanner.nextInt();
            switch (opt) {
                case 1:
                    printCin(cin, n, m);
                    break;
                case 2:
                    buySeat(cin, n, m);
                    break;
                case 3:
                    statistics(cin, n, m);
                    break;
                case 0:
                    sw = false;
                    break;
                default:
                    break;
            }
        }

//        printCin(cin, n , m);
//
//        buySeat(cin, n, m);

    }
    public static void printCin(char[][] cin, int n, int m) {
        System.out.println();
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 0; i < m; i++){
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < cin.length; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < cin[i].length; j++) {
                System.out.print(cin[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static int price(int n,int m,int row) {
        if (n * m > 60) {
            if (row > n / 2) {
                return 8;
            } else {
                return 10;
            }
        } else {
            return 10;
        }

    }
    public static char[][] buySeat(char[][] cin, int n, int m) {
        boolean bla = true;
        while (bla) {
            System.out.println();
            System.out.println("Enter a row number:");
            int row = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int seat = scanner.nextInt();
            System.out.println();

            if (row > n || seat > m ) {
                System.out.println("Wrong input!");
                continue;
            }
            if (cin[row - 1][seat - 1] == 'B') {
                System.out.println("That ticket has already been purchased!");
                continue;
            }

            int price = price(n,m,row);
            System.out.println("Ticket price: $" + price);

            cin[row - 1][seat - 1] = 'B';

//        printCin(cin,n,m);

            bla = false;
        }
        return cin;

    }
    public static void printOptions() {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");

    }
    public static int count(char[][] cin, int n, int m) {
        int count = 0;
        for (int i = 0; i < cin.length; i++) {
            for (int j = 0; j < cin[i].length; j++) {
                if (cin[i][j] == 'B') {
                    count++;
                }
            }
        }
        return count;
    }
    public static void statistics(char[][] cin, int n, int m) {
        int b = count(cin, n, m);
        System.out.println("Number of purchased tickets: " + b);
        if (b == 0) {
            System.out.println("Percentage: 0.00%");
        } else {
            float percentage =  (((float) b /  (n * m)) * 100);

            System.out.println("Percentage: " + String.format("%.2f",percentage) + "%");
        }
        int currentIncome = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if (cin[i][j] == 'B') {
                    if (n * m > 60) {
                        currentIncome += i >= n/2 ? 8 : 10;
                    } else {
                        currentIncome += 10;
                    }

                }
            }
        }
        System.out.println("Current income: $" + currentIncome);
        int totalIncome = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if (n * m > 60) {
                    if (i < n /2) {
                        totalIncome += 10;
                    } else {
                        totalIncome += 8;
                    }
                } else {
                    totalIncome += 10;
                }
            }

        }
        System.out.println("Total income: $" + totalIncome);

    }

}