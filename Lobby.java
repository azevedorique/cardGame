
 import java.util.ArrayList;
import java.util.List;

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
        for (Lobby lobby : lobbies) {
            if (lobby != this && lobby.isDisponivel() && lobby.getModoJogo().equals(modoJogo)) {
                // Encontrou um adversário disponível no mesmo modo de jogo.
                iniciarPartida(this, lobby);
                return true;
            }
        }
        return false; // Não encontrou um adversário disponível.
    }

    private void iniciarPartida(Lobby jogador1, Lobby jogador2) {
        // Lógica para iniciar a partida com os dois jogadores.
        Arena arena = new Arena(jogador1, jogador2);
        arena.iniciarPartida();
    }

    public boolean isDisponivel() {
        return disponibilidade2;
    }

    public String getModoJogo() {
        return modoJogo;
    }
}
