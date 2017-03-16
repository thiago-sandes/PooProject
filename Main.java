/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooproject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author thiago_sandes
 */
public class Main  {
    public static void main(String args[]){
        int opcaoMenu, opcaoMenuPrincipal;
        String nome, aux;
        boolean flagVoltar = false;
        Agenda agenda = new Agenda();
        Scanner ler = new Scanner(System.in);
         
        agenda.menuPrincipal();
        
        System.out.println("\nInsira a opcao desejada:");
        opcaoMenuPrincipal = agenda.lerOpcao();

        while(opcaoMenuPrincipal > 4 || opcaoMenuPrincipal < 1){

                System.out.println("Opcao errada. Tente novamente");
                System.out.println("\nInsira a opcao desejada:");
                opcaoMenuPrincipal = agenda.lerOpcao();

        }

        opcaoMenu = opcaoMenuPrincipal;

        while(opcaoMenu > 0 && opcaoMenu < 6){

            if(flagVoltar == true){
                System.out.println("\nInsira a opcao desejada:");
                opcaoMenuPrincipal = agenda.lerOpcao();
            }

            switch(opcaoMenuPrincipal){
                case 1:
                    agenda.menuPaciente();
                    System.out.println("\nInsira a opcao desejada:");
                    opcaoMenu = agenda.lerOpcao();


                        switch(opcaoMenu){                
                            case 1:
                                Paciente paciente = new Paciente();
                                String cpf, telefone;

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

                    switch(opcaoMenu){                
                        case 1:
                            Medico medico = new Medico();
                            String especialidade, nomeMed;

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

                    switch(opcaoMenu){                
                        case 1:
                            System.out.println("Insira o nome do paciente cadastrado:");
                            nome = ler.nextLine();
                            agenda.listarPacientePorNome(nome);
                            System.out.println("Deseja marcar a consulta para qual médico(insira seu nome)?:");
                            nome = ler.nextLine();
                            agenda.listarMedicoPorNome(nome);
                            
                            // To be continue ...
                            agenda.voltarMenuPrincipal();
                            flagVoltar = true;

                            break;
                        case 2:


                            agenda.voltarMenuPrincipal();
                            flagVoltar = true;    

                            break;
                        case 3:



                            agenda.voltarMenuPrincipal();
                            flagVoltar = true;

                            break;
                        case 4:

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
