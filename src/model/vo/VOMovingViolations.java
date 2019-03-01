package model.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Representation of a Trip object
 */
public class VOMovingViolations implements Comparable<VOMovingViolations>{

	/**
	 * Atributo que da el ID de la infracci�n
	 */
	private int objectID;

	/**
	 * Atributo que da la ubicaci�n de la infracci�n
	 */
	private String addressID;

	/**
	 * Atributo que da el identificador del segmento de calle donde hubo infraccion.
	 */
	private String streetSegID;

	/**
	 * Atributo que da el total a pagar por infracci�n (FINEAMT)
	 */
	private int fineAMT;

	/**
	 * Atributo que da el dinero que efectivamente se pag� por infracci�n (TOALPAID)
	 */
	private int totalPaid;

	/**
	 * Atributo que da el dinero extra a pagar por infracci�n (penalty1)
	 */
	private int penalty1;

	/**
	 * Atributo que da el dinero extra a pagar por infracci�n (penalty2)
	 */
	private int penalty2;

	/**
	 * Atributo que da si hubo accidente o no
	 */
	private String accidentIndicator;

	/**
	 * Atributo que da la fecha de la infracci�n
	 */
	private String ticketIssueDate;

	/**
	 * Atributo que da el tipo de infracci�n
	 */
	private String violationCode;

	/**
	 * Atributo que da la descripci�n de la infracci�n
	 */
	private String violationDescription;

	/**
	 * Constructor VOMovingViolations
	 * @param pObjectId identificador de la infracci�n
	 * @param pIssueDate fecha de la infracci�n
	 * @param pViolationCode tipo de infracci�n
	 * @param pFineAMT dinero a pagar por la infracci�n
	 * @param pAddress direccion de la infracci�n
	 * @param pStreetSegId identificador de segmento de calle con infracci�n
	 * @param pTotalPaid total que se pago efectivamente en la infracci�n
	 * @param pDescrption descripcion de la infracci�n
	 * @param pAccidentIndicator indica si hubo accidente o no en la infracci�n
	 * @param pPenal1 extra por infracci�n
	 * @param pPenal2 extra por infracci�n
	 */
	public VOMovingViolations(int pObjectId, String pIssueDate, String pViolationCode, int pFineAMT, String pAddress, String pStreetSegId, int pTotalPaid, String pDescrption, String pAccidentIndicator, int pPenal1, int pPenal2 ){
		
		objectID = pObjectId;
		addressID = pAddress;
		streetSegID = pStreetSegId;
		fineAMT = pFineAMT;
		totalPaid = pTotalPaid;
		penalty1 = pPenal1;
		penalty2 = pPenal2;
		accidentIndicator = pAccidentIndicator;
		ticketIssueDate = pIssueDate;
		violationCode = pViolationCode;
		violationDescription = pDescrption;

	}
	
	public int darObjectID(){
		return objectID;
	}
	
	public String darDireccion(){
		return addressID;
	}

	public String darIDCalle(){
		return streetSegID;
	}
	
	public int darFINEAMT(){
		return fineAMT;
	}
	
	public int darTotalPaid(){
		return totalPaid;
	}
	
	public int darPenal1(){
		return penalty1;
	}
	
	public int darPenal2(){
		return penalty2;
	}
	
	public String darAccidentIndicator(){
		return accidentIndicator;
	}
	
	public String darFecha(){
		return ticketIssueDate;
	}
	
	public String darViolationCode(){
		return violationCode;
	}
	
	public String darDescripcion(){
		return violationDescription;
	}

	@Override
	public int compareTo(VOMovingViolations o) {
			// TODO implementar la comparacion "natural" de la clase
		
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
			int comparacion = 0;
			try {
				Date fecha1 = formato.parse(ticketIssueDate);
				Date fecha2 = formato.parse(o.ticketIssueDate);
				comparacion = fecha1.compareTo(fecha2);

			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(comparacion < 0){
				comparacion =  -1;
			}
			
			else if(comparacion > 0){
				comparacion =  1;
			}
			
			else if(comparacion == 0){
				if(this.objectID < o.objectID){
					comparacion =   -1;
				}
				else if(this.objectID > o.objectID){
					comparacion = 1;
				}
				
				else if(this.objectID == o.objectID){
					comparacion =  0;
				}
			}
			return comparacion;
		}

}
