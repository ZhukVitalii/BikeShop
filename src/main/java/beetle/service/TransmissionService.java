package beetle.service;

import beetle.entity.Manufacturer;
import beetle.entity.frame.BikeType;
import beetle.entity.transmission.*;
import beetle.entity.wheels.BackSprocketNumber;
import beetle.entity.wheels.BearingType;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by VitaliiZhuk on 02.07.2017.
 */

public interface TransmissionService {

    void addToArticleBackDerailleur(Long article);
    //get article from List
    Long getArticleBackDerailleurFromCart (int a);
    //get size of List
    int getSizeBackDerailleur();

    //For BackGearKas
    void addToArticleBackGearKas(Long article);
    Long getArticleBackGearKasFromCart (int a);
    int getSizeBackGearKas();
    //For BackGearTr
    void addToArticleBackGearTr(Long article);
    Long getArticleBackGearTrFromCart (int a);
    int getSizeBackGearTr();
    //For Bracket
    void addToArticleBracket(Long article);
    Long getArticleBracketFromCart (int a);
    int getSizeBracket();
    //For Chain
    void addToArticleChain(Long article);
    Long getArticleChainFromCart (int a);
    int getSizeChain();

    //For Crank
    void addToArticleCrank(Long article);
    Long getArticleCrankFromCart (int a);
    int getSizeCrank();
    //For FrontDerailleur
    void addToArticleFrontDerailleur(Long article);
    Long getArticleFrontDerailleurFromCart (int a);
    int getSizeFrontDerailleur();

    //For Pedal
    void addToArticlePedal(Long article);
    public Long getArticlePedalFromCart (int a);
    public int getSizePedal();


    // add
    @Transactional
    public void addBackDerailleur(BackDerailleur backDerailleur);

    @Transactional
    public  void addBackGearKas (BackGearKas backGearKas);

    @Transactional
    public  void addBackGearTr(BackGearTr backGearTr);

    @Transactional
    public  void addBracket (Bracket bracket);

    @Transactional
    public  void addChain (Chain chain);

    @Transactional
    public  void addCrank (Crank crank);

    @Transactional
    public  void addFrontDerailleur (FrontDerailleur frontDerailleur);

    @Transactional
    public  void addPedal (Pedal pedal);

    @Transactional
    public  void addTransmissionMaker (Manufacturer transmissionMaker);
    @Transactional
    public  void addBackSprocketMax(BackSprocketMax backSprocketMax);

    @Transactional
    public  void addBackSprocketMin (BackSprocketMin backSprocketMin);
    @Transactional
    public void addBackSprocketSize(BackSprocketSize backSprocketSize);
    @Transactional
    public void addBracketAxisLength(BracketAxisLength bracketAxisLength);
    @Transactional
    public void addBracketWide(BracketWide bracketWide);

    @Transactional
    public void addBracketsType(BracketType bracketType);

    @Transactional
    public  void addCarvingType (CarvingType carvingType);

    @Transactional
    public  void addChainElementNumber(ChainElementNumber chainElementNumber);
    @Transactional
    public  void addCollarDiam (CollarDiam collarDiam);

    @Transactional
    public void addCrankLength (CrankLength crankLength);

    @Transactional
    public void addFrontDerailleurFixType (FrontDerailleurFixType frontDerailleurFixType);
    public void addFrontSprocketMax(FrontSprocketMax frontSprocketMax);

    @Transactional
    public void addFrontSprocketMin(FrontSprocketMin frontSprocketMin);

    @Transactional
    public void addFrontSprocketNumber(FrontSprocketNumber frontSprocketNumber);

    @Transactional
    public void addFrontSprocketSize(FrontSprocketSize frontSprocketSize);
    @Transactional
    public void addPawLength(PawLength pawLength);

    @Transactional
    public void addBackSprocketNumber(BackSprocketNumber backSprocketNumber);

    @Transactional
    public void addBearingType(BearingType bearingType);

    @Transactional
    public void addPedalType(PedalType pedalType);

    @Transactional
    public void addTeethCapasity(TeethCapasity teethCapasity);

    @Transactional
    public void addTractionType(TractionType tractionType);

    @Transactional
    public void addBikeType(BikeType bikeType);


    //delete component from database for admin

    @Transactional
    public void deleteBackDerailleur(long[] idList);

    @Transactional
    public void deleteBackGearKas(long[] idList);

    @Transactional
    public void deleteBackGearTr(long[] idList);

    @Transactional
    public void deleteBracket(long[] idList);

    @Transactional
    public void deleteChain(long[] idList);

    @Transactional
    public void deleteCrank(long[] idList);

    @Transactional
    public void deleteFrontDerailleur(long[] idList);

    @Transactional
    public void deletePedal(long[] idList);

    //find all components from database
    @Transactional(readOnly=true)
    public List<BackDerailleur> findAll(Pageable pageable);

    @Transactional(readOnly=true)
    public List<BackGearKas> findAllOne(Pageable pageable);

    @Transactional(readOnly=true)
    public List<BackGearTr> findAllTwo(Pageable pageable);

    @Transactional(readOnly=true)
    public List<Bracket> findAllThree(Pageable pageable);

    @Transactional(readOnly=true)
    public List<Chain> findAllFor(Pageable pageable);

    @Transactional(readOnly=true)
    public List<Crank> findAllFive(Pageable pageable);

    @Transactional(readOnly=true)
    public List<FrontDerailleur> findAllSix(Pageable pageable);
    @Transactional(readOnly=true)
    public List<Pedal> findAllSeven(Pageable pageable);

    @Transactional(readOnly=true)
    public List<Manufacturer> findTransmissionMakers();

    @Transactional(readOnly=true)
    public List<BackSprocketMax> findBackSprocketMax();

    @Transactional(readOnly=true)
    public List<BackSprocketMin> findBackSprocketMin();

    @Transactional(readOnly=true)
    public List<BackSprocketSize> findBackSprocketSize();

    @Transactional(readOnly=true)
    public List<BracketAxisLength> findBracketAxisLength();

    @Transactional(readOnly=true)
    public List<BracketWide> findBracketWide();

    @Transactional(readOnly=true)
    public List<BracketType> findBracketType();

    @Transactional(readOnly=true)
    public List<CarvingType > findCarvingType ();

    @Transactional(readOnly=true)
    public List<ChainElementNumber> findChainElementNumber();

    @Transactional(readOnly=true)
    public List<CollarDiam> findCollarDiam();

    @Transactional(readOnly=true)
    public List<CrankLength> findCrankLength();

    @Transactional(readOnly=true)
    public List<FrontDerailleurFixType> findFrontDerailleurFixType();

    @Transactional(readOnly=true)
    public List<FrontSprocketMax> findFrontSprocketMax();

    @Transactional(readOnly=true)
    public List<FrontSprocketMin> findFrontSprocketMin();

    @Transactional(readOnly=true)
    public List<FrontSprocketNumber> findFrontSprocketNumber();

    @Transactional(readOnly=true)
    public List<FrontSprocketSize> findFrontSprocketSize();

    @Transactional(readOnly=true)
    public List<PawLength> findPawLength();

    @Transactional(readOnly=true)
    public List<BackSprocketNumber> findBackSprocketNumber();

    @Transactional(readOnly=true)
    public List<BearingType> findBearingType();

    @Transactional(readOnly=true)
    public List<PedalType> findPedalType();

    @Transactional(readOnly=true)
    public List<TeethCapasity> findTeethCapasity();

    @Transactional(readOnly=true)
    public List<TractionType> findTractionType();

    @Transactional(readOnly=true)
    public List<BikeType> findBikeType();

    //select from database by parametrs

    @Transactional(readOnly=true)
    public List<BackDerailleur> findBySprNumberAndSprMaxAndSprMin(BackSprocketNumber backSprocketNumber,
                                                                  BackSprocketMax backSprocketMax,
                                                                  BackSprocketMin backSprocketMin,
                                                                  Pageable pageable);
    @Transactional(readOnly=true)
    public List<FrontDerailleur> findByFrSprNumberAndBackSprNumberAndFrSprMaxAndFrSprMin(
                                                                  FrontSprocketNumber frontSprocketNumber,
                                                                  BackSprocketNumber backSprocketNumber,
                                                                  FrontSprocketMax frontSprocketMax,
                                                                  FrontSprocketMin frontSprocketMin,
                                                                  Pageable pageable);

    @Transactional(readOnly=true)
    public List<BackDerailleur> findByBackDerailleurMakers(Manufacturer transmissionMaker, Pageable pageable);
    @Transactional(readOnly=true)
    public List<BackGearKas> findByBackGearKasMakers(Manufacturer transmissionMaker, Pageable pageable);
    @Transactional(readOnly=true)
    public List<BackGearTr> findByBackGearTrMakers(Manufacturer transmissionMaker, Pageable pageable);
    @Transactional(readOnly=true)
    public List<Bracket> findByBracketMakers(Manufacturer transmissionMaker, Pageable pageable);

    @Transactional(readOnly=true)
    public List<Chain> findByChainMakers(Manufacturer transmissionMaker, Pageable pageable);

    @Transactional(readOnly=true)
    public List<Crank> findByCrankMakers(Manufacturer transmissionMaker, Pageable pageable);
    @Transactional(readOnly=true)
    public List<FrontDerailleur> findByFrontDerailleurMakers(Manufacturer transmissionMaker, Pageable pageable);

    @Transactional(readOnly=true)
    public List<Pedal> findByPedalMakers(Manufacturer transmissionMaker, Pageable pageable) ;

    @Transactional(readOnly=true)
    public List<BackDerailleur> findBackDerailleurByArticle(Long article, Pageable pageable);

    @Transactional(readOnly=true)
    public List<BackDerailleur> findBackDerailleurByUrl(String url, Pageable pageable);
    @Transactional(readOnly=true)
    public List<BackGearKas> findBackGearKasByArticle(Long article, Pageable pageable);

    @Transactional(readOnly=true)
    public List<BackGearKas> findBackGearKasByUrl(String url, Pageable pageable);

    @Transactional(readOnly=true)
    public List<BackGearTr> findBackGearTrByArticle(Long article, Pageable pageable);
    @Transactional(readOnly=true)
    public List<BackGearTr> findBackGearTrByUrl(String url, Pageable pageable) ;
    @Transactional(readOnly=true)
    public List<Bracket> findBracketByArticle(Long article, Pageable pageable);
    @Transactional(readOnly=true)
    public List<Bracket> findBracketByUrl(String url, Pageable pageable);
    @Transactional(readOnly=true)
    public List<Chain> findChainByArticle(Long article, Pageable pageable);
    @Transactional(readOnly=true)
    public List<Chain> findChainByUrl(String url, Pageable pageable);

    @Transactional(readOnly=true)
    public List<Crank> findCrankByArticle(Long article, Pageable pageable);

    @Transactional(readOnly=true)
    public List<Crank> findCrankByUrl(String url, Pageable pageable);

    @Transactional(readOnly=true)
    public List<FrontDerailleur> findFrontDerailleurByArticle(Long article, Pageable pageable);
    @Transactional(readOnly=true)
    public List<FrontDerailleur> findFrontDerailleurByUrl(String url, Pageable pageable);

    @Transactional(readOnly=true)
    public List<Pedal> findPedalByArticle(Long article, Pageable pageable);

    @Transactional(readOnly=true)
    public List<Pedal> findPedalByUrl(String url, Pageable pageable);

    @Transactional(readOnly=true)
    public List<BackGearKas> findByBackSprocketNumberBackGearKas(BackSprocketNumber backSprocketNumber, Pageable pageable);

    @Transactional(readOnly=true)
    public List<Bracket> findByBracketWide(BracketWide bracketWide, Pageable pageable);

    @Transactional(readOnly=true)
    public List<Chain> findByBackSprocketNumberChain (BackSprocketNumber backSprocketNumber, Pageable pageable) ;

    @Transactional(readOnly=true)
    public List<Crank> findByBikeType (BikeType bikeType, Pageable pageable) ;

    @Transactional(readOnly=true)
    public List<Crank> findByBracketTypeCrank (BracketType bracketType, Pageable pageable) ;
    // count by

    @Transactional(readOnly = true)
    public long countByBackDerailleurMaker(Manufacturer transmissionMaker);

    @Transactional(readOnly = true)
    public long countByBackGearKasMaker(Manufacturer transmissionMaker);
    @Transactional(readOnly = true)
    public long countByBackGearTrMaker(Manufacturer transmissionMaker);

    @Transactional(readOnly = true)
    public long countByBracketMaker(Manufacturer transmissionMaker);

    @Transactional(readOnly = true)
    public long countByChainMaker(Manufacturer transmissionMaker) ;

    @Transactional(readOnly = true)
    public long countByCrankMaker(Manufacturer transmissionMaker) ;

    @Transactional(readOnly = true)
    public long countByFrontDerailleurMaker(Manufacturer transmissionMaker) ;

    @Transactional(readOnly = true)
    public long countByPedalMaker(Manufacturer transmissionMaker);

    //find by id
    @Transactional(readOnly = true)
    public Crank findCrank(long id);

    @Transactional(readOnly = true)
    public Bracket findBracket(long id);

    @Transactional(readOnly = true)
    public BackGearKas findBackGearKas(long id);

    @Transactional(readOnly=true)
    public Manufacturer findTransmissionMaker(long id);

    @Transactional(readOnly=true)
    public BackSprocketMax findBackSprocketMax(long id);

    @Transactional(readOnly=true)
    public BackSprocketMin findBackSprocketMin(long id);

    @Transactional(readOnly=true)
    public BackSprocketSize findBackSprocketSize(long id);

    @Transactional(readOnly=true)
    public BackSprocketNumber findBackSprocketNumber(long id);

    @Transactional(readOnly=true)
    public BracketAxisLength findBracketAxisLength(long id);

    @Transactional(readOnly=true)
    public BracketWide findBracketWide(long id);

    @Transactional(readOnly=true)
    public BracketType findBracketType(long id);

    @Transactional(readOnly=true)
    public CarvingType findCarvingType(long id);

    @Transactional(readOnly=true)
    public ChainElementNumber findChainElementNumber(long id);

    @Transactional(readOnly=true)
    public CollarDiam findCollarDiam(long id);

    @Transactional(readOnly=true)
    public CrankLength findCrankLength(long id);

    @Transactional(readOnly=true)
    public FrontDerailleurFixType findFrontDerailleurFixType(long id);
    @Transactional(readOnly=true)
    public FrontSprocketMax findFrontSprocketMax(long id);

    @Transactional(readOnly=true)
    public FrontSprocketMin findFrontSprocketMin(long id);

    @Transactional(readOnly=true)
    public FrontSprocketNumber findFrontSprocketNumber(long id);

    @Transactional(readOnly=true)
    public FrontSprocketSize findFrontSprocketSize(long id);

    @Transactional(readOnly=true)
    public PawLength findPawLength(long id);

    @Transactional(readOnly=true)
    public PedalType findPedalType(long id);

    @Transactional(readOnly=true)
    public TeethCapasity findTeethCapasity(long id);

    @Transactional(readOnly=true)
    public TractionType findTractionType(long id);

    @Transactional(readOnly=true)
    public BearingType findBearingType(long id);
    @Transactional(readOnly=true)
    public BikeType findBikeType(long id);

}
