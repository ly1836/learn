package mybatis.models;

import java.io.Serializable;

/**
 *  Created by ly on 2018/3/2.
 */
public class Post implements Serializable {
    private int id;
    private Users users;
    private String title;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUser(Users user) {
        this.users = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
