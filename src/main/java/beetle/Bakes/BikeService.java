package beetle.Bakes;

import beetle.Frames.Frame;
import beetle.Frames.FrameRepository;
import beetle.Frames.FrameSize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by VitaliiZhuk on 07.07.2017.
 */
@Service
public class BikeService {
    //main components
    @Autowired
    private ComponentRepository componentRepository;
    @Autowired
    private FrameRepository frameRepository;

    // add
    @Transactional
    public void addComponent(Component component) {
        componentRepository.save(component);
    }


//delete

    @Transactional
    public void deleteComponent(long[] idList) {
        for (long id : idList)
            componentRepository.delete(id);
    }

    //find
    @Transactional(readOnly=true)
    public List<Component> findAll(Pageable pageable) {
        return componentRepository.findAll(pageable).getContent();
    }

    @Transactional(readOnly = true)
    public long countComponent() {
        return componentRepository.count();
    }

    @Transactional(readOnly=true)
    public List<Frame> findByFrameSize(FrameSize frameSize, Pageable pageable) {
        return frameRepository.findByFrameSize(frameSize, pageable);
    }

}

