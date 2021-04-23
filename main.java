import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//int mesa = 0;
public class main {
    // int mesa = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Reserva> lista = new ArrayList<>();
        List<Reserva> espera = new ArrayList<>();

        int opcao;
        int mesa = 0;
        do {
            System.out.println("Escolha a opção a seguir");
            System.out.println("1. Reservar mesa");
            System.out.println("2. Pesquisar reserva");
            System.out.println("3. Imprimir lista de reserva");
            System.out.println("4. Imprimir lista de espera");
            System.out.println("5. Cancelar reserva");
            System.out.println("6. Finalizar");

            opcao = sc.nextInt();

            switch (opcao) {
            case 1:
                if (lista.size() < 6) {
                    mesa++;
                    lista.add(ReservarMesa(lista, mesa));

                } else {
                    System.out.println("Sua reserva será colocada na lista de espera");
                    mesa++;
                    espera.add(ReservarMesa(espera, mesa));

                }
                break;
            case 2:
                Pesquisar(lista);
                break;
            case 3:
                ImprimirReservas(lista);
                break;
            case 4:
                ImprimirEspera(espera);
                break;
            case 5:
                CancelarReserva(lista);
                break;
            // case 7:
            // System.out.println(lista);
            // break;
            }
        } while (opcao != 6);
        System.out.println("Finalizado");

    }

    // RESERVA DA MESA

    public static Reserva ReservarMesa(List<Reserva> lista, int mesa) {
        Scanner sc = new Scanner(System.in);
        Cliente cliente = null;
        // Reserva reserva = null;

        System.out.println("Cadastrar clientes da mesa:");
        System.out.println("1. Pessoa juridica");
        System.out.println("2. Pessoa fisica");
        int tipoPessoa = sc.nextInt();

        switch (tipoPessoa) {
        case 1:
            cliente = CadastrarJuridica();
            System.out.println(cliente);
            // Reserva reserva = new Reserva(cliente, true);

            System.out.println("mesa: " + mesa);
            break;

        case 2:
            cliente = CadastrarFisica();

            break;
        }
        Reserva reserva = new Reserva(cliente, true);
        System.out.println();
        System.out.println("reserva: " + reserva);
        return reserva;
    }

    // CADASTRO PESSOA JURIDICA
    public static Cliente CadastrarJuridica() {
        Scanner sc = new Scanner(System.in);

        // Cliente pJur = null;
        System.out.print("CNPJ: ");
        String cnpj = sc.next();
        System.out.print("Nome: ");
        String nome = sc.next();
        PessoaJuridica pJur = new PessoaJuridica(cnpj, nome);
        return pJur;
    }

    // CADASTRO PESSOA FISICA
    public static Cliente CadastrarFisica() {
        Scanner sc = new Scanner(System.in);

        // Cliente pFis = null;
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("CPF: ");
        String cpf = sc.nextLine();
        PessoaFisica pFis = new PessoaFisica(cpf, nome);
        return pFis;
    }

    // PESQUISAR
    public static void Pesquisar(List<Reserva> lista) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Pesquisar por CPF ou CNPJ?");
        String opcao2 = sc.nextLine().toLowerCase();

        switch (opcao2) {
        case "cpf":

            for (int i = 0; i < lista.size(); i++) {
                System.out.print("Qual CPF deseja pesquisar?");
                String cpf = sc.nextLine();

                if (lista.get(i) instanceof Reserva) {
                    System.out.print("Ja tem reserva");
                } else {
                    System.out.println("Ainda não tem reserva");
                }
            }

            break;

        case "cnpj":
            for (int i = 0; i < lista.size(); i++) {
                System.out.print("Qual CNPJ deseja pesquisar?");
                String cnpj = sc.next();

                if (lista.get(i) instanceof Reserva) {
                    System.out.println("Ja tem reserva");
                } else {
                    System.out.println("Ainda não tem reserva");
                }

                break;
            }

        }
    }

    // IMPRIMIR RESERVAS
    public static void ImprimirReservas(List<Reserva> lista) {
        // PessoaFisica pFis = null;
        System.out.println(lista);

        // for (int i = 0; i <= 6; i++) {
        // if (PessoaFisica instanceof Cliente) {
        // System.out.println("Cliente do tipo Pessoa Fisica");
        // System.out.println(PessoaFisica);
        // // System.out.println("Pagamento a vista?");
        // } else {
        // System.out.println("Cliente do tipo Pessoa Juridica");
        // System.out.println(PessoaJuridica);
        // // System.out.println("Pagamento a vista?");
        // }
        // }

    }

    // IMPRIMIR LISTA DE ESPERA
    public static void ImprimirEspera(List<Reserva> espera) {

        System.out.println(espera);

        // for (int i = 0; espera.size(); i++) {
        // if (PessoaFisica instanceof Cliente) {
        // System.out.println("Cliente do tipo Pessoa Fisica");
        // System.out.println(PessoaFisica);
        // // System.out.println("Pagamento a vista?");
        // } else {
        // System.out.println("Cliente do tipo Pessoa Juridica");
        // System.out.println(PessoaJuridica);
        // // System.out.println("Pagamento a vista?");
        // }
        // }
    }

    // CANCELAR RESERVA
    public static void CancelarReserva(List<Reserva> lista) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Cancelar por CPF ou CNPJ? ");
        String opcao3 = sc.nextLine().toLowerCase();

        if (opcao3 == "cpf") {
            System.out.print("Qual CPF deseja cancelar a reserva?");
            String cpfapagar = sc.nextLine();

            for (int i = 0; i < lista.size(); i++) {
                if (lista.get(i) instanceof Reserva) {
                    Reserva apagar = lista.get(i);
                    if (cpfapagar.equals(apagar)) {
                        lista.remove(apagar);
                    }
                } else {
                    System.out.println("cpf não encontrado");
                }
            }
        }

        // } if (opcao3 == "cnpj") {
        // System.out.print("Qual CNPJ deseja cancelar a reserva?");
        // String cnpjapagar = sc.nextLine();

        // if (lista.get(i) instanceof Cliente) {
        // Cliente apagar = lista.get(i);
        // if (cnpjapagar.equals(apagar)) {
        // lista.remove(apagar);
        // }
        // } else {
        // System.out.println("cnpj não encontrado");
        // }

    }
}
