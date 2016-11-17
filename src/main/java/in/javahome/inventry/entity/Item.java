package in.javahome.inventry.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="ITEMS")
@XmlRootElement
public class Item implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer itemId;
	@Column(name="ITEM_NAME")
	@NotEmpty(message="Item Name is mandatory")
	@Length(min=3,message="Item name must contain minimum 3 characters")
	private String itemName;
	@Column(name="ITEM_COUNT")
	private Integer itemCount;
	@Column(name="PRICE")
	private Double price;
	@Transient
	private String description;
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	
}
