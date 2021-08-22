package com.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tp.dao.RentalTransportDao;
import com.tp.entity.FourWheeler;
import com.tp.entity.RentalTransport;
import com.tp.entity.TwoWheeler;

@Service
@Transactional
public class RentalTransportServiceImpl implements RentalTransportService{
	
	@Autowired
	RentalTransportDao rentalTransportDao;

	@Override
	public void createFourWheeler(FourWheeler fourWheeler) {

		rentalTransportDao.createFourWheeler(fourWheeler);
		
	}

	@Override
	public void createTwoWheeler(TwoWheeler twoWheeler) {

		rentalTransportDao.createTwoWheeler(twoWheeler);
		
	}
	
	@Override
	public List<RentalTransport> getAllRentalTransport() {
		
		return rentalTransportDao.getAllRentalTransport();
	}

	
	@Override
	public List<RentalTransport> updateFourWheeler(FourWheeler fourWheeler) {

		return rentalTransportDao.updateFourWheeler(fourWheeler);
	}
	
	@Override
	public List<RentalTransport> updateTwoWheeler(TwoWheeler twoWheeler) {

		return rentalTransportDao.updateTwoWheeler(twoWheeler);
	}

	@Override
	public List<RentalTransport> deleteRentalTransport(int rtno) {

		return rentalTransportDao.deleteRentalTransport(rtno);
	}

	@Override
	public RentalTransport getRentalTransportById(int rtid) {

		return rentalTransportDao.getRentalTransportById(rtid);
	}

}