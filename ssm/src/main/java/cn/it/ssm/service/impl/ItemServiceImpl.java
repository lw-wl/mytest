package cn.it.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.it.ssm.mapper.ItemMapper;
import cn.it.ssm.po.Item;
import cn.it.ssm.po.QueryVo;
import cn.it.ssm.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemMapper itemMapper;
	
	/**
	 * 1.查询全部商品列表数据
	 */
	public List<Item> queryAllItems() {
		List<Item> list = itemMapper.selectByExample(null);
		return list;
	}

	/**
	 * 2.根据商品Id查询商品
	 */
	public Item queryItemById(Integer id) {
		Item item = itemMapper.selectByPrimaryKey(id);
		return item;
	}

	/**
	 * 修改商品
	 */
	public void updateItem(Item item) {
		itemMapper.updateByPrimaryKeySelective(item);
	}

	/**
	 * 搜索查询
	 */
	public List<Item> queryItemByCondition(QueryVo queryVo) {
		return null;
	}

}
