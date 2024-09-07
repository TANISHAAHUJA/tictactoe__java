
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JFrame {
    private int boardWidth = 600;
    private int boardHeight = 650;
    private JButton[][] buttons;
    private String currentPlayer;
    private boolean gameOver;
    private int turnCount;
    private int scoreX;
    private int scoreO;
    
    private JLabel statusLabel;
    private JLabel scoreLabel;
    private JPanel boardPanel;

    public TicTacToe() {
        setTitle("Tic-Tac-Toe ");
        setSize(boardWidth, boardHeight);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        currentPlayer = "X";
        gameOver = false;
        turnCount = 0;
        scoreX = 0;
        scoreO = 0;

        statusLabel = new JLabel("Player X's turn", SwingConstants.CENTER);
        statusLabel.setBackground(Color.white);
        statusLabel.setForeground(Color.pink);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 40));
        statusLabel.setOpaque(true);

        scoreLabel = new JLabel("Player X: 0 | Player O: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(statusLabel, BorderLayout.NORTH);
        topPanel.add(scoreLabel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);

        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(3, 3));
        boardPanel.setBackground(Color.pink);
        buttons = new JButton[3][3];

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                JButton button = new JButton();
                buttons[r][c] = button;
                button.setBackground(Color.white);
                button.setForeground(Color.darkGray);
                button.setFont(new Font("Arial", Font.BOLD, 110));
                button.setFocusable(false);
                button.addActionListener(new ButtonClickListener());
                boardPanel.add(button);
            }
        }

        JButton restartButton = new JButton("Restart Game");
        restartButton.setFont(new Font("Arial", Font.BOLD, 20));
        restartButton.addActionListener(e -> restartGame());

        add(boardPanel, BorderLayout.CENTER);
        add(restartButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (gameOver) return;
            JButton clickedButton = (JButton) e.getSource();
            if (clickedButton.getText().equals("")) {
                clickedButton.setText(currentPlayer);
                turnCount++;
                checkForWinner();
                if (!gameOver) {
                    currentPlayer = currentPlayer.equals("X") ? "O" : "X";
                    statusLabel.setText("Player " + currentPlayer + "'s turn");
                }
            }
        }
    }

    private void checkForWinner() {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (!buttons[i][0].getText().equals("") &&
                buttons[i][0].getText().equals(buttons[i][1].getText()) &&
                buttons[i][1].getText().equals(buttons[i][2].getText())) {
                declareWinner(buttons[i][0]);
                return;
            }
            if (!buttons[0][i].getText().equals("") &&
                buttons[0][i].getText().equals(buttons[1][i].getText()) &&
                buttons[1][i].getText().equals(buttons[2][i].getText())) {
                declareWinner(buttons[0][i]);
                return;
            }
        }

        // Check diagonals
        if (!buttons[0][0].getText().equals("") &&
            buttons[0][0].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][2].getText())) {
            declareWinner(buttons[0][0]);
            return;
        }
        if (!buttons[0][2].getText().equals("") &&
            buttons[0][2].getText().equals(buttons[1][1].getText()) &&
            buttons[1][1].getText().equals(buttons[2][0].getText())) {
            declareWinner(buttons[0][2]);
            return;
        }

        // Check for tie
        if (turnCount == 9) {
            for (int r = 0; r < 3; r++) {
                for (int c = 0; c < 3; c++) {
                    showTie(buttons[r][c]);
                }
            }
            gameOver = true;
        }
    }

    private void declareWinner(JButton winningButton) {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (buttons[r][c].getText().equals(currentPlayer)) {
                    buttons[r][c].setForeground(Color.red);
                    buttons[r][c].setBackground(Color.black);
                }
            }
        }
        statusLabel.setText("Player " + currentPlayer + " wins!");
        if (currentPlayer.equals("X")) {
            scoreX++;
        } else {
            scoreO++;
        }
        updateScore();
        gameOver = true;
    }

    private void showTie(JButton tile) {
        tile.setForeground(Color.blue);
        tile.setBackground(Color.black);
        statusLabel.setText("It's a tie!");
    }

    private void restartGame() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                buttons[r][c].setText("");
                buttons[r][c].setForeground(Color.darkGray);
                buttons[r][c].setBackground(Color.black);
            }
        }
        currentPlayer = "X";
        statusLabel.setText("Player X's turn");
        gameOver = false;
        turnCount = 0;
    }

    private void updateScore() {
        scoreLabel.setText("Player X: " + scoreX + " | Player O: " + scoreO);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TicTacToe::new);
    }
}
