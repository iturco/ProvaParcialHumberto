public class PessoaFisica extends Cliente {
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public PessoaFisica(String cpf, String nome) {
        super(nome);
        this.cpf = cpf;
    }

    // @Override
    // public boolean equals(Object obj) {
    //     String auxCpf;
    //     if (obj instanceof Cliente) {
    //         auxCpf = ((PessoaFisica) obj).cpf;
    //         if(cpf.equals(auxCpf)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    @Override
    public String toString() {
        return "Pessoa fisica --> cpf: " + cpf + "\n Nome: " + getNome();
    }
}
