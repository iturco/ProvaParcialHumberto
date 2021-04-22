public class PessoaJuridica extends Cliente{
    private String cnpj;
    
    public PessoaJuridica(String cnpj, String nome) {
        super(cnpj, nome);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String toString() {
        return "cnpj: " + cnpj + " Nome: " + getNome();
    }
}
