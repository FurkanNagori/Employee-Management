package com.thinking.machine.hr.bl;
import com.thinking.machine.hr.dl.*;
import com.thinking.machine.hr.beans.*;
import java.util.*;
public class DesignationBl
{
	public List<DesignationBean> getAll()
	{
		List<DesignationBean> designations = new LinkedList<>();
		try
		{
			DesignationDAO designationDAO = new DesignationDAO();
			List<DesignationDTO> dlDesignations = designationDAO.getAll();
			DesignationBean designationBean;
			for(DesignationDTO desigantionDTO:dlDesignations)
			{
				designationBean = new DesignationBean();
				designationBean.setCode(desigantionDTO.getCode());
				designationBean.setTitle(desigantionDTO.getTitle());
				designations.add(designationBean);
			}
		}catch(DAOException daoException)
		{
			System.out.println(daoException.getMessage());
		}
			return designations; 
	}
}