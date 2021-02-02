package es.ulpgc.eite.cleancode.helloworld.hello;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.helloworld.app.ByeToHelloState;
import es.ulpgc.eite.cleancode.helloworld.app.GetMessageAsyncTaskCallback;
import es.ulpgc.eite.cleancode.helloworld.app.HelloToByeState;

public interface HelloContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayHelloData(HelloViewModel viewModel);
    void getHelloMessage(GetMessageAsyncTaskCallback callback);
    void navigateToByeScreen();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    void injectRouter(Router router);

    void onResumeCalled();
    void sayHelloButtonClicked();
    void goByeButtonClicked();
  }

  interface Model {
    String getHelloMessage();
    void setHelloMessage(String message);
  }

  interface Router {

    ByeToHelloState getDataFromByeScreen();
    void passDataToByeScreen(HelloToByeState state);
    //void navigateToByeScreen();
  }
}