package com.sunRays.dao;

import java.util.List;

import com.sunRays.bean.MenuItemDto;

public interface MenuItemDao {
		MenuItemDto get(Integer menuId);
		List <MenuItemDto>  getMenuItemList();
		void update(MenuItemDto menuItem);
		void delete(MenuItemDto menuItem);

}