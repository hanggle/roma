package com.oskyhang.system.dto;

import com.oskyhang.system.entity.BdMenu;
import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: hanggle
 * @date: 2018/11/25
 */
@Data
public class MenuQueryParam {
    private Long id;
    private String label;
    private Integer level;
}
