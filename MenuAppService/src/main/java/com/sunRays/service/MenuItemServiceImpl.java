package com.sunRays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sunRays.bean.MenuItemDto;
import com.sunRays.dao.MenuItemDao;
import com.sunRays.model.MenuItem;

@Service("menuItemService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class MenuItemServiceImpl implements MenuItemService {

	@Autowired
	private MenuItemDao menuItemDao;
	
	public MenuItemDto get(Integer menuId) {
		return menuItemDao.get(menuId);
	}

	
	public List<MenuItemDto> getMenuItemList() {
		return menuItemDao.getMenuItemList();
	}

	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void update(MenuItemDto menuItem) {
		menuItemDao.update(menuItem);
	}

	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(MenuItemDto menuItem) {
		menuItemDao.delete(menuItem);
	}
	
	

}
