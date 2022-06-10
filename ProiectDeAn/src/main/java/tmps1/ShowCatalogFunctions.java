package tmps1;

import java.util.ArrayList;

public class ShowCatalogFunctions {
  private int forPurchase = 0;

  public void ShowMainCatalog(ArrayList<Compartiment> compartimentList) {
    EmptyLines();
    System.out.println("Farmacie UTM");
    System.out.println("");

    for (int i = 0; i < compartimentList.size(); i++) {
      System.out.println(i + ". " + compartimentList.get(i).getName() + " -> ");
    }

    System.out.println("");
    System.out.println("Alegeti inserand numarul potrivit: ");
  }

  public void ShowSubCatalog(int indexCompartiment, ArrayList<Compartiment> compartimentList) {
    Compartiment compartiment = compartimentList.get(indexCompartiment);

    EmptyLines();
    System.out.println("Farmacie UTM");
    System.out.println(indexCompartiment + ". " + compartiment.getName() + ": ");
    System.out.println("|...........List...........|");

    for (int i = 0; i < compartiment.getProducts().size(); i++) {
      System.out.println(i + ". " +
          compartiment.getProducts().get(i).getTitlu() +
          "\n|--|Pret: " +
          compartiment.getProducts().get(i).getPret() +
          " mdl" +
          "\n|--|Cantitate: " +
          compartiment.getProducts().get(i).getGrame() +
          " g||ml" +
          "\n|--|Descriere: " +
          compartiment.getProducts().get(i).getDescriere());
    }

    System.out.println("");
    System.out.println("(back - inapoi || main - meniul principal)");
    System.out.println("Alegeti inserand numarul potrivit: ");
  }

  public void ShowBasket(ClientBascket bascket, ArrayList<Compartiment> compartimentList) {
    forPurchase = 0;
    Compartiment compartiment;
    Product product;
    EmptyLines();
    System.out.println("Basket: ");
    System.out.println("|...........List...........|");

    for (int i = 0; i < bascket.getClientProducts().size(); i++) {

      compartiment = compartimentList.get(getIndexCompartimentList(bascket, i));
      System.out.println(
          getIndexCompartimentList(bascket, i) + ". " +
              compartiment.getName() + " :"
      );
      for (int j = 0; j < bascket.getClientProducts().get(i).getProductBaskets().size(); j++) {

        product = compartiment.getProducts().get(getIndexProductList(bascket, i, j));
        System.out.println("-------------------");
        System.out.println(
            "|--|" +
                getIndexProductList(bascket, i, j) +
                ". " +
                product.getTitlu() +
                "\n|--|--|Pret: " +
                product.getPret() +
                " mdl");
        forPurchase += product.getPret();
      }
    }
    System.out.println("");
    System.out.println("Total spre achitare: " + forPurchase + " mdl");
    System.out.println("");
  }

  private int getIndexProductList(ClientBascket bascket, int i, int j) {
    return bascket.getClientProducts().get(i).getProductBaskets().get(j).indexProduct;
  }

  private int getIndexCompartimentList(ClientBascket bascket, int i) {
    return bascket.getClientProducts().get(i).getIndexComaprtiment();
  }

  public void EmptyLines() {
    for (int i = 0; i < 20; i++) {
      System.out.println("\n");
    }
  }
}
