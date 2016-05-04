package book.dao;

import java.util.List;

public interface IDAO<T, K> {
	public boolean doCreate(T vo) throws Exception;

	public boolean doUpdate(T vo) throws Exception;

	public boolean doRemove(String id) throws Exception;

	public T findById(String id) throws Exception;

	public List<T> findAll(String keyWord) throws Exception;

	public List<T> findAll(String keyWord, int currentPage, int lineSize)
			throws Exception;

	public long getAllCount(String keyWord) throws Exception;
}
