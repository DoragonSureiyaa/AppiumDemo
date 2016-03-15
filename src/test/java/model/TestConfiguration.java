package model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by tomasz.skrzypek on 2016-03-15.
 */
@XmlRootElement(name = "TestConfiguration")
public class TestConfiguration {

    String application;

    public static TestConfiguration configureFromExtFile(String configName, String appName) {
        configName = configName.toLowerCase();
//        TestConfiguration envConf = EntityCreator.createFromExtFile("configuration", "configuration/"+configName, TestConfiguration.class);
//        TestConfiguration sliceConf = EntityCreator.createFromExtFile(sliceName, "configuration/", TestConfiguration.class);

//        try {
//            BeanUtilsBean beanUtils=new NullAwareBeanUtilsBean();
//            beanUtils.copyProperties(envConf, sliceConf);
//        } catch (IllegalAccessException | InvocationTargetException e) {
//            log.error("There was a problem generating test configuration file" + e.getMessage());
//            return null;
//        }
//        return envConf;
        return null;
    }
}
