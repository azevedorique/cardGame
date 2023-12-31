public class Usuario {

    private static Usuario instance;

    private String user;
    private String cpf;
    private int senha;
    private int idade;
    private String sexo;
    private String email;
    private int nivel = 1;
    private Inventario inventario;
    private int[] decks = new int[5];
    private int saldo = 0;

    private Usuario(String user, String cpf, int senha, int idade, String sexo, String email, Inventario inventario) {
        this.user = user;
        this.cpf = cpf;
        this.senha = senha;
        this.idade = idade;
        this.sexo = sexo;
        this.email = email;
        this.inventario = inventario;
    }

    public static Usuario getInstance(String user, String cpf, int senha, int idade, String sexo, String email, Inventario inventario) {
        if (instance == null) {
            instance = new Usuario(user, cpf, senha, idade, sexo, email, inventario);
        }
        return instance;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public int[] getDecks() {
        return decks;
    }

    public void setDecks(int[] decks) {
        this.decks = decks;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}