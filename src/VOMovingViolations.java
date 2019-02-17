
public class VOMovingViolations {

	/**
	 * Atributo que da el ID de la infracción
	 */
	private int objectID;

	/**
	 * Atributo que da la ubicación de la infracción
	 */
	private String addressID;

	/**
	 * Atributo que da el identificador del segmento de calle donde hubo infraccion.
	 */
	private String streetSegID;

	/**
	 * Atributo que da el total a pagar por infracción (FINEAMT)
	 */
	private int fineAMT;

	/**
	 * Atributo que da el dinero que efectivamente se pagó por infracción (TOALPAID)
	 */
	private int totalPaid;

	/**
	 * Atributo que da el dinero extra a pagar por infracción (penalty1)
	 */
	private int penalty1;

	/**
	 * Atributo que da el dinero extra a pagar por infracción (penalty2)
	 */
	private int penalty2;

	/**
	 * Atributo que da si hubo accidente o no
	 */
	private String accidentIndicator;

	/**
	 * Atributo que da la fecha de la infracción
	 */
	private String ticketIssueDate;

	/**
	 * Atributo que da el tipo de infracción
	 */
	private String violationCode;

	/**
	 * Atributo que da la descripción de la infracción
	 */
	private String violationDescription;

	/**
	 * Constructor VOMovingViolations
	 * @param pObjectId identificador de la infracción
	 * @param pIssueDate fecha de la infracción
	 * @param pViolationCode tipo de infracción
	 * @param pFineAMT dinero a pagar por la infracción
	 * @param pAddress direccion de la infracción
	 * @param pStreetSegId identificador de segmento de calle con infracción
	 * @param pTotalPaid total que se pago efectivamente en la infracción
	 * @param pDescrption descripcion de la infracción
	 * @param pAccidentIndicator indica si hubo accidente o no en la infracción
	 * @param pPenal1 extra por infracción
	 * @param pPenal2 extra por infracción
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
}
