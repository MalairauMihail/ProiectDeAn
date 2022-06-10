package tmps1.Strategy1;

import tmps1.Compartiment;

import java.util.ArrayList;

public class WorkingWithFiles {
  private Context context = new Context();

  public Object ReloadCatalog() {
    context.setStrategy(new ReloadCatalog());
    return context.executeStrategy(new ArrayList<Compartiment>());
  }

  public void SaveCatalog(ArrayList<Compartiment> compartimentList) {
    context.setStrategy(new SaveCatalog());
    context.executeStrategy(compartimentList);
  }
}
