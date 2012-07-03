package SpaceInvaders.GUI;

import java.awt.Graphics;

import javax.swing.JPanel;

import SpaceInvaders.Core.Entities.Bullets.Bullet;

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

public class BulletPanel
    extends JPanel {
  GameFrame parent;

  public BulletPanel(GameFrame parent) {
    super();
    this.parent = parent;
    setOpaque(false);
    addKeyListener(parent.listen);
    addMouseListener(parent.listen);
    addMouseMotionListener(parent.listen);
  }

  public void paintComponent(Graphics g) {
    if (!parent.bulletEnemyList.isEmpty() && !parent.pause)
      for (int i = 0; i < parent.bulletEnemyList.size(); i++)
        g.drawImage( ( (Bullet) parent.bulletEnemyList.get(i)).getNextImage(),
                    (int) ( (Bullet) parent.bulletEnemyList.get(i)).x,
                    (int) ( (Bullet) parent.bulletEnemyList.get(i)).y,
                    ( (Bullet) parent.bulletEnemyList.get(i)).
                    width,
                    (int) ( (Bullet) parent.
                           bulletEnemyList.get(i)).height, this);

    if (!parent.bulletPlayerList.isEmpty() &&
        !parent.pause)
      for (int i = 0; i < parent.bulletPlayerList.size(); i++)
        g.drawImage( ( (Bullet) parent.bulletPlayerList.get(i)).
                    getNextImage(),
                    (int) ( (Bullet) parent.bulletPlayerList.get(i)).x,
                    (int) ( (Bullet) parent.bulletPlayerList.get(i)).
                    y,
                    ( (Bullet) parent.bulletPlayerList.get(i)).
                    width,
                    ( (Bullet) parent.bulletPlayerList.get(i)).
                    height, this);
  }
}
