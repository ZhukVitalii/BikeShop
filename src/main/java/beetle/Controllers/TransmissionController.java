package beetle.Controllers;

import beetle.Entities.Frames.BikeType;
import beetle.Entities.Transmission.*;
import beetle.Services.TransmissionService;
import beetle.Entities.Wheels.BackSprocketNumber;
import beetle.Entities.Wheels.BearingType;
import beetle.Services.WheelService;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                .findAllBackDerailleur(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<BackGearKas> backGearKass = transmissionService
                .findAllBackGearKas(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<BackGearTr> backGearTrs = transmissionService
                .findAllBackGearTr(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Bracket> brackets = transmissionService
                .findAllBracket(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Chain>  chains = transmissionService
                .findAllChain(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Crank> cranks = transmissionService
                .findAllCrank(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<FrontDerailleur> frontDerailleurs = transmissionService
                .findAllFrontDerailleur(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        List<Pedal> pedals  = transmissionService
                .findAllPedal(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("transmissionMakers", transmissionService.findTransmissionMakers());
        model.addAttribute("backDerailleurs", backDerailleurs);
        model.addAttribute("backGearKass", backGearKass);
        model.addAttribute("backGearTrs", backGearTrs);
        model.addAttribute("brackets", brackets);
        model.addAttribute("chains", chains);
        model.addAttribute("cranks", cranks);
        model.addAttribute("frontDerailleurs", frontDerailleurs);
        model.addAttribute("pedals", pedals);
        return "transmissionsAdmin";
    }

    // return pages with type of brakes components

    @RequestMapping("/show_BackDerailleur")
    public String backDerailleursVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        Set<TransmissionMaker> transmissionMakers = new HashSet<>();
        List<BackDerailleur> backDerailleurs = transmissionService
                .findAllBackDerailleur(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (BackDerailleur backDerailleur : backDerailleurs) {
            transmissionMakers.add(backDerailleur.getMaker());
        }
        model.addAttribute("productMakers",transmissionMakers);
        model.addAttribute("products", backDerailleurs);
        model.addAttribute("allPages", getPageCountBackDerailleur());
        return "product";
    }

    @RequestMapping("/show_BackGearKas")
    public String backGearKassVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        Set<TransmissionMaker> transmissionMakers = new HashSet<>();
        List<BackGearKas> backGearKass = transmissionService
                .findAllBackGearKas(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (BackGearKas gearKass : backGearKass) {
            transmissionMakers.add(gearKass.getMaker());
        }
        model.addAttribute("productMakers", transmissionMakers);
        model.addAttribute("products", backGearKass);
        model.addAttribute("allPages", getPageCountBackGearKas());
        return "product";
    }

    @RequestMapping("/show_BackGearTr")
    public String backGearTrsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        Set<TransmissionMaker> transmissionMakers = new HashSet<>();
        List<BackGearTr> backGearTrs = transmissionService
                .findAllBackGearTr(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (BackGearTr backGearTr : backGearTrs) {
            transmissionMakers.add(backGearTr.getMaker());
        }
        model.addAttribute("productMakers", transmissionMakers);
        model.addAttribute("products", backGearTrs);
        model.addAttribute("allPages", getPageCountBackGearTr());
        return "product";
    }

    @RequestMapping("/show_Bracket")
    public String bracketsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        Set<TransmissionMaker> transmissionMakers = new HashSet<>();
        List<Bracket> brackets = transmissionService
                .findAllBracket(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (Bracket bracket : brackets) {
            transmissionMakers.add(bracket.getMaker());
        }
        model.addAttribute("productMakers", transmissionMakers);
        model.addAttribute("products", brackets);
        model.addAttribute("allPages", getPageCountBracket());
        return "product";
    }

    @RequestMapping("/show_Chain")
    public String chainsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        Set<TransmissionMaker> transmissionMakers = new HashSet<>();
        List<Chain>  chains = transmissionService
                .findAllChain(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (Chain chain : chains) {
            transmissionMakers.add(chain.getMaker());
        }
        model.addAttribute("productMakers", transmissionMakers);
        model.addAttribute("products", chains);
        model.addAttribute("allPages", getPageCountChain());
        return "product";
    }

    @RequestMapping("/show_Crank")
    public String cranksVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        Set<TransmissionMaker> transmissionMakers = new HashSet<>();
        List<Crank> cranks = transmissionService
                .findAllCrank(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (Crank crank : cranks) {
            transmissionMakers.add(crank.getMaker());
        }
        model.addAttribute("productMakers", transmissionMakers);
        model.addAttribute("products", cranks);
        model.addAttribute("allPages", getPageCountCrank());
        return "product";
    }

    @RequestMapping("/show_FrontDerailleur")
    public String frontDerailleursVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        Set<TransmissionMaker> transmissionMakers = new HashSet<>();
        List<FrontDerailleur> frontDerailleurs = transmissionService
                .findAllFrontDerailleur(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (FrontDerailleur frontDerailleur : frontDerailleurs) {
            transmissionMakers.add(frontDerailleur.getMaker());
        }
        model.addAttribute("productMakers", transmissionMakers);
        model.addAttribute("products", frontDerailleurs);
        model.addAttribute("allPages", getPageCountFrontDerailleur());
        return "product";
    }

    @RequestMapping("/show_Pedal")
    public String pedalsVeiw(Model model, @RequestParam(required = false, defaultValue = "0") Integer page) {
        if (page < 0) page = 0;
        Set<TransmissionMaker> transmissionMakers = new HashSet<>();
        List<Pedal> pedals  = transmissionService
                .findAllPedal(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (Pedal pedal : pedals) {
            transmissionMakers.add(pedal.getMaker());
        }
        model.addAttribute("productMakers", transmissionMakers);
        model.addAttribute("products", pedals);
        model.addAttribute("allPages", getPageCountPedal());
        return "product";
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
    public String listTransmissionMakerAdmin(
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
    @RequestMapping("/TransmissionMaker/BackDerailleur/{id}")
    public String listBackDerailleurMaker(
            @PathVariable(value = "id") long transmissionMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        if (page < 0) page = 0;
        List<BackDerailleur> backDerailleursAll = transmissionService.findAllBackDerailleur(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        Set<TransmissionMaker> transmissionMakers = new HashSet<>();
        List<BackDerailleur> backDerailleurs  = transmissionService
                .findByBackDerailleurMakers(transmissionMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (BackDerailleur backDerailleur : backDerailleursAll) {
            transmissionMakers.add(backDerailleur.getMaker());
        }
        model.addAttribute("productMakers", transmissionMakers);
        model.addAttribute("products", backDerailleurs);
        model.addAttribute("byGroupPages", getPageCountBackDerailleurMaker(transmissionMaker));
        model.addAttribute("groupId", transmissionMakerId);
        return "product";
    }
    @RequestMapping("/TransmissionMaker/BackGearKas/{id}")
    public String listBackGearKasMaker(
            @PathVariable(value = "id") long transmissionMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        if (page < 0) page = 0;
        List<BackGearKas> backGearKasAll = transmissionService.findAllBackGearKas(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        Set<TransmissionMaker> transmissionMakers = new HashSet<>();
        List<BackGearKas> backGearKass  = transmissionService
                .findByBackGearKasMakers(transmissionMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (BackGearKas backGearKas : backGearKasAll) {
            transmissionMakers.add(backGearKas.getMaker());
        }
        model.addAttribute("productMakers", transmissionMakers);
        model.addAttribute("products", backGearKass);
        model.addAttribute("byGroupPages", getPageCountBackGearKasMaker(transmissionMaker));
        model.addAttribute("groupId", transmissionMakerId);
        return "product";
    }
    @RequestMapping("/TransmissionMaker/BackGearTr/{id}")
    public String listBackGearTrMaker(
            @PathVariable(value = "id") long transmissionMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        if (page < 0) page = 0;
        List<BackGearTr> backGearTrsAll = transmissionService.findAllBackGearTr(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        Set<TransmissionMaker> transmissionMakers = new HashSet<>();
        List<BackGearTr> backGearTrs = transmissionService
                .findByBackGearTrMakers(transmissionMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (BackGearTr backGearTr : backGearTrsAll) {
            transmissionMakers.add(backGearTr.getMaker());
        }
        model.addAttribute("productMakers", transmissionMakers);
        model.addAttribute("products", backGearTrs);
        model.addAttribute("byGroupPages", getPageCountBackGearTrMaker(transmissionMaker));
        model.addAttribute("groupId", transmissionMakerId);
        return "product";
    }
    @RequestMapping("/TransmissionMaker/Bracket/{id}")
    public String listBracketnMaker(
            @PathVariable(value = "id") long transmissionMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        if (page < 0) page = 0;
        List<Bracket> bracketsAll = transmissionService.findAllBracket(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        Set<TransmissionMaker> transmissionMakers = new HashSet<>();
        List<Bracket> brackets  = transmissionService
                .findByBracketMakers(transmissionMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (Bracket bracket : bracketsAll) {
            transmissionMakers.add(bracket.getMaker());
        }
        model.addAttribute("productMakers", transmissionMakers);
        model.addAttribute("products", brackets);
        model.addAttribute("byGroupPages", getPageCountBracketMaker(transmissionMaker));
        model.addAttribute("groupId", transmissionMakerId);
        return "product";
    }
    @RequestMapping("/TransmissionMaker/Chain/{id}")
    public String listChainMaker(
            @PathVariable(value = "id") long transmissionMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        if (page < 0) page = 0;
        List<Chain> chainsAll = transmissionService.findAllChain(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        Set<TransmissionMaker> transmissionMakers = new HashSet<>();
        List<Chain> chains  = transmissionService
                .findByChainMakers(transmissionMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (Chain chain : chainsAll) {
            transmissionMakers.add(chain.getMaker());
        }
        model.addAttribute("productMakers", transmissionMakers);
        model.addAttribute("products", chains);
        model.addAttribute("byGroupPages", getPageCountChainMaker(transmissionMaker));
        model.addAttribute("groupId", transmissionMakerId);
        return "product";
    }
    @RequestMapping("/TransmissionMaker/Crank/{id}")
    public String listCranknMaker(
            @PathVariable(value = "id") long transmissionMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        if (page < 0) page = 0;
        List<Crank> cranksAll = transmissionService.findAllCrank(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        Set<TransmissionMaker> transmissionMakers = new HashSet<>();
        List<Crank> cranks  = transmissionService
                .findByCrankMakers(transmissionMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (Crank crank : cranksAll) {
            transmissionMakers.add(crank.getMaker());
        }
        model.addAttribute("productMakers", transmissionMakers);
        model.addAttribute("products", cranks);
        model.addAttribute("byGroupPages", getPageCountCrankMaker(transmissionMaker));
        model.addAttribute("groupId", transmissionMakerId);
        return "product";
    }
    @RequestMapping("/TransmissionMaker/FrontDerailleur/{id}")
    public String listFrontDerailleurMaker(
            @PathVariable(value = "id") long transmissionMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        if (page < 0) page = 0;
        List<FrontDerailleur> frontDerailleursAll = transmissionService.findAllFrontDerailleur(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        Set<TransmissionMaker> transmissionMakers = new HashSet<>();
        for (FrontDerailleur frontDerailleur : frontDerailleursAll) {
            transmissionMakers.add(frontDerailleur.getMaker());
        }
        List<FrontDerailleur> frontDerailleurs  = transmissionService
                .findByFrontDerailleurMakers(transmissionMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        model.addAttribute("productMakers", transmissionMakers);
        model.addAttribute("products", frontDerailleurs);
        model.addAttribute("byGroupPages", getPageCountFrontDerailleurMaker(transmissionMaker));
        model.addAttribute("groupId", transmissionMakerId);
        return "product";
    }
    @RequestMapping("/TransmissionMaker/Pedal/{id}")
    public String listPedalMaker(
            @PathVariable(value = "id") long transmissionMakerId,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        if (page < 0) page = 0;
        List<Pedal> pedalsAll = transmissionService.findAllPedal(new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        Set<TransmissionMaker> transmissionMakers = new HashSet<>();
        List<Pedal> pedals  = transmissionService
                .findByPedalMakers(transmissionMaker, new PageRequest(page, ITEMS_PER_PAGE, Sort.Direction.DESC, "id"));
        for (Pedal pedal : pedalsAll) {
            transmissionMakers.add(pedal.getMaker());
        }
        model.addAttribute("productMakers", transmissionMakers);
        model.addAttribute("products", pedals);
        model.addAttribute("byGroupPages", getPageCountPedalMaker(transmissionMaker));
        model.addAttribute("groupId", transmissionMakerId);
        return "product";
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
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        BackSprocketNumber backSprocketNumber = (backSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketNumber(backSprocketNumberId) : null;
        BackSprocketMax backSprocketMax = (backSprocketMaxId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketMax(backSprocketMaxId) : null;
        BackSprocketMin backSprocketMin = (backSprocketMinId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketMin(backSprocketMinId) : null;
        PawLength pawLength = (pawLengthId != DEFAULT_GROUP_ID) ? transmissionService.findPawLength(pawLengthId) : null;
        BackDerailleur backDerailleur = new BackDerailleur(transmissionMaker,article,url,name,backSprocketNumber,backSprocketMax,
                backSprocketMin,pawLength,material,weight,color,description,price,way);
        transmissionService.addBackDerailleur(backDerailleur);
        return "redirect:/show_BackDerailleur";
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
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        BackSprocketNumber backSprocketNumber = (backSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketNumber(backSprocketNumberId) : null;
        BackSprocketMax backSprocketMax = (backSprocketMaxId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketMax(backSprocketMaxId) : null;
        BackSprocketMin backSprocketMin = (backSprocketMinId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketMin(backSprocketMinId) : null;
        BackSprocketSize backSprocketSize = (backSprocketSizeId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketSize(backSprocketSizeId) : null;
        BackGearKas backGearKas = new BackGearKas(transmissionMaker,article,url,name,backSprocketNumber,backSprocketMax,backSprocketMin,
                backSprocketSize,material,color,description,price,way);
        transmissionService.addBackGearKas(backGearKas);
        return "redirect:/show_BackGearKas";
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
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        BackSprocketNumber backSprocketNumber = (backSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketNumber(backSprocketNumberId) : null;
        BackSprocketMax backSprocketMax = (backSprocketMaxId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketMax(backSprocketMaxId) : null;
        BackSprocketMin backSprocketMin = (backSprocketMinId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketMin(backSprocketMinId) : null;
        BackSprocketSize backSprocketSize = (backSprocketSizeId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketSize(backSprocketSizeId) : null;
        BackGearTr backGearTr = new BackGearTr(transmissionMaker,article,url,name,backSprocketNumber,backSprocketMax,backSprocketMin,
                backSprocketSize,material,color,description,price,way);
        transmissionService.addBackGearTr(backGearTr);
        return "redirect:/show_BackGearTr";
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
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        BracketAxisLength bracketAxisLength = (bracketAxisLengthId != DEFAULT_GROUP_ID) ? transmissionService.findBracketAxisLength(bracketAxisLengthId) : null;
        BracketWide bracketWide = (bracketWideId != DEFAULT_GROUP_ID) ? transmissionService.findBracketWide(bracketWideId) : null;
        BracketType bracketType = (bracketTypeId != DEFAULT_GROUP_ID) ? transmissionService.findBracketType(bracketTypeId) : null;
        BearingType bearingType = (bearingTypeId != DEFAULT_GROUP_ID) ? transmissionService.findBearingType(bearingTypeId) : null;
        CarvingType carvingType = (carvingTypeId != DEFAULT_GROUP_ID) ? transmissionService.findCarvingType(carvingTypeId) : null;
        Bracket bracket = new Bracket(transmissionMaker,article, url,name,bracketAxisLength, bracketWide, bracketType,bearingType,axisMaterial,carvingType,color,description,price,way);
        transmissionService.addBracket(bracket);
        return "redirect:/show_Bracket";
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
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        BackSprocketNumber backSprocketNumber = (backSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketNumber(backSprocketNumberId) : null;
        ChainElementNumber chainElementNumber = (chainElementNumberId != DEFAULT_GROUP_ID) ? transmissionService.findChainElementNumber(chainElementNumberId) : null;
        Chain chain = new Chain(transmissionMaker,article,url,name,backSprocketNumber,chainElementNumber,weight,material,color,description,price,way);
        transmissionService.addChain(chain);
        return "redirect:/show_Chain";
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
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        BikeType bikeType = (bikeTypeId != DEFAULT_GROUP_ID) ? transmissionService.findBikeType(bikeTypeId) : null;
        BackSprocketNumber backSprocketNumber = (backSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findBackSprocketNumber(backSprocketNumberId) : null;
        FrontSprocketNumber frontSprocketNumber = (frontSprocketNumberId != DEFAULT_GROUP_ID) ? transmissionService.findFrontSprocketNumber(frontSprocketNumberId) : null;
        FrontSprocketSize frontSprocketSize = (frontSprocketSizeId != DEFAULT_GROUP_ID) ? transmissionService.findFrontSprocketSize(frontSprocketSizeId) : null;
        FrontSprocketMax frontSprocketMax = (frontSprocketMaxId != DEFAULT_GROUP_ID) ? transmissionService.findFrontSprocketMax(frontSprocketMaxId) : null;
        FrontSprocketMin frontSprocketMin = (frontSprocketMinId != DEFAULT_GROUP_ID) ? transmissionService.findFrontSprocketMin(frontSprocketMinId) : null;
        CrankLength crankLength = (crankLengthId != DEFAULT_GROUP_ID) ? transmissionService.findCrankLength(crankLengthId) : null;
        BracketType bracketType = (bracketTypeId != DEFAULT_GROUP_ID) ? transmissionService.findBracketType(bracketTypeId) : null;
        Crank crank = new Crank(transmissionMaker,article,url,name,bikeType,backSprocketNumber,frontSprocketNumber,frontSprocketSize,frontSprocketMax,
                frontSprocketMin,crankLength,sprocketMaterial,crankMaterial, bracketType,color,description,price,way);
        transmissionService.addCrank(crank);
        return "redirect:/show_Crank";
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
        return "redirect:/show_FrontDerailleur";
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
        TransmissionMaker transmissionMaker = (transmissionMakerId != DEFAULT_GROUP_ID) ? transmissionService.findTransmissionMaker(transmissionMakerId) : null;
        PedalType pedalType = (pedalTypeId != DEFAULT_GROUP_ID) ? transmissionService.findPedalType(pedalTypeId) : null;
        BearingType bearingType = (bearingTypeId != DEFAULT_GROUP_ID) ? transmissionService.findBearingType(bearingTypeId) : null;
        Pedal pedal = new Pedal(transmissionMaker,article,url,name,pedalType,bearingType,sizes,material,weight,color,description,price,way);
        transmissionService.addPedal(pedal);
        return "redirect:/show_Pedal";
    }

    //Add Maker to database
    @RequestMapping(value="/admin/transmissionMaker/add", method = RequestMethod.POST)
    public String transmissionMakerAdd(@RequestParam String name) {
        transmissionService.addTransmissionMaker(new TransmissionMaker(name));
        return "redirect:/admin/show_transmissions";
    }

    // Select one product by url and open in separate page

    @RequestMapping("/BackDerailleur/{url}/{id}")
    public String listBackDerailleurUrl(
            @PathVariable(value = "url") String url,
            @PathVariable(value = "id") long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        BackDerailleur backDerailleur = transmissionService.findBackDerailleur(id);
        model.addAttribute("product", backDerailleur);
        return "oneProduct";
    }

    @RequestMapping("/BackGearKas/{url}/{id}")
    public String listBackGearKasUrl(
            @PathVariable(value = "url") String url,
            @PathVariable(value = "id") long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        BackGearKas backGearKas = transmissionService.findBackGearKas(id);
        model.addAttribute("product", backGearKas);
        return "oneProduct";
    }

    @RequestMapping("/BackGearTr/{url}/{id}")
    public String listBackGearTrUrl(
            @PathVariable(value = "url") String url,
            @PathVariable(value = "id") long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        BackGearTr backGearTr = transmissionService.findBackGearTr(id);
        model.addAttribute("product", backGearTr);
        return "oneProduct";
    }

    @RequestMapping("/Bracket/{url}/{id}")
    public String listBracketUrl(
            @PathVariable(value = "url") String url,
            @PathVariable(value = "id") long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        Bracket bracket = transmissionService.findBracket(id);
        model.addAttribute("product", bracket);
        return "oneProduct";
    }

    @RequestMapping("/Chain/{url}/{id}")
    public String listChainUrl(
            @PathVariable(value = "url") String url,
            @PathVariable(value = "id") long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        Chain chain = transmissionService.findChain(id);
        model.addAttribute("product", chain);
        return "oneProduct";
    }

    @RequestMapping("/Crank/{url}/{id}")
    public String listCrankUrl(
            @PathVariable(value = "url") String url,
            @PathVariable(value = "id") long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        Crank crank = transmissionService.findCrank(id);
        model.addAttribute("product", crank);
        return "oneProduct";
    }

    @RequestMapping("/FrontDerailleur/{url}/{id}")
    public String listFrontDerailleurUrl(
            @PathVariable(value = "url") String url,
            @PathVariable(value = "id") long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        FrontDerailleur frontDerailleur = transmissionService.findFrontDerailleur(id);
        model.addAttribute("product", frontDerailleur);
        return "oneProduct";
    }

    @RequestMapping("/Pedal/{url}/{id}")
    public String listPedalUrl(
            @PathVariable(value = "url") String url,
            @PathVariable(value = "id") long id,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            Model model)
    {
        if (page < 0) page = 0;
        Pedal pedal = transmissionService.findPedal(id);
        model.addAttribute("product", pedal);
        return "oneProduct";
    }

    private long getPageCountBackDerailleur() {
        long totalCount = transmissionService.countBackDerailleur();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountBackGearKas() {
        long totalCount = transmissionService.countBackGearKas();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountBackGearTr() {
        long totalCount = transmissionService.countBackGearTr();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountChain() {
        long totalCount = transmissionService.countChain();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountCrank() {
        long totalCount = transmissionService.countCrank();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountPedal() {
        long totalCount = transmissionService.countPedal();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountFrontDerailleur() {
        long totalCount = transmissionService.countFrontDerailleur();
        return (totalCount / ITEMS_PER_PAGE) + ((totalCount % ITEMS_PER_PAGE > 0) ? 1 : 0);
    }
    private long getPageCountBracket() {
        long totalCount = transmissionService.countBracket();
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

