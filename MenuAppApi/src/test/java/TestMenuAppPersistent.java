import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sunRays.bean.MenuItemDto;

import com.sunRays.service.MenuItemService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/applicationContext.xml"})
public class TestMenuAppPersistent {
	@Autowired
	private MenuItemService menuItemService;
	
	@Test
	public void show() {
		Integer menuId=2; 
		MenuItemDto mid=menuItemService.get(menuId);
		System.out.println(mid.getMenuId());
		System.out.println(mid.getMenuName());
		System.out.println(mid.getCategory());
	}

}
