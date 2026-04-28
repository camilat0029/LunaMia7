package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

public class RedefinirSenha extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPasswordField pfNovaSenhaRS;
	private JPasswordField pfConfirmarNovaSenhaRS;
	private JButton btConfirmarRS;
	private JButton btCancelarRS;
	private JLabel lbSenha;

	/**
	 * Create the panel.
	 */
	public RedefinirSenha() {
		setBackground(new Color(234, 219, 247));
		setPreferredSize(new Dimension(1020,640));
		setMinimumSize(new Dimension(1020, 640));
		setLayout(new MigLayout("gap 7", "[grow][][][][grow]", "[grow][][][][][][][][][][][grow]"));
		
		JLabel lbSenhaRS = new JLabel("Senha");
		lbSenhaRS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbSenhaRS, "cell 1 1 3 1,alignx center");
		
		JPanel panel_Senha = new JPanel();
		panel_Senha.setBackground(new Color(255, 255, 255));
		panel_Senha.setBorder(BorderFactory.createEmptyBorder(0, 5, 4, 0));
		add(panel_Senha, "cell 1 2 3 1,growx,width 30%,height 38px");
		panel_Senha.setLayout(new MigLayout("", "[90px]", "[26px]"));
		
		lbSenha = new JLabel("");
		lbSenha.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_Senha.add(lbSenha, "cell 0 0,alignx left,aligny center");
		
		JLabel lbNovaSenhaRS = new JLabel("Nova Senha");
		lbNovaSenhaRS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbNovaSenhaRS, "cell 1 4 3 1,alignx center, gapy 30");
		
		pfNovaSenhaRS = new JPasswordField();
		pfNovaSenhaRS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(pfNovaSenhaRS, "cell 1 5 3 1,growx,width 30%,height 38px");
		
		JLabel lbConfirmarNovaSenhaRS = new JLabel("Confirmar nova senha");
		lbConfirmarNovaSenhaRS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		add(lbConfirmarNovaSenhaRS, "cell 1 7 3 1,alignx center, gapy 30");
		
		pfConfirmarNovaSenhaRS = new JPasswordField();
		pfConfirmarNovaSenhaRS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 22));
		add(pfConfirmarNovaSenhaRS, "cell 1 8 3 1,growx,width 30%,height 38px");
		
		JPanel panelCancelarRS = new JPanel();
		panelCancelarRS.setBackground(new Color(234, 219, 247));
		add(panelCancelarRS, "cell 1 10,alignx left,growy,gapy 38");
		
		btCancelarRS = new JButton("Cancelar");
		btCancelarRS.setBackground(new Color(193, 151, 232));
		btCancelarRS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panelCancelarRS.add(btCancelarRS);
		btCancelarRS.setBorderPainted(false);
		
		JPanel panelConfirmarRS = new JPanel();
		panelConfirmarRS.setBackground(new Color(234, 219, 247));
		add(panelConfirmarRS, "cell 3 10,alignx right,growy,gapy 38");
		
		btConfirmarRS = new JButton("Confirmar");
		btConfirmarRS.setBackground(new Color(193, 151, 232));
		btConfirmarRS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, 25));
		panelConfirmarRS.add(btConfirmarRS);
		btConfirmarRS.setBorderPainted(false);
		
		addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // Calcula novo tamanho baseado na largura
            	int largura = getTopLevelAncestor().getWidth();
                int novaFonte = Math.max(25, Math.min(35, largura / 35));
                
                lbSenhaRS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, novaFonte));
                lbNovaSenhaRS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, novaFonte));
                lbConfirmarNovaSenhaRS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, novaFonte));
                btCancelarRS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, novaFonte));
                btConfirmarRS.setFont(new Font("Bodoni Bk BT", Font.PLAIN, novaFonte));
                
                repaint();
                revalidate();
                                
            }
        });	

	}
	
	public void confirmar(ActionListener actionListener) {
		this.btConfirmarRS.addActionListener(actionListener);
	}
	
	public void cancelar(ActionListener actionListener) {
		this.btCancelarRS.addActionListener(actionListener);
	}
	
	
	public JPasswordField getPfNovaSenhaRS() {
		return pfNovaSenhaRS;
	}

	public void setPfNovaSenhaRS(JPasswordField pfNovaSenhaRS) {
		this.pfNovaSenhaRS = pfNovaSenhaRS;
	}

	public JPasswordField getPfConfirmarNovaSenhaRS() {
		return pfConfirmarNovaSenhaRS;
	}

	public void setPfConfirmarNovaSenhaRS(JPasswordField pfConfirmarNovaSenhaRS) {
		this.pfConfirmarNovaSenhaRS = pfConfirmarNovaSenhaRS;
	}

	public JLabel getLbSenha() {
		return lbSenha;
	}

	public void setLbSenha(JLabel lbSenha) {
		this.lbSenha = lbSenha;
	}



}
