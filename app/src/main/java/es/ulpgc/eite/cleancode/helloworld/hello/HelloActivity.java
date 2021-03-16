package es.ulpgc.eite.cleancode.helloworld.hello;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.cleancode.helloworld.R;
import es.ulpgc.eite.cleancode.helloworld.app.AppMediator;
import es.ulpgc.eite.cleancode.helloworld.app.GetMessageAsyncTaskCallback;
import es.ulpgc.eite.cleancode.helloworld.bye.ByeActivity;


public class HelloActivity
    extends AppCompatActivity implements HelloContract.View {

  public static String TAG = HelloActivity.class.getSimpleName();

  HelloContract.Presenter presenter;

  Button sayHelloButton, goByeButton;
  TextView helloMessage;
  ProgressBar progressBar;

  private boolean running;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_hello);

    getSupportActionBar().setTitle(R.string.hello_screen_title);

    sayHelloButton = findViewById(R.id.sayHelloButton);
    goByeButton = findViewById(R.id.goByeButton);
    helloMessage = findViewById(R.id.helloMessage);
    progressBar = findViewById(R.id.progressBar);

    sayHelloButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        presenter.sayHelloButtonClicked();
      }
    });

    goByeButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        presenter.goByeButtonClicked();
      }
    });

    sayHelloButton.setText(getSayHelloButtonLabel());
    goByeButton.setText(getGoByeButtonLabel());

    if(savedInstanceState == null){
      AppMediator.resetInstance();
    }

    // do the setup
    HelloScreen.configure(this);

  }


  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.onResumeCalled();
  }

  @Override
  public void navigateToByeScreen() {
    Intent intent = new Intent(this, ByeActivity.class);
    //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
  }


  @Override
  public void displayHelloData(HelloViewModel viewModel) {
    Log.e(TAG, "displayHelloData()");

    // deal with the data
    helloMessage.setText(viewModel.helloMessage);

    if(viewModel.progressBarVisibility) {
      progressBar.setVisibility(View.VISIBLE);
    } else {
      progressBar.setVisibility(View.INVISIBLE);
    }
  }

  @Override
  public void getHelloMessage(final GetMessageAsyncTaskCallback callback) {
    Log.e(TAG, "getHelloMessage()");

    running = true;

    new Handler().postDelayed(new Runnable() {

      @Override
      public void run() {
        // Execute async code

        String message = getString(R.string.hello_message);

        if (callback != null) {
          callback.onGetMessageAsyncTaskFinished(message);
        }

        running = false;

      }
    }, 5000);

  }


  private String getGoByeButtonLabel() {
    return getResources().getString(R.string.go_bye_button_label);
  }

  private String getSayHelloButtonLabel() {
    return getResources().getString(R.string.say_hello_button_label);
  }

  @Override
  public void injectPresenter(HelloContract.Presenter presenter) {
    this.presenter = presenter;
  }
}
