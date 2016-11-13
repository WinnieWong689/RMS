package edu.nju.rms.dao;

import java.util.List;

import edu.nju.rms.model.TrackItem;

public interface TrackItemDao {
	
	public int addTrackItem(TrackItem item);

	public List<TrackItem> getTrackItemsByRiskId(int id);
	
}
