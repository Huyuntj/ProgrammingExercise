public class RecipeItem {
	private String item;
	private String amount;
	private String unit;
	private String validDate;
	
	public RecipeItem(String item, String amount, String unit){
		this.item = item;
		this.amount = amount;
		this.unit = unit;
	}
	public RecipeItem(String item, String amount, String unit, String validDate){
		this.item = item;
		this.amount = amount;
		this.unit = unit;
		this.validDate = validDate;
	}
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getValidDate() {
		return validDate;
	}
	public void setValidDate(String validDate) {
		this.validDate = validDate;
	}
	
	public boolean match(RecipeItem item){
		return this.item.equalsIgnoreCase(item.getItem()) && (this.amount.compareTo(item.getAmount()) >= 0) 
				&& this.unit.equalsIgnoreCase(item.getUnit()) && (this.validDate.compareTo(item.getValidDate()) >= 0); 
	}
}
