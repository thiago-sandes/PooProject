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
        JOptionPane.showMessageDialog(null, "[Dados do medico] \n\n" + "Nome do medico: " + getNome() + "\nEspecialidade: " + getEspecialidade() + "\n" , "Sistema de clínicas!", JOptionPane.INFORMATION_MESSAGE);   
    }
    

    
    
     
}
