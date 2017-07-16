package com.pathology.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.pathology.dto.PathologyDTO;
import com.pathology.entity.Pathology;

public interface IPathologyService {

  List<Pathology> getByPage(int index, Class clazz, String hql);

  List<Pathology> getAllPathology(Class clazz, String hql);

  void deletePathology(Pathology em);

  Pathology getPathology(Class clazz, String id);

  PathologyDTO getPathologyByIdAndDiagStatus(String id, String diagStatus);

  void updatePathology(Pathology em);

  void addPathology(Pathology em);

  List<PathologyDTO> getListPathologyToNeed(HttpServletRequest request, String name);

  List<PathologyDTO> getListPathologyToHas(HttpServletRequest request, String name);

  List<PathologyDTO> getListPathologyToBack(HttpServletRequest request, String name);
}
