package seniorlabs.challenge.softwareengineer.hcm.model.utils;

import org.apache.catalina.util.ToStringUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {

    public String converteDataFormatoPayLoad(Date data) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dataConvertida = formatter.format(data);

        return dataConvertida;
    }

    String dataToString(Date data) {
        String stringData = new String();
        stringData = "";

        return "";
    }

}
