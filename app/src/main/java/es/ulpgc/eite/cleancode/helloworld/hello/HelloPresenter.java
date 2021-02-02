package es.ulpgc.eite.cleancode.helloworld.hello;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.helloworld.app.ByeToHelloState;
import es.ulpgc.eite.cleancode.helloworld.app.GetMessageAsyncTaskCallback;
import es.ulpgc.eite.cleancode.helloworld.app.HelloToByeState;

public class HelloPresenter implements HelloContract.Presenter {

  public static String TAG = HelloPresenter.class.getSimpleName();

  private WeakReference<HelloContract.View> view;
  private HelloState state;
  private HelloContract.Model model;
  private HelloContract.Router router;

  public HelloPresenter(HelloState state) {
    this.state = state;
  }

  @Override
  public void injectView(WeakReference<HelloContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(HelloContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(HelloContract.Router router) {
    this.router = router;
  }

  @Override
  public void onResumeCalled() {
    //Log.e(TAG, "onResumeCalled()");

    ByeToHelloState savedState = router.getDataFromByeScreen();
    if(savedState != null){

      // set passed state
      state.helloMessage = savedState.message;
    }

    view.get().displayHelloData(state);

    if(state.progressBarVisibility) {
      startHelloMessageAsyncTask();
    }
  }

  private void startHelloMessageAsyncTask() {
    //Log.e(TAG, "startHelloMessageAsyncTask()");

    /*
    String message = model.getHelloMessage();
    if(message != null) {
      updateHelloData(message);

      return;
    }
    */

    view.get().getHelloMessage(new GetMessageAsyncTaskCallback() {

      @Override
      public void onGetMessageAsyncTaskFinished(String message) {
        //Log.e(TAG, "onGetMessageAsyncTaskFinished()");

        model.setHelloMessage(message);
        updateHelloData(message);
      }
    });

  }

  private void updateHelloData(String message) {
    state.helloMessage = message;
    state.progressBarVisibility = false;

    view.get().displayHelloData(state);
  }

  @Override
  public void sayHelloButtonClicked() {
    //Log.e(TAG, "sayHelloButtonClicked()");

    state.helloMessage = "";
    state.progressBarVisibility = true;

    view.get().displayHelloData(state);

    // call the model
    startHelloMessageAsyncTask();

  }

  @Override
  public void goByeButtonClicked() {
    //Log.e(TAG, "goByeButtonClicked()");

    HelloToByeState newState = new HelloToByeState(state.helloMessage);
    router.passDataToByeScreen(newState);
    //router.navigateToByeScreen();
    view.get().navigateToByeScreen();
  }


}
