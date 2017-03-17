/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooproject;
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
        System.out.println("\n Dados do paciente \n ");    
        System.out.println("Nome do paciente: " + getNome());
        System.out.println("Cpf: " + cpf);
        System.out.println("Telefone: " + telefone + "\n");
        
    }
    
}
