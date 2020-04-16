package beetle.controller;

import beetle.entity.frame.BikeType;
import beetle.enums.BikeTypeEnum;
import beetle.json.SearchResultResponseJSON;
import beetle.json.frame.FramesJSON;
import beetle.json.frame.FramesSearchInputJSON;
import beetle.repository.ManufacturerRepository;
import beetle.repository.forks.BrakesTypeRepository;
import beetle.repository.forks.TubeDiameterRepository;
import beetle.repository.forks.WheelsDiamRepository;
import beetle.repository.frame.*;
import beetle.repository.handlebars.HeadsetTypeRepository;
import beetle.repository.transmission.BracketWideRepository;
import beetle.service.FrameService;
import beetle.service.impl.FrameServiceImpl;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.junit.Assert.assertEquals;

@Slf4j
@RunWith(JUnitPlatform.class)
@SpringBootTest
@PropertySource("classpath:config.properties")
public class UserControllerTest {
    Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

    @Value("${local.server.port.test}")
    private String port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Mock
    private FrameRepository frameRepository;// = Mockito.mock(FrameRepository.class);
    @Mock
    private ManufacturerRepository manufacturerRepository;
    @Mock
    private FrameSizeRepository frameSizeRepository;
    @Mock
    private UnderSaddleTubeRepository underSaddleTubeRepository;
    @Mock
    private TrunkBindingRepository trunkBindingRepository;
    @Mock
    private BikeTypeRepository bikeTypeRepository;
    @Mock
    private BrakesTypeRepository brakesTypeRepository;
    @Mock
    private HeadsetTypeRepository headsetTypeRepository;
    @Mock
    private TubeDiameterRepository tubeDiameterRepository;
    @Mock
    private BracketWideRepository bracketWideRepository;
    @Mock
    private WheelsDiamRepository wheelsDiamRepository ;
    @Mock
    @Autowired
    private SessionFactory sessionFactory;


    @InjectMocks
    private FrameService frameService = new FrameServiceImpl(frameRepository,manufacturerRepository,frameSizeRepository,underSaddleTubeRepository,trunkBindingRepository,bikeTypeRepository,brakesTypeRepository,
            headsetTypeRepository,tubeDiameterRepository,bracketWideRepository,wheelsDiamRepository,sessionFactory);

    private final static BikeType bikeType = new BikeType("MTB");
    //private final static FrameSizeType frameSize = new FrameSizeType("M");
    private final static String mockFrameName = "MockFrameName";
    private final static String mockFrameDescription = "MockDescription";
    private final static Double mockFramePrice = new Double(158.5);


//    @BeforeEach
//    void setMockOutput() {
//        SearchResultBO searchResult = new SearchResultBO();
//        searchResult.setSearchResult(Arrays.asList(new Frame(bikeType, frameSize, mockFrameName, mockFrameDescription, mockFramePrice)));
//        searchResult.setTotalCount(12L);
//        bikeType.setId(1L);
//        when(frameService.searchByCriteria(buildRequest())).thenReturn(searchResult);
//    }


//    @DisplayName("Test Mock Search Frame")
//    @Test
//    public void getRepoFrames() {
//        bikeType.setId(1L);
//        List<Frame> frames = frameService.findByBikeType(bikeType, new PageRequest(0,
//                5,
//                Sort.Direction.DESC, "id"));
//        assertEquals(bikeType.getType(), frames.get(0).getBikeType().getType());
//    }

    @DisplayName("Test Mock Search Frame endpoint")
    @Test
    public void getFrames() {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<FramesSearchInputJSON> request = new HttpEntity<>(buildRequest(), headers);
            restTemplate = new TestRestTemplate();
            ResponseEntity<SearchResultResponseJSON> response = restTemplate.postForEntity(new URL("http://localhost:" + 8080 + "/get-frames").toString(), request, SearchResultResponseJSON.class);
            FramesJSON frame =(FramesJSON) response.getBody().getResultResponse().get(0);
            assertEquals(bikeType.getType(), frame.getBikeType());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    private FramesSearchInputJSON buildRequest() {
        FramesSearchInputJSON request = new FramesSearchInputJSON();
        request.setBikeTypeId(1L);
        request.setBikeType(BikeTypeEnum.MTB);
        request.setItemsPerPage(5);
        request.setPage(0);
        return request;
    }


}