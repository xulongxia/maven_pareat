package com.jk.service;

import com.jk.dao.TreeDao;
import com.jk.model.TreeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

@Service("treeService")
public class TreeServiceImpl implements TreeService {

    @Autowired
    private TreeDao  treeDao;
    @Override
    public List<TreeModel> queryTree(){
        List<TreeModel>  list = treeDao.queryTree(0);
        List<TreeModel> queryTwoTree = queryTwoTree(list);
        return queryTwoTree;
    }

    private List<TreeModel> queryTwoTree(List<TreeModel> list) {
        List<TreeModel> treeList = new ArrayList<TreeModel>();
        for(int i=0;i<list.size();i++){
            TreeModel crTree = list.get(i);
            List<TreeModel> newStuTreeList = treeDao.queryTree(crTree.getId());
            if(newStuTreeList != null && newStuTreeList.size()>0){
                List<TreeModel> endTreeList = queryEndTree(newStuTreeList);
                crTree.setNodes(endTreeList);
                treeList.add(crTree);
            }else{
                treeList.add(crTree);
            }
        }
        return treeList;
    }

    private List<TreeModel> queryEndTree(List<TreeModel> list) {
        List<TreeModel> treeList = new ArrayList<TreeModel>();
        for(int i=0;i<list.size();i++){
            TreeModel crTree = list.get(i);
            List<TreeModel> newStuTreeList = treeDao.queryTree(crTree.getId());
            if(newStuTreeList != null && newStuTreeList.size()>0){
                List<TreeModel> endTreeList = queryEndTree(newStuTreeList);
                crTree.setNodes(endTreeList);
                treeList.add(crTree);
            }else{
                treeList.add(crTree);
            }
        }
        return treeList;
    }
}
