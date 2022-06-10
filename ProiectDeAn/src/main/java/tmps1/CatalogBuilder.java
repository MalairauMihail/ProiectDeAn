package tmps1;

public interface CatalogBuilder {
  void AddCompartiment(String titlu);

  void AddProduct(int index, String titlu, String descriere, int grame, int pret);

  void AddClonedProduct(int indexCompartiment, int indexProduct);

  void RemoveCompartiment(int index);

  void RemoveProduct(int indexCompartimet, int indexProduct);

  void ReloadedCatalog();

  void ShowMainCatalog();

  void ShowSubCatalog(int indexCompartiment);

  void ShowBasket(ClientBascket bascket);
}
