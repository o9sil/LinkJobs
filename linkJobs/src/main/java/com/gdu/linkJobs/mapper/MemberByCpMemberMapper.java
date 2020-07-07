package com.gdu.linkJobs.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gdu.linkJobs.vo.MemberByResume;

@Mapper
public interface MemberByCpMemberMapper {

	public List<MemberByResume> selectMemberListByResume();
}
