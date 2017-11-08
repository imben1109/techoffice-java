
package com.techoffice.service;

import java.util.HashMap;
import java.util.Map;
import antlr.collections.List;
import com.techoffice.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestSerive {

    @Autowired
    private TestDao testDao;

    @Transactional
    public void insert(com.techoffice.entity.Test Test) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.putAll(BeanUtil.getMap(Test))
        testDao.insert(map);
    }

    @Transactional
    public void update(com.techoffice.entity.Test test) {
        Map<String, Object> map;
        map = new HashMap();
        testDao.insert(map);
    }

    @Transactional
    public void delete(com.techoffice.entity.Test test) {
        Map<String, Object> map;
        map = new HashMap();
        testDao.insert(map);
    }

    @Transactional
    public List<com.techoffice.entity.Test> search(com.techoffice.entity.Test test) {
        List<com.techoffice.entity.Test> list;
        Map<String, Object> map;
        map = new HashMap();
        dao.insert(map);
        list = (List<Test>) map.get("result")
        return list;
    }

}
