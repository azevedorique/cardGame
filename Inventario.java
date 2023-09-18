 public class Inventario {
    private Carta[] carta = new Carta[200];
    private int nivelAtual;
    private int cardCoins;

    public Inventario(Carta[] carta, int nivelAtual, int cardCoins) {
        this.carta = carta;
        this.nivelAtual = nivelAtual;
        this.cardCoins = cardCoins;
    }
    public Carta[] getCarta() {
        return carta;
    }
    public void setCarta(Carta[] carta) {
        this.carta = carta;
    }
    public int getNivel() {
        return nivelAtual;
    }
    public void setNivel(int nivelAtual) {
        this.nivelAtual = nivelAtual;
    }
    public int getCards() {
        return cardCoins;
    }
    public void setCards(int cardCoins) {
        this.cardCoins = cardCoins;
    }

}
