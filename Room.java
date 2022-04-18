package cinema;

import java.util.Scanner;

public class Room {
    status currentStatus = status.MENU;
    int rows;
    int cols;
    char[][] roomSeats;

    void sellTicket() {
        Scanner scanner = new Scanner(System.in);
        int pickRow;
        int pickCol;
        while (true) {
            System.out.println(Strings.ENTER_ROW_NUMBER);
            pickRow = scanner.nextInt();
            if (pickRow > 0 && pickRow <= rows) {
                System.out.println(Strings.ENTER_SEAT_NUMBER_IN_ROW);
                pickCol = scanner.nextInt();
                if (pickCol > 0 && pickCol <= rows) {
                    break;
                } else {
                    System.out.println(Strings.WRONG_INPUT);
                }
            } else {
                System.out.println(Strings.WRONG_INPUT);
            }
        }

        if (roomSeats[pickRow - 1][pickCol - 1] != 'B') {
            roomSeats[pickRow - 1][pickCol - 1] = 'B';
            int price;
            if (rows * cols > 60) {
                price = pickRow <= rows / 2 ? 10 : 8;
            } else {
                price = 10;
            }
            System.out.printf(Strings.TICKET_PRICE.toString(), price);
            currentStatus = status.MENU;
        } else {
            System.out.println(Strings.ALREADY_PURCHASED);
        }
    }

    void showCinema(){
        System.out.println(Strings.CINEMA);
        System.out.print("  ");
        for (int j = 1; j <= cols; j++) {
            System.out.print(j);
            if (j != cols) {
                System.out.print(" ");
            }
        }
        System.out.println();
        for (int i = 0; i < rows; i++) {
            int rowNumber = i + 1;
            System.out.print(rowNumber + " ");
            for (int j = 0; j < cols; j++) {
                System.out.print(roomSeats[i][j]);
                if (j != cols) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
        currentStatus = status.MENU;
    }

    void initiateCinema(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(Strings.ENTER_NUMBER_OF_ROWS);
        rows = scanner.nextInt();
        System.out.println(Strings.ENTER_NUMBER_OF_SEATS_IN_ROW);
        cols = scanner.nextInt();
        roomSeats = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                roomSeats[i][j] = 'S';
            }
        }
    }

    void menu(){
        System.out.println(Strings.MENU);
        Scanner scanner = new Scanner(System.in);
        int command = scanner.nextInt();
        switch (command) {
            case 1:
                currentStatus = status.SHOW;
                break;
            case 2:
                currentStatus = status.SELL;
                break;
            case 3:
                currentStatus = status.STATISTIC;
                break;
            case 0:
                currentStatus = status.OFF;
                break;
            default:
                System.out.println(Strings.NO_SUCH_OPTION);
                break;
        }
    }

    int countSoldTickets() {
        int ticksCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (roomSeats[i][j] == 'B') {
                    ticksCount++;
                }
            }
        }
        return ticksCount;
    }

    int countTotalIncome() {
        int income;
        if (rows * cols > 60) {
            income = (rows / 2 * 10 + (rows / 2 + rows % 2) * 8) * cols;
        } else {
            income = rows * cols * 10;
        }
        return income;
    }

    int countIncome() {
        int income;
        if (rows * cols > 60) {
            int price10amount = 0;
            int price8amount = 0;
            for (int i = 0; i < rows / 2; i++) {
                for (int j = 0; j < cols; j++) {
                    if (roomSeats[i][j] == 'B') {
                        price10amount++;
                    }
                }
            }
            for (int i = rows / 2 ; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (roomSeats[i][j] == 'B') {
                        price8amount++;
                    }
                }
            }
            income = price10amount * 10 + price8amount * 8;
        } else {
            int amount = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (roomSeats[i][j] == 'B') {
                        amount++;
                    }
                }
            }
            income = amount * 10;
        }
        return income;
    }

    void showStat() {
        String stat = Strings.STATISTICS.toString();
        int ticketsCount = this.countSoldTickets();
        double ticketPercent = 100f * ticketsCount / (cols * rows);
        int curIncome = countIncome();
        int totalIncome = countTotalIncome();
        stat = String.format(stat, ticketsCount, ticketPercent, curIncome, totalIncome);
        System.out.println(stat);
        currentStatus = status.MENU;
    }
}
