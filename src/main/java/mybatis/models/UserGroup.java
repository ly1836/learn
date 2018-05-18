package mybatis.models;

/**
 *  Created by ly on 2018/3/2.
 */
public class UserGroup {
    private int userId;
    private int groupId;
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
