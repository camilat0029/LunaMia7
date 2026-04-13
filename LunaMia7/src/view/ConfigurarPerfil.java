package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class ConfigurarPerfil extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeCompCP;
	private JPasswordField pfSenhaCP;
	private JTextField tfTelefoneCP;
	private JTextField tfEnderecoCP;
	private JTextField tfPrecoHoraCP;
	private JTextField tfPercLucroCP;
	private JLabel lbNomeUsuarioCad;
	private JLabel lbEmailCad;

	/**
	 * Create the panel.
	 */
	public ConfigurarPerfil() {
		
		setBackground(new Color(234, 219, 247));
		setPreferredSize(new Dimension(1020,640));
		setMinimumSize(new Dimension(1020, 640));
		setLayout(new MigLayout("gap 15", "[grow][][][][][][][][][grow]", "[grow][][][][][][][][][][][][][][][grow]"));
		
		JLabel lbNomeCompCP = new JLabel("Nome Completo");
		lbNomeCompCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbNomeCompCP, "cell 1 2");
		
		tfNomeCompCP = new JTextField();
		tfNomeCompCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(tfNomeCompCP, "cell 3 2 6 1, width 67%, wmax 1500px,height 38px");
		tfNomeCompCP.setColumns(10);
		
		JLabel lbNomeUsuaCP = new JLabel("Nome de Usuário");
		lbNomeUsuaCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbNomeUsuaCP, "cell 1 3");
		
		JPanel panel_NomeUsuario = new JPanel();
		panel_NomeUsuario.setBorder(BorderFactory.createEmptyBorder(0, 5, 4, 0));
		panel_NomeUsuario.setBackground(new Color(255, 255, 255));
		add(panel_NomeUsuario, "cell 3 3 6 1, width 67%, height 38!");
		panel_NomeUsuario.setLayout(new MigLayout("", "[]", "[]"));
		
		lbNomeUsuarioCad = new JLabel("");
		lbNomeUsuarioCad.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_NomeUsuario.add(lbNomeUsuarioCad, "cell 0 0,alignx left, growy, aligny center");
		
		JLabel lbEmailCP = new JLabel("Email");
		lbEmailCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbEmailCP, "cell 1 4");
		
		JPanel panel_EmailCad = new JPanel();
		panel_EmailCad.setBorder(BorderFactory.createEmptyBorder(0, 5, 4, 0));
		panel_EmailCad.setBackground(new Color(255, 255, 255));
		add(panel_EmailCad, "cell 3 4 6 1, width 67%, height 38!");
		panel_EmailCad.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		lbEmailCad = new JLabel("");
		lbEmailCad.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_EmailCad.add(lbEmailCad, "cell 0 0,alignx left, growy, aligny center");
		
		JLabel lbSenhaCP = new JLabel("Senha");
		lbSenhaCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbSenhaCP, "cell 1 5");
		
		pfSenhaCP = new JPasswordField();
		pfSenhaCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(pfSenhaCP, "cell 3 5,width 18%,height 38px");
		
		JPanel panel_btRedefinirSenha = new JPanel();
		panel_btRedefinirSenha.setLayout(new MigLayout("", "[250:n,center]", "[]"));
		panel_btRedefinirSenha.setBackground(new Color(234, 219, 247));
		add(panel_btRedefinirSenha, "cell 5 5 4 2,alignx center,aligny center");
		
		JButton btRedefinirSenha = new JButton("Redefinir Senha");
		btRedefinirSenha.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		btRedefinirSenha.setBackground(new Color(193, 151, 232));
		panel_btRedefinirSenha.add(btRedefinirSenha, "growx");
		
		JLabel lbTelefoneCP = new JLabel("Telefone");
		lbTelefoneCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbTelefoneCP, "cell 1 6");
		
		tfTelefoneCP = new JTextField();
		tfTelefoneCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(tfTelefoneCP, "cell 3 6,width 18%,height 38px");
		tfTelefoneCP.setColumns(10);
		
		JLabel lbEstadoCP = new JLabel("Estado");
		lbEstadoCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbEstadoCP, "cell 1 7");
		
		JComboBox cbEstadoCP = new JComboBox();
		cbEstadoCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(cbEstadoCP, "cell 3 7, width 18%,height 38px, height 38px");
		
		JLabel lbCidadeCP = new JLabel("Cidade");
		lbCidadeCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbCidadeCP, "cell 5 7");
		
		JComboBox cbCidade = new JComboBox();
		cbCidade.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(cbCidade, "cell 7 7 2 1,growx,width 18%,height 38px");
		
		JLabel lbEnderecoCP = new JLabel("Endereço");
		lbEnderecoCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbEnderecoCP, "cell 1 8");
		
		tfEnderecoCP = new JTextField();
		tfEnderecoCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(tfEnderecoCP, "cell 3 8,width 18%,height 38px");
		tfEnderecoCP.setColumns(10);
		
		JLabel lbBairroCP = new JLabel("Bairro");
		lbBairroCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbBairroCP, "cell 5 8");
		
		JComboBox cbBairro = new JComboBox();
		cbBairro.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(cbBairro, "cell 7 8 2 1,growx,height 38px");
		
		JLabel lbPrecoHoraCP = new JLabel("Preço da Hora");
		lbPrecoHoraCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbPrecoHoraCP, "cell 1 9");
		
		tfPrecoHoraCP = new JTextField();
		tfPrecoHoraCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		tfPrecoHoraCP.setFont(new Font("Dialog", Font.PLAIN, 20));
		add(tfPrecoHoraCP, "cell 3 9,width 18%,height 38px");
		tfPrecoHoraCP.setColumns(10);
		
		JLabel lbPercLucroCP = new JLabel("Percentual de Lucro");
		lbPercLucroCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbPercLucroCP, "cell 5 9");
		
		tfPercLucroCP = new JTextField();
		tfPercLucroCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(tfPercLucroCP, "cell 7 9 2 1,growx,height 38px");
		tfPercLucroCP.setColumns(10);
		
		JPanel panel_foto = new JPanel();
		add(panel_foto, "cell 3 10 1 3,width 18%, growy");
		
		JLabel lbFotoPerfilCP = new JLabel("Foto de Perfil");
		lbFotoPerfilCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbFotoPerfilCP, "cell 1 11");
		
		JPanel panel_btSalvar = new JPanel();
		panel_btSalvar.setLayout(new MigLayout("", "[250:n,center]", "[]"));
		panel_btSalvar.setBackground(new Color(234, 219, 247));
		add(panel_btSalvar, "cell 1 13 3 1,alignx center,gapy 30");
		
		JPanel panel_btEditar = new JPanel();
		panel_btEditar.setLayout(new MigLayout("", "[250:n,center]", "[]"));
		panel_btEditar.setBackground(new Color(234, 219, 247));
		add(panel_btEditar, "cell 5 13 4 1,alignx center,gapy 30");
		
		JButton btEditar = new JButton("Editar");
		btEditar.setBackground(new Color(193, 151, 232));
		btEditar.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panel_btEditar.add(btEditar, "growx");
		
		JButton btSalvar = new JButton("Salvar");
		btSalvar.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		btSalvar.setBackground(new Color(193, 151, 232));
		panel_btSalvar.add(btSalvar, "cell 0 0,growx");
		
		btSalvar.setBorderPainted(false);
		btEditar.setBorderPainted(false);
		btRedefinirSenha.setBorderPainted(false);
		
		addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Calcula novo tamanho baseado na largura
                int novaFonte = Math.max(24, Math.min(35, getWidth() / 65));

                lbNomeCompCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, novaFonte));
                lbNomeUsuaCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, novaFonte));
                lbEmailCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, novaFonte));
                lbBairroCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, novaFonte));
                lbCidadeCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, novaFonte));
                lbEnderecoCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, novaFonte));
                lbEstadoCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, novaFonte));
                lbFotoPerfilCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, novaFonte));
                lbPercLucroCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, novaFonte));
                lbPrecoHoraCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, novaFonte));
                lbSenhaCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, novaFonte));
                lbTelefoneCP.setFont(new Font("Bodoni Bk BT", Font.PLAIN, novaFonte));
                btEditar.setFont(new Font("Bodoni Bk BT", Font.PLAIN, novaFonte));
                btRedefinirSenha.setFont(new Font("Bodoni Bk BT", Font.PLAIN, novaFonte));
                btSalvar.setFont(new Font("Bodoni Bk BT", Font.PLAIN, novaFonte));
                                
            }
        });	

	}

	public JTextField getTfNomeCompCP() {
		return tfNomeCompCP;
	}

	public void setTfNomeCompCP(JTextField tfNomeCompCP) {
		this.tfNomeCompCP = tfNomeCompCP;
	}

	

	public JPasswordField getPfSenhaCP() {
		return pfSenhaCP;
	}

	public void setPfSenhaCP(JPasswordField pfSenhaCP) {
		this.pfSenhaCP = pfSenhaCP;
	}

	public JTextField getTfTelefoneCP() {
		return tfTelefoneCP;
	}

	public void setTfTelefoneCP(JTextField tfTelefoneCP) {
		this.tfTelefoneCP = tfTelefoneCP;
	}

	public JTextField getTfEnderecoCP() {
		return tfEnderecoCP;
	}

	public void setTfEnderecoCP(JTextField tfEnderecoCP) {
		this.tfEnderecoCP = tfEnderecoCP;
	}

	public JTextField getTfPrecoHoraCP() {
		return tfPrecoHoraCP;
	}

	public void setTfPrecoHoraCP(JTextField tfPrecoHoraCP) {
		this.tfPrecoHoraCP = tfPrecoHoraCP;
	}

	public JTextField getTfPercLucroCP() {
		return tfPercLucroCP;
	}

	public void setTfPercLucroCP(JTextField tfPercLucroCP) {
		this.tfPercLucroCP = tfPercLucroCP;
	}

	public JLabel getLbNomeUsuarioCad() {
		return lbNomeUsuarioCad;
	}

	public void setLbNomeUsuarioCad(JLabel lbNomeUsuarioCad) {
		this.lbNomeUsuarioCad = lbNomeUsuarioCad;
	}

	public JLabel getLbEmailCad() {
		return lbEmailCad;
	}

	public void setLbEmailCad(JLabel lbEmailCad) {
		this.lbEmailCad = lbEmailCad;
	}
	
	
	

}
