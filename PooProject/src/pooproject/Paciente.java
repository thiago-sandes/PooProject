/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooproject;

import javax.swing.JOptionPane;

/**
 *
 * @author André Biriba
 */
public class Paciente extends Agente {
    private String cpf;
    private String telefone; 
    
    public Paciente(String parNome, String parCpf, String parTelefone){
        super(parNome);
        cpf = parCpf;
        telefone = parTelefone;
    }

    public Paciente() {
         
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    
     public void imprime(){
        JOptionPane.showMessageDialog(null, "\n[Dados do paciente] \n\n" + "Nome do paciente: " + getNome()+ "\nCpf: " + cpf + "\nTelefone: " + telefone + "\n" ,"Sistema de clínica!", JOptionPane.INFORMATION_MESSAGE);        
    }
    
}
