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

import com.tp.entity.PackageBooking;

/**
 * The Class PackageBookingDaoImpl.
 * @author Dhanushya
 */
@Repository
@Transactional
public class PackageBookingDaoImpl implements PackageBookingDao {
	
	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Gets the session.
	 * 
	 * @return the session
	 */
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Creates the packagebooking.
	 * 
	 * @author Dhanushya
	 * @param customer the packagebooking
	 */
	@Override
	public void createPackageBooking(PackageBooking packBooking) {
		System.out.println(packBooking);
//		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//		
//		Date DiscountStartDate = new Date();
//		try {
//			DiscountStartDate = formatter.parse("25-08-2021");
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
//		Date DiscountEndDate = new Date();
//		try {
//			DiscountEndDate = formatter.parse("27-08-2021");
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		double discount = 0.10;
//		if(((packBooking.getBookingDate()).after(DiscountStartDate))&&((packBooking.getBookingDate()).before(DiscountEndDate))) {
//		packBooking.setPackageCost((((packBooking.getPack().getCostPerDay() + packBooking.getPack().getHotelCostPerDay())
//				* packBooking.getNoOfPeope() + packBooking.getRentTransport().getChargesPerDay())
//				* packBooking.getNoOfDays())*(1-discount));
//		}
//		else {
			packBooking.setPackageCost(((packBooking.getPack().getCostPerDay() + packBooking.getPack().getHotelCostPerDay())
					* packBooking.getNoOfPeope())
					* packBooking.getNoOfDays());
//		}
		getSession().saveOrUpdate(packBooking);
		System.out.println("PackageBooking has been stored successfully in DB !");
	}

	/**
	 * Gets the packagebooking list.
	 * 
	 * @author Dhanushya
	 * @return the packagebooking list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PackageBooking> getAllPackageBookings() {

		Query query = getSession().createQuery("from PackageBooking packBooking");
		List<PackageBooking> packBookinglist = query.list();
		System.out.println(packBookinglist);
		return packBookinglist;
	}

	/**
	 * Updates the packagebooking.
	 * 
	 * @author Dhanushya
	 * @return the packagebooking.
	 */
	@Override
	public List<PackageBooking> updatePackageBooking(PackageBooking packBooking) {

		packBooking.setPackageCost(((packBooking.getPack().getCostPerDay() + packBooking.getPack().getHotelCostPerDay())
				* packBooking.getNoOfPeope())* packBooking.getNoOfDays());
		getSession().saveOrUpdate(packBooking);
		System.out.println("Package has been updated successfully in DB !");
		return getAllPackageBookings();
	}

	/**
	 * Delete packagebooking.
	 * @author Dhanushya
	 * @param pbno the pbno
	 * @return the list
	 */
	@Override
	public List<PackageBooking> deletePackageBooking(int pbno) {

		Query query = getSession().createQuery("delete from PackageBooking packBooking where packBookID=:pbno");
		query.setParameter("pbno", pbno);
		int noofrows = query.executeUpdate();
		if (noofrows > 0) {
			System.out.println("Deleted " + noofrows + " rows");
		}
		return getAllPackageBookings();
	}

	/**
	 * Gets the packagebooking.
	 * 
	 * @author Dhanushya
	 * @param pbid the pbid
	 * @return the packagebooking
	 */
	@Override
	public PackageBooking getPackageBookingById(int pbid) {

		Criteria c = getSession().createCriteria(PackageBooking.class);
		c.add(Restrictions.eq("packBookID", pbid));
		PackageBooking packBooking = (PackageBooking) c.uniqueResult();
		System.out.println(packBooking);
		return packBooking;
	}

	/**
	 * Gets the packagebooking.
	 * @author Dhanushya
	 * @param cid the cid
	 * @return the packagebooking list.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<PackageBooking> getPackageBookingsByCId(int cid) {

		Query query = getSession().createQuery("from PackageBooking packBooking where customerid=:cid");
		query.setParameter("cid", cid);
		List<PackageBooking> packBookinglist = query.list();
		System.out.println(packBookinglist);
		return packBookinglist;
	}

}
