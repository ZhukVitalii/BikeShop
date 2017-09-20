package beetle.Transmissions;

import beetle.Bakes.BikeType;
import beetle.Wheels.BackSprocketNumber;
import beetle.Wheels.BearingType;
import beetle.Wheels.WheelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by VitaliiZhuk on 02.07.2017.
 */
@Controller
public class TransmissionController {
    static final int DEFAULT_GROUP_ID = -1;
    static final int ITEMS_PER_PAGE = 6;




    @Autowired
    private TransmissionService transmissionService;
    @Autowired
    private WheelService wheelService;





    @RequestMapping("/show_transmissions")
    public String transmissionsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;

        List<BackDerailleur> backDerailleurs = transmissionService
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<BackGearKas> backGearKass = transmissionService
                .findAllOne(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<BackGearTr> backGearTrs = transmissionService
                .findAllTwo(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Bracket> brackets = transmissionService
                .findAllThree(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Chain>  chains = transmissionService
                .findAllFor(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Crank> cranks = transmissionService
                .findAllFive(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<FrontDerailleur> frontDerailleurs = transmissionService
                .findAllSix(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Pedal> pedals  = transmissionService
                .findAllSeven(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));



        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("backSprocketMax", transmissionService.findBackSprocketMax());
        model.addAttribute("backSprocketMin", transmissionService.findBackSprocketMin());
        model.addAttribute("backSprocketSize", transmissionService.findBackSprocketSize());
        model.addAttribute("bracketAxisLength", transmissionService.findBracketAxisLength());
        model.addAttribute("bracketWide", transmissionService.findBracketWide());
        model.addAttribute("bracketType", transmissionService.findBracketType());
        model.addAttribute("carvingType", transmissionService.findCarvingType());
        model.addAttribute("chainElementNumber", transmissionService.findChainElementNumber());
        model.addAttribute("collarDiam", transmissionService.findCollarDiam());
        model.addAttribute("crankLength", transmissionService.findCrankLength());
        model.addAttribute("frontDerailleurFixType", transmissionService.findFrontDerailleurFixType());
        model.addAttribute("frontSprocketMax", transmissionService.findFrontSprocketMax());
        model.addAttribute("frontSprocketMin", transmissionService.findFrontSprocketMin());
        model.addAttribute("frontSprocketNumber", transmissionService.findFrontSprocketNumber());
        model.addAttribute("frontSprocketSize", transmissionService.findFrontSprocketSize());
        model.addAttribute("pawLength", transmissionService.findPawLength());
        model.addAttribute("backSprocketNumber", transmissionService.findBackSprocketNumber());
        model.addAttribute("bearingType", transmissionService.findBearingType());
        model.addAttribute("pedalType", transmissionService.findPedalType());
        model.addAttribute("teethCapasity", transmissionService.findTeethCapasity());
        model.addAttribute("tractionType", transmissionService.findTractionType());
        model.addAttribute("bikeType", transmissionService.findBikeType());




        model.addAttribute("backDerailleurs", backDerailleurs);
        model.addAttribute("backGearKass", backGearKass);
        model.addAttribute("backGearTrs", backGearTrs);
        model.addAttribute("brackets", brackets);
        model.addAttribute("chains", chains);
        model.addAttribute("cranks", cranks);
        model.addAttribute("frontDerailleurs", frontDerailleurs);
        model.addAttribute("pedals", pedals);
        model.addAttribute("allPages", getPageCount());


        return "transmissions";
    }

    @RequestMapping("/backDerailleur_add_page")
    public String backDerailleurAddPage(Model model) {
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("backSprocketMax", transmissionService.findBackSprocketMax());
        model.addAttribute("backSprocketMin", transmissionService.findBackSprocketMin());
        model.addAttribute("backSprocketNumber", transmissionService.findBackSprocketNumber());
        model.addAttribute("pawLength", transmissionService.findPawLength());
        return "backDerailleur_add_page";
    }
    @RequestMapping("/backGearKas_add_page")
    public String backGearKasAddPage(Model model) {
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("backSprocketMax", transmissionService.findBackSprocketMax());
        model.addAttribute("backSprocketMin", transmissionService.findBackSprocketMin());
        model.addAttribute("backSprocketNumber", transmissionService.findBackSprocketNumber());
        model.addAttribute("backSprocketSize", transmissionService.findBackSprocketSize());

        return "backGearKas_add_page";
    }
    @RequestMapping("/backGearTr_add_page")
    public String backGearTrAddPage(Model model) {
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("backSprocketMax", transmissionService.findBackSprocketMax());
        model.addAttribute("backSprocketMin", transmissionService.findBackSprocketMin());
        model.addAttribute("backSprocketNumber", transmissionService.findBackSprocketNumber());
        model.addAttribute("backSprocketSize", transmissionService.findBackSprocketSize());

        return "backGearTr_add_page";
    }
    @RequestMapping("/bracket_add_page")
    public String bracketAddPage(Model model) {
        model.addAttribute("bracketAxisLength", transmissionService.findBracketAxisLength());
        model.addAttribute("bracketWide", transmissionService.findBracketWide());
        model.addAttribute("bracketType", transmissionService.findBracketType());
        model.addAttribute("carvingType", transmissionService.findCarvingType());
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("bearingType", transmissionService.findBearingType());

        return "bracket_add_page";
    }
    @RequestMapping("/chain_add_page")
    public String chainAddPage(Model model) {
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("backSprocketNumber", transmissionService.findBackSprocketNumber());
        model.addAttribute("chainElementNumber", transmissionService.findChainElementNumber());
        return "chain_add_page";
    }
    @RequestMapping("/crank_add_page")
    public String crankAddPage(Model model) {
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("frontSprocketMax", transmissionService.findFrontSprocketMax());
        model.addAttribute("frontSprocketMin", transmissionService.findFrontSprocketMin());
        model.addAttribute("frontSprocketNumber", transmissionService.findFrontSprocketNumber());
        model.addAttribute("frontSprocketSize", transmissionService.findFrontSprocketSize());
        model.addAttribute("backSprocketNumber", transmissionService.findBackSprocketNumber());
        model.addAttribute("bikeType", transmissionService.findBikeType());
        model.addAttribute("crankLength", transmissionService.findCrankLength());
        model.addAttribute("bracketType", transmissionService.findBracketType());

        return "crank_add_page";
    }
    @RequestMapping("/frontDerailleur_add_page")
    public String frontDerailleurAddPage(Model model) {
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("frontDerailleurFixType", transmissionService.findFrontDerailleurFixType());
        model.addAttribute("frontSprocketMax", transmissionService.findFrontSprocketMax());
        model.addAttribute("frontSprocketMin", transmissionService.findFrontSprocketMin());
        model.addAttribute("frontSprocketNumber", transmissionService.findFrontSprocketNumber());
        model.addAttribute("teethCapasity", transmissionService.findTeethCapasity());
        model.addAttribute("tractionType", transmissionService.findTractionType());
        model.addAttribute("backSprocketNumber", transmissionService.findBackSprocketNumber());
        model.addAttribute("collarDiam", transmissionService.findCollarDiam());

        return "frontDerailleur_add_page";
    }
    @RequestMapping("/pedal_add_page")
    public String pedalAddPage(Model model) {
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("bearingType", transmissionService.findBearingType());
        model.addAttribute("pedalType", transmissionService.findPedalType());


        return "pedal_add_page";
    }



    @RequestMapping("/transmissionMaker_add_page")
    public String transmissionMakerAddPage() {
        return "transmissionMaker_add_page";
    }



    @RequestMapping("/transmissionMaker/{id}")
    public String listTransmissionMaker(
            @PathVariable(value = "id") long transmissionMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;


        if (page < 0) page = 0;

        List<BackDerailleur> backDerailleurs  = transmissionService
                .findByBackDerailleurMakers(transmissionMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        List<BackGearKas> backGearKass  = transmissionService
                .findByBackGearKasMakers(transmissionMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        List<BackGearTr> backGearTrs = transmissionService
                .findByBackGearTrMakers(transmissionMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        List<Bracket> brackets  = transmissionService
                .findByBracketMakers(transmissionMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        List<Chain> chains  = transmissionService
                .findByChainMakers(transmissionMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        List<Crank> cranks  = transmissionService
                .findByCrankMakers(transmissionMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        List<FrontDerailleur> frontDerailleurs  = transmissionService
                .findByFrontDerailleurMakers(transmissionMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));

        List<Pedal> pedals  = transmissionService
                .findByPedalMakers(transmissionMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));


        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("backDerailleurs", backDerailleurs);
        model.addAttribute("backGearKass", backGearKass);
        model.addAttribute("backGearTrs", backGearTrs);
        model.addAttribute("brackets", brackets);
        model.addAttribute("chains", chains);
        model.addAttribute("cranks", cranks);
        model.addAttribute("frontDerailleurs", frontDerailleurs);
        model.addAttribute("pedals", pedals);


        model.addAttribute("byBackDerailleurMakerPages", getPageCountBackDerailleurMaker(transmissionMaker));
        model.addAttribute("byBackGearKasMakerPages", getPageCountBackGearKasMaker(transmissionMaker));
        model.addAttribute("byBackGearTrMakerPages", getPageCountBackGearTrMaker(transmissionMaker));
        model.addAttribute("byBracketMakerPages", getPageCountBracketMaker(transmissionMaker));
        model.addAttribute("byChainMakerPages", getPageCountChainMaker(transmissionMaker));
        model.addAttribute("byCrankMakerPages", getPageCountCrankMaker(transmissionMaker));
        model.addAttribute("byFrontDerailleurMakerPages", getPageCountFrontDerailleurMaker(transmissionMaker));
        model.addAttribute("byPedalMakerPages", getPageCountPedalMaker(transmissionMaker));

        model.addAttribute("groupId", transmissionMakerId);

        return "transmissions";
    }

    @RequestMapping(value = "/backDerailleur/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> delete(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            transmissionService.deleteBackDerailleur(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/backGearKas/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteOne(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            transmissionService.deleteBackGearKas(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/backGearTr/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteTwo(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            transmissionService.deleteBackGearTr(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/bracket/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteThree(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            transmissionService.deleteBracket(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/chain/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteFor(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            transmissionService.deleteChain(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/crank/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteFive(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            transmissionService.deleteCrank(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/frontDerailleur/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteSix(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            transmissionService.deleteFrontDerailleur(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }
    @RequestMapping(value = "/pedal/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteSeven(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            transmissionService.deletePedal(toDelete);

        return new ResponseEntity<>(HttpStatus.OK);
    }




    @RequestMapping(value="/backDerailleur/add", method = RequestMethod.POST)
    public String backDerailleurAdd(
            @RequestParam(value = "transmissionMaker") long transmissionMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "backSprocketNumber") long backSprocketNumberId,
            @RequestParam(value = "backSprocketMax") long backSprocketMaxId,
            @RequestParam(value = "backSprocketMin") long backSprocketMinId,
            @RequestParam(value = "pawLength") long pawLengthId,
            @RequestParam String material,
            @RequestParam String weight,
            @RequestParam String color,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String way)
    {
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        BackSprocketNumber backSprocketNumber = (backSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketNumber(backSprocketNumberId) : null;
        BackSprocketMax backSprocketMax = (backSprocketMaxId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketMax(backSprocketMaxId) : null;
        BackSprocketMin backSprocketMin = (backSprocketMinId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketMin(backSprocketMinId) : null;
        PawLength pawLength = (pawLengthId != DEFAULT_GROUP_ID) ? transmissionService.findPawLength(pawLengthId) : null;

        BackDerailleur backDerailleur = new BackDerailleur(transmissionMaker,article,url,name,backSprocketNumber,backSprocketMax,
                backSprocketMin,pawLength,material,weight,color,description,price,way);

        transmissionService.addBackDerailleur(backDerailleur);
        return "redirect:/show_transmissions";
    }


    @RequestMapping(value="/backGearKas/add", method = RequestMethod.POST)
    public String backGearKasAdd(
            @RequestParam(value = "transmissionMaker") long transmissionMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "backSprocketNumber") long backSprocketNumberId,
            @RequestParam(value = "backSprocketMax") long backSprocketMaxId,
            @RequestParam(value = "backSprocketMin") long backSprocketMinId,
            @RequestParam(value = "backSprocketSize") long backSprocketSizeId,
            @RequestParam String material,
            @RequestParam String color,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String way)
    {
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        BackSprocketNumber backSprocketNumber = (backSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketNumber(backSprocketNumberId) : null;
        BackSprocketMax backSprocketMax = (backSprocketMaxId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketMax(backSprocketMaxId) : null;
        BackSprocketMin backSprocketMin = (backSprocketMinId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketMin(backSprocketMinId) : null;
        BackSprocketSize backSprocketSize = (backSprocketSizeId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketSize(backSprocketSizeId) : null;

        BackGearKas backGearKas = new BackGearKas(transmissionMaker,article,url,name,backSprocketNumber,backSprocketMax,backSprocketMin,
                backSprocketSize,material,color,description,price,way);


        transmissionService.addBackGearKas(backGearKas);

        return "redirect:/show_transmissions";
    }

    @RequestMapping(value="/backGearTr/add", method = RequestMethod.POST)
    public String backGearTrAdd(
            @RequestParam(value = "transmissionMaker") long transmissionMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "backSprocketNumber") long backSprocketNumberId,
            @RequestParam(value = "backSprocketMax") long backSprocketMaxId,
            @RequestParam(value = "backSprocketMin") long backSprocketMinId,
            @RequestParam(value = "backSprocketSize") long backSprocketSizeId,
            @RequestParam String material,
            @RequestParam String color,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String way)
    {
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        BackSprocketNumber backSprocketNumber = (backSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketNumber(backSprocketNumberId) : null;
        BackSprocketMax backSprocketMax = (backSprocketMaxId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketMax(backSprocketMaxId) : null;
        BackSprocketMin backSprocketMin = (backSprocketMinId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketMin(backSprocketMinId) : null;
        BackSprocketSize backSprocketSize = (backSprocketSizeId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketSize(backSprocketSizeId) : null;

        BackGearTr backGearTr = new BackGearTr(transmissionMaker,article,url,name,backSprocketNumber,backSprocketMax,backSprocketMin,
                backSprocketSize,material,color,description,price,way);


        transmissionService.addBackGearTr(backGearTr);

        return "redirect:/show_transmissions";
    }

    @RequestMapping(value="/bracket/add", method = RequestMethod.POST)
    public String bracketAdd(
            @RequestParam(value = "transmissionMaker") long transmissionMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "bracketAxisLength") long bracketAxisLengthId,
            @RequestParam(value = "bracketWide") long bracketWideId,
            @RequestParam(value = "bracketType") long bracketTypeId,
            @RequestParam(value = "bearingType") long bearingTypeId,
            @RequestParam(value = "carvingType") long carvingTypeId,
            @RequestParam String axisMaterial,
            @RequestParam String color,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String way)
    {
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        BracketAxisLength bracketAxisLength = (bracketAxisLengthId != DEFAULT_GROUP_ID) ? transmissionService.findBracketAxisLength(bracketAxisLengthId) : null;
        BracketWide bracketWide = (bracketWideId != DEFAULT_GROUP_ID) ? transmissionService.findBracketWide(bracketWideId) : null;
        BracketType bracketType = (bracketTypeId != DEFAULT_GROUP_ID) ? transmissionService.findBracketType(bracketTypeId) : null;
        BearingType bearingType = (bearingTypeId != DEFAULT_GROUP_ID) ? transmissionService.findBearingType(bearingTypeId) : null;
        CarvingType carvingType = (carvingTypeId != DEFAULT_GROUP_ID) ? transmissionService.findCarvingType(carvingTypeId) : null;

        Bracket bracket = new Bracket(transmissionMaker,article, url,name,bracketAxisLength, bracketWide,bracketType,bearingType,axisMaterial,carvingType,color,description,price,way);

        transmissionService.addBracket(bracket);

        return "redirect:/show_transmissions";
    }

    @RequestMapping(value="/chain/add", method = RequestMethod.POST)
    public String chainAdd(
            @RequestParam(value = "transmissionMaker") long transmissionMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "backSprocketNumber") long backSprocketNumberId,
            @RequestParam(value = "chainElementNumber") long chainElementNumberId,
            @RequestParam String weight,
            @RequestParam String material,
            @RequestParam String color,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String way)
    {
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        BackSprocketNumber backSprocketNumber = (backSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketNumber(backSprocketNumberId) : null;
        ChainElementNumber chainElementNumber = (chainElementNumberId != DEFAULT_GROUP_ID) ? transmissionService.findChainElementNumber(chainElementNumberId) : null;

        Chain chain = new Chain(transmissionMaker,article,url,name,backSprocketNumber,chainElementNumber,weight,material,color,description,price,way);

        transmissionService.addChain(chain);

        return "redirect:/show_transmissions";
    }

    @RequestMapping(value="/crank/add", method = RequestMethod.POST)
    public String crankAdd(
            @RequestParam(value = "transmissionMaker") long transmissionMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "bikeType") long bikeTypeId,
            @RequestParam(value = "backSprocketNumber") long backSprocketNumberId,
            @RequestParam(value = "frontSprocketNumber") long frontSprocketNumberId,
            @RequestParam(value = "frontSprocketSize") long frontSprocketSizeId,
            @RequestParam(value = "frontSprocketMax") long frontSprocketMaxId,
            @RequestParam(value = "frontSprocketMin") long frontSprocketMinId,
            @RequestParam(value = "crankLength") long crankLengthId,
            @RequestParam String sprocketMaterial,
            @RequestParam String crankMaterial,
            @RequestParam(value = "bracketType") long bracketTypeId,
            @RequestParam String color,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String way)
    {
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        BikeType bikeType = (bikeTypeId != DEFAULT_GROUP_ID) ? transmissionService.findBikeType(bikeTypeId) : null;
        BackSprocketNumber backSprocketNumber = (backSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketNumber(backSprocketNumberId) : null;
        FrontSprocketNumber frontSprocketNumber = (frontSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findFrontSprocketNumber(frontSprocketNumberId) : null;
        FrontSprocketSize frontSprocketSize = (frontSprocketSizeId != DEFAULT_GROUP_ID) ? transmissionService.findFrontSprocketSize(frontSprocketSizeId) : null;
        FrontSprocketMax frontSprocketMax = (frontSprocketMaxId != DEFAULT_GROUP_ID) ? transmissionService.findFrontSprocketMax(frontSprocketMaxId) : null;
        FrontSprocketMin frontSprocketMin = (frontSprocketMinId != DEFAULT_GROUP_ID) ? transmissionService.findFrontSprocketMin(frontSprocketMinId) : null;
        CrankLength crankLength = (crankLengthId != DEFAULT_GROUP_ID) ? transmissionService.findCrankLength(crankLengthId) : null;
        BracketType bracketType = (bracketTypeId != DEFAULT_GROUP_ID) ? transmissionService.findBracketType(bikeTypeId) : null;

        Crank crank = new Crank(transmissionMaker,article,url,name,bikeType,backSprocketNumber,frontSprocketNumber,frontSprocketSize,frontSprocketMax,
                frontSprocketMin,crankLength,sprocketMaterial,crankMaterial,bracketType,color,description,price,way);

        transmissionService.addCrank(crank);
        return "redirect:/show_transmissions";
    }


    @RequestMapping(value="/frontDerailleur/add", method = RequestMethod.POST)
    public String frontDerailleurAdd(
            @RequestParam(value = "transmissionMaker") long transmissionMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "frontSprocketNumber") long frontSprocketNumberId,
            @RequestParam(value = "backSprocketNumber") long backSprocketNumberId,
            @RequestParam(value = "frontSprocketMax") long frontSprocketMaxId,
            @RequestParam(value = "frontSprocketMin") long frontSprocketMinId,
            @RequestParam(value = "teethCapasity") long teethCapasityId,
            @RequestParam String chainLine,
            @RequestParam(value = "frontDerailleurFixType") long frontDerailleurFixTypeId,
            @RequestParam(value = "collarDiam") long collarDiamId,
            @RequestParam(value = "tractionType") long tractionTypeId,
            @RequestParam String material,
            @RequestParam String weight,
            @RequestParam String color,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String way)
    {
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        BackSprocketNumber backSprocketNumber = (backSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketNumber(backSprocketNumberId) : null;
        FrontSprocketNumber frontSprocketNumber = (frontSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findFrontSprocketNumber(frontSprocketNumberId) : null;
        TeethCapasity teethCapasity = (teethCapasityId != DEFAULT_GROUP_ID) ? transmissionService.findTeethCapasity(teethCapasityId) : null;
        FrontSprocketMax frontSprocketMax = (frontSprocketMaxId != DEFAULT_GROUP_ID) ? transmissionService.findFrontSprocketMax(frontSprocketMaxId) : null;
        FrontSprocketMin frontSprocketMin = (frontSprocketMinId != DEFAULT_GROUP_ID) ? transmissionService.findFrontSprocketMin(frontSprocketMinId) : null;
        FrontDerailleurFixType frontDerailleurFixType = (frontDerailleurFixTypeId != DEFAULT_GROUP_ID) ? transmissionService.findFrontDerailleurFixType(frontDerailleurFixTypeId) : null;
        CollarDiam collarDiam = (collarDiamId != DEFAULT_GROUP_ID) ? transmissionService.findCollarDiam(collarDiamId) : null;
        TractionType tractionType = (tractionTypeId != DEFAULT_GROUP_ID) ? transmissionService.findTractionType(tractionTypeId) : null;

        FrontDerailleur frontDerailleur = new FrontDerailleur(transmissionMaker,article,url,name,frontSprocketNumber,backSprocketNumber,frontSprocketMax,frontSprocketMin,
                teethCapasity,chainLine,frontDerailleurFixType,collarDiam,tractionType,material,weight,color,description,price,way);

        transmissionService.addFrontDerailleur(frontDerailleur);
        return "redirect:/show_transmissions";
    }

    @RequestMapping(value="/pedal/add", method = RequestMethod.POST)
    public String pedalAdd(
            @RequestParam(value = "transmissionMaker") long transmissionMakerId,
            @RequestParam Long article,
            @RequestParam String url,
            @RequestParam String name,
            @RequestParam(value = "pedalType") long pedalTypeId,
            @RequestParam(value = "bearingType") long bearingTypeId,
            @RequestParam String sizes,
            @RequestParam String material,
            @RequestParam String weight,
            @RequestParam String color,
            @RequestParam String description,
            @RequestParam Double price,
            @RequestParam String way)
    {
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        PedalType pedalType = (pedalTypeId != DEFAULT_GROUP_ID) ? transmissionService.findPedalType(pedalTypeId) : null;
        BearingType bearingType = (bearingTypeId != DEFAULT_GROUP_ID) ? transmissionService.findBearingType(bearingTypeId) : null;

        Pedal pedal = new Pedal(transmissionMaker,article,url,name,pedalType,bearingType,sizes,material,weight,color,description,price,way);

        transmissionService.addPedal(pedal);
        return "redirect:/show_transmissions";
    }





    @RequestMapping(value="/transmissionMaker/add", method = RequestMethod.POST)
    public String transmissionMakerAdd(@RequestParam String name) {
        transmissionService.addTransmissionMaker(new TransmissionMaker(name));
        return "redirect:/show_transmissions";
    }





    private long getPageCount() {
        long totalCount = wheelService.count();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }


    private long getPageCountBackDerailleurMaker(TransmissionMaker transmissionMaker) {
        long totalCount = transmissionService.countByBackDerailleurMaker(transmissionMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountBackGearKasMaker(TransmissionMaker transmissionMaker) {
        long totalCount = transmissionService.countByBackGearKasMaker(transmissionMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountBackGearTrMaker(TransmissionMaker transmissionMaker) {
        long totalCount = transmissionService.countByBackGearTrMaker(transmissionMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountBracketMaker(TransmissionMaker transmissionMaker) {
        long totalCount = transmissionService.countByBracketMaker(transmissionMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountChainMaker(TransmissionMaker transmissionMaker) {
        long totalCount = transmissionService.countByChainMaker(transmissionMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountCrankMaker(TransmissionMaker transmissionMaker) {
        long totalCount = transmissionService.countByCrankMaker(transmissionMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountFrontDerailleurMaker(TransmissionMaker transmissionMaker) {
        long totalCount = transmissionService.countByFrontDerailleurMaker(transmissionMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountPedalMaker(TransmissionMaker transmissionMaker) {
        long totalCount = transmissionService.countByPedalMaker(transmissionMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }



}

