
package com.techoffice.dao;

import java.util.Map;

public interface TestDao {


    public void insert(Map<String, Object> map);

    public void search(Map<String, Object> map);

    public void update(Map<String, Object> map);

    public void delete(Map<String, Object> map);

}
