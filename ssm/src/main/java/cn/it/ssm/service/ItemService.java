package cn.it.ssm.service;

import java.util.List;

import cn.it.ssm.po.Item;
import cn.it.ssm.po.QueryVo;

public interface ItemService {
	
	/**
	 * 1.查询全部商品列表数据
	 */
	List<Item> queryAllItems();
	
	/**
	 * 2.根据商品Id查询商品
	 */
	Item queryItemById(Integer id);
	
	/**
	 * 修改商品
	 */
	void updateItem(Item item);
	
	/**
	 * 搜索查询
	 */
	List<Item> queryItemByCondition(QueryVo queryVo);
}
