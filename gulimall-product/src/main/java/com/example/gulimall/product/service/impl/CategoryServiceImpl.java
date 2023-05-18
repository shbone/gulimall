package com.example.gulimall.product.service.impl;

import com.example.gulimall.product.vo.Catalog2Vo;
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

    /**
     * 查询一级分类
     * 父级ID为0，或者层级为1
     *
     *  * Mapper 继承该接口后，无需编写 mapper.xml 文件，即可获得CRUD功能
     *  * 这个 Mapper 支持 id 泛型
     * @return
     */
    @Override
    public List<CategoryEntity> getLevel1Categorys() {

        System.out.println("调用了 getLevel1Categorys  查询了数据库........【一级分类】");
        return baseMapper.selectList(new QueryWrapper<CategoryEntity>().eq("parent_cid",0));
//        return null;
    }
    /**
     * 查询出父ID为 parent_cid的List集合
     */
    private List<CategoryEntity> getParent_cid(List<CategoryEntity> selectList, Long parent_cid) {
        return selectList.stream().filter(item -> item.getParentCid() == parent_cid)
                .collect(Collectors.toList());
        //return baseMapper.selectList(new QueryWrapper<CategoryEntity>().eq("parent_cid", level.getCatId()));
    }

    @Override
    public Map<String, List<Catalog2Vo>> getCatalogJson() {
        // 一次性获取所有 数据
        List<CategoryEntity> selectList = baseMapper.selectList(null);
        System.out.println("调用了 getCatalogJson  查询了数据库........【三级分类】");
        // 1）、所有1级分类
        List<CategoryEntity> level1Categorys = getParent_cid(selectList, 0L);
        level1Categorys.forEach(item -> System.out.println(item));
        // 2) 封装数据
        Map<String,List<Catalog2Vo>> collect = level1Categorys.stream().collect(Collectors.toMap(k -> k.getCatId().toString() , level1 ->{

        }));
//        }return lev ));
//        return collect;
        return null;

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