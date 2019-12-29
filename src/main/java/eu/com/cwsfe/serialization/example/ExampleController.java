package eu.com.cwsfe.serialization.example;

import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleController.class);

    private static final byte[] HUGE_BYTES_ARRAY = RandomUtils.nextBytes(20 * 1024 * 1024);

    @GetMapping(value = "/largePojo")
    public PojoData getPojoData() {
        LOGGER.info("Large pojo data invoked");
        return new PojoData(
                "code", "someDataValue".getBytes(),
                1, 2, 3d, new PojoInternalData(true),
                HUGE_BYTES_ARRAY
        );
    }

    @GetMapping(value = "/smallPojo")
    public PojoData getSmallPojoData() {
        LOGGER.info("Large pojo data invoked");
        return new PojoData(
                "code", "someDataValue".getBytes(),
                1, 2, 3d, new PojoInternalData(true),
                "".getBytes()
        );
    }

}
