package SpaceInvaders.strategy;

import java.lang.reflect.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import SpaceInvaders.GUI.GameFrame;
import SpaceInvaders.Core.Entities.Players.RedSpaceShip;
import SpaceInvaders.GUI.Main;

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
 *@Version 0.1
 */
public class Loader
    extends JFrame implements ChangeListener, ActionListener {
  boolean music, FX;
  int screenWidth, screenHeight, gameType, level, stage;
  JProgressBar bar;
  JPanel load;
  GraphicsDevice device;
  DisplayMode mode;
  GameFrame game;

  /**
   *
   *@param music boolean
   *@param FX boolean
   *@param screen int
   *@param gameType int
   *@param stage int
   */
  public Loader(boolean music, boolean FX, int screen, int gameType, int level,
                int stage, JFrame parent) {
    super("Loading...");
    parent.removeAll();
    parent.invalidate();
    parent.dispose();
    setUndecorated(true);
    if (parent instanceof Main)
      ( (Main) parent).musicPlay.kill();
      this.music = music;
      this.FX = FX;
      screenWidth = screen;
      if (screen == 800)
        screenHeight = 600;
      else
        screenHeight = 768;
      this.gameType = gameType;
      this.level = level;
      this.stage = stage;
      getContentPane().setLayout(null);
      load = new LoaderPanel();
      getContentPane().add(load);
      setSize(400, 300);
      setLocationRelativeTo(null);
      setVisible(true);
      load();
    //
  }

  /**
   *load elements of level
   */
  private void load() {
    GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
    device = env.getDefaultScreenDevice();
    mode = new DisplayMode(screenWidth, screenHeight, 32,
                           DisplayMode.REFRESH_RATE_UNKNOWN);
    bar.setValue(bar.getValue() + 10);
    load.repaint();
    game = new GameFrame(screenWidth, screenHeight, gameType, stage, level,
                         music, FX);
    game.space = new RedSpaceShip( (screenWidth - 50) / 2, screenHeight - 50,
                                 50, 50);
    bar.setValue(bar.getValue() + 20);
    load.repaint();
    initialEnemies(game);
    bar.setValue(bar.getValue() + 70);
    load.repaint();
    Timer a = new Timer(1000, this);
    a.setRepeats(false);
    a.start();
  }

  /**
   *initializes the Enemy Object corresponding to gameType of GameFrame
   *
   *@param game GameFrame
   */
  private void initialEnemies(GameFrame game) {
    Class enemy = null;
    try {
      enemy = Class.forName("SpaceInvaders.Core.Entities.Enemies." +
                            Levels.EnemyName[ (stage - 1) * 3 + (level - 1)]);
    }
    catch (ClassNotFoundException ex) {
    }
    Constructor[] enemyCons = enemy.getConstructors();
    int enemyWidth = 30, enemyHeight = 40;
    for (int i = 0; i < 5; i++)
      for (int j = 0; j < 10; j++)
        try {
          Integer x = new Integer(10 + (enemyWidth + 10) * j);
          Integer y = new Integer(50 + (enemyHeight + 10) * i);
          Integer w = new Integer(enemyWidth);
          Integer h = new Integer(enemyHeight);
          game.enemyList[i].add(enemyCons[0].newInstance(new Object[] {x, y, w,
              h}));
        }
        catch (Exception ex1) {
        }
  }

  public void stateChanged(ChangeEvent e) {
    if ( ( (JProgressBar) e.getSource()).getValue() < 100)
      bar.repaint();
  }

  public void actionPerformed(ActionEvent e) {
    device.setFullScreenWindow(game);
    device.setDisplayMode(mode);
    game.setEnabled(this);

  }

  public class LoaderPanel
      extends JPanel {
    public LoaderPanel() {
      Font font = new Font("lucida handwriting", Font.BOLD + Font.ITALIC, 24);
      Color color = new Color(200, 190, 50);
      JLabel loading = new JLabel("Loading....");
      loading.setFont(font);
      loading.setForeground(color);
      loading.setBounds(120, 50, 200, 40);
      JLabel stageLabel = new JLabel("Stage" + stage);
      stageLabel.setFont(font);
      stageLabel.setForeground(color);
      stageLabel.setBounds(140, 110, 200, 40);
      JLabel levelLabel = new JLabel("Level" + level);
      levelLabel.setFont(font);
      levelLabel.setForeground(color);
      levelLabel.setBounds(140, 150, 200, 40);
      bar = new JProgressBar(0, 100);
      bar.setValue(0);
      bar.setForeground(new Color(220, 190, 50));
      bar.addChangeListener(Loader.this);
      bar.setBounds(100, 200, 200, 25);
      setLayout(null);
      add(bar);
      add(stageLabel);
      add(levelLabel);
      add(loading);
      setSize(400, 300);
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.drawImage(new ImageIcon("data/Images/Menu/startMenu/loader.gif").
                  getImage(),
                  0, 0, 400, 300, this);
    }
  }
}
