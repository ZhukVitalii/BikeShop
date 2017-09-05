package beetle.Bakes;

/**
 * Created by VitaliiZhuk on 19.08.2017.
 */
import beetle.Forks.BrakesTypeRepository;
import beetle.Forks.TubeDiameterRepository;
import beetle.Frames.*;
import beetle.Handlebars.HeadsetTypeRepository;
import beetle.Transmissions.BracketWideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private FrameRepository frameRepository;
    @Autowired
    private  CartRepository cartRepository;


    @Autowired
    private FrameMakerRepository frameMakerRepository;
    @Autowired
    private FrameSizeRepository frameSizeRepository;
    @Autowired
    private UnderSaddleTubeRepository underSaddleTubeRepository;
    @Autowired
    private TrunkBindingRepository trunkBindingRepository;
    @Autowired
    private BikeTypeRepository bikeTypeRepository;
    @Autowired
    private BrakesTypeRepository brakesTypeRepository;
    @Autowired
    private HeadsetTypeRepository headsetTypeRepository;
    @Autowired
    private TubeDiameterRepository tubeDiameterRepository;
    @Autowired
    private BracketWideRepository bracketWideRepository;

    @Transactional
    public void addCart(Cart cart) {
        cartRepository.save(cart);
    }
    @Transactional
    public void addFrameToCart(Cart cart) {
        cartRepository.save(cart);
    }




    public List<Long> articles = new ArrayList<>();




    public void testPrint(){
        for (Long articlo : articles){
            System.out.println(articlo);
        }
    }
    public  void printSize(){
        System.out.println("розмір корзини " + getSize());
    }


    public void addToArticle(Long article) {
        articles.add(article);
        testPrint();
        getSize();
        printSize();
    }
    public Long getArticleFromCart (int a) {
        Long b = articles.get(a);
        return b;
    }
    public int getSize() {
        int a = articles.size();
        return a;
    }

}

