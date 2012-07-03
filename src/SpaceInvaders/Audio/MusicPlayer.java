package SpaceInvaders.Audio;

import java.io.File;
import java.util.Map;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerEvent;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import javazoom.jlgui.basicplayer.BasicPlayerListener;

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
 *@Version 1.0
 */

public class MusicPlayer
    implements BasicPlayerListener, Runnable {
  public void opened(Object object, Map map) {
  }

  public void progress(int _int, long _long, byte[] byteArray, Map map) {
  }

  public void stateUpdated(BasicPlayerEvent basicPlayerEvent) {
    if (player.getStatus() == player.STOPPED && loop &&
        player.getStatus() != player.PAUSED)
      try {

        player.play();

      }
      catch (BasicPlayerException ex) {
      }
  }

  public void setController(BasicController basicController) {
  }

  private String path = System.getProperty("user.dir")+"/data/Music/";
  public BasicPlayer player;
  boolean loop;

  public MusicPlayer(boolean loop) {
    this.loop = loop;
  }

  public MusicPlayer(String name) {
    loop = false;
    player = new BasicPlayer();
    try {
      player.open(new File(path + name));
      player.setGain(0.8);
    }
    catch (BasicPlayerException e) {
      e.printStackTrace();
    }
  }

  public void openStream(String name) {
    player = new BasicPlayer();
    try {
      player.open(new File(path + name));
      player.setGain(0.8);
    }
    catch (BasicPlayerException e) {
      e.printStackTrace();
      return;
    }
  }

  public void run() {
    try {
      player.play();
    }
    catch (BasicPlayerException ex1) {
      return;
    }

    player.addBasicPlayerListener(this);
  }

  public void setVolume(double gain) {
    try {
      player.setGain(gain);
    }
    catch (BasicPlayerException ex) {
    }
  }

  public void stopPlay() {
    try {
      player.pause();
    }
    catch (BasicPlayerException ex) {
    }
  }

  public void play() {
    try {
      player.resume();
    }
    catch (BasicPlayerException ex) {
    }
  }

  public void kill() {
    loop = false;
    try {
      player.stop();
    }
    catch (BasicPlayerException ex) {}
  }
}
