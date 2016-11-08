package in.javahome.inventry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.javahome.inventry.entity.Item;
import in.javahome.inventry.service.IInventryService;

@RestController
public class InventryController {
	@Autowired
	private IInventryService stdservice;

	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String addItem(@RequestBody Item item) {
		return stdservice.addItem(item);
	}
}
