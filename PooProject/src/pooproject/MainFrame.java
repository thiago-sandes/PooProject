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
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author thiago_sandes
 */
public class MainFrame implements ActionListener {

    private JFrame quadro;
    Agenda agenda = new Agenda();

    public MainFrame() {
        makeMainFrame();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    class AbrirActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            try {
                abrirArquivo(); // executa a ação de abrir }
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class SalvarActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            try {
                salvarArquivo();
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    class SairActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            sair();
        }
    }

    class PacienteFrameActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            makePacienteFrame();
        }
    }

    class MedicoActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            makeMedicoFrame();
        }
    }

    class ConsultaActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            makeConsultaFrame();
        }
    }

    class ShowAboutActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            showAbout();
        }
    }

    class HelpPacienteActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            helpPaciente();
        }
    }

    class AddPacienteActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            addPaciente();
        }
    }

    class RmvPacienteActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            rmvPaciente();
        }
    }

    class LstPacienteActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            lstPaciente();
        }
    }

    class LstAllPacientesActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            lstAllPacientes();
        }
    }

    class HelpMedicoActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            helpMedico();
        }
    }

    class AddMedicoActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            addMedico();
        }
    }

    class RmvMedicoActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            rmvMedico();
        }
    }

    class LstMedicoActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            lstMedico();
        }
    }

    class LstAllMedicosActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            lstAllMedicos();
        }
    }

    class HelpConsultaActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            helpConsulta();
        }
    }

    class AddConsultaActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            addConsulta();
        }
    }

    class RmvConsultaActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            rmvConsulta();
        }
    }

    class LstConsultaActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            lstConsulta();
        }
    }

    class LstAllConsultasActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            lstAllConsultas();
        }
    }

    private void makeMainFrame() {
        quadro = new JFrame("Sistema de Clínicas"); // Crio quadro
        quadro.setSize(400, 400);
        quadro.setLocation(200, 50);
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

    private void makePacienteFrame() {
        quadro = new JFrame("Sistema de Clínicas"); // Crio quadro
        quadro.setSize(500, 400);
        quadro.setLocation(100, 50);
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

    private void makeMedicoFrame() {
        quadro = new JFrame("Sistema de Clínicas"); // Crio quadro
        quadro.setSize(500, 400);
        quadro.setLocation(100, 50);
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

    private void makeConsultaFrame() {
        quadro = new JFrame("Ajuda"); // Crio quadro
        quadro.setSize(500, 400);
        quadro.setLocation(100, 50);
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

    private void showAbout() {
        JOptionPane.showMessageDialog(quadro, "Aplicativo desenvolvido para conclusão de matéria universitária.", "Sistema para Clínicas", JOptionPane.INFORMATION_MESSAGE);
    }

    private void helpPaciente() {
        JOptionPane.showMessageDialog(quadro, "Este é o menu de Paciente. Para usá-lo, acesse uma das opções listadas.", "Ajuda para o menu Paciente", JOptionPane.INFORMATION_MESSAGE);
    }

    private void addPaciente() {
        Paciente paciente = new Paciente();

        String nome = JOptionPane.showInputDialog("Insira o nome do paciente.");
        if (nome == null) {
            return;
        }
        if (nome.equals("")) {
            JOptionPane.showMessageDialog(quadro, "Campo vazio não pode. Tente novamente.", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        paciente.setNome(nome);

        String cpf = JOptionPane.showInputDialog("Insira o cpf do paciente.");
        if (cpf == null) {
            return;
        }
        if (cpf.equals("")) {
            JOptionPane.showMessageDialog(quadro, "Campo vazio não pode. Tente novamente.", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        paciente.setCpf(cpf);

        String telefone = JOptionPane.showInputDialog("Insira o telefone do paciente.");
        if (telefone == null) {
            return;
        }
        if (telefone.equals("")) {
            JOptionPane.showMessageDialog(quadro, "Campo vazio não pode. Tente novamente.", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        paciente.setTelefone(telefone);

        agenda.addPacientes(cpf, paciente);

        JOptionPane.showMessageDialog(quadro, " Paciente adicionado com sucesso!", "Sistema de Clínicas!", JOptionPane.INFORMATION_MESSAGE);
    }

    private void rmvPaciente() {
        String cpf = JOptionPane.showInputDialog("Insira o cpf do paciente para removê-lo");
        if (cpf == null) {
            return;
        }
        if (cpf.equals("")) {
            JOptionPane.showMessageDialog(quadro, "Campo vazio não pode. Tente novamente.", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        agenda.removerPacientePorCpf(cpf);
    }

    private void lstPaciente() {
        String cpf = JOptionPane.showInputDialog("Insira o cpf do paciente.");
        if (cpf == null) {
            return;
        }
        if (cpf.equals("")) {
            JOptionPane.showMessageDialog(quadro, "Campo vazio não pode. Tente novamente.", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        agenda.listarPacientePorCpf(cpf);
    }

    private void lstAllPacientes() {
        agenda.listarTodosPacientes();
    }

    private void helpMedico() {
        JOptionPane.showMessageDialog(quadro, "Este é o menu Médico. Para usá-lo, escolha uma das opções listadas.", "Ajuda para o menu Médico", JOptionPane.INFORMATION_MESSAGE);
    }

    private void addMedico() {
        Medico medico = new Medico();

        String nome = JOptionPane.showInputDialog("Insira o nome do médico.");
        if (nome == null) {
            return;
        }
        if (nome.equals("")) {
            JOptionPane.showMessageDialog(quadro, "Campo vazio não pode. Tente novamente.", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        medico.setNome(nome);

        String especialidade = JOptionPane.showInputDialog("Insira a especialidade do médico.");
        if (especialidade == null) {
            return;
        }
        if (especialidade.equals("")) {
            JOptionPane.showMessageDialog(quadro, "Campo vazio não pode. Tente novamente.", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        medico.setEspecialidade(especialidade);

        agenda.addMedicos(medico);

        JOptionPane.showMessageDialog(quadro, " Médico adicionado com sucesso!", "Sistema de Clínicas!", JOptionPane.INFORMATION_MESSAGE);
    }

    private void rmvMedico() {
        String nome = JOptionPane.showInputDialog("Insira o nome do médico para removê-lo.");
        if (nome == null) {
            return;
        }
        if (nome.equals("")) {
            JOptionPane.showMessageDialog(quadro, "Campo vazio não pode. Tente novamente.", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        agenda.removerMedicoPorNome(nome);

    }

    private void lstMedico() {
        String nome = JOptionPane.showInputDialog("Insira o nome do médico.");
        if (nome == null) {
            return;
        }
        if (nome.equals("")) {
            JOptionPane.showMessageDialog(quadro, "Campo vazio não pode. Tente novamente.", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        agenda.listarMedicoPorNome(nome);

    }

    private void lstAllMedicos() {
        agenda.listarTodosMedicos();
    }

    private void helpConsulta() {
        JOptionPane.showMessageDialog(quadro, "Este é o menu Consulta. Para usá-lo, acesse uma das opções listadas.", "Ajuda para o menu Consulta", JOptionPane.INFORMATION_MESSAGE);
    }

    private void addConsulta() {
        String auxHorario;
        boolean auxFlag;
        int horario;

        Consulta consulta = new Consulta();
        String cpfPaciente = JOptionPane.showInputDialog("Insira o cpf do paciente cadastrado: ");
        if (cpfPaciente == null) {
            return;
        }
        if (cpfPaciente.equals("")) {
            JOptionPane.showMessageDialog(quadro, "Campo vazio não pode. Tente novamente.", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        auxFlag = agenda.listarPacientePorCpf(cpfPaciente);
        if (auxFlag == true) {
            consulta.setCpfPaciente(cpfPaciente);
            consulta.setNomePaciente(agenda.getNomeHashPacientes(cpfPaciente));

            String nomeMedico = JOptionPane.showInputDialog("Deseja marcar a consulta para qual médico(insira seu nome)?: ");
            if (nomeMedico == null) {
                return;
            }

            if (nomeMedico.equals("")) {
                JOptionPane.showMessageDialog(quadro, "Campo vazio não pode. Tente novamente.", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            auxFlag = agenda.listarMedicoPorNome(nomeMedico);
            if (auxFlag == true) {
                consulta.setNomeMedico(nomeMedico);
                auxHorario = JOptionPane.showInputDialog("Os horários de atendimentos são das 08h - 12h (1h cada consulta) e das 14h - 18h. Em qual horario deseja marcar a consulta?: ");
                if (auxHorario == null) {
                    return;
                }

                if (auxHorario.equals("")) {
                    JOptionPane.showMessageDialog(quadro, "Campo vazio não pode. Tente novamente.", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                horario = Integer.parseInt(auxHorario);

                try {
                    while ((horario > 11 && horario < 14) || (horario > 17 || horario < 8)) {
                        auxHorario = JOptionPane.showInputDialog("Horário inválido. Tente novamente com um horário disponível: ");
                        if (auxHorario == null) {
                            return;
                        }

                        if (auxHorario.equals("")) {
                            JOptionPane.showMessageDialog(quadro, "Campo vazio não pode. Tente novamente.", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        horario = Integer.parseInt(auxHorario);

                        auxFlag = true;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(quadro, "Caractere inválido. Tente novamente acessando o menu Consulta.", "Alerta!", JOptionPane.INFORMATION_MESSAGE);

                    auxFlag = false;
                }

                if (auxFlag == true) {
                    consulta.setHorario(horario);

                    JOptionPane.showMessageDialog(quadro, "Consulta marcada com sucesso!", "Alerta!", JOptionPane.INFORMATION_MESSAGE);

                    agenda.addConsulta(cpfPaciente, consulta);

                } else {
                    JOptionPane.showMessageDialog(quadro, "Consulta não registrada!", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(quadro, "Busque o nome correto do medico no menu Medico e volte aqui.", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(quadro, "Busque o cpf correto do paciente no menu Paciente e volte aqui.", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void rmvConsulta() {
        String cpf = JOptionPane.showInputDialog("Insira o cpf do paciente.");
        if (cpf == null) {
            return;
        }
        if (cpf.equals("")) {
            JOptionPane.showMessageDialog(quadro, "Campo vazio não pode. Tente novamente.", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        agenda.removerConsultaPorPaciente(cpf);
    }

    private void lstConsulta() {
        String cpf = JOptionPane.showInputDialog("Insira o cpf do paciente.");
        if (cpf == null) {
            return;
        }
        if (cpf.equals("")) {
            JOptionPane.showMessageDialog(quadro, "Campo vazio não pode. Tente novamente.", "Alerta!", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        agenda.listarConsultaPorPaciente(cpf);

    }

    private void lstAllConsultas() {
        agenda.listarTodasConsultas();
    }

    private void abrirArquivo() throws IOException {
        JOptionPane.showMessageDialog(quadro, "Para evitar problemas quando for abrir o arquivo de dados, abra-o na pasta \"data\" dentro da pasta do programa.\nDeve ser um arquivo .txt gerado pelo próprio programa.\nCaso contrário, as informações não farão sentido.", "Alerta!", JOptionPane.WARNING_MESSAGE);

        String line_str;
        try {
            int auxHr;
            String auxCpf = "";

            javax.swing.JFileChooser arquivo = new javax.swing.JFileChooser();
            arquivo.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
            arquivo.setFileFilter(new FileNameExtensionFilter("Text Files (.txt)", "txt"));
            arquivo.setAcceptAllFileFilterUsed(false);

            if (arquivo.showOpenDialog(arquivo) == javax.swing.JFileChooser.APPROVE_OPTION) {
                File file = arquivo.getSelectedFile();
                java.io.FileInputStream varArq = new java.io.FileInputStream("" + file.getPath());

                java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(file.getPath()));

                String line = reader.readLine();

                while (line != null) {

                    do {
                        Paciente paciente = new Paciente();
                        line = reader.readLine();
                        if (line.equals("")) {
                            line = reader.readLine();
                            if (line.equals("Médicos")) {
                                break;
                            }
                            paciente.setNome(line);

                            line = reader.readLine();
                            paciente.setCpf(line);
                            auxCpf = line;

                            line = reader.readLine();
                            paciente.setTelefone(line);

                        }
                        agenda.addPacientes(auxCpf, paciente);

                    } while (!line.contains("Médicos"));

                    if (line.contains("Médicos")) {
                        line = reader.readLine();

                        do {
                            Medico medico = new Medico();
                            line = reader.readLine();

                            if (line.length() > 0 && !line.equals("Consultas")) {

                                medico.setNome(line);

                                line = reader.readLine();
                                medico.setEspecialidade(line);

                                line = reader.readLine();

                            }
                            if (!line.equals("Consultas")) {
                                agenda.addMedicos(medico);
                            }

                        } while (!line.contains("Consultas"));
                    }

                    if (line.contains("Consultas")) {
                        line = reader.readLine();

                        do {
                            Consulta consulta = new Consulta();
                            line = reader.readLine();

                            if (line.length() > 0) {

                                consulta.setNomePaciente(line);

                                line = reader.readLine();
                                consulta.setCpfPaciente(line);
                                auxCpf = line;
                                line = reader.readLine();
                                consulta.setNomeMedico(line);

                                line = reader.readLine();
                                auxHr = Integer.parseInt(line);
                                consulta.setHorario(auxHr);

                                line = reader.readLine();

                            }
                            agenda.addConsulta(auxCpf, consulta);

                        } while (line != null);

                    }

                }
                reader.close();
            }

        } catch (java.io.IOException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "File error:" + e.toString());
        }

    }

    private void salvarArquivo() throws IOException {
        JOptionPane.showMessageDialog(quadro, "Para evitar problemas quando for abrir o arquivo de dados, salve-o na pasta \"data\" dentro da pasta do programa.", "Alerta!", JOptionPane.INFORMATION_MESSAGE);

        JFileChooser arquivo = new javax.swing.JFileChooser();
        arquivo.setFileSelectionMode(javax.swing.JFileChooser.FILES_ONLY);
        arquivo.setFileFilter(new FileNameExtensionFilter("Text Files (.txt)", "txt"));
        arquivo.setAcceptAllFileFilterUsed(false);

        int resultadoArq = arquivo.showSaveDialog(null);
        if (resultadoArq == javax.swing.JFileChooser.CANCEL_OPTION) {
            return;
        }

        File arquivoNome = arquivo.getSelectedFile();

        if (!arquivoNome.getAbsolutePath().endsWith(".txt")) {
            arquivoNome = new File(arquivoNome.getAbsolutePath() + ".txt");
        }

        if (arquivoNome == null || arquivoNome.getName().equals("")) {
            javax.swing.JOptionPane.showMessageDialog(null, "Nome de Arquivo Inválido", "Alerta!", javax.swing.JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                if (arquivoNome.exists()) {
                    int response = JOptionPane.showConfirmDialog(quadro,
                            "Substituir o arquivo existente?", "Confirmar substituição",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.QUESTION_MESSAGE);

                    if (response == JOptionPane.CANCEL_OPTION) {
                        salvarArquivo();
                        return;
                    }
                    if (response == JOptionPane.CLOSED_OPTION) {
                        return;
                    }
                }

                FileWriter writer = new FileWriter(arquivoNome);
                if ((agenda.salvarTodosMedicos() != null && !(agenda.salvarTodosMedicos().equals(""))) || (agenda.salvarTodosPacientes() != null && !(agenda.salvarTodosPacientes().equals(""))) || (agenda.salvarTodasConsultas() != null && !(agenda.salvarTodasConsultas().equals("")))) {
                    writer.write("Pacientes\r\n\r\n" + agenda.salvarTodosPacientes() + "Médicos\r\n\r\n" + agenda.salvarTodosMedicos() + "Consultas\r\n\r\n" + agenda.salvarTodasConsultas());
                }
                //[Linux]   writer.write("Pacientes\n\n" + agenda.salvarTodosPacientes() + "\n\nMédicos\n\n" + agenda.salvarTodosMedicos() + "\n\nConsultas\n\n" + agenda.salvarTodasConsultas());
                writer.close();
            } catch (Exception e) {

            }
        }
    }

    private void sair() {
        System.out.println("Vou sair");
        System.exit(0);
    }

}
