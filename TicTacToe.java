import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class TicTacToe {

	private JFrame frmTicTacToe;
	private JButton btnNewButton_0_0, btnNewButton_0_1, btnNewButton_0_2, btnNewButton_1_0, btnNewButton_1_1,
			btnNewButton_1_2, btnNewButton_2_0, btnNewButton_2_1, btnNewButton_2_2, btnNewButton_PlayAgain;
	JLabel lblPlayerWon;
	private int flag = 0, count = 0;
	private static int[][] arr = new int[9][9];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			Arrays.fill(arr[i], -1);
		}

		/*
		 * for(int i=0;i<3;i++) { for(int j=0;j<3;j++) { System.out.print(arr[i][j] +
		 * " "); } System.out.println(); }
		 */

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToe window = new TicTacToe();
					window.frmTicTacToe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Check whether straight line is formed or not
	 */
	private boolean checkLine(int[][] arr) {

		if (arr[1][1] != -1) {
			int a = 1, b = 1;

			for (int i = 1; i >= 0; i--) {
				for (int j = 1; j > -2; j--) {
					if (i == 0 && j == 0) {
						break;
					}
					if (arr[a][b] == arr[a - i][b - j] && arr[a + i][b + j] == arr[a][b]) {
//						System.out.println("" + i + j);
						return true;
					}
				}
			}
		}

		if (arr[0][0] != -1) {
			if (arr[0][0] == arr[0][1] && arr[0][0] == arr[0][2]) {
				return true;
			} else if (arr[0][0] == arr[1][0] && arr[0][0] == arr[2][0]) {
				return true;
			}
		}

		if (arr[2][2] != -1) {
			if (arr[2][2] == arr[1][2] && arr[2][2] == arr[0][2]) {
				return true;
			} else if (arr[2][2] == arr[2][1] && arr[2][2] == arr[2][0]) {
				return true;
			}
		}

		return false;
	}

	public void checkWin() {
		if (checkLine(arr)) {
			if (flag == 0) {
				System.out.println("Player 2 won");
				lblPlayerWon.setText("Player 2 Won!!");
			} else {
				System.out.println("Player 1 won");
				lblPlayerWon.setText("Player 1 Won!!");
			}

			/*
			 * for(int i=0;i<3;i++) { for(int j=0;j<3;j++) { System.out.print(arr[i][j] +
			 * " "); } System.out.println(); }
			 */

			btnNewButton_PlayAgain.setVisible(true);

		} else if (count == 9) {
			lblPlayerWon.setText("Its Draw!!!");
			btnNewButton_PlayAgain.setVisible(true);
		}
	}

	/**
	 * Create the application.
	 */
	public TicTacToe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTicTacToe = new JFrame();
		frmTicTacToe.setTitle("Tic Tac Toe");
		frmTicTacToe.setBounds(100, 100, 527, 673);
		frmTicTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTicTacToe.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Tic Tac Toe");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("DialogInput", Font.BOLD, 42));
		lblNewLabel.setBounds(128, 20, 282, 89);
		frmTicTacToe.getContentPane().add(lblNewLabel);

		btnNewButton_0_0 = new JButton();
		btnNewButton_0_0.setBackground(new Color(153, 204, 255));
		btnNewButton_0_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_0_0.getText() != "O" && btnNewButton_0_0.getText() != "X") {
					if (flag == 0) {
						btnNewButton_0_0.setText("O");
						flag = 1;
						arr[0][0] = 0;
					} else {
						btnNewButton_0_0.setText("X");
						flag = 0;
						arr[0][0] = 1;
					}

					count++;
					checkWin();
				}
			}
		});
		btnNewButton_0_0.setFont(new Font("Brush Script MT", Font.PLAIN, 85));
		btnNewButton_0_0.setBounds(110, 148, 100, 100);
		frmTicTacToe.getContentPane().add(btnNewButton_0_0);

		btnNewButton_0_1 = new JButton("");
		btnNewButton_0_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_0_1.getText() != "O" && btnNewButton_0_1.getText() != "X") {
					if (flag == 0) {
						btnNewButton_0_1.setText("O");
						flag = 1;
						arr[0][1] = 0;
					} else {
						btnNewButton_0_1.setText("X");
						flag = 0;
						arr[0][1] = 1;
					}

					count++;
					checkWin();
				}
			}
		});
		btnNewButton_0_1.setBackground(new Color(153, 204, 255));
		btnNewButton_0_1.setFont(new Font("Brush Script MT", Font.PLAIN, 85));
		btnNewButton_0_1.setBounds(220, 148, 100, 100);
		frmTicTacToe.getContentPane().add(btnNewButton_0_1);

		btnNewButton_0_2 = new JButton("");
		btnNewButton_0_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_0_2.getText() != "O" && btnNewButton_0_2.getText() != "X") {
					if (flag == 0) {
						btnNewButton_0_2.setText("O");
						flag = 1;
						arr[0][2] = 0;
					} else {
						btnNewButton_0_2.setText("X");
						flag = 0;
						arr[0][2] = 1;
					}

					count++;
					checkWin();
				}
			}
		});
		btnNewButton_0_2.setBackground(new Color(153, 204, 255));
		btnNewButton_0_2.setFont(new Font("Brush Script MT", Font.PLAIN, 85));
		btnNewButton_0_2.setBounds(330, 148, 100, 100);
		frmTicTacToe.getContentPane().add(btnNewButton_0_2);

		btnNewButton_1_0 = new JButton("");
		btnNewButton_1_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_1_0.getText() != "O" && btnNewButton_1_0.getText() != "X") {
					if (flag == 0) {
						btnNewButton_1_0.setText("O");
						flag = 1;
						arr[1][0] = 0;
					} else {
						btnNewButton_1_0.setText("X");
						flag = 0;
						arr[1][0] = 1;
					}

					count++;
					checkWin();
				}
			}
		});
		btnNewButton_1_0.setBackground(new Color(153, 204, 255));
		btnNewButton_1_0.setFont(new Font("Brush Script MT", Font.PLAIN, 85));
		btnNewButton_1_0.setBounds(110, 258, 100, 100);
		frmTicTacToe.getContentPane().add(btnNewButton_1_0);

		btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_1_1.getText() != "O" && btnNewButton_1_1.getText() != "X") {
					if (flag == 0) {
						btnNewButton_1_1.setText("O");
						flag = 1;
						arr[1][1] = 0;
					} else {
						btnNewButton_1_1.setText("X");
						flag = 0;
						arr[1][1] = 1;
					}

					count++;
					checkWin();
				}
			}
		});
		btnNewButton_1_1.setBackground(new Color(153, 204, 255));
		btnNewButton_1_1.setFont(new Font("Brush Script MT", Font.PLAIN, 85));
		btnNewButton_1_1.setBounds(220, 258, 100, 100);
		frmTicTacToe.getContentPane().add(btnNewButton_1_1);

		btnNewButton_1_2 = new JButton("");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_1_2.getText() != "O" && btnNewButton_1_2.getText() != "X") {
					if (flag == 0) {
						btnNewButton_1_2.setText("O");
						flag = 1;
						arr[1][2] = 0;
					} else {
						btnNewButton_1_2.setText("X");
						flag = 0;
						arr[1][2] = 1;
					}

					count++;
					checkWin();
				}
			}
		});
		btnNewButton_1_2.setBackground(new Color(153, 204, 255));
		btnNewButton_1_2.setFont(new Font("Brush Script MT", Font.PLAIN, 85));
		btnNewButton_1_2.setBounds(330, 258, 100, 100);
		frmTicTacToe.getContentPane().add(btnNewButton_1_2);

		btnNewButton_2_0 = new JButton("");
		btnNewButton_2_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_2_0.getText() != "O" && btnNewButton_2_0.getText() != "X") {
					if (flag == 0) {
						btnNewButton_2_0.setText("O");
						flag = 1;
						arr[2][0] = 0;
					} else {
						btnNewButton_2_0.setText("X");
						flag = 0;
						arr[2][0] = 1;
					}

					count++;
					checkWin();
				}
			}
		});
		btnNewButton_2_0.setBackground(new Color(153, 204, 255));
		btnNewButton_2_0.setFont(new Font("Brush Script MT", Font.PLAIN, 85));
		btnNewButton_2_0.setBounds(110, 368, 100, 100);
		frmTicTacToe.getContentPane().add(btnNewButton_2_0);

		btnNewButton_2_1 = new JButton("");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_2_1.getText() != "O" && btnNewButton_2_1.getText() != "X") {
					if (flag == 0) {
						btnNewButton_2_1.setText("O");
						flag = 1;
						arr[2][1] = 0;
					} else {
						btnNewButton_2_1.setText("X");
						flag = 0;
						arr[2][1] = 1;
					}

					count++;
					checkWin();
				}
			}
		});
		btnNewButton_2_1.setBackground(new Color(153, 204, 255));
		btnNewButton_2_1.setFont(new Font("Brush Script MT", Font.PLAIN, 85));
		btnNewButton_2_1.setBounds(220, 368, 100, 100);
		frmTicTacToe.getContentPane().add(btnNewButton_2_1);

		btnNewButton_2_2 = new JButton("");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNewButton_2_2.getText() != "O" && btnNewButton_2_2.getText() != "X") {
					if (flag == 0) {
						btnNewButton_2_2.setText("O");
						flag = 1;
						arr[2][2] = 0;
					} else {
						btnNewButton_2_2.setText("X");
						flag = 0;
						arr[2][2] = 1;
					}

					count++;
					checkWin();
				}
			}
		});
		btnNewButton_2_2.setBackground(new Color(153, 204, 255));
		btnNewButton_2_2.setFont(new Font("Brush Script MT", Font.PLAIN, 85));
		btnNewButton_2_2.setBounds(330, 368, 100, 100);
		frmTicTacToe.getContentPane().add(btnNewButton_2_2);

		lblPlayerWon = new JLabel("");
		lblPlayerWon.setForeground(Color.MAGENTA);
		lblPlayerWon.setFont(new Font("Brush Script MT", Font.BOLD | Font.ITALIC, 35));
		lblPlayerWon.setBounds(176, 492, 201, 49);
		frmTicTacToe.getContentPane().add(lblPlayerWon);

		btnNewButton_PlayAgain = new JButton("Play Again");
		btnNewButton_PlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RestartableTask();
			}
		});
		btnNewButton_PlayAgain.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNewButton_PlayAgain.setFont(new Font("Brush Script MT", Font.PLAIN, 20));
		btnNewButton_PlayAgain.setBackground(Color.ORANGE);
		btnNewButton_PlayAgain.setBounds(207, 551, 121, 44);
		btnNewButton_PlayAgain.setVisible(false);
		frmTicTacToe.getContentPane().add(btnNewButton_PlayAgain);
	}

	public void RestartableTask() {
		btnNewButton_0_0.setText(null);
		btnNewButton_0_1.setText(null);
		btnNewButton_0_2.setText(null);
		btnNewButton_1_0.setText(null);
		btnNewButton_1_1.setText(null);
		btnNewButton_1_2.setText(null);
		btnNewButton_2_0.setText(null);
		btnNewButton_2_1.setText(null);
		btnNewButton_2_2.setText(null);
		lblPlayerWon.setText(null);
		count = 0;
		flag = 0;

		for (int i = 0; i < 3; i++) {
			Arrays.fill(arr[i], -1);
		}

		btnNewButton_PlayAgain.setVisible(false);
	}
}
