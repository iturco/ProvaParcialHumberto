public abstract class Cliente {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente(String cpf, String nome) {

    }

    @Override
    public String toString() {
        return "Cliente: " + nome;
    }
}