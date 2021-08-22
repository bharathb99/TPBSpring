package com.tp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tp.entity.FourWheeler;
import com.tp.entity.RentalTransport;
import com.tp.entity.TwoWheeler;

@Repository
@Transactional
public class RentalTransportDaoImpl implements RentalTransportDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void createFourWheeler(FourWheeler fourWheeler) {

		getSession().saveOrUpdate(fourWheeler);
		System.out.println("FourWheeler has been stored successfully in DB !");
	}
	
	@Override
	public void createTwoWheeler(TwoWheeler twoWheeler) {

		getSession().saveOrUpdate(twoWheeler);
		System.out.println("TwoWheeler has been stored successfully in DB !");
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RentalTransport> getAllRentalTransport() {

		Query query = getSession().createQuery("from RentalTransport rentalTransport ");
		List<RentalTransport> rentalTransportlist = query.list();
		System.out.println(rentalTransportlist);
		return rentalTransportlist;
	}

	@Override
	public List<RentalTransport> updateFourWheeler(FourWheeler fourWheeler) {

		getSession().saveOrUpdate(fourWheeler);
		System.out.println("FourWheeler has been updated successfully in DB !");
		return getAllRentalTransport();
	}
	
	@Override
	public List<RentalTransport> updateTwoWheeler(TwoWheeler twoWheeler) {

		getSession().saveOrUpdate(twoWheeler);
		System.out.println("TwoWheeler has been updated successfully in DB !");
		return getAllRentalTransport();
	}

	@Override
	public List<RentalTransport> deleteRentalTransport(int rtno) {
		  
		Query query = getSession().createQuery("delete from RentalTransport rentalTransport where rentTransID=:rtno");
		query.setParameter("rtno", rtno);
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted " + noofrows + " rows");
		}
		return getAllRentalTransport();
	}

	@Override
	public RentalTransport getRentalTransportById(int rtid) {
		Criteria c = getSession().createCriteria(RentalTransport.class);
		c.add(Restrictions.eq("rentTransID", rtid));
		RentalTransport rentalTransport = (RentalTransport)c.uniqueResult();
		System.out.println(rentalTransport);
		return rentalTransport; 

	}

	

}
