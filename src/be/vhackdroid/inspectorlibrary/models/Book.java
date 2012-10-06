package be.vhackdroid.inspectorlibrary.models;

public class Book {
	
	protected int id;
	protected String titel;
	protected String barcode;
	protected boolean hired;
	protected String clue;
	protected int themeId;
	
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
	public String getBarcode() {
		return barcode;
	}
	/**
	 * @param barcode the barcode to set
	 */
	public void setBarcode(String barcode) {
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
	
	public String getClue(){
		return clue;
	}
	
	public void setClue(String clue){
		this.clue = clue;
	}
	
	public int getThemeId(){
		return themeId;
	}
	
	public void setThemeId(int themeId){
		this.themeId = themeId;
	}
}
