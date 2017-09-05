package beetle.Brakes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import beetle.Handlebars.HandlebarDiameter;
import beetle.Handlebars.HandlebarDiameterRepository;
import beetle.Wheels.RotorFixType;
import beetle.Wheels.RotorFixTypeRepository;

import java.util.List;

/**
 * Created by VitaliiZhuk on 26.06.2017.
 */
@Service
public class BrakeService {
    //main components
    @Autowired
    private BrakeHandleRepository brakeHandleRepository;
    @Autowired
    private BrakeVBrakeRepository brakeVBrakeRepository;
    @Autowired
    private BrakeDiscHydraulicRepository brakeDiscHydraulicRepository;
    @Autowired
    private BrakeDiscMechanikRepository brakeDiscMechanikRepository;


    //auxiliary components

    @Autowired
    private BrakeHandleCompatibilityRepository brakeHandleCompatibilityRepository;
    @Autowired
    private BrakeHandleLocationRepository brakeHandleLocationRepository;
    @Autowired
    private BrakeHandleWideRepository brakeHandleWideRepository;
    @Autowired
    private BrakeMakerRepository brakeMakerRepository;
    @Autowired
    private LengthHydrolineRepository lengthHydrolineRepository;
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private RotorDiamRepository rotorDiamRepository;
    @Autowired
    private HandlebarDiameterRepository handlebarDiameterRepository;
    @Autowired
    private BrakeLiquidRepository brakeLiquidRepository;
    @Autowired
    private RotorFixTypeRepository rotorFixTypeRepository;




    // add
    @Transactional
    public void addBrakeDiscHydraulic(BrakeDiscHydraulic brakeDiscHydraulic) {
        brakeDiscHydraulicRepository.save(brakeDiscHydraulic);
    }

    @Transactional
    public  void addBrakeDiscMechanik (BrakeDiscMechanik brakeDiscMechanik) {
        brakeDiscMechanikRepository.save(brakeDiscMechanik);
    }

    @Transactional
    public  void addBrakeVBrake (BrakeVBrake brakeVBrake) {
        brakeVBrakeRepository.save(brakeVBrake);
    }

    @Transactional
    public  void addBrakeHandle (BrakeHandle brakeHandle) {
        brakeHandleRepository.save(brakeHandle);
    }




    @Transactional
    public  void addBrakeMaker (BrakeMaker brakeMaker) {
        brakeMakerRepository.save(brakeMaker);
    }


    @Transactional
    public  void addBrakeHandleCompatibility(BrakeHandleCompatibility brakeHandleCompatibility) {
        brakeHandleCompatibilityRepository.save(brakeHandleCompatibility);
    }


    @Transactional
    public  void addBrakeHandleLocation (BrakeHandleLocation brakeHandleLocation) {
        brakeHandleLocationRepository.save(brakeHandleLocation);
    }

    @Transactional
    public void addBrakeHandleWide(BrakeHandleWide brakeHandleWide) {
        brakeHandleWideRepository.save(brakeHandleWide);
    }

    @Transactional
    public void addBrakeLiquid(BrakeLiquid brakeLiquid) {
        brakeLiquidRepository.save(brakeLiquid);
    }

    @Transactional
    public void addLengthHydroline(LengthHydroline lengthHydroline) {
        lengthHydrolineRepository.save(lengthHydroline);
    }
    @Transactional
    public void addLocation(Location location) {
        locationRepository.save(location);
    }

    @Transactional
    public  void addRotorDiam (RotorDiam rotorDiam) {
        rotorDiamRepository.save(rotorDiam);
    }





//delete

    @Transactional
    public void deleteBrakeDiscHydraulic(long[] idList) {
        for (long id : idList)
            brakeDiscHydraulicRepository.delete(id);
    }
    @Transactional
    public void deleteBrakeDiscMechanik(long[] idList) {
        for (long id : idList)
            brakeDiscMechanikRepository.delete(id);
    }

    @Transactional
    public void deleteRBrakeVBrake(long[] idList) {
        for (long id : idList)
            brakeVBrakeRepository.delete(id);
    }

    @Transactional
    public void deleteBrakeHandle(long[] idList) {
        for (long id : idList)
            brakeHandleRepository.delete(id);
    }


    //find
    @Transactional(readOnly=true)
    public List<BrakeDiscHydraulic> findAll(Pageable pageable) {
        return brakeDiscHydraulicRepository.findAll(pageable).getContent();
    }
    @Transactional(readOnly=true)
    public List<BrakeDiscMechanik> findAllOne(Pageable pageable) {
        return brakeDiscMechanikRepository.findAll(pageable).getContent();
    }
    @Transactional(readOnly=true)
    public List<BrakeVBrake> findAllTwo(Pageable pageable) {
        return brakeVBrakeRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly=true)
    public List<BrakeHandle> findAllThree(Pageable pageable) {
        return brakeHandleRepository.findAll(pageable).getContent();
    }


    @Transactional(readOnly=true)
    public List<BrakeMaker> findBrakeMakers() {
        return brakeMakerRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<BrakeHandleCompatibility> findBrakeHandleCompatibility() {
        return brakeHandleCompatibilityRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<Location> findLocation() {
        return locationRepository.findAll();
    }

    @Transactional(readOnly=true)
    public List<BrakeHandleLocation> findBrakeHandleLocation() {
        return brakeHandleLocationRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<BrakeHandleWide> findBrakeHandleWide() {
        return brakeHandleWideRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<BrakeLiquid> findBrakeLiquid() {
        return brakeLiquidRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<LengthHydroline> findLengthHydroline() {
        return lengthHydrolineRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<RotorDiam> findRotorDiam() {
        return rotorDiamRepository.findAll();
    }









    //findBy

    @Transactional(readOnly=true)
    public List<BrakeDiscHydraulic> findByBrakeDiscHydraulicMakers(BrakeMaker brakeMaker, Pageable pageable) {
        return brakeDiscHydraulicRepository.findByBrakeMakers(brakeMaker, pageable);
    }

    @Transactional(readOnly=true)
    public List<BrakeDiscMechanik> findByBrakeDiscMechanikMakers(BrakeMaker brakeMaker, Pageable pageable) {
        return brakeDiscMechanikRepository.findByBrakeMakers(brakeMaker, pageable);
    }

    @Transactional(readOnly=true)
    public List<BrakeVBrake> findByBrakeVBrakeMakers(BrakeMaker brakeMaker, Pageable pageable) {
        return brakeVBrakeRepository.findByBrakeMakers(brakeMaker, pageable);
    }
    @Transactional(readOnly=true)
    public List<BrakeHandle> findByBrakeHandleMakers(BrakeMaker brakeMaker, Pageable pageable) {
        return brakeHandleRepository.findByBrakeMakers(brakeMaker, pageable);
    }




    @Transactional(readOnly=true)
    public List<BrakeDiscHydraulic> findByLocationHydraulik(Location location, Pageable pageable) {
        return brakeDiscHydraulicRepository.findByLocation(location, pageable);
    }
    @Transactional(readOnly=true)
    public List<BrakeDiscHydraulic> findByLengthHydroline(LengthHydroline lengthHydroline, Pageable pageable) {
        return brakeDiscHydraulicRepository.findByLengthHydroline(lengthHydroline, pageable);
    }
    @Transactional(readOnly=true)
    public List<BrakeDiscHydraulic> findByBrakeLiquid(BrakeLiquid brakeLiquid, Pageable pageable) {
        return brakeDiscHydraulicRepository.findByBrakeLiquid(brakeLiquid, pageable);
    }
    @Transactional(readOnly=true)
    public List<BrakeDiscHydraulic> findByRotorDiam(RotorDiam rotorDiam, Pageable pageable) {
        return brakeDiscHydraulicRepository.findByRotorDiam( rotorDiam, pageable);
    }
    @Transactional(readOnly=true)
    public List<BrakeDiscHydraulic> findByRotorFixType(RotorFixType rotorFixType, Pageable pageable) {
        return brakeDiscHydraulicRepository.findByRotorFixType( rotorFixType, pageable);
    }

    @Transactional(readOnly=true)
    public List<BrakeDiscMechanik> findByLocationMechanik(Location location, Pageable pageable) {
        return brakeDiscMechanikRepository.findByLocation(location, pageable);
    }
    @Transactional(readOnly=true)
    public List<BrakeDiscMechanik> findByRotorDiamMechanik(RotorDiam rotorDiam, Pageable pageable) {
        return brakeDiscMechanikRepository.findByRotorDiam( rotorDiam, pageable);
    }
    @Transactional(readOnly=true)
    public List<BrakeDiscMechanik> findByRotorFixTypeMechanik(RotorFixType rotorFixType, Pageable pageable) {
        return brakeDiscMechanikRepository.findByRotorFixType( rotorFixType, pageable);
    }

    @Transactional(readOnly=true)
    public List<BrakeVBrake> findByLocationVBrake(Location location, Pageable pageable) {
        return brakeVBrakeRepository.findByLocation(location, pageable);
    }

    @Transactional(readOnly=true)
    public List<BrakeHandle> findByBrakeHandleLocation(BrakeHandleLocation brakeHandleLocation, Pageable pageable) {
        return brakeHandleRepository.findByBrakeHandleLocation(brakeHandleLocation, pageable);
    }
    @Transactional(readOnly=true)
    public List<BrakeHandle> findByBrakeHandleCompatibility (BrakeHandleCompatibility brakeHandleCompatibility, Pageable pageable) {
        return brakeHandleRepository.findByBrakeHandleCompatibility(brakeHandleCompatibility, pageable);
    }

    @Transactional(readOnly=true)
    public List<BrakeHandle> findByHandlebarDiameter (HandlebarDiameter handlebarDiameter, Pageable pageable) {
        return brakeHandleRepository.findByHandlebarDiameter(handlebarDiameter, pageable);
    }
    @Transactional(readOnly=true)
    public List<BrakeHandle> findByBrakeHandleWide (BrakeHandleWide brakeHandleWide, Pageable pageable) {
        return brakeHandleRepository.findByBrakeHandleWide(brakeHandleWide, pageable);
    }










// count by


    @Transactional(readOnly = true)
    public long countByBrakeMakerDiscHydr(BrakeMaker brakeMaker) {
        return brakeDiscHydraulicRepository.countByBrakeMakers(brakeMaker);
    }
    @Transactional(readOnly = true)
    public long countByBrakeMakerDiscMech(BrakeMaker brakeMaker) {
        return brakeDiscMechanikRepository.countByBrakeMakers(brakeMaker);
    }
    @Transactional(readOnly = true)
    public long countByBrakeMakerVBrake(BrakeMaker brakeMaker) {
        return brakeVBrakeRepository.countByBrakeMakers(brakeMaker);
    }
    @Transactional(readOnly = true)
    public long countByBrakeMakerHandle(BrakeMaker brakeMaker) {
        return brakeHandleRepository.countByBrakeMakers(brakeMaker);
    }

    @Transactional(readOnly = true)
    public long countByLocationDiscHydr(Location location) {
        return brakeDiscHydraulicRepository.countByLocation(location);
    }

    @Transactional(readOnly = true)
    public long countByBrakeLiquid(BrakeLiquid brakeLiquid) {
        return brakeDiscHydraulicRepository.countByBrakeLiquid(brakeLiquid);
    }
    @Transactional(readOnly = true)
    public long countByLengthHydroline(LengthHydroline lengthHydroline) {
        return brakeDiscHydraulicRepository.countByLengthHydroline(lengthHydroline);
    }
    @Transactional(readOnly = true)
    public long countByRotorDiamDiscHydr(RotorDiam rotorDiam) {
        return brakeDiscHydraulicRepository.countByRotorDiam(rotorDiam);
    }
    @Transactional(readOnly = true)
    public long countByRotorFixTypeDiscHydr(RotorFixType rotorFixType) {
        return brakeDiscHydraulicRepository.countByRotorFixType(rotorFixType);
    }
    @Transactional(readOnly = true)
    public long countByLocationDiscMech(Location location) {
        return brakeDiscMechanikRepository.countByLocation(location);
    }
    @Transactional(readOnly = true)
    public long countByRotorDiamDiscMech(RotorDiam rotorDiam) {
        return brakeDiscMechanikRepository.countByRotorDiam(rotorDiam);
    }

    @Transactional(readOnly = true)
    public long countByRotorFixTypeDiscMech(RotorFixType rotorFixType) {
        return brakeDiscMechanikRepository.countByRotorFixType(rotorFixType);
    }







    @Transactional(readOnly=true)
    public List<BrakeDiscHydraulic> findByPatternDiscHydr(String pattern, Pageable pageable) {
        return brakeDiscHydraulicRepository.findByPattern(pattern, pageable);
    }

    @Transactional(readOnly=true)
    public List<BrakeDiscMechanik> findByPatternDiscMech(String pattern, Pageable pageable) {
        return brakeDiscMechanikRepository.findByPattern(pattern, pageable);
    }
    @Transactional(readOnly=true)
    public List<BrakeVBrake> findByPatternVBrake(String pattern, Pageable pageable) {
        return  brakeVBrakeRepository.findByPattern(pattern, pageable);
    }
    @Transactional(readOnly=true)
    public List<BrakeHandle> findByPatternBrakeHandle(String pattern, Pageable pageable) {
        return  brakeHandleRepository.findByPattern(pattern, pageable);
    }

    @Transactional(readOnly = true)
    public long countBrakeDiscHydr() {
        return brakeDiscHydraulicRepository.count();
    }

    @Transactional(readOnly = true)
    public long countBrakeDiscMech() {
        return brakeDiscMechanikRepository.count();
    }

    @Transactional(readOnly = true)
    public long countVBrake() {
        return brakeVBrakeRepository.count();
    }
    @Transactional(readOnly = true)
    public long countBrakeHandle() {
        return brakeHandleRepository.count();
    }

    //find
    @Transactional(readOnly=true)
    public BrakeMaker findBrakeMaker(long id) {
        return brakeMakerRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public Location findLication(long id) {
        return locationRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public BrakeHandleCompatibility findBrakeHandleCompatibility(long id) {
        return brakeHandleCompatibilityRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public BrakeHandleLocation findBrakeHandleLocation(long id) {
        return brakeHandleLocationRepository.findOne(id);
    }


    @Transactional(readOnly=true)
    public BrakeHandleWide findBrakeHandleWide(long id) {
        return brakeHandleWideRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public BrakeLiquid findBrakeLiquid(long id) {
        return brakeLiquidRepository.findOne(id);
    }
    @Transactional(readOnly=true)
    public LengthHydroline  findLengthHydroline(long id) {
        return lengthHydrolineRepository.findOne(id);
    }
    @Transactional(readOnly=true)
    public RotorDiam  findRotorDiam(long id) {
        return rotorDiamRepository.findOne(id);
    }
    @Transactional(readOnly=true)
    public Location findLocation(long id) {
        return locationRepository.findOne(id);
    }




}
