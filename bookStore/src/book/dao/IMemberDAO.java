package book.dao;

import java.util.List;

import book.vo.Member;

public interface IMemberDAO extends IDAO<Member, String> {
	public boolean findLogin(Member vo) throws Exception;

	public void doUpdateLastdate(String id) throws Exception;
	public boolean findPaypass(Member vo) throws Exception;

	public int PageSize() throws Exception;

	public List<Member> findPage(String keyWord) throws Exception;
}
