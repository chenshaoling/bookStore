package book.dao;

import java.util.List;
import java.util.Set;

import book.vo.Member;
import book.vo.Product;

public interface IProductDAO extends IDAO<Product, Integer> {
	public List<Product> findAll(Set<Integer> key) throws Exception;

	public void doUpdateCount(Integer id) throws Exception ;

	public List<Product> findByType(String keyWord) throws Exception ;
	
}
