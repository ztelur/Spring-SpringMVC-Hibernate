package com.nju.ee.DAO;

import com.nju.ee.entity.Article;
import com.nju.ee.entity.Paper;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.RepositoryDefinition;

/**
 * Created by homer on 16-12-16.
 */
@RepositoryDefinition(domainClass=Paper.class, idClass=Integer.class)
public interface PaperRepository extends PagingAndSortingRepository<Paper, Integer> {
}
