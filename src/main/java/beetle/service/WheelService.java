package beetle.service;

import beetle.bo.SearchResultBO;
import beetle.entity.wheels.*;
import beetle.json.wheel.*;

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