package com.sunRays.service;

import java.util.List;

import com.sunRays.bean.MenuItemDto;

public interface MenuItemService {
		MenuItemDto get(Integer menuId);
		List <MenuItemDto>  getMenuItemList();
		void update(MenuItemDto menuItem);
		void delete(MenuItemDto menuItem);

}
