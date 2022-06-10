package tmps1;

import java.util.ArrayList;

public class CompartimentBasket {
  private int indexComaprtiment;
  private ArrayList<ProductBasket> productBaskets = new ArrayList<ProductBasket>();

  public CompartimentBasket(int indexCompartiment) {
    this.indexComaprtiment = indexCompartiment;
  }

  public void addIndexProduct(int indexProduct){
    ProductBasket product = new ProductBasket();
    product.indexProduct = indexProduct;
    productBaskets.add(product);
  }

  public int getIndexComaprtiment() {
    return indexComaprtiment;
  }

  public ArrayList<ProductBasket> getProductBaskets() {
    return this.productBaskets;
  }
}
