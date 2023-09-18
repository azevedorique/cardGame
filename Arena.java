 
public class Arena {

    private Lobby jogador1;
    private Lobby jogador2;
    private Carta[][] campoJogador1;
    private Carta[][] campoJogador2;
    private int pontosVidaJogador1;
    private int pontosVidaJogador2;

    public Arena(Lobby jogador1, Lobby jogador2) {
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.campoJogador1 = new Carta[2][5];
        this.campoJogador2 = new Carta[2][5];
        this.pontosVidaJogador1 = 20;
        this.pontosVidaJogador2 = 20;
    }
    public Lobby getJogador1() {
        return jogador1;
    }
    public void setJogador1(Lobby jogador1) {
        this.jogador1 = jogador1;
    }
    public Lobby getJogador2() {
        return jogador2;
    }
    public void setJogador2(Lobby jogador2) {
        this.jogador2 = jogador2;
    }
    public Carta[][] getCampoJogador1() {
        return campoJogador1;
    }
    public void setCampoJogador1(Carta[][] campoJogador1) {
        this.campoJogador1 = campoJogador1;
    }
    public Carta[][] getCampoJogador2() {
        return campoJogador2;
    }
    public void setCampoJogador2(Carta[][] campoJogador2) {
        this.campoJogador2 = campoJogador2;
    }
    public int getPontosVidaJogador1() {
        return pontosVidaJogador1;
    }
    public void setPontosVidaJogador1(int pontosVidaJogador1) {
        this.pontosVidaJogador1 = pontosVidaJogador1;
    }
    public int getPontosVidaJogador2() {
        return pontosVidaJogador2;
    }
    public void setPontosVidaJogador2(int pontosVidaJogador2) {
        this.pontosVidaJogador2 = pontosVidaJogador2;
    }


    public void iniciarPartida() {
        // Lógica para iniciar a partida.
        System.out.println("A partida começou!");

        while (pontosVidaJogador1 > 0 && pontosVidaJogador2 > 0) {
            // Lógica da rodada
            // Aqui você pode implementar a lógica do jogo, como jogar cartas, calcular dano, etc.
            // Atualize os campos e pontos de vida dos jogadores conforme a jogada.

            // Exemplo de rodada:
            // jogador1.jogarCarta();
            // jogador2.jogarCarta();
            // Calcula o resultado da rodada, atualiza campos e pontos de vida.

            // Simulação: diminuir pontos de vida dos jogadores a cada rodada.
            pontosVidaJogador1--;
            pontosVidaJogador2--;

            // Exemplo de impressão do estado da partida.
            imprimirEstadoPartida();
        }

        // Fim da partida, determinar o vencedor.
        if (pontosVidaJogador1 <= 0) {
            System.out.println("Jogador 2 venceu!");
        } else {
            System.out.println("Jogador 1 venceu!");
        }
    }

    private void imprimirEstadoPartida() {
        // Lógica para imprimir o estado atual da partida, campos, pontos de vida, etc.
        // Você pode implementar essa lógica de acordo com as suas necessidades.
    }
}

