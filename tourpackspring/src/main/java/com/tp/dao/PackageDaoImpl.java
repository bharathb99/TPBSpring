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

import com.tp.entity.Packages;

@Repository
@Transactional
public class PackageDaoImpl implements PackageDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void createPackage(Packages pack) {
		
		getSession().saveOrUpdate(pack);
		System.out.println("Package has been stored successfully in DB !");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Packages> getAllPackages() {
		
		Query query = getSession().createQuery("from Packages pack");
		List<Packages> packlist = query.list();
		System.out.println(packlist);
		return packlist;
	}

	@Override
	public List<Packages> updatePackage(Packages pack) {
		
		getSession().saveOrUpdate(pack);
		System.out.println("Package has been updated successfully in DB !");
		return getAllPackages();
	}

	@Override
	public List<Packages> deletePackage(int pno) {
		
		Query query = getSession().createQuery("delete from Packages pack where packageid=:pno");
		query.setParameter("pno", pno);
		int noofrows = query.executeUpdate();
		if(noofrows >0)
		{
			System.out.println("Deleted " + noofrows + " rows");
		}
		return getAllPackages();
	}

	@Override
	public Packages getPackageById(int pid) {
		
		Criteria c = getSession().createCriteria(Packages.class);
		c.add(Restrictions.eq("packageID", pid));
		Packages pack = (Packages)c.uniqueResult();
		System.out.println(pack);
		return pack; 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Packages> SortPackagesByCostPerDay(double min, double max) {
		Query query = getSession().createQuery("from Packages pack where costperday between :min and :max");
		query.setParameter("min", min);
		query.setParameter("max", max);
		List<Packages> packlist = query.list();
		System.out.println(packlist);
		return packlist;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Packages> SortPackagesByHotelCostPerDay(double min, double max) {
		Query query = getSession().createQuery("from Packages pack where hotelCostPerDay between :min and :max");
		query.setParameter("min", min);
		query.setParameter("max", max);
		List<Packages> packlist = query.list();
		System.out.println(packlist);
		return packlist;
	}
	
}
