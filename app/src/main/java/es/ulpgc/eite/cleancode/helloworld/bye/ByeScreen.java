package es.ulpgc.eite.cleancode.helloworld.bye;


import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.helloworld.R;
import es.ulpgc.eite.cleancode.helloworld.app.AppMediator;

public class ByeScreen {

  public static void configure(ByeContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    //String message = context.get().getString(R.string.hello_message);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    ByeState state = mediator.getByeState();

    ByeContract.Router router = new ByeRouter(mediator);
    ByeContract.Presenter presenter = new ByePresenter(state);
    //ByeContract.Model model = new ByeModel(message);
    ByeContract.Model model = new ByeModel();
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    presenter.injectRouter(router);

    view.injectPresenter(presenter);

  }

}
