/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooproject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author André Biriba
 */
public class Agenda implements Interface{
    private Paciente paciente;
    private Medico medico;
    private ArrayList<Medico> medicos = new ArrayList<Medico>();
    private HashMap<String,Paciente> pacientes; // Instanciar no construtor!
    
    public Agenda(){
        paciente = new Paciente();
        medico = new Medico();
        medicos = new ArrayList<Medico>();
        pacientes = new HashMap<String,Paciente>(2, 1);
    }
    
    public void addMedicos(Medico medico){
        medicos.add(medico);
    }
    
    public void removeMedicos(Medico medico){
        medicos.remove(medico);
    }
    
    public void listarTodosMedicos(){
        Iterator<Medico> medicoIterator = medicos.iterator();;
       
        while(medicoIterator.hasNext()){
            medicoIterator.next().imprime();
        }
        
    }
    
    public void listarMedico(String nome){
        Iterator<Medico> medicoIterator =  medicos.iterator();
 
        while(medicoIterator.hasNext()){
            if(nome.equals(medicoIterator.next().getNome())){
                System.out.println("\nMedico encontrado!\n");
                medicoIterator.next().imprime();
                
            }
        }
        
        System.out.println("\nMedico nao encontrado.\n");
       
    }
    

    
    public void removerMedicoPorNome(String nome){
        int i;
        for (i = 0; i < medicos.size(); i++){
            if(nome.equals(medicos.get(i).getNome())){
                medicos.remove(i);
                System.out.println("\n Medico removido com sucesso! \n ");  

            }

        }

        System.out.println("\n Medico nao encontrado. \n ");  
    }
    
   
    public void addPaciente(String nome, Paciente paciente){
            pacientes.put(nome, paciente);      
    }
    
    public void removerPacientePorNome(String nome){ // Falta revisar código. 
        int i;
        
        if(nome.equals(pacientes.get(nome).getNome())){
            pacientes.remove(nome);
                System.out.println("\nPaciente removido com sucesso!\n");
           
        }else{
            System.out.println("\nPaciente nao esta cadastrado ou seu nome esta errado.\n");
        }
        
        
                            
    }
    
    public void listarPaciente(String nome){
        
        for (Map.Entry<String,Paciente> entrada : pacientes.entrySet()) {
            if(nome.equals(pacientes.get(nome))){
                System.out.println("\nPaciente encontrado!\n:");
                entrada.getValue().imprime();
               
            }
        }
        System.out.println("\nPaciente nao encontrado.\n");
       
    }
    
    public void listarTodosPacientes(){
        for (Map.Entry<String,Paciente> entrada : pacientes.entrySet()) {
                entrada.getValue().imprime();
        }
    }
    
    
    public void menuPrincipal(){
        System.out.println("\n Bem vindo ao Hospital Vida Nova!\n");
        System.out.println("Abaixo segue as opcoes de servicos disponiveis:");
        System.out.println("1 - Paciente");
        System.out.println("2 - Medico");
        System.out.println("3 - Consulta");
        System.out.println("4 - Sair\n"); 
        
        
    }
    
    public void menuPaciente(){  
            System.out.println("\nEste e o menu do Paciente.\n");
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Cadastro de paciente");
            System.out.println("2 - Remocao de paciente");
            System.out.println("3 - Listar paciente cadastrado");
            System.out.println("4 - Listar todos os pacientes cadastrados");
            System.out.println("5 - Voltar ao menu anterior\n");

    }
    
    public void menuMedico(){
            System.out.println("\nEste e o menu do Medico.\n");
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Cadastro de medico");
            System.out.println("2 - Remocao de medico");
            System.out.println("3 - Listar medico cadastrado");
            System.out.println("4 - Listar todos os medicos cadastrados");
            System.out.println("5 - Voltar ao menu anterior\n");
            
            

    }
    
    private Scanner ler;
    private Agenda agenda;
    
    public void delay(int parametro){ 
        try {       
            Thread.sleep((1000*parametro));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    public void voltarMenuPrincipal(){
        agenda = new Agenda();
        String aux;
        int option;
        System.out.println("\nDeseja voltar ao menu principal?");
        System.out.println("(1 - Sim | 2 - Nao(Programa sera¡ fechado)\n");
        ler = new Scanner(System.in);
        
        aux = ler.nextLine();
        option = Integer.parseInt(aux);
        
        if(option == 1){
            agenda.menuPrincipal();
        }else{
            if(option == 2){
                System.out.println("Como quiser. Bye!");
                delay(1);
                System.exit(0);
            }else{
                System.out.println("Opcao invalida! Tente novamente. \n");
                voltarMenuPrincipal();
            }
        }
        
    }
}
    

