package beetle.controller;

import beetle.entity.Manufacturer;
import beetle.entity.frame.BikeType;
import beetle.entity.wheels.BackSprocketNumber;
import beetle.entity.wheels.BearingType;
import beetle.service.WheelService;
import beetle.entity.transmission.*;
import beetle.service.TransmissionService;
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

    //return page with links to pages with components
    @RequestMapping("/show_transmissionComponent")
    public String brakesComponentsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        return "transmissionComponents";
    }

    //for admin with all brakes components
    @RequestMapping("/admin/show_transmissions")
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
        model.addAttribute("backDerailleurs", backDerailleurs);
        model.addAttribute("backGearKass", backGearKass);
        model.addAttribute("backGearTrs", backGearTrs);
        model.addAttribute("brackets", brackets);
        model.addAttribute("chains", chains);
        model.addAttribute("cranks", cranks);
        model.addAttribute("frontDerailleurs", frontDerailleurs);
        model.addAttribute("pedals", pedals);
        model.addAttribute("allPages", getPageCount());
        return "transmissionsAdmin";
    }

    // return pages with type of brakes components

    @RequestMapping("/show_backDerailleurs")
    public String backDerailleursVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<BackDerailleur> backDerailleurs = transmissionService
                .findAll(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("backDerailleurs", backDerailleurs);
        model.addAttribute("allPages", getPageCount());
        return "backDerailleurs";
    }

    @RequestMapping("/show_backGearKass")
    public String backGearKassVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<BackGearKas> backGearKass = transmissionService
                .findAllOne(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("backGearKass", backGearKass);
        model.addAttribute("allPages", getPageCount());
        return "backGearKass";
    }

    @RequestMapping("/show_backGearTrs")
    public String backGearTrsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<BackGearTr> backGearTrs = transmissionService
                .findAllTwo(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("backGearTrs", backGearTrs);
        model.addAttribute("allPages", getPageCount());
        return "backGearTrs";
    }

    @RequestMapping("/show_brackets")
    public String bracketsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Bracket> brackets = transmissionService
                .findAllThree(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("brackets", brackets);
        model.addAttribute("allPages", getPageCount());
        return "brackets";
    }

    @RequestMapping("/show_chains")
    public String chainsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Chain>  chains = transmissionService
                .findAllFor(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("chains", chains);
        model.addAttribute("allPages", getPageCount());
        return "chains";
    }

    @RequestMapping("/show_cranks")
    public String cranksVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Crank> cranks = transmissionService
                .findAllFive(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("cranks", cranks);
        model.addAttribute("allPages", getPageCount());
        return "cranks";
    }

    @RequestMapping("/show_frontDerailleurs")
    public String frontDerailleursVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<FrontDerailleur> frontDerailleurs = transmissionService
                .findAllSix(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("frontDerailleurs", frontDerailleurs);
        model.addAttribute("allPages", getPageCount());
        return "frontDerailleurs";
    }

    @RequestMapping("/show_pedals")
    public String pedalsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        List<Pedal> pedals  = transmissionService
                .findAllSeven(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("pedals", pedals);
        model.addAttribute("allPages", getPageCount());
        return "pedals";
    }

    //add components from browser

    @RequestMapping("/admin/backDerailleur_add_page")
    public String backDerailleurAddPage(Model model) {
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("backSprocketMax", transmissionService.findBackSprocketMax());
        model.addAttribute("backSprocketMin", transmissionService.findBackSprocketMin());
        model.addAttribute("backSprocketNumber", transmissionService.findBackSprocketNumber());
        model.addAttribute("pawLength", transmissionService.findPawLength());
        return "backDerailleur_add_page";
    }

    @RequestMapping("/admin/backGearKas_add_page")
    public String backGearKasAddPage(Model model) {
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("backSprocketMax", transmissionService.findBackSprocketMax());
        model.addAttribute("backSprocketMin", transmissionService.findBackSprocketMin());
        model.addAttribute("backSprocketNumber", transmissionService.findBackSprocketNumber());
        model.addAttribute("backSprocketSize", transmissionService.findBackSprocketSize());
        return "backGearKas_add_page";
    }

    @RequestMapping("/admin/backGearTr_add_page")
    public String backGearTrAddPage(Model model) {
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("backSprocketMax", transmissionService.findBackSprocketMax());
        model.addAttribute("backSprocketMin", transmissionService.findBackSprocketMin());
        model.addAttribute("backSprocketNumber", transmissionService.findBackSprocketNumber());
        model.addAttribute("backSprocketSize", transmissionService.findBackSprocketSize());

        return "backGearTr_add_page";
    }

    @RequestMapping("/admin/bracket_add_page")
    public String bracketAddPage(Model model) {
        model.addAttribute("bracketAxisLength", transmissionService.findBracketAxisLength());
        model.addAttribute("bracketWide", transmissionService.findBracketWide());
        model.addAttribute("bracketType", transmissionService.findBracketType());
        model.addAttribute("carvingType", transmissionService.findCarvingType());
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("bearingType", transmissionService.findBearingType());

        return "bracket_add_page";
    }

    @RequestMapping("/admin/chain_add_page")
    public String chainAddPage(Model model) {
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("backSprocketNumber", transmissionService.findBackSprocketNumber());
        model.addAttribute("chainElementNumber", transmissionService.findChainElementNumber());
        return "chain_add_page";
    }

    @RequestMapping("/admin/crank_add_page")
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

    @RequestMapping("/admin/frontDerailleur_add_page")
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

    @RequestMapping("/admin/pedal_add_page")
    public String pedalAddPage(Model model) {
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("bearingType", transmissionService.findBearingType());
        model.addAttribute("pedalType", transmissionService.findPedalType());
        return "pedal_add_page";
    }

    @RequestMapping("/admin/transmissionMaker_add_page")
    public String transmissionMakerAddPage() {
        return "transmissionMaker_add_page";
    }

    // for filter by Maker
    @RequestMapping("/transmissionMaker/{id}")
    public String listTransmissionMaker(
            @PathVariable(value = "id") long transmissionMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        Manufacturer transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
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

    //for delete components for admin

    @RequestMapping(value = "/admin/backDerailleur/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> delete(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            transmissionService.deleteBackDerailleur(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/backGearKas/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteOne(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            transmissionService.deleteBackGearKas(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/backGearTr/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteTwo(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            transmissionService.deleteBackGearTr(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/bracket/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteThree(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            transmissionService.deleteBracket(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/chain/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteFor(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            transmissionService.deleteChain(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/crank/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteFive(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            transmissionService.deleteCrank(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/frontDerailleur/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteSix(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            transmissionService.deleteFrontDerailleur(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/admin/pedal/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteSeven(@RequestParam(value = "toDelete[]", required = false) long[] toDelete) {
        if (toDelete != null && toDelete.length > 0)
            transmissionService.deletePedal(toDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    // Add components to database
    @RequestMapping(value="/admin/backDerailleur/add", method = RequestMethod.POST)
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
        //todo migrate to mapper
        Manufacturer transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        BackSprocketNumber backSprocketNumber = (backSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketNumber(backSprocketNumberId) : null;
        BackSprocketMax backSprocketMax = (backSprocketMaxId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketMax(backSprocketMaxId) : null;
        BackSprocketMin backSprocketMin = (backSprocketMinId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketMin(backSprocketMinId) : null;
        PawLength pawLength = (pawLengthId != DEFAULT_GROUP_ID) ? transmissionService.findPawLength(pawLengthId) : null;
//        BackDerailleur backDerailleur = new BackDerailleur(transmissionMaker,article,url,name,backSprocketNumber,backSprocketMax,
//                backSprocketMin,pawLength,material,weight,color,description,price,way);
//        transmissionService.addBackDerailleur(backDerailleur);
        return "redirect:/show_backDerailleurs";
    }

    @RequestMapping(value="/admin/backGearKas/add", method = RequestMethod.POST)
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
        //todo migrate to mapper
        Manufacturer transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        BackSprocketNumber backSprocketNumber = (backSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketNumber(backSprocketNumberId) : null;
        BackSprocketMax backSprocketMax = (backSprocketMaxId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketMax(backSprocketMaxId) : null;
        BackSprocketMin backSprocketMin = (backSprocketMinId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketMin(backSprocketMinId) : null;
        BackSprocketSize backSprocketSize = (backSprocketSizeId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketSize(backSprocketSizeId) : null;
//        BackGearKas backGearKas = new BackGearKas(transmissionMaker,article,url,name,backSprocketNumber,backSprocketMax,backSprocketMin,
//                backSprocketSize,material,color,description,price,way);
//        transmissionService.addBackGearKas(backGearKas);
        return "redirect:/show_backGearKass";
    }

    @RequestMapping(value="/admin/backGearTr/add", method = RequestMethod.POST)
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
        Manufacturer transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        BackSprocketNumber backSprocketNumber = (backSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketNumber(backSprocketNumberId) : null;
        BackSprocketMax backSprocketMax = (backSprocketMaxId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketMax(backSprocketMaxId) : null;
        BackSprocketMin backSprocketMin = (backSprocketMinId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketMin(backSprocketMinId) : null;
        BackSprocketSize backSprocketSize = (backSprocketSizeId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketSize(backSprocketSizeId) : null;
//        BackGearTr backGearTr = new BackGearTr(transmissionMaker,article,url,name,backSprocketNumber,backSprocketMax,backSprocketMin,
//                backSprocketSize,material,color,description,price,way);
//        transmissionService.addBackGearTr(backGearTr);
        return "redirect:/show_backGearTrs";
    }

    @RequestMapping(value="/admin/bracket/add", method = RequestMethod.POST)
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
        //todo migrate to mapper
        Manufacturer transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        BracketAxisLength bracketAxisLength = (bracketAxisLengthId != DEFAULT_GROUP_ID) ? transmissionService.findBracketAxisLength(bracketAxisLengthId) : null;
        BracketWide bracketWide = (bracketWideId != DEFAULT_GROUP_ID) ? transmissionService.findBracketWide(bracketWideId) : null;
        BracketType bracketType = (bracketTypeId != DEFAULT_GROUP_ID) ? transmissionService.findBracketType(bracketTypeId) : null;
        BearingType bearingType = (bearingTypeId != DEFAULT_GROUP_ID) ? transmissionService.findBearingType(bearingTypeId) : null;
        CarvingType carvingType = (carvingTypeId != DEFAULT_GROUP_ID) ? transmissionService.findCarvingType(carvingTypeId) : null;
//        Bracket bracket = new Bracket(transmissionMaker,article, url,name,bracketAxisLength, bracketWide, bracketType,bearingType,axisMaterial,carvingType,color,description,price,way);
//        transmissionService.addBracket(bracket);
        return "redirect:/show_brackets";
    }

    @RequestMapping(value="/admin/chain/add", method = RequestMethod.POST)
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
        //todo migrate to mapper
        Manufacturer transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        BackSprocketNumber backSprocketNumber = (backSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketNumber(backSprocketNumberId) : null;
        ChainElementNumber chainElementNumber = (chainElementNumberId != DEFAULT_GROUP_ID) ? transmissionService.findChainElementNumber(chainElementNumberId) : null;
//        Chain chain = new Chain(transmissionMaker,article,url,name,backSprocketNumber,chainElementNumber,weight,material,color,description,price,way);
//        transmissionService.addChain(chain);
        return "redirect:/show_chains";
    }

    @RequestMapping(value="/admin/crank/add", method = RequestMethod.POST)
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
        Manufacturer transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        BikeType bikeType = (bikeTypeId != DEFAULT_GROUP_ID) ? transmissionService.findBikeType(bikeTypeId) : null;
        BackSprocketNumber backSprocketNumber = (backSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketNumber(backSprocketNumberId) : null;
        FrontSprocketNumber frontSprocketNumber = (frontSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findFrontSprocketNumber(frontSprocketNumberId) : null;
        FrontSprocketSize frontSprocketSize = (frontSprocketSizeId != DEFAULT_GROUP_ID) ? transmissionService.findFrontSprocketSize(frontSprocketSizeId) : null;
        FrontSprocketMax frontSprocketMax = (frontSprocketMaxId != DEFAULT_GROUP_ID) ? transmissionService.findFrontSprocketMax(frontSprocketMaxId) : null;
        FrontSprocketMin frontSprocketMin = (frontSprocketMinId != DEFAULT_GROUP_ID) ? transmissionService.findFrontSprocketMin(frontSprocketMinId) : null;
        CrankLength crankLength = (crankLengthId != DEFAULT_GROUP_ID) ? transmissionService.findCrankLength(crankLengthId) : null;
        BracketType bracketType = (bracketTypeId != DEFAULT_GROUP_ID) ? transmissionService.findBracketType(bracketTypeId) : null;
//        Crank crank = new Crank(transmissionMaker,article,url,name,bikeType,backSprocketNumber,frontSprocketNumber,frontSprocketSize,frontSprocketMax,
//                frontSprocketMin,crankLength,sprocketMaterial,crankMaterial, bracketType,color,description,price,way);
//        transmissionService.addCrank(crank);
        return "redirect:/show_cranks";
    }

    @RequestMapping(value="/admin/frontDerailleur/add", method = RequestMethod.POST)
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
        Manufacturer transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        BackSprocketNumber backSprocketNumber = (backSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketNumber(backSprocketNumberId) : null;
        FrontSprocketNumber frontSprocketNumber = (frontSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findFrontSprocketNumber(frontSprocketNumberId) : null;
        TeethCapasity teethCapasity = (teethCapasityId != DEFAULT_GROUP_ID) ? transmissionService.findTeethCapasity(teethCapasityId) : null;
        FrontSprocketMax frontSprocketMax = (frontSprocketMaxId != DEFAULT_GROUP_ID) ? transmissionService.findFrontSprocketMax(frontSprocketMaxId) : null;
        FrontSprocketMin frontSprocketMin = (frontSprocketMinId != DEFAULT_GROUP_ID) ? transmissionService.findFrontSprocketMin(frontSprocketMinId) : null;
        FrontDerailleurFixType frontDerailleurFixType = (frontDerailleurFixTypeId != DEFAULT_GROUP_ID) ? transmissionService.findFrontDerailleurFixType(frontDerailleurFixTypeId) : null;
        CollarDiam collarDiam = (collarDiamId != DEFAULT_GROUP_ID) ? transmissionService.findCollarDiam(collarDiamId) : null;
        TractionType tractionType = (tractionTypeId != DEFAULT_GROUP_ID) ? transmissionService.findTractionType(tractionTypeId) : null;
//        FrontDerailleur frontDerailleur = new FrontDerailleur(transmissionMaker,article,url,name,frontSprocketNumber,backSprocketNumber,frontSprocketMax,frontSprocketMin,
//                teethCapasity,chainLine,frontDerailleurFixType,collarDiam,tractionType,material,weight,color,description,price,way);
//        transmissionService.addFrontDerailleur(frontDerailleur);
        return "redirect:/show_frontDerailleurs";
    }

    @RequestMapping(value="/admin/pedal/add", method = RequestMethod.POST)
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
        Manufacturer transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        PedalType pedalType = (pedalTypeId != DEFAULT_GROUP_ID) ? transmissionService.findPedalType(pedalTypeId) : null;
        BearingType bearingType = (bearingTypeId != DEFAULT_GROUP_ID) ? transmissionService.findBearingType(bearingTypeId) : null;
//        Pedal pedal = new Pedal(transmissionMaker,article,url,name,pedalType,bearingType,sizes,material,weight,color,description,price,way);
//        transmissionService.addPedal(pedal);
        return "redirect:/show_pedals";
    }

    //Add Maker to database
    @RequestMapping(value="/admin/transmissionMaker/add", method = RequestMethod.POST)
    public String transmissionMakerAdd(@RequestParam String name) {
        transmissionService.addTransmissionMaker(new Manufacturer(name));
        return "redirect:/admin/show_transmissions";
    }

    // Select one product by url and open in separate page

    @RequestMapping("/backDerailleur/{url}")
    public String listBackDerailleurUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<BackDerailleur> backDerailleurs = transmissionService
                .findBackDerailleurByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("backDerailleurs", backDerailleurs);
        return "OneBackDerailleur";
    }

    @RequestMapping("/backGearKas/{url}")
    public String listBackGearKasUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<BackGearKas> backGearKass = transmissionService
                .findBackGearKasByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("backGearKass", backGearKass);
        return "OneBackGearKas";
    }

    @RequestMapping("/backGearTr/{url}")
    public String listBackGearTrUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<BackGearTr> backGearTrs = transmissionService
                .findBackGearTrByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("backGearTrs", backGearTrs);
        return "OneBackGearTr";
    }

    @RequestMapping("/bracket/{url}")
    public String listBracketUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<Bracket> brackets = transmissionService
                .findBracketByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("brackets", brackets);
        return "OneBracket";
    }

    @RequestMapping("/chain/{url}")
    public String listChainUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<Chain> chains = transmissionService
                .findChainByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("chains", chains);
        return "OneChain";
    }

    @RequestMapping("/crank/{url}")
    public String listCrankUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<Crank> cranks = transmissionService
                .findCrankByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("cranks", cranks);
        return "OneCrank";
    }

    @RequestMapping("/frontDerailleur/{url}")
    public String listFrontDerailleurUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<FrontDerailleur> frontDerailleurs = transmissionService
                .findFrontDerailleurByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("frontDerailleurs", frontDerailleurs);
        return "OneFrontDerailleur";
    }

    @RequestMapping("/pedal/{url}")
    public String listPedalUrl(
            @PathVariable(value = "url") String url,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        List<Pedal> pedals = transmissionService
                .findPedalByUrl(url, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("pedals", pedals);
        return "OnePedal";
    }


    private long getPageCount() {
        long totalCount = wheelService.count();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountBackDerailleurMaker(Manufacturer transmissionMaker) {
        long totalCount = transmissionService.countByBackDerailleurMaker(transmissionMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountBackGearKasMaker(Manufacturer transmissionMaker) {
        long totalCount = transmissionService.countByBackGearKasMaker(transmissionMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountBackGearTrMaker(Manufacturer transmissionMaker) {
        long totalCount = transmissionService.countByBackGearTrMaker(transmissionMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountBracketMaker(Manufacturer transmissionMaker) {
        long totalCount = transmissionService.countByBracketMaker(transmissionMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountChainMaker(Manufacturer transmissionMaker) {
        long totalCount = transmissionService.countByChainMaker(transmissionMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountCrankMaker(Manufacturer transmissionMaker) {
        long totalCount = transmissionService.countByCrankMaker(transmissionMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountFrontDerailleurMaker(Manufacturer transmissionMaker) {
        long totalCount = transmissionService.countByFrontDerailleurMaker(transmissionMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountPedalMaker(Manufacturer transmissionMaker) {
        long totalCount = transmissionService.countByPedalMaker(transmissionMaker);
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }

}

