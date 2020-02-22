package es.ulpgc.eite.cleancode.helloworld.bye;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.helloworld.app.ByeToHelloState;
import es.ulpgc.eite.cleancode.helloworld.app.GetMessageAsyncTaskCallback;
import es.ulpgc.eite.cleancode.helloworld.app.HelloToByeState;


public interface ByeContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayByeData(ByeViewModel viewModel);
    void getByeMessage(GetMessageAsyncTaskCallback callback);
    void finishView();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    void injectRouter(Router router);

    void onResumeCalled();
    void sayByeButtonClicked();
    void goHelloButtonClicked();
  }

  interface Model {
    String getByeMessage();
    void setByeMessage(String message);
  }

  interface Router {

    void passDataToHelloScreen(ByeToHelloState state);
    HelloToByeState getDataFromHelloScreen();
  }

}