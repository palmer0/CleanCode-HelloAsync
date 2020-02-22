package es.ulpgc.eite.cleancode.helloworld.bye;

import java.util.Objects;

public class ByeViewModel  {

  public boolean progressBarVisibility = false;
  public String byeMessage = "";

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    ByeViewModel that = (ByeViewModel) obj;
    return progressBarVisibility == that.progressBarVisibility &&
        Objects.equals(byeMessage, that.byeMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(progressBarVisibility, byeMessage);
  }

  @Override
  public String toString() {
    return
        "byeMessage: " + byeMessage + ", " +
        "progressBarVisibility: " + progressBarVisibility ;
  }
}

