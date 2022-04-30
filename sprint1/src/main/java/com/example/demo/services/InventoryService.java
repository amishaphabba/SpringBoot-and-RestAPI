package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Inventory;
import com.example.demo.repositories.InventoryRepository;

@Service
public class InventoryService {
	@Autowired
	InventoryRepository inventoryrepo;

	public String getProducts() {
		// TODO Auto-generated method stub
		List productlist = inventoryrepo.findAll();
		if(productlist.size()!=0) {
			return productlist.toString();
		}
		return "empty list";
	}

	public String getProductOnId(int product_id) {
		// TODO Auto-generated method stub
		if(inventoryrepo.existsById(product_id)){
			return inventoryrepo.getById(product_id).toString();
		}
		return "no product found with id "+product_id;	
	}

	public String addProduct(Inventory inventory) {
		// TODO Auto-generated method stub
		return "product added \n"+inventoryrepo.save(inventory).toString();
	}

	public String updateProduct(Inventory inventory, int product_id) {
		// TODO Auto-generated method stub
		if(inventoryrepo.existsById(product_id)) {
			return "product updated \n"+inventoryrepo.save(inventory).toString();
		}
		return "no product found with id "+product_id;																
	}

	public String deleteProduct(int product_id) {
		// TODO Auto-generated method stub
		if(inventoryrepo.existsById(product_id)) {
			 Inventory inventorydel = inventoryrepo.getById(product_id);
			 inventoryrepo.delete(inventorydel);
			 return "product deleted \n"+ inventorydel.toString();
		}
		return "no product found with id "+product_id;
	}

}
