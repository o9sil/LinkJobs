package com.gdu.linkJobs.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gdu.linkJobs.mapper.AreaMapper;
import com.gdu.linkJobs.vo.Area;
import com.gdu.linkJobs.vo.AreaAndArea2;


@Service
@Transactional
public class AreaService {
   @Autowired
   private AreaMapper areaMapper;
   
   // area리스트 다 출력
	public Map<String, Object> getAreaListAll() {

		Map<String, Object> map = new HashMap<String, Object>();

		List<Area> areaList = areaMapper.selectAreaListAll();
		List<AreaAndArea2> area2List = areaMapper.selectArea2ListAll();
		
		map.put("areaList", areaList);
		map.put("area2List", area2List);

		return map;
	}
   
   //sido
   public List<Area> getArea(){
      return areaMapper.selectArea();
   }
   
   //gungu
   public List<AreaAndArea2> getArea2(int areaNo){
      return areaMapper.selectArea2(areaNo);
   }
   
   //gungu
   public List<AreaAndArea2> getArea2AreaSido(String areaSido){
      return areaMapper.selectArea2AreaSido(areaSido);
   }
}