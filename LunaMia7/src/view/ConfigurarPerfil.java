

package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import model.UsuarioPerfil;
import model.UsuarioPerfilDAO;

import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfigurarPerfil extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeCompCP;
	private JTextField tfNomeUsuaCP;
	private JTextField tfEmailCP;
	private JPasswordField pfSenhaCP;
	private JTextField tfTelefoneCP;
	private JTextField tfEnderecoCP;
	private JTextField tfPrecoHoraCP;
	private JTextField tfPercLucroCP;
	UsuarioPerfil novoUsuario = new UsuarioPerfil(null, null, null, null, null, null, 0.0f, 0.0f, null);
	UsuarioPerfilDAO usuarioDAO = new UsuarioPerfilDAO();

	/**
	 * Create the panel.
	 */
	public ConfigurarPerfil() {
		setBackground(new Color(234, 219, 247));
		setLayout(new MigLayout("", "[grow][][][151.00][][130.00][][][][grow]", "[grow][][][][][][][][][][][grow][][][][][][][][grow]"));
		
		JLabel lbNomeCompCP = new JLabel("Nome Completo");
		lbNomeCompCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbNomeCompCP, "cell 1 2");
		
		tfNomeCompCP = new JTextField();
		tfNomeCompCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(tfNomeCompCP, "cell 3 2 6 1,growx");
		tfNomeCompCP.setColumns(10);
		
		JLabel lbNomeUsuaCP = new JLabel("Nome de Usuário");
		lbNomeUsuaCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbNomeUsuaCP, "cell 1 3");
		
		tfNomeUsuaCP = new JTextField();
		tfNomeUsuaCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(tfNomeUsuaCP, "cell 3 3 6 1,growx");
		tfNomeUsuaCP.setColumns(10);
		
		JLabel lbEmailCP = new JLabel("Email");
		lbEmailCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbEmailCP, "cell 1 4");
		
		tfEmailCP = new JTextField();
		tfEmailCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(tfEmailCP, "cell 3 4 6 1,growx");
		tfEmailCP.setColumns(10);
		
		JLabel lbSenhaCP = new JLabel("Senha");
		lbSenhaCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbSenhaCP, "cell 1 5");
		
		pfSenhaCP = new JPasswordField();
		pfSenhaCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(pfSenhaCP, "cell 3 5,growx");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(234, 219, 247));
		add(panel_2, "cell 5 5 4 2,growx,aligny center");
		
		JButton btRedefinirS = new JButton("Redefinir Senha");
		btRedefinirS.setBackground(new Color(193, 151, 232));
		btRedefinirS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panel_2.add(btRedefinirS);
		
		JLabel lbTelefoneCP = new JLabel("Telefone");
		lbTelefoneCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbTelefoneCP, "cell 1 6");
		
		tfTelefoneCP = new JTextField();
		tfTelefoneCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(tfTelefoneCP, "cell 3 6,growx");
		tfTelefoneCP.setColumns(10);
		
		JLabel lbEstadoCP = new JLabel("Estado");
		lbEstadoCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbEstadoCP, "cell 1 7");
		
		JComboBox cbEstadoCP = new JComboBox();
		cbEstadoCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(cbEstadoCP, "cell 3 7,growx");
		
		JLabel lbCidadeCP = new JLabel("Cidade");
		lbCidadeCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbCidadeCP, "cell 5 7");
		
		JComboBox cbCidade = new JComboBox();
		cbCidade.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(cbCidade, "cell 7 7 2 1,growx");
		
		JLabel lbEnderecoCP = new JLabel("Endereço");
		lbEnderecoCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbEnderecoCP, "cell 1 8");
		
		tfEnderecoCP = new JTextField();
		tfEnderecoCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(tfEnderecoCP, "cell 3 8,growx");
		tfEnderecoCP.setColumns(10);
		
		JLabel lbBairroCP = new JLabel("Bairro");
		lbBairroCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbBairroCP, "cell 5 8");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(comboBox_1, "cell 7 8 2 1,growx");
		
		JLabel lbPrecoHoraCP = new JLabel("Preço da Hora");
		lbPrecoHoraCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbPrecoHoraCP, "cell 1 9");
		
		tfPrecoHoraCP = new JTextField();
		tfPrecoHoraCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(tfPrecoHoraCP, "cell 3 9,growx");
		tfPrecoHoraCP.setColumns(10);
		
		JLabel lbPercLucroCP = new JLabel("Percentual de Lucro");
		lbPercLucroCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbPercLucroCP, "cell 5 9");
		
		tfPercLucroCP = new JTextField();
		tfPercLucroCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(tfPercLucroCP, "cell 7 9 2 1,growx");
		tfPercLucroCP.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		add(panel_3, "cell 3 10 1 7,grow");
		
		JLabel lbFotoPerfilCP = new JLabel("Foto de Perfil");
		lbFotoPerfilCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbFotoPerfilCP, "cell 1 13");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 219, 247));
		add(panel, "cell 3 17,grow");
		
		JButton btEditar = new JButton("Editar");
		btEditar.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		btEditar.setBackground(new Color(193, 151, 232));
		panel.add(btEditar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(234, 219, 247));
		add(panel_1, "cell 5 17,grow");
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				novoUsuario.setNome(tfNomeCompCP.getText());
	            novoUsuario.setNomeUsuario(tfNomeUsuaCP.getText());
	            novoUsuario.setEmail(tfEmailCP.getText());
	            novoUsuario.setSenha(pfSenhaCP.getText());
	            novoUsuario.setEndereco(tfEnderecoCP.getText());
	            novoUsuario.setPercentualLucro(Float.parseFloat(tfPercLucroCP.getText()));
	            novoUsuario.setPrecoHora(Float.parseFloat(tfPrecoHoraCP.getText()));
	            novoUsuario.setTelefone(tfTelefoneCP.getText());
	            

	            usuarioDAO.adicionarDados(novoUsuario);
	            
				
				
				
				
				
			}
		});
		btSalvar.setBackground(new Color(193, 151, 232));
		btSalvar.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panel_1.add(btSalvar);
		
		btEditar.setBorderPainted(false);
		btSalvar.setBorderPainted(false);
		btRedefinirS.setBorderPainted(false);

	}

}
