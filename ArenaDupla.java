public class ArenaDupla extends Arena {
    private Lobby jogador3;
    private Lobby jogador4;

    public ArenaDupla(Lobby jogador1, Lobby jogador2, Lobby jogador3, Lobby jogador4) {
        super(jogador1, jogador2);
        this.jogador3 = jogador3;
        this.jogador4 = jogador4;
    }

    public ArenaDupla(Lobby jogador1, Lobby jogador2, Lobby jogador3) {
    }

    @Override
    public void sacar(Lobby jogador,Deck deck) {
        if (jogador.getDeck().getQuantidadeCartas() >= 7) {
            Carta cartaSacada = ((Object) jogador.getDeck()).sacarCartaAleatoria();
            String cartaNoDeck;
             for (int i = 0; i < 7; i++) {
                deck.removerCarta(cartaNoDeck);
                jogador.adicionarCartaNaMao(cartaSacada);
             }
             int cartasParaRetornar = Math.min(5,jogador.getTamanhoMao());
             for (int i = 0; i < cartasParaRetornar; i++) {
                jogador.removerCartaDaMao(i);
                deck.adicionarCarta(cartaNoDeck);
             }
             for (int i = 0; i < cartasParaRetornar; i++) {
                deck.removerCarta(cartaNoDeck);
                jogador.adicionarCartaNaMao(cartaSacada);
             }
         

            
        } else {
            System.out.println("Não há cartas suficientes no deck para fazer um saque.");
    }
    }




    @Override
    public void iniciarPartida() {
        System.out.println("A partida em dupla começou!");

        while (super.getPontosVidaJogador1() > 0 && super.getPontosVidaJogador2() > 0) {
            // Lógica da rodada em dupla
            // Implemente a lógica do jogo aqui, levando em conta os quatro jogadores.
            // Atualize os campos e pontos de vida dos jogadores conforme as jogadas.

            // Exemplo de rodada:
            // jogador1.jogarCarta();
            // jogador2.jogarCarta();
            // jogador3.jogarCarta();
            // jogador4.jogarCarta();
            // Calcula o resultado da rodada, atualiza campos e pontos de vida.

            // Simulação: diminuir pontos de vida dos jogadores a cada rodada.
            super.pontosVidaJogador1--;
            super.pontosVidaJogador2--;
            super.jogador3.diminuirPontosVida();
            super.jogador4.diminuirPontosVida();

            // Exemplo de impressão do estado da partida.
            imprimirEstadoPartida();
        }

        // Fim da partida, determinar o vencedor em dupla.
        if (super.pontosVidaJogador1 <= 0 && super.pontosVidaJogador2 <= 0) {
            System.out.println("A partida em dupla terminou em empate!");
        } else if (super.pontosVidaJogador1 <= 0) {
            System.out.println("Jogadores 2 e 4 venceram!");
        } else {
            System.out.println("Jogadores 1 e 3 venceram!");
        }
    }

    private void imprimirEstadoPartida() {
    }
}
