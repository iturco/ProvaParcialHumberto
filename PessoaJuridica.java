public class PessoaJuridica extends Cliente {
    private String cnpj;

    public PessoaJuridica(String cnpj, String nome) {
        super(nome);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public boolean equals(Object obj) {
        String auxCnpj;
        if (obj instanceof Cliente) {
            auxCnpj = ((PessoaJuridica) obj).cnpj;
            if(cnpj.equals(auxCnpj)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Pessoa juridica --> cnpj: " + cnpj + "\n Nome: " + getNome();
    }
}
