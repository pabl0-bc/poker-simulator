package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import controller.Controller;
import logic.CombinationGenerator;
import objects.Card;
import objects.Deck;
import objects.Player;

public class MainWindow extends JFrame {

	private javax.swing.JLabel fondo;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JButton omahaButton;
	private javax.swing.JButton pokerButton;
	private String[] folders = { "clubs", "diamonds", "hearts", "spades" };
	private Map<String, ImageIcon> icons;
	private Omaha _omaha;
	private Poker _poker;
	private Controller _ctrl;
	private Deck _deck;
	private ArrayList<Player> _players;
	

	public MainWindow(Deck deck, ArrayList<Player> players, Controller ctrl) {
		_ctrl = ctrl;
		_deck = deck;
		_players = players;
		icons = new LinkedHashMap<>();
		initIcons();
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
        pokerButton = new javax.swing.JButton();
        omahaButton = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sportium3");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));


        pokerButton.setBorder(null);
        pokerButton.setContentAreaFilled(false);
        pokerButton.addActionListener((e)->{
        	removeAll();
        	_poker = new Poker(_deck, _players, _ctrl, icons);
        	setVisible(false);
        });

        omahaButton.setBorder(null);
        omahaButton.setContentAreaFilled(false);
        omahaButton.addActionListener((e)->{
        	removeAll();
        	_omaha = new Omaha(_deck, _players, _ctrl, icons);
        	setVisible(false);

        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(pokerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(720, 720, 720)
                .addComponent(omahaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pokerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(omahaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

		
		File f = new File("icons/jij.png");
		if (f != null) {
			try {
				BufferedImage faux = ImageIO.read(f);
				fondo.setIcon(escalarImagen(faux, 1100, 650));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		File p = new File("icons/poker.png");
		if (p != null) {
			try {
				BufferedImage paux = ImageIO.read(p);
				pokerButton.setIcon(escalarImagen(paux, 210, 210));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		File o = new File("icons/omaha.png");
		if (o != null) {
			try {
				BufferedImage oaux = ImageIO.read(o);
				omahaButton.setIcon(escalarImagen(oaux, 210, 210));
			    omahaButton.setDisabledIcon(escalarImagen(oaux, 210, 210));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		pack();
	    setLocationRelativeTo(null);
		setVisible(true);
	}// </editor-fold>

	private ImageIcon escalarImagen(BufferedImage img, int ancho, int alto) {
		Image imagenEscalada = img.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
		return new ImageIcon(imagenEscalada);
	}
	
	private void initIcons() {
		String route = "icons/CARTAS/";

		for (String s : folders) {
			String routeAux = route + s;

			File carpeta = new File(routeAux);

			if (carpeta.isDirectory()) {
				File[] archivos = carpeta.listFiles();

				if (archivos != null) {
					for (File archivo : archivos) {
						String aux = archivo.getName();
						aux = aux.substring(1);
						if (archivo.isFile() && archivo.getName().toLowerCase().endsWith(".png")) {
							try {

								BufferedImage img = ImageIO.read(archivo);

								icons.put(aux.replace(".png", ""), escalarImagen(img, 70, 110));

							} catch (IOException e) {
								e.getMessage();
							}
						}
					}
				}
			} else {
				System.out.println("La ruta no es un directorio.");
			}
		}
	}


}
