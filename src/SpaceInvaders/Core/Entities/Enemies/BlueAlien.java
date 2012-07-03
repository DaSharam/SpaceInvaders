package SpaceInvaders.Core.Entities.Enemies;

import java.awt.Image;

import javax.swing.ImageIcon;

import SpaceInvaders.Core.Entities.Bullets.BlueAlienBullet;
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
public class BlueAlien
    extends Enemy {
  double angel;
  final static Image image = new ImageIcon(
      "data/Images/Entities/Enemies/BlueAlien.gif").getImage();

  public BlueAlien(int startX, int startY, int width, int height) {
    super(startX, startY, width, height);
    setMoveSize(5, height);
  }

  /**return the Bullet related to the Blue Alien
   *
   *@return Bullet
   */
  public Bullet getBullet() {
    Bullet temp = new BlueAlienBullet(this.x + this.width / 2,
                                      this.y + this.height,
                                      20, 20);
    temp.setVerticalMove(true);
    temp.setMoveSize(0, this.height);
    return temp;
  }

  /**
   *getNextImage
   *
   *@return Image
   *@todo returns the next Image to be displayed depending on image type and
   *image direction values
   */
  public Image getNextImage() {
    return image;
  }

  public void move() {
    x = x +
        Math.exp(0.1 * Math.PI) * horizentalMoveSize * horizentalMoveDirection;
    y = y + Math.sin(0.1 * Math.PI) * verticalMoveSize * verticalMoveDirection;
  }

}
