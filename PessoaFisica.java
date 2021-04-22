public class PessoaFisica extends Cliente{
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public PessoaFisica(String nome, String cpf) {
        super(cpf, nome);
    }

    @Override
    public String toString() {
        return "cpf: " + cpf + "\n Nome: " + getNome();
    }
}
