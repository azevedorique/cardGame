import java.util.Random;

public class ArenaDupla extends Arena {
    private Lobby jogador3;
    private Lobby jogador4;
    private int pontosVidaJogador3;
    private int pontosVidaJogador4;
 

    public ArenaDupla(Lobby jogador1, Lobby jogador2, Lobby jogador3, Lobby jogador4) {
        super(jogador1, jogador2);
        this.jogador3 = jogador3;
        this.jogador4 = jogador4;
    }

     
    @Override
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
            System.out.println("Não há cartas suficientes no deck para fazer um saque para o jogador " + jogador.getNome() + ".");
        }
    }




    
    public void iniciarPartidaEmDupla() {
        System.out.println("A partida em dupla começou!");
    
 
    
        while (super.getPontosVidaJogador1() > 0 && super.getPontosVidaJogador2() > 0 &&
               getPontosVidaJogador3() > 0 && getPontosVidaJogador4() > 0) {
    
        
            super.sacar(super.jogador1, super.jogador1.getDeck());
            super.sacar(super.jogador2, super.jogador2.getDeck());
    
           
            super.turno(super.jogador1, super.jogador2);
    
             
            super.sacar(jogador3, jogador3.getDeck());
            super.sacar(jogador4, jogador4.getDeck());
    
           
            super.turno(jogador3, jogador4);
    
            
       
        }
    }
 

    public int getPontosVidaJogador3() {
        return pontosVidaJogador3;
    }

    public int getPontosVidaJogador4() {
        return pontosVidaJogador4;
    }
    public void turno(Lobby jogadorAtivo, Lobby aliado, Lobby oponente1, Lobby oponente2) {
        System.out.println("Turno do Jogador " + jogadorAtivo.getNome() + ".");
    
        comprar(jogadorAtivo);
        posicionamento(jogadorAtivo);
        ataque(jogadorAtivo,aliado, oponente1, oponente2);
    
        
        System.out.println("Turno do Aliado " + aliado.getNome() + ".");
        comprar(aliado);
        posicionamento(aliado);
        ataque(aliado,jogadorAtivo, oponente1, oponente2);
    
    
        
        System.out.println("Turno do Oponente " + oponente1.getNome() + ".");
        comprar(oponente1);
        posicionamento(oponente1);
        ataque(oponente1,oponente2, jogadorAtivo, aliado);
    
        
    
    
        System.out.println("Turno do Oponente " + oponente2.getNome() + ".");
        comprar(oponente2);
        posicionamento(oponente2);
        ataque(oponente2,oponente1, jogadorAtivo, aliado);
    
        
    }
    @Override
    public void comprar(Lobby jogador) {
    if (jogador.getDeck().getQuantidadeCartas() > 1) {
         
        Carta cartaSacada = (jogador.getDeck()).sacarCartaAleatoria();
        jogador.setManaMaxima(jogador.getManaMaxima() + 1);
        jogador.adicionarCartaNaMao(cartaSacada);
        System.out.println("Jogador " + jogador.getNome() + " sacou uma carta: " + cartaSacada.getNome());
 
        Lobby aliado = (jogador == jogador1 || jogador == jogador2) ? jogador3 : jogador1;
        cartaSacada = (aliado.getDeck()).sacarCartaAleatoria();
        aliado.setManaMaxima(aliado.getManaMaxima() + 1);
        aliado.adicionarCartaNaMao(cartaSacada);
        System.out.println("Aliado " + aliado.getNome() + " sacou uma carta: " + cartaSacada.getNome());
    }
    
}
@Override
public void posicionamento(Lobby jogador) {
    if (jogador.getManaMaxima() > 0) {
        System.out.println("Posicionamento para o Jogador " + jogador.getNome());

        int posicaoMao = new Random().nextInt(jogador.getTamanhoMao());
        Carta cartaSelecionada = jogador.getCartaNaMao(posicaoMao);

        if (cartaSelecionada != null) {
            if (jogador == jogador1 || jogador == jogador2) {
                campoJogador1[1][posicaoMao] = cartaSelecionada;
            } else {
                campoJogador2[1][posicaoMao] = cartaSelecionada;
            }

            jogador.setManaMaxima(jogador.getManaMaxima() - 1);
            jogador.removerCartaDaMao(posicaoMao);

            System.out.println("Jogador " + jogador.getNome() + " posicionou uma carta no campo: " + cartaSelecionada.getNome());
        }

        
        Lobby aliado = (jogador == jogador1 || jogador == jogador2) ? jogador3 : jogador1;
        posicaoMao = new Random().nextInt(aliado.getTamanhoMao());
        cartaSelecionada = aliado.getCartaNaMao(posicaoMao);

        if (cartaSelecionada != null) {
            campoJogador2[1][posicaoMao] = cartaSelecionada; 
            aliado.setManaMaxima(aliado.getManaMaxima() - 1);
            aliado.removerCartaDaMao(posicaoMao);

            System.out.println("Aliado " + aliado.getNome() + " posicionou uma carta no campo: " + cartaSelecionada.getNome());
        }
    }
}


public void ataque(Lobby jogadorAtivo, Lobby aliado, Lobby oponente1, Lobby oponente2) {
    System.out.println("Fase de Ataque para o Jogador " + jogadorAtivo.getNome());

 
    realizarAtaques(jogadorAtivo, oponente1, oponente2);
    realizarAtaques(aliado, oponente1, oponente2);
 
    System.out.println("Fase de Ataque dos Oponentes");

    realizarAtaques(oponente1, jogadorAtivo, aliado);
    realizarAtaques(oponente2, jogadorAtivo, aliado);
}

private void realizarAtaques(Lobby atacante, Lobby oponente1, Lobby oponente2) {
    Carta[][] campoAtacante = (atacante == jogador1 || atacante == jogador2) ? campoJogador1 : campoJogador2;
    Carta[][] campoOponente = (atacante == jogador1 || atacante == jogador2) ? campoJogador2 : campoJogador1;

    for (int i = 0; i < campoAtacante.length; i++) {
        for (int j = 0; j < campoAtacante[i].length; j++) {
            Carta cartaAtiva = campoAtacante[i][j];

            if (cartaAtiva != null) {
               
                int posicaoAlvo = new Random().nextInt(campoOponente[i].length);
                Carta cartaAlvo = campoOponente[i][posicaoAlvo];

              
                if (cartaAlvo != null) {
                 
                    int dano = cartaAtiva.getAtaque() - cartaAlvo.getDefesa();
 
                    if (atacante == jogador1 || atacante == jogador2) {
                        oponente1.diminuirPontosVida(dano);
                        oponente2.diminuirPontosVida(dano);
                    } else {
                        jogador1.diminuirPontosVida(dano);
                        jogador2.diminuirPontosVida(dano);
                    }

                  
                    if (cartaAlvo.getPontosVida() <= 0) {
                        if (atacante == jogador1 || atacante == jogador2) {
                            oponente1.adicionarCartaAoCemiterio(cartaAlvo);
                            oponente2.adicionarCartaAoCemiterio(cartaAlvo);
                            campoOponente[i][posicaoAlvo] = null;
                        } else {
                            jogador1.adicionarCartaAoCemiterio(cartaAlvo);
                            jogador2.adicionarCartaAoCemiterio(cartaAlvo);
                            campoOponente[i][posicaoAlvo] = null;
                        }
                    }

                    System.out.println(atacante.getNome() + " atacou com " +
                            cartaAtiva.getNome() + " causando " + dano + " de dano aos oponentes.");
                }
            }
        }
    }
}


    
 
    


 
    

 }
