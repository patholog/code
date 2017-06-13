package com.pathology.service;

import java.util.List;

import com.pathology.bean.PageBean;
import com.pathology.entity.Leaf;
import com.pathology.entity.Users;

public interface ILeafServ {
 Users check(Users u);
 Users save(Users u);
 Leaf save(Leaf l);
 Leaf delt(Leaf l);
 List<Leaf> getByPage(String username,PageBean p);
 List<String> getAllUsername();
}
