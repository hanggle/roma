package com.oskyhang.system.mapper;


import com.oskyhang.system.entity.BdMenu;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 * description: <br/>
 * @author: zh <br/>
 * date: 2018/3/12 <br/>
 */
@Repository
public interface BdMenuMapper{
    /**
     * 删除
     * @param id id
     * @return id
     */
    int delete(Long id);

    /**
     * 新增
     * @param object 实体
     * @return id
     */
    int insert(BdMenu object);

    /**
     * 根据id选择
     * @param id id
     * @return 查询的对象
     */
    BdMenu load(Long id);

    /**
     *  据id更新
     * @param record  对象
     * @return id
     */
    int update(BdMenu record);

    /**
     *  据id更新
     * @param params  对象
     * @return id
     */
    List<BdMenu> list(Map params);
    /**
     * 查询集合
     * @return 集合
     */
    List<BdMenu> selectMenuTree();
}
