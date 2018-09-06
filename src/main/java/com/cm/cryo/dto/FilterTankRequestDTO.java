package com.cm.cryo.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FilterTankRequestDTO implements Serializable{
	private int roomId;
	private int typeId;
	private int labelId;
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public int getLabelId() {
		return labelId;
	}
	public void setLabelId(int labelId) {
		this.labelId = labelId;
	}
	
}
