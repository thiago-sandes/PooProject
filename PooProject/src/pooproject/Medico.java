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
public class Medico extends Agente {
    private String especialidade;

    public Medico(String nomeMedico, String especialidade) {
        super(nomeMedico);
        this.especialidade = especialidade;
    }

    public Medico() {
        
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    public void imprime(){
        System.out.println("\n Dados do medico \n ");    
        System.out.println("Nome do medico: " + getNome());
        System.out.println("Especialidade: " + getEspecialidade() + "\n");
        
    }
    

    
    
     
}
