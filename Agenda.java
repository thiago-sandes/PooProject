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
    
    public void listarMedicoPorNome(String nome){
        int i;
        boolean flagAux = false;
        
        for (i = 0; i < medicos.size(); i++){
            if(nome.equals(medicos.get(i).getNome())){
                System.out.println("\nMedico encontrado!\n");
                medicos.get(i).imprime();
                flagAux = true;
            }

        }
        
        if(flagAux!=true){
            System.out.println("\n Medico nao encontrado. \n ");  
        }
 
    }
    

    
    public void removerMedicoPorNome(String nome){
        int i;
        boolean flagAux = false;
        for (i = 0; i < medicos.size(); i++){
            if(nome.equals(medicos.get(i).getNome())){
                medicos.remove(i);
                System.out.println("\n Medico removido com sucesso! \n ");  
                flagAux = true;
            }

        }
        
        if(flagAux!=true){
            System.out.println("\n Medico nao encontrado. \n ");  
        }
    }
    
   
    public void addPaciente(String nome, Paciente paciente){
            pacientes.put(nome, paciente);      
    }
    
    public void removerPacientePorNome(String nome){ // Falta revisar código. 
        boolean flagAux = false;
        
        try{
            if(nome.equals(pacientes.get(nome).getNome())){
                pacientes.remove(nome);
                System.out.println("\nPaciente removido com sucesso!\n");
                flagAux = true;
            }
        }catch(NullPointerException e){
            if(flagAux != true){
                System.out.println("\nPaciente nao esta cadastrado ou seu nome esta errado.\n");
            }
        }
        
        
                            
    }
    
    public void listarPacientePorNome(String nome){
        boolean flagAux = false;
       
        try{
            for (Map.Entry<String,Paciente> entrada : pacientes.entrySet()) {
                if(nome.equals(pacientes.get(nome).getNome())){
                    System.out.println("\nPaciente encontrado!\n");
                    entrada.getValue().imprime();
                    flagAux = true;
                }
            }
        }catch(NullPointerException e){
            if(flagAux!=true){
                System.out.println("\nPaciente nao encontrado.\n");
            }
        }
        
        if(nome.equals("") && flagAux!= true){
            System.out.println("\nPaciente nao encontrado.\n");
        }
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
    
    public void menuConsulta(){
            System.out.println("\nEste e o menu de consulta.\n");
            System.out.println("O que deseja fazer?");
            System.out.println("1 - Marcar consulta");
            System.out.println("2 - Desmarcar consulta");
            System.out.println("3 - Listar consultas marcadas para um dado médico");
            System.out.println("4 - Listar todas as consultas marcadas por médico");
            System.out.println("5 - Voltar ao menu anterior\n");
            
            

    }
    
    
    public void delay(int parametro){ 
        try {       
            Thread.sleep((1000*parametro));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
     
    public void voltarMenuPrincipal(){
        String aux;
        int option;
        Scanner ler = new Scanner(System.in);
        
        System.out.println("\nDeseja voltar ao menu principal?");
        System.out.println("(1 - Sim | 2 - Nao(Programa sera¡ fechado)\n");
        
        
        option = lerOpcao();
        
        if(option == 1){
            menuPrincipal();
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
    
    public int lerOpcao(){
        Scanner ler = new Scanner(System.in);
        String aux = "";
        int intAux = 0;
        boolean flag = false;
        
        while(aux.equals("") || flag == true){
            try{
                aux = ler.nextLine();
                if(aux.equals("")){
                    System.out.println("Opcao inexistente. Tente novamente:");
                }else{
                    intAux = Integer.parseInt(aux);
                    flag = false;
                }
                
            }catch(NumberFormatException e){
                System.out.println("\nOpcao não existente. Tente novamente em 3 segundos. \n");
                flag = true;
                delay(3);
            }
        }
        return intAux;
    }
}
    

