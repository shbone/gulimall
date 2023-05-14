package com.example.gulimall.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.common.utils.PageUtils;
import com.example.common.utils.Query;

import com.example.gulimall.product.dao.CategoryDao;
import com.example.gulimall.product.entity.CategoryEntity;
import com.example.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }
//    public Map<String,List<  >>
    @Override
    public List<CategoryEntity> listwithTree() {
//        1. 查出所有分类
        List<CategoryEntity> entityList =baseMapper.selectList(null);
//        2. 构建成树形结构
//        2.1 选出一级分类
        List<CategoryEntity> level1Menus = entityList.stream().filter((CategoryEntity)->
            CategoryEntity.getParentCid() == 0
        ).map((menu) ->{
            menu.setChildren(getChildrens(menu,entityList));
            return menu;
        }).sorted((menu1,menu2)->{
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());
        return level1Menus;
    }

    @Override
    public void removeMenusById(List<Long> asList) {
        //TODO 检查当前菜单是否引用
        baseMapper.deleteBatchIds(asList);
    }

    List<CategoryEntity>  getChildrens(CategoryEntity root, List<CategoryEntity> all){
        List<CategoryEntity> children=all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid().equals(root.getCatId()) ;
        }).map(categoryEntity -> {
            categoryEntity.setChildren(getChildrens(categoryEntity,all));
            return categoryEntity;
        }).sorted((menu1,menu2)->{
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());

        return children;
    }

}