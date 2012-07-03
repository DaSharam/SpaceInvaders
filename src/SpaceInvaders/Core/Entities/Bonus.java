package SpaceInvaders.Core.Entities;

import java.awt.*;
import javax.swing.*;

import SpaceInvaders.Core.Entities.Bullets.*;

/**
 *<p> Description...Title:Space Invaders</p>
 *<>Designed By MuRF</p>
 *<p>Copyright.Copyright(c) 2006 </p>
 *<p>Company:MuRF Software Distribution </p>
 *
 *@author MuRF
 *@version 1.0
 */
public class Bonus
    extends Entity {
  public static int TYPE_POWER = 1, TYPE_SHIELD = 2, TYPE_LIFE = 3;
  public int type;
  final Image power = new ImageIcon("data/Images/Entities/Bonus/power.gif").
      getImage();

  final Image shield = new ImageIcon("data/Images/Entities/Bonus/shield.gif").
      getImage();

  final Image life = new ImageIcon("data/Images/Entities/Bonus/ship.gif").
      getImage();

  /**
   *getBullet
   *
   *@return Bullet
   *@todo implement this spaceInvaderMuRF.core.entities.EntityModel method
   */

  public Bullet getBullet() {
    return null;
  }

  /**
   *getNextImage
   *
   *@Return Image
   *@todo implement this spaceInvaderMuRF.core.entities.EntityModel method
   */

  public Image getNextImage() {
    if (type == TYPE_LIFE)
      return life;
    else if (type == TYPE_POWER)
      return power;
    else
      return shield;
  }

  public Bonus(double startX, double startY, int Type) {
    super(startX, startY, 30, 30);
    setVerticalMove(true);
    setMoveSize(0, 30);
    type = Type;
  }

  public Bonus(Entity x) {
    super(x);
  }
}
