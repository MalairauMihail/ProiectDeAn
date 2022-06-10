package tmps1;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    Catalog catalog = new Catalog();
    CatalogMemento catalogMemento;
    ClientBascket bascket = new ClientBascket();
    int thisCompartiment = 0;
    boolean isExit = true;
    boolean isCompartiment = false;
    String command;

    catalog.ReloadedCatalog();
    catalog.ShowMainCatalog();

    catalogMemento = new CatalogMemento(catalog.getCatalogForSave());

    while (isExit) {
      command = InputString();

      if (command.contains("exit")) isExit = false;//exit app

      else if (command.contains("add")) {

        CreateProductOrCompartiment(command, catalog);
        isCompartiment = false;

      } else if (command.contains("restoreBackup")) {

        catalog.loadBackup(catalogMemento);

      } else if (command.contains("backup")) {

        catalogMemento = new CatalogMemento(catalog.getCatalogForSave());

      } else if (command.contains("cloneProduct")) {

        CloneProduct(catalog);
        isCompartiment = false;

      } else if (command.contains("remove")) {

        RemoveProductOrCompartiment(command, catalog);
        isCompartiment = false;

      } else if (isNumeric(command) && !isCompartiment) {

        catalog.ShowSubCatalog(Integer.parseInt(command));
        thisCompartiment = Integer.parseInt(command);
        isCompartiment = true;

      } else if (isNumeric(command) && isCompartiment) {

        bascket.addProductBasket(thisCompartiment, Integer.parseInt(command));
        System.out.println("Comanda " + catalog.getCompartimentList().
            get(thisCompartiment).getProducts().
            get(Integer.parseInt(command)).
            getTitlu() + " este adaugat in cos");

      } else if ((command.contains("back") && isCompartiment) || command.contains("main")) {

        catalog.ShowMainCatalog();
        isCompartiment = false;

      } else if (command.contains("basket")) {

        catalog.ShowBasket(bascket);

      }
    }
  }

  static void CreateProductOrCompartiment(String string, Catalog catalog) {

    if (string.contains("Compartiment")) {

      String titlu = InputString("Inserati titlul compartimentului: ");
      catalog.AddCompartiment(titlu);
      catalog.ShowMainCatalog();

    } else if (string.contains("Product")) {

      int index = InputInt("Inserati indexul compartimentului: ");
      String titlu = InputString("Inserati titlul produsului: ");
      String descriere = InputString("Inserati descrierea produsului: ");
      int grame = InputInt("Inserati gramele produsului: ");
      int pret = InputInt("Inserati pretul produsului: ");

      catalog.AddProduct(index, titlu, descriere, grame, pret);
      catalog.ShowMainCatalog();

    } else {
      System.out.println("Incerceti 'add'+(Compartiment sau Product)");
    }
  }

  static void RemoveProductOrCompartiment(String string, Catalog catalog) {

    if (string.contains("Compartiment")) {

      int indexCompartiment = InputInt("Inserati indexul compartimentului: ");

      catalog.RemoveCompartiment(indexCompartiment);
      catalog.ShowMainCatalog();

    } else if (string.contains("Product")) {

      int indexCompartiment = InputInt("Inserati indexul compartimentului: ");
      int indexProduct = InputInt("Inserati indexul produsului: ");

      catalog.RemoveProduct(indexCompartiment, indexProduct);
      catalog.ShowMainCatalog();

    } else {
      System.out.println("Incerceti 'remove'+(Compartiment sau Product)");
    }
  }

  public static void CloneProduct(Catalog catalog) {
    int indexCompartiment = InputInt("Inserati indexul compartimentului: ");
    int indexProduct = InputInt("Inserati indexul produsului: ");

    catalog.AddClonedProduct(indexCompartiment, indexProduct);
    catalog.ShowMainCatalog();
  }

  public static boolean isNumeric(String str) {
    return str != null && str.matches("[-+]?\\d*\\.?\\d+");
  }

  public static String InputString(String string) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(string);
    return scanner.nextLine();
  }

  public static String InputString() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine();
  }

  public static int InputInt(String string) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(string);
    return scanner.nextInt();
  }
}
