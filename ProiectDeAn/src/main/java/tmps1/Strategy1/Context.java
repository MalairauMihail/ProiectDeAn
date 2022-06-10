package tmps1.Strategy1;

import tmps1.Compartiment;

import java.util.ArrayList;

public class Context {
  private Strategy strategy;

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public Object executeStrategy(ArrayList<Compartiment> compartimentList){
    return strategy.execute( compartimentList);
  }
}
