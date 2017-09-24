package beetle.Transmissions;

import beetle.Bakes.BikeType;
import beetle.Bakes.BikeTypeRepository;
import beetle.Wheels.BackSprocketNumber;
import beetle.Wheels.BackSprocketNumberRepository;
import beetle.Wheels.BearingType;
import beetle.Wheels.BearingTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 02.07.2017.
 */
@Service
public class TransmissionService {
    //main components
    @Autowired
    private BackDerailleurRepository backDerailleurRepository;
    @Autowired
    private BackGearKasRepository backGearKasRepository;
    @Autowired
    private BackGearTrRepository backGearTrRepository;
    @Autowired
    private BracketRepository bracketRepository;
    @Autowired
    private ChainRepository chainRepository;
    @Autowired
    private  CrankRepository crankRepository;
    @Autowired
    private  FrontDerailleurRepository frontDerailleurRepository;
    @Autowired
    private  PedalRepository pedalRepository;


    //auxiliary components

    @Autowired
    private BackSprocketMaxRepository backSprocketMaxRepository;
    @Autowired
    private BackSprocketMinRepository backSprocketMinRepository;
    @Autowired
    private  BackSprocketSizeRepository backSprocketSizeRepository;
    @Autowired
    private BracketAxisLengthRepository bracketAxisLengthRepository;
    @Autowired
    private BracketWideRepository bracketWideRepository;
    @Autowired
    private BracketTypeRepository bracketTypeRepository;
    @Autowired
    private CarvingTypeRepository carvingTypeRepository;
    @Autowired
    private ChainElementNumberRepository chainElementNumberRepository;
    @Autowired
    private CollarDiamRepository collarDiamRepository;
    @Autowired
    private CrankLengthRepository crankLengthRepository;
    @Autowired
    private FrontDerailleurFixTypeRepository frontDerailleurFixTypeRepository;
    @Autowired
    private FrontSprocketMaxRepository frontSprocketMaxRepository;
    @Autowired
    private FrontSprocketMinRepository frontSprocketMinRepository;
    @Autowired
    private FrontSprocketNumberRepository frontSprocketNumberRepository;
    @Autowired
    private FrontSprocketSizeRepository frontSprocketSizeRepository;
    @Autowired
    private PawLengthRepository pawLengthRepository;
    @Autowired
    private PedalTypeRepository pedalTypeRepository;
    @Autowired
    private TeethCapasityRepository teethCapasityRepository;
    @Autowired
    private TractionTypeRepository tractionTypeRepository;
    @Autowired
    private TransmissionMakerRepository transmissionMakerRepository;
    @Autowired
    private BikeTypeRepository bikeTypeRepository;
    @Autowired
    private  BackSprocketNumberRepository backSprocketNumberRepository;
    @Autowired
    private BearingTypeRepository bearingTypeRepository;

    public List<Long> articlesBackDerailleur = new ArrayList<>();
    public List<Long> articlesBackGearKas = new ArrayList<>();
    public List<Long> articlesBackGearTr = new ArrayList<>();
    public List<Long> articlesBracket = new ArrayList<>();
    public List<Long> articlesChain = new ArrayList<>();
    public List<Long> articlesCrank = new ArrayList<>();
    public List<Long> articlesFrontDerailleur = new ArrayList<>();
    public List<Long> articlesPedal = new ArrayList<>();


    //For BackDerailleur
    public void testPrintBackDerailleur(){
        for (Long articlo : articlesBackDerailleur){
            System.out.println(articlo);
        }
    }
    public  void printSizeBackDerailleur(){
        System.out.println("розмір корзини " + getSizeBackDerailleur());
    }
    public void addToArticleBackDerailleur(Long article) {
        articlesBackDerailleur.add(article);
        testPrintBackDerailleur();
        getSizeBackDerailleur();
        printSizeBackDerailleur();
    }
    public Long getArticleBackDerailleurFromCart (int a) {
        Long b = articlesBackDerailleur.get(a);
        return b;
    }
    public int getSizeBackDerailleur() {
        int a = articlesBackDerailleur.size();
        return a;
    }
    //For BackGearKas
    public void testPrintBackGearKas(){
        for (Long articlo : articlesBackGearKas){
            System.out.println(articlo);
        }
    }
    public  void printSizeBackGearKas(){
        System.out.println("розмір корзини " + getSizeBackGearKas());
    }
    public void addToArticleBackGearKas(Long article) {
        articlesBackGearKas.add(article);
        testPrintBackGearKas();
        getSizeBackGearKas();
        printSizeBackGearKas();
    }
    public Long getArticleBackGearKasFromCart (int a) {
        Long b = articlesBackGearKas.get(a);
        return b;
    }
    public int getSizeBackGearKas() {
        int a = articlesBackGearKas.size();
        return a;
    }

    //For BackGearTr
    public void testPrintBackGearTr(){
        for (Long articlo : articlesBackGearTr){
            System.out.println(articlo);
        }
    }
    public  void printSizeBackGearTr(){
        System.out.println("розмір корзини " + getSizeBackGearTr());
    }
    public void addToArticleBackGearTr(Long article) {
        articlesBackGearTr.add(article);
        testPrintBackGearTr();
        getSizeBackGearTr();
        printSizeBackGearTr();
    }
    public Long getArticleBackGearTrFromCart (int a) {
        Long b = articlesBackGearTr.get(a);
        return b;
    }
    public int getSizeBackGearTr() {
        int a = articlesBackGearTr.size();
        return a;
    }

    //For Bracket
    public void testPrintBracket(){
        for (Long articlo : articlesBracket){
            System.out.println(articlo);
        }
    }
    public  void printSizeBracket(){
        System.out.println("розмір корзини " + getSizeBracket());
    }
    public void addToArticleBracket(Long article) {
        articlesBracket.add(article);
        testPrintBracket();
        getSizeBracket();
        printSizeBracket();
    }
    public Long getArticleBracketFromCart (int a) {
        Long b = articlesBracket.get(a);
        return b;
    }
    public int getSizeBracket() {
        int a = articlesBracket.size();
        return a;
    }

    //For Chain
    public void testPrintChain(){
        for (Long articlo : articlesChain){
            System.out.println(articlo);
        }
    }
    public  void printSizeChain(){
        System.out.println("розмір корзини " + getSizeChain());
    }
    public void addToArticleChain(Long article) {
        articlesChain.add(article);
        testPrintChain();
        getSizeChain();
        printSizeChain();
    }
    public Long getArticleChainFromCart (int a) {
        Long b = articlesChain.get(a);
        return b;
    }
    public int getSizeChain() {
        int a = articlesChain.size();
        return a;
    }

    //For Crank
    public void testPrintCrank(){
        for (Long articlo : articlesCrank){
            System.out.println(articlo);
        }
    }
    public  void printSizeCrank(){
        System.out.println("розмір корзини " + getSizeCrank());
    }
    public void addToArticleCrank(Long article) {
        articlesCrank.add(article);
        testPrintCrank();
        getSizeCrank();
        printSizeCrank();
    }
    public Long getArticleCrankFromCart (int a) {
        Long b = articlesCrank.get(a);
        return b;
    }
    public int getSizeCrank() {
        int a = articlesCrank.size();
        return a;
    }

    //For hFrontDerailleur
    public void testPrintFrontDerailleur(){
        for (Long articlo : articlesFrontDerailleur){
            System.out.println(articlo);
        }
    }
    public  void printSizeFrontDerailleur(){
        System.out.println("розмір корзини " + getSizeFrontDerailleur());
    }
    public void addToArticleFrontDerailleur(Long article) {
        articlesFrontDerailleur.add(article);
        testPrintFrontDerailleur();
        getSizeFrontDerailleur();
        printSizeFrontDerailleur();
    }
    public Long getArticleFrontDerailleurFromCart (int a) {
        Long b = articlesFrontDerailleur.get(a);
        return b;
    }
    public int getSizeFrontDerailleur() {
        int a = articlesFrontDerailleur.size();
        return a;
    }

    //For Pedal
    public void testPrintPedal(){
        for (Long articlo : articlesPedal){
            System.out.println(articlo);
        }
    }
    public  void printSizePedal(){
        System.out.println("розмір корзини " + getSizePedal());
    }
    public void addToArticlePedal(Long article) {
        articlesPedal.add(article);
        testPrintPedal();
        getSizePedal();
        printSizePedal();
    }
    public Long getArticlePedalFromCart (int a) {
        Long b = articlesPedal.get(a);
        return b;
    }
    public int getSizePedal() {
        int a = articlesPedal.size();
        return a;
    }


    // add
    @Transactional
    public void addBackDerailleur(BackDerailleur backDerailleur) {
        backDerailleurRepository.save(backDerailleur);
    }
    @Transactional
    public  void addBackGearKas (BackGearKas backGearKas) {
        backGearKasRepository.save(backGearKas);
    }
    @Transactional
    public  void addBackGearTr(BackGearTr backGearTr) {
        backGearTrRepository.save(backGearTr);
    }
    @Transactional
    public  void addBracket (Bracket bracket) {
        bracketRepository.save(bracket);
    }
    @Transactional
    public  void addChain (Chain chain) {
        chainRepository.save(chain);
    }
    @Transactional
    public  void addCrank (Crank crank) {
        crankRepository.save(crank);
    }
    @Transactional
    public  void addFrontDerailleur (FrontDerailleur frontDerailleur) {
        frontDerailleurRepository.save(frontDerailleur);
    }
    @Transactional
    public  void addPedal (Pedal pedal) {
        pedalRepository.save(pedal);
    }
    @Transactional
    public  void addTransmissionMaker (TransmissionMaker transmissionMaker) {
        transmissionMakerRepository.save(transmissionMaker);
    }
    @Transactional
    public  void addBackSprocketMax(BackSprocketMax backSprocketMax) {
        backSprocketMaxRepository.save(backSprocketMax);
    }
    @Transactional
    public  void addBackSprocketMin (BackSprocketMin backSprocketMin) {
        backSprocketMinRepository.save(backSprocketMin);
    }
    @Transactional
    public void addBackSprocketSize(BackSprocketSize backSprocketSize) {
        backSprocketSizeRepository.save(backSprocketSize);
    }
    @Transactional
    public void addBracketAxisLength(BracketAxisLength bracketAxisLength) {
        bracketAxisLengthRepository.save(bracketAxisLength);
    }
    @Transactional
    public void addBracketWide(BracketWide bracketWide) {
        bracketWideRepository.save(bracketWide);
    }
    @Transactional
    public void addBracketType(BracketType bracketType) {
        bracketTypeRepository.save(bracketType);
    }
    @Transactional
    public  void addCarvingType (CarvingType carvingType) {
        carvingTypeRepository.save(carvingType);
    }
    @Transactional
    public  void addChainElementNumber(ChainElementNumber chainElementNumber) {
        chainElementNumberRepository.save(chainElementNumber);
    }
    @Transactional
    public  void addCollarDiam (CollarDiam collarDiam) {
        collarDiamRepository.save(collarDiam);
    }
    @Transactional
    public void addCrankLength (CrankLength crankLength) {
        crankLengthRepository.save(crankLength);
    }
    @Transactional
    public void addFrontDerailleurFixType (FrontDerailleurFixType frontDerailleurFixType) {
        frontDerailleurFixTypeRepository.save(frontDerailleurFixType);
    }
    @Transactional
    public void addFrontSprocketMax(FrontSprocketMax frontSprocketMax) {
        frontSprocketMaxRepository.save(frontSprocketMax);
    }
    @Transactional
    public void addFrontSprocketMin(FrontSprocketMin frontSprocketMin) {
        frontSprocketMinRepository.save(frontSprocketMin);
    }
    @Transactional
    public void addFrontSprocketNumber(FrontSprocketNumber frontSprocketNumber) {
        frontSprocketNumberRepository.save(frontSprocketNumber);
    }
    @Transactional
    public void addFrontSprocketSize(FrontSprocketSize frontSprocketSize) {
        frontSprocketSizeRepository.save(frontSprocketSize);
    }
    @Transactional
    public void addPawLength(PawLength pawLength) {
        pawLengthRepository.save(pawLength);
    }
    @Transactional
    public void addBackSprocketNumber(BackSprocketNumber backSprocketNumber) {
        backSprocketNumberRepository.save(backSprocketNumber);
    }
    @Transactional
    public void addBearingType(BearingType bearingType) {
        bearingTypeRepository.save(bearingType);
    }
    @Transactional
    public void addPedalType(PedalType pedalType) {
        pedalTypeRepository.save(pedalType);
    }
    @Transactional
    public void addTeethCapasity(TeethCapasity teethCapasity) {
        teethCapasityRepository.save(teethCapasity);
    }
    @Transactional
    public void addTractionType(TractionType tractionType) {
        tractionTypeRepository.save(tractionType);
    }
    @Transactional
    public void addBikeType(BikeType bikeType) {
        bikeTypeRepository.save(bikeType);
    }




//delete

    @Transactional
    public void deleteBackDerailleur(long[] idList) {
        for (long id : idList)
           backDerailleurRepository.delete(id);
    }
    @Transactional
    public void deleteBackGearKas(long[] idList) {
        for (long id : idList)
            backGearKasRepository.delete(id);
    }
    @Transactional
    public void deleteBackGearTr(long[] idList) {
        for (long id : idList)
            backGearTrRepository.delete(id);
    }
    @Transactional
    public void deleteBracket(long[] idList) {
        for (long id : idList)
           bracketRepository.delete(id);
    }
    @Transactional
    public void deleteChain(long[] idList) {
        for (long id : idList)
            chainRepository.delete(id);
    }
    @Transactional
    public void deleteCrank(long[] idList) {
        for (long id : idList)
            crankRepository.delete(id);
    }
    @Transactional
    public void deleteFrontDerailleur(long[] idList) {
        for (long id : idList)
            frontDerailleurRepository.delete(id);
    }
    @Transactional
    public void deletePedal(long[] idList) {
        for (long id : idList)
            pedalRepository.delete(id);
    }

    //find
    @Transactional(readOnly=true)
    public List<BackDerailleur> findAll(Pageable pageable) {
        return backDerailleurRepository.findAll(pageable).getContent();
    }
    @Transactional(readOnly=true)
    public List<BackGearKas> findAllOne(Pageable pageable) {
        return backGearKasRepository.findAll(pageable).getContent();
    }
    @Transactional(readOnly=true)
    public List<BackGearTr> findAllTwo(Pageable pageable) {
        return backGearTrRepository.findAll(pageable).getContent();
    }
    @Transactional(readOnly=true)
    public List<Bracket> findAllThree(Pageable pageable) {
        return bracketRepository.findAll(pageable).getContent();
    }
    @Transactional(readOnly=true)
    public List<Chain> findAllFor(Pageable pageable) {
        return chainRepository.findAll(pageable).getContent();
    }
    @Transactional(readOnly=true)
    public List<Crank> findAllFive(Pageable pageable) {
        return crankRepository.findAll(pageable).getContent();
    }
    @Transactional(readOnly=true)
    public List<FrontDerailleur> findAllSix(Pageable pageable) {
        return frontDerailleurRepository.findAll(pageable).getContent();
    }
    @Transactional(readOnly=true)
    public List<Pedal> findAllSeven(Pageable pageable) {
        return pedalRepository.findAll(pageable).getContent();
    }




    @Transactional(readOnly=true)
    public List<TransmissionMaker> findTransmissionMakers() {
        return transmissionMakerRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<BackSprocketMax> findBackSprocketMax() {
        return backSprocketMaxRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<BackSprocketMin> findBackSprocketMin() {
        return backSprocketMinRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<BackSprocketSize> findBackSprocketSize() {
        return backSprocketSizeRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<BracketAxisLength> findBracketAxisLength() {
        return bracketAxisLengthRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<BracketWide> findBracketWide() {
        return bracketWideRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<BracketType> findBracketType() {
        return bracketTypeRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<CarvingType > findCarvingType () {
        return carvingTypeRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<ChainElementNumber> findChainElementNumber() {
        return chainElementNumberRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<CollarDiam> findCollarDiam() {
        return collarDiamRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<CrankLength> findCrankLength() {
        return crankLengthRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<FrontDerailleurFixType> findFrontDerailleurFixType() {
        return frontDerailleurFixTypeRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<FrontSprocketMax> findFrontSprocketMax() {
        return frontSprocketMaxRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<FrontSprocketMin> findFrontSprocketMin() {
        return frontSprocketMinRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<FrontSprocketNumber> findFrontSprocketNumber() {
        return frontSprocketNumberRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<FrontSprocketSize> findFrontSprocketSize() {
        return frontSprocketSizeRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<PawLength> findPawLength() {
        return pawLengthRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<BackSprocketNumber> findBackSprocketNumber() {
        return backSprocketNumberRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<BearingType> findBearingType() {
        return bearingTypeRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<PedalType> findPedalType() {
        return pedalTypeRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<TeethCapasity> findTeethCapasity() {
        return teethCapasityRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<TractionType> findTractionType() {
        return tractionTypeRepository.findAll();
    }
    @Transactional(readOnly=true)
    public List<BikeType> findBikeType() {
        return bikeTypeRepository.findAll();
    }
    //findBy

    @Transactional(readOnly=true)
    public List<BackDerailleur> findByBackDerailleurMakers(TransmissionMaker transmissionMaker, Pageable pageable) {
        return backDerailleurRepository.findByTransmissionMakers(transmissionMaker, pageable);
    }
    @Transactional(readOnly=true)
    public List<BackGearKas> findByBackGearKasMakers(TransmissionMaker transmissionMaker, Pageable pageable) {
        return backGearKasRepository.findByTransmissionMakers(transmissionMaker, pageable);
    }
    @Transactional(readOnly=true)
    public List<BackGearTr> findByBackGearTrMakers(TransmissionMaker transmissionMaker, Pageable pageable) {
        return backGearTrRepository.findByTransmissionMakers(transmissionMaker, pageable);
    }
    @Transactional(readOnly=true)
    public List<Bracket> findByBracketMakers(TransmissionMaker transmissionMaker, Pageable pageable) {
        return bracketRepository.findByTransmissionMakers(transmissionMaker, pageable);
    }
    @Transactional(readOnly=true)
    public List<Chain> findByChainMakers(TransmissionMaker transmissionMaker, Pageable pageable) {
        return chainRepository.findByTransmissionMakers(transmissionMaker, pageable);
    }
    @Transactional(readOnly=true)
    public List<Crank> findByCrankMakers(TransmissionMaker transmissionMaker, Pageable pageable) {
        return crankRepository.findByTransmissionMakers(transmissionMaker, pageable);
    }
    @Transactional(readOnly=true)
    public List<FrontDerailleur> findByFrontDerailleurMakers(TransmissionMaker transmissionMaker, Pageable pageable) {
        return frontDerailleurRepository.findByTransmissionMakers(transmissionMaker, pageable);
    }
    @Transactional(readOnly=true)
    public List<Pedal> findByPedalMakers(TransmissionMaker transmissionMaker, Pageable pageable) {
        return pedalRepository.findByTransmissionMakers(transmissionMaker, pageable);
    }

    @Transactional(readOnly=true)
    public List<BackDerailleur> findBackDerailleurByArticle(Long article, Pageable pageable) {
        return backDerailleurRepository.findByArticle(article, pageable);
    }
    @Transactional(readOnly=true)
    public List<BackDerailleur> findBackDerailleurByUrl(String url, Pageable pageable) {
        return backDerailleurRepository.findByUrl(url,pageable);
    }
    @Transactional(readOnly=true)
    public List<BackGearKas> findBackGearKasByArticle(Long article, Pageable pageable) {
        return backGearKasRepository.findByArticle(article, pageable);
    }
    @Transactional(readOnly=true)
    public List<BackGearKas> findBackGearKasByUrl(String url, Pageable pageable) {
        return backGearKasRepository.findByUrl(url,pageable);
    }
    @Transactional(readOnly=true)
    public List<BackGearTr> findBackGearTrByArticle(Long article, Pageable pageable) {
        return backGearTrRepository.findByArticle(article, pageable);
    }
    @Transactional(readOnly=true)
    public List<BackGearTr> findBackGearTrByUrl(String url, Pageable pageable) {
        return backGearTrRepository.findByUrl(url,pageable);
    }
    @Transactional(readOnly=true)
    public List<Bracket> findBracketByArticle(Long article, Pageable pageable) {
        return bracketRepository.findByArticle(article, pageable);
    }
    @Transactional(readOnly=true)
    public List<Bracket> findBracketByUrl(String url, Pageable pageable) {
        return bracketRepository.findByUrl(url,pageable);
    }
    @Transactional(readOnly=true)
    public List<Chain> findChainByArticle(Long article, Pageable pageable) {
        return chainRepository.findByArticle(article, pageable);
    }
    @Transactional(readOnly=true)
    public List<Chain> findChainByUrl(String url, Pageable pageable) {
        return chainRepository.findByUrl(url,pageable);
    }
    @Transactional(readOnly=true)
    public List<Crank> findCrankByArticle(Long article, Pageable pageable) {
        return crankRepository.findByArticle(article, pageable);
    }
    @Transactional(readOnly=true)
    public List<Crank> findCrankByUrl(String url, Pageable pageable) {
        return crankRepository.findByUrl(url,pageable);
    }
    @Transactional(readOnly=true)
    public List<FrontDerailleur> findFrontDerailleurByArticle(Long article, Pageable pageable) {
        return frontDerailleurRepository.findByArticle(article, pageable);
    }
    @Transactional(readOnly=true)
    public List<FrontDerailleur> findFrontDerailleurByUrl(String url, Pageable pageable) {
        return frontDerailleurRepository.findByUrl(url,pageable);
    }
    @Transactional(readOnly=true)
    public List<Pedal> findPedalByArticle(Long article, Pageable pageable) {
        return pedalRepository.findByArticle(article, pageable);
    }
    @Transactional(readOnly=true)
    public List<Pedal> findPedalByUrl(String url, Pageable pageable) {
        return pedalRepository.findByUrl(url,pageable);
    }


    @Transactional(readOnly=true)
    public List<BackDerailleur> findByBackSprocketNumberBackDerailleur(BackSprocketNumber backSprocketNumber, Pageable pageable) {
        return backDerailleurRepository.findByBackSprocketNumber(backSprocketNumber, pageable);
    }
    @Transactional(readOnly=true)
    public List<BackDerailleur> findByBackSprocketMaxBackDerailleur(BackSprocketMax backSprocketMax, Pageable pageable) {
        return backDerailleurRepository.findByBackSprocketMax(backSprocketMax, pageable);
    }
    @Transactional(readOnly=true)
    public List<BackDerailleur> findByBackSprocketMinBackDerailleur(BackSprocketMin backSprocketMin, Pageable pageable) {
        return backDerailleurRepository.findByBackSprocketMin(backSprocketMin, pageable);
    }
    @Transactional(readOnly=true)
    public List<BackDerailleur> findByPawLength(PawLength pawLength, Pageable pageable) {
        return backDerailleurRepository.findByPawLength(pawLength, pageable);
    }
    @Transactional(readOnly=true)
    public List<BackGearKas> findByBackSprocketNumberBackGearKas(BackSprocketNumber backSprocketNumber, Pageable pageable) {
        return backGearKasRepository.findByBackSprocketNumber(backSprocketNumber, pageable);
    }
    @Transactional(readOnly=true)
    public List<BackGearKas> findByBackSprocketMaxBackGearKas(BackSprocketMax backSprocketMax, Pageable pageable) {
        return backGearKasRepository.findByBackSprocketMax ( backSprocketMax, pageable);
    }
    @Transactional(readOnly=true)
    public List<BackGearKas> findByBackSprocketMinBackGearKas(BackSprocketMin backSprocketMin, Pageable pageable) {
        return backGearKasRepository.findByBackSprocketMin(backSprocketMin, pageable);
    }
    @Transactional(readOnly=true)
    public List<BackGearKas> findByBackSprocketSizeBackGearKas(BackSprocketSize backSprocketSize, Pageable pageable) {
        return backGearKasRepository.findByBackSprocketSize(backSprocketSize, pageable);
    }
    @Transactional(readOnly=true)
    public List<BackGearTr> findByBackSprocketNumberBackGearTr(BackSprocketNumber backSprocketNumber, Pageable pageable) {
        return backGearTrRepository.findByBackSprocketNumber(backSprocketNumber, pageable);
    }
    @Transactional(readOnly=true)
    public List<BackGearTr> findByBackSprocketMaxBackGearTr(BackSprocketMax backSprocketMax, Pageable pageable) {
        return backGearTrRepository.findByBackSprocketMax ( backSprocketMax, pageable);
    }
    @Transactional(readOnly=true)
    public List<BackGearTr> findByBackSprocketMinBackGearTr(BackSprocketMin backSprocketMin, Pageable pageable) {
        return backGearTrRepository.findByBackSprocketMin(backSprocketMin, pageable);
    }
    @Transactional(readOnly=true)
    public List<BackGearTr> findByBackSprocketSizeBackGearTr(BackSprocketSize backSprocketSize, Pageable pageable) {
        return backGearTrRepository.findByBackSprocketSize(backSprocketSize, pageable);
    }
    @Transactional(readOnly=true)
    public List<Bracket> findByBracketAxisLength(BracketAxisLength bracketAxisLength, Pageable pageable) {
        return bracketRepository.findByBracketAxisLength(bracketAxisLength, pageable);
    }
    @Transactional(readOnly=true)
    public List<Bracket> findByBracketWide(BracketWide bracketWide, Pageable pageable) {
        return bracketRepository.findByBracketWide(bracketWide, pageable);
    }
    @Transactional(readOnly=true)
    public List<Bracket> findByBracketType(BracketType bracketType, Pageable pageable) {
        return bracketRepository.findByBracketType(bracketType, pageable);
    }
    @Transactional(readOnly=true)
    public List<Bracket> findByBearingTypeBracket(BearingType bearingType, Pageable pageable) {
        return bracketRepository.findByBearingType(bearingType, pageable);
    }
    @Transactional(readOnly=true)
    public List<Bracket> findByCarvingType(CarvingType carvingType, Pageable pageable) {
        return bracketRepository.findByCarvingType(carvingType, pageable);
    }
    @Transactional(readOnly=true)
    public List<Chain> findByBackSprocketNumberChain (BackSprocketNumber backSprocketNumber, Pageable pageable) {
        return chainRepository.findByBackSprocketNumber(backSprocketNumber, pageable);
    }
    @Transactional(readOnly=true)
    public List<Chain> findByChainElementNumber (ChainElementNumber chainElementNumber, Pageable pageable) {
        return chainRepository.findByChainElementNumber(chainElementNumber, pageable);
    }
    @Transactional(readOnly=true)
    public List<Crank> findByBikeType (BikeType bikeType, Pageable pageable) {
        return crankRepository.findByBikeType(bikeType, pageable);
    }
    @Transactional(readOnly=true)
    public List<Crank> findByBackSprocketNumberCrank (BackSprocketNumber backSprocketNumber, Pageable pageable) {
        return crankRepository.findByBackSprocketNumber(backSprocketNumber, pageable);
    }
    @Transactional(readOnly=true)
    public List<Crank> findByFrontSprocketNumberCrank (FrontSprocketNumber frontSprocketNumber, Pageable pageable) {
        return crankRepository.findByFrontSprocketNumber(frontSprocketNumber, pageable);
    }
    @Transactional(readOnly=true)
    public List<Crank> findByFrontSprocketSizeCrank (FrontSprocketSize frontSprocketSize, Pageable pageable) {
        return crankRepository.findByFrontSprocketSize(frontSprocketSize, pageable);
    }
    @Transactional(readOnly=true)
    public List<Crank> findByFrontSprocketMaxCrank (FrontSprocketMax frontSprocketMax, Pageable pageable) {
        return crankRepository.findByFrontSprocketMax(frontSprocketMax, pageable);
    }
    @Transactional(readOnly=true)
    public List<Crank> findByFrontSprocketMin(FrontSprocketMin frontSprocketMin, Pageable pageable) {
        return crankRepository.findByFrontSprocketMin(frontSprocketMin, pageable);
    }
    @Transactional(readOnly=true)
    public List<Crank> findByCrankLength (CrankLength crankLength, Pageable pageable) {
        return crankRepository.findByCrankLength(crankLength, pageable);
    }
    @Transactional(readOnly=true)
    public List<Crank> findByBracketTypeCrank (BracketType bracketType, Pageable pageable) {
        return crankRepository.findByBracketType(bracketType, pageable);
    }
    @Transactional(readOnly=true)
    public List<FrontDerailleur> findByFrontSprocketNumberFrontDerailleur (FrontSprocketNumber frontSprocketNumber, Pageable pageable) {
        return frontDerailleurRepository.findByFrontSprocketNumber(frontSprocketNumber, pageable);
    }
    @Transactional(readOnly=true)
    public List<FrontDerailleur> findByBackSprocketNumberFrontDerailleur (BackSprocketNumber backSprocketNumber, Pageable pageable) {
        return frontDerailleurRepository.findByBackSprocketNumber(backSprocketNumber, pageable);
    }
    @Transactional(readOnly=true)
    public List<FrontDerailleur> findByFrontSprocketMaxFrontDerailleur (FrontSprocketMax frontSprocketMax, Pageable pageable) {
        return frontDerailleurRepository.findByFrontSprocketMax (frontSprocketMax, pageable);
    }
    @Transactional(readOnly=true)
    public List<FrontDerailleur> findByFrontSprocketMinFrontDerailleur (FrontSprocketMin frontSprocketMin, Pageable pageable) {
        return frontDerailleurRepository.findByFrontSprocketMin(frontSprocketMin, pageable);
    }
    @Transactional(readOnly=true)
    public List<FrontDerailleur> findByTeethCapasity(TeethCapasity teethCapasity, Pageable pageable) {
        return frontDerailleurRepository.findByTeethCapasity(teethCapasity, pageable);
    }
    @Transactional(readOnly=true)
    public List<FrontDerailleur> findByFrontDerailleurFixType (FrontDerailleurFixType frontDerailleurFixType, Pageable pageable) {
        return frontDerailleurRepository.findByFrontDerailleurFixType(frontDerailleurFixType, pageable);
    }
    @Transactional(readOnly=true)
    public List<FrontDerailleur> findByCollarDiam (CollarDiam collarDiam, Pageable pageable) {
        return frontDerailleurRepository.findByCollarDiam(collarDiam, pageable);
    }
   @Transactional(readOnly=true)
    public List<FrontDerailleur> findByTractionType (TractionType tractionType, Pageable pageable) {
        return frontDerailleurRepository.findByTractionType(tractionType, pageable);
    }
    @Transactional(readOnly=true)
    public List<Pedal> findByPedalType (PedalType pedalType, Pageable pageable) {
        return pedalRepository.findByPedalType(pedalType, pageable);
    }
    @Transactional(readOnly=true)
    public List<Pedal> findByBearingTypePedal (BearingType bearingType, Pageable pageable) {
        return pedalRepository.findByBearingType(bearingType, pageable);
    }








// count by


    @Transactional(readOnly = true)
    public long countByBackDerailleurMaker(TransmissionMaker transmissionMaker) {
        return backDerailleurRepository.countByTransmissionMakers(transmissionMaker);
    }
    @Transactional(readOnly = true)
    public long countByBackGearKasMaker(TransmissionMaker transmissionMaker) {
        return backGearKasRepository.countByTransmissionMakers(transmissionMaker);
    }
    @Transactional(readOnly = true)
    public long countByBackGearTrMaker(TransmissionMaker transmissionMaker) {
        return backGearTrRepository.countByTransmissionMakers(transmissionMaker);
    }
    @Transactional(readOnly = true)
    public long countByBracketMaker(TransmissionMaker transmissionMaker) {
        return bracketRepository.countByTransmissionMakers(transmissionMaker);
    }
    @Transactional(readOnly = true)
    public long countByChainMaker(TransmissionMaker transmissionMaker) {
        return chainRepository.countByTransmissionMakers(transmissionMaker);
    }
    @Transactional(readOnly = true)
    public long countByCrankMaker(TransmissionMaker transmissionMaker) {
        return crankRepository.countByTransmissionMakers(transmissionMaker);
    }
    @Transactional(readOnly = true)
    public long countByFrontDerailleurMaker(TransmissionMaker transmissionMaker) {
        return frontDerailleurRepository.countByTransmissionMakers(transmissionMaker);
    }
    @Transactional(readOnly = true)
    public long countByPedalMaker(TransmissionMaker transmissionMaker) {
        return pedalRepository.countByTransmissionMakers(transmissionMaker);
    }











    @Transactional(readOnly = true)
    public long countBackDerailleur() {
        return backDerailleurRepository.count();
    }

    @Transactional(readOnly = true)
    public long countBackGearKas() {
        return backGearKasRepository.count();
    }

    @Transactional(readOnly = true)
    public long countBackGearTr() {
        return backGearTrRepository.count();
    }
    @Transactional(readOnly = true)
    public long countBracket() {
        return bracketRepository.count();
    }
    @Transactional(readOnly = true)
    public long countChain() {
        return chainRepository.count();
    }
    @Transactional(readOnly = true)
    public long countCrank() {
        return crankRepository.count();
    }
    @Transactional(readOnly = true)
    public long countFrontDerailleur() {
        return frontDerailleurRepository.count();
    }
    @Transactional(readOnly = true)
    public long countPedal() {
        return pedalRepository.count();
    }


    //find
    @Transactional(readOnly=true)
    public TransmissionMaker findTransmissionMaker(long id) {
        return transmissionMakerRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public BackSprocketMax findBackSprocketMax(long id) {
        return backSprocketMaxRepository.findOne(id);
    }
    @Transactional(readOnly=true)
    public BackSprocketMin findBackSprocketMin(long id) {
        return backSprocketMinRepository.findOne(id);
    }
    @Transactional(readOnly=true)
    public BackSprocketSize findBackSprocketSize(long id) {
        return backSprocketSizeRepository.findOne(id);
    }
    @Transactional(readOnly=true)
    public BackSprocketNumber findBackSprocketNumber(long id) {
        return backSprocketNumberRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public BracketAxisLength findBracketAxisLength(long id) {
        return bracketAxisLengthRepository.findOne(id);
    }


    @Transactional(readOnly=true)
    public BracketWide findBracketWide(long id) {
        return bracketWideRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public BracketType findBracketType(long id) {
        return bracketTypeRepository.findOne(id);
    }
    @Transactional(readOnly=true)
    public CarvingType findCarvingType(long id) {
        return carvingTypeRepository.findOne(id);
    }
    @Transactional(readOnly=true)
    public ChainElementNumber findChainElementNumber(long id) {
        return chainElementNumberRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public CollarDiam findCollarDiam(long id) {
        return collarDiamRepository.findOne(id);
    }
    @Transactional(readOnly=true)
    public CrankLength findCrankLength(long id) {
        return crankLengthRepository.findOne(id);
    }
    @Transactional(readOnly=true)
    public FrontDerailleurFixType findFrontDerailleurFixType(long id) {
        return frontDerailleurFixTypeRepository.findOne(id);
    }
    @Transactional(readOnly=true)
    public FrontSprocketMax findFrontSprocketMax(long id) {
        return frontSprocketMaxRepository.findOne(id);
    }
    @Transactional(readOnly=true)
    public FrontSprocketMin findFrontSprocketMin(long id) {
        return frontSprocketMinRepository.findOne(id);
    }
    @Transactional(readOnly=true)
    public FrontSprocketNumber findFrontSprocketNumber(long id) {
        return frontSprocketNumberRepository.findOne(id);
    }
    @Transactional(readOnly=true)
    public FrontSprocketSize findFrontSprocketSize(long id) {
        return frontSprocketSizeRepository.findOne(id);
    }
    @Transactional(readOnly=true)
    public PawLength findPawLength(long id) {
        return pawLengthRepository.findOne(id);
    }
    @Transactional(readOnly=true)
    public PedalType findPedalType(long id) {
        return pedalTypeRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public TeethCapasity findTeethCapasity(long id) {
        return teethCapasityRepository.findOne(id);
    }
    @Transactional(readOnly=true)
    public TractionType findTractionType(long id) {
        return tractionTypeRepository.findOne(id);
    }
    @Transactional(readOnly=true)
    public BearingType findBearingType(long id) {
        return bearingTypeRepository.findOne(id);
    }

    @Transactional(readOnly=true)
    public BikeType findBikeType(long id) {
        return bikeTypeRepository.findOne(id);
    }

}
