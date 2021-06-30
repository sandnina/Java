package Lesson7;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame {

    private int winWidth = 750;
    private int winHeight = 600;
    private int winPositionX = 300;
    private int winPositionY = 200;

    private int minMapSize = 3;
    private int maxMapSize = 10;
    private int minWinLength = 3;

    private JButton btnStart;
    private JButton btnExit;
    private JButton btnClearLog;

    private JPanel panelSettings;
    private JPanel panelButtons;

    private JTextArea gameLog;
    private JScrollPane scrollPanel;

    private JSlider sliderSize;
    private JLabel labelSize;
    private final String sizeLabelText = "Map Size";

    private JSlider sliderWinLength;
    private JLabel labelWInLength;
    private final String winLengthLabelText = "Win Length";

    public GameMap gameMap;
    private int round = 0;

    public Window() {
        setupWindow();
        gameSettings();
        prepareButtons();
        prepareGameSettingsControl();
        prepareGameLogElement();

        gameMap = new GameMap(this);

        panelSettings.add(panelButtons, BorderLayout.NORTH);
        panelSettings.add(scrollPanel, BorderLayout.SOUTH);

        add(panelSettings, BorderLayout.EAST);
        add(gameMap);

        setVisible(true);
    }

    private void setupWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(winWidth, winHeight);
        setLocation(winPositionX, winPositionY);
        setTitle("Tic-tac-toe");
    }

    private void gameSettings() {
        panelSettings = new JPanel();
        panelSettings.setLayout(new GridLayout(2,1));
    }

    private void prepareButtons() {
        btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                collectUserSettings();
            }
        });

        btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        btnClearLog = new JButton("Clear Log");
        btnClearLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameLog.setText("");
            }
        });
    }

    private void prepareGameSettingsControl() {
        panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(10, 1));
        labelSize = new JLabel(sizeLabelText + minMapSize);
        sliderSize = new JSlider(minMapSize, maxMapSize, minMapSize);
        sliderSize.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int currentPosition = sliderSize.getValue();
                labelSize.setText(sizeLabelText + currentPosition);
                sliderWinLength.setMaximum(currentPosition);
            }
        });

        labelWInLength = new JLabel(winLengthLabelText + minWinLength);
        sliderWinLength = new JSlider(minWinLength,  minMapSize, minMapSize);
        sliderWinLength.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelWInLength.setText(winLengthLabelText + sliderWinLength.getValue());
            }
        });

        panelButtons.add(labelSize);
        panelButtons.add(sliderSize);
        panelButtons.add(labelWInLength);
        panelButtons.add(sliderWinLength);
        panelButtons.add(btnStart);
        panelButtons.add(btnExit);
        panelButtons.add(btnClearLog);

    }

    private void prepareGameLogElement() {
        gameLog = new JTextArea();
        scrollPanel = new JScrollPane(gameLog);
        gameLog.setEditable(false);

    }

    void saveLog(String text) {
        gameLog.append(text + "\n");
    }

    private void collectUserSettings() {
        int mapSize = sliderSize.getValue();
        int winLen = sliderWinLength.getValue();
        ++round;
        saveLog("*** Round # " + round + " *****");
        saveLog("Map size is " + mapSize + "x" + mapSize + ". Win Length = " + winLen);
        gameMap.startGame(mapSize, mapSize, winLen);
    }


}
