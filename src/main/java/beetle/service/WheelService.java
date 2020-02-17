package beetle.service;

import beetle.businessObjects.SearchResultBO;
import beetle.entity.Manufacturer;
import beetle.entity.forks.BrakesType;
import beetle.entity.forks.WheelsDiam;
import beetle.entity.frame.BikeType;
import beetle.entity.wheels.*;
import beetle.json.wheel.*;
import beetle.repository.ManufacturerRepository;
import beetle.repository.forks.BrakesTypeRepository;
import beetle.repository.forks.WheelsDiamRepository;
import beetle.repository.frame.BikeTypeRepository;
import beetle.repository.wheels.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 11.06.2017.
 */

public interface WheelService {
    SearchResultBO searchByCriteria(WheelSearchInputJSON input);

    SearchResultBO searchByCriteria(HubSearchInputJSON input);

    SearchResultBO searchByCriteria(RimSearchInputJSON input);

    SearchResultBO searchByCriteria(TireSearchInputJSON input);

    SearchResultBO searchByCriteria(SpokeSearchInputJSON input);

    Wheel getWheel(Long id);

    Hub getHub(Long id);

    Rim getRim(Long id);

    Tire getTire(Long id);

    Spoke getSpoke(Long id);
}