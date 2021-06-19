package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class OnlineGame {

    public static char[][] board;
    public static int boardWidht;
    public static int boardHeight;
    public static int winLenght = 3;

    public static char playerMe = 'X';
    public static char playerComp = '0';
    public static char emptyField = '_';

    public static Scanner pencil = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        makeBoard();
        showBoard();
        while (true) {
            turnPlayerMe();
            showBoard();
            if (isWin(playerMe)) {
                System.out.println("Я выиграл!");
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }

            turnPlayerComp();
            showBoard();

            if (isWin(playerComp)) {
                System.out.println("Выиграл компьютер :(");
                break;
            }
            if (isDraw()) {
                System.out.println("Ничья!");
                break;
            }
        }
    }

    public static void makeBoard() {
        boardHeight = 3;
        boardWidht = 3;
        board = new char[boardHeight][boardWidht];
        for (int y = 0; y < boardHeight; y++) {
            for (int x = 0; x < boardWidht; x++) {
                board[y][x] = emptyField;
            }
        }
    }

    public static void showBoard() {
        for (int y = 0; y < boardHeight; y++) {
            System.out.print("|");
            for (int x = 0; x < boardWidht; x++) {
                System.out.print(board[y][x] + "|");
            }
            System.out.println();
        }
    }

    public static void turnPlayerMe() {
        int x;
        int y;
        do {
            System.out.print("Введите координаты: ");
            x = pencil.nextInt() - 1;
            y = pencil.nextInt() - 1;
        } while (!isValidField(y, x) || !isEmptyField(y, x));
        board[x][y] = playerMe;
            System.out.println("Мой ход [" + (x + 1) + ":" + (y + 1) + "]");
        }

    public static boolean isEmptyField(int x, int y) {
        return board[y][x] == emptyField;
    }

    public static boolean isValidField(int x, int y) {
        return x >= 0 && x < boardWidht && y >= 0 && y < boardHeight;
    }

    public static void turnPlayerComp() {
        if (turnCompWin()) {
            return;
        }
        if (turnMeWin()) {

        }
        int x;
        int y;
        do {
            x = random.nextInt(boardHeight);
            y = random.nextInt(boardHeight);
        }
            while (!isEmptyField(y, x));
            board[x][y] = playerComp;
        System.out.println("Ход компьютера [" + (x + 1) + ":" + (y + 1) + "]");

    }

    public static boolean turnCompWin() {
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidht; j++) {
                if (isEmptyField(j,i)) {
                    board[i][j] = playerComp;
                    if (isWin(playerComp)) {
                        return true;
                    }
                    board[i][j] = emptyField;
                }
            }
        }
        return false;
    }

    public static boolean turnMeWin() {
        for (int i = 0; i < boardHeight; i++) {
            for (int j = 0; j < boardWidht; j++) {
                if (isEmptyField(j,i)) {
                    board[i][j] = playerMe;
                    /*if (isWin(playerMe)) {
                        board[i][j] = playerComp;
                        return true;
                    }*/
                    board[i][j] = emptyField;
                }
            }
        }
        return false;
    }

    public static boolean isDraw() {
        for (int y = 0; y < boardHeight; y++) {
            for (int x = 0; x < boardWidht; x++) {
                if (board[y][x] == emptyField) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isWin (char player) {
        for (int i = 0; i < boardWidht; i++) {
            for (int j = 0; j < boardHeight; j++) {
                if (checkLine(i, j, 1, 0, winLenght, player)) {
                    return true;
                }
                if (checkLine(i, j, 1, 1, winLenght, player)) {
                    return true;
                }
                if (checkLine(i, j, 0, 1, winLenght, player)) {
                    return true;
                }
                if (checkLine(i, j, 0, -1, winLenght, player)) {
                    return true;
                }

            }

            //if (board[0][0] == player && board[0][1] == player && board[0][2] == player) return true;
            //if (board[1][0] == player && board[1][1] == player && board[1][2] == player) return true;
            //if (board[2][0] == player && board[2][1] == player && board[2][2] == player) return true;

            //if (board[0][0] == player && board[1][0] == player && board[2][0] == player) return true;
            //if (board[0][1] == player && board[1][1] == player && board[2][1] == player) return true;
            //if (board[0][2] == player && board[1][2] == player && board[2][2] == player) return true;

            //if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
            //if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;


        }
        return false;
    }


    public static boolean checkLine (int x, int y, int vx, int vy, int len, int player) {
        final int farX = x + (len - 1) * vx;
        final int farY = y + (len - 1) * vy;
        if (!isValidField(farX, farY)) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            if (board[y + i * vy][x + i * vx] != player) {
                return false;
            }
        }
        return true;
    }
}
