package beetle.service;

import beetle.businessObjects.SearchResultBO;
import beetle.json.fork.ForkSearchInputJSON;
import beetle.repository.forks.BrakesTypeRepository;
import beetle.repository.forks.ForkRepository;
import beetle.repository.forks.TubeDiameterRepository;
import beetle.repository.forks.WheelsDiamRepository;
import beetle.entity.Manufacturer;
import beetle.entity.forks.BrakesType;
import beetle.entity.forks.Fork;
import beetle.entity.forks.TubeDiameter;
import beetle.entity.forks.WheelsDiam;
import beetle.entity.frame.BikeType;
import beetle.repository.ManufacturerRepository;
import beetle.repository.frame.BikeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

