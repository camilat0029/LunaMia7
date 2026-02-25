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
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class CadastroUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfNomeComp;
	private JTextField tfNomeUsuario;
	private JTextField tfEmail;
	private JTextField tfTelefone;
	private JTextField tfSenha;

	/**
	 * Create the panel.
	 */
	public CadastroUsuario() {
		setBackground(new Color(234, 219, 247));
		setPreferredSize(new Dimension(1020,640));
		setMinimumSize(new Dimension(1020, 640));
		setLayout(new MigLayout("", "[][30.00][grow][][][][][45.00][grow]", "[][grow][][][][][][][][][][][grow]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CadastroUsuario.class.getResource("/imagensIcones/Icone_Seta.png")));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 27));
		add(lblNewLabel, "cell 0 0 2 1");
		
		JLabel lbLunaMia = new JLabel("Luna & Mia");
		lbLunaMia.setFont(new Font("Constantia", Font.PLAIN, 99));
		add(lbLunaMia, "cell 3 2 4 1,center");
		
		JLabel lbNomeComp = new JLabel("Nome Completo");
		lbNomeComp.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbNomeComp, "cell 3 4");
		
		tfNomeComp = new JTextField();
		tfNomeComp.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(tfNomeComp, "cell 5 4 2 1,width 22%,height 38px");
		tfNomeComp.setColumns(10);
		
		JLabel lbNomeUsuario = new JLabel("Nome de Usuário");
		lbNomeUsuario.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbNomeUsuario, "cell 3 5");
		
		tfNomeUsuario = new JTextField();
		tfNomeUsuario.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(tfNomeUsuario, "cell 5 5 2 1,width 22%,height 38px");
		tfNomeUsuario.setColumns(10);
		
		JLabel lbEmail = new JLabel("Email");
		lbEmail.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbEmail, "cell 3 6");
		
		tfEmail = new JTextField();
		tfEmail.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(tfEmail, "cell 5 6 2 1,width 22%,height 38px");
		tfEmail.setColumns(10);
		
		JLabel lbTelefone = new JLabel("Telefone");
		lbTelefone.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbTelefone, "cell 3 7");
		
		tfTelefone = new JTextField();
		tfTelefone.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(tfTelefone, "cell 5 7 2 1,width 22%,height 38px");
		tfTelefone.setColumns(10);
		
		JLabel lbSenha = new JLabel("Senha");
		lbSenha.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbSenha, "cell 3 8");
		
		tfSenha = new JTextField();
		tfSenha.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 20));
		add(tfSenha, "cell 5 8 2 1,width 22%,height 38px");
		tfSenha.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 219, 247));
		add(panel, "cell 3 10 4 1,grow");
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		btCadastrar.setBackground(new Color(193, 151, 232));
		panel.add(btCadastrar);
		
		btCadastrar.setBorderPainted(false);
		
		addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Calcula novo tamanho baseado na largura
                int newFontSize = Math.max(20, Math.min(40, getWidth() / 30));
                //int newFontSize2 = Math.max(80, Math.min(99,getWidth() / 30));
                //lbLunaMia.setFont(new Font("Constantia", Font.PLAIN, newFontSize2));
                lbEmail.setFont(new Font("Bodoni Bk BT", Font.PLAIN, newFontSize));
                lbNomeComp.setFont(new Font("Bodoni Bk BT", Font.PLAIN, newFontSize));
                lbNomeUsuario.setFont(new Font("Bodoni Bk BT", Font.PLAIN, newFontSize));
                lbTelefone.setFont(new Font("Bodoni Bk BT", Font.PLAIN, newFontSize));
                lbSenha.setFont(new Font("Bodoni Bk BT", Font.PLAIN, newFontSize));
                btCadastrar.setFont(new Font("Bodoni Bk BT", Font.PLAIN, newFontSize));
                
                //tfEmail.setFont(new Font("Bodoni Bk BT", Font.PLAIN, newFontSize2));
                
                
            }
        });


	}
	//width 220px,height 30px
}
