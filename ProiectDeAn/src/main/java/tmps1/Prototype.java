package tmps1;

public class Prototype {

  Product cloneProduct(Product product) {
    return (Product) product.copy();
  }

}
