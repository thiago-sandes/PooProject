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
import javax.swing.JOptionPane;

/**
 *
 * @author thiago_sandes
 */
public class MainFrame implements ActionListener {
    private JFrame quadro;
    Agenda agenda = new Agenda();
    
    public MainFrame(){
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
    
    class ShowAboutActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            showAbout(); 
        }
    }
    
    class HelpPacienteActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            helpPaciente(); 
        }
    }
    
    class AddPacienteActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            addPaciente(); 
        }
    }
    
    class RmvPacienteActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            rmvPaciente(); 
        }
    }
    
    class LstPacienteActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            lstPaciente(); 
        }
    }
      
    class LstAllPacientesActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            lstAllPacientes(); 
        }
    }
    
    class HelpMedicoActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            helpMedico(); 
        }
    }
    
    class AddMedicoActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            addMedico(); 
        }
    }
    
    class RmvMedicoActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            rmvMedico(); 
        }
    }
    
    class LstMedicoActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            lstMedico(); 
        }
    }
      
    class LstAllMedicosActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            lstAllMedicos(); 
        }
    }
    
    
    class HelpConsultaActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            helpConsulta(); 
        }
    }
    
    class AddConsultaActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            addConsulta(); 
        }
    }
    
    class RmvConsultaActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            rmvConsulta(); 
        }
    }
    
    class LstConsultaActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            lstConsulta(); 
        }
    }
      
    class LstAllConsultasActionListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            lstAllConsultas(); 
        }
    }
    
    private void makeMainFrame(){
        quadro = new JFrame("Sistema de clínicas"); // Crio quadro
        quadro.setSize(400, 400);
        quadro.setLocation(200,50);
        quadro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container conteudo = quadro.getContentPane(); // Crio painel de conteúdo do quadro
        conteudo.setLayout(new BorderLayout());
        
        JButton button = new JButton("Sobre o aplicativo");    
        conteudo.add(button, BorderLayout.NORTH); // Adiciono rótulo ao quadro
        button.addActionListener(new ShowAboutActionListener());
        
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
        
        quadro.setVisible(true); // Torno o quadro visível
        
    }
    
    private void makePacienteFrame(){
        quadro = new JFrame("Sistema de clínicas"); // Crio quadro
        quadro.setSize(500, 400);
        quadro.setLocation(100,50);
        quadro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Container conteudo = quadro.getContentPane(); // Crio painel de conteúdo do quadro
        conteudo.setLayout(new BorderLayout());
        
        JButton button = new JButton("Ajuda");    
        conteudo.add(button, BorderLayout.NORTH); // Adiciono rótulo ao quadro
        button.addActionListener(new HelpPacienteActionListener());
        
        
        JButton button1 = new JButton("Adicionar Paciente");
        conteudo.add(button1, BorderLayout.CENTER);
        button1.addActionListener(new AddPacienteActionListener());
        
        JButton button2 = new JButton("Remover Paciente");
        conteudo.add(button2, BorderLayout.WEST);
        button2.addActionListener(new RmvPacienteActionListener());
        
        JButton button3 = new JButton("Listar paciente cadastrado");
        conteudo.add(button3, BorderLayout.EAST);
        button3.addActionListener(new LstPacienteActionListener());
        
        JButton button4 = new JButton("Listar todos os pacientes cadastrados");
        conteudo.add(button4, BorderLayout.SOUTH);
        button4.addActionListener(new LstAllPacientesActionListener());
        
        quadro.setVisible(true); // Torno o quadro visível
        
    }
    
    private void makeMedicoFrame(){
        quadro = new JFrame("Sistema de clínicas"); // Crio quadro
        quadro.setSize(500, 400);
        quadro.setLocation(100,50);
        quadro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Container conteudo = quadro.getContentPane(); // Crio painel de conteúdo do quadro
        conteudo.setLayout(new BorderLayout());
        
        JButton button = new JButton("Ajuda");    
        conteudo.add(button, BorderLayout.NORTH); // Adiciono rótulo ao quadro
        button.addActionListener(new HelpMedicoActionListener());
        
        JButton button1 = new JButton("Adicionar médico");
        conteudo.add(button1, BorderLayout.CENTER);
        button1.addActionListener(new AddMedicoActionListener());
        
        JButton button2 = new JButton("Remover médico");
        conteudo.add(button2, BorderLayout.WEST);
        button2.addActionListener(new RmvMedicoActionListener());
        
        JButton button3 = new JButton("Listar médico cadastrado");
        conteudo.add(button3, BorderLayout.EAST);
        button3.addActionListener(new LstMedicoActionListener());
        
        JButton button4 = new JButton("Listar todos os médicos cadastrados");
        conteudo.add(button4, BorderLayout.SOUTH);
        button4.addActionListener(new LstAllMedicosActionListener());
        
        quadro.setVisible(true); // Torno o quadro visível
    }
    
    private void makeConsultaFrame(){
        quadro = new JFrame("Ajuda"); // Crio quadro
        quadro.setSize(500, 400);
        quadro.setLocation(100,50);
        quadro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        Container conteudo = quadro.getContentPane(); // Crio painel de conteúdo do quadro
        conteudo.setLayout(new BorderLayout());
        
        JButton button = new JButton("Ajuda");    
        conteudo.add(button, BorderLayout.NORTH); // Adiciono rótulo ao quadro
        button.addActionListener(new HelpConsultaActionListener());
        
        JButton button1 = new JButton("Marcar consulta");
        conteudo.add(button1, BorderLayout.CENTER);
        button1.addActionListener(new AddConsultaActionListener());
        
        JButton button2 = new JButton("Desmarcar consulta");
        conteudo.add(button2, BorderLayout.WEST);
        button2.addActionListener(new RmvConsultaActionListener());
        
        JButton button3 = new JButton("Listar consulta marcada");
        conteudo.add(button3, BorderLayout.EAST);
        button3.addActionListener(new LstConsultaActionListener());
        
        JButton button4 = new JButton("Listar todas as consultas marcadas");
        conteudo.add(button4, BorderLayout.SOUTH);
        button4.addActionListener(new LstAllConsultasActionListener());
        
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
    
    private void showAbout(){
        JOptionPane.showMessageDialog(quadro, "Sobre o aplicativo", "Sistema para clínicas", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void helpPaciente(){
        JOptionPane.showMessageDialog(quadro,  "A implementar...","Ajuda para o menu Paciente", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void addPaciente(){
        Paciente paciente = new Paciente();
        
        String nome = JOptionPane.showInputDialog("Insira o nome do paciente.");
        paciente.setNome(nome);
        
        String cpf = JOptionPane.showInputDialog("Insira o cpf do paciente.");
        paciente.setCpf(cpf);
        
        String telefone = JOptionPane.showInputDialog("Insira o telefone do paciente.");
        paciente.setTelefone(telefone);
        
        agenda.addPaciente(cpf, paciente);
                            
        JOptionPane.showMessageDialog(quadro, " Paciente adicionado com sucesso!" ,"Sistema de clínica!", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void rmvPaciente(){
        String cpf = JOptionPane.showInputDialog("Insira o cpf do paciente para removê-lo");
        agenda.removerPacientePorCpf(cpf);
    }
    
    private void lstPaciente(){
        String cpf = JOptionPane.showInputDialog("Insira o cpf do paciente.");
        agenda.listarPacientePorCpf(cpf);
    }   
    
    private void lstAllPacientes(){
        agenda.listarTodosPacientes();
    }
    
    private void helpMedico(){
        JOptionPane.showMessageDialog(quadro, "A implementar...", "Ajuda para o menu Médico",  JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void addMedico(){
        Medico medico = new Medico();
        
        String nome = JOptionPane.showInputDialog("Insira o nome do médico.");
        medico.setNome(nome);
        String especialidade = JOptionPane.showInputDialog("Insira a especialidade do médico.");
        medico.setEspecialidade(especialidade);
        agenda.addMedicos(medico);
        
        JOptionPane.showMessageDialog(quadro, " Médico adicionado com sucesso!" , "Sistema de clínica!", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void rmvMedico(){
        String nome = JOptionPane.showInputDialog("Insira o nome do médico para removê-lo.");
        
        agenda.removerMedicoPorNome(nome);

    }
    
    private void lstMedico(){
        String nome = JOptionPane.showInputDialog("Insira o nome do médico.");
        
        agenda.listarMedicoPorNome(nome);

        }
    
    private void lstAllMedicos(){
        agenda.listarTodosMedicos();
    }
    
    
    private void helpConsulta(){
        JOptionPane.showMessageDialog(quadro, "A implementar...", "Ajuda para o menu Consulta",  JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void addConsulta(){
        String auxHorario;
        boolean auxFlag;
        int horario;

        Consulta consulta = new Consulta();
        String cpfPaciente = JOptionPane.showInputDialog("Insira o cpf do paciente cadastrado: ");
    
        auxFlag = agenda.listarPacientePorCpf(cpfPaciente);
        if (auxFlag == true) {    
            consulta.setCpfPaciente(cpfPaciente);
            consulta.setNomePaciente(agenda.getNomeHashPacientes(cpfPaciente));
            
            String nomeMedico = JOptionPane.showInputDialog("Deseja marcar a consulta para qual médico(insira seu nome)?: ");
                        
            auxFlag = agenda.listarMedicoPorNome(nomeMedico);
            if(auxFlag == true){
                consulta.setNomeMedico(nomeMedico);
                auxHorario = JOptionPane.showInputDialog("Os horários de atendimentos são das 08h - 12h (1h cada consulta) e das 14h - 18h. Em qual horario deseja marcar a consulta?: ");
                horario = Integer.parseInt(auxHorario);
                
                try {
                    while ((horario > 11 && horario < 14) || (horario > 17 || horario < 8)) {
                        auxHorario = JOptionPane.showInputDialog("Horário inválido. Tente novamente com um horário disponível: ");
                        horario = Integer.parseInt(auxHorario);
        
                        auxFlag = true;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(quadro, "Caractere inválido. Tente novamente acessando o menu Consulta.", "Alerta!",  JOptionPane.INFORMATION_MESSAGE);

                    auxFlag = false;
                }
                
                if (auxFlag == true) {
                    consulta.setHorario(horario);

                    JOptionPane.showMessageDialog(quadro, "Consulta marcada com sucesso!", "Alerta!",  JOptionPane.INFORMATION_MESSAGE);

                    agenda.addConsulta(cpfPaciente, consulta);
                    
                } else {
                    JOptionPane.showMessageDialog(quadro, "Consulta não registrada!", "Alerta!",  JOptionPane.INFORMATION_MESSAGE);
                }

            }else{
               JOptionPane.showMessageDialog(quadro, "Busque o nome correto do medico no menu Medico e volte aqui.", "Alerta!",  JOptionPane.INFORMATION_MESSAGE);                
            }                            
        } else {
            JOptionPane.showMessageDialog(quadro, "Busque o cpf correto do paciente no menu Paciente e volte aqui.", "Alerta!",  JOptionPane.INFORMATION_MESSAGE);                
        }
    }
    
    private void rmvConsulta(){
        String cpf = JOptionPane.showInputDialog("Insira o cpf do paciente.");
        agenda.removerConsultaPorPaciente(cpf);
    }
    
    private void lstConsulta(){
        String cpf = JOptionPane.showInputDialog("Insira o cpf do paciente.");
        agenda.listarConsultaPorPaciente(cpf);
        
    }
    
    private void lstAllConsultas(){
        agenda.listarTodasConsultas();
    }
    
    private void sair(){
        System.out.println("Vou sair");
        System.exit(0);
    }
    
}
