package apps.kdad.components.content.jsJavaTest;

import com.adobe.cq.sightly.SightlyWCMMode;
import org.apache.jackrabbit.util.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import com.adobe.cq.sightly.WCMUsePojo;

import java.util.Date;

public class Utils extends WCMUsePojo{

    public static final Logger log = LoggerFactory.getLogger(Utils.class);

    private Resource resource;
    private SightlyWCMMode wcmMode;
    private Date date;
    private String str;

    public void activate() throws Exception {
        resource = getResource();
        wcmMode = getWcmMode();
    }

    public String getDate() {
        return new Date().toString();
    }

    public String getPath() {
        return resource.getPath();
    }
}