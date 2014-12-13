package com.carbon.ecommerce.dao;

import java.util.List;

import com.carbon.ecommerce.domain.ReferenceSize;



public interface IReferenceSizeDao extends ISuperDAO {
	
	List<ReferenceSize> findSize();
}
