
public class VOMovingViolations {

	/**
	 * Atributo que da el ID de la infracci�n
	 */
	private int objectID;

	/**
	 * Atributo que da la ubicaci�n de la infracci�n
	 */
	private String addressID;

	/**
	 * Atributo que da la fecha de la infracci�n
	 */
	private String ticketIssueDate;

	/**
	 * Atributo que da el total a pagar por infracci�n (FINEAMT)
	 */
	private int fineAMT;

	/**
	 * Atributo que da si hubo accidente o no
	 */
	private String accidentIndicator;

	/**
	 * Atributo que da la descripci�n de la infracci�n
	 */
	private String violationDescription;

	/**
	 * Atributo que da el tipo de infracci�n
	 */
	private String violationCode;

	/**
	 * Atributo que da el dinero que efectivamente se pag� por infracci�n (TOALPAID)
	 */
	private int totalPaid;
	
	/**
	 * Atributo que da el identificador del segmento de calle donde hubo infraccion.
	 */
	private String streetSegID;
	
	/**
	 * Atributo que da el dinero extra a pagar por infracci�n (penalty1)
	 */
	private int penalty1;
	
	/**
	 * Atributo que da el dinero extra a pagar por infracci�n (penalty2)
	 */
	private int penalty2;
	
	/**
	 * Constructor
	 * @param pId id infracci�n
	 * @param pLoc ubicaci�n infracci�n
	 * @param pDate fecha infracci�n
	 * @param pTotal total a pagar por infracci�n
	 * @param pIndicator indicador de infracci�n
	 * @param pDescription descripcion de infracci�n
	 */
	public VOMovingViolations(int pId, String pLoc, String pDate, int pTotal, String pIndicator, String pDescription){

		id= pId;
		location = pLoc;
		date = pDate;
		total = pTotal;
		accidentIndicator = pIndicator;
		description = pDescription;
	}
	/**
	 * @return id - Identificador único de la infracción
	 */
	public int objectId() {

		return id;
	}	


	/**
	 * @return location - Dirección en formato de texto.
	 */
	public String getLocation() {

		return location;
	}

	/**
	 * @return date - Fecha cuando se puso la infracción .
	 */
	public String getTicketIssueDate() {

		return date;
	}

	/**
	 * @return FINEAMT - Cantidad a pagar po la infraccion en USD
	 */
	public int getFineAMT() {

		return total;
	}

	/**
	 * @return accidentIndicator - Si hubo un accidente o no.
	 */
	public String  getAccidentIndicator() {

		return accidentIndicator;
	}

	/**
	 * @return description - Descripción textual de la infracción.
	 */
	public String  getViolationDescription() {

		return description;
	}
}

}
