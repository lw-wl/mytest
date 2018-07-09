package cn.it.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.it.ssm.po.Item;
import cn.it.ssm.po.QueryVo;
import cn.it.ssm.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	/*@RequestMapping("/queryItem.do")
	public ModelAndView queryItem() {

		ModelAndView mav = new ModelAndView();
		
		List<Item> itemList = itemService.queryAllItems();

		mav.addObject("itemList", itemList);

		// 3.响应商品列表页面
		mav.setViewName("item/itemList");

		return mav;
	}*/
	
	/*@RequestMapping("/queryItemById.do")
	public ModelAndView queryItemById(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		
		String id = request.getParameter("id");
		
		Item item = itemService.queryItemById(Integer.parseInt(id));

		mav.addObject("item", item);

		// 3.响应商品列表页面
		mav.setViewName("item/itemEdit");

		return mav;
	}*/
	
	/*@RequestMapping("/queryItemById.do")
	public String queryItemById(Model model, HttpServletRequest request) {

		String id = request.getParameter("id");
		
		Item item = itemService.queryItemById(Integer.parseInt(id));

		model.addAttribute("item", item);

		return "item/itemEdit";
	}*/
	
	@RequestMapping("/queryItemById.do")
	public String queryItemById(Model model,/*@RequestParam(value = "itemId", defaultValue = "2")*/ Integer id) {

		Item item = itemService.queryItemById(id);

		model.addAttribute("item", item);

		return "item/itemEdit";
	}
	
	/**
	 * 修改商品
	 */
	@RequestMapping("/updateItem.do")
	public String updateItem(Item item) {
		
		try {
			itemService.updateItem(item);
			
		} catch (Exception e) {
			e.printStackTrace();
			return "common/failure";
		}
		return "common/success";
	}
	
	/**
	 * 搜索商品
	 */
	@RequestMapping("/queryItem.do")
	public ModelAndView queryItem(QueryVo queryVo){
		
		// System.out.println(queryVo.getItem().getName());
		
		// 1.创建ModelAndView
		ModelAndView mav = new ModelAndView();
		
		// 2.响应商品列表数据
		// 查询数据库中的商品数据，替换静态的商品数据
		List<Item> itemList = itemService.queryAllItems();
		
		mav.addObject("itemList", itemList);
		
		// 3.响应商品列表页面
		mav.setViewName("item/itemList");
		
		
		return mav;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
