package com.cm.cryo.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Repository;

import com.cm.cryo.dto.CryoLabelDTO;
import com.cm.cryo.dto.CryoRoomDTO;
import com.cm.cryo.dto.CryoTankDropDownAttributeDTO;
import com.cm.cryo.dto.CryoTypeDTO;
import com.cm.cryo.helpers.CryoTankResultSetMapper;
import com.cm.cryo.idao.ICryoTankDropDownDAO;
import com.cm.cryo.util.CryoConstants;

@Repository
public class CryoTankDropDownDAO  extends StoredProcedure implements ICryoTankDropDownDAO{

public CryoTankDropDownDAO(DataSource dataSource,String sp1)
{
	super(dataSource,sp1);
	declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_ROOMS_RESULTSET,
			new CryoTankResultSetMapper.DropDownAttributeMapper<CryoRoomDTO>()));
	declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_TYPES_RESULTSET,
			new CryoTankResultSetMapper.DropDownAttributeMapper<CryoTypeDTO>()));
	declareParameter(new SqlReturnResultSet(CryoConstants.CRYO_LABELS_RESULTSET,
			new CryoTankResultSetMapper.DropDownAttributeMapper<CryoLabelDTO>()));
	compile();}

@Override
public CryoTankDropDownAttributeDTO getTankDropDownAttributes() {
	Map<String, Object> responseMap = this.execute();
	return createTankDropDownAttributeDTOFromResponseMap(responseMap);
}

@SuppressWarnings("unchecked")
private CryoTankDropDownAttributeDTO createTankDropDownAttributeDTOFromResponseMap(
		Map<String, Object> responseMap) {
	CryoTankDropDownAttributeDTO dropDownAttributeDTO = new CryoTankDropDownAttributeDTO();
	dropDownAttributeDTO.setRooms((List<CryoRoomDTO>) responseMap.get(CryoConstants.CRYO_ROOMS_RESULTSET));
	dropDownAttributeDTO.setTypes((List<CryoTypeDTO>) responseMap.get(CryoConstants.CRYO_TYPES_RESULTSET));
	dropDownAttributeDTO.setLabels((List<CryoLabelDTO>) responseMap.get(CryoConstants.CRYO_LABELS_RESULTSET));
	return dropDownAttributeDTO;
}

}
