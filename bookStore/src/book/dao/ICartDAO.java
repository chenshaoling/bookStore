package book.dao;

import java.util.List;

import java.util.Set;

import book.vo.Cart;

public interface ICartDAO extends IDAO<Cart, Integer> {
	public List<Cart> findAll(Set<Integer> key) throws Exception;

	public void doUpdateCount(Integer id) throws Exception ;
}