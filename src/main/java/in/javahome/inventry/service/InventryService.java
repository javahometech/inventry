package in.javahome.inventry.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import in.javahome.inventry.entity.Item;
import in.javahome.inventry.model.ItemModel;
import in.javahome.inventry.repository.InventryRepository;
import in.javahome.inventry.response.BaseResponse;
import in.javahome.inventry.response.ListResponse;

@Service
public class InventryService implements IInventryService {
	@Autowired
	public InventryRepository inventRepo;

	@Transactional
	public BaseResponse addItem(ItemModel item) {
		// check for existing item

		Item itmEntity = new Item();
		BeanUtils.copyProperties(item, itmEntity);
		
		Item existingItem = inventRepo.findByItemName(item.getItemName());
		if (existingItem != null) {
			int newCount = item.getItemCount() + existingItem.getItemCount();
			existingItem.setItemCount(newCount);
			inventRepo.save(existingItem);
		} else {
			inventRepo.save(itmEntity);
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

	public ListResponse findAllItems() {
		ListResponse resp = new ListResponse();
		resp.setCode(HttpStatus.OK.value());
		resp.setStatus("Success");
		List<Item> itemEntityList = inventRepo.findAll();
		List<ItemModel> itemModelList = new ArrayList<>();
		for (Item item : itemEntityList) {
			ItemModel itmModel = new ItemModel();
			BeanUtils.copyProperties(item, itmModel);
			itemModelList.add(itmModel);
		}
		resp.setItems(itemModelList);
		return resp;
	}

	@Override
	public BaseResponse findItem(Integer id) {
		BaseResponse resp = new BaseResponse();
		resp.setCode(HttpStatus.OK.value());
		resp.setStatus("Success");
		Item entity = inventRepo.findOne(id);
		ItemModel itmModel = new ItemModel();
		BeanUtils.copyProperties(entity, itmModel);
		resp.setData(itmModel);
		return resp;
	}
}
