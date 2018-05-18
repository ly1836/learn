package mybatis.dao;

import mybatis.models.User;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Select;
import org.mybatis.caches.ehcache.EhcacheCache;

import java.util.List;

/**
 *  Created by ly on 2018/3/2.
 */
//@CacheNamespace(implementation = EhcacheCache.class)
public interface IUser {
//    @Select("select * from user where id= #{id}")
    public User getUserByID(int id);

    public void insertUser(User user);

    public void updateUser(User user);

    public void deleteUser(int userId);

    public List<User> getUserList();

}
