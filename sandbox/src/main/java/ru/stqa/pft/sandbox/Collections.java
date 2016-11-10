package ru.stqa.pft.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jane on 11/10/16.
 */
public class Collections {

  public static void main(String[] args) {
    String[] langs = {"JAVA", "C#", "Python", "PHP"};

    List<String> languages = Arrays.asList("JAVA", "C#", "Python", "PHP");


    for (String l : languages) {
      System.out.println("Я хочу выучить " + l);
    }
  }
}
