package SpaceInvaders.Core.Entities;

import java.awt.Image;

import javax.swing.ImageIcon;

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
public class DeathScene
    extends Entity {
  public int count = 1;
  final static Image alien = new ImageIcon(
      "data/Images/Entities/Death/death.gif").getImage();

  final static Image player = new ImageIcon(
      "data/Images/Entities/Death/dead.gif").getImage();

  final static Image bullet = new ImageIcon(
      "data/Images/Entities/Death/bang.gif").getImage();

  final static Image shield = new ImageIcon(
      "data/Images/Entities/Death/shield.gif").getImage();

  String type;
  public DeathScene(double startX, double startY, int width, int height,
                    String Type) {
    super(startX, startY, width, height);
    if (Type.equals("alien"))
      this.count = 8;
    if (Type.equals("player"))
      this.count = 8;
    if (Type.equals("bullet"))
      this.count = 2;
    if (Type.equals("shield"))
      this.count = 5;
    type = Type;
  }

  public Image getNextImage() {
    if (count == 0)
      getKill();
    count--;
    if (type.equals("alien"))
      return alien;
    else if (type.equals("player"))
      return player;
    else if (type.equals("shield"))
      return shield;
    else
      return bullet;
  }

  public Bullet getBullet() {
    return null;
  }
}
