import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.TreeUI;

public class main {

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
            {

            }
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
                mesa--;
                CancelarReserva(lista, espera);
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
        boolean avista = true;
        // Reserva reserva = null;

        System.out.println("Cadastrar clientes da mesa:");
        System.out.println("1. Pessoa juridica");
        System.out.println("2. Pessoa fisica");
        int tipoPessoa = sc.nextInt();

        switch (tipoPessoa) {
        case 1:

            cliente = CadastrarJuridica();

            // System.out.println(cliente);
            // Reserva reserva = new Reserva(cliente, true);
            // System.out.println("mesa: " + mesa);
            break;

        case 2:

            cliente = CadastrarFisica();
            break;
        }

        System.out.println("Formas de pagamentos: ");
        System.out.println("1. a vista");
        System.out.println("2. parcelado");
        int pagamento = sc.nextInt();
        switch (pagamento) {
        case 1:
            avista = true;
            break;

        case 2:
            avista = false;
            break;
        }
        // ADD FORMA DE PAGAMENTO NO TRUE
        Reserva reserva = new Reserva(cliente, avista);
        System.out.println();
        // System.out.println("reserva: " + reserva);
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

        System.out.println("Pesquisar por CPF ou CNPJ?");
        String opcao2 = sc.nextLine().toLowerCase();

        switch (opcao2) {
        case "cpf":

            for (int i = 0; i < lista.size(); i++) {
                System.out.print("Qual CPF deseja pesquisar?");
                String cpf = sc.nextLine();
                PessoaFisica nome = new PessoaFisica("", cpf);
                if (lista.get(i).getCliente().equals(nome)) {
                    System.out.print("Ja tem reserva");
                } else {
                    System.out.println("Ainda não tem reserva");
                }
            }
            break;

        case "cnpj":
            for (int i = 0; i < lista.size(); i++) {
                System.out.print("Qual CNPJ deseja pesquisar?");
                String cnpj = sc.nextLine();
                PessoaJuridica nome = new PessoaJuridica("", cnpj);
                if (lista.get(i).getCliente().equals(nome)) {
                    System.out.print("Ja tem reserva");
                } else {
                    System.out.println("Ainda não tem reserva");
                }
            }
            break;
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
    public static void CancelarReserva(List<Reserva> lista, List<Reserva> espera) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Cancelar por CPF ou CNPJ? ");
        String opcao3 = sc.nextLine().toLowerCase();

        // System.out.println("opcao 3 " + opcao3);

        // 1- PEGAR CPF ok--> 2- PROCURAR NA LISTA --> 3- APAGAR CPF DA LISTA
        // 4- PEGAR 1o DA ESPERA --> 5- COPIAR O CLIENTE --> 6- PASSAR PARA A LISTA

        switch (opcao3) {
        case "cpf":
            System.out.print("Qual CPF deseja cancelar a reserva?");
            String cpfapagar = sc.nextLine();

            //int resPesq = Pesquisar(lista);

            for (int i = 0; i < lista.size(); i++) {

                Reserva apagar = lista.get(i);

                Cliente cli = apagar.getCliente();
                PessoaFisica pFis = (PessoaFisica) cli;
                
                
               
               
                // if (cpfapagar.equals(pFis)) {
                //     System.out.println("achei");

                // }
                // if (pFis.getCpf().equals(cpfapagar)) {
                // // if (cpfapagar.equals(pFis.getCpf()))
                // lista.remove(pFis.getCpf());
                // System.out.println("APAGUEI");
                // }
                else {
                    System.out.println("nao achei");
                }
                // if (lista.get(i) instanceof Reserva) {
                // Reserva apagar = lista.get(i);
                // Cliente cli = apagar.getCliente();
                // PessoaFisica pFis = (PessoaFisica) cli;
                // lista.remove(lista.get(i));
                // Reserva primEspera = espera.get(0);
                // lista.add(primEspera);
                // espera.remove(espera.get(0));
                // System.out.println("reserva liberada");

                // }
            }
            break;

        case "cnpj":
            break;
        }
        // System.out.print("Qual CPF deseja cancelar a reserva?");
        // String cpfapagar = sc.nextLine();

        // for (int i = 0; i < lista.size(); i++) {
        // if (lista.get(i) instanceof Reserva) {
        // // Reserva apagar = lista.get(i);

        // // if (cpfapagar.equals(apagar)) {
        // lista.remove(lista.get(i));
        // System.out.println("apagado");
        // // }
        // } else {
        // System.out.println("cpf não encontrado");
        // }
        // }
        // }

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
