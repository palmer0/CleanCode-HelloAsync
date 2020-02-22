package es.ulpgc.eite.cleancode.helloworld.bye;

import android.util.Log;

public class ByeModel implements ByeContract.Model {

  public static String TAG = ByeModel.class.getSimpleName();

  private String message;

  @Override
  public String getByeMessage() {
    return message;
  }

  @Override
  public void setByeMessage(String message) {
    Log.e(TAG, "setByeMessage()");

    this.message = message;
  }
}
