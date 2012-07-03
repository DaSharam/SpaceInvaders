package SpaceInvaders.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import SpaceInvaders.Audio.*;
import SpaceInvaders.strategy.*;
import SpaceInvaders.Core.Game;


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

public class MenuPanel
    extends JPanel implements MouseListener, MouseMotionListener {
  GameFrame parent;
  JButton continueButton, exitButton, optionButton, nextGameButton,
  restartGameButton, backButton, musicONButton, musicOFFButton, FXONButton,
  FXOFFButton;
  public MenuPanel(GameFrame parent) {
    this.parent = parent;
    setOpaque(false);
    setLayout(null);
    addMouseListener(parent.listen);
    addMouseMotionListener(parent.listen);
    setBounds( (parent.width - 450) / 2, (parent.height - 400) / 2, 450, 400);
    Cursor hand = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
//Defining the start menu elements
//generating continue Button
    continueButton = new JButton(new ImageIcon(
        "data/Images/Menu/menu/continue1.gif "));
    continueButton.setDisabledIcon(new ImageIcon(
        "data/Images/Menu/menu/continue1.gif "));
    continueButton.setBounds(250, 100, 100, 60);
    continueButton.setDisabledSelectedIcon(new ImageIcon(
        "data/Images/Menu/menu/continue2.gif "));
    continueButton.setOpaque(false);
    continueButton.setEnabled(false);
    continueButton.setBorderPainted(false);
    continueButton.addMouseListener(this);
    continueButton.addMouseMotionListener(this);
//generating exit Button
    exitButton = new JButton(new ImageIcon("data/Images/Menu/menu/exit1.gif "));
    exitButton.setDisabledIcon(new ImageIcon("data/Images/Menu/menu/exit1.gif "));
    exitButton.setBounds(180, 260, 100, 60);
    exitButton.setEnabled(false);
    exitButton.setDisabledSelectedIcon(new ImageIcon(
        "data/Images/Menu/menu/exit2.gif "));
    exitButton.setOpaque(false);
    exitButton.setBorderPainted(false);
    exitButton.addMouseListener(this);
    exitButton.addMouseMotionListener(this);
//generating option Button
    optionButton = new JButton(new ImageIcon(
        "data/Images/Menu/menu/options1.gif "));
    optionButton.setDisabledIcon(new ImageIcon(
        "data/Images/Menu/menu/options1.gif "));
    optionButton.setBounds(180, 180, 100, 60);
    optionButton.setDisabledSelectedIcon(new ImageIcon(
        "data/Images/Menu/menu/options2.gif "));
    optionButton.setOpaque(false);
    optionButton.setBorderPainted(false);
    optionButton.setEnabled(false);
    optionButton.addMouseListener(this);
    optionButton.addMouseMotionListener(this);
//generating nextGame Button
    nextGameButton = new JButton(new ImageIcon(
        "data/Images/Menu/menu/next1.gif "));
    nextGameButton.setDisabledIcon(new ImageIcon(
        "data/Images/Menu/menu/next1.gif "));
    nextGameButton.setBounds(250, 100, 100, 60);
    nextGameButton.setDisabledSelectedIcon(new ImageIcon(
        "data/Images/Menu/menu/next2.gif "));
    nextGameButton.setOpaque(false);
    nextGameButton.setBorderPainted(false);
    nextGameButton.setEnabled(false);
    nextGameButton.addMouseListener(this);
    nextGameButton.addMouseMotionListener(this);
//generating restartGame Button
    restartGameButton = new JButton(new ImageIcon(
        "data/Images/Menu/menu/restart1.gif"));
    restartGameButton.setDisabledIcon(new ImageIcon(
        "data/Images/Menu/menu/restart1.gif"));
    restartGameButton.setBounds(100, 100, 100, 60);
    restartGameButton.setDisabledSelectedIcon(new ImageIcon(
        "data/Images/Menu/menu/restart2.gif"));
    restartGameButton.setOpaque(false);
    restartGameButton.setBorderPainted(false);
    restartGameButton.setEnabled(false);
    restartGameButton.addMouseListener(this);
    restartGameButton.addMouseMotionListener(this);
//Defining Option menu Button
//generating back Button
    backButton = new JButton(new ImageIcon("data/Images/Menu/menu/back1.gif"));
    backButton.setDisabledIcon(new ImageIcon("data/Images/Menu/menu/back1.gif"));
    backButton.setBounds(85, 256, 100, 60);
    backButton.setDisabledSelectedIcon(new ImageIcon(
        "data/Images/Menu/menu/back2.gif"));
    backButton.setOpaque(false);
    backButton.setBorderPainted(false);
    backButton.setEnabled(false);
    backButton.addMouseListener(this);
    backButton.addMouseMotionListener(this);
//generating musicON Button
    musicONButton = new JButton(new ImageIcon("data/Images/Menu/unCheck.gif"));
    musicONButton.setDisabledIcon(new ImageIcon("data/Images/Menu/unCheck.gif"));
    musicONButton.setBounds(240, 90, 30, 30);
    musicONButton.setDisabledSelectedIcon(new ImageIcon(
        "data/Images/Menu/check.gif"));
    musicONButton.setOpaque(false);
    musicONButton.setBorderPainted(false);
    musicONButton.setEnabled(false);
    musicONButton.addMouseListener(this);
//generating musicOFF Button
    musicOFFButton = new JButton(new ImageIcon("data/Images/Menu/unCheck.gif"));
    musicOFFButton.setDisabledIcon(new ImageIcon(
        "data/Images/Menu/unCheck.gif"));
    musicOFFButton.setBounds(240, 130, 30, 30);
    musicOFFButton.setDisabledSelectedIcon(new ImageIcon(
        "data/Images/Menu/check.gif"));
    musicOFFButton.setOpaque(false);
    musicOFFButton.setBorderPainted(false);
    musicOFFButton.setEnabled(false);
    musicOFFButton.addMouseListener(this);
//generating FXON Button
    FXONButton = new JButton(new ImageIcon("data/Images/Menu/unCheck.gif"));
    FXONButton.setDisabledIcon(new ImageIcon("data/Images/Menu/unCheck.gif"));
    FXONButton.setBounds(240, 180, 30, 30);
    FXONButton.setDisabledSelectedIcon(new ImageIcon(
        "data/Images/Menu/check.gif"));
    FXONButton.setOpaque(false);
    FXONButton.setBorderPainted(false);
    FXONButton.setEnabled(false);
    FXONButton.addMouseListener(this);
//generating FXOFF Button
    FXOFFButton = new JButton(new ImageIcon("data/Images/Menu/unCheck.gif"));
    FXOFFButton.setDisabledIcon(new ImageIcon("data/Images/Menu/unCheck.gif"));
    FXOFFButton.setBounds(240, 220, 30, 30);
    FXOFFButton.setDisabledSelectedIcon(new ImageIcon("data/Images/Menu/check.gif"));
    FXOFFButton.setOpaque(false);
    FXOFFButton.setBorderPainted(false);
    FXOFFButton.setEnabled(false);
    FXOFFButton.addMouseListener(this);
    this.addMouseMotionListener(this);
  }

  public void pauseMenu(boolean type) {
    restartGameButton.setBounds(100, 100, 100, 60);
    parent.repaint.stop();

    parent.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new
        ImageIcon("data/Images/Menu/hand.gif ").getImage(), new Point(17, 17),
        ""));

    if (type) {
      parent.musicPlay.kill();
      parent.musicPlay = new MusicPlayer(true);
      parent.musicPlay.openStream("menu");
      if (parent.music && parent.isActive())
        parent.musicPlay.run();
    }
    removeAll();

    add(restartGameButton);

    add(continueButton);

    add(optionButton);

    add(exitButton);

    setSize(450, 400);

    this.paintImmediately(getBounds());
  }

  public void gameOverMenu() {
    JLabel gameOver = new JLabel(new ImageIcon(
        "data/Images/Menu/menu/gameOver.gif"));
    gameOver.setBounds(125, 180, 200, 60);
    JLabel won = new JLabel(new ImageIcon("data/Images/Menu/menu/won.gif"));
    won.setBounds(125, 180, 200, 60);
    parent.repaint.stop();
    parent.musicPlay = new MusicPlayer(false);
    removeAll();
    restartGameButton.setBounds(180, 100, 100, 60);
    if (parent.space.score == 50) {
      restartGameButton.setBounds(100, 100, 100, 60);
      add(nextGameButton);
      parent.musicPlay.openStream("win");
      add(won);
    }
    else {
      add(gameOver);
      parent.musicPlay.openStream("gameOver");
    }
    if (parent.music)
      parent.musicPlay.run();
    add(restartGameButton);
    add(exitButton);
    setSize(450, 400);
    this.paintImmediately(getBounds());
  }

  public void optionMenu() {
    removeAll();
    if (parent.music)
      musicONButton.setSelected(true);
    else
      musicOFFButton.setSelected(true);
    if (parent.FX)
      FXONButton.setSelected(true);
    else
      FXOFFButton.setSelected(true);
    add(backButton);
    add(musicONButton);
    add(musicOFFButton);
    add(FXOFFButton);
    add(FXONButton);
    JLabel sound = new JLabel(new ImageIcon(
        "data/Images/Menu/menu/sound.gif"));
    sound.setBounds(90, 180, 130, 50);
    JLabel music = new JLabel(new ImageIcon(
        "data/Images/Menu/menu/music.gif"));
    music.setBounds(90, 90, 130, 50);
    JLabel soundON = new JLabel(new ImageIcon("data/Images/Menu/on.gif"));
    soundON.setBounds(285, 180, 100, 50);
    JLabel soundOFF = new JLabel(new ImageIcon("data/Images/Menu/off.gif"));
    soundOFF.setBounds(285, 225, 100, 50);
    JLabel musicON = new JLabel(new ImageIcon("data/Images/Menu/on.gif"));
    musicON.setBounds(285, 90, 100, 50);
    JLabel musicOFF = new JLabel(new ImageIcon("data/Images/Menu/off.gif"));
    musicOFF.setBounds(285, 130, 100, 50);
    add(sound);
    add(music);
    add(soundON);
    add(soundOFF);
    add(musicON);
    add(musicOFF);
    setSize(450, 400);
    this.paintImmediately(getBounds());
  }

  public void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    super.paintComponent(g2d);
//Drawing the background menus
    if (parent.pause || parent.gameOver)
      g.drawImage(new ImageIcon("data/Images/Menu/menu/background.gif").
                  getImage(),
                  0, 0, 450, 400, this);
  }

  public void mouseDragged(MouseEvent e) {
  }

  public void mouseMoved(MouseEvent e) {
    exitButton.setSelected(false);
    optionButton.setSelected(false);
    restartGameButton.setSelected(false);
    backButton.setSelected(false);
    nextGameButton.setSelected(false);
    continueButton.setSelected(false);
    restartGameButton.setSelected(false);
    if (e.getComponent() == exitButton) {
      exitButton.setSelected(true);
      exitButton.paintImmediately(exitButton.getBounds());
    }
    else if (e.getComponent() == restartGameButton) {
      restartGameButton.setSelected(true);
      restartGameButton.paintImmediately(restartGameButton.getBounds());
    }
    else if (e.getComponent() == optionButton) {
      optionButton.setSelected(true);
      optionButton.paintImmediately(optionButton.getBounds());
    }
    else if (e.getComponent() == backButton) {
      backButton.setSelected(true);
      backButton.paintImmediately(backButton.getBounds());
    }
    else if (e.getComponent() == nextGameButton) {
      nextGameButton.setSelected(true);
      nextGameButton.paintImmediately(nextGameButton.getBounds());
    }
    else if (e.getComponent() == continueButton) {
      continueButton.setSelected(true);
      continueButton.paintImmediately(continueButton.getBounds());
    }
    this.paintImmediately(getBounds());
  }

  public void mouseClicked(MouseEvent e) {
    if (e.getComponent() == exitButton)
      System.exit(1);
    else if (e.getComponent() == continueButton) {
      if(parent.music){
        parent.musicPlay.kill();
        parent.musicPlay = new MusicPlayer(true);
        parent.musicPlay.openStream("stage" + parent.stage );
      }
      parent.menuPanel.removeAll();
      parent.pause = false;
      parent.game = new Game(parent);
      parent.game.start();
      parent.game.yield();
    }
    else if (e.getComponent() == restartGameButton) {
      parent.musicPlay.kill();
      new Loader(parent.music, parent.FX, parent.width, parent.gameType,
                 parent.stage, parent.level, parent);
    }
    else if (e.getComponent() == nextGameButton) {
      parent.musicPlay.kill();
      if (parent.level == 3) {
        parent.level = 0;
        parent.stage++;
      }
      new Loader(parent.music, parent.FX, parent.width, parent.gameType,
                 parent.stage, parent.level, parent);
    }
    else if (e.getComponent() == optionButton)
      optionMenu();
    else if (e.getComponent() == backButton) {
      if (FXONButton.isSelected())
        parent.FX = true;
      else if (FXOFFButton.isSelected())
        parent.FX = false;
      if (musicONButton.isSelected())
        parent.music = true;
      else if (musicOFFButton.isSelected())
        parent.music = false;
      if (parent.gameOver)
        gameOverMenu();
      else
        pauseMenu(false);
    }
    else if (e.getComponent() == musicONButton) {
      parent.musicPlay.play();
      parent.music = true;
      musicONButton.setSelected(true);
      musicOFFButton.setSelected(false);
      this.paintImmediately(getBounds());
    }
    else if (e.getComponent() == musicOFFButton) {
      parent.musicPlay.stopPlay();
      parent.music = false;
      musicOFFButton.setSelected(true);
      musicONButton.setSelected(false);
      this.paintImmediately(getBounds());
    }
    else if (e.getComponent() == FXOFFButton) {
      parent.FX = false;
      FXOFFButton.setSelected(true);
      FXONButton.setSelected(false);
      this.paintImmediately(getBounds());
    }
    else if (e.getComponent() == FXONButton) {
      parent.FX = true;
      FXOFFButton.setSelected(false);
      FXONButton.setSelected(true);
      this.paintImmediately(getBounds());
    }
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

  public void mousePressed(MouseEvent e) {
  }

  public void mouseReleased(MouseEvent e) {
  }
}

