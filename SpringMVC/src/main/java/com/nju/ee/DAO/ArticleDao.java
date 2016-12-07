package com.nju.ee.DAO;

import com.nju.ee.vo.ArticleVo;
import org.springframework.data.repository.PagingAndSortingRepository;
/**
 * Created by 克崽兽 on 2016/12/3.
 */
//TODO:保证与ID的类型一致（如果不是Integer记得改）
public interface ArticleDao extends PagingAndSortingRepository<ArticleVo,Integer>{

}
