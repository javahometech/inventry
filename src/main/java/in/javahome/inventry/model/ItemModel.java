package in.javahome.inventry.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@XmlRootElement
public class ItemModel implements Serializable{

	@NotEmpty(message="Item Name is mandatory")
	@Length(min=3,message="Item name must contain minimum 3 characters")
	private String itemName;
	private Integer itemCount;
	private Double price;

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getItemCount() {
		return itemCount;
	}
	public void setItemCount(Integer itemCount) {
		this.itemCount = itemCount;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
