package com.sunRays.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunRays.bean.MenuItemDto;
import com.sunRays.model.MenuItem;

@Repository("menuItemDao")
public class MenuItemDaoImpl implements MenuItemDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public MenuItemDto get(Integer menuId) {
		MenuItem menuItem=(MenuItem) sessionFactory.getCurrentSession().get(MenuItem.class, menuId);
		return modelToBean(menuItem);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MenuItemDto> getMenuItemList() {
		List<MenuItem> listMenuItem=(List<MenuItem>) sessionFactory.getCurrentSession().createCriteria(MenuItem.class).list();
		return listModelToBean(listMenuItem);
	}

	

	@Override
	public void update(MenuItemDto menuItem) {
		System.out.println("Calling saveOrUpdate");
		sessionFactory.getCurrentSession().saveOrUpdate(beanToModel(menuItem));
	}

	@Override
	public void delete(MenuItemDto menuItem) {
		//sessionFactory.getCurrentSession().createQuery("DELETE FROM menuitems WHERE empid = "+menuItem.getMenuId()).executeUpdate();
		sessionFactory.getCurrentSession().delete(beanToModel(menuItem));
		
	}

	private MenuItem beanToModel(MenuItemDto menuItemDto){
		MenuItem menuItem=new MenuItem();
		if(menuItemDto.getMenuId()!=null && menuItemDto.getMenuId().length()>0)
			menuItem.setMenuId(Integer.parseInt(menuItemDto.getMenuId()));
		menuItem.setMenuName(menuItemDto.getMenuName());
		menuItem.setCategory(menuItemDto.getCategory());
		menuItem.setImageId(menuItemDto.getImageId());
		return menuItem;
	}
	private MenuItemDto modelToBean(MenuItem menuItem){
		MenuItemDto menuItemDto=new MenuItemDto();
		menuItemDto.setMenuId(""+menuItem.getMenuId());
		menuItemDto.setMenuName(menuItem.getMenuName());
		menuItemDto.setCategory(menuItem.getCategory());
		menuItemDto.setImageId(menuItem.getImageId());
		return menuItemDto;
	}
	private List<MenuItemDto> listModelToBean(List<MenuItem> listMenuItem) {
		List<MenuItemDto> listMID=new ArrayList<MenuItemDto>();
		Iterator <MenuItem>itr=listMenuItem.iterator();
		while(itr.hasNext()){
			listMID.add(modelToBean(itr.next()));
		}
		return listMID;
	}
}
