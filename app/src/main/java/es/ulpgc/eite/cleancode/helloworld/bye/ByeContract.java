package es.ulpgc.eite.cleancode.helloworld.bye;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.helloworld.app.GetMessageAsyncTaskCallback;


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

    void onResumeCalled();
    void sayByeButtonClicked();
    void goHelloButtonClicked();
  }

  interface Model {
    String getByeMessage();
    void setByeMessage(String message);
  }

}