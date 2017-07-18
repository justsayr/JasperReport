package com.jasper.JasperReport;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jasper.JasperReport.domain.Person;
import com.jasper.JasperReport.service.PersonService;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

@SpringBootApplication
public class JasperReportApplication {

	public static void main(String[] args) throws JRException {
		SpringApplication.run(JasperReportApplication.class, args);
		prepareReport();
	}

	private static void prepareReport() throws JRException {

		List<Person> persons = PersonService.createPersonList();
		JasperReport report = JasperCompileManager.compileReport("C:/workspace/JasperReport/jasper_report_temp.jrxml");
		
		JRBeanCollectionDataSource jrBean = new JRBeanCollectionDataSource(persons);
		JRBeanCollectionDataSource jrSubReportBean = new JRBeanCollectionDataSource(PersonService.createIdAndPersonList());

		Map<String, Object> params = new HashMap<>();
		params.put("personlist", jrBean);
		params.put("personTableList", jrSubReportBean);
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(report, params,  new JREmptyDataSource());
	
		// Make sure the output directory exists.
		File outDir = new File("C:/jasperoutput");
		outDir.mkdirs();

		// PDF Exportor.
		JRPdfExporter exporter = new JRPdfExporter();

		ExporterInput exporterInput = new SimpleExporterInput(jasperPrint);
		// ExporterInput
		exporter.setExporterInput(exporterInput);

		// ExporterOutput
		OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
		        "C:/jasperoutput/FirstJasperReport.pdf");
		// Output
		exporter.setExporterOutput(exporterOutput);

		//
		SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
		exporter.setConfiguration(configuration);
		exporter.exportReport();

		System.out.print("Done!");
	
	}
}
