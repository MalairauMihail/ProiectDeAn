package tmps1.Strategy1;

import tmps1.Compartiment;

import java.util.ArrayList;

public interface Strategy {
  Object execute(ArrayList<Compartiment> compartimentList);
}
