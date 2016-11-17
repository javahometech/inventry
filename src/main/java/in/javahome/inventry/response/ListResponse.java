package in.javahome.inventry.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import in.javahome.inventry.entity.Item;

@XmlRootElement
@XmlSeeAlso({Item.class})
public class ListResponse extends BaseResponse{
 private List<?> items;

public List<?> getItems() {
	return items;
}

public void setItems(List<?> items) {
	this.items = items;
}
 
}
