package com.limyel.shutbb.util;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;

import java.util.List;

public class PageUtil {
    // 将 PageInfo 的查询结果转换为 dto
    public static <S, T> PageInfo<T> convert(PageInfo<S> pageInfo, List<T> list) {
        PageInfo<T> result = new PageInfo<>();
        BeanUtils.copyProperties(pageInfo, result);
        result.setList(list);
        return result;
    }
}
