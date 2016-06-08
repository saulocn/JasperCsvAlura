package br.com.caelum.relatorio.teste;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import br.com.caelum.relatorio.GeradorRelatorio;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.data.JRCsvDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class TesteGeraRelatorioComCSVDataSource {

	public static void main(String[] args) throws SQLException, JRException, FileNotFoundException {

		JasperCompileManager.compileReportToFile("movimentacoes.jrxml"); 

		Map<String, Object> parametros = new HashMap<String, Object>();

		//ƒ preciso initializar a datasource para ler um arquivo movimentacoes.csv
		JRCsvDataSource dataSource = new JRCsvDataSource(JRLoader.getLocationInputStream("movimentacoes.csv"));
		//id,data,descricao,tipoMovimentacao,valor
	    String[] columnNames = new String[]{"id", "data", "descricao", "tipoMovimentacao", "valor"};
	    dataSource.setColumnNames(columnNames);
	    dataSource.setDatePattern("yyyy-MM-dd");
	    
	    GeradorRelatorio gr = new GeradorRelatorio("movimentacoes.jasper", parametros, dataSource);
	    gr.geraPDFPara(new FileOutputStream("movimentacoes_ds.pdf"));
		
//		JasperPrint print = JasperFillManager.fillReport("movimentacoes.jasper", parametros, dataSource);
//
//		JRExporter exporter = new JRPdfExporter();
//		exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
//		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, new FileOutputStream("movimentacoes.pdf"));
//		exporter.exportReport();
	}

}
