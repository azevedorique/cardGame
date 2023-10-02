import java.util.Arrays;
import java.util.Random;

public class Arena {
    private Lobby jogador1;
    private Lobby jogador2;
    private Carta[][] campoJogador1;
    private Carta[][] campoJogador2;
    private int pontosVidaJogador1;
    private int pontosVidaJogador2;
    private Carta[] maoJogador1;
    private Carta[] maoJogador2;
    private int manaMaximaJogador1;
    private int manaMaximaJogador2;
    private Carta[] cemiterioJogador1;
    private Carta[] cemiterioJogador2;

    public Arena(Lobby jogador1, Lobby jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.campoJogador1 = new Carta[2][5];
        this.campoJogador2 = new Carta[2][5];
        this.pontosVidaJogador1 = 20;
        this.pontosVidaJogador2 = 20;
        this.maoJogador1 = new Carta[10];
        this.maoJogador2 = new Carta[10];
        this.manaMaximaJogador1 = 0;
        this.manaMaximaJogador2 = 0;
        this.cemiterioJogador1 = new Carta[100];
        this.cemiterioJogador2 = new Carta[100];
    }

    public void iniciarPartida() {
        // Lógica para iniciar a partida.
        System.out.println("A partida começou!");

        // Sorteia aleatoriamente o jogador que começa.
        if (new Random().nextBoolean()) {
            System.out.println("Jogador 1 começa.");
            turno(jogador1, jogador2);
        } else {
            System.out.println("Jogador 2 começa.");
            turno(jogador2, jogador1);
        }
    }

    private void turno(Lobby jogadorAtivo, Lobby jogadorOponente) {
        System.out.println("Turno do Jogador " + jogadorAtivo.getNome() + ".");

        // Realiza as ações do turno (Compra, Posicionamento, Ataque).
        comprar(jogadorAtivo);
        posicionamento(jogadorAtivo);
        ataque(jogadorAtivo, jogadorOponente);

        // Verifica se o jogo terminou.
        if (pontosVidaJogador1 <= 0 || pontosVidaJogador2 <= 0) {
            terminarPartida();
        } else {
            // Passa o turno para o próximo jogador.
            turno(jogadorOponente, jogadorAtivo);
        }
    }

    private void comprar(Lobby jogador) {
        if (jogador.getDeck().getQuantidadeCartas() > 1) {
            // O jogador tem pelo menos 2 cartas no deck.
            // Sorteia uma carta aleatoriamente.
            Carta cartaSacada = ((Object) jogador.getDeck()).sacarCartaAleatoria();

            // Renova a mana máxima.
            jogador.setManaMaxima(jogador.getManaMaxima() + 1);

            // Adiciona a carta à mão do jogador.
            jogador.adicionarCartaNaMao(cartaSacada);

            System.out.println("Jogador " + jogador.getNome() + " sacou uma carta: " + cartaSacada.getNome());
        }
    }

    private void posicionamento(Lobby jogador) {
        if (jogador.getManaMaxima() > 0) {
            // O jogador tem mana para posicionar uma carta.
            // Vamos assumir que a posição na mão onde a carta será selecionada aleatoriamente.
            int posicaoMao = new Random().nextInt(jogador.getTamanhoMao());

            Carta cartaSelecionada = jogador.getCartaNaMao(posicaoMao);

            if (cartaSelecionada != null) {
                // O jogador tem uma carta na posição selecionada.
                // Posicione a carta no campo (segunda linha).
                if (jogador == jogador1) {
                    campoJogador1[1][posicaoMao] = cartaSelecionada;
                } else {
                    campoJogador2[1][posicaoMao] = cartaSelecionada;
                }

                // Reduz a mana máxima.
                jogador.setManaMaxima(jogador.getManaMaxima() - 1);

                // Remove a carta da mão do jogador.
                jogador.removerCartaDaMao(posicaoMao);

                System.out.println("Jogador " + jogador.getNome() + " posicionou uma carta no campo: " + cartaSelecionada.getNome());
            }
        }
    }

    private void ataque(Lobby jogadorAtivo, Lobby jogadorOponente) {
        // Implemente a lógica de ataque aqui, comparando as cartas nos campos.
        // Você pode usar um loop para verificar as posições no campo de ambos os jogadores
        // e calcular o dano de acordo com as cartas e regras do jogo.
    }

    private void terminarPartida() {
        // Implemente a lógica para encerrar a partida e declarar o vencedor.
    }

    public int getPontosVidaJogador1() {
        return pontosVidaJogador1;
    }

    public int getPontosVidaJogador2() {
        return pontosVidaJogador2;
    }

    private void turno(Lobby jogadorAtivo, Lobby jogadorOponente) {
        System.out.println("Turno do Jogador " + jogadorAtivo.getNome() + ".");

        calcularDano(jogadorAtivo, jogadorOponente);
        calcularDano(jogadorOponente, jogadorAtivo);

        if (pontosVidaJogador1 <= 0) {
            terminarPartida(jogador2, jogador1);
        } else if (pontosVidaJogador2 <= 0) {
            terminarPartida(jogador1, jogador2);
        }

        turno(jogadorOponente, jogadorAtivo);
    }

    private void calcularDano(Lobby jogadorAtivo, Lobby jogadorOponente) {
        Carta[][] campoAtivo = (jogadorAtivo == jogador1) ? campoJogador1 : campoJogador2;
        Carta[][] campoOponente = (jogadorAtivo == jogador1) ? campoJogador2 : campoJogador1;

        for (int i = 0; i < campoAtivo.length; i++) {
            for (int j = 0; j < campoAtivo[i].length; j++) {
                Carta cartaAtiva = campoAtivo[i][j];
                if (cartaAtiva != null) {
                    Carta cartaOponente = campoOponente[i][j];
                    if (cartaOponente != null) {
                        int dano = cartaAtiva.getAtaque() - cartaOponente.getDefesa();
                        if (dano > 0) {
                            jogadorOponente.diminuirPontosVida(dano);
                        }
                        if (cartaAtiva.getPontosVida() <= 0) {
                            jogadorAtivo.adicionarCartaAoCemiterio(cartaAtiva);
                            campoAtivo[i][j] = null;
                        }
                        if (cartaOponente.getPontosVida() <= 0) {
                            jogadorOponente.adicionarCartaAoCemiterio(cartaOponente);
                            campoOponente[i][j] = null;
                        }
                    }
                }
            }
        }
    }

    private void terminarPartida(Lobby vencedor, Lobby perdedor) {
        System.out.println("Jogador " + vencedor.getNome() + " é o vencedor!");

        vencedor.adicionarCardCoins(100);
        perdedor.adicionarCardCoins(10);

        System.out.println("Jogador " + vencedor.getNome() + " ganhou 100 card coins.");
        System.out.println("Jogador " + perdedor.getNome() + " ganhou 10 card coins.");
    }
}

