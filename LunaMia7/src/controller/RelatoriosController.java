package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.OrcamentoDAO;
import view.RelatorioGastos;
import view.RelatorioHorasTrabalhadas;
import view.RelatorioLucros;
import view.Relatorios;
import view.TelaPrincipal;

public class RelatoriosController {
	
	private Menu menu;
	private NavegadorTelas navegadorTelas;
	private Relatorios relatorios;
	private TelaPrincipal telaPrincipal;
	
	private RelatorioLucros relatorioLucros;
	private OrcamentoDAO orcamentoDAO;
	
	private RelatorioHorasTrabalhadas relatorioHorasTrabalhadas;
	private RelatorioGastos relatorioGastos;
	
	public RelatoriosController(Menu menu, NavegadorTelas navegadorTelas, Relatorios relatorios,
			TelaPrincipal telaPrincipal,RelatorioLucros relatorioLucros, OrcamentoDAO orcamentoDAO, RelatorioHorasTrabalhadas relatorioHorasTrabalhadas,
			RelatorioGastos relatorioGastos) {
		
		super();
		this.menu = menu;
		this.navegadorTelas = navegadorTelas;
		this.relatorios = relatorios;
		this.telaPrincipal = telaPrincipal;
		this.relatorioLucros = relatorioLucros;
		this.orcamentoDAO = orcamentoDAO;
		this.relatorioHorasTrabalhadas = relatorioHorasTrabalhadas;
		this.relatorioGastos = relatorioGastos;
		
		this.relatorios.relatorioGT(e ->{
			navegadorTelas.navegarTela("RELATORIO_GASTOS");
		});
		this.relatorios.relatorioHT(e ->{
			navegadorTelas.navegarTela("RELATORIO_HORAS_TRABALHADAS");
		});
		this.relatorios.relatorioLC(e ->{
			navegadorTelas.navegarTela("RELATORIO_LUCROS");
		});
		
		this.relatorioLucros.voltar(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        navegadorTelas.navegarTela("RELATORIOS");
		    }
		});	
		this.relatorioHorasTrabalhadas.voltar(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        navegadorTelas.navegarTela("RELATORIOS");
		    }
		});	
		this.relatorioGastos.voltar(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        navegadorTelas.navegarTela("RELATORIOS");
		    }
		});
		
	}
		
}
