package com.pathology.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.pathology.dto.PathologyDTO;
import com.pathology.entity.Pathology;
import com.pathology.entity.Result;
import com.pathology.entity.Users;

public interface IPathologyService {

  List<Pathology> getByPage(int index, Class clazz, String hql);

  List<Pathology> getAllPathology(Class clazz, String hql);

  void deletePathology(Pathology em);

  Pathology getPathology(Class clazz, String id);

  PathologyDTO getPathologyByIdAndDiagStatus(String id);

  void updatePathology(Pathology em);

  void finishPathology(String caseId);

  int addPathology(Map<String, String[]> paramMap);

  void addPathology(Pathology em);

  List<PathologyDTO> getListPathologyToNeed(HttpServletRequest request, String name);

  List<PathologyDTO> getListPathologyToHas(HttpServletRequest request, String name);

  List<PathologyDTO> getListPathologyToBack(HttpServletRequest request, String name);

  List<Users> selectDoctorList();
}
