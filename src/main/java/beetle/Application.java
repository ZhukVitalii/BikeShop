package beetle;

import beetle.Forks.ForkService;
import beetle.Frames.FrameService;
import beetle.Handlebars.HandlebarService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/*");
        return registrationBean;
    }

    @Bean
    public CommandLineRunner demo(final FrameService frameService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                /*
                FrameMaker frameMaker = new FrameMaker("Giant");
                Frame frame;
                frameService.addFrameMaker(frameMaker);
                FrameSize frameSize = new FrameSize("M");
                frameService.addFrameSize(frameSize);
                FrameSize frameSize1 = new FrameSize("L");
                frameService.addFrameSize(frameSize1);
                FrameSize frameSize2 = new FrameSize("S");
                frameService.addFrameSize(frameSize2);
                */
              //  for (int i = 0; i < 5; i++) {
                //    frame = new Frame(frameGroup, "ASR", "mtb", "m", "alum", "30", "1.8", "30.7", "disc", "no", "16.0", "blue", "3000.26", "good frame", "/static/DSCN8243.png");
                  //  frameService.addContact(contact);
                //}
            }


        };
    }

    @Bean
    public CommandLineRunner demoOne(final ForkService forkService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                /*
                ForkMaker forkMaker = new ForkMaker("SANTOUR");
                forkService.addForkMaker(forkMaker);

                ForkType forkType = new ForkType("MTB");

                forkService.addForkType(forkType);
                TubeDiameter tubeDiameter = new TubeDiameter("11/2");
                forkService.addTubeDiameter(tubeDiameter);
                TubeDiameter tubeDiameter1 = new TubeDiameter("11/8");
                forkService.addTubeDiameter(tubeDiameter1);
                TubeDiameter tubeDiameter2 = new TubeDiameter("1");
                forkService.addTubeDiameter(tubeDiameter2);
                WheelsDiam wheelsDiam = new WheelsDiam("29");
                forkService.addWheelsDiam(wheelsDiam);
                WheelsDiam wheelsDiam1 = new WheelsDiam("26");
                forkService.addWheelsDiam(wheelsDiam1);
                WheelsDiam wheelsDiam2 = new WheelsDiam("24");
                forkService.addWheelsDiam(wheelsDiam2);
                BrakesType brakesType = new BrakesType("disc");
                forkService.addBrakesType(brakesType);
                BrakesType brakesType1 = new BrakesType("v-brake");
                forkService.addBrakesType(brakesType1);
                */
            }


        };
    }

    @Bean
    public CommandLineRunner demoTwo(final HandlebarService handlebarService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {

/*
                HandlebarMaker handlebarMaker = new HandlebarMaker("Kellis");
                handlebarService.addHandlebarMaker(handlebarMaker);
                HandlebarMaterial handlebarMaterial = new HandlebarMaterial("alum");
                handlebarService.addHandlebarMaterrial(handlebarMaterial);
                HandlebarType handlebarType = new HandlebarType("MTB");
                handlebarService.addHandlebarType(handlebarType);
                HandlebarType handlebarType1= new HandlebarType("BMX");
                handlebarService.addHandlebarType(handlebarType1);
                HandlebarType handlebarType2 = new HandlebarType("шосер");


                handlebarService.addHandlebarType(handlebarType2);
                HandlebarDiameter handlebarDiameter = new HandlebarDiameter("25.4");
                handlebarService.addHandlebarDiameter(handlebarDiameter);
                HandlebarDiameter handlebarDiameter1 = new HandlebarDiameter("31.8");
                handlebarService.addHandlebarDiameter(handlebarDiameter1);
                HandlebarDiameter handlebarDiameter2 = new HandlebarDiameter("26");
                handlebarService.addHandlebarDiameter(handlebarDiameter2);
                HandlebarMaker handlebarMaker1 = new HandlebarMaker("Giant");
                handlebarService.addHandlebarMaker(handlebarMaker1);
                Handlebar handlebar = new Handlebar(handlebarMaker,"кермо",handlebarType2,"35",handlebarDiameter,"46",handlebarMaterial,"45","white","1259","good helm","/static/DSCN8243.png");
                handlebarService.addHandlebar(handlebar);
                Winding winding = new Winding(handlebarMaker,"fdef","65","30 mm","gum","red","2550","vah","");
                handlebarService.addWinding(winding);
                TubeDiameter tubeDiameter6 = new TubeDiameter("85");
              handlebarService.addTubeDiameter(tubeDiameter6);

                Stem stem = new Stem(handlebarMaker1,"apg","75",handlebarDiameter,tubeDiameter6,handlebarMaterial,"85","white","25neuhbrsd","cool гарне кермо","static/DSCN8243.png");
handlebarService.addStem(stem);
*/
                }

        };

    }

}