import java.util.ArrayList;
import java.util.List;
 public class Loja {

    private String nCartao;
    private String verif;
    private int cardCoins;
    private List<Carta> inventario;

public Loja(String nCartao, String verif){
        this.nCartao = nCartao;
        this.verif = verif;
        this.cardCoins = 0;
         this.inventario = new ArrayList<>();
    }

    public String getnCartao() {
        return nCartao;
    }

    public void setnCartao(String nCartao) {
        this.nCartao = nCartao;
    }

    public String getVerif() {
        return verif;
    }

    public void setVerif(String verif) {
        this.verif = verif;
    }
  public int getCardCoins() {
    return cardCoins;
  }
  public void setCardCoins(int cardCoins) {
    this.cardCoins = cardCoins;
  }
  public List<Carta> getInventario() {
        return inventario;
    }

    public void setInventario(List<Carta> inventario) {
        this.inventario = inventario;
    }

    public void buyBooster() {
       int precoBooster = 200;
       if (cardCoins >= precoBooster) {
        this.cardCoins = precoBooster - cardCoins;

        List<Carta> booster = <>(12);

        for (Carta card : booster) {
            adicionarAoInventario(card);
        }
        System.out.println("Booster adquirido");
        if (Inventario.getCarta() >=3) {
            int valor = 20;
           this.cardcoins = cardcoins + valor;
           System.out.println("Você já tem 3 cartas desse tipo! No lugar das cartas você irá receber " + valor + " cardcoins");

        }
       }
       else {
        System.out.println("Dinheiro insuficiente");
       }
    
    }

}

