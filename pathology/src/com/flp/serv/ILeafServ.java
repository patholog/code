package com.flp.serv;

import java.util.List;

import com.flp.bean.PageBean;
import com.flp.hib.Leaf;
import com.flp.hib.Users;

public interface ILeafServ {
 Users check(Users u);
 Users save(Users u);
 Leaf save(Leaf l);
 Leaf delt(Leaf l);
 List<Leaf> getByPage(String username,PageBean p);
 List<String> getAllUsername();
}
