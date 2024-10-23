package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

import objects.Card;
import objects.Deck;
import objects.Player;

public class CardsDialog extends JDialog {

	private javax.swing.JToggleButton card1;
	private javax.swing.JToggleButton card10;
	private javax.swing.JToggleButton card11;
	private javax.swing.JToggleButton card12;
	private javax.swing.JToggleButton card13;
	private javax.swing.JToggleButton card14;
	private javax.swing.JToggleButton card15;
	private javax.swing.JToggleButton card16;
	private javax.swing.JToggleButton card17;
	private javax.swing.JToggleButton card18;
	private javax.swing.JToggleButton card19;
	private javax.swing.JToggleButton card2;
	private javax.swing.JToggleButton card20;
	private javax.swing.JToggleButton card21;
	private javax.swing.JToggleButton card22;
	private javax.swing.JToggleButton card23;
	private javax.swing.JToggleButton card24;
	private javax.swing.JToggleButton card25;
	private javax.swing.JToggleButton card26;
	private javax.swing.JToggleButton card27;
	private javax.swing.JToggleButton card28;
	private javax.swing.JToggleButton card29;
	private javax.swing.JToggleButton card3;
	private javax.swing.JToggleButton card30;
	private javax.swing.JToggleButton card31;
	private javax.swing.JToggleButton card32;
	private javax.swing.JToggleButton card33;
	private javax.swing.JToggleButton card34;
	private javax.swing.JToggleButton card35;
	private javax.swing.JToggleButton card36;
	private javax.swing.JToggleButton card37;
	private javax.swing.JToggleButton card38;
	private javax.swing.JToggleButton card39;
	private javax.swing.JToggleButton card4;
	private javax.swing.JToggleButton card40;
	private javax.swing.JToggleButton card41;
	private javax.swing.JToggleButton card42;
	private javax.swing.JToggleButton card43;
	private javax.swing.JToggleButton card44;
	private javax.swing.JToggleButton card45;
	private javax.swing.JToggleButton card46;
	private javax.swing.JToggleButton card47;
	private javax.swing.JToggleButton card48;
	private javax.swing.JToggleButton card49;
	private javax.swing.JToggleButton card5;
	private javax.swing.JToggleButton card50;
	private javax.swing.JToggleButton card51;
	private javax.swing.JToggleButton card52;
	private javax.swing.JToggleButton card6;
	private javax.swing.JToggleButton card7;
	private javax.swing.JToggleButton card8;
	private javax.swing.JToggleButton card9;
	private javax.swing.JToggleButton okButton;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane2;
	private Map<String, ImageIcon> _icons;
	private List<JToggleButton> buttonList;
	private Deck _deck;
	private Player _player;
	private ArrayList<JLabel> _board;
	private JLabel _card1;
	private JLabel _card2;
	private Object message;
	private int playersReady = 0;
	private JButton _currButton;
	private ArrayList<Card> _boardCards;
	private JLabel _card3;
	private JLabel _card4;

	public CardsDialog(java.awt.Frame parent, boolean modal, Map<String, ImageIcon> icons, Deck deck,
			ArrayList<Card> board) {
		super(parent, modal);
		buttonList = new ArrayList<>();
		_deck = deck;
		_icons = icons;
		_boardCards = board;
		initComponents();
	}

	private void initComponents() {

		setSize(390, 645);

		jScrollPane2 = new javax.swing.JScrollPane();
		jPanel1 = new javax.swing.JPanel();
		card1 = new javax.swing.JToggleButton();
		card2 = new javax.swing.JToggleButton();
		card3 = new javax.swing.JToggleButton();
		card4 = new javax.swing.JToggleButton();
		card5 = new javax.swing.JToggleButton();
		card6 = new javax.swing.JToggleButton();
		card7 = new javax.swing.JToggleButton();
		card8 = new javax.swing.JToggleButton();
		card9 = new javax.swing.JToggleButton();
		card10 = new javax.swing.JToggleButton();
		card11 = new javax.swing.JToggleButton();
		card12 = new javax.swing.JToggleButton();
		card13 = new javax.swing.JToggleButton();
		card14 = new javax.swing.JToggleButton();
		card15 = new javax.swing.JToggleButton();
		card16 = new javax.swing.JToggleButton();
		card17 = new javax.swing.JToggleButton();
		card18 = new javax.swing.JToggleButton();
		card19 = new javax.swing.JToggleButton();
		card20 = new javax.swing.JToggleButton();
		card21 = new javax.swing.JToggleButton();
		card22 = new javax.swing.JToggleButton();
		card23 = new javax.swing.JToggleButton();
		card24 = new javax.swing.JToggleButton();
		card25 = new javax.swing.JToggleButton();
		card26 = new javax.swing.JToggleButton();
		card27 = new javax.swing.JToggleButton();
		card28 = new javax.swing.JToggleButton();
		card29 = new javax.swing.JToggleButton();
		card30 = new javax.swing.JToggleButton();
		card31 = new javax.swing.JToggleButton();
		card32 = new javax.swing.JToggleButton();
		card33 = new javax.swing.JToggleButton();
		card34 = new javax.swing.JToggleButton();
		card35 = new javax.swing.JToggleButton();
		card36 = new javax.swing.JToggleButton();
		card37 = new javax.swing.JToggleButton();
		card38 = new javax.swing.JToggleButton();
		card39 = new javax.swing.JToggleButton();
		card40 = new javax.swing.JToggleButton();
		card41 = new javax.swing.JToggleButton();
		card42 = new javax.swing.JToggleButton();
		card43 = new javax.swing.JToggleButton();
		card44 = new javax.swing.JToggleButton();
		card45 = new javax.swing.JToggleButton();
		card46 = new javax.swing.JToggleButton();
		card47 = new javax.swing.JToggleButton();
		card48 = new javax.swing.JToggleButton();
		card49 = new javax.swing.JToggleButton();
		card50 = new javax.swing.JToggleButton();
		card51 = new javax.swing.JToggleButton();
		card52 = new javax.swing.JToggleButton();
		okButton = new javax.swing.JToggleButton();

		buttonList.add(card1);
		buttonList.add(card2);
		buttonList.add(card3);
		buttonList.add(card4);
		buttonList.add(card5);
		buttonList.add(card6);
		buttonList.add(card7);
		buttonList.add(card8);
		buttonList.add(card9);
		buttonList.add(card10);
		buttonList.add(card11);
		buttonList.add(card12);
		buttonList.add(card13);
		buttonList.add(card14);
		buttonList.add(card15);
		buttonList.add(card16);
		buttonList.add(card17);
		buttonList.add(card18);
		buttonList.add(card19);
		buttonList.add(card20);
		buttonList.add(card21);
		buttonList.add(card22);
		buttonList.add(card23);
		buttonList.add(card24);
		buttonList.add(card25);
		buttonList.add(card26);
		buttonList.add(card30);
		buttonList.add(card33);
		buttonList.add(card29);
		buttonList.add(card27);
		buttonList.add(card34);
		buttonList.add(card31);
		buttonList.add(card39);
		buttonList.add(card36);
		buttonList.add(card37);
		buttonList.add(card38);
		buttonList.add(card28);
		buttonList.add(card32);
		buttonList.add(card35);
		buttonList.add(card47);
		buttonList.add(card44);
		buttonList.add(card41);
		buttonList.add(card50);
		buttonList.add(card42);
		buttonList.add(card51);
		buttonList.add(card46);
		buttonList.add(card52);
		buttonList.add(card43);
		buttonList.add(card48);
		buttonList.add(card49);
		buttonList.add(card45);
		buttonList.add(card40);

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Sellect 2 cards for Player ");

		card1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card10.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card12.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card13.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card15.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card16.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card17.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card19.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card20.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card22.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card23.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card24.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card25.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card26.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card27.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card28.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card29.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card30.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card31.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card32.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card33.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card34.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card35.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card36.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card37.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card38.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card39.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card40.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card41.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card42.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card43.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card44.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card45.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card46.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card47.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card48.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card49.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card50.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card51.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		card52.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card5, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card6, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card7, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card8, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card9, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card10, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card11, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card12, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card13, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(card14, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card15, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card16, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card17, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card18, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card19, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card20, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card21, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card22, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card23, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card24, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card25, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card26, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(card30, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card33, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card29, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card27, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card34, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card31, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card39, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card36, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card37, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card38, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card28, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card32, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card35, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(card47, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card44, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card41, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card50, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card42, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card51, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card46, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card52, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card43, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card48, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card49, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card45, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(card40, javax.swing.GroupLayout.PREFERRED_SIZE, 80,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addComponent(card47, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(card44, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(card41, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(card50, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(card42, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(card51, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(card46, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(card52, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(card43, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(card48, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(card49, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(card45, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(card40, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addComponent(card30, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(card33, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(card29, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(card27, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(card34, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(card31, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(card39, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(card36, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(card37, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(card38, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(card28, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(card32, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(
														card35, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(jPanel1Layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(card14, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card15, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card16, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card17, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card18, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card19, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card20, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card21, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card22, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card23, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card24, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(
																card25, javax.swing.GroupLayout.PREFERRED_SIZE, 130,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card26, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(jPanel1Layout.createSequentialGroup()
														.addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card4, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card5, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card6, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card7, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card8, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card9, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card10, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card11, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card12, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(
																javax.swing.LayoutStyle.ComponentPlacement.RELATED)
														.addComponent(card13, javax.swing.GroupLayout.PREFERRED_SIZE,
																130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
						.addContainerGap(16, Short.MAX_VALUE)));

		jScrollPane2.setViewportView(jPanel1);

		okButton.setText("Accept");
		okButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

		okButton.addActionListener((e) -> {

			if (_board == null) {
				if (_card3 == null) {
					if (_card1.getIcon() != null && _card2.getIcon() != null) {
						for (JToggleButton b : buttonList) {
							if (b.isSelected()) {
								b.setEnabled(false);
							}
						}
						_currButton.setEnabled(false);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, message, "Seleccione 2 cartas",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					if (_card1.getIcon() != null && _card2.getIcon() != null && _card3.getIcon() != null
							&& _card4.getIcon() != null) {
						for (JToggleButton b : buttonList) {
							if (b.isSelected()) {
								b.setEnabled(false);
							}
						}
						_currButton.setEnabled(false);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(null, message, "Seleccione 4 cartas",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			} else {
				if (_boardCards.size() >= 3) {
					for (JToggleButton b : buttonList) {
						if (b.isSelected()) {
							b.setEnabled(false);
						}
					}
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(null, message, "Seleccione minimo 3 cartas en el board",
							JOptionPane.WARNING_MESSAGE);
				}
			}

		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(okButton,
								javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 562,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 21,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		int i = 0;
		boolean f = false;
		for (String icon : _icons.keySet()) {
			final int index = i;
			int j = 0;
			buttonList.get(i).addActionListener((e) -> {
				Card c = new Card(icon.charAt(0) + "", icon.charAt(1) + "", icon);
				if (!buttonList.get(index).isSelected()) {
					if (_board == null) {
						_deck.addCard(c);
						_player.removeCard(c);
						if (_card1.getIcon() == _icons.get(icon)) {
							_card1.setIcon(null);
						} else if (_card2.getIcon() == _icons.get(icon)) {
							_card2.setIcon(null);
						} else if (_card3.getIcon() == _icons.get(icon)) {
							_card3.setIcon(null);
						} else if (_card4.getIcon() == _icons.get(icon)) {
							_card4.setIcon(null);
						}
					} else {
						_deck.addCard(c);
						_boardCards.remove(c);

						for (JLabel l : _board) {
							if (l.getIcon() == _icons.get(icon)) {
								l.setIcon(null);
							}
						}
					}

				} else {
					if (_board == null) {
						if (_card3 == null) {
							if (_player.getNumOfCards() < 2) {
								_deck.removeCard(c);
								_player.addCard(c);

								if (_card1.getIcon() == null) {
									_card1.setIcon(_icons.get(icon));
								} else {
									_card2.setIcon(_icons.get(icon));
								}

							} else {
								JOptionPane.showMessageDialog(null, message, "Maximo de 2 cartas por jugador",
										JOptionPane.WARNING_MESSAGE);
								buttonList.get(index).setSelected(false);
							}
						} else {
							if (_player.getNumOfCards() < 4) {
								_deck.removeCard(c);
								_player.addCard(c);

								if (_card1.getIcon() == null) {
									_card1.setIcon(_icons.get(icon));
								} else if (_card2.getIcon() == null) {
									_card2.setIcon(_icons.get(icon));
								} else if (_card3.getIcon() == null) {
									_card3.setIcon(_icons.get(icon));
								} else if (_card4.getIcon() == null) {
									_card4.setIcon(_icons.get(icon));
								}
							} else {
								JOptionPane.showMessageDialog(null, message, "Maximo de 4 cartas por jugador",
										JOptionPane.WARNING_MESSAGE);
								buttonList.get(index).setSelected(false);
							}
						}
					} else {
						if (_boardCards.size() < 5) {
							_deck.removeCard(c);
							_boardCards.add(c);

							for (JLabel l : _board) {
								if (l.getIcon() == null) {
									l.setIcon(_icons.get(icon));
									break;
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, message, "Maximo de 5 cartas en el board",
									JOptionPane.WARNING_MESSAGE);
							buttonList.get(index).setSelected(false);
						}
					}
				}
			});
			buttonList.get(i).setIcon(_icons.get(icon));
			i++;
		}

	}

	public void open(Player player, JLabel card1, JLabel card2, ArrayList<JLabel> board, JButton currButton) {
		_player = player;
		_board = board;
		_card1 = card1;
		_card2 = card2;
		_currButton = currButton;
		for (String s : _icons.keySet()) {
			boolean found = false;
			int i = 0;

			Card aux = new Card(s.charAt(0) + "", s.charAt(1) + "", s);
			if (!_deck.containsCard(aux)) {
				while (i < buttonList.size() && !found) {
					if (buttonList.get(i).getIcon().equals(_icons.get(s))) {
						buttonList.get(i).setEnabled(false);
						found = true;
					}
					i++;
				}
			}
		}
		pack();
		setVisible(true);
	}

	public void open(Player player, JLabel card1, JLabel card2, JLabel card3, JLabel card4, ArrayList<JLabel> board,
			JButton currButton) {
		_player = player;
		_board = board;
		_card1 = card1;
		_card2 = card2;
		_card3 = card3;
		_card4 = card4;
		_currButton = currButton;
		for (String s : _icons.keySet()) {
			boolean found = false;
			int i = 0;

			Card aux = new Card(s.charAt(0) + "", s.charAt(1) + "", s);
			if (!_deck.containsCard(aux)) {
				while (i < buttonList.size() && !found) {
					if (buttonList.get(i).getIcon().equals(_icons.get(s))) {
						buttonList.get(i).setEnabled(false);
						found = true;
					}
					i++;
				}
			}
		}
		pack();
		setVisible(true);
	}

	public void reset() {
		int i = 0;
		while (i < buttonList.size()) {
			buttonList.get(i).setEnabled(true);

			i++;
		}
	}

}
