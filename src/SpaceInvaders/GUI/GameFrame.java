package SpaceInvaders.GUI;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import SpaceInvaders.Audio.MusicPlayer;
import SpaceInvaders.Core.Game;
import SpaceInvaders.Core.Listener;
import SpaceInvaders.Core.Entities.Players.Player;
import SpaceInvaders.strategy.Loader;

/**
 *<p>Title:Space Invaders</p>
 *
 *<p>Description: Besigned By H.R.</p>
 *
 *<p>Copyright : Copyright (c)2005</p>
 *
 *
 *
 *@author MuRF
 *@Version 1.0
 */
public class GameFrame
    extends JFrame implements ActionListener, WindowListener {
  /**
	 *
	 */
	private static final long serialVersionUID = 1L;
public Vector bulletEnemyList, bulletPlayerList, enemyList[], death, bonus;
  public Player space;
  public boolean gameOver = false, pause = false;
  public int width, height, gameType, fantasyCount = 0, stage, level;
  public boolean music, FX;
  public EnemyPanel enemyPanel;
  public BulletPanel bulletPanel;
  public DeathPanel deathPanel;
  public MainPanel mainPanel;
  public MenuPanel menuPanel;
  public MusicPlayer musicPlay;
  public JPanel main;
  public Game game;
  public javax.swing.Timer repaint;
  public boolean start = true;
  public Listener listen;
  public GameFrame(int ScreenWidth, int screenHeight, int gameType, int stage,
                   int level, boolean music, boolean FX) {
    super("Space Invaders By MuRF");
    setUndecorated(true);
    setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    getContentPane().setLayout(null);
    this.stage = stage;
    this.level = level;
    bulletEnemyList = new Vector(5);
    bulletPlayerList = new Vector(5);
    bonus = new Vector();
    enemyList = new Vector[5];
    for (int i = 0; i < 5; i++)
      enemyList[i] = new Vector();
    death = new Vector();
    width = ScreenWidth;
    height = screenHeight;
    this.music = music;
    this.FX = FX;
    this.gameType = gameType;
    this.setResizable(false);
    enemyPanel = new EnemyPanel(this);
    bulletPanel = new BulletPanel(this);
    deathPanel = new DeathPanel(this);
    mainPanel = new MainPanel(this);
    menuPanel = new MenuPanel(this);
    enemyPanel.setSize(width, height);
    bulletPanel.setSize(width, height);
    mainPanel.setSize(width, height);
    deathPanel.setSize(width, height);
    main = new JPanel(null, false);
    main.add(menuPanel);
    menuPanel.setEnabled(false);
    main.add(deathPanel);
    main.add(enemyPanel);
    main.add(bulletPanel);
    main.add(mainPanel);
    main.setOpaque(false);
    main.setBounds(0, 0, width, height);
    listen = new Listener(this);
    main.addKeyListener(listen);
    addKeyListener(listen);
    addMouseListener(listen);
    addMouseMotionListener(listen);
    getContentPane().add(main);
    setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(
        "data/Images/Menu/hand.gif").getImage(), new Point(2, 2), ""));
    setBounds(0, 0, width, height);
    setSize(width, height);
    addWindowListener(this);
  }

  public void setEnabled(Loader parent) {
    parent.removeAll();
    parent.dispose();
    parent.invalidate();
    repaint = new javax.swing.Timer(200, this);
    musicPlay = new MusicPlayer(true);
    musicPlay.openStream("stage" + stage);
game = new Game(this);
    game.start();
    game.yield();

  }

  public void actionPerformed(ActionEvent e) {
    if (!pause)
      main.paintImmediately(main.getBounds());
  }

  public void windowOpened(WindowEvent e) {
  }

  public void windowClosing(WindowEvent e) {
  }

  public void windowClosed(WindowEvent e) {
  }

  public void windowIconified(WindowEvent e) {
  }

  public void windowDeiconified(WindowEvent e) {
  }

  public void windowActivated(WindowEvent e) {

    if (pause) {
      pause = false;
      repaint.restart();
game = new Game( this , false );
      game.start();
      repaint.start();
      if (music)
        musicPlay.play();

    }
  }

  public void windowDeactivated(WindowEvent e) {

    pause = true;
    repaint.stop();
    if (music)
      musicPlay.stopPlay();
    setState(JFrame.ICONIFIED);

  }
}
