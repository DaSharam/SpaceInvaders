package SpaceInvaders.GUI;

import java.awt.Graphics;

import javax.swing.JPanel;

import SpaceInvaders.Core.Entities.Bonus;
import SpaceInvaders.Core.Entities.DeathScene;

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

public class DeathPanel
    extends JPanel {
  GameFrame parent;

  public DeathPanel(GameFrame parent) {
    super();
    this.parent = parent;
    setOpaque(false);
    addKeyListener(parent.listen);
    addMouseListener(parent.listen);
    addMouseMotionListener(parent.listen);
  }

  public void paintComponent(Graphics g) {
    if (!parent.death.isEmpty())
      for (int i = 0; i < parent.death.size(); i++) {
        DeathScene temp = ( (DeathScene)this.parent.death.get(i));
        if (temp.isDead())
          parent.death.remove(i--);
        else
          g.drawImage(temp.getNextImage(), (int) temp.x, (int) temp.y,
                      temp.width, temp.height, this);
      }
    if (!parent.bonus.isEmpty())
      for (int i = 0; i < parent.bonus.size(); i++) {
        Bonus temp = ( (Bonus)this.parent.bonus.get(i));
        g.drawImage(temp.getNextImage(), (int) temp.x, (int) temp.y, temp.width,
                    temp.height, this);
      }
  }
}
