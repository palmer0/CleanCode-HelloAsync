package es.ulpgc.eite.cleancode.helloworld.hello;


import java.util.Objects;

public class HelloViewModel  {

  public boolean progressBarVisibility = false;
  public String helloMessage = "";

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    HelloViewModel viewModel = (HelloViewModel) obj;
    return progressBarVisibility == viewModel.progressBarVisibility &&
        Objects.equals(helloMessage, viewModel.helloMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(progressBarVisibility, helloMessage);
  }

  @Override
  public String toString() {
    return
        "helloMessage: " + helloMessage + ", " +
        "progressBarVisibility: " + progressBarVisibility ;
  }
}

