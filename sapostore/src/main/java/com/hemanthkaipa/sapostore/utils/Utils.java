package com.hemanthkaipa.sapostore.utils;

import com.sap.smp.client.odata.metadata.ODataMetadata;
import com.sap.smp.client.odata.offline.ODataOfflineStore;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Set;

public class Utils {
    public static String getNameSpace(ODataOfflineStore oDataOfflineStore) {
        String mStrNameSpace = "";

        ODataMetadata oDataMetadata = null;
        try {
            oDataMetadata = oDataOfflineStore.getMetadata();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Set<String> set = oDataMetadata.getMetaNamespaces();

        if (set != null && !set.isEmpty()) {
            Iterator itr = set.iterator();
            while (itr.hasNext()) {
                String tempNameSpace = itr.next().toString();
                if (!tempNameSpace.equalsIgnoreCase("OfflineOData")) {
                    mStrNameSpace = tempNameSpace;
                }
            }
        }

        return mStrNameSpace;
    }

    public static String convertCalenderToStringFormat(GregorianCalendar calendar) {
        String dateFormatted = "";
        if (calendar != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            simpleDateFormat.setCalendar(calendar);
            dateFormatted = simpleDateFormat.format(calendar.getTime());
        }
        return dateFormatted;
    }
}
