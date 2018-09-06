package com.cm.cryo.dto;

import java.util.List;

public class AppLoadDTO {
private List<CryoTankDTO> tanks;
private CryoTankDropDownAttributeDTO dropDownAttributes;
public List<CryoTankDTO> getTanks() {
	return tanks;
}
public void setTanks(List<CryoTankDTO> tanks) {
	this.tanks = tanks;
}
public CryoTankDropDownAttributeDTO getDropDownAttributes() {
	return dropDownAttributes;
}
public void setDropDownAttributes(CryoTankDropDownAttributeDTO dropDownAttributes) {
	this.dropDownAttributes = dropDownAttributes;
}

}
