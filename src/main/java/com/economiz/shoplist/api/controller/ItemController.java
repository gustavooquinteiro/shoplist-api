package com.economiz.shoplist.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.economiz.shoplist.api.dto.ItemDTO;
import com.economiz.shoplist.domain.model.Item;
import com.economiz.shoplist.domain.service.ItemService;

@RestController
@RequestMapping("/itens")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@PostMapping
	public Item cadastrarItem(@RequestBody ItemDTO item) {
		return itemService.salvarItem(item);
	}
}
