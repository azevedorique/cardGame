public class Inventario {

    private static Inventario instance;
    
    private Carta[] carta = new Carta[200];
    private int nivelAtual;
    private int cardCoins;

    private Inventario(int nivelAtual, int cardCoins) {
        this.nivelAtual = nivelAtual;
        this.cardCoins = cardCoins;
    }

    public static Inventario getInstance(int nivelAtual, int cardCoins) {
        if (instance == null) {
            instance = new Inventario(nivelAtual, cardCoins);
        }
        return instance;
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
