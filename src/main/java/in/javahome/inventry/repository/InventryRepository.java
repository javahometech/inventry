package in.javahome.inventry.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.javahome.inventry.entity.Item;

@Repository
public interface InventryRepository extends JpaRepository<Item, Integer> {
	public Item findByItemName(String itemName);
}
