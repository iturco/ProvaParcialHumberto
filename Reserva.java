public class Reserva {
    private Cliente cliente;
    private boolean pagamentoAVista;
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isPagamentoAVista() {
        return pagamentoAVista;
    }

    public void setPagamentoAVista(boolean pagamentoAVista) {
        this.pagamentoAVista = pagamentoAVista;
    }

    public Reserva(Cliente cliente, boolean pagamentoAVista) {

    }
    public Reserva() {
    }

    //metodo toString()
    public String toString() {
        return "Nome: " + this.cliente + ", Pagamento a vista? " + this.pagamentoAVista;
    }
}
