package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Inventory;
import com.example.demo.services.InventoryService;

@RestController
public class InventoryController {
	@Autowired
	InventoryService is;
	
    @GetMapping("/inventory")
	public String getProducts(){
		return is.getProducts();
	}
	
	@GetMapping("/inventory/{product_id}")
	public String getProductOnId(@PathVariable int product_id) {
		return is.getProductOnId(product_id);	
	}
	
	@PostMapping("/inventory")
	public String addProduct(@RequestBody Inventory inventory) {
		return is.addProduct(inventory);		
	}
	@PutMapping("/inventory/{product_id}")
	public String updateProduct(@RequestBody Inventory inventory,@PathVariable int product_id) {
		return is.updateProduct(inventory,product_id);
		
	}
	
	@DeleteMapping("/inventory/{product_id}")
	public String deleteProduct(@PathVariable int product_id ){
		return is.deleteProduct(product_id);
	}

}
