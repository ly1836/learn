package mybatis.models;

import java.util.List;

/**
 * Created by ly on 2018/3/2.
 */
public class Group {
    private int groupId;
    private String groupName;
    private List<UserManyToMany> UserManyToManys;

    public List<UserManyToMany> getUserManyToManys() {
        return UserManyToManys;
    }
    public void setUserManyToManys(List<UserManyToMany> UserManyToManys) {
        this.UserManyToManys = UserManyToManys;
    }
    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    public String getGroupName() {
        return groupName;
    }
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}

