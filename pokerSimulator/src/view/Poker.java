package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.Controller;
import objects.Card;
import objects.Deck;
import objects.Player;

public class Poker extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private javax.swing.JPanel MainPanel;
	private javax.swing.JLabel board1;
	private javax.swing.JLabel board2;
	private javax.swing.JLabel board3;
	private javax.swing.JLabel board4;
	private javax.swing.JLabel board5;
	private javax.swing.JLabel equity1;
	private javax.swing.JLabel equity2;
	private javax.swing.JLabel equity3;
	private javax.swing.JLabel equity4;
	private javax.swing.JLabel equity5;
	private javax.swing.JLabel equity6;
	private javax.swing.JButton fold1;
	private javax.swing.JButton fold2;
	private javax.swing.JButton fold3;
	private javax.swing.JButton fold4;
	private javax.swing.JButton fold5;
	private javax.swing.JButton fold6;
	private javax.swing.JLabel fondo;
	private javax.swing.JLabel j1c1;
	private javax.swing.JLabel j1c2;
	private javax.swing.JLabel j2c1;
	private javax.swing.JLabel j2c2;
	private javax.swing.JLabel j3c1;
	private javax.swing.JLabel j3c2;
	private javax.swing.JLabel j4c1;
	private javax.swing.JLabel j4c2;
	private javax.swing.JLabel j5c1;
	private javax.swing.JLabel j5c2;
	private javax.swing.JLabel j6c1;
	private javax.swing.JLabel j6c2;
	private javax.swing.JButton manual1;
	private javax.swing.JButton manual2;
	private javax.swing.JButton manual3;
	private javax.swing.JButton manual4;
	private javax.swing.JButton manual5;
	private javax.swing.JButton manual6;
	private javax.swing.JButton nextButton;
	private javax.swing.JButton randomButton;
	private JButton boardButton;
	private JButton resetButton;
	private String[] suits = { "d", "c", "s", "h" };
	private String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A" };
	private Deck _deck;
	private Map<String, ImageIcon> icons;
	private Random ran;
	private List<JLabel> cartas;
	private ArrayList<Player> _players;
	private CardsDialog _cardsDialog;
	private Controller _ctrl;
	private ArrayList<Card> _board;
	private ArrayList<JLabel> boardList;
	private Object message;
	private Map<Player, JLabel> _equitys;
	private ImageIcon de;
	private boolean enableFold;

	public Poker(Deck deck, ArrayList<Player> players, Controller ctrl, Map<String, ImageIcon> icons) {
		_ctrl = ctrl;
		this.icons = icons;
		_equitys = new LinkedHashMap<>();
		boardList = new ArrayList<>();
		_board = new ArrayList<>();
		ran = new Random();
		_players = players;
		cartas = new ArrayList<>();
		_deck = deck;
		_cardsDialog = new CardsDialog(this, rootPaneCheckingEnabled, icons, deck, _board);
		enableFold = false;
		initComponents();
	}

	private void initComponents() {

		MainPanel = new javax.swing.JPanel();
		j1c2 = new javax.swing.JLabel();
		j1c1 = new javax.swing.JLabel();
		j2c1 = new javax.swing.JLabel();
		j2c2 = new javax.swing.JLabel();
		j3c1 = new javax.swing.JLabel();
		j3c2 = new javax.swing.JLabel();
		j4c1 = new javax.swing.JLabel();
		j4c2 = new javax.swing.JLabel();
		j5c1 = new javax.swing.JLabel();
		j5c2 = new javax.swing.JLabel();
		board1 = new javax.swing.JLabel();
		j6c2 = new javax.swing.JLabel();
		equity1 = new javax.swing.JLabel();
		equity2 = new javax.swing.JLabel();
		equity3 = new javax.swing.JLabel();
		equity4 = new javax.swing.JLabel();
		equity5 = new javax.swing.JLabel();
		equity6 = new javax.swing.JLabel();
		j6c1 = new javax.swing.JLabel();
		board2 = new javax.swing.JLabel();
		board4 = new javax.swing.JLabel();
		board3 = new javax.swing.JLabel();
		board5 = new javax.swing.JLabel();
		fold1 = new javax.swing.JButton();
		randomButton = new javax.swing.JButton();
		fold2 = new javax.swing.JButton();
		fold3 = new javax.swing.JButton();
		fold4 = new javax.swing.JButton();
		fold5 = new javax.swing.JButton();
		fold6 = new javax.swing.JButton();
		nextButton = new javax.swing.JButton();
		manual1 = new javax.swing.JButton();
		manual2 = new javax.swing.JButton();
		manual3 = new javax.swing.JButton();
		manual4 = new javax.swing.JButton();
		manual5 = new javax.swing.JButton();
		manual6 = new javax.swing.JButton();
		fondo = new javax.swing.JLabel();
		boardButton = new JButton();
		resetButton = new JButton();

		cartas.add(j1c1);
		cartas.add(j1c2);
		cartas.add(j2c1);
		cartas.add(j2c2);
		cartas.add(j3c1);
		cartas.add(j3c2);
		cartas.add(j4c1);
		cartas.add(j4c2);
		cartas.add(j5c1);
		cartas.add(j5c2);
		cartas.add(j6c1);
		cartas.add(j6c2);

		boardList.add(board1);
		boardList.add(board2);
		boardList.add(board3);
		boardList.add(board4);
		boardList.add(board5);

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Sportium3");
		setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		MainPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

		equity1.setText("0%");
		equity1.setForeground(Color.white);
		equity1.setBorder(null);
		equity1.setOpaque(false);
		equity1.setSize(60, 30);

		equity2.setText("0%");
		equity2.setForeground(Color.white);
		equity2.setBorder(null);
		equity2.setOpaque(false);

		equity3.setText("0%");
		equity3.setForeground(Color.white);
		equity3.setBorder(null);
		equity3.setOpaque(false);

		equity4.setText("0%");
		equity4.setForeground(Color.white);
		equity4.setBorder(null);
		equity4.setOpaque(false);

		equity5.setText("0%");
		equity5.setForeground(Color.white);
		equity5.setBorder(null);
		equity5.setOpaque(false);

		equity6.setText("0%");
		equity6.setForeground(Color.white);
		equity6.setBorder(null);
		equity6.setOpaque(false);

		_equitys.put(_players.get(0), equity1);
		_equitys.put(_players.get(1), equity2);
		_equitys.put(_players.get(2), equity3);
		_equitys.put(_players.get(3), equity4);
		_equitys.put(_players.get(4), equity5);
		_equitys.put(_players.get(5), equity6);

		fold1.setBackground(new java.awt.Color(153, 153, 0));
		fold1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
		fold1.setText("Fold");
		fold1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		fold1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		randomButton.setBackground(new java.awt.Color(0, 153, 153));
		randomButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
		randomButton.setText("Random");
		randomButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		randomButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		randomButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				randomAssign();
				randomButton.setEnabled(false);
				manual1.setEnabled(false);
				manual2.setEnabled(false);
				manual3.setEnabled(false);
				manual4.setEnabled(false);
				manual5.setEnabled(false);
				manual6.setEnabled(false);

				for (Player p : _players) {
					p.reset();
				}
				_ctrl.checkComb(_board, 5 - _board.size());

				for (Player p : _equitys.keySet()) {
					JLabel aux = _equitys.get(p);
					if (aux.isEnabled())
						aux.setText(p.getPercent() + "%");
				}
				enableFold = true;
			}
		});

		fold2.setBackground(new java.awt.Color(153, 153, 0));
		fold2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
		fold2.setText("Fold");
		fold2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		fold2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		fold3.setBackground(new java.awt.Color(153, 153, 0));
		fold3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
		fold3.setText("Fold");
		fold3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		fold3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		fold4.setBackground(new java.awt.Color(153, 153, 0));
		fold4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
		fold4.setText("Fold");
		fold4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		fold4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		fold5.setBackground(new java.awt.Color(153, 153, 0));
		fold5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
		fold5.setText("Fold");
		fold5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		fold5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		fold6.setBackground(new java.awt.Color(153, 153, 0));
		fold6.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
		fold6.setText("Fold");
		fold6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		fold6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		File d = new File("icons/cartaPorDetras.png");
		if (d != null) {
			try {
				BufferedImage daux = ImageIO.read(d);
				de = (escalarImagen(daux, 70, 110));

			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		fold1.addActionListener((e) -> {
			
			if(enableFold) {
				// dar vuelta a la carta
				j1c1.setIcon(de);
				j1c2.setIcon(de);

				for (int i = 0; i < _players.size(); i++) {
					if (_players.get(i).getIndex() == 0)
						_players.remove(_players.get(i));
				}
				equity1.setText("0%");
				equity1.setEnabled(false);
//				cartas.remove(j1c1);
//				cartas.remove(j1c2);
				boolean ok = true;
				for (Player p : _players) {
					if (p.getCards().size() != 2) {
						ok = false;
					}
				}

				if (ok) {
					_ctrl.checkComb(_board, 5 - _board.size());

					for (Player p : _equitys.keySet()) {
						JLabel aux = _equitys.get(p);
						if (aux.isEnabled())
							aux.setText(p.getPercent() + "%");
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null, message, "Algun jugador sin cartas asignadas",
						JOptionPane.WARNING_MESSAGE);
			}
		});

		fold2.addActionListener((e) -> {
			
			if(enableFold) {
				// dar vuelta a la carta

				j2c1.setIcon(de);
				j2c2.setIcon(de);

				for (int i = 0; i < _players.size(); i++) {
					if (_players.get(i).getIndex() == 1)
						_players.remove(_players.get(i));
				}
				equity2.setEnabled(false);
				equity2.setText("0%");
//				cartas.remove(j2c1);
//				cartas.remove(j2c2);
				boolean ok = true;
				for (Player p : _players) {
					if (p.getCards().size() != 2) {
						ok = false;
					}
				}

				if (ok) {
					_ctrl.checkComb(_board, 5 - _board.size());

					for (Player p : _equitys.keySet()) {
						JLabel aux = _equitys.get(p);
						if (aux.isEnabled())
							aux.setText(p.getPercent() + "%");
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null, message, "Algun jugador sin cartas asignadas",
						JOptionPane.WARNING_MESSAGE);
			}
		});

		fold3.addActionListener((e) -> {
			
			if(enableFold) {
				// dar vuelta a la carta

				j3c1.setIcon(de);
				j3c2.setIcon(de);

				for (int i = 0; i < _players.size(); i++) {
					if (_players.get(i).getIndex() == 2)
						_players.remove(_players.get(i));
				}
				equity3.setEnabled(false);
				equity3.setText("0%");
//				cartas.remove(j3c1);
//				cartas.remove(j3c2);
				boolean ok = true;
				for (Player p : _players) {
					if (p.getCards().size() != 2) {
						ok = false;
					}
				}

				if (ok) {
					_ctrl.checkComb(_board, 5 - _board.size());

					for (Player p : _equitys.keySet()) {
						JLabel aux = _equitys.get(p);
						if (aux.isEnabled())
							aux.setText(p.getPercent() + "%");
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null, message, "Algun jugador sin cartas asignadas",
						JOptionPane.WARNING_MESSAGE);
			}
		});

		fold4.addActionListener((e) -> {
			
			if(enableFold) {
				// dar vuelta a la carta

				j4c1.setIcon(de);
				j4c2.setIcon(de);

				for (int i = 0; i < _players.size(); i++) {
					if (_players.get(i).getIndex() == 3)
						_players.remove(_players.get(i));
				}
				equity4.setEnabled(false);
				equity4.setText("0%");
//				cartas.remove(j4c1);
//				cartas.remove(j4c2);
				boolean ok = true;
				for (Player p : _players) {
					if (p.getCards().size() != 2) {
						ok = false;
					}
				}

				if (ok) {
					_ctrl.checkComb(_board, 5 - _board.size());

					for (Player p : _equitys.keySet()) {
						JLabel aux = _equitys.get(p);
						if (aux.isEnabled())
							aux.setText(p.getPercent() + "%");
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null, message, "Algun jugador sin cartas asignadas",
						JOptionPane.WARNING_MESSAGE);
			}
		});

		fold5.addActionListener((e) -> {
			
			if(enableFold) {
				// dar vuelta a la carta

				j5c1.setIcon(de);
				j5c2.setIcon(de);
				
				for (int i = 0; i < _players.size(); i++) {
					if (_players.get(i).getIndex() == 4)
						_players.remove(_players.get(i));
				}
				equity5.setEnabled(false);
				equity5.setText("0%");
//				cartas.remove(j5c1);
//				cartas.remove(j5c2);
				boolean ok = true;
				for (Player p : _players) {
					if (p.getCards().size() != 2) {
						ok = false;
					}
				}

				if (ok) {
					_ctrl.checkComb(_board, 5 - _board.size());

					for (Player p : _equitys.keySet()) {
						JLabel aux = _equitys.get(p);
						if (aux.isEnabled())
							aux.setText(p.getPercent() + "%");
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null, message, "Algun jugador sin cartas asignadas",
						JOptionPane.WARNING_MESSAGE);
			}
		});

		fold6.addActionListener((e) -> {
			
			if(enableFold) {
				// dar vuelta a la carta

				j6c1.setIcon(de);
				j6c2.setIcon(de);

				for (int i = 0; i < _players.size(); i++) {
					if (_players.get(i).getIndex() == 5)
						_players.remove(_players.get(i));
				}
				equity6.setEnabled(false);
				equity6.setText("0%");
//				cartas.remove(j6c1);
//				cartas.remove(j6c2);
				boolean ok = true;
				for (Player p : _players) {
					if (p.getCards().size() != 2) {
						ok = false;
					}
				}

				if (ok) {
					_ctrl.checkComb(_board, 5 - _board.size());

					for (Player p : _equitys.keySet()) {
						JLabel aux = _equitys.get(p);
						if (aux.isEnabled())
							aux.setText(p.getPercent() + "%");
					}
				}
			}
			else {
				JOptionPane.showMessageDialog(null, message, "Algun jugador sin cartas asignadas",
						JOptionPane.WARNING_MESSAGE);
			}
		});

		nextButton.setBackground(new java.awt.Color(153, 0, 153));
		nextButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
		nextButton.setText("Next");
		nextButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		nextButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		nextButton.addActionListener((e) -> {

			if (_deck.getRaminingCards().size() <= 40) {
				int s = ran.nextInt(3);
				int r = ran.nextInt(13);

				while (!_deck.containsCard(new Card(ranks[r], suits[s], ranks[r] + suits[s]))) {
					s = ran.nextInt(3);
					r = ran.nextInt(13);
				}
				if (_board.size() < 3) {
					board1.setIcon(icons.get(ranks[r] + suits[s]));
					Card aux = new Card(ranks[r], suits[s], ranks[r] + suits[s]);
					_board.add(aux);
					_deck.removeCard(aux);
					while (!_deck.containsCard(new Card(ranks[r], suits[s], ranks[r] + suits[s]))) {
						s = ran.nextInt(3);
						r = ran.nextInt(13);
					}
					board2.setIcon(icons.get(ranks[r] + suits[s]));
					aux = new Card(ranks[r], suits[s], ranks[r] + suits[s]);
					_board.add(aux);
					_deck.removeCard(aux);
					while (!_deck.containsCard(new Card(ranks[r], suits[s], ranks[r] + suits[s]))) {
						s = ran.nextInt(3);
						r = ran.nextInt(13);
					}
					board3.setIcon(icons.get(ranks[r] + suits[s]));
					aux = new Card(ranks[r], suits[s], ranks[r] + suits[s]);
					_board.add(aux);
					_deck.removeCard(aux);
				} else {
					boolean found = false;
					int i = _board.size();
					while (i < boardList.size() && !found) {
						if (boardList.get(i).getIcon() == null) {
							Card aux = new Card(ranks[r], suits[s], ranks[r] + suits[s]);
							boardList.get(i).setIcon(icons.get(ranks[r] + suits[s]));
							aux = new Card(ranks[r], suits[s], ranks[r] + suits[s]);
							_board.add(aux);
							_deck.removeCard(aux);
							found = true;
						}
						i++;
					}
				}

				for (Player p : _players) {
					p.reset();
				}

				_ctrl.checkComb(_board, 5 - _board.size());

				for (Player p : _equitys.keySet()) {
					JLabel aux = _equitys.get(p);
					if (aux.isEnabled())
						aux.setText(p.getPercent() + "%");
				}
				
			} else {
				JOptionPane.showMessageDialog(null, message, "Algun jugador sin cartas asignadas",
						JOptionPane.WARNING_MESSAGE);
			}

		});

		manual1.setBorder(null);
		manual1.setBorderPainted(false);
		manual1.setContentAreaFilled(false);
		manual1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		manual1.setFocusPainted(false);
		manual1.addActionListener((e) -> {
			_cardsDialog.open(_players.get(0), j1c1, j1c2, null, manual1);
			repaint();
			if (!manual1.isEnabled() && !manual2.isEnabled() && !manual3.isEnabled() && !manual4.isEnabled()
					&& !manual5.isEnabled() && !manual6.isEnabled()) {
				_ctrl.checkComb(_board, 5 - _board.size());

				for (Player p : _equitys.keySet()) {
					JLabel aux = _equitys.get(p);
					if (aux.isEnabled())
						aux.setText(p.getPercent() + "%");
				}
				enableFold = true;
			}
		});

		manual2.setBorder(null);
		manual2.setBorderPainted(false);
		manual2.setContentAreaFilled(false);
		manual2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		manual2.setFocusPainted(false);
		manual2.addActionListener((e) -> {
			_cardsDialog.open(_players.get(1), j2c1, j2c2, null, manual2);
			repaint();
			if (!manual1.isEnabled() && !manual2.isEnabled() && !manual3.isEnabled() && !manual4.isEnabled()
					&& !manual5.isEnabled() && !manual6.isEnabled()) {
				_ctrl.checkComb(_board, 5 - _board.size());

				for (Player p : _equitys.keySet()) {
					JLabel aux = _equitys.get(p);
					if (aux.isEnabled())
						aux.setText(p.getPercent() + "%");
				}
				enableFold = true;
			}
		});

		manual3.setBorder(null);
		manual3.setBorderPainted(false);
		manual3.setContentAreaFilled(false);
		manual3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		manual3.setFocusPainted(false);
		manual3.addActionListener((e) -> {
			_cardsDialog.open(_players.get(2), j3c1, j3c2, null, manual3);
			repaint();
			if (!manual1.isEnabled() && !manual2.isEnabled() && !manual3.isEnabled() && !manual4.isEnabled()
					&& !manual5.isEnabled() && !manual6.isEnabled()) {
				_ctrl.checkComb(_board, 5 - _board.size());

				for (Player p : _equitys.keySet()) {
					JLabel aux = _equitys.get(p);
					if (aux.isEnabled())
						aux.setText(p.getPercent() + "%");
				}
				enableFold = true;
			}
		});

		manual4.setBorder(null);
		manual4.setBorderPainted(false);
		manual4.setContentAreaFilled(false);
		manual4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		manual4.setFocusPainted(false);
		manual4.addActionListener((e) -> {
			_cardsDialog.open(_players.get(3), j4c1, j4c2, null, manual4);
			repaint();
			if (!manual1.isEnabled() && !manual2.isEnabled() && !manual3.isEnabled() && !manual4.isEnabled()
					&& !manual5.isEnabled() && !manual6.isEnabled()) {
				_ctrl.checkComb(_board, 5 - _board.size());

				for (Player p : _equitys.keySet()) {
					JLabel aux = _equitys.get(p);
					if (aux.isEnabled())
						aux.setText(p.getPercent() + "%");
				}
				enableFold = true;
			}
		});

		manual5.setBorder(null);
		manual5.setBorderPainted(false);
		manual5.setContentAreaFilled(false);
		manual5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		manual5.setFocusPainted(false);
		manual5.addActionListener((e) -> {
			_cardsDialog.open(_players.get(4), j5c1, j5c2, null, manual5);
			repaint();
			if (!manual1.isEnabled() && !manual2.isEnabled() && !manual3.isEnabled() && !manual4.isEnabled()
					&& !manual5.isEnabled() && !manual6.isEnabled()) {
				_ctrl.checkComb(_board, 5 - _board.size());

				for (Player p : _equitys.keySet()) {
					JLabel aux = _equitys.get(p);
					if (aux.isEnabled())
						aux.setText(p.getPercent() + "%");
				}
				enableFold = true;
			}
		});

		manual6.setBorder(null);
		manual6.setBorderPainted(false);
		manual6.setContentAreaFilled(false);
		manual6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		manual6.setFocusPainted(false);
		manual6.addActionListener((e) -> {
			_cardsDialog.open(_players.get(5), j6c1, j6c2, null, manual6);
			repaint();
			if (!manual1.isEnabled() && !manual2.isEnabled() && !manual3.isEnabled() && !manual4.isEnabled()
					&& !manual5.isEnabled() && !manual6.isEnabled()) {
				_ctrl.checkComb(_board, 5 - _board.size());

				for (Player p : _equitys.keySet()) {
					JLabel aux = _equitys.get(p);
					if (aux.isEnabled())
						aux.setText(p.getPercent() + "%");
				}
				enableFold = true;
			}
		});

		resetButton.setBackground(new java.awt.Color(153, 51, 0));
		resetButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
		resetButton.setText("Reset");
		resetButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		resetButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		resetButton.addActionListener((e) -> {
			
			for(JLabel l : cartas) {
				l.setIcon(null);
			}
			for(JLabel l : boardList) {
				l.setIcon(null);
			}
			for(Player p : _players) {
				p.reset2();
			}
			for(JLabel l : _equitys.values()) {
				l.setText("0%");
				l.setEnabled(true);
			}
			manual1.setEnabled(true);
			manual2.setEnabled(true);
			manual3.setEnabled(true);
			manual4.setEnabled(true);
			manual5.setEnabled(true);
			manual6.setEnabled(true);

			
			_deck.initDeck();
			_board.clear();
			_cardsDialog.reset();
			randomButton.setEnabled(true);
			_ctrl = new Controller(_deck, _players);
			enableFold = false;
			_cardsDialog = new CardsDialog(this, rootPaneCheckingEnabled, icons, _deck, _board);
			
			repaint();

		});

		boardButton.setBackground(new java.awt.Color(153, 0, 102));
		boardButton.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
		boardButton.setText("Board");
		boardButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		boardButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		boardButton.addActionListener((e) -> {
			int prevSize = _board.size();
			_cardsDialog.open(null, null, null, boardList, manual6);
			boolean ok = true;
			for (Player p : _players) {
				if (p.getCards().size() != 2) {
					ok = false;
				}
			}

			if (ok) {
				if (prevSize != _board.size()) {

					_ctrl.checkComb(_board, 5 - _board.size());

					for (Player p : _equitys.keySet()) {
						JLabel aux = _equitys.get(p);
						if (aux.isEnabled())
							aux.setText(p.getPercent() + "%");
					}
				}
			}
		});

		javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
		MainPanel.setLayout(MainPanelLayout);
		MainPanelLayout
				.setHorizontalGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(MainPanelLayout.createSequentialGroup().addGap(20, 20, 20)
								.addComponent(randomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(130, 130, 130)
								.addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(fold1, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(manual1, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(90, 90, 90)
								.addComponent(j1c2, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(140, 140, 140)
								.addComponent(j2c1, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0)
								.addComponent(j2c2, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(10, 10, 10)
								.addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(fold2, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(manual2, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(MainPanelLayout.createSequentialGroup().addGap(360, 360, 360)
								.addComponent(equity1, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(240, 240, 240)
								.addComponent(equity2, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(MainPanelLayout.createSequentialGroup().addGap(40, 40, 40)
								.addComponent(manual6, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(10, 10, 10)
								.addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(j6c1, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(MainPanelLayout.createSequentialGroup().addGap(50, 50, 50)
												.addComponent(equity6, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGap(190, 190, 190)
								.addComponent(
										board2, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(MainPanelLayout.createSequentialGroup().addGap(10, 10, 10)
												.addComponent(boardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(board3, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addComponent(board4, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0)
								.addComponent(board5, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(70, 70, 70)
								.addComponent(j3c1, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(0, 0, 0)
								.addComponent(j3c2, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(10, 10, 10)
								.addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(fold3, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(manual3, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(MainPanelLayout.createSequentialGroup().addGap(240, 240, 240)
								.addComponent(manual5, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(310, 310, 310)
								.addComponent(j4c2, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(90, 90, 90).addComponent(manual4, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(MainPanelLayout.createSequentialGroup().addGap(660, 660, 660).addComponent(equity4,
								javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(MainPanelLayout.createSequentialGroup().addGap(1010, 1010, 1010).addComponent(
								resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(MainPanelLayout.createSequentialGroup().addGap(780, 780, 780).addComponent(fold4,
								javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(MainPanelLayout.createSequentialGroup().addGap(360, 360, 360).addComponent(equity5,
								javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(MainPanelLayout.createSequentialGroup().addGap(40, 40, 40).addComponent(fold6,
								javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(MainPanelLayout.createSequentialGroup().addGap(330, 330, 330).addComponent(board1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(MainPanelLayout.createSequentialGroup().addGap(690, 690, 690).addComponent(j4c1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(MainPanelLayout.createSequentialGroup().addGap(190, 190, 190).addComponent(j6c2,
								javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(MainPanelLayout.createSequentialGroup().addGap(310, 310, 310).addComponent(j5c1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(MainPanelLayout.createSequentialGroup().addGap(850, 850, 850).addComponent(equity3,
								javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(MainPanelLayout.createSequentialGroup().addGap(310, 310, 310).addComponent(j1c1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(MainPanelLayout.createSequentialGroup().addGap(940, 940, 940).addComponent(nextButton,
								javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(MainPanelLayout.createSequentialGroup().addGap(390, 390, 390).addComponent(j5c2,
								javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(MainPanelLayout.createSequentialGroup().addGap(240, 240, 240).addComponent(fold5,
								javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1100,
								javax.swing.GroupLayout.PREFERRED_SIZE));
		MainPanelLayout.setVerticalGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(MainPanelLayout.createSequentialGroup().addGap(20, 20, 20)
						.addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(randomButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(MainPanelLayout.createSequentialGroup().addGap(40, 40, 40)
										.addComponent(fold1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(10, 10, 10)
										.addComponent(manual1, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(MainPanelLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(
										j1c2, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(MainPanelLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(
										j2c1, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(MainPanelLayout.createSequentialGroup().addGap(10, 10, 10).addComponent(j2c2,
										javax.swing.GroupLayout.PREFERRED_SIZE, 130,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(MainPanelLayout.createSequentialGroup().addGap(40, 40, 40)
										.addComponent(fold2, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(10, 10, 10).addComponent(manual2,
												javax.swing.GroupLayout.PREFERRED_SIZE, 60,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(equity1, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(equity2, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(20, 20, 20)
						.addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(MainPanelLayout.createSequentialGroup().addGap(90, 90, 90).addComponent(
										manual6, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(MainPanelLayout.createSequentialGroup().addGap(20, 20, 20)
										.addComponent(j6c1, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, 0).addComponent(equity6, javax.swing.GroupLayout.PREFERRED_SIZE,
												30, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(MainPanelLayout.createSequentialGroup().addGap(40, 40, 40).addComponent(
										board2, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(MainPanelLayout.createSequentialGroup()
										.addComponent(boardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(10, 10, 10).addComponent(board3, javax.swing.GroupLayout.PREFERRED_SIZE,
												130, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(MainPanelLayout.createSequentialGroup().addGap(40, 40, 40).addComponent(
										board4, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(MainPanelLayout.createSequentialGroup().addGap(40, 40, 40).addComponent(
										board5, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(MainPanelLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(j3c1,
										javax.swing.GroupLayout.PREFERRED_SIZE, 130,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(MainPanelLayout.createSequentialGroup().addGap(20, 20, 20).addComponent(j3c2,
										javax.swing.GroupLayout.PREFERRED_SIZE, 130,
										javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(MainPanelLayout.createSequentialGroup().addGap(50, 50, 50)
										.addComponent(fold3, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(10, 10, 10)
										.addComponent(manual3, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(40, 40, 40)
						.addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(j4c2, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(MainPanelLayout.createSequentialGroup().addGap(70, 70, 70)
										.addGroup(MainPanelLayout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(manual5, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(manual4, javax.swing.GroupLayout.PREFERRED_SIZE, 60,
														javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addComponent(equity4, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, 0).addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(MainPanelLayout.createSequentialGroup().addGap(460, 460, 460).addComponent(fold4,
						javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(MainPanelLayout.createSequentialGroup().addGap(560, 560, 560).addComponent(equity5,
						javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(MainPanelLayout.createSequentialGroup().addGap(260, 260, 260).addComponent(fold6,
						javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(MainPanelLayout.createSequentialGroup().addGap(250, 250, 250).addComponent(board1,
						javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(MainPanelLayout.createSequentialGroup().addGap(430, 430, 430).addComponent(j4c1,
						javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(MainPanelLayout.createSequentialGroup().addGap(230, 230, 230).addComponent(j6c2,
						javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(MainPanelLayout.createSequentialGroup().addGap(430, 430, 430).addComponent(j5c1,
						javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(MainPanelLayout.createSequentialGroup().addGap(360, 360, 360).addComponent(equity3,
						javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(MainPanelLayout.createSequentialGroup().addGap(30, 30, 30).addComponent(j1c1,
						javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(MainPanelLayout.createSequentialGroup().addGap(590, 590, 590).addComponent(nextButton,
						javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(MainPanelLayout.createSequentialGroup().addGap(430, 430, 430).addComponent(j5c2,
						javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGroup(MainPanelLayout.createSequentialGroup().addGap(460, 460, 460).addComponent(fold5,
						javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 640,
						javax.swing.GroupLayout.PREFERRED_SIZE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE)));

		File f = new File("icons/fondo.png");
		if (f != null) {
			try {
				BufferedImage faux = ImageIO.read(f);
				fondo.setIcon(escalarImagen(faux, 1100, 640));
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		File dd = new File("icons/deck.png");
		if (dd != null) {
			try {
				BufferedImage daux = ImageIO.read(dd);
				ImageIcon dec = (escalarImagen(daux, 60, 60));
				manual1.setIcon(dec);
				manual2.setIcon(dec);
				manual3.setIcon(dec);
				manual4.setIcon(dec);
				manual5.setIcon(dec);
				manual6.setIcon(dec);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		setVisible(true);
		pack();
	}

	private void randomAssign() {
		int s = -1;
		int r = -1;
		int cont = 0;
		int contAux = 0;

		for (JLabel l : cartas) {
			s = ran.nextInt(3);
			r = ran.nextInt(13);

			if (contAux == 2) {
				cont++;
				contAux = 0;
			}

			while (!_deck.containsCard(new Card(ranks[r], suits[s], ranks[r] + suits[s]))) {
				s = ran.nextInt(3);
				r = ran.nextInt(13);
			}

			if (l.getIcon() == null) {
				l.setIcon(icons.get(ranks[r] + suits[s]));
				Card aux = new Card(ranks[r], suits[s], ranks[r] + suits[s]);
				_players.get(cont).addCard(aux);
				_deck.removeCard(aux);
			}
			contAux++;
		}

	}

	private ImageIcon escalarImagen(BufferedImage img, int ancho, int alto) {
		Image imagenEscalada = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		return new ImageIcon(imagenEscalada);
	}


}