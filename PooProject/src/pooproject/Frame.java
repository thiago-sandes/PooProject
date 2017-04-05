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
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author thiago_sandes
 */
public class Frame implements ActionListener {
    private JFrame quadro;
    
    public Frame(){
        makeMainFrame();
    }
    
    

    @Override
    public void actionPerformed(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   

    class AbrirActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            abrirArquivo(); // executa a ação de abrir }
        }    
    }
    
    class SalvarActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            salvarArquivo(); 
        }
    }

    class SairActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            sair(); 
        }
    }
    
    class PacienteFrameActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            makePacienteFrame(); 
        }
    }
    
    
    class MedicoActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            makeMedicoFrame(); 
        }
    }
    
    
    class ConsultaActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            makeConsultaFrame(); 
        }
    }
    
    private void makeMainFrame(){
        quadro = new JFrame("Sistema de clínicas"); // Crio quadro
        Container conteudo = quadro.getContentPane(); // Crio painel de conteúdo do quadro
        
        conteudo.setLayout(new BorderLayout());
        
        JButton button = new JButton("Sobre o aplicativo");    
        conteudo.add(button, BorderLayout.NORTH); // Adiciono rótulo ao quadro
        
        JButton button1 = new JButton("Paciente");
        conteudo.add(button1, BorderLayout.CENTER);
        button1.addActionListener(new PacienteFrameActionListener());
        
        JButton button2 = new JButton("Médico");
        conteudo.add(button2, BorderLayout.WEST);
        button2.addActionListener(new MedicoActionListener());
        
        JButton button3 = new JButton("Consulta");
        conteudo.add(button3, BorderLayout.EAST);
        button3.addActionListener(new ConsultaActionListener());
        
        JButton button4 = new JButton("Sair");
        conteudo.add(button4, BorderLayout.SOUTH);
        button4.addActionListener(new SairActionListener());
        
        quadro.pack(); // Organizo os componentes de rótulo e de container dentro do quadro
        
        quadro.setVisible(true); // Torno o quadro visível
        
        JMenuBar barraDeMenu = new JMenuBar(); // Crio barra de menu
        
        quadro.setJMenuBar(barraDeMenu); // Coloco a barra de menu no quadro
        
        JMenu menuDeArquivo = new JMenu("Opções"); // Crio menu
        
        barraDeMenu.add(menuDeArquivo); // Adiciono o menu à barra de menu
        
        JMenuItem itemAbrir = new JMenuItem("Abrir arquivo"); // Crio um item do menu
        
        itemAbrir.addActionListener(new AbrirActionListener()); // Chamo o método para registrar o objeto itemAbrir como ouvinte
        
        menuDeArquivo.add(itemAbrir); // Adiciono um item de menu ao menu
        
        JMenuItem itemSalvar = new JMenuItem("Salvar arquivo"); // Crio um item do menu
        
        itemSalvar.addActionListener(new SalvarActionListener()); // Chamo o método para registrar o objeto itemSalvar como ouvinte
        
        menuDeArquivo.add(itemSalvar); // Adiciono um item de menu ao menu
        
        JMenuItem itemSair = new JMenuItem("Sair"); // Crio um item do menu
        
        itemSair.addActionListener(new SairActionListener()); // Chamo o método para registrar o objeto itemSair como ouvinte
        
        menuDeArquivo.add(itemSair); // Adiciono um item de menu ao menu
        
        
        
        
        
    }
    
    private void makePacienteFrame(){
        quadro = new JFrame("Sistema de clínicas"); // Crio quadro
        Container conteudo = quadro.getContentPane(); // Crio painel de conteúdo do quadro
        
        conteudo.setLayout(new BorderLayout());
        
        JButton button = new JButton("Ajuda");    
        conteudo.add(button, BorderLayout.NORTH); // Adiciono rótulo ao quadro
        
        JButton button1 = new JButton("Adicionar Paciente");
        conteudo.add(button1, BorderLayout.CENTER);
        
        JButton button2 = new JButton("Remover Paciente");
        conteudo.add(button2, BorderLayout.WEST);
       
        JButton button3 = new JButton("Listar paciente cadastrado");
        conteudo.add(button3, BorderLayout.EAST);
        
        JButton button4 = new JButton("Listar todos os pacientes cadastrados");
        conteudo.add(button4, BorderLayout.SOUTH);
        
        quadro.pack(); // Organizo os componentes de rótulo e de container dentro do quadro
        
        quadro.setVisible(true); // Torno o quadro visível
        
        
    }
    
    private void makeMedicoFrame(){
        quadro = new JFrame("Sistema de clínicas"); // Crio quadro
        Container conteudo = quadro.getContentPane(); // Crio painel de conteúdo do quadro
        
        conteudo.setLayout(new BorderLayout());
        
        JButton button = new JButton("Ajuda");    
        conteudo.add(button, BorderLayout.NORTH); // Adiciono rótulo ao quadro
        
        JButton button1 = new JButton("Adicionar médico");
        conteudo.add(button1, BorderLayout.CENTER);
        
        JButton button2 = new JButton("Remover médico");
        conteudo.add(button2, BorderLayout.WEST);
       
        JButton button3 = new JButton("Listar médico cadastrado");
        conteudo.add(button3, BorderLayout.EAST);
        
        JButton button4 = new JButton("Listar todos os médicos cadastrados");
        conteudo.add(button4, BorderLayout.SOUTH);
        
        quadro.pack(); // Organizo os componentes de rótulo e de container dentro do quadro
        
        quadro.setVisible(true); // Torno o quadro visível
        
        
    }
    
    private void makeConsultaFrame(){
        quadro = new JFrame("Ajuda"); // Crio quadro
        Container conteudo = quadro.getContentPane(); // Crio painel de conteúdo do quadro
        
        conteudo.setLayout(new BorderLayout());
        
        JButton button = new JButton("Ajuda");    
        conteudo.add(button, BorderLayout.NORTH); // Adiciono rótulo ao quadro
        
        JButton button1 = new JButton("Marcar consulta");
        conteudo.add(button1, BorderLayout.CENTER);
        
        JButton button2 = new JButton("Desmarcar consulta");
        conteudo.add(button2, BorderLayout.WEST);
       
        JButton button3 = new JButton("Listar consulta marcada");
        conteudo.add(button3, BorderLayout.EAST);
        
        JButton button4 = new JButton("Listar todas as consultas marcadas");
        conteudo.add(button4, BorderLayout.SOUTH);
        
        quadro.pack(); // Organizo os componentes de rótulo e de container dentro do quadro
        
        quadro.setVisible(true); // Torno o quadro visível
        
        
    }
    
    
    private void abrirArquivo(){
        //System.out.println("Vou abrir um arquivo");
        FileDialog fd = new FileDialog(quadro, "Escolha o arquivo", FileDialog.LOAD);
        fd.setDirectory("C:\\");
        //fd.setFile("*.xml");
        fd.setVisible(true);
        String filename = fd.getFile();
        if (filename == null)
            System.out.println("Você cancelou a escolha");
        else
            System.out.println("Você escolheu " + filename);
        
        /*JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(modalToComponent) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
        // load from file*/

        }
    
    private void salvarArquivo(){
        System.out.println("Vou salvar um arquivo");
        FileDialog fd = new FileDialog(quadro, "Escolha o arquivo", FileDialog.LOAD);
        fd.setDirectory("C:\\");
        //fd.setFile("*.xml");
        fd.setVisible(true);
        String filename = fd.getFile();
        if (filename == null)
            System.out.println("Você cancelou a escolha");
        else
            System.out.println("Você escolheu " + filename);
    }
    
    private void sair(){
        System.out.println("Vou sair");
        System.exit(0);
    }
    
}
