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

/**
 * The Class PackageDaoImpl.
 * @author Bharath
 */
@Repository
@Transactional
public class PackageDaoImpl implements PackageDao{
	
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Gets the session.
	 * @author Bharath
	 * @return the session
	 */
	protected Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Creates the package.
	 * 
	 * @author Bharath
	 * @param package the package
	 */
	@Override
	public void createPackage(Packages pack) {
		
		getSession().saveOrUpdate(pack);
		System.out.println("Package has been stored successfully in DB !");
	}

	/**
	 * Gets the package list.
	 * @author Bharath
	 * @return the package list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Packages> getAllPackages() {
		
		Query query = getSession().createQuery("from Packages pack");
		List<Packages> packlist = query.list();
		System.out.println(packlist);
		return packlist;
	}

	/**
	 * Update package.
	 * @author Bharath
	 * @param package This Param includes 
	 *                  the package object
	 * @return the list
	 */
	@Override
	public List<Packages> updatePackage(Packages pack) {
		
		getSession().saveOrUpdate(pack);
		System.out.println("Package has been updated successfully in DB !");
		return getAllPackages();
	}

	/**
	 * Delete package.
	 * @author Bharath
	 * @param pno This Param includes the
	 *           id of the customer to be deleted
	 * @return the package list
	 */
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

	/**
	 * Gets the package.
	 * @author Bharath
	 * @param pid This Param includes the
	 *           id of the package object to be retreived
	 * @return the package list
	 */
	@Override
	public Packages getPackageById(int pid) {
		
		Criteria c = getSession().createCriteria(Packages.class);
		c.add(Restrictions.eq("packageID", pid));
		Packages pack = (Packages)c.uniqueResult();
		System.out.println(pack);
		return pack; 
	}

	/**
	 * Gets the package list.
	 * @author Bharath
	 * @param min,max This Param includes the
	 *           range of costPerDay of the package object to be retreived
	 * @return the package list
	 */
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

	/**
	 * Gets the package list.
	 * @author Bharath
	 * @param min,max This Param includes the
	 *           range of hotelCostPerDay of the package object to be retreived
	 * @return the package list
	 */
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

	/**
	 * Gets the package list.
	 * @author Bharath
	 * @param location This Param includes the
	 *           location of the package object to be retreived
	 * @return the package list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Packages> SearchPackagesByLocation(String loc) {
		Query query = getSession().createQuery("from Packages pack where location=:loc");
		query.setParameter("loc", loc);
		List<Packages> packlist = query.list();
		System.out.println(packlist);
		return packlist;
	}
	
}
