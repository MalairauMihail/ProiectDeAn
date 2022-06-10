package tmps1;

import tmps1.Strategy1.WorkingWithFiles;

import java.util.ArrayList;
//Composite
public class Catalog extends WorkingWithFiles implements CatalogBuilder {
  private ArrayList<Compartiment> compartimentList = new ArrayList<Compartiment>();

  private ShowCatalogFunctions showCatalogFunctions = new ShowCatalogFunctions();
  private Prototype prototype = new Prototype();

  public ArrayList<Compartiment> getCompartimentList() {
    return this.compartimentList;
  }

  @Override
  public void AddCompartiment(String titlu) {

    this.compartimentList.add(new Compartiment(titlu));
    SaveCatalog(this.compartimentList);
    ReloadedCatalog();
  }

  @Override
  public void AddProduct(int index, String titlu, String descriere, int grame, int pret) {

    this.compartimentList.get(index).AddProduct(titlu, descriere, grame, pret);
    SaveCatalog(this.compartimentList);
    ReloadedCatalog();
  }

  @Override
  public void AddClonedProduct(int indexCompartiment, int indexProduct) {

    this.compartimentList.get(indexCompartiment).AddClonedProduct(
        prototype.cloneProduct(
            this.compartimentList.get(indexCompartiment).getProducts().get(indexProduct)
        )
    );
    SaveCatalog(this.compartimentList);
    ReloadedCatalog();
  }

  @Override
  public void RemoveCompartiment(int index) {
    this.compartimentList.remove(index);
  }

  @Override
  public void RemoveProduct(int indexCompartimet, int indexProduct) {

    this.compartimentList.get(indexCompartimet).RemoveProduct(indexProduct);
    SaveCatalog(this.compartimentList);
    ReloadedCatalog();
  }

  @Override
  public void ReloadedCatalog() {
    this.compartimentList = (ArrayList<Compartiment>) super.ReloadCatalog();
  }

  @Override
  public void ShowMainCatalog() {
    showCatalogFunctions.ShowMainCatalog(this.compartimentList);
  }

  @Override
  public void ShowSubCatalog(int indexCompartiment) {
    showCatalogFunctions.ShowSubCatalog(indexCompartiment, this.compartimentList);
  }

  @Override
  public void ShowBasket(ClientBascket bascket) {
    showCatalogFunctions.ShowBasket(bascket, this.compartimentList);
  }

  //Memento
  public ArrayList<Compartiment> getCatalogForSave(){
    return this.compartimentList;
  }

  //Memento
  public void loadBackup(CatalogMemento catalogMemento){
    this.compartimentList = catalogMemento.getCatalogBackup();
  }
}
