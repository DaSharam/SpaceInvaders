package SpaceInvaders.Core.Entities.Players;

import java.awt.Image;
import java.util.Vector;

import javax.swing.ImageIcon;

import SpaceInvaders.Core.Entities.Entity;
import SpaceInvaders.Core.Entities.Bullets.Bullet;
import SpaceInvaders.Core.Entities.Bullets.Rocket;

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

public class RedSpaceShip
    extends Player {
  final Image alive = new ImageIcon("data/Images/Entities/Players/ship.gif").
      getImage();

  public RedSpaceShip(int startX, int startY, int width, int height) {
    super(startX, startY, width, height);
    setMoveSize(width / 2, 0);
  }

  /**
   *Returns the bullet related to Bullet
   *
   *@Return Bullet
   */
  public Bullet getBullet(Vector r) {
    if (power == 1) {
      Bullet temp = new Rocket(this.x + this.width / 2,
                               this.y - this.height / 2, this.width / 3,
                               this.height / 2);
      temp.setMoveSize(0, this.height);
      temp.setVerticalMoveDirection(Entity.MOVE_NEGETIVE);
      temp.setVerticalMove(true);
      r.add(temp);
    }
    else if (power == 2) {
      Bullet temp = new Rocket(this.x, this.y - this.height / 2, this.width / 3,
                               this.height / 2);
      temp.setMoveSize(0, this.height);
      temp.setVerticalMoveDirection(Entity.MOVE_NEGETIVE);
      temp.setVerticalMove(true);
      r.add(temp);
      temp = new Rocket(this.x + this.width, this.y - this.height / 2,
                        this.width / 3, this.height / 2);
      temp.setMoveSize(0, this.height);
      temp.setVerticalMoveDirection(Entity.MOVE_NEGETIVE);
      temp.setVerticalMove(true);
      r.add(temp);
    }
    else if (power == 3) {
      Bullet temp = new Rocket(this.x, this.y - this.height / 2, this.width / 3,
                               this.height / 2);
      temp.setMoveSize(0, this.height);
      temp.setVerticalMoveDirection(Entity.MOVE_NEGETIVE);
      temp.setVerticalMove(true);
      r.add(temp);
      temp = new Rocket(this.x + this.width / 2, this.y - this.height,
                        this.width / 3, this.height / 2);
      temp.setMoveSize(0, this.height);
      temp.setVerticalMoveDirection(Entity.MOVE_NEGETIVE);
      temp.setVerticalMove(true);
      r.add(temp);
      temp = new Rocket(this.x + this.width, this.y - height / 2,
                        this.width / 3, this.height / 2);
      temp.setMoveSize(0, this.height);
      temp.setVerticalMoveDirection(Entity.MOVE_NEGETIVE);
      temp.setVerticalMove(true);
      r.add(temp);
    }
    else if (power == 4) {
      Bullet temp = new Rocket(this.x, this.y - this.height / 2, this.width / 3,
                               this.height / 2);
      temp.setMoveSize(this.height / 2, this.height);
      temp.setHorizentalMoveDirection(temp.MOVE_NEGETIVE);
      temp.setVerticalMoveDirection(Entity.MOVE_NEGETIVE);
      temp.setVerticalMove(true);
      r.add(temp);
      temp = new Rocket(this.x + this.width / 2, this.y - this.height,
                        this.width / 3, this.height / 2);
      temp.setMoveSize(0, this.height);
      temp.setVerticalMoveDirection(Entity.MOVE_NEGETIVE);
      temp.setVerticalMove(true);
      r.add(temp);
      temp = new Rocket(this.x + this.width, this.y - this.height / 2,
                        this.width / 3, this.height / 2);
      temp.setMoveSize(this.height / 2, this.height);
      temp.setVerticalMoveDirection(Entity.MOVE_NEGETIVE);
      temp.setVerticalMove(true);
      r.add(temp);
    }
    else if (power == 5) {
      Bullet temp = new Rocket(this.x, this.y - this.height / 2, this.width / 3,
                               this.height / 2);
      temp.setMoveSize(this.height / 2, this.height);
      temp.setHorizentalMoveDirection(temp.MOVE_NEGETIVE);
      temp.setVerticalMoveDirection(Entity.MOVE_NEGETIVE);
      temp.setVerticalMove(true);
      r.add(temp);
      temp = new Rocket(this.x + this.width / 3, this.y - this.height,
                        this.width / 3, this.height / 2);
      temp.setMoveSize(0, this.height);
      temp.setVerticalMoveDirection(Entity.MOVE_NEGETIVE);
      temp.setVerticalMove(true);
      r.add(temp);

      temp = new Rocket(this.x + this.width * 2 / 3, this.y - this.height,
                        this.width / 3, this.height / 2);
      temp.setMoveSize(0, this.height);
      temp.setVerticalMoveDirection(Entity.MOVE_NEGETIVE);
      temp.setVerticalMove(true);
      r.add(temp);

      temp = new Rocket(this.x + this.width, this.y - this.height / 2,
                        this.width / 3, this.height / 2);
      temp.setMoveSize(this.height / 2, this.height);
      temp.setVerticalMoveDirection(Entity.MOVE_NEGETIVE);
      temp.setVerticalMove(true);
      r.add(temp);
    }
    return null;
  }

  /**
   *getNextImage
   *
   *@return Image
   *@todo returns the next image to be displayed depending on omage type and imade direction values
   */
  public Image getNextImage() {
    return alive;
  }

}

