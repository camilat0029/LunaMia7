package view;

public class ControllerTeste {
	
	Teste frame;
	
	
	public static void main(String[] args) {
		ControllerTeste c = new ControllerTeste();
		c.iniciar();
	}
	
	public ControllerTeste() {
		// TODO Auto-generated constructor stub
		 frame = new Teste(this);
	}
	private void iniciar() {
		// TODO Auto-generated method stub
		frame.setVisible(true);
		
	}
	
	public void cont() {
		frame.mostrarPainelCont();
	}
	
	public void exp() {
		frame.mostrarPainelExp();
	}


}
