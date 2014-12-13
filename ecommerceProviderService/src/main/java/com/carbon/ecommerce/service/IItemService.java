package com.carbon.ecommerce.service;

import java.util.List;

import com.carbon.ecommerce.domain.Item;
import com.carbon.ecommerce.domain.ReferenceSize;
import com.carbon.ecommerce.exception.BusinessException;


public interface IItemService {

	List<Item> findItem() throws BusinessException;
	
	List<ReferenceSize> findSize();
	
	// Methode bouchon car a ce jour on utilise une base embarquee
	void insertItems();
	
}
