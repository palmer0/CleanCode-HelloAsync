package es.ulpgc.eite.cleancode.helloworld.bye;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.helloworld.app.AppMediator;
import es.ulpgc.eite.cleancode.helloworld.app.ByeToHelloState;
import es.ulpgc.eite.cleancode.helloworld.app.GetMessageAsyncTaskCallback;
import es.ulpgc.eite.cleancode.helloworld.app.HelloToByeState;


public class ByePresenter implements ByeContract.Presenter {

  public static String TAG = ByePresenter.class.getSimpleName();

  private WeakReference<ByeContract.View> view;
  private ByeState state;
  private ByeContract.Model model;
  private AppMediator mediator;

  public ByePresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getByeState();
  }


  private HelloToByeState getDataFromHelloScreen() {
    return mediator.getHelloToByeState();
  }

  private void passDataToHelloScreen(ByeToHelloState state) {

    mediator.setByeToHelloState(state);
  }

  @Override
  public void onResumeCalled() {
    Log.e(TAG, "onResumeCalled()");

    HelloToByeState savedState = getDataFromHelloScreen();
    if(savedState != null){

      // set passed state
      state.byeMessage = savedState.message;
    }

    view.get().displayByeData(state);

    if(state.progressBarVisibility) {
      startByeMessageAsyncTask();
    }

  }

  @Override
  public void onPauseCalled() {
    Log.e(TAG, "onPauseCalled()");

  }

  @Override
  public void onDestroyCalled() {
    Log.e(TAG, "onDestroyCalled()");

  }

  private void startByeMessageAsyncTask() {
    Log.e(TAG, "startByeMessageAsyncTask()");

    /*
    String message = model.getByeMessage();
    if(message != null) {
      updateByeData(message);

      return;
    }
    */

    view.get().getByeMessage(new GetMessageAsyncTaskCallback() {

      @Override
      public void onGetMessageAsyncTaskFinished(String message) {

        model.setByeMessage(message);
        updateByeData(message);
      }
    });

  }

  private void updateByeData(String message) {

    state.byeMessage = message;
    state.progressBarVisibility = false;

    view.get().displayByeData(state);
  }

  @Override
  public void sayByeButtonClicked() {
    Log.e(TAG, "sayByeButtonClicked()");

    state.byeMessage = "";
    state.progressBarVisibility = true;

    view.get().displayByeData(state);

    // call the model
    startByeMessageAsyncTask();
  }

  @Override
  public void goHelloButtonClicked() {
    ByeToHelloState newState = new ByeToHelloState(state.byeMessage);
    passDataToHelloScreen(newState);
    view.get().finishView();
  }


  @Override
  public void injectView(WeakReference<ByeContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(ByeContract.Model model) {
    this.model = model;
  }
}
