package tmps1;

import java.util.ArrayList;

public class CatalogMemento {
  private final ArrayList<Compartiment> CatalogBackup;

  public CatalogMemento(ArrayList<Compartiment> CatalogBackup) {
    this.CatalogBackup = CatalogBackup;
  }

  public ArrayList<Compartiment> getCatalogBackup() {
    return CatalogBackup;
  }
}
