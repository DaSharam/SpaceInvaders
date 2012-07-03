package SpaceInvaders.Core.Entities.Players;

import java.awt.Image;
import java.util.Vector;

import SpaceInvaders.Core.Entities.Entity;
import SpaceInvaders.Core.Entities.Bullets.Bullet;

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
public class Player
    extends Entity {
  public int bulletType = 0, bounceCount = 0, shotTime = 0, score = 0;
  public int shield = 3, lives = 4, power = 1;
  public boolean shot = false, sShot = false;
  public Player(int startX, int startY, int width, int height) {
    super(startX, startY, width, height);
  }

  /**
   *getBullet
   *
   *@return Bullet
   *@todo implement this spaceInvadersMuRF.core.entities.EntityModel method
   */
  public Bullet getBullet(Vector r) {
    return null;
  }

  public void shot() {
    sShot = true;
    shotTime = 4;
    shield--;
    if (shield == 0) {
      power = 1;
      shot = true;
      lives--;
    }
    if (shield == 0 && lives != 0)
      shield = 3;
    if (lives == 0)
      getKill();
  }

  public boolean isShot() {
    if (shotTime == 0) {
      shot = false;
      sShot = false;
      return false;
    }
    else if (sShot && !shot) {
      shotTime--;
      return false;
    }
    else if (shot) {
      shotTime--;
      return true;
    }
    else
      return false;
  }

  /**
   *getNextImage
   *
   *@return Bullet
   *@todo implement this spaceInvadersMuRF.core.entities.EntityModel method
   */
  public Image getNextImage() {
    return null;
  }

  public Bullet getBullet() {
    return null;
  }
}
