package es.ulpgc.eite.cleancode.helloworld.hello;

import es.ulpgc.eite.cleancode.helloworld.app.AppMediator;
import es.ulpgc.eite.cleancode.helloworld.app.ByeToHelloState;
import es.ulpgc.eite.cleancode.helloworld.app.HelloToByeState;


public class HelloRouter implements HelloContract.Router {

  public static String TAG = HelloRouter.class.getSimpleName();

  private AppMediator mediator;

  public HelloRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public ByeToHelloState getDataFromByeScreen() {
    if (mediator != null) {
      return mediator.getByeToHelloState();
    }

    return null;
  }

  @Override
  public void passDataToByeScreen(HelloToByeState state) {
    if (mediator != null) {
      mediator.setHelloToByeState(state);
    }
  }

//  @Override
//  public void navigateToByeScreen() {
//    Context context = mediator.getApplicationContext();
//    Intent intent = new Intent(context, ByeActivity.class);
//    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//    context.startActivity(intent);
//  }

}
