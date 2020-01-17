package com.hemanthkaipa.sapostore.utils;

import com.hemanthkaipa.sapostore.exceptions.OfflineODataStoreException;
import com.sap.smp.client.odata.exception.ODataException;
import com.sap.smp.client.odata.store.ODataRequestExecution;

public interface UIListener {
    void onRequestError(int operation, Exception e, ODataRequestExecution oDataRequestExecution);
    void onRequestSuccess(int operation,ODataRequestExecution request) throws ODataException, OfflineODataStoreException;
}
