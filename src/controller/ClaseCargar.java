package controller;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import model.data_structures.Cola;
import model.data_structures.IQueue;
import model.data_structures.IStack;
import model.data_structures.Pila;
import model.vo.*;

public class ClaseCargar {

	/**
	 * Ruta de archivo CSV Enero.
	 */
	public static final String rutaEnero = "./data/Moving_Violations_Issued_in_January_2018.csv";

	/**
	 * Ruta de archivo CSV Febrero.
	 */
	public static final String rutaFebrero = "./data/Moving_Violations_Issued_in_February_2018.csv";

	/**
	 * Ruta de archivo CSV Marzo.
	 */
	public static final String rutaMarzo = "./data/Moving_Violations_Issued_in_March_2018.csv";

	/**
	 * Ruta de archivo CSV Abril.
	 */
	public static final String rutaAbril = "./data/Moving_Violations_Issued_in_April_2018.csv";

	private IQueue<VOMovingViolations> cola;

	private IStack<VOMovingViolations> pila;

	public ClaseCargar() {
		cola = new Cola<>();
		pila = new Pila<>();

	}

	public void cargarPrimerCuatrimestre() {

		try {
			CSVReader lectorEnero = new CSVReader(new FileReader(rutaEnero));
			String[] lineaEnero = lectorEnero.readNext();
			while ((lineaEnero = lectorEnero.readNext()) != null) {
				String obID = lineaEnero[0];
				int objectID = Integer.parseInt(obID);
				String address = lineaEnero[3];
				String streetSegID = lineaEnero[4];
				String fine = lineaEnero[8];
				int fineAmt = Integer.parseInt(fine);
				String total = lineaEnero[9];
				int totalPaid = Integer.parseInt(total);
				String p1 = lineaEnero[10];
				int penalty1 = Integer.parseInt(p1);
				String p2 = lineaEnero[11];
				int penalty2 = 0;
				if(!p2.equals("")){
					penalty2 = Integer.parseInt(p2);
				}
				else{
					penalty2 = 0;
				}
				String accidentIndicator = lineaEnero[12];
				String issueDate = lineaEnero[13];
				String violationCode = lineaEnero[14];
				String violationDesc = lineaEnero[15];
				cola.enqueue(new VOMovingViolations(objectID, issueDate, violationCode, fineAmt, address, streetSegID,
						totalPaid, violationDesc, accidentIndicator, penalty1, penalty2));
				pila.push(new VOMovingViolations(objectID, issueDate, violationCode, fineAmt, address, streetSegID,
						totalPaid, violationDesc, accidentIndicator, penalty1, penalty2));
			
			}
			lectorEnero.close();

			CSVReader lectorFebrero = new CSVReader(new FileReader(rutaFebrero));
			String[] lineaFebrero = lectorFebrero.readNext();
			while ((lineaFebrero = lectorFebrero.readNext()) != null) {
				String obID = lineaFebrero[0];
				int objectID = Integer.parseInt(obID);
				String address = lineaFebrero[3];
				String streetSegID = lineaFebrero[4];
				String fine = lineaFebrero[8];
				int fineAmt = Integer.parseInt(fine);
				String total = lineaFebrero[9];
				int totalPaid = Integer.parseInt(total);
				String p1 = lineaFebrero[10];
				int penalty1 = Integer.parseInt(p1);
				String p2 = lineaFebrero[11];
				int penalty2 = 0;
				if(!p2.equals("")){
					penalty2 = Integer.parseInt(p2);
				}
				else{
					penalty2 = 0;
				}
				String accidentIndicator = lineaFebrero[12];
				String issueDate = lineaFebrero[13];
				String violationCode = lineaFebrero[14];
				String violationDesc = lineaFebrero[15];
				cola.enqueue(new VOMovingViolations(objectID, issueDate, violationCode, fineAmt, address, streetSegID,
						totalPaid, violationDesc, accidentIndicator, penalty1, penalty2));
				pila.push(new VOMovingViolations(objectID, issueDate, violationCode, fineAmt, address, streetSegID,
						totalPaid, violationDesc, accidentIndicator, penalty1, penalty2));
				
			}
			lectorFebrero.close();

			CSVReader lectorMarzo = new CSVReader(new FileReader(rutaMarzo));
			String[] lineaMarzo = lectorMarzo.readNext();
			while ((lineaMarzo = lectorMarzo.readNext()) != null) {
				String obID = lineaMarzo[0];
				int objectID = Integer.parseInt(obID);
				String address = lineaMarzo[3];
				String streetSegID = lineaMarzo[4];
				String fine = lineaMarzo[8];
				int fineAmt = Integer.parseInt(fine);
				String total = lineaMarzo[9];
				int totalPaid = Integer.parseInt(total);
				String p1 = lineaMarzo[10];
				int penalty1 = Integer.parseInt(p1);
				String p2 = lineaMarzo[11];
				int penalty2 = 0;
				if(!p2.equals("")){
					penalty2 = Integer.parseInt(p2);
				}
				else{
					penalty2 = 0;
				}
				String accidentIndicator = lineaMarzo[12];
				String issueDate = lineaMarzo[13];
				String violationCode = lineaMarzo[14];
				String violationDesc = lineaMarzo[15];
				cola.enqueue(new VOMovingViolations(objectID, issueDate, violationCode, fineAmt, address, streetSegID,
						totalPaid, violationDesc, accidentIndicator, penalty1, penalty2));
				pila.push(new VOMovingViolations(objectID, issueDate, violationCode, fineAmt, address, streetSegID,
						totalPaid, violationDesc, accidentIndicator, penalty1, penalty2));
				
			}
			lectorMarzo.close();

			CSVReader lectorAbril = new CSVReader(new FileReader(rutaAbril));
			String[] lineaAbril = lectorAbril.readNext();
			while ((lineaAbril = lectorAbril.readNext()) != null) {
				String obID = lineaAbril[0];
				int objectID = Integer.parseInt(obID);
				String address = lineaAbril[3];
				String streetSegID = lineaAbril[4];
				String fine = lineaAbril[8];
				int fineAmt = Integer.parseInt(fine);
				String total = lineaAbril[9];
				int totalPaid = Integer.parseInt(total);
				String p1 = lineaAbril[10];
				int penalty1 = Integer.parseInt(p1);
				String p2 = lineaAbril[11];
				int penalty2 = 0;
				if(!p2.equals("")){
					penalty2 = Integer.parseInt(p2);
				}
				else{
					penalty2 = 0;
				}
				String accidentIndicator = lineaAbril[12];
				String issueDate = lineaAbril[13];
				String violationCode = lineaAbril[14];
				String violationDesc = lineaAbril[15];
				cola.enqueue(new VOMovingViolations(objectID, issueDate, violationCode, fineAmt, address, streetSegID,
						totalPaid, violationDesc, accidentIndicator, penalty1, penalty2));
				pila.push(new VOMovingViolations(objectID, issueDate, violationCode, fineAmt, address, streetSegID,
						totalPaid, violationDesc, accidentIndicator, penalty1, penalty2));				
			}
			lectorAbril.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
