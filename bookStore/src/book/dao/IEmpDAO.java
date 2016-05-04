package book.dao ;
import java.util.* ;


import book.vo.Emp;

public interface IEmpDAO {
	public boolean doCreate(Emp emp) throws Exception ;
	public List<Emp> findAll(String keyWord) throws Exception ;
	public Emp findById(int empno) throws Exception ;
}