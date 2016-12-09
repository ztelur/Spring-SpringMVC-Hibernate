package com.nju.ee.DAO;

import com.nju.ee.entity.Article;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * Created by 克崽兽 on 2016/12/8.
 */
@RepositoryDefinition(domainClass=Article.class, idClass=Integer.class)
public interface ArticleRepository extends PagingAndSortingRepository<Article, Integer> {
}
