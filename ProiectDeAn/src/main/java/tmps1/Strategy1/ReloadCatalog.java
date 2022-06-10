package tmps1.Strategy1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import tmps1.Compartiment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class ReloadCatalog implements Strategy{
  private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
  private Path fileName = Path.of("F:\\ProiectDeAn\\src\\main\\java\\tmps1\\catalog.txt");

  @Override
  public Object execute(ArrayList<Compartiment> compartimentList) {
    try {
      return gson.fromJson(Files.readString(fileName), new TypeToken<ArrayList<Compartiment>>(){}.getType());
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
