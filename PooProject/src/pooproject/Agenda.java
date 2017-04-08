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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *  #TODO
 *  Consertar método de busca em HashMap. Está errado.
 */


public class Agenda implements Interface{
    private Paciente paciente;
    private Medico medico;
    private Consulta consulta;
    private ArrayList<Medico> medicos;
    private HashMap<String,Paciente> pacientes; // Instanciar no construtor!
    private HashMap<String,Consulta> consultas;
    private JFrame quadro;
    
    public Agenda(){
        paciente = new Paciente();
        medico = new Medico();
        consulta = new Consulta();
        medicos = new ArrayList<Medico>();
        pacientes = new HashMap<String,Paciente>(2, 1);
        consultas = new HashMap<String,Consulta>(2, 1); // A chave é o nome do paciente
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
    
    public boolean listarMedicoPorNome(String nome){
        int i;
        boolean flagAux = false;
        
        for (i = 0; i < medicos.size(); i++){
            if(nome.equals(medicos.get(i).getNome())){
                medicos.get(i).imprime();
                flagAux = true;
                return true;
            }

        }
        
        if(flagAux!=true){
            JOptionPane.showMessageDialog(quadro,"\nMédico não encontrado.\n","Sistema de Clínicas!", JOptionPane.INFORMATION_MESSAGE);
        }
        return false;
    }
    

    
    public void removerMedicoPorNome(String nome){
        int i;
        boolean flagAux = false;
        for (i = 0; i < medicos.size(); i++){
            if(nome.equals(medicos.get(i).getNome())){
                medicos.remove(i);
                JOptionPane.showMessageDialog(quadro,"\nMédico removido com sucesso.\n","Sistema de Clínicas!", JOptionPane.INFORMATION_MESSAGE);
                flagAux = true;
            }

        }
        
        if(flagAux!=true){
            JOptionPane.showMessageDialog(quadro,"\nMédico não encontrado.\n","Sistema de Clínicas!", JOptionPane.INFORMATION_MESSAGE); 
        }
    }
    
   
    public void addPaciente(String cpf, Paciente paciente){
            pacientes.put(cpf, paciente);      
    }
    
    public void removerPacientePorCpf(String cpf){ // Falta revisar código. 
        boolean flagAux = false;
        
        try{
            if(cpf.equals(pacientes.get(cpf).getCpf())){
                pacientes.remove(cpf);
                JOptionPane.showMessageDialog(quadro,"\nPaciente removido com sucesso.\n","Sistema de Clínicas!", JOptionPane.INFORMATION_MESSAGE);
 
                flagAux = true;
            }
        }catch(Exception e){
            if(flagAux != true){
                JOptionPane.showMessageDialog(quadro,"\nPaciente não está cadastrado ou seu cpf está errado.\n","Sistema de Clínicas!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
        
                            
    }
    
    public boolean listarPacientePorCpf(String cpf){
        boolean flagAux = false;
       
        try{
            if(cpf.equals(pacientes.get(cpf).getCpf())){  
                pacientes.get(cpf).imprime();
                flagAux = true;
                return flagAux;
            }
            
            if(!cpf.equals(pacientes.get(cpf).getCpf()))                              
                JOptionPane.showMessageDialog(quadro,"\nPaciente nao encontrado.\n","Alerta!", JOptionPane.INFORMATION_MESSAGE);
 
        }catch(NullPointerException e){
            if(flagAux!=true){
                JOptionPane.showMessageDialog(quadro,"\nPaciente nao encontrado.\n","Alerta!", JOptionPane.INFORMATION_MESSAGE);
           }
        }
        
        if(cpf.equals("") && flagAux!= true){
            JOptionPane.showMessageDialog(quadro,"\nPaciente nao encontrado.\n","Alerta!", JOptionPane.INFORMATION_MESSAGE);
     }
        return false;
    }
    
    public void listarTodosPacientes(){
        for (Map.Entry<String,Paciente> entrada : pacientes.entrySet()) {
                entrada.getValue().imprime();
        }
    }
    
    
    public void addConsulta(String nome, Consulta consulta){
            consultas.put(nome, consulta);      
    }
    
    public void removerConsultaPorPaciente(String nome){ // Falta revisar código. 
        boolean flagAux = false;
        
        try{
            if(nome.equals(consultas.get(nome).getNomePaciente())){
                consultas.remove(nome);
                System.out.println("\nConsulta removida com sucesso!\n");
                flagAux = true;
            }
        }catch(NullPointerException e){
            if(flagAux != true){
                System.out.println("\nConsulta nao esta cadastrada ou o nome do paciente esta errado.\n");
            }
        }
        
        
                            
    }
    
    public boolean listarConsultaPorPaciente(String nome){
        boolean flagAux = false;
       
        try{
            for (Map.Entry<String,Consulta> entrada : consultas.entrySet()) {
                if(nome.equals(consultas.get(nome).getNomePaciente())){
                    System.out.println("\nConsulta encontrada!\n");
                    entrada.getValue().imprime();
                    flagAux = true;
                    return true;
                }
            }
            if(!nome.equals(consultas.get(nome).getNomePaciente()))
                System.out.println("\nConsulta nao encontrada.\n");
        }catch(NullPointerException e){
            if(flagAux!=true){
                System.out.println("\nConsulta nao encontrada.\n");
            }
        }
        
        if(nome.equals("") && flagAux!= true){
            System.out.println("\nConsulta nao encontrada.\n");
        }
        return false;
    }
    
    public void listarTodasConsultas(){
        for (Map.Entry<String,Consulta> entrada : consultas.entrySet()) {
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
            System.out.println("3 - Listar consulta marcada para um dado paciente");
            System.out.println("4 - Listar todas as consultas marcadas por paciente");
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
        
        do{
            try{
                aux = ler.nextLine();
                if(aux.equals("")){
                    System.out.println("Opcao inexistente. Tente novamente:");
                }else{
                    intAux = Integer.parseInt(aux);
                    if((intAux < 1) || (intAux > 5) ){
                        System.out.println("Opcao inexistente. Tente novamente:");
                        flag = true;
                    }else{
                        flag = false;
                    }
                    
                }
                
            }catch(NumberFormatException e){
                System.out.println("\nOpcao não existente. Tente novamente em 3 segundos. \n");
                flag = true;
                delay(3);
            }
        }while(aux.equals("") || flag == true);
        return intAux;
    }
    
    
}
    

