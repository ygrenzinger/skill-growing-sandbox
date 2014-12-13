package com.carbon.ecommerce.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.carbon.ecommerce.domain.ReferenceSize;

@Repository
public class ReferenceSizeDao extends SuperDAOImpl implements IReferenceSizeDao {

	public ReferenceSizeDao(){
		super();
	}

	@Override
	public List<ReferenceSize> findSize() {
		Query query = createQuery("from ReferenceSize");
		return (List<ReferenceSize>) query.list();
	}
}
