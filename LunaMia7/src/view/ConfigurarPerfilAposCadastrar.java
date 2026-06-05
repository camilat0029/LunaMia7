package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.text.ParseException;

import javax.swing.JTextField;
import javax.swing.JToolTip;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class ConfigurarPerfilAposCadastrar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeCompCP;
	private JPasswordField pfSenhaCP;
	private JTextField tfTelefoneCP;
	private JTextField tfPrecoHoraCP;
	private JTextField tfPercLucroCP;
	private JLabel lbNomeUsuarioCad;
	private JLabel lbEmailCad, lbFoto;
	private JComboBox cbCidade;
	private JComboBox cbEstado;
	private JButton btIgnorar, btEscolherFoto, btSalvar;
	private JLabel interrogacaoPrecoHora, interrogacaoPercentLucro;
	private JLabel asteriscoNC;

	/**
	 * Create the panel.
	 */
	public ConfigurarPerfilAposCadastrar() {
		
		setBackground(new Color(234, 219, 247));
		setPreferredSize(new Dimension(1020, 700));
		setMinimumSize(new Dimension(1020, 700));
		setLayout(new MigLayout("gap 16", "[grow][][][][][][grow]", "[grow][][][][][][][][][][][][][][grow]"));
		
		JLabel lbNomeCompCP = new JLabel("Nome Completo");
		lbNomeCompCP.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbNomeCompCP, "cell 1 2");
		
		tfNomeCompCP = new JTextField();
		tfNomeCompCP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(tfNomeCompCP, "cell 2 2 4 1,width 62%,height 38px");
		tfNomeCompCP.setColumns(10);
		
		JLabel lbNomeUsuaCP = new JLabel("Nome de Usuário");
		lbNomeUsuaCP.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbNomeUsuaCP, "cell 1 3");
		
		JPanel panel_NomeUsuario = new JPanel();
		panel_NomeUsuario.setBorder(BorderFactory.createEmptyBorder(0, 5, 4, 0));
		panel_NomeUsuario.setBackground(new Color(255, 255, 255));
		add(panel_NomeUsuario, "cell 2 3 4 1,width 62%,height 38!");
		panel_NomeUsuario.setLayout(new MigLayout("", "[]", "[]"));
		
		lbNomeUsuarioCad = new JLabel("");
		lbNomeUsuarioCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_NomeUsuario.add(lbNomeUsuarioCad, "cell 0 0,alignx left, growy, aligny center");
		
		JLabel lbEmailCP = new JLabel("Email");
		lbEmailCP.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbEmailCP, "cell 1 4");
		
		JPanel panel_EmailCad = new JPanel();
		panel_EmailCad.setBorder(BorderFactory.createEmptyBorder(0, 5, 4, 0));
		panel_EmailCad.setBackground(new Color(255, 255, 255));
		add(panel_EmailCad, "cell 2 4 4 1,width 62%,height 38!");
		panel_EmailCad.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		lbEmailCad = new JLabel("");
		lbEmailCad.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		panel_EmailCad.add(lbEmailCad, "cell 0 0,alignx left, growy, aligny center");
		
		JLabel lbSenhaCP = new JLabel("Senha");
		lbSenhaCP.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbSenhaCP, "cell 1 5");
		
		pfSenhaCP = new JPasswordField();
		pfSenhaCP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(pfSenhaCP, "cell 2 5, growx, width 18%,height 38px");
		
		JLabel lbTelefoneCP = new JLabel("Telefone");
		lbTelefoneCP.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbTelefoneCP, "cell 1 6");
		
		tfTelefoneCP = new JTextField();
		tfTelefoneCP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(tfTelefoneCP, "cell 2 6, growx, width 18%,height 38px");
		tfTelefoneCP.setColumns(10);
		
		JLabel lbEstadoCP = new JLabel("Estado");
		lbEstadoCP.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbEstadoCP, "cell 1 7");
		
		cbEstado = new JComboBox();
		cbEstado.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(cbEstado, "cell 2 7,growx,width 18%,height 38px");
		cbEstado.setPreferredSize(new Dimension(175,38));
		cbEstado.setMaximumSize(new Dimension(350,38));
		
		JLabel lbCidadeCP = new JLabel("Cidade");
		lbCidadeCP.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbCidadeCP, "cell 3 7");
		
		cbCidade = new JComboBox();
		cbCidade.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(cbCidade, "cell 4 7 2 1, growx, width 12%,height 38px");
		cbCidade.setPreferredSize(new Dimension(80,38));
		cbCidade.setMaximumSize(new Dimension(550,38));
		cbCidade.setMinimumSize(new Dimension(80,38));
		
		JLabel lbPrecoHoraCP = new JLabel("Preço da Hora");
		lbPrecoHoraCP.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbPrecoHoraCP, "flowx,cell 1 8");
		
		tfPrecoHoraCP = new JTextField();
		tfPrecoHoraCP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfPrecoHoraCP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(tfPrecoHoraCP, "cell 2 8,growx,width 18%, height 38px");
		tfPrecoHoraCP.setColumns(10);
		
		JLabel lbPercLucroCP = new JLabel("Percentual de Lucro");
		lbPercLucroCP.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbPercLucroCP, "flowx,cell 3 8");
		
		tfPercLucroCP = new JTextField();
		tfPercLucroCP.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		add(tfPercLucroCP, "cell 4 8 2 1,growx, width 18%, height 38px");
		tfPercLucroCP.setColumns(10);
		
		JLabel lbFotoPerfilCP = new JLabel("Foto de Perfil");
		lbFotoPerfilCP.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		add(lbFotoPerfilCP, "cell 1 10, gapy 25");
		
		lbFoto = new JLabel();
		
		lbFoto.setHorizontalAlignment(SwingConstants.CENTER);
		lbFoto.setVerticalAlignment(SwingConstants.CENTER);
		
		lbFoto.setIcon(new ImageIcon(ConfigurarPerfil.class.getResource("/imagensIcones/fotoPerfilPadrao.png")));
		ImageIcon imagemPadrao = new ImageIcon(getClass().getResource("/imagensIcones/fotoPerfilPadrao.png"));
		lbFoto.setIcon(new ImageIcon(imagemPadrao.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));

		lbFoto.setPreferredSize(new Dimension(150, 150));
		
		add(lbFoto, "cell 2 10,alignx center,gapy 25");
		
		btEscolherFoto = new JButton("Escolher foto");
		btEscolherFoto.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btEscolherFoto.setBackground(new Color(193, 151, 232));
		add(btEscolherFoto, "cell 3 10, gapy 25");
		
		JPanel panel_btSalvar = new JPanel();
		panel_btSalvar.setLayout(new MigLayout("", "[250:n,center]", "[]"));
		panel_btSalvar.setBackground(new Color(234, 219, 247));
		add(panel_btSalvar, "cell 1 12 2 1,alignx center,gapy 25");
		
		JPanel panel_btIgnorar = new JPanel();
		panel_btIgnorar.setBackground(new Color(234, 219, 247));
		add(panel_btIgnorar, "cell 3 12 3 1,growx,gapy 25");
		
		btIgnorar = new JButton("Ignorar Por Enquanto ");
		btIgnorar.setBackground(new Color(193, 151, 232));
		btIgnorar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		panel_btIgnorar.add(btIgnorar);
		
		btSalvar = new JButton("Salvar");
		btSalvar.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btSalvar.setBackground(new Color(193, 151, 232));
		panel_btSalvar.add(btSalvar, "cell 0 0,growx");
		
		btSalvar.setBorderPainted(false);
		btIgnorar.setBorderPainted(false);
		btEscolherFoto.setBorderPainted(false);
		
		btSalvar.setFocusPainted(false);
		btIgnorar.setFocusPainted(false);
		btEscolherFoto.setFocusPainted(false);		
		
		interrogacaoPrecoHora = new JLabel("") {
			@Override
			public JToolTip createToolTip() {

				JToolTip tooltip = super.createToolTip();

				tooltip.setOpaque(true);
				tooltip.setBackground(new Color(239, 239, 239));
				tooltip.setForeground(new Color(143, 97, 201));
				tooltip.setFont(new Font("Times New Roman", Font.PLAIN, 15));

				return tooltip;
			}
		};
		add(interrogacaoPrecoHora, "cell 1 8");

		interrogacaoPercentLucro = new JLabel("") {
			@Override
			public JToolTip createToolTip() {

				JToolTip tooltip = super.createToolTip();

				tooltip.setOpaque(true);
				tooltip.setBackground(new Color(239, 239, 239));
				tooltip.setForeground(new Color(143, 97, 201));
				tooltip.setFont(new Font("Times New Roman", Font.PLAIN, 15));

				return tooltip;
			}
		};
		add(interrogacaoPercentLucro, "cell 3 8");

		ImageIcon iconInterrogacao = new ImageIcon(
				CadastroMateriaPrimaEstoque.class.getResource("/imagensIcones/Icone_Interrogacao.png"));

		Image imgInterrogacao = iconInterrogacao.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH);
		interrogacaoPercentLucro.setIcon(new ImageIcon(imgInterrogacao));
		interrogacaoPrecoHora.setIcon(new ImageIcon(imgInterrogacao));

		interrogacaoPrecoHora.setToolTipText("<html><div style='width: 150px;'> O valor que será cobrado por cada hora do seu trabalho."
				+ "Você pode fazer : (Salário Desejado + Custos Fixos e Operacionais) /<br>  Horas Trabalhadas no Mês = Preço por Hora. </div></html>");
		interrogacaoPercentLucro
				.setToolTipText("<html><div style='width:150px;'> É a porcentagem que irá sobrar após pagar as despesas do trabalho."
						+ "Você pode fazer: (Lucro da empresa / Faturamento) * 100 </div></html>");
		
		
		addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Calcula novo tamanho baseado na largura
                int novaFonte = Math.max(24, Math.min(35, getWidth() / 65));

                lbNomeCompCP.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));
                lbNomeUsuaCP.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));
                lbEmailCP.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));                
                lbCidadeCP.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));                
                lbEstadoCP.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));
                lbFotoPerfilCP.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));
                lbPercLucroCP.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));
                lbPrecoHoraCP.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));
                lbSenhaCP.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));
                lbTelefoneCP.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));
                btIgnorar.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));
                btSalvar.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));
                
                lbNomeUsuarioCad.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));
                lbEmailCad.setFont(new Font("Times New Roman", Font.PLAIN, novaFonte));
                
                
                                
            }
        });	
		
		ImageIcon iconAsterisco = new ImageIcon(CadastroMateriaPrimaEstoque.class.getResource("/imagensIcones/Asterisco.png"));
		Image imgAsterisco = iconAsterisco.getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH);
		
		asteriscoNC = new JLabel("") {
			@Override
			public JToolTip createToolTip() {

				JToolTip tooltip = super.createToolTip();

				tooltip.setOpaque(true);
				tooltip.setBackground(new Color(239,239,239));
				tooltip.setForeground(new Color(143, 97, 201));
				tooltip.setFont(new Font("Times New Roman", Font.PLAIN, 15));

				return tooltip;
			}
		};
		asteriscoNC.setIcon(new ImageIcon(imgAsterisco));
		add(asteriscoNC, "cell 1 2,alignx left,aligny top");
		asteriscoNC.setToolTipText("<html><b>É obrigatório</b></html>");

	}
	
	public JLabel getLbFoto() {
		return lbFoto;
	}

	public void setLbFoto(JLabel lbFoto) {
		this.lbFoto = lbFoto;
	}
	
	public void escolherFoto(ActionListener actionListener) {
		this.btEscolherFoto.addActionListener(actionListener);
	}
	
	public void salvarCadCompleto(ActionListener actionListener) {
		this.btSalvar.addActionListener(actionListener);
	}
	
	public void ignorar(ActionListener actionListener) {
		this.btIgnorar.addActionListener(actionListener);
	}
	

	public JTextField getTfNomeCompCP() {
		return tfNomeCompCP;
	}

	public void setTfNomeCompCP(JTextField tfNomeCompCP) {
		this.tfNomeCompCP = tfNomeCompCP;
	}

	public JLabel getLbEmailCad() {
		return lbEmailCad;
	}

	public void setLbEmailCad(JLabel lbEmailCad) {
		this.lbEmailCad = lbEmailCad;
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


	public JComboBox getCbCidade() {
		return cbCidade;
	}

	public void setCbCidade(JComboBox cbCidade) {
		this.cbCidade = cbCidade;
	}

	public JComboBox getCbEstadoCP() {
		return cbEstado;
	}

	public void setCbEstadoCP(JComboBox cbEstadoCP) {
		this.cbEstado = cbEstadoCP;
	}
		
	public void adicionarOuvinte(ComponentListener listener) {
		this.addComponentListener(listener);
	}

}