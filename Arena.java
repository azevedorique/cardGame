  
import java.util.Random;

public class Arena {

    private static Arena instance;

    protected Lobby jogador1;
    protected Lobby jogador2;
    protected Carta[][] campoJogador1;
    protected Carta[][] campoJogador2;
    protected int pontosVidaJogador1;
    protected int pontosVidaJogador2;
   
    public Arena(Lobby jogador1, Lobby jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.campoJogador1 = new Carta[2][5];
        this.campoJogador2 = new Carta[2][5];
        this.pontosVidaJogador1 = 20;
        this.pontosVidaJogador2 = 20;
    }

    public static Arena getInstance(Lobby jogador1, Lobby jogador2) {
        if (instance == null) {
            instance = new Arena(jogador1, jogador2);
        }
        return instance;
    }

    public void sacar(Lobby jogador, Deck deck) {
        if (jogador.getDeck().getQuantidadeCartas() >= 7) {
            Carta cartaSacada;
            Carta cartaNoDeck;
            for (int i = 0; i < 7; i++) {
                cartaSacada = jogador.getDeck().sacarCartaAleatoria();
                deck.removerCarta(cartaSacada);
                jogador.adicionarCartaNaMao(cartaSacada);
            }
            int cartasParaRetornar = Math.min(5, jogador.getTamanhoMao());
            for (int i = 0; i < cartasParaRetornar; i++) {
                cartaNoDeck = jogador.getDeck().sacarCartaAleatoria();
                jogador.removerCartaDaMao(i);
                deck.adicionarCarta(cartaNoDeck);
            }
            for (int i = 0; i < cartasParaRetornar; i++) {
                cartaNoDeck = jogador.getDeck().sacarCartaAleatoria();
                deck.removerCarta(cartaNoDeck);
                jogador.adicionarCartaNaMao(cartaNoDeck);
            }
        } else {
            System.out.println("Não há cartas suficientes no deck para fazer um saque.");
        }
    }
    

    public void iniciarPartida() {
    
        System.out.println("A partida começou!");

    
        if (new Random().nextBoolean()) {
            System.out.println("Jogador 1 começa.");
            turno(jogador1, jogador2);
        } else {
            System.out.println("Jogador 2 começa.");
            turno2(jogador2, jogador1);
        }
    }

    protected void turno(Lobby jogadorAtivo, Lobby jogadorOponente) {
        System.out.println("Turno do Jogador " + jogadorAtivo.getNome() + ".");

        
        comprar(jogadorAtivo);
        posicionamento(jogadorAtivo);
        ataque(jogadorAtivo, jogadorOponente);

        
        if (pontosVidaJogador1 <= 0 || pontosVidaJogador2 <= 0) {
            terminarPartida(jogadorAtivo,jogadorOponente);
        } 
            
          
        
    }

    public void comprar(Lobby jogador) {
        if (jogador.getDeck().getQuantidadeCartas() > 1) {
 
            Carta cartaSacada = (jogador.getDeck()).sacarCartaAleatoria();

            
            jogador.setManaMaxima(jogador.getManaMaxima() + 1);

            
            jogador.adicionarCartaNaMao(cartaSacada);

            System.out.println("Jogador " + jogador.getNome() + " sacou uma carta: " + cartaSacada.getNome());
        }
    }

    public void posicionamento(Lobby jogador) {
        if (jogador.getManaMaxima() > 0) {
            
            int posicaoMao = new Random().nextInt(jogador.getTamanhoMao());

            Carta cartaSelecionada = jogador.getCartaNaMao(posicaoMao);

            if (cartaSelecionada != null) {
 
                if (jogador == jogador1) {
                    campoJogador1[1][posicaoMao] = cartaSelecionada;
                } else {
                    campoJogador2[1][posicaoMao] = cartaSelecionada;
                }

                
                jogador.setManaMaxima(jogador.getManaMaxima() - 1);

                
                jogador.removerCartaDaMao(posicaoMao);

                System.out.println("Jogador " + jogador.getNome() + " posicionou uma carta no campo: " + cartaSelecionada.getNome());
            }
        }
    }

    public void ataque(Lobby jogadorAtivo, Lobby jogadorOponente) {
        System.out.println("Ataque de  " + jogadorAtivo.getNome());
        Carta[][] campoAtivo = (jogadorAtivo == jogador1) ? campoJogador1 : campoJogador2;
        Carta[][] campoOponente = (jogadorAtivo == jogador1) ? campoJogador2 : campoJogador1;
        for (int i = 0; i < campoAtivo.length; i++) {
            for (int j = 0; j < campoAtivo[i].length; j++) {
                Carta cartaAtiva = campoAtivo[i][j];

                if (cartaAtiva != null) {
                    int posicaoAlvo = new Random().nextInt(campoOponente[i].length);
                    Carta cartaAlvo = campoOponente[i][posicaoAlvo];
                    if (cartaAlvo != null) {
                        int dano = cartaAtiva.getAtaque() - cartaAlvo.getDefesa();
    

                        jogadorOponente.diminuirPontosVida(dano);
    
                }
                if (cartaAlvo.getPontosVida() <= 0) {
                    jogadorOponente.adicionarCartaAoCemiterio(cartaAlvo);
                    campoOponente[i][posicaoAlvo] = null;
                }
                System.out.println("Jogador " + jogadorAtivo.getNome() + " atacou com " + cartaAtiva.getNome() + " causando " + cartaAtiva.getAtaque() + " de dano a carta " + cartaAlvo.getNome() + " de " + jogadorOponente.getNome());
    }
    
            }
        
        }
    }


   

    public int getPontosVidaJogador1() {
        return pontosVidaJogador1;
    }

    public int getPontosVidaJogador2() {
        return pontosVidaJogador2;
    }

    private void turno2(Lobby jogadorAtivo, Lobby jogadorOponente) {
        System.out.println("Turno do Jogador " + jogadorAtivo.getNome() + ".");

        calcularDano(jogadorAtivo, jogadorOponente);
        calcularDano(jogadorOponente, jogadorAtivo);

        if (pontosVidaJogador1 <= 0) {
            terminarPartida(jogador2, jogador1);
        } else if (pontosVidaJogador2 <= 0) {
            terminarPartida(jogador1, jogador2);
        }

        
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