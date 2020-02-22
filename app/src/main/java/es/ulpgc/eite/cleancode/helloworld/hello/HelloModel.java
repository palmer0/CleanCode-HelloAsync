package es.ulpgc.eite.cleancode.helloworld.hello;

import android.util.Log;

public class HelloModel implements HelloContract.Model {

  public static String TAG = HelloModel.class.getSimpleName();

  private String message;

  @Override
  public String getHelloMessage() {
    return message;
  }

  @Override
  public void setHelloMessage(String message) {
    Log.e(TAG, "setHelloMessage()");

    this.message = message;
  }
}
