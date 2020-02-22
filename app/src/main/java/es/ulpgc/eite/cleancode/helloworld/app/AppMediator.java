package es.ulpgc.eite.cleancode.helloworld.app;

import android.app.Application;

import es.ulpgc.eite.cleancode.helloworld.bye.ByeState;
import es.ulpgc.eite.cleancode.helloworld.hello.HelloState;

public class AppMediator extends Application {

  private HelloState helloState = new HelloState();
  private ByeState byeState = new ByeState();

  private HelloToByeState helloToByeState;
  private ByeToHelloState byeToHelloState;

  /*
  @Override
  public void onCreate() {
    super.onCreate();

    helloState = new HelloState();
    byeState = new ByeState();
  }
  */

  public ByeState getByeState() {
    return byeState;
  }

  public HelloState getHelloState() {
    return helloState;
  }

  public HelloToByeState getHelloToByeState() {
    HelloToByeState state = helloToByeState;
    helloToByeState = null;
    return state;
  }

  public void setHelloToByeState(HelloToByeState state) {
    this.helloToByeState = state;
  }

  public ByeToHelloState getByeToHelloState() {
    ByeToHelloState state = byeToHelloState;
    byeToHelloState = null;
    return state;
  }

  public void setByeToHelloState(ByeToHelloState state) {
    this.byeToHelloState = state;
  }


}
