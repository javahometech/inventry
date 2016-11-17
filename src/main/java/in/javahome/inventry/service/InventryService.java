package in.javahome.inventry.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import in.javahome.inventry.entity.Item;
import in.javahome.inventry.repository.InventryRepository;
import in.javahome.inventry.response.BaseResponse;
import in.javahome.inventry.response.ListResponse;

@Service
public class InventryService implements IInventryService {
	@Autowired
	private InventryRepository inventRepo;

	@Transactional
	public BaseResponse addItem(Item item) {
		// check for existing item
		Item existingItem = inventRepo.findByItemName(item.getItemName());
		if (existingItem != null) {
			int newCount = item.getItemCount() + existingItem.getItemCount();
			existingItem.setItemCount(newCount);
			inventRepo.save(existingItem);
		} else {
			inventRepo.save(item);
		}
		BaseResponse resp = new BaseResponse();
		resp.setCode(HttpStatus.OK.value());
		resp.setStatus("Success");
		return resp;
	}

	@Override
	public BaseResponse deleteItem(Integer itemId) {
		inventRepo.delete(itemId);
		BaseResponse resp = new BaseResponse();
		resp.setCode(HttpStatus.OK.value());
		resp.setStatus("Success");
		return resp;
	}
	
	public ListResponse findAllItems(){
		ListResponse resp = new ListResponse();
		resp.setCode(HttpStatus.OK.value());
		resp.setStatus("Success");
		resp.setItems(inventRepo.findAll());
		return resp;
	}

	@Override
	public BaseResponse findItem(Integer id) {
		BaseResponse resp = new BaseResponse();
		resp.setCode(HttpStatus.OK.value());
		resp.setStatus("Success");
		resp.setData(inventRepo.findOne(id));
		return resp;
	}
}
