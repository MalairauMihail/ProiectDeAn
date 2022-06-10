package tmps1.Strategy1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tmps1.Compartiment;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class SaveCatalog implements Strategy{
  private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
  private Path fileName = Path.of("F:\\ProiectDeAn\\src\\main\\java\\tmps1\\catalog.txt");

  @Override
  public Object execute(ArrayList<Compartiment> compartimentList) {
    try {
      Files.writeString(fileName, gson.toJson(compartimentList), StandardCharsets.UTF_8);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
