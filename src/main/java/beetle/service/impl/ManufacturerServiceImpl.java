package beetle.service.impl;

import beetle.json.manufacturer.ManufacturerJSON;
import beetle.mapper.ManufacturerMapper;
import beetle.repository.ManufacturerRepository;
import beetle.service.ManufacturerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;
    private final ManufacturerMapper mapper;


    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository, ManufacturerMapper mapper) {
        this.manufacturerRepository = manufacturerRepository;
        this.mapper = mapper;
    }

    @Override
    @Transactional(readOnly=true)
    public ManufacturerJSON getManufacturer(Long id) {
        return mapper.toJSON(manufacturerRepository.findOne(id));
    }

    @Override
    @Transactional(readOnly=true)
    public List<ManufacturerJSON> getManufacturers() {
        return mapper.toJSONs(manufacturerRepository.findAll());
    }


}
