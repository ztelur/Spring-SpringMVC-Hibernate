package com.nju.ee.DAO;


import com.nju.ee.entity.Paper;

import java.util.List;

/**
 * Created by homer on 16-12-16.
 */
public interface PaperDao {
    Paper getPaperById(int id);

    List<Paper> getPapersWithpaper(int paper);

    Paper update(Paper paper);

    Paper delete(Paper paper);

    Paper save(Paper paper);
}
