
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
	 * Atributo que da la fecha de la infracción
	 */
	private String ticketIssueDate;

	/**
	 * Atributo que da el total a pagar por infracción (FINEAMT)
	 */
	private int fineAMT;

	/**
	 * Atributo que da si hubo accidente o no
	 */
	private String accidentIndicator;

	/**
	 * Atributo que da la descripción de la infracción
	 */
	private String violationDescription;

	/**
	 * Atributo que da el tipo de infracción
	 */
	private String violationCode;

	/**
	 * Atributo que da el dinero que efectivamente se pagó por infracción (TOALPAID)
	 */
	private int totalPaid;
	
	/**
	 * Atributo que da el identificador del segmento de calle donde hubo infraccion.
	 */
	private String streetSegID;
	
	/**
	 * Atributo que da el dinero extra a pagar por infracción (penalty1)
	 */
	private int penalty1;
	
	/**
	 * Atributo que da el dinero extra a pagar por infracción (penalty2)
	 */
	private int penalty2;
	
	/**
	 * Constructor
	 * @param pId id infracción
	 * @param pLoc ubicación infracción
	 * @param pDate fecha infracción
	 * @param pTotal total a pagar por infracción
	 * @param pIndicator indicador de infracción
	 * @param pDescription descripcion de infracción
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
	 * @return id - Identificador Ãºnico de la infracciÃ³n
	 */
	public int objectId() {

		return id;
	}	


	/**
	 * @return location - DirecciÃ³n en formato de texto.
	 */
	public String getLocation() {

		return location;
	}

	/**
	 * @return date - Fecha cuando se puso la infracciÃ³n .
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
	 * @return description - DescripciÃ³n textual de la infracciÃ³n.
	 */
	public String  getViolationDescription() {

		return description;
	}
}

}
