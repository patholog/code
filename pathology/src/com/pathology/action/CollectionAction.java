package com.pathology.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import com.pathology.dto.CollectionDTO;
import com.pathology.entity.Collection;
import com.pathology.entity.Hospital;
import com.pathology.service.ICollectionService;

public class CollectionAction extends BaseAction{

	public ICollectionService collectionService;
	private List<CollectionDTO> collections;
	private CollectionDTO collection;
	
	public String  getCollectionList(){
		try{
		
			HttpServletRequest
			 request = ServletActionContext.getRequest();	
			
		collections =  collectionService.getListCollection(request,"");
		
		return "collections";
	  }catch(Exception e){
		
	   }
		return "collections";
	}


	public CollectionDTO getCollection() {
		return collection;
	}


	public void setCollection(CollectionDTO collection) {
		this.collection = collection;
	}


	public ICollectionService getCollectionService() {
		return collectionService;
	}


	public void setCollectionService(ICollectionService collectionService) {
		this.collectionService = collectionService;
	}


	public List<CollectionDTO> getCollections() {
		return collections;
	}


	public void setCollections(List<CollectionDTO> collections) {
		this.collections = collections;
	}
	public String deleteCollection(){
		Collection hos=collectionService.getCollection(Collection.class, collection.getCollectionId());
		collectionService.deleteCollection(hos);
		return "deletesuccess";
	}
	
	
}
