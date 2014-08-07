package com.sunRays.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.sunRays.bean.MenuItemDto;
import com.sunRays.service.MenuItemService;


@Component
@Scope("prototype")
@Path("/menuItems")
public class MenuItemJSONProvider {
	 @Autowired
	 private MenuItemService menuItemService;
	 
	 
	 @GET
	 @Path("/get/{menuId}")
	 @Produces(MediaType.APPLICATION_JSON)
	 public MenuItemDto get(@PathParam ("menuId") String menuId){
		 MenuItemDto mi= null;
		 try{
			 if(menuId!=null && menuId.length()>0)
				 mi=menuItemService.get(Integer.parseInt(menuId));
		 } catch (IllegalArgumentException e) {
		      throw new WebApplicationException(Response.status(Status.BAD_REQUEST).entity( e.getMessage() ).build());
		 }
		 return mi;
	 }

	 @GET
	 @Path("/listMenu")
	 @Produces(MediaType.APPLICATION_JSON)
	 //@RequestMapping(value = "/listMenu", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	 //@ResponseBody
	 //@ResponseStatus(HttpStatus.OK)
	 public List<MenuItemDto> getMenuItemList(){
		 return menuItemService.getMenuItemList();
	 }
	 
	 //@RequestMapping(value = "/save", method = RequestMethod.POST)
	 @POST
	 @Path("/save")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @Produces(MediaType.APPLICATION_JSON)
	 public void update(MenuItemDto menuItem){
		 
		 menuItemService.update(menuItem);

//		ResponseBuilder builder = new ResponseBuilderImpl(); // Creates a ResponseBuilder
//		builder.header("content-type", "application/json");		// Sets the header of the return data
//		builder.status(Response.Status.OK);		// Sets the response code as a 200
//		builder.header("Access-Control-Allow-Origin", "*");		// Allows Cross Domain Requests from any origin
//		builder.entity(menuItem);		// Adds your result data to the Response
//		return builder.build();		// Creates the Response

	 }
	 
	 //@RequestMapping(value = "/delete", method = RequestMethod.POST)
	 @POST
	 @Path("/delete")
	 @Consumes(MediaType.APPLICATION_JSON)
	public void delete(MenuItemDto menuItem){
		 menuItemService.delete(menuItem);
	 }
	 
//	private MenuItem beanToModel(MenuItemDto menuItemDto){
//		MenuItem menuItem=new MenuItem();
//		if(menuItemDto.getMenuId()!=null && menuItemDto.getMenuId().length()>0)
//			menuItem.setMenuId(Integer.parseInt(menuItemDto.getMenuId()));
//		menuItem.setMenuName(menuItemDto.getMenuName());
//		menuItem.setCategory(menuItemDto.getCategory());
//		menuItem.setImageId(menuItemDto.getImageId());
//		return menuItem;
//	}
//	private MenuItemDto modelToBean(MenuItem menuItem){
//		MenuItemDto menuItemDto=new MenuItemDto();
//		menuItemDto.setMenuId(menuItem.getMenuId());
//		menuItemDto.setMenuName(menuItem.getMenuName());
//		menuItemDto.setCategory(menuItem.getCategory());
//		menuItemDto.setImageId(menuItem.getImageId());
//		return menuItem;
//	}

	 
}
