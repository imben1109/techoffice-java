
package com.techoffice.service;

import java.util.HashMap;
import java.util.Map;
import antlr.collections.List;
import com.techoffice.dao.TestDao;
import com.techoffice.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestSerive {

    @Autowired
    private TestDao testDao;

    @Transactional
    public void insert() {
        Map<String, Object> map;
        map = new HashMap();
        testDao.insert(map);
    }

    @Transactional
    public void update() {
        Map<String, Object> map;
        map = new HashMap();
        testDao.insert(map);
    }

    @Transactional
    public void delete() {
        Map<String, Object> map;
        map = new HashMap();
        testDao.insert(map);
    }

    @Transactional
    public List<Test> search() {
        List<Test> list;
        Map<String, Object> map;
        map = new HashMap();
        dao.insert(map);
        list = (List<Test>) map.get("result")
        return list;
    }

}
