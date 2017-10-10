package beetle;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VitaliiZhuk on 03.10.2017.
 */
@Service
public class UserService {



    //Lists with articles of components, that user added to cart
    public List<Long> idOfComponents = new ArrayList<>(25);

    // full list 0
    public void addAllId() {
        long a =0;
        idOfComponents.add(a);
    }
    /*
    * 0 el = frame
    * 1 el = fork
    * 2 el = BrakeDiscHydraulic
    * 3 el = BrakeDiscMechanik
    * 4 el = BrakeHandle
    * 5 el = BrakeVBrake
    * 6 el = Grips
    * 7 el = Handlebar
    * 8 el = Headset
    * 9 el = Stem
    * 10 el = Winding
    * 11 el = BackDerailleur
    * 12 el = BackGearKas
    * 13 el = BackGearTr
    * 14 el = Bracket
    * 15 el = Chain
    * 16 el = Crank
    * 17 el = FrontDerailleur
    * 18 el = Pedal
    * 19 el = BackHub
    * 20 el = FrontHub
    * 21 el = Rim
    * 22 el = Spoke
    * 23 el = Tire
    * 24 el = Wheel

    * */
    //Frame is 0 element
    public void addIdFrame (Long id) {
        idOfComponents.set(0,id);
        System.out.println("Frame id =" + idOfComponents.get(0));
    }
    public Long getIdFrame () {
        Long id = idOfComponents.get(0);
        return id;
    }

    //Fork is 1 element
    public void addIdFork (Long id) {
        idOfComponents.set(1,id);
    }
    public Long getIdFork () {
        Long id = idOfComponents.get(1);
        return  id;
    }

    //BrakeDiscHydraulic is 2 element
    public void addIdBrakeDiscHydraulic (Long id) {
        idOfComponents.set(2,id);
    }
    public Long getIdBrakeDiscHydraulic () {
        Long id = idOfComponents.get(2);
        return  id;
    }

    //BrakeDiscMechanik is 3 element
    public void addIdBrakeDiscMechanik (Long id) {
        idOfComponents.set(3,id);
    }
    public Long getIdBrakeDiscMechanik () {
        Long id = idOfComponents.get(3);
        return  id;
    }

    //BrakeHandle is 4 element
    public void addIdBrakeHandle (Long id) {
        idOfComponents.set(4,id);
    }
    public Long getIdBrakeHandle () {
        Long id = idOfComponents.get(4);
        return  id;
    }

    //BrakeVBrake is 5 element
    public void addIdBrakeVBrake (Long id) {
        idOfComponents.set(5,id);
    }
    public long getIdBrakeVBrake () {
        Long id = idOfComponents.get(5);
        return  id;
    }

    //Grips is 6 element
    public void addIdGrips (Long id) {
        idOfComponents.set(6,id);
    }
    public Long getIdGrips () {
        Long id = idOfComponents.get(6);
        return  id;
    }

    //Handlebar is 7 element
    public void addIdHandlebar (Long id) {
        idOfComponents.set(7,id);
    }
    public Long getIdHandlebar () {
        Long id = idOfComponents.get(7);
        return  id;
    }

    //Headset is 8 element
    public void addIdHeadset (Long id) {
        idOfComponents.set(8,id);
    }
    public Long getIdHeadset () {
        Long id = idOfComponents.get(8);
        return  id;
    }

    //Stem is 9 element
    public void addIdStem (Long id) {
        idOfComponents.set(9,id);
    }
    public Long getIdStem () {
        Long id = idOfComponents.get(9);
        return  id;
    }

    //Winding is 10 element
    public void addIdWinding (Long id) {
        idOfComponents.set(10,id);
    }
    public Long getIdWinding () {
        Long id = idOfComponents.get(10);
        return  id;
    }

    //BackDerailleur is 11 element
    public void addIdBackDerailleur (Long id) {
        idOfComponents.set(11,id);
    }
    public Long getIdBackDerailleur () {
        Long id = idOfComponents.get(11);
        return  id;
    }

    //BackGearKas is 12 element
    public void addIdBackGearKas (Long id) {
        idOfComponents.set(12,id);
    }
    public Long getIdBackGearKas () {
        Long id = idOfComponents.get(12);
        return  id;
    }

    //BackGearTr is 13 element
    public void addIdBackGearTr (Long id) {
        idOfComponents.set(13,id);
    }
    public Long getIdBackGearTr () {
        Long id = idOfComponents.get(13);
        return  id;
    }

    //Bracket is 14 element
    public void addIdBracket (Long id) {
        idOfComponents.set(14,id);
    }
    public Long getIdBracket () {
        Long id = idOfComponents.get(14);
        return  id;
    }

    //Chain is 15 element
    public void addIdChain (Long id) {
        idOfComponents.set(15,id);
    }
    public Long getIdChain () {
        Long id = idOfComponents.get(15);
        return  id;
    }

    //Crank is 16 element
    public void addIdCrank (Long id) {
        idOfComponents.set(16,id);
    }
    public Long getIdCrank () {
        Long id = idOfComponents.get(16);
        return  id;
    }

    //FrontDerailleur is 17 element
    public void addIdFrontDerailleur (Long id) {
        idOfComponents.set(17,id);
    }
    public Long getIdFrontDerailleur () {
        Long id = idOfComponents.get(17);
        return  id;
    }

    //Pedal is 18 element
    public void addIdPedal (Long id) {
        idOfComponents.set(18,id);
    }
    public Long getIdPedal () {
        Long id = idOfComponents.get(18);
        return  id;
    }

    //BackHub is 19 element
    public void addIdBackHub (Long id) {
        idOfComponents.set(19,id);
    }
    public Long getIdBackHub () {
        Long id = idOfComponents.get(19);
        return  id;
    }

    //FrontHub is 20 element
    public void addIdFrontHub (Long id) {
        idOfComponents.set(20,id);
    }
    public Long getIdFrontHub () {
        Long id = idOfComponents.get(20);
        return  id;
    }

    //Rim is 21 element
    public void addIdRim (Long id) {
        idOfComponents.set(21,id);
    }
    public Long getIdRim () {
        Long id = idOfComponents.get(21);
        return  id;
    }

    //Spoke is 22 element
    public void addIdSpoke (Long id) {
        idOfComponents.set(22,id);
    }
    public Long getIdSpoke () {
        Long id = idOfComponents.get(22);
        return  id;
    }

    //Tire is 23 element
    public void addIdTire (Long id) {
        idOfComponents.set(23,id);
    }
    public Long getIdTire () {
        Long id = idOfComponents.get(23);
        return  id;
    }

    //Wheel is 24 element
    public void addIdWheel (Long id) {
        idOfComponents.set(24,id);
    }
    public Long getIdWheel () {
        Long id = idOfComponents.get(24);
        return  id;
    }

}

