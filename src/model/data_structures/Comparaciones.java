package model.data_structures;

import java.io.Serializable;
import model.vo.VOMovingViolations;

/**
 * 
 * 
 *
 */
public enum Comparaciones implements Serializable{
	VIOLATIONCODE("Codigo", new SerializableComparator<VOMovingViolations>() {
		/**
		 * 
		 */

		/**
		 * 
		 */
		private static final long serialVersionUID = 123L;

		/**
		 * Compara las dos canciones por su dificultad
		 */
		//TODO Cree y complete el m�todo compare, de acuerdo a la documentaci�n.
		@Override
		public int compare(VOMovingViolations o1, VOMovingViolations o2) {
			int comparacion=o1.darViolationCode().compareToIgnoreCase(o2.darViolationCode());
			if(comparacion<0)
				return -1;
			else if(comparacion>0)
				return 1;
			else return 0;

		}
	}),
	DATE("Fecha", new SerializableComparator<VOMovingViolations>() {
		/**
		 * 
		 */

		/**
		 * 
		 */
		private static final long serialVersionUID = 1456L;

		@Override
		public int compare(VOMovingViolations o1, VOMovingViolations o2) {
			// TODO Auto-generated method stub

			return o2.darFechaLocalDateTime().compareTo(o1.darFechaLocalDateTime());
		}




	}),
	HORA("Hora", new SerializableComparator<VOMovingViolations>() {
		/**
		 * 
		 */

		/**
		 * 
		 */
		private static final long serialVersionUID = 1456L;

		@Override
		public int compare(VOMovingViolations o1, VOMovingViolations o2) {
			// TODO Auto-generated method stub

			int c= o2.darFechaLocalDateTime().getHour()-o1.darFechaLocalDateTime().getHour();
			if(c<0)
				return -1;
			else if(c>0)
			{
				return 1;
			}
			else
				return 0;
		}




	}),
	STREETID("StreetId", new SerializableComparator<VOMovingViolations>() {

		/**
		 * 
		 */
		/**
		 * 
		 */
		private static final long serialVersionUID = 1789L;
		@Override
		public int compare(VOMovingViolations o1, VOMovingViolations o2) {
			// TODO Auto-generated method stub
			return o1.darIDCalle().compareToIgnoreCase(o2.darIDCalle());

		}
		/**
		 * Compara las canciones por su nombre.
		 */

	}),
	VIOLATIONDESCRIPTION("ViolationDescription", new SerializableComparator<VOMovingViolations>() {

		/**
		 * 
		 */

		/**
		 * 
		 */
		private static final long serialVersionUID = 1789L;
		@Override
		public int compare(VOMovingViolations o1, VOMovingViolations o2) {
			// TODO Auto-generated method stub
			return o1.darDescripcion().compareToIgnoreCase(o2.darDescripcion());
		}
		/**
		 * Compara las canciones por su nombre.
		 */

	});

	/**
	 * Nombre para mostrarle al usuario del nombre del criterio de comparaci�n.
	 */
	public String nombre;

	/**
	 * Criterio de comparaci�n del elemento de la enumeraci�n.
	 */
	public SerializableComparator<VOMovingViolations> comparador;

	/**
	 * Constructor del enum. Asigna el nombre y el comparador.
	 * @param nombre Nombre para mostrarle al usuario.
	 * @param comparador Comparador del elemento del enum.
	 */
	private Comparaciones(String nombre, SerializableComparator<VOMovingViolations> comparador) 
	{
		this.nombre = nombre;
		this.comparador = comparador;
	}

	@Override
	public String toString() 
	{
		return nombre;
	}
}
