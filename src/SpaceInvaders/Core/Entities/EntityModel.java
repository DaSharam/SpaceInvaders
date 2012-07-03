package SpaceInvaders.Core.Entities;

import java.awt.*;

import SpaceInvaders.Core.Entities.Bullets.*;

/**
 * <p>Title: Space Invaders</p>
 *
 * <p>Description: Graduation Project</p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author Hassan Rajaeian
 * @version 1.0
 */
public interface EntityModel {
  public void getKill();
  public boolean isDead();
  public void setMoveSize(double x,double y);
  public void setVerticalMoveSize(double y);
  public void setHorizentalMoveSize(double x);
  public void setVerticalMoveDirection(int direction);
  public void setHorizentalMoveDirection(int direction);
  public void move(int times);
  public Point getNextPoint();
  public Rectangle getCurrentPosition();
  public Image getNextImage();
  public void switchImageDirection();
  public Bullet getBullet();
}
