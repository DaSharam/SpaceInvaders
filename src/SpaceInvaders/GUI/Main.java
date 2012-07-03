package SpaceInvaders.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import SpaceInvaders.Audio.*;
import SpaceInvaders.strategy.*;

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
 *@Version 0.5
 */

public class Main
    extends JFrame implements MouseListener, MouseMotionListener {
  JButton newGameButton, exitButton, optionsButton, backButton, classicButton,
      modernButton, fantasyButton, Button800, Button1024,
  musicONButton, musicOFFButton, FXONButton, FXOFFButton;
  boolean FX = true, music = true;
  int gameTypeValue = 2, screenSizeValue = 800;
  public MusicPlayer musicPlay;
  JPanel panel;
  public Main() {
    super("Space Invaders");
    setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new ImageIcon(
        "data/Images/Menu/hand.gif").getImage(), new Point(2, 2), ""));
    setUndecorated(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    panel = new optionPanel();
    getContentPane().add("Center", panel);
    setSize(500, 500);
    setLocationRelativeTo(null);
    setVisible(true);
    addMouseMotionListener(Main.this);
    musicPlay = new MusicPlayer(true);
    musicPlay.openStream("menu");
    musicPlay.run();
  }

  public static void main(String[] args) {
    System.out.println(System.getProperty("user.dir"));
    new Main();
  }

  public void mouseClicked(MouseEvent e) {
    if (e.getComponent() == exitButton)
      System.exit(1);
    else if (e.getComponent() == newGameButton)
      new Loader(music, FX, screenSizeValue, gameTypeValue, 1, 1, this);
    else if (e.getComponent() == optionsButton)
      displayOptionsMenu();
    else if (e.getComponent() == backButton){
      panel.removeAll();
    if (classicButton.isSelected())
      gameTypeValue = 1;
    else if (modernButton.isSelected())
      gameTypeValue = 2;
    if (fantasyButton.isSelected())
      gameTypeValue = 3;
    if (Button800.isSelected())
      screenSizeValue = 800;
    if (Button1024.isSelected())
      screenSizeValue = 1024;
    if (FXONButton.isSelected())
      FX = true;
    if (FXOFFButton.isSelected())
      FX = false;
    if (musicONButton.isSelected())
      music = true;
    if (musicOFFButton.isSelected())
      music = false;
      panel.add(newGameButton);
      panel.add(exitButton);
      panel.add(optionsButton);
      panel.repaint();
    }
    else if (e.getComponent() == classicButton) {
      classicButton.setSelected(true);
      modernButton.setSelected(false);
      fantasyButton.setSelected(false);
      panel.repaint();
    }
    else if (e.getComponent() == fantasyButton) {
      fantasyButton.setSelected(true);
      classicButton.setSelected(false);
      modernButton.setSelected(false);
      panel.repaint();
    }
    else if (e.getComponent() == modernButton) {
      modernButton.setSelected(true);
      classicButton.setSelected(false);
      fantasyButton.setSelected(false);
      panel.repaint();
    }
    else if (e.getComponent() == Button800) {
      Button800.setSelected(true);
      Button1024.setSelected(false);
      panel.repaint();
    }
    else if (e.getComponent() == Button1024) {
      Button1024.setSelected(true);
      Button800.setSelected(false);
      panel.repaint();
    }
    else if (e.getComponent() == musicONButton) {
      musicPlay.play();
      musicONButton.setSelected(true);
      musicOFFButton.setSelected(false);
      panel.repaint();
    }
    else if (e.getComponent() == musicOFFButton) {
      musicPlay.stopPlay();
      musicOFFButton.setSelected(true);
      musicONButton.setSelected(false);
      panel.repaint();
    }
    else if (e.getComponent() == FXOFFButton) {
      FXOFFButton.setSelected(true);
      FXONButton.setSelected(false);
      panel.repaint();
    }
    else if (e.getComponent() == FXONButton) {
      FXONButton.setSelected(true);
      FXOFFButton.setSelected(false);
      panel.repaint();
    }
  }

  /**
   *Displays Option Window
   * adding labels and bullets
   *setting the selected values of check buttons
   */

  private void displayOptionsMenu() {
    panel.removeAll();
//obtaining the selected values
    if (gameTypeValue == 1)
      classicButton.setSelected(true);
    else if (gameTypeValue == 2)
      modernButton.setSelected(true);
    else if (gameTypeValue == 3)
      fantasyButton.setSelected(true);
    if (screenSizeValue == 800)
      Button800.setSelected(true);
    else if (screenSizeValue == 1024)
      Button1024.setSelected(true);
    if (music)
      musicONButton.setSelected(true);
    else
      musicOFFButton.setSelected(true);
    if (FX)
      FXONButton.setSelected(true);
    else
      FXOFFButton.setSelected(true);
//defining the labels
    JLabel musicLabel = new JLabel(new ImageIcon(
        "data/Images/Menu/startMenu/music.gif"));
    musicLabel.setBounds(70, 80, 100, 50);
    JLabel musicONLabel = new JLabel(new ImageIcon("data/Images/Menu/on.gif"));
    musicONLabel.setBounds(260, 80, 100, 50);
    JLabel musicOFFLabel = new JLabel(new ImageIcon("data/Images/Menu/off.gif"));
    musicOFFLabel.setBounds(340,80, 100, 50);
    JLabel FXLabel = new JLabel(new ImageIcon(
        "data/Images/Menu/startMenu/sound.gif"));
    FXLabel.setBounds(70, 130, 170, 50);
    JLabel FXONLabel = new JLabel(new ImageIcon("data/Images/Menu/on.gif"));
    FXONLabel.setBounds(260, 130, 100, 50);
    JLabel FXOFFLabel = new JLabel(new ImageIcon("data/Images/Menu/off.gif"));
    FXOFFLabel.setBounds(340, 130, 100, 50);
    JLabel gameTypeLabel = new JLabel(new ImageIcon(
        "data/Images/Menu/startMenu/gameType.gif"));
    gameTypeLabel.setBounds(70, 180, 170, 50);
    JLabel screenSizeLabel = new JLabel(new ImageIcon(
        "data/Images/Menu/startMenu/screenSize.gif"));
    screenSizeLabel.setBounds(70, 315, 170, 50);
    JLabel classicLabel = new JLabel(new ImageIcon(
        "data/Images/Menu/startMenu/classic.gif"));
    classicLabel.setBounds(280, 195, 100, 50);
    JLabel fantasyLabel = new JLabel(new ImageIcon(
        "data/Images/Menu/startMenu/fantasy.gif"));
    fantasyLabel.setBounds(280, 265, 100, 50);
    JLabel modernLabel = new JLabel(new ImageIcon(
        "data/Images/Menu/startMenu/modern.gif"));
    modernLabel.setBounds(280, 230, 100, 50);
    JLabel Label800 = new JLabel(new ImageIcon(
        "data/Images/Menu/startMenu/800.gif"));
    Label800.setBounds(280, 320, 100, 50);
    JLabel Label1024 = new JLabel(new ImageIcon(
        "data/Images/Menu/startMenu/1024.gif"));
    Label1024.setBounds(280, 355, 100, 50);
//adding buttons to panel
    panel.add(musicONButton);
    panel.add(musicOFFButton);
    panel.add(FXONButton);
    panel.add(FXOFFButton);
    panel.add(Button800);
    panel.add(Button1024);
    panel.add(fantasyButton);
    panel.add(modernButton);
    panel.add(classicButton);
    panel.add(backButton);
//adding labels to panel
    panel.add(musicONLabel);
    panel.add(musicOFFLabel);
    panel.add(FXONLabel);
    panel.add(FXOFFLabel);
    panel.add(Label800);
    panel.add(Label1024);
    panel.add(fantasyLabel);
    panel.add(modernLabel);
    panel.add(classicLabel);
    panel.add(musicLabel);
    panel.add(screenSizeLabel);
    panel.add(gameTypeLabel);
    panel.add(FXLabel);
    panel.repaint();
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

  public void mousePressed(MouseEvent e) {
  }

  public void mouseReleased(MouseEvent e) {
  }

  public void mouseDragged(MouseEvent e) {
  }

  public void mouseMoved(MouseEvent e) {
    exitButton.setSelected(false);
    optionsButton.setSelected(false);
    newGameButton.setSelected(false);
    backButton.setSelected(false);
    if (e.getComponent() == exitButton) {
      exitButton.setSelected(true);
      exitButton.paintImmediately(exitButton.getBounds());
    }
    else if (e.getComponent() == newGameButton) {
      newGameButton.setSelected(true);
      newGameButton.paintImmediately(newGameButton.getBounds());
    }
    else if (e.getComponent() == optionsButton) {
      optionsButton.setSelected(true);
      optionsButton.paintImmediately(optionsButton.getBounds());
    }
    else if (e.getComponent() == backButton) {
      backButton.setSelected(true);
      backButton.paintImmediately(backButton.getBounds());
    }
  }

  class optionPanel
      extends JPanel {
    public optionPanel() {
      setLayout(null);
//Defining the start menu elements
//Generating Option Button
      optionsButton = new JButton(new ImageIcon(
          "data/Images/Menu/startMenu/option1.gif"));
      optionsButton.setDisabledIcon(new ImageIcon(
          "data/Images/Menu/startMenu/option1.gif"));
      optionsButton.setBounds(150, 190, 200, 118);
      optionsButton.setDisabledSelectedIcon(new ImageIcon(
          "data/Images/Menu/startMenu/option2.gif"));
      optionsButton.setOpaque(false);
      optionsButton.setBorderPainted(false);
      optionsButton.setEnabled(false);
      optionsButton.addMouseListener(Main.this);
      optionsButton.addMouseMotionListener(Main.this);
//Generating new game Button
      newGameButton = new JButton(new ImageIcon(
          "data/Images/Menu/startMenu/new1.gif"));
      newGameButton.setDisabledIcon(new ImageIcon(
          "data/Images/Menu/startMenu/new1.gif"));
      newGameButton.setBounds(150, 60, 200, 121);
      newGameButton.setDisabledSelectedIcon(new ImageIcon(
          "data/Images/Menu/startMenu/new2.gif"));
      newGameButton.setOpaque(false);
      newGameButton.setBorderPainted(false);
      newGameButton.setEnabled(false);
      newGameButton.addMouseListener(Main.this);
      newGameButton.addMouseMotionListener(Main.this);
//Generating exit game Button
      exitButton = new JButton(new ImageIcon(
          "data/Images/Menu/startMenu/exit1.gif"));
      exitButton.setDisabledIcon(new ImageIcon(
          "data/Images/Menu/startMenu/exit1.gif"));
      exitButton.setBounds(150, 320, 200, 120);
      exitButton.setDisabledSelectedIcon(new ImageIcon(
          "data/Images/Menu/startMenu/exit2.gif"));
      exitButton.setOpaque(false);
      exitButton.setEnabled(false);
      exitButton.setBorderPainted(false);
      exitButton.addMouseListener(Main.this);
      exitButton.addMouseMotionListener(Main.this);
//Defining option menu Button
//Generating back Button
      backButton = new JButton(new ImageIcon(
          "data/Images/Menu/startMenu/back1.gif"));
      backButton.setDisabledIcon(new ImageIcon(
          "data/Images/Menu/startMenu/back1.gif"));
      backButton.setBounds(80, 400, 200, 100);
      backButton.setDisabledSelectedIcon(new ImageIcon(
          "data/Images/Menu/startMenu/back2.gif"));
      backButton.setOpaque(false);
      backButton.setBorderPainted(false);
      backButton.setEnabled(false);
      backButton.addMouseListener(Main.this);
      backButton.addMouseMotionListener(Main.this);
//Generating classic check Button
      classicButton = new JButton(new ImageIcon("data/Images/Menu/unCheck.gif "));
      classicButton.setDisabledIcon(new ImageIcon(
          "data/Images/Menu/unCheck.gif"));
      classicButton.setBounds(250, 200, 30, 30);
      classicButton.setDisabledSelectedIcon(new ImageIcon(
          "data/Images/Menu/Check.gif"));
      classicButton.setOpaque(false);
      classicButton.setBorderPainted(false);
      classicButton.setEnabled(false);
      classicButton.addMouseListener(Main.this);
//Generating modern check Button
      modernButton = new JButton(new ImageIcon("data/Images/Menu/unCheck.gif "));
      modernButton.setDisabledIcon(new ImageIcon("data/Images/Menu/unCheck.gif"));
      modernButton.setBounds(250, 235, 30, 30);
      modernButton.setDisabledSelectedIcon(new ImageIcon(
          "data/Images/Menu/Check.gif"));
      modernButton.setOpaque(false);
      modernButton.setBorderPainted(false);
      modernButton.setEnabled(false);
      modernButton.addMouseListener(Main.this);
//Generating fantasy check Button
      fantasyButton = new JButton(new ImageIcon("data/Images/Menu/unCheck.gif "));
      fantasyButton.setDisabledIcon(new ImageIcon(
          "data/Images/Menu/unCheck.gif"));
      fantasyButton.setBounds(250, 270, 30, 30);
      fantasyButton.setDisabledSelectedIcon(new ImageIcon(
          "data/Images/Menu/Check.gif"));
      fantasyButton.setOpaque(false);
      fantasyButton.setBorderPainted(false);
      fantasyButton.setEnabled(false);
      fantasyButton.addMouseListener(Main.this);
//Generating 800x600 check Button
      Button800 = new JButton(new ImageIcon("data/Images/Menu/unCheck.gif "));
      Button800.setDisabledIcon(new ImageIcon("data/Images/Menu/unCheck.gif"));
      Button800.setBounds(250, 330, 30, 30);
      Button800.setDisabledSelectedIcon(new ImageIcon(
          "data/Images/Menu/Check.gif"));
      Button800.setOpaque(false);
      Button800.setBorderPainted(false);
      Button800.setEnabled(false);
      Button800.addMouseListener(Main.this);
//Generating 1024x768 check Button
      Button1024 = new JButton(new ImageIcon("data/Images/Menu/unCheck.gif "));
      Button1024.setDisabledIcon(new ImageIcon("data/Images/Menu/unCheck.gif"));
      Button1024.setBounds(250, 365, 30, 30);
      Button1024.setDisabledSelectedIcon(new ImageIcon(
          "data/Images/Menu/Check.gif"));
      Button1024.setOpaque(false);
      Button1024.setBorderPainted(false);
      Button1024.setEnabled(false);
      Button1024.addMouseListener(Main.this);
//Generating Music On check Button
      musicONButton = new JButton(new ImageIcon("data/Images/Menu/unCheck.gif "));
      musicONButton.setDisabledIcon(new ImageIcon(
          "data/Images/Menu/unCheck.gif"));
      musicONButton.setBounds(250, 90, 30, 30);
      musicONButton.setDisabledSelectedIcon(new ImageIcon(
          "data/Images/Menu/Check.gif"));
      musicONButton.setOpaque(false);
      musicONButton.setBorderPainted(false);
      musicONButton.setEnabled(false);
      musicONButton.addMouseListener(Main.this);
//Generating Music Off check Button
      musicOFFButton = new JButton(new ImageIcon(
          "data/Images/Menu/unCheck.gif "));
      musicOFFButton.setDisabledIcon(new ImageIcon(
          "data/Images/Menu/unCheck.gif"));
      musicOFFButton.setBounds(330, 90, 30, 30);
      musicOFFButton.setDisabledSelectedIcon(new ImageIcon(
          "data/Images/Menu/Check.gif"));
      musicOFFButton.setOpaque(false);
      musicOFFButton.setBorderPainted(false);
      musicOFFButton.setEnabled(false);
      musicOFFButton.addMouseListener(Main.this);
//Generating FXON check Button
      FXONButton = new JButton(new ImageIcon("data/Images/Menu/unCheck.gif "));
      FXONButton.setDisabledIcon(new ImageIcon("data/Images/Menu/unCheck.gif"));
      FXONButton.setBounds(250,140, 30, 30);
      FXONButton.setDisabledSelectedIcon(new ImageIcon(
          "data/Images/Menu/Check.gif"));
      FXONButton.setOpaque(false);
      FXONButton.setBorderPainted(false);
      FXONButton.setEnabled(false);
      FXONButton.addMouseListener(Main.this);
//Generating FXOFF check Button
      FXOFFButton = new JButton(new ImageIcon("data/Images/Menu/unCheck.gif "));
      FXOFFButton.setDisabledIcon(new ImageIcon("data/Images/Menu/unCheck.gif"));
      FXOFFButton.setBounds(330,140, 30, 30);
      FXOFFButton.setDisabledSelectedIcon(new ImageIcon(
          "data/Images/Menu/Check.gif"));
      FXOFFButton.setOpaque(false);
      FXOFFButton.setBorderPainted(false);
      FXOFFButton.setEnabled(false);
      FXOFFButton.addMouseListener(Main.this);
//adding Start menu Elements
      add(exitButton);
      add(newGameButton);
      add(optionsButton);
      setOpaque(false);
    }

    public void paintComponent(Graphics g) {
      Graphics2D g2d = (Graphics2D) g;
      super.paintComponent(g2d);
//Drawing the backGround of menus
      g.drawImage(new ImageIcon("data/Images/Menu/startMenu/startBack.gif ").
                  getImage(), 0, 0, 500, 500, this);
    }
  }
}
