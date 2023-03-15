package es.ulpgc.eite.cleancode.helloworld.bye;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.cleancode.helloworld.R;
import es.ulpgc.eite.cleancode.helloworld.app.GetMessageAsyncTaskCallback;


public class ByeActivity
    extends AppCompatActivity implements ByeContract.View {

  public static String TAG = ByeActivity.class.getSimpleName();

  ByeContract.Presenter presenter;

  Button sayByeButton, goHelloButton;
  TextView byeMessage;
  ProgressBar progressBar;

  private boolean running;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_bye);

    getSupportActionBar().setTitle(R.string.bye_screen_title);

    sayByeButton = findViewById(R.id.sayByeButton);
    goHelloButton = findViewById(R.id.goHelloButton);
    byeMessage = findViewById(R.id.byeMessage);
    progressBar = findViewById(R.id.progressBar);

    sayByeButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        presenter.sayByeButtonClicked();
      }
    });

    goHelloButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        presenter.goHelloButtonClicked();
      }
    });

    sayByeButton.setText(getSayByeButtonLabel());
    goHelloButton.setText(getGoHelloButtonLabel());

    // do the setup
    ByeScreen.configure(this);

  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.onResumeCalled();
  }

  @Override
  protected void onPause() {
    super.onPause();

    // do some work
    presenter.onPauseCalled();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    // do some work
    presenter.onDestroyCalled();
  }

  @Override
  public void displayByeData(ByeViewModel viewModel) {
    Log.e(TAG, "displayByeData()");

    // deal with the data
    byeMessage.setText(viewModel.byeMessage);

    if(viewModel.progressBarVisibility) {
      progressBar.setVisibility(View.VISIBLE);
    } else {
      progressBar.setVisibility(View.INVISIBLE);
    }
  }

  @Override
  public void getByeMessage(final GetMessageAsyncTaskCallback callback) {
    Log.e(TAG, "getByeMessage()");


    running = true;

    new Handler().postDelayed(new Runnable() {

      @Override
      public void run() {
        // Execute async code

        String message = getString(R.string.bye_message);

        if (callback != null) {
          callback.onGetMessageAsyncTaskFinished(message);
        }

        running = false;

      }
    }, 5000);
  }

  @Override
  public void finishView() {
    finish();
  }

  private String getGoHelloButtonLabel() {
    return getResources().getString(R.string.go_hello_button_label);
  }

  private String getSayByeButtonLabel() {
    return getResources().getString(R.string.say_bye_button_label);
  }


  @Override
  public void injectPresenter(ByeContract.Presenter presenter) {
    this.presenter = presenter;
  }
}
