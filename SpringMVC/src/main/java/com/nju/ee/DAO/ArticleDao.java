package com.nju.ee.DAO;

import com.nju.ee.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * Created by 克崽兽 on 2016/12/3.
 */
public interface ArticleDao {
    Article findOne(Integer integer);

    Page<Article> findAll(Pageable pageable);

    <S extends Article> S save(S s);

    /**
     *
     * @param integer 需要删除的新闻ID
     * @return 返回删除的结果
     */
    String delete4Result(Integer integer);
}
