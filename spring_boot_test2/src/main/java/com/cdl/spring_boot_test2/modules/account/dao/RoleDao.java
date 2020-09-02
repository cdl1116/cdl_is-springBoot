package com.cdl.spring_boot_test2.modules.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import org.springframework.stereotype.Repository;

import com.cdl.spring_boot_test2.modules.account.entity.Role;
import com.cdl.spring_boot_test2.modules.common.vo.SearchVo;

@Mapper
@Repository
public interface RoleDao {

	@Select("select * from role")
	List<Role> getRoles();

	@Insert("insert into role (role_name) values (#{roleName})")
	@Options(useGeneratedKeys = true, keyColumn = "role_id", keyProperty = "roleId")
	void insertRole(Role role);

	@Select("select * from role role left join user_role userRole "
			+ "on role.role_id = userRole.role_id where userRole.user_id = #{userId}")
	List<Role> getRolesByUserId(int userId);

	@Insert("insert role(role_name) value(#{roleName})")
	@Options(useGeneratedKeys=true, keyProperty="roleId", keyColumn="role_id")
	void addRole(Role role);

	@Update("update role set role_name = #{roleName} where role_id = #{roleId}")
	void updateRole(Role role);

	@Delete("delete from role where role_id = #{roleId}")
	void deleteRole(int roleId);

	@Select("<script>" +
			"select * from role "
			+ "<where> "
			+ "<if test='keyWord != \"\" and keyWord != null'>"
			+ "and role_name like '%${keyWord}%' "
			+ "</if>"
			+ "</where>"
			+ "<choose>"
			+ "<when test='orderBy != \"\" and orderBy != null'>"
			+ "order by ${orderBy} ${sort}"
			+ "</when>"
			+ "<otherwise>"
			+ "order by role_id desc"
			+ "</otherwise>"
			+ "</choose>"
			+ "</script>")
	List<Role> getRolesBySearchVo(SearchVo searchVo);

	@Select("select * from role role left join role_resource roleResource "
			+ "on role.role_id = roleResource.role_id where roleResource.resource_id = #{resourceId}")
	List<Role> getRolesByResourceId(int resourceId);

	@Select("select * from role where role_id=#{roleId}")
	Role getRoleById(int roleId);

	@Select("select * from role where role_name = #{roleName} limit 1")
	Role getRoleByRoleName(String roleName);
}
