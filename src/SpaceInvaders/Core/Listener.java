package SpaceInvaders.Core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import SpaceInvaders.Audio.MusicPlayer;
import SpaceInvaders.GUI.GameFrame;

/**
 *<p>Title:Space Invaders</p>
 *
 *<p>Description: Besigned By H.R.</p>
 *
 *<p>Copyright : Copyright (c)2006</p>
 *
 *
 *
 *@author MuRF
 *@Version 1.0
 */

public class Listener
    implements KeyListener, MouseMotionListener, MouseListener {
  GameFrame parent;
  String cheat;

  public Listener(GameFrame parent) {
    this.parent = parent;
    cheat = "";
  }

  public void keyPressed(KeyEvent e) {
    if(parent.pause && e.getKeyCode() == KeyEvent.VK_ESCAPE){
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
    if (!parent.pause && !parent.gameOver) {
      if (e.getKeyCode() == KeyEvent.VK_RIGHT && !parent.space.sShot) {
        if (parent.space.x < parent.width - parent.space.width)
          parent.space.x += 10;
      }
      if (e.getKeyCode() == KeyEvent.VK_LEFT && !parent.space.sShot) {
        if (parent.space.x > 0)
          parent.space.x -= 10;
      }
      if (e.getKeyCode() == KeyEvent.VK_SPACE && !parent.space.sShot &&
          parent.bulletPlayerList.size() < 5) {
        parent.space.getBullet(parent.bulletPlayerList);
        if (parent.FX) {
          MusicPlayer play = new MusicPlayer(false);
          play.openStream("shoot");
          new Thread(play).start();
        }
      }
      if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
        parent.pause = true;
        parent.menuPanel.pauseMenu(true);
        parent.repaint.stop();
        parent.menuPanel.paintImmediately(0, 0, parent.menuPanel.WIDTH,
                                          parent.menuPanel.HEIGHT);
      }
    }
  }

  public void keyReleased(KeyEvent e) {

  }

  public void keyTyped(KeyEvent e) {
    cheat = cheat + e.getKeyChar();
    if (cheat.endsWith("power"))
      if(parent.space.power<5)
        parent.space.power++;
    if (cheat.length() > 10) {
      cheat = "";
    }
  }

  public void mouseDragged(MouseEvent e) {
  }

  public void mouseMoved(MouseEvent e) {
    if (!parent.pause && !parent.gameOver && !parent.space.sShot) {
      parent.space.x = e.getX();
    }
  }

  public void mouseClicked(MouseEvent e) {
    if (!parent.pause && !parent.gameOver)
      if (!parent.space.sShot && parent.bulletPlayerList.size() < 5) {
        parent.space.getBullet(parent.bulletPlayerList);
        if (parent.FX) {
          MusicPlayer play = new MusicPlayer(false);
          play.openStream("shoot");
          new Thread(play).start();
        }
      }
  }

  public void mousePressed(MouseEvent e) {
  }

  public void mouseReleased(MouseEvent e) {
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }
}
