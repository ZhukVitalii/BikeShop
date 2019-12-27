package beetle.controller;

import beetle.entity.frame.BikeType;
import beetle.entity.frame.Frame;
import beetle.entity.frame.FrameSize;
import beetle.enums.BikeTypeEnum;
import beetle.json.FrameSearchResultResponseJSON;
import beetle.json.FramesSearchInputJSON;
import beetle.repository.frame.FrameRepository;
import beetle.service.FrameService;
import beetle.service.impl.FrameServiceImpl;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
@RunWith(JUnitPlatform.class)
@SpringBootTest
@PropertySource("classpath:config.properties")
public class UserControllerTest{
    @Value("${local.server.port.test}")
    private String port;
    @Autowired
    private TestRestTemplate restTemplate;

    @Mock
    private FrameRepository frameRepository;// = Mockito.mock(FrameRepository.class);


    @InjectMocks
    private FrameService frameService = new FrameServiceImpl(frameRepository);

    private final static BikeType bikeType = new BikeType("MTB");
    private final static FrameSize frameSize = new FrameSize("M");
    private final static String mockFrameName = "MockFrameName";
    private final static String mockFrameDescription = "MockDescription";
    private final static Double mockFramePrice = new Double(158.5);


    @BeforeEach
    void setMockOutput(){
        System.out.println("Teststst" );
        //FrameRepository frameRepository = Mockito.mock(FrameRepository.class);
        bikeType.setId(1);
        when(frameRepository.findByBikeType(bikeType,new PageRequest( 0 ,
                5,
                Sort.Direction.DESC, "id"))).thenReturn(
                Arrays.asList(new Frame(bikeType,frameSize,mockFrameName,mockFrameDescription,mockFramePrice)));
    }



    @DisplayName("Test Mock Search Frame")
    @Test
    public void getRepoFrames() throws Exception {
        bikeType.setId(1);
        List<Frame> frames =  frameService.findByBikeType(bikeType,new PageRequest( 0 ,
                5,
                Sort.Direction.DESC, "id"));
        assertEquals(bikeType.getType(), frames.get(0).getBikeType().getType());
    }
    @DisplayName("Test Mock Search Frame endpoint")
    @Test
    public void getFrames() throws Exception {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<FramesSearchInputJSON> request = new HttpEntity<>(buildRequest(),headers);
        restTemplate = new TestRestTemplate();
        ResponseEntity<FrameSearchResultResponseJSON> response = restTemplate.postForEntity(new URL("http://localhost:" + 8080 + "/get-frames").toString(),request,FrameSearchResultResponseJSON.class);
        assertEquals(bikeType.getType(), response.getBody().getFrames().get(0).getBikeType());
    }

    private FramesSearchInputJSON buildRequest() {
        FramesSearchInputJSON request = new FramesSearchInputJSON();
        request.setBikeTypeId(1L);
        request.setBikeType(BikeTypeEnum.MTB);
        request.setItemsPerPage(5);
        request.setPage(0);
        return  request;
    }


}