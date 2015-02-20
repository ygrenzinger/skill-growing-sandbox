package com.carbon.ecommerce.service;

import java.util.List;

import com.carbon.ecommerce.domain.Client;
import com.carbon.ecommerce.exception.BusinessException;
import com.carbon.ecommerce.model.ItemDto;


public interface IOrderService {

	void orderItem(List<ItemDto> items, Client client) throws BusinessException ;
}
