import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private static Deck instance;

    private List<Carta> cartas;
    private boolean disponibilidade;
    private List<Carta> inventario2;

    private Deck() {
        this.cartas = new ArrayList<>();
        this.disponibilidade = false;
        this.inventario2 = new ArrayList<>();
    }
    
    public static Deck getInstance() {
        if (instance == null) {
            instance = new Deck();
        }
        return instance;
    }

    public void adicionarCarta(Carta carta) {
        if (podeAdicionarCarta(carta)) {
            cartas.add(carta);
            removerDoInventario(carta);
            atualizarDisponibilidade();
        }
    }

    public void removerCarta(Carta carta) {
        if (cartas.contains(carta)) {
            cartas.remove(carta);
            adicionarAoInventario(carta);
            atualizarDisponibilidade();
        }
    }

    private boolean podeAdicionarCarta(Carta carta) {
        int quantidadeAtual = cartas.size();
        if (quantidadeAtual >= 60) {
            return false; // Não é possível adicionar mais cartas, o deck já tem 60 ou mais cartas.
        }

        int quantidadeNoDeck = contarCartasNoDeck(carta);
        if (quantidadeNoDeck >= 3 && !carta.getTipo().equals("mana")) {
            return false; // Não é possível adicionar mais cartas repetidas (exceto mana).
        }

        return inventario2.contains(carta); // Verifica se a carta está no inventário.
    }

    private int contarCartasNoDeck(Carta carta) {
        int count = 0;
        for (Carta c : cartas) {
            if (c.equals(carta)) {
                count++;
            }
        }
        return count;
    }

    private void removerDoInventario(Carta carta) {
        inventario2.remove(carta);
    }

    private void adicionarAoInventario(Carta carta) {
        inventario2.add(carta);
    }

    private void atualizarDisponibilidade() {
        disponibilidade = (cartas.size() >= 60);
    }

    public boolean isDisponivel() {
        return disponibilidade;
    }

    public int getQuantidadeCartas() {
        return cartas.size();
    }

    public Carta sacarCartaAleatoria() {
        if (!cartas.isEmpty()) {
            Random random = new Random();
            int indiceCartaAleatoria = random.nextInt(cartas.size());
            Carta cartaSacada = cartas.remove(indiceCartaAleatoria);
            adicionarAoInventario(cartaSacada);
            atualizarDisponibilidade();
            return cartaSacada;
        } else {
            System.out.println("O deck está vazio. Não é possível sacar uma carta.");
            return null;
        }
    }
}
