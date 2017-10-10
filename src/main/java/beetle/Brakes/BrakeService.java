package beetle.Brakes;

import beetle.Handlebars.HandlebarDiameter;
import beetle.Handlebars.HandlebarDiameterRepository;
import beetle.Wheels.RotorFixType;
import beetle.Wheels.RotorFixTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    //Lists with articles of components, that user added to cart
    public List<Long> articlesBrakeDiscHydraulic = new ArrayList<>();
    public List<Long> articlesBrakeDiscMechanik = new ArrayList<>();
    public List<Long> articlesBrakeVBrake = new ArrayList<>();
    public List<Long> articlesBrakeHandle = new ArrayList<>();

    //For BrakeDiscHydraulic

    //add articles to List
    public void addToArticleBrakeDiscHydraulic(Long article) {
        articlesBrakeDiscHydraulic.add(article);
        getSizeBrakeDiscHydraulic();
    }
    //get article from List
    public Long getArticleBrakeDiscHydraulicFromCart (int a) {
        Long b = articlesBrakeDiscHydraulic.get(a);
        return b;
    }
    //get size of List
    public int getSizeBrakeDiscHydraulic() {
        int a = articlesBrakeDiscHydraulic.size();
        return a;
    }

    //For BrakeDiscDiscMechanik
    public void addToArticleBrakeDiscMechanik(Long article) {
        articlesBrakeDiscMechanik.add(article);
        getSizeBrakeDiscMechanik();
    }
    public Long getArticleBrakeDiscMechanikFromCart (int a) {
        Long b = articlesBrakeDiscMechanik.get(a);
        return b;
    }
    public int getSizeBrakeDiscMechanik() {
        int a = articlesBrakeDiscMechanik.size();
        return a;
    }

    //For BrakeVBrake
    public void addToArticleBrakeVBrake(Long article) {
        articlesBrakeVBrake.add(article);
        getSizeBrakeVBrake();
    }
    public Long getArticleBrakeVBrakeFromCart (int a) {
        Long b = articlesBrakeVBrake.get(a);
        return b;
    }
    public int getSizeBrakeVBrake() {
        int a = articlesBrakeVBrake.size();
        return a;
    }

    //For BrakeHandle
    public void addToArticleBrakeHandle(Long article) {
        articlesBrakeHandle.add(article);
        getSizeBrakeHandle();
    }
    public Long getArticleBrakeHandleFromCart (int a) {
        Long b = articlesBrakeHandle.get(a);
        return b;
    }
    public int getSizeBrakeHandle() {
        int a = articlesBrakeHandle.size();
        return a;
    }

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

    //delete component from database for admin

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
    public void deleteBrakeVBrake(long[] idList) {
        for (long id : idList)
            brakeVBrakeRepository.delete(id);
    }

    @Transactional
    public void deleteBrakeHandle(long[] idList) {
        for (long id : idList)
            brakeHandleRepository.delete(id);
    }

    //find all components from database
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

    //select from database by parametrs

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
    public List<BrakeDiscHydraulic> findBrakeDiscHydraulicByArticle(Long article, Pageable pageable) {
        return brakeDiscHydraulicRepository.findByArticle(article, pageable);
    }

    @Transactional(readOnly=true)
    public List<BrakeDiscHydraulic> findBrakeDiscHydraulicByUrl(String url, Pageable pageable) {
        return brakeDiscHydraulicRepository.findByUrl(url,pageable);
    }

    @Transactional(readOnly=true)
    public List<BrakeDiscMechanik> findBrakeDiscMechanikByArticle(Long article, Pageable pageable) {
        return brakeDiscMechanikRepository.findByArticle(article, pageable);
    }

    @Transactional(readOnly=true)
    public List<BrakeDiscMechanik> findBrakeDiscMechanikByUrl(String url, Pageable pageable) {
        return brakeDiscMechanikRepository.findByUrl(url,pageable);
    }

    @Transactional(readOnly=true)
    public List<BrakeVBrake> findBrakeVBrakeByArticle(Long article, Pageable pageable) {
        return brakeVBrakeRepository.findByArticle(article, pageable);
    }

    @Transactional(readOnly=true)
    public List<BrakeVBrake> findBrakeVBrakeByUrl(String url, Pageable pageable) {
        return brakeVBrakeRepository.findByUrl(url,pageable);
    }

    @Transactional(readOnly=true)
    public List<BrakeHandle> findBrakeHandleByArticle(Long article, Pageable pageable) {
        return brakeHandleRepository.findByArticle(article, pageable);
    }

    @Transactional(readOnly=true)
    public List<BrakeHandle> findBrakeHandleByUrl(String url, Pageable pageable) {
        return brakeHandleRepository.findByUrl(url,pageable);
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

    //find by id

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
}
