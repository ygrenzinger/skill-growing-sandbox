package com.carbon.ecommerce.service;

import com.carbon.ecommerce.dao.ItemDao;
import com.carbon.ecommerce.domain.Item;
import com.carbon.ecommerce.exception.BusinessException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService extends SuperServiceImpl implements IItemService {
	
	public ItemService(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Autowired
	private ItemDao itemDao;

	@Transactional
	@Override
	public List<Item> findItem() throws BusinessException{
		List<Item> items = itemDao.findAllItems();
		if (items == null || items.isEmpty()){
			throw new BusinessException("Aucun article n'a ete trouvee");
		}
		return items;
	}

	@Transactional
	@Override
	public List<String> findSize() {
		return null;
	}

}
