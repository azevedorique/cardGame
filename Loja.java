
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Loja {

    private String nCartao;
    private String verif;
    private int cardCoins;
    private List<Carta> inventario;
    private boolean promocao;

    public Loja(String nCartao, String verif, boolean promocao) {
        this.nCartao = nCartao;
        this.verif = verif;
        this.cardCoins = 0;
        this.inventario = new ArrayList<>();
        this.promocao = promocao;
    }

    // Getters e setters para os atributos

    public void adicionarAoInventario(Carta carta) {
        inventario.add(carta);
    }

    public void buyBooster() {
        int precoBooster = promocao ? 300 : 200; // Preço 50% mais caro se estiver em promoção
        if (cardCoins >= precoBooster) {
            this.cardCoins -= precoBooster;
            
            List<Carta> booster = abrirBooster();

            for (Carta card : booster) {
                adicionarAoInventario(card);
            }
            System.out.println("Booster adquirido");
            if (contarCartasTipoEspecifico() >= 3) {
                int valor = 20;
                this.cardCoins += valor;
                System.out.println("Você já tem 3 cartas desse tipo! No lugar das cartas você irá receber " + valor + " cardcoins");
            }
        } else {
            System.out.println("Dinheiro insuficiente");
        }
    }

    public List<Carta> abrirBooster() {
        List<Carta> booster = new ArrayList<>(12);
        
        Random random = new Random();
        double chanceCartaUnica = promocao ? 0.01 : 0.005; // Probabilidade 1% se estiver em promoção, 0.5% caso contrário
        
        for (int i = 0; i < 12; i++) {
            if (random.nextDouble() <= chanceCartaUnica) {
                // Adicione aqui a lógica para criar uma carta única
                booster.add(new CartaUnica());
            } else {
                // Adicione aqui a lógica para criar uma carta comum
                booster.add(new CartaComum());
            }
        }
        
        return booster;
    }

    public int contarCartasTipoEspecifico() {
        // Implemente a lógica para contar as cartas de um tipo específico no inventário aqui
        return 0; // Substitua por sua implementação real
    }
}


