package book.dao;

import java.util.List;
import java.util.Set;

import book.vo.Order;

public interface IOrderDAO extends IDAO<Order, Integer> {
	public List<Order> findAll(Set<Integer> key) throws Exception;

	public void doUpdateCount(Integer id) throws Exception ;
	public boolean doUpdateSth(Order vo) throws Exception ;
}