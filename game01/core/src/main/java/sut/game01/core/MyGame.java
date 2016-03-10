package sut.game01.core;

import static playn.core.PlayN.*;

import playn.core.Game;
import playn.core.Image;
import playn.core.ImageLayer;

public class MyGame extends Game.Default {
  private Image bgImage;
  private ImageLayer bgLayer;

  private Image mountImage;
  private ImageLayer mount;

  private Image sunImage;
  private ImageLayer sun;

  private float x = 0f;
  private float y = 480f;

  private float a = 0f;
  private float b = 100f;
  private boolean flag = false;

  public MyGame() {
    super(33); // call update every 33ms (30 times per second)
  }



  @Override
  public void init() {
    // create and add background image layer
    bgImage = assets().getImage("images/bg.png");
    bgLayer = graphics().createImageLayer(bgImage);
    graphics().rootLayer().add(bgLayer);

    sunImage = assets().getImage("images/s.png");
    sun = graphics().createImageLayer(sunImage);
    graphics().rootLayer().add(sun);
    sun.setTranslation(x,y);

    mountImage = assets().getImage("images/m.png");
    mount = graphics().createImageLayer(mountImage);
    graphics().rootLayer().add(mount);
  }

  @Override
  public void update(int delta) {
  }

  @Override
  public void paint(float alpha) {
    // the background automatically paints itself, so no need to do anything here!

    System.out.printf("alpha: %f x : %.2f   y :%.2f bool:%B\n",alpha,x,y,flag);
    if(!(flag)){ // ขึ้น
      y -= 2f * alpha;
      x += 2f * alpha;
    }
    else{  //ลง
      y += 2f * alpha;
      x -= 2f * alpha;
    }
    if(y > 480 && flag == true){
      flag = false;

    }
    else if(y < 0 && flag == false){
      flag = true;
    }
    sun.setTranslation(x,y);





  }
}
