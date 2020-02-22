package es.ulpgc.eite.cleancode.helloworld.bye;

import es.ulpgc.eite.cleancode.helloworld.app.AppMediator;
import es.ulpgc.eite.cleancode.helloworld.app.ByeToHelloState;
import es.ulpgc.eite.cleancode.helloworld.app.HelloToByeState;


public class ByeRouter implements ByeContract.Router {

  public static String TAG = ByeRouter.class.getSimpleName();

  private AppMediator mediator;

  public ByeRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public HelloToByeState getDataFromHelloScreen() {
    return mediator.getHelloToByeState();
  }

  @Override
  public void passDataToHelloScreen(ByeToHelloState state) {

    mediator.setByeToHelloState(state);
  }

}
