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
        
        if(medicos.isEmpty())
            JOptionPane.showMessageDialog(quadro,"\nNão há médicos cadastrados.\n","Alerta!", JOptionPane.INFORMATION_MESSAGE);
        
        while(medicoIterator.hasNext()){
            medicoIterator.next().imprime();
        }
        
    }
    
    public String salvarTodosMedicos(){
        Iterator<Medico> medicoIterator = medicos.iterator();;
        String medicos = "";
        
        while(medicoIterator.hasNext()){
            medicos +=  medicoIterator.next().toString();
        }
        
        
        if(medicos == null)
            return "\r\n\r\n";
        return medicos;
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
    
   
    public void addPacientes(String cpf, Paciente paciente){
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
            
            if(!cpf.equals(pacientes.get(cpf).getCpf())){                              
                JOptionPane.showMessageDialog(quadro,"\nPaciente não encontrado.\n","Alerta!", JOptionPane.INFORMATION_MESSAGE);
                return flagAux;
            }
        }catch(NullPointerException e){
            if(flagAux!=true){
                JOptionPane.showMessageDialog(quadro,"\nPaciente não encontrado.\n","Alerta!", JOptionPane.INFORMATION_MESSAGE);
           }
        }
        
        return false;
    }
    
    public void listarTodosPacientes(){
        if(pacientes.isEmpty())
            JOptionPane.showMessageDialog(quadro,"\nNão há pacientes cadastrados.\n","Alerta!", JOptionPane.INFORMATION_MESSAGE);
        
        for (Map.Entry<String,Paciente> entrada : pacientes.entrySet()) {
                entrada.getValue().imprime();
        }
    }
    
    public String salvarTodosPacientes(){
        String stringPacientes = "";
        
        for (Map.Entry<String,Paciente> entrada : pacientes.entrySet()) {
                stringPacientes += entrada.getValue().toString();
        }

        if(stringPacientes == null)
            return "\r\n\r\n";
        return stringPacientes;
    }
    
    public String getNomeHashPacientes(String cpf){
        return pacientes.get(cpf).getNome();
    }
    
    
    public void addConsulta(String cpf, Consulta consulta){
            consultas.put(cpf, consulta);      
    }
    
    public void removerConsultaPorPaciente(String cpf){ // Falta revisar código. 
        boolean flagAux = false;
        
        try{
            if(cpf.equals(consultas.get(cpf).getCpfPaciente())){
                consultas.remove(cpf);
                JOptionPane.showMessageDialog(quadro,"\nConsulta removida com sucesso!\n","Alerta!", JOptionPane.INFORMATION_MESSAGE);
                flagAux = true;
            }
        }catch(NullPointerException e){
            if(flagAux != true){
                JOptionPane.showMessageDialog(quadro,"\nConsulta não está cadastrada ou o nome do paciente está errado.\n","Alerta!", JOptionPane.INFORMATION_MESSAGE);
            }
        }
        
    }
    
    public boolean listarConsultaPorPaciente(String cpf){
        boolean flagAux = false;
       
        try{
            for (Map.Entry<String,Consulta> entrada : consultas.entrySet()) {
                if(cpf.equals(consultas.get(cpf).getCpfPaciente())){
                    JOptionPane.showMessageDialog(quadro,"\nConsulta encontrada!\n","Alerta!", JOptionPane.INFORMATION_MESSAGE);
                    entrada.getValue().imprime();
                    flagAux = true;
                    return flagAux;
                }
            }
            if(!cpf.equals(consultas.get(cpf).getCpfPaciente())){
                JOptionPane.showMessageDialog(quadro,"\nConsulta não encontrada.\n","Alerta!", JOptionPane.INFORMATION_MESSAGE);
                return flagAux;
            }        
        }catch(NullPointerException e){
            if(flagAux!=true){
                JOptionPane.showMessageDialog(quadro,"\nConsulta não encontrada.\n","Alerta!", JOptionPane.INFORMATION_MESSAGE);
                return flagAux;
            }
        }
        
        if(cpf.equals("") && flagAux!= true){
            JOptionPane.showMessageDialog(quadro,"\nConsulta não encontrada.\n","Alerta!", JOptionPane.INFORMATION_MESSAGE);
                
        }
        return false;
    }
    
    public void listarTodasConsultas(){
        if(consultas.isEmpty())
            JOptionPane.showMessageDialog(quadro,"\nNão há consultas marcadas.\n","Alerta!", JOptionPane.INFORMATION_MESSAGE);
        
        for (Map.Entry<String,Consulta> entrada : consultas.entrySet()) {
                entrada.getValue().imprime();
        }
    }
    
    public String salvarTodasConsultas(){
        String stringConsultas = "";
        for (Map.Entry<String,Consulta> entrada : consultas.entrySet()) {
                stringConsultas += entrada.getValue().toString();
        }
        
        
        if(stringConsultas == null)
            return "\r\n\r\n";
        return stringConsultas;
    }
    
    public void delay(int parametro){ 
        try {       
            Thread.sleep((1000*parametro));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
    

