package SpaceInvaders.Core.Entities;

import java.awt.*;
import javax.swing.*;

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
public abstract class Entity
    extends JComponent implements EntityModel{
  /**
   *Defines the movment position to be positive
   */
  public static int MOVE_POSITIVE = 1;
  /**
   *Defiines the movment position to  bbe Negative
   */
  public static int MOVE_NEGETIVE = -1;

  public int verticalMoveDirection, horizentalMoveDirection;
  public boolean live, imageDirection, verticalMove;
  public static Image[] alive;
  public int width, height, picNumber;
  public double x, y, verticalMoveSize, horizentalMoveSize;
  public double angel = 0.0;

  /**
   *initialize the class with starting position and width and height
   */

  public Entity(double startX, double startY, int width, int height) {
    this.x = startX;
    this.y = startY;
    this.width = width;
    this.height = height;
    verticalMoveDirection = MOVE_POSITIVE;
    horizentalMoveDirection = MOVE_POSITIVE;
    verticalMove = false;
    imageDirection = true;
    live = true;
    picNumber = 0;
  }

  public Entity(Entity x) {
    this.x = x.x;
    this.y = x.y;
    this.width = x.width;
    this.height = x.height;
    verticalMoveDirection = MOVE_POSITIVE;
    horizentalMoveDirection = MOVE_POSITIVE;
    verticalMove = false;
    imageDirection = true;
    live = true;
    picNumber = 0;
  }

  /**
   *getCurrentPosition
   *
   *@return Rectangle
   *@todo returns the current Rectangle Bounds of the object
   */
  public Rectangle getCurrentPosition() {
    return new Rectangle( (int) x, (int) y, width, height);
  }

  public Point getNextPoint() {
    move(1);
    return new Point( (int) x, (int) y);
  }

  /**
   *Checks that object is dead or not
   *
   *@return boolean
   */

  public boolean isDead() {
    if (!live)
      return true;
    else
      return false;
  }

  /**
   *Sets the horizental move direction to posetive or negative.
   *
   *@param direction int
   */
  public void setHorizentalMoveDirection(int direction) {
    if (direction == MOVE_POSITIVE)
      horizentalMoveDirection = direction;
    else if (direction == MOVE_NEGETIVE)
      horizentalMoveDirection = direction;
  }

  /**
   *Set the horizental move size
   *
   *@param x int
   */

  public void setHorizentalMoveSize(double x) {
    horizentalMoveSize = x;
  }

  /**
   *Set the Movment size
   *
   *@param x int
   *@param y int
   *@see #setHorizentalMoveSize
   *@see #setVerticalMoveSize
   */

  public void setMoveSize(double x, double y) {
    setVerticalMoveSize(y);
    setHorizentalMoveSize(x);
  }

  /**
   *Sets the vertical move direction to posetive or negative
   *
   *@param direction int
   */

  public void setVerticalMoveDirection(int direction) {
    if (direction == MOVE_POSITIVE)
      verticalMoveDirection = direction;
    else if (direction == MOVE_NEGETIVE)
      verticalMoveDirection = direction;
  }

  /**
   *Sets the vertical move size
   *
   *@param y int
   */
  public void setVerticalMoveSize(double y) {
    verticalMoveSize = y;
  }

  /**
   *Kills the ENtity
   */

  public void getKill() {
    live = false;
  }

  /**
   *Moves the entity by times * move size of the entity
   *
   *@param items int
   */
  public void move(int times) {
    x += times * horizentalMoveSize * horizentalMoveDirection;
    if (verticalMove)
      y += times * verticalMoveSize * verticalMoveDirection;
  }

  /**
   *Sets the vertical mover to corresponding value
   *If true it will move in corresponding Direction
   *Else no Vertival Move
   *
   *@param yes boolean
   */
  public void setVerticalMove(boolean yes) {
    verticalMove = yes;
  }
  /**
   *Switches the Image Direction value to make an animated looking loop
   */
  public void switchImageDirection() {
    if (imageDirection) {
      picNumber--;
      imageDirection = false;
    }
    else {
      picNumber++;
      imageDirection = true;
    }
   }

}
