import sprint3.Inlamningsuppgift_3.src.Move;
import sprint3.Inlamningsuppgift_3.src.WinCondition;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JPanel masterPanel = new JPanel();
    private JPanel gameBoard = new JPanel();
    private JPanel westPanel = new JPanel();
    private JPanel eastPanel = new JPanel();
    private JPanel northPanel = new JPanel();
    private JPanel southPanel = new JPanel();

    private JButton shuffle = new JButton("Nytt spel");
    private JButton b0 = new JButton("1");
    private JButton b1 = new JButton("2");
    private JButton b2 = new JButton("3");
    private JButton b3 = new JButton("4");
    private JButton b4 = new JButton("5");
    private JButton b5 = new JButton("6");
    private JButton b6 = new JButton("7");
    private JButton b7 = new JButton("8");
    private JButton b8 = new JButton("9");
    private JButton b9 = new JButton("10");
    private JButton b10 = new JButton("11");
    private JButton b11 = new JButton("12");
    private JButton b12 = new JButton("13");
    private JButton b13 = new JButton("14");
    private JButton b14 = new JButton("15");
    private JButton b15 = new JButton("0");

    private JLabel gameStatus = new JLabel("Grattis, du vann!");
    private Timer timer;
    private Color customPurple = new Color(128, 0, 255);
    private Color customOrange = new Color(255, 175, 0);
    private Color[] colors = {customOrange, Color.GREEN, customPurple, Color.MAGENTA};
    private int colorIndexF = 0;
    private int colorIndexB = 2;

    public Main() {

        this.add(masterPanel);
        masterPanel.setLayout(new BorderLayout());

        LineBorder border = new LineBorder(Color.RED, 10);

        b15.setVisible(false);

        gameBoard.setLayout(new GridLayout(4, 4));
        gameBoard.setBackground(Color.RED);
        gameBoard.setBorder(border);
        gameBoard.add(b0);
        gameBoard.add(b1);
        gameBoard.add(b2);
        gameBoard.add(b3);
        gameBoard.add(b4);
        gameBoard.add(b5);
        gameBoard.add(b6);
        gameBoard.add(b7);
        gameBoard.add(b8);
        gameBoard.add(b9);
        gameBoard.add(b10);
        gameBoard.add(b11);
        gameBoard.add(b12);
        gameBoard.add(b13);
        gameBoard.add(b14);
        gameBoard.add(b15);

        westPanel.setPreferredSize(new Dimension(100, 100));
        eastPanel.setPreferredSize(new Dimension(100, 100));
        northPanel.setPreferredSize(new Dimension(100, 100));
        southPanel.setPreferredSize(new Dimension(100, 100));

        westPanel.setBackground(Color.BLACK);
        eastPanel.setBackground(Color.BLACK);
        northPanel.setBackground(Color.BLACK);
        southPanel.setBackground(Color.BLACK);

        northPanel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.anchor = GridBagConstraints.CENTER;

        northPanel.add(shuffle, constraints);

        southPanel.setLayout(new GridBagLayout());

        gameStatus.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        gameStatus.setOpaque(true);
        gameStatus.setVisible(false);
        gameStatus.setForeground(Color.MAGENTA);
        gameStatus.setBackground(Color.GREEN);

        southPanel.add(gameStatus, constraints);

        timer = new Timer(1000, this);

        masterPanel.add(gameBoard, BorderLayout.CENTER);
        masterPanel.add(westPanel, BorderLayout.WEST);
        masterPanel.add(eastPanel, BorderLayout.EAST);
        masterPanel.add(northPanel, BorderLayout.NORTH);
        masterPanel.add(southPanel, BorderLayout.SOUTH);

        b0.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
        b12.addActionListener(this);
        b13.addActionListener(this);
        b14.addActionListener(this);
        b15.addActionListener(this);
        shuffle.addActionListener(this);

        //shuffle.doClick();

        setSize(600, 600);
        //pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private int blankTilePosition = 15;
    private boolean valid;

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == shuffle) {
            gameStatus.setVisible(false);
            int[] array = Shuffle.shuffle();
            int i = 0;
            for (Component component : gameBoard.getComponents()) {
                if (component instanceof JButton) {
                    JButton button = (JButton) component;
                    button.setText(Integer.toString(array[i]));
                    button.setVisible(true);
                    i++;
                }
                timer.stop();
                b15.setVisible(false);
                blankTilePosition = 15;
            }
        } else if (ae.getSource() == timer) {
            gameStatus.setForeground(colors[colorIndexF]);
            gameStatus.setBackground(colors[colorIndexB]);
            colorIndexF = (colorIndexF + 1) % colors.length;
            colorIndexB = (colorIndexB + 1) % colors.length;
        } else {
            if (!timer.isRunning()) {
                valid = Move.validMoveCheck(ae, blankTilePosition);

                if (valid) {
                    blankTilePosition = Move.makeMove(ae, blankTilePosition);
                }
                if (WinCondition.checkIfMet(gameBoard)) {
                    gameStatus.setVisible(true);
                    timer.start();
                }
            }
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
    }
}