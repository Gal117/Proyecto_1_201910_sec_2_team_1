package controller;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.opencsv.CSVReader;

import model.data_structures.IQueue;
import model.data_structures.IStack;
import model.vo.VODaylyStatistic;
import model.vo.VOMovingViolations;
import model.vo.VOViolationCode;
import view.MovingViolationsManagerView;

public class Controller {

	private MovingViolationsManagerView view;

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

	/**
	 * Ruta de archivo CSV Mayo.
	 */
	public static final String rutaMayo = "./data/Moving_Violations_Issued_in_May_2018.csv";
	/**
	 * Ruta de archivo CSV Junio.
	 */
	public static final String rutaJunio = "./data/Moving_Violations_Issued_in_June_2018.csv";
	/**
	 * Ruta de archivo CSV Julio.
	 */
	public static final String rutaJulio = "./data/Moving_Violations_Issued_in_July_2018.csv";
	/**
	 * Ruta de archivo CSV Agosto.
	 */
	public static final String rutaAgosto = "./data/Moving_Violations_Issued_in_August_2018.csv";
	/**
	 * Ruta de archivo CSV Septiembre.
	 */
	public static final String rutaSeptiembre = "./data/Moving_Violations_Issued_in_September_2018.csv";
	/**
	 * Ruta de archivo CSV Octubre.
	 */
	public static final String rutaOctubre = "./data/Moving_Violations_Issued_in_October_2018.csv";
	/**
	 * Ruta de archivo CSV Noviembre.
	 */
	public static final String rutaNoviembre = "./data/Moving_Violations_Issued_in_November_2018.csv";
	/**
	 * Ruta de archivo CSV Diciembre.
	 */
	public static final String rutaDiciembre = "./data/Moving_Violations_Issued_in_December_2018.csv";

	private IStack<VOMovingViolations> pila;


	public Controller() {
		view = new MovingViolationsManagerView();
		//TODO inicializar pila 
	}

	public void run() {
		Scanner sc = new Scanner(System.in);
		boolean fin=false;
		Controller controller = new Controller();

		while(!fin)
		{
			view.printMenu();

			int option = sc.nextInt();

			switch(option)
			{
			case 0:
				view.printMessage("Ingrese el cuatrimestre (1, 2 o 3)");
				int numeroCuatrimestre = sc.nextInt();
				controller.loadMovingViolations(numeroCuatrimestre);
				break;

			case 1:
				boolean isUnique = controller.verifyObjectIDIsUnique();
				view.printMessage("El objectId es único: " + isUnique);
				break;

			case 2:

				view.printMessage("Ingrese la fecha con hora inicial (Ej : 28/03/2017T15:30:20)");
				LocalDateTime fechaInicialReq2A = convertirFecha_Hora_LDT(sc.next());

				view.printMessage("Ingrese la fecha con hora final (Ej : 28/03/2017T15:30:20)");
				LocalDateTime fechaFinalReq2A = convertirFecha_Hora_LDT(sc.next());

				IQueue<VOMovingViolations> resultados2 = controller.getMovingViolationsInRange(fechaInicialReq2A, fechaFinalReq2A);

				view.printMovingViolationsReq2(resultados2);

				break;

			case 3:

				view.printMessage("Ingrese el VIOLATIONCODE (Ej : T210)");
				String violationCode3 = sc.next();

				double [] promedios3 = controller.avgFineAmountByViolationCode(violationCode3);

				view.printMessage("FINEAMT promedio sin accidente: " + promedios3[0] + ", con accidente:" + promedios3[1]);
				break;


			case 4:

				view.printMessage("Ingrese el ADDRESS_ID");
				String addressId4 = sc.next();

				view.printMessage("Ingrese la fecha con hora inicial (Ej : 28/03/2017)");
				LocalDate fechaInicialReq4A = convertirFecha(sc.next());

				view.printMessage("Ingrese la fecha con hora final (Ej : 28/03/2017)");
				LocalDate fechaFinalReq4A = convertirFecha(sc.next());

				IStack<VOMovingViolations> resultados4 = controller.getMovingViolationsAtAddressInRange(addressId4, fechaInicialReq4A, fechaFinalReq4A);

				view.printMovingViolationsReq4(resultados4);

				break;

			case 5:
				view.printMessage("Ingrese el limite inferior de FINEAMT  (Ej: 50)");
				double limiteInf5 = sc.nextDouble();

				view.printMessage("Ingrese el limite superior de FINEAMT  (Ej: 50)");
				double limiteSup5 = sc.nextDouble();

				IQueue<VOViolationCode> violationCodes = controller.violationCodesByFineAmt(limiteInf5, limiteSup5);
				view.printViolationCodesReq5(violationCodes);
				break;

			case 6:

				view.printMessage("Ingrese el limite inferior de TOTALPAID (Ej: 200)");
				double limiteInf6 = sc.nextDouble();

				view.printMessage("Ingrese el limite superior de TOTALPAID (Ej: 200)");
				double limiteSup6 = sc.nextDouble();

				view.printMessage("Ordenar Ascendentmente: (Ej: true)");
				boolean ascendente6 = sc.nextBoolean();				

				IStack<VOMovingViolations> resultados6 = controller.getMovingViolationsByTotalPaid(limiteInf6, limiteSup6, ascendente6);
				view.printMovingViolationReq6(resultados6);
				break;

			case 7:

				view.printMessage("Ingrese la hora inicial (Ej: 23)");
				int horaInicial7 = sc.nextInt();

				view.printMessage("Ingrese la hora final (Ej: 23)");
				int horaFinal7 = sc.nextInt();

				IQueue<VOMovingViolations> resultados7 = controller.getMovingViolationsByHour(horaInicial7, horaFinal7);
				view.printMovingViolationsReq7(resultados7);
				break;

			case 8:

				view.printMessage("Ingrese el VIOLATIONCODE (Ej : T210)");
				String violationCode8 = sc.next();

				double [] resultado8 = controller.avgAndStdDevFineAmtOfMovingViolation(violationCode8);

				view.printMessage("FINEAMT promedio: " + resultado8[0] + ", desviación estandar:" + resultado8[1]);
				break;

			case 9:

				view.printMessage("Ingrese la hora inicial (Ej: 23)");
				int horaInicial9 = sc.nextInt();

				view.printMessage("Ingrese la hora final (Ej: 23)");
				int horaFinal9 = sc.nextInt();

				int resultado9 = controller.countMovingViolationsInHourRange(horaInicial9, horaFinal9);

				view.printMessage("Número de infracciones: " + resultado9);
				break;

			case 10:
				view.printMovingViolationsByHourReq10();
				break;

			case 11:
				view.printMessage("Ingrese la fecha inicial (Ej : 28/03/2017)");
				LocalDate fechaInicial11 = convertirFecha(sc.next());

				view.printMessage("Ingrese la fecha final (Ej : 28/03/2017)");
				LocalDate fechaFinal11 = convertirFecha(sc.next());

				double resultados11 = controller.totalDebt(fechaInicial11, fechaFinal11);
				view.printMessage("Deuda total "+ resultados11);
				break;

			case 12:	
				view.printTotalDebtbyMonthReq12();

				break;

			case 13:	
				fin=true;
				sc.close();
				break;
			}
		}

	}


	public void loadMovingViolations(int numeroCuatrimestre) {
		try {
			if(numeroCuatrimestre ==1){
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
					pila.push(new VOMovingViolations(objectID, issueDate, violationCode, fineAmt, address, streetSegID,
							totalPaid, violationDesc, accidentIndicator, penalty1, penalty2));				
				}
				lectorAbril.close();
			}
			
			else if(numeroCuatrimestre == 2){
				
				CSVReader lectorMayo = new CSVReader(new FileReader(rutaMayo));
				String[] lineaMayo = lectorMayo.readNext();
				while ((lineaMayo = lectorMayo.readNext()) != null) {
					String obID = lineaMayo[0];
					int objectID = Integer.parseInt(obID);
					String address = lineaMayo[3];
					String streetSegID = lineaMayo[4];
					String fine = lineaMayo[8];
					int fineAmt = Integer.parseInt(fine);
					String total = lineaMayo[9];
					int totalPaid = Integer.parseInt(total);
					String p1 = lineaMayo[10];
					int penalty1 = Integer.parseInt(p1);
					String p2 = lineaMayo[11];
					int penalty2 = 0;
					if(!p2.equals("")){
						penalty2 = Integer.parseInt(p2);
					}
					else{
						penalty2 = 0;
					}
					String accidentIndicator = lineaMayo[12];
					String issueDate = lineaMayo[13];
					String violationCode = lineaMayo[14];
					String violationDesc = lineaMayo[15];

					pila.push(new VOMovingViolations(objectID, issueDate, violationCode, fineAmt, address, streetSegID,
							totalPaid, violationDesc, accidentIndicator, penalty1, penalty2));

				}
				lectorMayo.close();
				
				CSVReader lectorJunio = new CSVReader(new FileReader(rutaJunio));
				String[] lineaJunio = lectorJunio.readNext();
				while ((lineaJunio = lectorJunio.readNext()) != null) {
					String obID = lineaJunio[0];
					int objectID = Integer.parseInt(obID);
					String address = lineaJunio[3];
					String streetSegID = lineaJunio[4];
					String fine = lineaJunio[8];
					int fineAmt = Integer.parseInt(fine);
					String total = lineaJunio[9];
					int totalPaid = Integer.parseInt(total);
					String p1 = lineaJunio[10];
					int penalty1 = Integer.parseInt(p1);
					String p2 = lineaJunio[11];
					int penalty2 = 0;
					if(!p2.equals("")){
						penalty2 = Integer.parseInt(p2);
					}
					else{
						penalty2 = 0;
					}
					String accidentIndicator = lineaJunio[12];
					String issueDate = lineaJunio[13];
					String violationCode = lineaJunio[14];
					String violationDesc = lineaJunio[15];

					pila.push(new VOMovingViolations(objectID, issueDate, violationCode, fineAmt, address, streetSegID,
							totalPaid, violationDesc, accidentIndicator, penalty1, penalty2));

				}
				lectorJunio.close();
				
				CSVReader lectorJulio = new CSVReader(new FileReader(rutaJulio));
				String[] lineaJulio = lectorJulio.readNext();
				while ((lineaMayo = lectorJulio.readNext()) != null) {
					String obID = lineaJulio[0];
					int objectID = Integer.parseInt(obID);
					String address = lineaJulio[3];
					String streetSegID = lineaJulio[4];
					String fine = lineaJulio[8];
					int fineAmt = Integer.parseInt(fine);
					String total = lineaJulio[9];
					int totalPaid = Integer.parseInt(total);
					String p1 = lineaJulio[10];
					int penalty1 = Integer.parseInt(p1);
					String p2 = lineaJulio[11];
					int penalty2 = 0;
					if(!p2.equals("")){
						penalty2 = Integer.parseInt(p2);
					}
					else{
						penalty2 = 0;
					}
					String accidentIndicator = lineaJulio[12];
					String issueDate = lineaJulio[13];
					String violationCode = lineaJulio[14];
					String violationDesc = lineaJulio[15];

					pila.push(new VOMovingViolations(objectID, issueDate, violationCode, fineAmt, address, streetSegID,
							totalPaid, violationDesc, accidentIndicator, penalty1, penalty2));

				}
				lectorJulio.close();
				
				CSVReader lectorAgosto = new CSVReader(new FileReader(rutaAgosto));
				String[] lineaAgosto = lectorAgosto.readNext();
				while ((lineaAgosto = lectorAgosto.readNext()) != null) {
					String obID = lineaAgosto[0];
					int objectID = Integer.parseInt(obID);
					String address = lineaAgosto[3];
					String streetSegID = lineaAgosto[4];
					String fine = lineaAgosto[8];
					int fineAmt = Integer.parseInt(fine);
					String total = lineaAgosto[9];
					int totalPaid = Integer.parseInt(total);
					String p1 = lineaAgosto[10];
					int penalty1 = Integer.parseInt(p1);
					String p2 = lineaAgosto[11];
					int penalty2 = 0;
					if(!p2.equals("")){
						penalty2 = Integer.parseInt(p2);
					}
					else{
						penalty2 = 0;
					}
					String accidentIndicator = lineaAgosto[12];
					String issueDate = lineaAgosto[13];
					String violationCode = lineaAgosto[14];
					String violationDesc = lineaAgosto[15];

					pila.push(new VOMovingViolations(objectID, issueDate, violationCode, fineAmt, address, streetSegID,
							totalPaid, violationDesc, accidentIndicator, penalty1, penalty2));

				}
				lectorAgosto.close();
			}
			
			else if(numeroCuatrimestre == 3){
				CSVReader lectorSeptiembre = new CSVReader(new FileReader(rutaSeptiembre));
				String[] lineaSeptiembre = lectorSeptiembre.readNext();
				while ((lineaSeptiembre = lectorSeptiembre.readNext()) != null) {
					String obID = lineaSeptiembre[0];
					int objectID = Integer.parseInt(obID);
					String address = lineaSeptiembre[3];
					String streetSegID = lineaSeptiembre[4];
					String fine = lineaSeptiembre[8];
					int fineAmt = Integer.parseInt(fine);
					String total = lineaSeptiembre[9];
					int totalPaid = Integer.parseInt(total);
					String p1 = lineaSeptiembre[10];
					int penalty1 = Integer.parseInt(p1);
					String p2 = lineaSeptiembre[11];
					int penalty2 = 0;
					if(!p2.equals("")){
						penalty2 = Integer.parseInt(p2);
					}
					else{
						penalty2 = 0;
					}
					String accidentIndicator = lineaSeptiembre[12];
					String issueDate = lineaSeptiembre[13];
					String violationCode = lineaSeptiembre[14];
					String violationDesc = lineaSeptiembre[15];

					pila.push(new VOMovingViolations(objectID, issueDate, violationCode, fineAmt, address, streetSegID,
							totalPaid, violationDesc, accidentIndicator, penalty1, penalty2));

				}
				lectorSeptiembre.close();
			}
			
			CSVReader lectorOctubre = new CSVReader(new FileReader(rutaOctubre));
			String[] lineaOctubre = lectorOctubre.readNext();
			while ((lineaOctubre = lectorOctubre.readNext()) != null) {
				String obID = lineaOctubre[0];
				int objectID = Integer.parseInt(obID);
				String address = lineaOctubre[3];
				String streetSegID = lineaOctubre[4];
				String fine = lineaOctubre[8];
				int fineAmt = Integer.parseInt(fine);
				String total = lineaOctubre[9];
				int totalPaid = Integer.parseInt(total);
				String p1 = lineaOctubre[10];
				int penalty1 = Integer.parseInt(p1);
				String p2 = lineaOctubre[11];
				int penalty2 = 0;
				if(!p2.equals("")){
					penalty2 = Integer.parseInt(p2);
				}
				else{
					penalty2 = 0;
				}
				String accidentIndicator = lineaOctubre[12];
				String issueDate = lineaOctubre[13];
				String violationCode = lineaOctubre[14];
				String violationDesc = lineaOctubre[15];

				pila.push(new VOMovingViolations(objectID, issueDate, violationCode, fineAmt, address, streetSegID,
						totalPaid, violationDesc, accidentIndicator, penalty1, penalty2));

			}
			lectorOctubre.close();
		
			CSVReader lectorNoviembre = new CSVReader(new FileReader(rutaNoviembre));
			String[] lineaNoviembre = lectorNoviembre.readNext();
			while ((lineaNoviembre = lectorNoviembre.readNext()) != null) {
				String obID = lineaNoviembre[0];
				int objectID = Integer.parseInt(obID);
				String address = lineaNoviembre[3];
				String streetSegID = lineaNoviembre[4];
				String fine = lineaNoviembre[8];
				int fineAmt = Integer.parseInt(fine);
				String total = lineaNoviembre[9];
				int totalPaid = Integer.parseInt(total);
				String p1 = lineaNoviembre[10];
				int penalty1 = Integer.parseInt(p1);
				String p2 = lineaNoviembre[11];
				int penalty2 = 0;
				if(!p2.equals("")){
					penalty2 = Integer.parseInt(p2);
				}
				else{
					penalty2 = 0;
				}
				String accidentIndicator = lineaNoviembre[12];
				String issueDate = lineaNoviembre[13];
				String violationCode = lineaNoviembre[14];
				String violationDesc = lineaNoviembre[15];

				pila.push(new VOMovingViolations(objectID, issueDate, violationCode, fineAmt, address, streetSegID,
						totalPaid, violationDesc, accidentIndicator, penalty1, penalty2));

			}
			lectorNoviembre.close();
			
			CSVReader lectorDiciembre = new CSVReader(new FileReader(rutaDiciembre));
			String[] lineaDiciembre = lectorDiciembre.readNext();
			while ((lineaDiciembre = lectorDiciembre.readNext()) != null) {
				String obID = lineaDiciembre[0];
				int objectID = Integer.parseInt(obID);
				String address = lineaDiciembre[3];
				String streetSegID = lineaDiciembre[4];
				String fine = lineaDiciembre[8];
				int fineAmt = Integer.parseInt(fine);
				String total = lineaDiciembre[9];
				int totalPaid = Integer.parseInt(total);
				String p1 = lineaDiciembre[10];
				int penalty1 = Integer.parseInt(p1);
				String p2 = lineaDiciembre[11];
				int penalty2 = 0;
				if(!p2.equals("")){
					penalty2 = Integer.parseInt(p2);
				}
				else{
					penalty2 = 0;
				}
				String accidentIndicator = lineaDiciembre[12];
				String issueDate = lineaDiciembre[13];
				String violationCode = lineaDiciembre[14];
				String violationDesc = lineaDiciembre[15];

				pila.push(new VOMovingViolations(objectID, issueDate, violationCode, fineAmt, address, streetSegID,
						totalPaid, violationDesc, accidentIndicator, penalty1, penalty2));

			}
			lectorDiciembre.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public IQueue <VODaylyStatistic> getDailyStatistics () {
		return null;
	}

	public IStack <VOMovingViolations> nLastAccidents(int n) {
		return null;
	}

	public boolean verifyObjectIDIsUnique() {
		return false;
	}

	public IQueue<VOMovingViolations> getMovingViolationsInRange(LocalDateTime fechaInicial,
			LocalDateTime fechaFinal) {
		// TODO Auto-generated method stub
		return null;
	}

	public double[] avgFineAmountByViolationCode(String violationCode3) {
		return new double [] {0.0 , 0.0};
	}

	public IStack<VOMovingViolations> getMovingViolationsAtAddressInRange(String addressId,
			LocalDate fechaInicial, LocalDate fechaFinal) {
		// TODO Auto-generated method stub
		return null;
	}

	public IQueue<VOViolationCode> violationCodesByFineAmt(double limiteInf5, double limiteSup5) {
		// TODO Auto-generated method stub
		return null;
	}

	public IStack<VOMovingViolations> getMovingViolationsByTotalPaid(double limiteInf6, double limiteSup6,
			boolean ascendente6) {
		// TODO Auto-generated method stub
		return null;
	}

	public IQueue<VOMovingViolations> getMovingViolationsByHour(int horaInicial7, int horaFinal7) {
		// TODO Auto-generated method stub
		return null;
	}

	public double[] avgAndStdDevFineAmtOfMovingViolation(String violationCode8) {
		// TODO Auto-generated method stub
		return new double [] {0.0 , 0.0};
	}

	public int countMovingViolationsInHourRange(int horaInicial9, int horaFinal9) {
		// TODO Auto-generated method stub
		return 0;
	}

	public double totalDebt(LocalDate fechaInicial11, LocalDate fechaFinal11) {
		// TODO Auto-generated method stub
		return 0;
	}


	/**
	 * Convertir fecha a un objeto LocalDate
	 * @param fecha fecha en formato dd/mm/aaaa con dd para dia, mm para mes y aaaa para agno
	 * @return objeto LD con fecha
	 */
	private static LocalDate convertirFecha(String fecha)
	{
		return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}


	/**
	 * Convertir fecha y hora a un objeto LocalDateTime
	 * @param fecha fecha en formato dd/mm/aaaaTHH:mm:ss con dd para dia, mm para mes y aaaa para agno, HH para hora, mm para minutos y ss para segundos
	 * @return objeto LDT con fecha y hora integrados
	 */
	private static LocalDateTime convertirFecha_Hora_LDT(String fechaHora)
	{
		return LocalDateTime.parse(fechaHora, DateTimeFormatter.ofPattern("dd/MM/yyyy'T'HH:mm:ss"));
	}
}
