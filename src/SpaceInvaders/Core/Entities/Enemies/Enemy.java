package SpaceInvaders.Core.Entities.Enemies;

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
public abstract class Enemy
    extends Entity {
  public Enemy(int startX, int startY, int width, int height) {
    super(startX, startY, width, height);
  }

  public Enemy(Entity x) {
    super(x);
  }

  abstract public void move();
}
