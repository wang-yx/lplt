package com.wyx.proj.dao;


import com.wyx.proj.entity.Prodcategory;
import com.wyx.proj.entity.User;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;


@Mapper
public interface UserDao {

    /*
    private String userName;
    private String passWord;
    private String nickName;
    private int isAdmin;
    private Date createTime;
     */


    /**
     * 所有产品类别
     * @return
     */
    @Select("select * from t_users order by create_time desc ")
    @Results({
            @Result(column = "user_name", property = "userName"),
            @Result(column = "pass_word", property = "passWord"),
            @Result(column = "nick_name", property = "nickName"),
            @Result(column = "is_admin", property = "isAdmin"),
            @Result(column = "create_time", property = "createTime")
    })
    public List<User> selectAllUsers();


    /**
     * 根据id获取
     * @return
     */
    @Select("select * from t_users where id=#{id} ")
    @Results({
            @Result(column = "user_name", property = "userName"),
            @Result(column = "pass_word", property = "passWord"),
            @Result(column = "nick_name", property = "nickName"),
            @Result(column = "is_admin", property = "isAdmin"),
            @Result(column = "create_time", property = "createTime")
    })
    public User selectUserById(int id);

    /**
     * 插入数据
     * @param user
     * @return
     */
    @Insert("insert into t_users(user_name,pass_word,nick_name,is_admin) values(#{userName},#{passWord},#{nickName},#{isAdmin})")
    public int insertUser(User user);

    /**
     * 跟新数据
     * @param user
     * @return
     */
    @Update("update t_users set user_name=#{userName},pass_word=#{passWord},nick_name=#{nickName},is_admin=#{isAdmin} where id=#{id} ")
    public int updateUser(User user);

    /**
     * 根据用户名密码查询
     * @param userName
     * @param passWord
     * @return
     */
    @Select("select count(1) from t_users where user_name=#{userName} and pass_word=#{passWord} limit 1")
    public int selectUser(@Param("userName") String userName, @Param("passWord") String passWord);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @UpdateProvider(type = Provider.class,method = "batchDeleteUsers")
    public int batchDeleteUsers(List<Integer> ids);



    class Provider{

        public String batchDeleteUsers(Map map){
            List<Integer> ids = (List<Integer>) map.get("list");
            StringBuilder sb = new StringBuilder();
            sb.append("delete from t_users where id in (");
            for (int i = 0; i < ids.size(); i++) {
                sb.append(ids.get(i));
                if (i < ids.size() - 1)
                    sb.append(",");
            }
            sb.append(")");
            return sb.toString();
        }
    }
}
