package com.cdl.spring_boot_test2.modules.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.cdl.spring_boot_test2.modules.account.entity.Role;
import com.cdl.spring_boot_test2.modules.common.vo.SearchVo;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoleDao {

	@Select("select * from role")
	List<Role> getRoles();

	@Select("select * from role r " +
			"left join user_role ur on r.role_id = ur.role_id " +
			"where ur.user_id = #{userId}")
	List<Role> getRolesByUserId(int userId);

}
