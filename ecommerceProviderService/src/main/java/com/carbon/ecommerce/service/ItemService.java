package com.carbon.ecommerce.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carbon.ecommerce.dao.IITemDao;
import com.carbon.ecommerce.dao.IReferenceSizeDao;
import com.carbon.ecommerce.dao.IStockDao;
import com.carbon.ecommerce.domain.Item;
import com.carbon.ecommerce.domain.ReferenceSize;
import com.carbon.ecommerce.domain.Stock;
import com.carbon.ecommerce.exception.BusinessException;

@Service
public class ItemService extends SuperServiceImpl implements IItemService {
	
	public ItemService(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Autowired
	private IITemDao itemDao;
	
	@Autowired
	private IStockDao stockDao;
	
	@Autowired
	private IReferenceSizeDao referenceSizeDao;

	@Transactional
	@Override
	public List<Item> findItem() throws BusinessException{
		itemDao.setSession(getSession());
		List<Item> items = itemDao.findItem();
		if (items == null || items.isEmpty()){
			throw new BusinessException("Aucun article n'a ete trouvee");
		}
		return items;
	}

	@Transactional
	@Override
	public void insertItems() {
		itemDao.setSession(getSession());
		List<Stock> stocks = itemDao.insertItems();
		stockDao.setSession(getSession());
		List<Stock> stockResult = stockDao.insertStocks(stocks);
		itemDao.updateItemBouchon(stockResult);
	}

	@Transactional
	@Override
	public List<ReferenceSize> findSize() {
		referenceSizeDao.setSession(getSession());
		return referenceSizeDao.findSize();
	}

}
