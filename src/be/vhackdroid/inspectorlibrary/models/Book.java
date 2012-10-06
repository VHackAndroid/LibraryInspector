package be.vhackdroid.inspectorlibrary.models;

public class Book {
	
	public int id;
	public String titel;
	public int barcode;
	public boolean hired;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the titel
	 */
	public String getTitel() {
		return titel;
	}
	/**
	 * @param titel the titel to set
	 */
	public void setTitel(String titel) {
		this.titel = titel;
	}
	/**
	 * @return the barcode
	 */
	public int getBarcode() {
		return barcode;
	}
	/**
	 * @param barcode the barcode to set
	 */
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	/**
	 * @return the hired
	 */
	public boolean isHired() {
		return hired;
	}
	/**
	 * @param hired the hired to set
	 */
	public void setHired(boolean hired) {
		this.hired = hired;
	}
}
