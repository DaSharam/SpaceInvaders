package SpaceInvaders.Core.Entities.Bullets;

import java.awt.Image;

import javax.swing.ImageIcon;

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


public class Rocket
    extends Bullet {
  final Image bulletImage = new ImageIcon(
      "data/Images/Entities/Bullets/player.gif").getImage();

  public Rocket(double startX, double startY, int width, int height) {
    super(startX, startY, width, height);
  }

  /**Bullet is single Image no loops for Bullets
   *
   *@return Image
   */
  public Image getNextImage() {
    return bulletImage;
  }

}
