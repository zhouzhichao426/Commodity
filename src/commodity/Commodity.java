package commodity;

public class Commodity {
	private String id;
	private String name;
	private double price;   //¼ÛÇ®
	private int amount;		//ÊýÁ¿
	private String state;	//×´Ì¬
	public Commodity() {
		super();
	}
	public Commodity(String id, String name, double price, int amount, String state) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.state = state;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
