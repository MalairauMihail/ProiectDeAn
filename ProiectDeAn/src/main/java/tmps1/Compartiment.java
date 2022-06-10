package tmps1;

import java.util.ArrayList;

public class Compartiment{
  private String name;
  private ArrayList<Product> compartimentProducts = new ArrayList<Product>();

  public Compartiment(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public ArrayList<Product> getProducts() {
    return this.compartimentProducts;
  }

  public void AddProduct(String titlu, String descriere, int grame, int pret){
    this.compartimentProducts.add(new Product(titlu, descriere, grame, pret));
  }

  public void AddClonedProduct(Product product){
    this.compartimentProducts.add(product);
  }

  public void RemoveProduct(int index){
    this.compartimentProducts.remove(index);
  }

  public Object copy() {
    return this;
  }

}
