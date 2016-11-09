package in.javahome.inventry.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.javahome.inventry.entity.Item;
import in.javahome.inventry.repository.InventryRepository;
@Service
public class InventryService implements IInventryService {
	@Autowired
	private InventryRepository inventRepo;

	@Transactional
	public String addItem(Item item) {
		inventRepo.save(item);
		return "Success";
	}
}
