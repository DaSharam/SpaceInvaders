package SpaceInvaders.Core;

import java.util.*;

import java.awt.*;
import javax.swing.*;

import SpaceInvaders.Audio.*;
import SpaceInvaders.Core.Entities.*;
import SpaceInvaders.Core.Entities.Bullets.*;
import SpaceInvaders.Core.Entities.Enemies.*;
import SpaceInvaders.GUI.*;

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
 *@Version 0.5
 */

public class Game
    extends Thread {
  GameFrame parent;
  boolean start = true;

  public Game(GameFrame parent) {
    this.parent = parent;
  }

  public Game(GameFrame parent, boolean start) {
    this(parent);
    this.start = start;
  }

  public void run() {
    if (parent.music && start)
      parent.musicPlay.run();
    parent.repaint.start();
    while (!parent.pause) {
      parent.repaint.stop();
      if (parent.gameType != 1)
        shoot();
      move();
      checkCrash();
      if (parent.space.score == 50 || parent.space.isDead()) {
        parent.bulletEnemyList.removeAllElements();
        parent.bulletPlayerList.removeAllElements();
        parent.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(new
            ImageIcon("data/Images/Menu/hand.gif").getImage(), new Point(2, 2),
            ""));
        if (parent.music)
          parent.musicPlay.kill();
        parent.pause = true;

        parent.menuPanel.gameOverMenu();
      }
      parent.repaint.start();
      try {
        Thread.sleep(200);
      }

      catch (InterruptedException ex) {
      }
    }

  }

  /**
   *shoot
   */
  private void shoot() {
    Random random = new Random();
    int x = random.nextInt() % 5;
    x = x > 0 ? x : x * -1;
    if (!parent.enemyList[x].isEmpty()) {
      int y = random.nextInt() % parent.enemyList[x].size();
      y = y > 0 ? y : y * -1;
      if (parent.bulletEnemyList.size() < 6)
        parent.bulletEnemyList.add( ( (Entity) parent.enemyList[x].get(y)).
                                   getBullet());
    }
  }

  private void checkCrash() {
    boolean flag = true;
    for (int j = 0; j < parent.bulletEnemyList.size(); j++)
      if (checkSpaceDeath(j))
        parent.bulletEnemyList.remove(j--);
    for (int j = 0; j < parent.bonus.size(); j++)
      if (checkSpaceBounce(j))
        parent.bonus.remove(j--);
    for (int i = 0; i < parent.bulletPlayerList.size(); i++) {
      for (int j = 0; j < 5; j++)
        if (!parent.enemyList[j].isEmpty() && flag)
          for (int k = 0; k < parent.enemyList[j].size(); k++)
            if (flag)
              if (checkEnemyDeath(i, j, k)) {
                parent.bulletPlayerList.remove(i--);
                parent.enemyList[j].remove(k--);
                flag = false;
              }

      for (int j = 0; j < parent.bulletEnemyList.size(); j++)
        if (flag)
          if (crashed( ( (Bullet) parent.bulletEnemyList.get(j)),
                      ( (Bullet) parent.bulletPlayerList.get(i)))) {
            parent.death.add(new DeathScene( ( (Bullet) parent.bulletEnemyList.
                                              get(
                                                  j)).x,
                                            ( (Bullet) parent.
                                             bulletEnemyList.get(j)).y,
                                            ( (Bullet) parent.bulletEnemyList.
                                             get(
                                                 j)).
                                            width,
                                            ( (Bullet) parent.bulletEnemyList.
                                             get(
                                                 j)).
                                            height, "bullet"));
            parent.bulletPlayerList.remove(i--);
            parent.bulletEnemyList.remove(j--);
            flag = false;
          }

      flag = true;
    }
  }

  private boolean checkSpaceBounce(int i) {
    if (crashed(parent.space, ( (Bonus) parent.bonus.get(i)))) {
      if ( ( (Bonus) parent.bonus.get(i)).type == Bonus.TYPE_LIFE) {
        if (parent.FX) {
          MusicPlayer play = new MusicPlayer(false);
          play.openStream("extraLife");
          new Thread(play).start();
        }
        if (parent.space.lives != 4)
          parent.space.lives++;
      }
      else if ( ( (Bonus) parent.bonus.get(i)).type == Bonus.TYPE_POWER) {
        if (parent.FX) {
          MusicPlayer play = new MusicPlayer(false);
          play.openStream("powerup");
          new Thread(play).start();
        }
        if (parent.space.power != 5)
          parent.space.power++;
      }
      else if ( ( (Bonus) parent.bonus.get(i)).type == Bonus.TYPE_SHIELD) {
        if (parent.FX) {
          MusicPlayer play = new MusicPlayer(false);
          play.openStream("extrashield");
          new Thread(play).start();
        }

        if (parent.space.shield != 3)
          parent.space.shield++;
      }
      return true;
    }
    else
      return false;
  }

  private boolean checkSpaceDeath(int i) {
    if (!parent.space.shot &&
        crashed(parent.space, ( (Entity) parent.bulletEnemyList.get(i)))) {
      if (parent.FX) {
        MusicPlayer play = new MusicPlayer(false);
        play.openStream("shot");
        new Thread(play).start();
      }
      int player = parent.space.lives;
      parent.space.shot();
      if (player == parent.space.lives)
        parent.death.add(new DeathScene(parent.space.x, parent.space.y,
                                        parent.space.width, parent.space.height,
                                        "shield"));
      else
        parent.death.add(new DeathScene(parent.space.x, parent.space.y,
                                        parent.space.width, parent.space.height,
                                        "player"));
      return true;
    }
    else
      return false;
  }

  /**
   *crashed
   *
   *@return boolean
   */
  private boolean crashed(Entity a, Entity b) {
    return a.getCurrentPosition().intersects(b.getCurrentPosition());
  }

  private boolean checkEnemyDeath(int i, int j, int k) {
    if (crashed( ( (Entity) parent.enemyList[j].get(k)),
                ( (Entity) parent.bulletPlayerList.get(i)))) {
      if (parent.FX) {
        MusicPlayer play = new MusicPlayer(false);
        play.openStream("died");
        new Thread(play).start();
      }
      Random r = new Random();
      switch (r.nextInt() % 20) {
        case 5:
          parent.bonus.add(new Bonus( ( (Entity) parent.enemyList[j].get(k)).x,
                                     ( (Entity) parent.enemyList[j].get(k)).y,
                                     Bonus.TYPE_LIFE));
          break;
        case 10:
          parent.bonus.add(new Bonus( ( (Entity) parent.enemyList[j].get(k)).x,
                                     ( (Entity) parent.enemyList[j].get(k)).y,
                                     Bonus.TYPE_POWER));
          break;
        case 15:
          parent.bonus.add(new Bonus( ( (Entity) parent.enemyList[j].get(k)).x,
                                     ( (Entity) parent.enemyList[j].get(k)).y,
                                     Bonus.TYPE_SHIELD));
          break;
      }

      parent.death.add(new DeathScene( ( (Entity) parent.enemyList[j].get(k)).x,
                                      ( (Entity) parent.enemyList[j].get(k)).y,
                                      ( (Entity) parent.enemyList[j].get(k)).
                                      width,
                                      ( (Entity) parent.enemyList[j].get(k)).
                                      height,
                                      "alien"));
      parent.space.score++;
      return true;
    }
    else
      return false;
  }

  private void move() {
    if (!parent.space.isDead()) {
      if (!parent.bonus.isEmpty()) {
        for (int i = parent.bonus.size() - 1; i > -1; i--) {
          if ( ( ( (Bonus) parent.bonus.get(i)).y > parent.height))
            parent.bonus.remove(i);
          else
            ( (Bonus) parent.bonus.get(i)).move(1);
        }
      }
      if (!parent.bulletEnemyList.isEmpty()) {
        for (int i = parent.bulletEnemyList.size() - 1; i > -1; i--) {
          if ( ( ( (Entity) parent.bulletEnemyList.get(i)).y > parent.height))
            parent.bulletEnemyList.remove(i);
          else
            ( (Entity) parent.bulletEnemyList.get(i)).move(2);
        }
      }
      if (!parent.bulletPlayerList.isEmpty()) {
        for (int i = parent.bulletPlayerList.size() - 1; i > -1; i--) {
          if ( ( (Entity) parent.bulletPlayerList.get(i)).y <
              80  ||
              ( (Entity) parent.bulletPlayerList.get(i)).x < 0 ||
              ( (Entity) parent.bulletPlayerList.get(i)).x > parent.width)
            parent.bulletPlayerList.remove(i);
          else
            ( (Entity) parent.bulletPlayerList.get(i)).move(1);
        }
      }
      int longestR = 0, longestC = 0, lowestRow, upestRow, leftest = 0;
      double x = 0, minX = parent.width;
      for (lowestRow = 4; lowestRow > -1; lowestRow--)
        if (!parent.enemyList[lowestRow].isEmpty())
          break;
      for (upestRow = 0; upestRow < 5; upestRow++)
        if (!parent.enemyList[upestRow].isEmpty())
          break;
      for (int i = 0; i < 5; i++) {
        if (!parent.enemyList[i].isEmpty()) {
          if ( ( (Enemy) parent.enemyList[i].get(parent.enemyList[i].size() - 1)).
              x > x) {
            x = ( (Enemy) parent.enemyList[i].get(parent.enemyList[i].size() -
                                                  1)).
                x;
            longestC = parent.enemyList[i].size() - 1;
            longestR = i;
          }
        }
        if (!parent.enemyList[i].isEmpty()) {
          if ( ( (Enemy) parent.enemyList[i].get(0)).x < minX) {
            minX = ( (Enemy) parent.enemyList[i].get(0)).x;
            leftest = i;
          }
        }
      }
      hormonyMove(longestR, longestC, upestRow, lowestRow, leftest);
    }
  }

  private void hormonyMove(int longestR, int longestC, int upestRow,
                           int lowestRow, int leftest) {
    if ( ( (Enemy) parent.enemyList[lowestRow].get(0)).y > parent.height / 2)
      for (int j = 0; j < 5; j++)
        for (int k = 0; k < parent.enemyList[j].size(); k++)
          ( (Enemy) parent.enemyList[j].get(k)).setVerticalMoveDirection(Entity.
              MOVE_NEGETIVE);
    else if ( ( (Enemy) parent.enemyList[upestRow].get(0)).y < 60)
      for (int j = 0; j < 5; j++)
        for (int k = 0; k < parent.enemyList[j].size(); k++)
          ( (Enemy) parent.enemyList[j].get(k)).setVerticalMoveDirection(Entity.
              MOVE_POSITIVE);
    if ( ( (Enemy) parent.enemyList[longestR].get(longestC)).x >
        parent.width -
        ( (Enemy) parent.enemyList[longestR].get(longestC)).width -
        10) {
      for (int j = 0; j < 5; j++)
        for (int k = 0; k < parent.enemyList[j].size(); k++) {
          ( (Enemy) parent.enemyList[j].get(k)).setHorizentalMoveDirection(
              Entity.
              MOVE_NEGETIVE);
          ( (Enemy) parent.enemyList[j].get(k)).setVerticalMove(true);
          if (parent.gameType == 3)
            ( (Enemy) parent.enemyList[j].get(k)).move();
          else
            ( (Entity) parent.enemyList[j].get(k)).move(1);
          ( (Enemy) parent.enemyList[j].get(k)).setVerticalMove(false);
        }
    }
    else if ( ( (Enemy) parent.enemyList[leftest].get(0)).x <
             ( (Enemy) parent.enemyList[longestR].get(0)).width) {
      for (int j = 0; j < 5; j++)
        for (int k = 0; k < parent.enemyList[j].size(); k++) {
          ( (Enemy) parent.enemyList[j].get(k)).setHorizentalMoveDirection(
              Entity.
              MOVE_POSITIVE);
          ( (Enemy) parent.enemyList[j].get(k)).setVerticalMove(true);
          if (parent.gameType == 3)
            ( (Enemy) parent.enemyList[j].get(k)).move();
          else
            ( (Entity) parent.enemyList[j].get(k)).move(1);
          ( (Enemy) parent.enemyList[j].get(k)).setVerticalMove(false);
        }
    }
    else
      for (int j = 0; j < 5; j++)
        for (int k = 0; k < parent.enemyList[j].size(); k++)
          if (parent.gameType == 3)
            ( (Enemy) parent.enemyList[j].get(k)).move();
          else
            ( (Entity) parent.enemyList[j].get(k)).move(1);
  }

  /**
   *normalEnemyMove
   *
   *@param temp Entity
   *@param parentGameFrame
   */
  private static void normalEnemyMove(Entity temp, GameFrame parent, int i) {
    if (temp.y > parent.height / 2)
      temp.setVerticalMoveDirection(Entity.MOVE_NEGETIVE);
    else if (temp.y < 20)
      temp.setVerticalMoveDirection(Entity.MOVE_POSITIVE);
    if (temp.x > parent.width - temp.width) {
      temp.setHorizentalMoveDirection(Entity.MOVE_NEGETIVE);
      temp.setVerticalMove(true);
    }
    if (temp.x < 0) {
      temp.setHorizentalMoveDirection(Entity.MOVE_POSITIVE);
      temp.setVerticalMove(true);
    }
    temp.move(1);
    temp.setVerticalMove(false);
  }
}
