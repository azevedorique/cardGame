import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<String> cartas;
    private boolean disponibilidade;
    private List<String> inventario2;

    public Deck(String nome) {
        this.cartas = new ArrayList<>();
        this.disponibilidade = false;
        this.inventario2 = new ArrayList<>();
    }
    public List<String> getCartas() {
        return cartas;
    }
    public void setCartas(List<String> cartas) {
        this.cartas = new ArrayList<>();
    }
    public boolean getDisponibilidade() {
        return disponibilidade;
    }
    public void setDisponibilidade (boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    public List<String> getInventario2() {
        return inventario2;
    }
    public void setInventario2(List<String> inventario2) {
        this.inventario2 = new ArrayList<>();
    }

    public void adicionarCarta(String carta) {
        if (podeAdicionarCarta(carta)) {
            cartas.add(carta);
            removerDoInventario(carta);
            atualizarDisponibilidade();
        }
    }

    public void removerCarta(String carta) {
        if (cartas.contains(carta)) {
            cartas.remove(carta);
            adicionarAoInventario(carta);
            atualizarDisponibilidade();
        }
    }

    private boolean podeAdicionarCarta(String carta) {
        int quantidadeAtual = cartas.size();
        if (quantidadeAtual >= 60) {
            return false; // Não é possível adicionar mais cartas, o deck já tem 60 ou mais cartas.
        }

        int quantidadeNoDeck = contarCartasNoDeck(carta);
        if (quantidadeNoDeck >= 3 && !carta.equals("mana")) {
            return false; // Não é possível adicionar mais cartas repetidas (exceto mana).
        }

        return inventario2.contains(carta); // Verifica se a carta está no inventário.
    }

    private int contarCartasNoDeck(String carta) {
        int count = 0;
        for (String c : cartas) {
            if (c.equals(carta)) {
                count++;
            }
        }
        return count;
    }

    private void removerDoInventario(String carta) {
        inventario2.remove(carta);
    }

    private void adicionarAoInventario(String carta) {
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
}