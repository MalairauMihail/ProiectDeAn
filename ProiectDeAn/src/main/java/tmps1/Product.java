package tmps1;

public class Product {
  private String titlu;
  private String descriere;
  private int grame;
  private int pret;

  public Product(String titlu, String descriere, int grame, int pret) {
    this.descriere = descriere;
    this.grame = grame;
    this.pret = pret;
    this.titlu = titlu;
  }

  public String getTitlu() {
    return titlu;
  }

  public String getDescriere() {
    return descriere;
  }

  public int getGrame() {
    return grame;
  }

  public int getPret() {
    return pret;
  }

  public Object copy() {
    return this;
  }
}
