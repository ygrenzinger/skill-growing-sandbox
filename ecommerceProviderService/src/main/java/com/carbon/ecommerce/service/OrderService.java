package com.carbon.ecommerce.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carbon.ecommerce.exception.BusinessException;
import com.carbon.ecommerce.model.ItemDto;

@Service
public class OrderService extends SuperServiceImpl implements IOrderService {
	
	public OrderService(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Transactional
	@Override
	public void orderItem(List<ItemDto> items) throws BusinessException {
		// Pour chaque item reservee, on va verifier qu'il y a du stock disponible
		for (ItemDto item : items) {
			
		}
	}
}
