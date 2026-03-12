

package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JTextField;

import controller.Menu;
import controller.NavegadorTelas2;
//import main.Usuario;
import model.UsuarioPerfil;
import model.UsuarioPerfilDAO;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CadastroUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeComp;
	private JTextField tfNomeUsuario;
	private JTextField tfEmail;
	private JTextField tfTelefone;
	private JPasswordField pfSenha;
	private NavegadorTelas2 navegadorTelas2;
	private Menu menu;
	private JLabel lbIconeVoltar;
	UsuarioPerfil novoUsuario = new UsuarioPerfil(null, null, null, null, null, null, 0.0f, 0.0f, null);
	UsuarioPerfilDAO usuarioDAO = new UsuarioPerfilDAO();

	/**
	 * Create the panel.
	 */
	public CadastroUsuario( Menu menu) {
				
		// Ação botão de um jeito
		//addMouseListener(new MouseAdapter() {
		//	@Override
		//	public void mouseClicked(MouseEvent e) {
				
		//		navegadorTelas2.navegarTela("LOGIN");
		//		
		//	}
		//});
		
		this.navegadorTelas2 = navegadorTelas2;
		this.menu = menu;
		
		setBackground(new Color(234, 219, 247));
		setPreferredSize(new Dimension(1020,640));
		setMinimumSize(new Dimension(1020, 640));
		setLayout(new MigLayout("", "[][30.00][grow][][][][][45.00][grow]", "[][grow][][][][][][][][71.00][][][grow]"));
		
		lbIconeVoltar = new JLabel("");
		lbIconeVoltar.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/imagensIcones/Icone_Seta.png")));
		lbIconeVoltar.setFont(new Font("Tahoma", Font.PLAIN, 27));
		add(lbIconeVoltar, "cell 0 0 2 1");
		
		JLabel lbLunaMia = new JLabel("Luna & Mia");
		lbLunaMia.setFont(new Font("Constantia", Font.PLAIN, 99));
		add(lbLunaMia, "cell 3 2 4 1,alignx center,aligny center");
		
		JLabel lbNomeComp = new JLabel("Nome Completo");
		lbNomeComp.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbNomeComp, "cell 3 4");
		
		tfNomeComp = new JTextField();
		tfNomeComp.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(tfNomeComp, "cell 5 4 2 1,width 27%,alignx left,height 38px");
		tfNomeComp.setColumns(10);
				
		JLabel lbNomeUsuario = new JLabel("Nome de Usuário");
		lbNomeUsuario.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbNomeUsuario, "cell 3 5");
		
		tfNomeUsuario = new JTextField();
		tfNomeUsuario.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(tfNomeUsuario, "cell 5 5 2 1,width 27%,height 38px");
		tfNomeUsuario.setColumns(10);
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbEmail, "cell 3 6");
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(tfEmail, "cell 5 6 2 1,width 27%,height 38px");
		tfEmail.setColumns(10);
		
		JLabel lbTelefone = new JLabel("Telefone");
		lbTelefone.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbTelefone, "cell 3 7");
		
		tfTelefone = new JTextField();
		tfTelefone.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(tfTelefone, "cell 5 7 2 1,width 27%,height 38px");
		tfTelefone.setColumns(10);
		
		JLabel lbSenha = new JLabel("Senha");
		lbSenha.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbSenha, "cell 3 8");
		
		pfSenha = new JPasswordField();
		pfSenha.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(pfSenha, "cell 5 8 2 1,width 27%,height 38px");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 219, 247));
		add(panel, "cell 3 10 4 1,grow");
		
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(e -> {
			
			novoUsuario.setNome(tfNomeComp.getText());
            novoUsuario.setNomeUsuario(tfNomeUsuario.getText());
            novoUsuario.setEmail(tfEmail.getText());
            novoUsuario.setSenha(pfSenha.getText());
            novoUsuario.setEndereco("");
            novoUsuario.setPercentualLucro(0);
            novoUsuario.setPrecoHora(0);
            novoUsuario.setTelefone(tfTelefone.getText());
            

            usuarioDAO.adicionarDados(novoUsuario);
            
			navegadorTelas2.navegarTela("INICIO");
			menu.mostrarPanelCont();
			
			
			
		});
		
		btCadastrar.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		btCadastrar.setBackground(new Color(193, 151, 232));
		panel.add(btCadastrar);
		
		btCadastrar.setBorderPainted(false);
		
		addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Calcula novo tamanho baseado na largura
                int newFontSize = Math.max(20, Math.min(40, getWidth() / 30));

                lbEmail.setFont(new Font("Bodoni Bk BT", Font.PLAIN, newFontSize));
                lbNomeComp.setFont(new Font("Bodoni Bk BT", Font.PLAIN, newFontSize));
                lbNomeUsuario.setFont(new Font("Bodoni Bk BT", Font.PLAIN, newFontSize));
                lbTelefone.setFont(new Font("Bodoni Bk BT", Font.PLAIN, newFontSize));
                lbSenha.setFont(new Font("Bodoni Bk BT", Font.PLAIN, newFontSize));
                btCadastrar.setFont(new Font("Bodoni Bk BT", Font.PLAIN, newFontSize));
                                
            }
        });
		


	}
	
	public void voltar(MouseListener mouseListener) {
		this.lbIconeVoltar.addMouseListener(mouseListener);
	}

	//public void voltar() {
	///	// TODO Auto-generated method stub
		
	//}

	//public Component getIconeVoltar() {
		// TODO Auto-generated method stub
		//return null;
	//}
}
