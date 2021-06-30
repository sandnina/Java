package Lesson7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class GameMap extends JPanel {

    private static int[][] map;
    private int mapSizeX;
    private int mapSizeY;
    private int winLength;

    private Window window;

    private int cellWidth;
    private int cellHeight;

    private static int playerMe = 1;
    private static int playerComp = 2;
    private static int emptyField = 0;

    private final int stateMeWin = 1;
    private String msgMeWin = "Ты выиграл";
    private final int stateCompWin = 2;
    private String msgCompWin = "Выиграл компьютер";
    private final int stateDraw = 0;
    private String msgDraw = "Ничья";

    private boolean isExistMap;
    private boolean isGameOver;

    public static Random random = new Random();

    public GameMap(Window window) {
        this.window = window;
        setBackground(new Color(4, 8, 23));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent mouseObject) {
                super.mouseReleased(mouseObject);
                update(mouseObject);
            }
        });

        isExistMap = false;
    }

    void startGame(int mapSizeX, int mapSizeY, int winLength) {
        this.mapSizeX = mapSizeX;
        this.mapSizeY = mapSizeY;
        this.winLength = winLength;
        map = new int[mapSizeY][mapSizeX];
        this.isExistMap = true;
        this.isGameOver = false;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    private void render (Graphics g) {
        if (!isExistMap) {
            return;
        }
        createMap(g);

        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x <mapSizeX; x++) {
                if (isEmptyField(x, y)) {
                    continue;
                }

                if (map[y][x] == playerMe) {
                    g.setColor(Color.MAGENTA);
                    g.fillOval(x*cellWidth, y*cellHeight, cellWidth, cellHeight);
                }
                if (map[y][x] == playerComp) {
                    g.setColor(Color.GREEN);
                    g.fillRect(x*cellWidth, y*cellHeight, cellWidth, cellHeight);
                }

            }
            
        }
        if (isGameOver) {
            return;
        }
    }

    private void update(MouseEvent mouseObject) {
        if (!isExistMap) {
            return;
        }
        if(isGameOver) {
            return;
        }

        int cellX = mouseObject.getX() / cellWidth;
        int cellY = mouseObject.getY() / cellHeight;

        if (!isValidField(cellX, cellY) || !isEmptyField(cellX, cellY)) {
            return;
        }
        map[cellY][cellX] = playerMe;
        window.saveLog("Мой ход [" + (cellY + 1) + ":" + (cellX + 1) + "]");

        if (isWin(playerMe)) {
            setGameOver(stateMeWin);
            return;

        }
        if (isDraw()) {
            setGameOver(stateDraw);
            return;

        }
        turnPlayerComp();
        repaint();

        if (isWin(playerComp)) {
            setGameOver(stateCompWin);
            return;
                   }

        if (isDraw()) {
            setGameOver(stateDraw);
            return;
                    }
    }

    private void setGameOver(int stateGameOverPlayer) {
        repaint();
        this.isGameOver = true;
        showGameOverMessage(stateGameOverPlayer);
    }

    private void showGameOverMessage(int state) {
        switch (state) {
            case stateMeWin:
                window.saveLog(msgMeWin);
                JOptionPane.showMessageDialog(this, msgMeWin);
                break;
            case stateCompWin:
                window.saveLog(msgCompWin);
                JOptionPane.showMessageDialog(this, msgCompWin);
                break;
            case stateDraw:
                window.saveLog(msgDraw);
                JOptionPane.showMessageDialog(this, msgDraw);
                break;
            default:
                JOptionPane.showMessageDialog(this, "Error");
        }
    }

    private void createMap(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        cellWidth = width / mapSizeX;
        cellHeight = height / mapSizeY;

        g.setColor(Color.YELLOW);

        for (int i = 0; i <= mapSizeY; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, width, y);
        }

        for (int i = 0; i < mapSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, height);
        }
    }

    private void turnPlayerComp() {
//        if (turnCompWin()) {
//            return;
//        }
//        if (turnMeWin()) {
//
//        }
        int x;
        int y;
        do {
            x = random.nextInt(mapSizeX);
            y = random.nextInt(mapSizeY);
        }
        while (!isEmptyField(y, x));
        map[x][y] = playerComp;
        window.saveLog("Ход компьютера [" + (x + 1) + ":" + (y + 1) + "]");

    }

    private boolean turnCompWin() {
        for (int i = 0; i < mapSizeY; i++) {
            for (int j = 0; j < mapSizeX; j++) {
                if (isEmptyField(j, i)) {
                    map[i][j] = playerComp;
                    if (isWin(playerComp)) {
                        return true;
                    }
                    map[i][j] = emptyField;
                }
            }
        }
        return false;
    }

    private boolean turnMeWin() {
        for (int i = 0; i < mapSizeY; i++) {
            for (int j = 0; j < mapSizeX; j++) {
                if (isEmptyField(j, i)) {
                    map[i][j] = playerMe;
                    if (isWin(playerMe)) {
                        map[i][j] = playerComp;
                        return true;
                    }
                    map[i][j] = emptyField;
                }
            }
        }
        return false;
    }

    public static boolean isWin(int player) {

        if (map[0][0] == player && map[0][1] == player && map[0][2] == player) return true;
        if (map[1][0] == player && map[1][1] == player && map[1][2] == player) return true;
        if (map[2][0] == player && map[2][1] == player && map[2][2] == player) return true;

        if (map[0][0] == player && map[1][0] == player && map[2][0] == player) return true;
        if (map[0][1] == player && map[1][1] == player && map[2][1] == player) return true;
        if (map[0][2] == player && map[1][2] == player && map[2][2] == player) return true;

        if (map[0][0] == player && map[1][1] == player && map[2][2] == player) return true;
        if (map[0][2] == player && map[1][1] == player && map[2][0] == player) return true;

        return false;
    }
    private boolean isDraw() {
        for (int y = 0; y < mapSizeY; y++) {
            for (int x = 0; x < mapSizeX; x++) {
                if (map[y][x] == emptyField) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isEmptyField(int x, int y) {
        return map[y][x] == emptyField;
    }

    private boolean isValidField(int x, int y) {
        return x >= 0 && x < mapSizeX && y >= 0 && y < mapSizeY;
    }
}