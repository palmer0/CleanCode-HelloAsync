package es.ulpgc.eite.cleancode.helloworld.hello;


import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.helloworld.app.AppMediator;

public class HelloScreen {

  public static void configure(HelloContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    //String message = context.get().getString(R.string.hello_message);

    //AppMediator mediator = (AppMediator) context.get().getApplication();
    AppMediator mediator = AppMediator.getInstance();
    HelloState state = mediator.getHelloState();

    HelloContract.Router router = new HelloRouter(mediator);
    HelloContract.Presenter presenter = new HelloPresenter(state);
    //HelloContract.Model model = new HelloModel(message);
    HelloContract.Model model = new HelloModel();
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    presenter.injectRouter(router);

    view.injectPresenter(presenter);

  }

}
