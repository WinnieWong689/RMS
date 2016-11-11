package edu.nju.rms.dao;

import edu.nju.rms.model.TriggerGroup;

public interface TriggerGroupDao {
	
	public boolean addTriggerGroup(TriggerGroup group);

	public boolean deleteTriggerGroupById(int id);
	
	public boolean updateTriggerGroup(TriggerGroup group);
	
	public TriggerGroup getTriggerGroupById(int id);
	
}
