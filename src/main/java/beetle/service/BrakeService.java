package beetle.service;

import beetle.businessObjects.SearchResultBO;
import beetle.entity.Manufacturer;
import beetle.entity.brake.*;
import beetle.json.brakes.BrakeHandleSearchInputJSON;
import beetle.json.brakes.BrakeSearchInputJSON;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BrakeService {

    void addToArticleBrakeDiscHydraulic(Long article);

    Long getArticleBrakeDiscHydraulicFromCart (int a);

    int getSizeBrakeDiscHydraulic();

    void addToArticleBrakeDiscMechanik(Long article);

    Long getArticleBrakeDiscMechanikFromCart (int a);

    int getSizeBrakeDiscMechanik();

    void addToArticleBrakeVBrake(Long article);

    Long getArticleBrakeVBrakeFromCart (int a);

    int getSizeBrakeVBrake();

    void addToArticleBrakeHandle(Long article);

    Long getArticleBrakeHandleFromCart (int a);

    int getSizeBrakeHandle();

    void addBrakeHandle (BrakeHandle brakeHandle);

    void addBrakeMaker (Manufacturer brakeMaker);

    void deleteBrakes(long[] idList);

    void deleteBrakeHandle(long[] idList);

    List<Brake> findAllBrakes(Pageable pageable);

    List<BrakeHandle> findAllHandles(Pageable pageable);

    List<Manufacturer> findBrakeMakers();

    long countBrakeHandle();

    Manufacturer findBrakeMaker(long id);

    SearchResultBO searchByCriteria(BrakeSearchInputJSON input);

    Brake getBrake(Long id);

    void addBrake(Brake brake);

    BrakeHandle getBrakeHandle(Long id);

    SearchResultBO searchByCriteria(BrakeHandleSearchInputJSON input);
}
