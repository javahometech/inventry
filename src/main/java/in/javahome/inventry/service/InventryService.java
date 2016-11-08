package in.javahome.inventry.service;

import org.springframework.beans.factory.annotation.Autowired;

import in.javahome.inventry.entity.Item;
import in.javahome.inventry.repository.InventryRepository;

public class InventryService implements IInventryService{
	@Autowired
	private InventryRepository inventRepo;
	public String addItem(Item item){
		inventRepo.save(item);
		return "Success";
	}
}
