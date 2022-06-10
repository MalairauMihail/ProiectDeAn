package tmps1;

import java.util.ArrayList;

public class ClientBascket {
  private ArrayList<CompartimentBasket> clientProducts = new ArrayList<CompartimentBasket>();
  private boolean isExistCompartiment = false;

  public void addProductBasket(int indexCompartiment, int indexProduct) {

    for (CompartimentBasket compartimentBasket : clientProducts) {
      if (compartimentBasket.getIndexComaprtiment() == indexCompartiment)
        isExistCompartiment = true;
    }

    if (isExistCompartiment) {
      this.clientProducts.get(indexCompartiment).addIndexProduct(indexProduct);
    } else {
      CompartimentBasket compartimentBasket = new CompartimentBasket(indexCompartiment);
      compartimentBasket.addIndexProduct(indexProduct);
      this.clientProducts.add(compartimentBasket);
    }
    isExistCompartiment = false;
  }

  public ArrayList<CompartimentBasket> getClientProducts() {
    return clientProducts;
  }
}
