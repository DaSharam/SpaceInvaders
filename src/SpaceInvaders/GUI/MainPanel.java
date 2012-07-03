package SpaceInvaders.GUI;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *<p>Title:Space Invaders</p>
 *
 *<p>Description: Besigned By H.R.</p>
 *
 *<p>Copyright : Copyright (c)2005</p>
 *
 *
 *
 *@author MuRF
 *@Version 0.5
 */

public class MainPanel
    extends JPanel {
  GameFrame parent;
  String backName;
  int backh = 0, direction = 1;
  BufferedImage background;
  public MainPanel(GameFrame parent) {
    backName = "data/Images/back" + ( (parent.stage - 1) * 3 + parent.level) +
        ".jpg";
    try {
      background = ImageIO.read(new File(backName));
    }
    catch (IOException ex) {
    }
    this.parent = parent;
    setSize(parent.width, parent.height);
    setOpaque(false);
    addKeyListener(parent.listen);
    addMouseListener(parent.listen);
    addMouseMotionListener(parent.listen);
  }

  public void paintComponent(Graphics g) {

    /*
     g.drawImage(background.getSubimage( 0 , 0  + backh , 800 , 600 - backh ) ,0 , 0 , parent.width , parent.height , this);
     backh = +10 * direction;
     if(backh > 480 )
     direction = -1;
     if(backh < 20 )
     direction = 1;
     */
    g.drawImage(background, 0, 0, parent.width, parent.height, this);

    //g.drawImage(new ImageIcon("data/Images/back1.gif").getImage(), 0, 0,
            //    parent.width, parent.height, this);
    g.drawImage(new ImageIcon("data/Images/panel/panel.gif ").getImage(), 0, 0,
                parent.width, 50, this);
    for (int i = 0; i < parent.space.power; i++)
      g.drawImage(new ImageIcon("data/Images/panel/true.gif ").getImage(),
                  (int) (parent.width * 0.09) + i * 40, 10, 30, 30, this);
    for (int i = parent.space.power; i < 5; i++)
      g.drawImage(new ImageIcon("data/Images/panel/false.gif ").getImage(),
                  (int) (parent.width * 0.09) + i * 40, 10, 30, 30, this);
    for (int i = 0; i < parent.space.shield; i++)
      g.drawImage(new ImageIcon("data/Images/panel/true.gif ").getImage(),
                  (int) (parent.width * 0.48) + i * 40, 10, 30, 30, this);
    for (int i = parent.space.shield; i < 3; i++)
      g.drawImage(new ImageIcon("data/Images/panel/false.gif ").getImage(),
                  (int) (parent.width * 0.48) + i * 40, 10, 30, 30, this);
    for (int i = 0; i < parent.space.lives; i++)
      g.drawImage(new ImageIcon("data/Images/panel/true.gif ").getImage(),
                  (int) (parent.width * 0.78) + i * 40, 10, 30, 30, this);
    for (int i = parent.space.lives; i < 4; i++)
      g.drawImage(new ImageIcon("data/Images/panel/false.gif ").getImage(),
                  (int) (parent.width * 0.78) + i * 40, 10, 30, 30, this);

    if (!parent.space.isShot())
      g.drawImage(parent.space.getNextImage(), (int) parent.space.x,
                  (int) parent.space.y, parent.space.width, parent.space.height, this);
  }
}
