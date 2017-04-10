/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooproject;

import javax.swing.JOptionPane;

/**
 *
 * @author Thiago
 */
public class Consulta {
    private String nomeMedico;
    private String nomePaciente;
    private String cpfPaciente;
    private int horario;
    
    public Consulta(){
        
    }
    
    public Consulta(String nomeMedico, String cpfPaciente, String nomePaciente, int horario){
        this.nomeMedico = nomeMedico;
        this.nomePaciente = nomePaciente;
        this.cpfPaciente = cpfPaciente;
        this.horario = horario;
    }
    
    public String getNomeMedico(){
        return this.nomeMedico;
    }
    
    public void setNomeMedico(String nome){
        nomeMedico = nome;
    }
    
    public String getNomePaciente(){
        return this.nomePaciente;
    }
    
    public void setNomePaciente(String nome){
        nomePaciente = nome;
    }
    
    
    public String getCpfPaciente(){
        return this.cpfPaciente;
    }
    
    public void setCpfPaciente(String cpf){
        cpfPaciente = cpf;
    }
    
    public int getHorario(){
        return horario;
    }
    
    public void setHorario(int horario){
        this.horario = horario;
    }
    
    public void imprime(){
        JOptionPane.showMessageDialog(null,"\n Dados da consulta \n\n" + "Nome do paciente: " + getNomePaciente() + "\n" + "Cpf do paciente: " + getCpfPaciente() + "\n" + "Nome do medico: " + getNomeMedico() + "\n" + "Horario da consulta: " + getHorario() + "h\n\n" ,"Alerta!", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public String toString(){
        //[Linux]    return  getNomePaciente() + "\n" + getCpfPaciente() + "\n"  + getNomeMedico() + "\n" +  getHorario()+ "h" + "\n\n";
        return  getNomePaciente() + "\r\n" + getCpfPaciente() + "\r\n"  + getNomeMedico() + "\r\n" +  getHorario() + "\r\n\r\n";
        
        
    }
}
