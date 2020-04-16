package beetle.service;

import beetle.entity.Manufacturer;
import beetle.json.manufacturer.ManufacturerJSON;

import java.util.List;

public interface ManufacturerService {
    ManufacturerJSON getManufacturer(Long id);
    List<ManufacturerJSON> getManufacturers();
}
