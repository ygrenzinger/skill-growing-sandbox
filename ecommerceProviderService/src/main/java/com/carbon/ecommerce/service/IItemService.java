package com.carbon.ecommerce.service;

import com.carbon.ecommerce.domain.Item;
import com.carbon.ecommerce.exception.BusinessException;

import java.util.List;


public interface IItemService {

	List<Item> findItem() throws BusinessException;
	
	List<String> findSize();
	
}
