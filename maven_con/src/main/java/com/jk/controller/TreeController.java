package com.jk.controller;

import com.jk.model.TreeModel;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.reflect.generics.tree.Tree;

import java.util.List;

@Controller
@RequestMapping("treeController")
public class TreeController {

    @Autowired
    private TreeService treeService;

    @RequestMapping("queryTree")
    @ResponseBody
    public List<TreeModel>  queryTree(){
        List<TreeModel>  list = treeService.queryTree();
        return  list;
    }





}
