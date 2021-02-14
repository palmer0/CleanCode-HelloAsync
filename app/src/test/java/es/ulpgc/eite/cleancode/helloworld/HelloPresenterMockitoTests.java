package es.ulpgc.eite.cleancode.helloworld;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.helloworld.app.AppMediator;
import es.ulpgc.eite.cleancode.helloworld.app.ByeToHelloState;
import es.ulpgc.eite.cleancode.helloworld.app.GetMessageAsyncTaskCallback;
import es.ulpgc.eite.cleancode.helloworld.app.HelloToByeState;
import es.ulpgc.eite.cleancode.helloworld.hello.HelloContract;
import es.ulpgc.eite.cleancode.helloworld.hello.HelloPresenter;
import es.ulpgc.eite.cleancode.helloworld.hello.HelloState;
import es.ulpgc.eite.cleancode.helloworld.hello.HelloViewModel;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class HelloPresenterMockitoTests {

  private static final String HELLO_STRING = "Hello World!";
  private static final String BYE_STRING = "Bye World!";
  private static final String EMPTY_STRING = "";


  @Captor
  private ArgumentCaptor<GetMessageAsyncTaskCallback> callbackCaptor;

  @Mock
  private HelloContract.Model modelMock;

  @Mock
  private HelloContract.View viewMock;

  private HelloContract.Presenter presenter;


  @Before
  public void configureMockito() {

    // To inject the mocks in the test this method needs to be called
    MockitoAnnotations.initMocks(this);
  }


  private void configureHelloScreen(HelloState state) {

    // Get a reference to the class under test
    AppMediator mediator = AppMediator.getInstance();
    mediator.setHelloState(state);
    presenter = new HelloPresenter(mediator);
    //presenter = new HelloPresenter(state);

    presenter.injectView(new WeakReference<>(viewMock));
    presenter.injectModel(modelMock);
    //presenter.injectRouter(routerMock);
  }

  @Test
  public void fetchHelloDataWithNullByeState() {
    // Given an initialized HelloPresenter
    // and a null state passed from ByePresenter
    // and a new state is generated including a empty message
    configureHelloScreen(new HelloState());
    //when(routerMock.getDataFromByeScreen()).thenReturn(null);

    HelloState viewModel = new HelloState();
    viewModel.progressBarVisibility = false;
    viewModel.helloMessage = EMPTY_STRING;

    // When loading of data is requested
    presenter.onResumeCalled();

    // Then progress indicator is hidden and empty message is shown in UI
    verify(viewMock).displayHelloData(viewModel);

  }

  @Test
  public void fetchHelloDataWithNotNullByeState() {
    // Given an initialized HelloPresenter
    // and a not null state passed from ByePresenter
    // and a new state is generated including a bye message
    configureHelloScreen(new HelloState());
    ByeToHelloState state = new ByeToHelloState(BYE_STRING);
    //when(routerMock.getDataFromByeScreen()).thenReturn(state);
    AppMediator.getInstance().setByeToHelloState(state);
    HelloState viewModel = new HelloState();
    viewModel.progressBarVisibility = false;
    viewModel.helloMessage = BYE_STRING;

    // When loading of data is requested
    presenter.onResumeCalled();

    // Then progress indicator is hidden and empty message is shown in UI
    verify(viewMock).displayHelloData(viewModel);

  }


  @Test
  public void updateHelloData() {
    // Given an initialized HelloPresenter
    // and a new state is generated including a empty message
    configureHelloScreen(new HelloState());

    HelloState viewModel = new HelloState();
    viewModel.progressBarVisibility = true;
    viewModel.helloMessage = EMPTY_STRING;

    // When updating of data is requested
    presenter.sayHelloButtonClicked();

    // Then progress indicator is not hidden and empty message is shown in UI
    verify(viewMock).displayHelloData(viewModel);
    //verify(routerMock, never()).getDataFromByeScreen();
  }

  @Test
  public void updateHelloDataWithGetMessageAsyncTaskCallback() {
    // Given an initialized HelloPresenter
    // and a new state is generated including a hello message
    configureHelloScreen(new HelloState());

    HelloState viewModel = new HelloState();
    viewModel.progressBarVisibility = false;
    viewModel.helloMessage = HELLO_STRING;

    // When updating of data is requested
    presenter.sayHelloButtonClicked();


    // Callback is captured and invoked with hello message
    verify(viewMock).getHelloMessage(callbackCaptor.capture());
    callbackCaptor.getValue().onGetMessageAsyncTaskFinished(HELLO_STRING);


    // Then progress indicator is hidden and message is shown in UI
    verify(viewMock, times(2)).displayHelloData(viewModel);
    //verify(routerMock, never()).getDataFromByeScreen();

  }

  @Test
  public void startByeScreenWithNotNullByeState() {
    // Given an initialized HelloPresenter
    // and a hello message as passed state to ByePresenter
    configureHelloScreen(new HelloState());
    HelloToByeState state = new HelloToByeState(EMPTY_STRING);
    AppMediator.getInstance().setHelloToByeState(state);

    // When start a new screen is requested
    presenter.goByeButtonClicked();


    // Then router is called to pass the state and start the new screen
//    verify(routerMock, times(1)).passDataToByeScreen(state);
//    verify(routerMock, times(1)).navigateToByeScreen();
//    verify(routerMock, never()).getDataFromByeScreen();
    verify(viewMock, never()).displayHelloData(any(HelloViewModel.class));

  }

  @Test
  public void fetchHelloDataWithNullByeStateAndGetMessageAsyncTaskCallback() {
    // Given an initialized HelloPresenter
    // and a null state passed from ByePresenter
    // and a new state is generated including a empty message
    // and progress is showing in UI
    HelloState state = new HelloState();
    state.progressBarVisibility = true;
    state.helloMessage = EMPTY_STRING;

    configureHelloScreen(state);
    //when(routerMock.getDataFromByeScreen()).thenReturn(null);

    HelloState viewModel = new HelloState();
    viewModel.progressBarVisibility = false;
    viewModel.helloMessage = HELLO_STRING;

    // When loading of data is requested
    presenter.onResumeCalled();

    // Callback is captured and invoked with hello message
    verify(viewMock).getHelloMessage(callbackCaptor.capture());
    callbackCaptor.getValue().onGetMessageAsyncTaskFinished(HELLO_STRING);

    // Then progress indicator is hidden and hello message is shown in UI
    verify(viewMock, times(2)).displayHelloData(viewModel);

  }
}
