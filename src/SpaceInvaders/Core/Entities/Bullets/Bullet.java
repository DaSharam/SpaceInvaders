package SpaceInvaders.Core.Entities.Bullets;

import java.awt.Image;

import SpaceInvaders.Core.Entities.Entity;

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
public abstract class Bullet
    extends Entity {
  Image bulletImage;
  public Bullet(double startX, double startY, int width, int height) {
    super(startX, startY, width, height);
  }

  /**
   * just kill the Bullet no Image Scene
   */
  public void getKill() {
    live = false;
  }

  public Bullet getBullet() {
    return null;
  }
}
