package com.gdu.linkJobs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.AnnouncementList;

@Mapper
public interface AnnouncementMapper {
	
	//기업회원별 등록한 채용공고 리스트 조회
	public List<AnnouncementList> selectAnnouncementListByCpMember(String cpMemberId);
}
