package in.javahome.inventry.service;

import in.javahome.inventry.model.ItemModel;
import in.javahome.inventry.response.BaseResponse;
import in.javahome.inventry.response.ListResponse;

public interface IInventryService {
	public BaseResponse addItem(ItemModel item);
	public BaseResponse deleteItem(Integer itemId);
	public ListResponse findAllItems();
	public BaseResponse findItem(Integer id);
}
