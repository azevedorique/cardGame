import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lobby {
    private String nome;
    private List<String> cartas2;
    private String modoJogo;
    private boolean disponibilidade2;

    public Lobby(String nome, List<String> cartas2, String modoJogo) {
        this.nome = nome;
        this.cartas2 = cartas2;
        this.modoJogo = modoJogo;
        this.disponibilidade2 = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void selecionarDeck() {
        // Lógica para o jogador selecionar o deck
        // Pode envolver a interface do usuário ou outro método de escolha.
        disponibilidade2 = true; // Assumindo que o deck agora está disponível para o jogo.
    }

    public void selecionarModoJogo(String modo) {
        // Lógica para o jogador selecionar o modo de jogo
        // Pode envolver a interface do usuário ou outro método de escolha.
        modoJogo = modo;
    }

    public boolean buscarAdversario(List<Lobby> lobbies) {
        // Lógica para buscar um adversário com um deck disponível e no mesmo modo de jogo.
        if (modoJogo.equals("Modo Dupla")) {
            // Modo de jogo em dupla
            List<Lobby> lobbiesDisponiveis = new ArrayList<>();
            for (Lobby lobby : lobbies) {
                if (lobby != this && lobby.isDisponivel() && lobby.getModoJogo().equals("Modo Dupla")) {
                    lobbiesDisponiveis.add(lobby);
                }
            }
            if (lobbiesDisponiveis.size() >= 2) {
                // Encontrou pelo menos dois jogadores disponíveis no modo de jogo em dupla.
                Random random = new Random();
                int index1 = random.nextInt(lobbiesDisponiveis.size());
                int index2;
                do {
                    index2 = random.nextInt(lobbiesDisponiveis.size());
                } while (index2 == index1);

                iniciarPartida(this, lobbiesDisponiveis.get(index1), lobbiesDisponiveis.get(index2));
                return true;
            }
        }
        return false; // Não encontrou um adversário disponível ou não está no modo de jogo em dupla.
    }

    private void iniciarPartida(Lobby jogador1, Lobby jogador2, Lobby jogador3) {
        // Lógica para iniciar a partida com os dois jogadores em dupla.
        ArenaDupla arena = new ArenaDupla(jogador1, jogador2, jogador3);
        arena.iniciarPartida();
    }

    public boolean isDisponivel() {
        return disponibilidade2;
    }

    public String getModoJogo() {
        return modoJogo;
    }

    public Object getDeck() {
        return null;
    }

    public int getManaMaxima() {
        return 0;
    }

    public void setManaMaxima(int i) {
    }

    public void adicionarCartaNaMao(Carta cartaSacada) {
    }

    public int getTamanhoMao() {
        return 0;
    }

    public Carta getCartaNaMao(int posicaoMao) {
        return null;
    }

    public void removerCartaDaMao(int posicaoMao) {
    }

    public void diminuirPontosVida(int dano) {
    }

    public void adicionarCartaAoCemiterio(Carta cartaAtiva) {
    }

    public void adicionarCardCoins(int i) {
    }
}
