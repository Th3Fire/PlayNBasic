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

  private Image fImage;
  private ImageLayer f;

  private float x = 0f;
  private float y = 480f;

  private float a = 0f;
  private float b = 50f;
  private boolean check1 = false;
  private boolean check2 = false;

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

    fImage = assets().getImage("images/t.png");
    f = graphics().createImageLayer(fImage);
    graphics().rootLayer().add(f);
    f.setTranslation(a,b);

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

    System.out.printf("alpha: %f x : %.2f   y :%.2f bool:%B a:%.2f b:%.2f\n",alpha,x,y,check1,a,b);
    //////////////////////////////
    if(!(check1)){ // ขึ้น
      y -= 2f * alpha;
      x += 2f * alpha;

    }

    else{  //ลง
      y += 2f * alpha;
      x -= 2f * alpha;
    }
    /////////////////////////////////
    if(!(check2)){
      a += 5f * alpha;

    }else{
      a -= 5f * alpha;
    }
    ////////////////////////////////

    if(y > 480 && check1 == true){
      check1 = false;

    }
    else if(y < 0 && check1 == false){
      check1 = true;
    }
    if(a > 520 && check2 == false){
      check2 = true;
    }else if(a < - 30 && check2 == true){
      check2 = false;
    }
    sun.setTranslation(x,y);
    f.setTranslation(a,b);





  }
}
