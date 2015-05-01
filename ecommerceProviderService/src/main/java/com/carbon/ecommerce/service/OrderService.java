package com.carbon.ecommerce.service;

import com.carbon.ecommerce.dao.OrderDao;
import com.carbon.ecommerce.dao.StockDao;
import com.carbon.ecommerce.domain.Client;
import com.carbon.ecommerce.domain.Item;
import com.carbon.ecommerce.domain.Size;
import com.carbon.ecommerce.exception.BusinessException;
import com.carbon.ecommerce.model.ItemDto;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService extends SuperServiceImpl implements IOrderService {
	
	@Autowired
	private StockDao stockDao;
	
	@Autowired
	private OrderDao orderDao;
	
	public OrderService(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Transactional
	@Override
	public void orderItem(List<ItemDto> itemDtos, Client client) throws BusinessException {
		 Map<Item, Integer>items = new HashMap<>();
		// Pour chaque item reservee, on va verifier qu'il y a du stock disponibles
		for (ItemDto item : itemDtos) {
			if (!stockDao.existStock(item.getItem(), item.getQuantity(), Size.S)) {
				throw new BusinessException("L'item dont l'id est " + item.getItem().getId() + " n'a plus de stock disponibles");
			}
			items.put(item.getItem(), item.getQuantity());
		}
		// Il y a du stock pour tous les items, on les enregistre donc.
		//orderDao.saveOrder(items, new Order(client), quantity);
	}
}
