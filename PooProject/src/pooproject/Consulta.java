/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pooproject;

/**
 *
 * @author Thiago
 */
public class Consulta {
    private String nomeMedico;
    private String nomePaciente;
    private int horario;
    
    public Consulta(){
        
    }
    
    public Consulta(String nomeMedico, String nomePaciente, int horario){
        this.nomeMedico = nomeMedico;
        this.nomePaciente = nomePaciente;
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
    
    public int getHorario(){
        return horario;
    }
    
    public void setHorario(int horario){
        this.horario = horario;
    }
    
    public void imprime(){
        System.out.println("\n Dados da consulta \n ");    
        System.out.println("Nome do paciente: " + getNomePaciente());
        System.out.println("Nome do medico: " + getNomeMedico());
        System.out.println("Horario da consulta: " + getHorario() + "h\n");
        
    }
}
