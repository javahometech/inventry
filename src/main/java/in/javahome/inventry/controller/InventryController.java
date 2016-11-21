package in.javahome.inventry.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.javahome.inventry.model.ItemModel;
import in.javahome.inventry.response.BaseResponse;
import in.javahome.inventry.response.ListResponse;
import in.javahome.inventry.service.IInventryService;

@RestController
public class InventryController {
	@Autowired
	private IInventryService stdservice;

	@RequestMapping(value = "/item", method = RequestMethod.POST)
	public BaseResponse addItem(@Valid @RequestBody ItemModel item, BindingResult result) {
		if (result.hasErrors()) {
			List<FieldError> fieldErrors = result.getFieldErrors();
			StringBuilder errorMsgs = new StringBuilder();
			for (FieldError fieldError : fieldErrors) {
				errorMsgs.append(fieldError.getDefaultMessage()+" \t");
			}
			BaseResponse resp = new BaseResponse();
			resp.setStatus("Error");
			resp.setCode(HttpStatus.BAD_REQUEST.value());
			resp.setErrMessage(errorMsgs.toString());
			return resp;
		}
		return stdservice.addItem(item);
	}

	@RequestMapping(value = "/item", method = RequestMethod.DELETE)
	public BaseResponse deleteItem(@RequestParam(name = "itemId", required = false) Integer itemId) {
		return stdservice.deleteItem(itemId);
	}

	@RequestMapping(value = "/item/{id}", method = RequestMethod.GET, produces = { "application/json",
			"application/xml" })
	public BaseResponse getItem(@PathVariable("id") Integer id) {
		BaseResponse resp = stdservice.findItem(id);
		return resp;
	}

	@RequestMapping(value = "/items", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public ListResponse getAllItems() {
		return stdservice.findAllItems();
	}
}
