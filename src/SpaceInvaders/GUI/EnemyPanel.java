package SpaceInvaders.GUI;

import java.awt.Graphics;

import javax.swing.JPanel;

import SpaceInvaders.Core.Entities.Entity;

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
public class EnemyPanel
    extends JPanel {
  GameFrame parent;
  public EnemyPanel(GameFrame parent) {
    super();
    this.parent = parent;
    setOpaque(false);
    addKeyListener(parent.listen);
    addMouseListener(parent.listen);
    addMouseMotionListener(parent.listen);
  }

  public void paintComponent(Graphics g) {
    if (!parent.pause)
      for (int i = 0; i < 5; i++)
        if (!parent.enemyList[i].isEmpty())
          for (int j = 0; j < parent.enemyList[i].size(); j++) {
            g.drawImage( ( (Entity) parent.enemyList[i].get(j)).getNextImage(),
                        (int) ( (Entity) parent.enemyList[i].get(j)).x,
                        (int) ( (Entity) parent.enemyList[i].get(j)).y,
                        ( (Entity) parent.enemyList[i].get(j)).width,
                        ( (Entity) parent.enemyList[i].get(j)).height, this);
          }
  }
}
