package mybatisAutomatic.service;

import mybatisAutomatic.java.class_;

public interface class_Mapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(class_ record);

    int insertSelective(class_ record);

    class_ selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(class_ record);

    int updateByPrimaryKey(class_ record);
}