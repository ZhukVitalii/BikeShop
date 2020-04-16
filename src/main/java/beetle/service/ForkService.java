package beetle.service;

import beetle.bo.SearchResultBO;
import beetle.json.fork.ForkSearchInputJSON;
import beetle.entity.Manufacturer;
import beetle.entity.forks.Fork;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by VitaliiZhuk on 20.05.2017.
 */

public interface ForkService {

    void addToArticle(Long article);

    Long getArticleFromCart (int a);

    int getSize();

    void addFork(Fork fork);

    void addForkMaker(Manufacturer forkMaker);

    void deleteForks(long[] idList);

    List<Fork> findAll(Pageable pageable);

    long count();

    SearchResultBO searchByCriteria(ForkSearchInputJSON input);

    Fork findFork(Long id);
}

