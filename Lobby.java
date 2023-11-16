  import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lobby {
    private String nome;
    private Deck deck;
    private String modoJogo;
    private boolean disponibilidade2;
    private Carta[] mao;
    private int manaMaxima;
    private int pontosVida;
    private Carta[] cemiterio;
    private int cardCoins;
   
    

    public Lobby(String nome, Deck deck, String modoJogo) {
        this.nome = nome;
        this.deck = deck;
        this.modoJogo = modoJogo;
        this.disponibilidade2 = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   


    public void selecionarDeck() throws IrregularDeckException {
       if (deck.isDisponivel()) {
       
        disponibilidade2 = true;  
       } else {
            IrregularDeckException e2 = new IrregularDeckException();
            throw e2;
       } 
        
    }
    public void selecionarDecKValido() {
        try {
            selecionarDeck();
        } catch (IrregularDeckException e2) {
            e2.getMessage();
        }
    }
    /*public Usuario[] preencherPareamento() {
        for(int i )
    }*/

    public void selecionarModoJogo(String modo) {
        modoJogo = modo;
    }


    public boolean buscarAdversarioDupla(List<Lobby> lobbies) {
    
        if (modoJogo.equals("Modo Dupla")) {
            
            List<Lobby> lobbiesDisponiveis = new ArrayList<>();
            for (Lobby lobby : lobbies) {
                if (lobby != this && lobby.isDisponivel() && lobby.getModoJogo().equals("Modo Dupla")) {
                    lobbiesDisponiveis.add(lobby);
                }
            }
            if (lobbiesDisponiveis.size() >= 2) {
                
                Random random = new Random();
                int index1 = random.nextInt(lobbiesDisponiveis.size());
                int index2;
                int index3;
                do {
                    index2 = random.nextInt(lobbiesDisponiveis.size());
                    index3 = random.nextInt(lobbiesDisponiveis.size());
                } while (index2 == index1);

                iniciarPartidaEmDupla(this, lobbiesDisponiveis.get(index1), lobbiesDisponiveis.get(index2),lobbiesDisponiveis.get(index3));
                return true;
            }
        }
        return false; 
    }
    public boolean buscarAdversario(List<Lobby> lobbies) {
        if (modoJogo.equals("Modo Single Player")) {

        List<Lobby> lobbies2 = lobbies;
        for (Lobby lobby : lobbies2) {
            if (lobby != this && lobby.isDisponivel() && lobby.getModoJogo().equals("Modo Single Player")) {
                iniciarPartida(this,lobby);
                return true;
            }
        }
    }
    return false;

    }

    private void iniciarPartidaEmDupla(Lobby jogador1, Lobby jogador2, Lobby jogador3, Lobby jogador4) {

        ArenaDupla arenaDupla = new ArenaDupla(jogador1, jogador2, jogador3,jogador4);
        arenaDupla.iniciarPartidaEmDupla();
    }
    private void iniciarPartida(Lobby jogador1, Lobby jogador2) {
        Arena arena = new Arena(jogador1, jogador2);
        arena.iniciarPartida();
    }

    public boolean isDisponivel() {
        return disponibilidade2;
    }

    public String getModoJogo() {
        return modoJogo;
    }

    public Deck getDeck() {
        return deck;
    }

    public int getManaMaxima() {
        return manaMaxima;
    }

    public void setManaMaxima(int novaManaMaxima) {
        if (novaManaMaxima >= 0) {
            this.manaMaxima = novaManaMaxima;
            System.out.println("Mana máxima de " + this.getNome() + " ajustada para " + novaManaMaxima);
        } else {
            System.out.println("Valor de mana máxima inválido");
        }
    }


    public void adicionarCartaNaMao(Carta carta) {
        if (this.getTamanhoMao() < this.mao.length) {
            
            for (int i = 0; i < this.mao.length; i++) {
                if (this.mao[i] == null) {
                    this.mao[i] = carta;
                    System.out.println("Carta " + carta.getNome() + " adicionada à mão de " + this.getNome());
                    break; 
                }
            }
        } else {
            System.out.println("A mão de " + this.getNome() + " está cheia.");
        }
    }

    public int getTamanhoMao() {
        return mao.length;
    }

    public Carta getCartaNaMao(int posicaoMao) {
        if (posicaoMao >= 0 && posicaoMao < this.mao.length) {
            return this.mao[posicaoMao];
        } else {
            System.out.println("Posição inválida na mão de " + this.getNome());
            return null;
        }
    }

    public void removerCartaDaMao(int posicaoMao) {
        
        if (posicaoMao >= 0 && posicaoMao < this.mao.length) {
            Carta cartaRemovida = this.mao[posicaoMao];
    
            this.mao[posicaoMao] = null;

            System.out.println("Carta " + cartaRemovida.getNome() + " removida da mão de " + this.getNome());
        } else {
            System.out.println("Posição inválida na mão de " + this.getNome());
        }
    }
    public void diminuirPontosVida(int dano) {
        if (dano >= 0) {
            this.pontosVida -= dano;
            System.out.println("Jogador " + this.getNome() + " sofreu " + dano + " pontos de dano. Pontos de vida restantes: " + this.pontosVida);
        } else {
            System.out.println("Valor de dano inválido");
        }
    }

    public void adicionarCartaAoCemiterio(Carta carta) {
        
        int posicaoCemiterio = encontrarPosicaoVazia(this.cemiterio);

        
        if (posicaoCemiterio != -1) {
            this.cemiterio[posicaoCemiterio] = carta;
            System.out.println("Carta " + carta.getNome() + " foi adicionada ao cemitério de " + this.getNome());
        } else {
            System.out.println("O cemitério de " + this.getNome() + " está cheio.");
        }
    }
    private int encontrarPosicaoVazia(Carta[] cemiterio) {
        for (int i = 0; i < cemiterio.length; i++) {
            if (cemiterio[i] == null) {
                return i;
            }
        }
        return -1; 
    }


    public void adicionarCardCoins(int quantidadeCardCoins) {
        
        if (quantidadeCardCoins >= 0) {
            this.cardCoins += quantidadeCardCoins;
            System.out.println("Jogador " + this.getNome() + " recebeu " + quantidadeCardCoins + " Card Coins. Total de Card Coins agora: " + this.cardCoins);
        } else {
            System.out.println("Quantidade de Card Coins inválida");
        }
    }

   

  
}
