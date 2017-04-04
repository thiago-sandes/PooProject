/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooproject;

import java.util.Scanner;

/**
 * #TODO Line 174. Fazer outra função para tratar a leitura dos horários de
 * consulta.
 *
 * @author thiago_sandes
 */
public class Main {

    public static void main(String args[]) {
        int opcaoMenu, opcaoMenuPrincipal;
        String nome, aux;
        boolean flagVoltar = false;
        Agenda agenda = new Agenda();
        Scanner ler = new Scanner(System.in);
        
        //Interface Gráfica;
        Frame frame = new Frame();
        
        agenda.menuPrincipal();

        System.out.println("\nInsira a opcao desejada:");
        opcaoMenuPrincipal = agenda.lerOpcao();

        while (opcaoMenuPrincipal > 4 || opcaoMenuPrincipal < 1) {

            System.out.println("Opcao errada. Tente novamente");
            System.out.println("\nInsira a opcao desejada:");
            opcaoMenuPrincipal = agenda.lerOpcao();

        }

        opcaoMenu = opcaoMenuPrincipal;

        while (opcaoMenu > 0 && opcaoMenu < 6) {

            if (flagVoltar == true) {
                System.out.println("\nInsira a opcao desejada:");
                opcaoMenuPrincipal = agenda.lerOpcao();
            }

            switch (opcaoMenuPrincipal) {
                case 1:
                    agenda.menuPaciente();
                    System.out.println("\nInsira a opcao desejada:");
                    opcaoMenu = agenda.lerOpcao();

                    switch (opcaoMenu) {
                        case 1:
                            Paciente paciente = new Paciente();
                            String cpf,
                             telefone;

                            System.out.println("Para adicionar um paciente, insira seu nome: ");
                            nome = ler.nextLine();
                            paciente.setNome(nome);
                            System.out.println("Agora, insira seu cpf: ");
                            cpf = ler.nextLine();
                            paciente.setCpf(cpf);
                            System.out.println("Por fim, insira seu numero de telefone ou celular: ");
                            telefone = ler.nextLine();
                            paciente.setTelefone(telefone);
                            agenda.addPaciente(nome, paciente);
                            System.out.println("\nPaciente e seus respectivos dados adicionados com sucesso!\n");

                            agenda.voltarMenuPrincipal();
                            flagVoltar = true;
                            break;
                        case 2:
                            System.out.println("Para remover um paciente, insira seu nome: ");
                            nome = ler.nextLine();
                            agenda.removerPacientePorNome(nome);
                            agenda.voltarMenuPrincipal();
                            flagVoltar = true;
                            break;
                        case 3:

                            System.out.println("Insira o nome do paciente:");
                            nome = ler.nextLine();
                            agenda.listarPacientePorNome(nome);
                            agenda.voltarMenuPrincipal();
                            flagVoltar = true;
                            break;
                        case 4:
                            agenda.listarTodosPacientes();
                            agenda.voltarMenuPrincipal();
                            flagVoltar = true;
                            break;
                        case 5:
                            agenda.menuPrincipal();
                            flagVoltar = true;
                            break;
                    }
                    break;
                case 2:
                    agenda.menuMedico();
                    System.out.println("\nInsira a opcao desejada:");
                    opcaoMenu = agenda.lerOpcao();

                    switch (opcaoMenu) {
                        case 1:
                            Medico medico = new Medico();
                            String especialidade,
                             nomeMed;

                            System.out.println("Para adicionar um medico, insira seu nome: ");
                            nomeMed = ler.nextLine();
                            medico.setNome(nomeMed);

                            System.out.println("Agora, insira sua especialidade: ");
                            especialidade = ler.nextLine();
                            medico.setEspecialidade(especialidade);

                            agenda.addMedicos(medico);

                            System.out.println("\nMedico e sua respectiva especialidade adicionados.\n");
                            agenda.voltarMenuPrincipal();
                            flagVoltar = true;
                            break;
                        case 2:
                            int i;

                            System.out.println("Para remover um medico, insira seu nome: ");
                            nome = ler.nextLine();
                            agenda.removerMedicoPorNome(nome);

                            agenda.voltarMenuPrincipal();
                            flagVoltar = true;
                            break;
                        case 3:
                            System.out.println("Insira o nome do medico:");
                            nome = ler.nextLine();
                            agenda.listarMedicoPorNome(nome);

                            agenda.voltarMenuPrincipal();
                            flagVoltar = true;
                            break;
                        case 4:
                            agenda.listarTodosMedicos();
                            agenda.voltarMenuPrincipal();
                            flagVoltar = true;
                            break;
                        case 5:
                            agenda.menuPrincipal();
                            flagVoltar = true;
                            break;
                    }
                    break;
                case 3:
                    agenda.menuConsulta();
                    System.out.println("\nInsira a opcao desejada:");
                    opcaoMenu = agenda.lerOpcao();
                    int horario = 0; // Os horários de atendimentos são das 08h - 12h (1h cada consulta) e das 14h - 18h.
                    String nomePaciente,
                     nomeMedico,
                     auxHorario;
                    boolean auxFlag;

                    switch (opcaoMenu) {
                        case 1: // Criar hashMap de Consultas...
                            Consulta consulta = new Consulta();
                            System.out.println("Insira o nome do paciente cadastrado:");
                            nomePaciente = ler.nextLine();
                            auxFlag = agenda.listarPacientePorNome(nomePaciente);
                            if (auxFlag == true) {
                                consulta.setNomePaciente(nomePaciente);
                                System.out.println("Deseja marcar a consulta para qual médico(insira seu nome)?:");
                                nomeMedico = ler.nextLine();
                                auxFlag = agenda.listarMedicoPorNome(nomeMedico);
                                if (auxFlag == true) {
                                    consulta.setNomeMedico(nomeMedico);
                                    System.out.println("Os horários de atendimentos são das 08h - 12h (1h cada consulta) e das 14h - 18h. Em qual horario deseja marcar a consulta?:");

                                    try {
                                        auxHorario = ler.nextLine();
                                        horario = Integer.parseInt(auxHorario);

                                        while ((horario > 11 && horario < 14) || (horario > 17 || horario < 8)) {
                                            System.out.println("Horário inválido. Tente novamente com um horario disponivel: ");
                                            auxHorario = ler.nextLine();
                                            horario = Integer.parseInt(auxHorario);
                                            auxFlag = true;
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Caractere invalido. Tente novamente acessando o menu Consulta.");
                                        auxFlag = false;
                                    }
                                    if (auxFlag == true) {
                                        consulta.setHorario(horario);

                                        System.out.println("\nMarcando a consulta . . . \n");
                                        agenda.addConsulta(nomePaciente, consulta);
                                        agenda.delay(3);

                                        System.out.println("\nConsulta registrada com sucesso!\n");
                                    } else {
                                        System.out.println("\nConsulta não registrada!\n");
                                        agenda.delay(3);
                                    }
                                } else {
                                    System.out.println("Busque o nome correto do medico no menu Medico e volte aqui.");

                                }
                            } else {
                                System.out.println("Busque o nome correto do paciente no menu Paciente e volte aqui.");

                            }

                            agenda.voltarMenuPrincipal();
                            flagVoltar = true;

                            break;
                        case 2:
                            System.out.println("Para remover uma consulta, insira o nome do paciente: ");
                            nome = ler.nextLine();
                            agenda.removerConsultaPorPaciente(nome);

                            agenda.voltarMenuPrincipal();
                            flagVoltar = true;

                            break;
                        case 3:
                            System.out.println("Insira o nome do paciente para listar suas consultas:");
                            nome = ler.nextLine();
                            agenda.listarConsultaPorPaciente(nome);

                            agenda.voltarMenuPrincipal();
                            flagVoltar = true;

                            break;
                        case 4:
                            agenda.listarTodasConsultas();

                            agenda.voltarMenuPrincipal();
                            flagVoltar = true;

                            break;
                        case 5:
                            agenda.menuPrincipal();
                            flagVoltar = true;

                            break;
                    }

                    break;
                case 4:
                    System.out.println("Bye!");
                    agenda.delay(2);
                    System.exit(0);
                    break;

            }
        }

    }
}
