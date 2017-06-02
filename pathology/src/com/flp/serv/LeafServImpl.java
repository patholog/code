package com.flp.serv;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.flp.bean.PageBean;
import com.flp.dao.ILeafDao;
import com.flp.dao.IUserDao;
import com.flp.hib.Leaf;
import com.flp.hib.Users;
@Transactional(readOnly=true)
public class LeafServImpl implements ILeafServ {
	private IUserDao<Users,Integer> udao;
	private ILeafDao<Leaf,String> ldao;
	public Users check(Users u) {
		List<Users> list = udao.getByExample(u);
		if(list!=null && list.size()>0)
			u = list.get(0);
		return u;
	}
	public List<Leaf> getByPage(String username, PageBean p) {
		List<Leaf> list = null;
		if(p.getPageNum()<1)
			p.setPageNum(1);
		if(p.getMaxPage()<1)
		{
			int rowsCount = ldao.getByNameRowsNum(username);
			if(rowsCount<1)return list;
			int maxPage = (rowsCount-1)/p.getRowsPage()+1;
			p.setMaxPage(maxPage);
			p.setRowsCount(rowsCount);
		}
		if(p.getPageNum()>p.getMaxPage())
			p.setPageNum(p.getMaxPage());
		int begin = (p.getPageNum()-1)*p.getRowsPage();
		list = ldao.getByName(username,begin,p.getRowsPage());
		if(p.getPageNum()>1)
			p.setLastPage(p.getPageNum()-1);
		if(p.getPageNum()<p.getMaxPage())
			p.setNextPage(p.getPageNum()+1);
		return list;
	}
	public List<String> getAllUsername() {
		return udao.getAll("select u.username from Users u");
	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public Users save(Users u) {
		return udao.save(u);
	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public Leaf save(Leaf l) {
		return ldao.save(l);
	}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public Leaf delt(Leaf l) {
		return ldao.delt(l);
	}
	public IUserDao getUdao() {
		return udao;
	}

	public void setUdao(IUserDao udao) {
		this.udao = udao;
	}

	public ILeafDao getLdao() {
		return ldao;
	}

	public void setLdao(ILeafDao ldao) {
		this.ldao = ldao;
	}

}
