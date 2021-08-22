package com.tp.dao;

import java.util.List;

import com.tp.entity.FourWheeler;
import com.tp.entity.RentalTransport;
import com.tp.entity.TwoWheeler;

public interface RentalTransportDao {
	
	public void createFourWheeler(FourWheeler fourWheeler);
	public void createTwoWheeler(TwoWheeler twoWheeler);
	public List<RentalTransport> getAllRentalTransport();
	public List<RentalTransport> updateFourWheeler(FourWheeler fourWheeler);
	public List<RentalTransport> updateTwoWheeler(TwoWheeler twoWheeler);
	public List<RentalTransport> deleteRentalTransport(int rtno);
	
	public RentalTransport getRentalTransportById(int rtid);
	


}
