package com.hemanthkaipa.sapostore.utils;

import com.hemanthkaipa.sapostore.exceptions.OfflineODataStoreException;
import com.sap.smp.client.odata.exception.ODataException;
import com.sap.smp.client.odata.store.ODataRequestExecution;
import com.sap.smp.client.odata.store.ODataRequestListener;

public class OfflineRequestListener implements ODataRequestListener {
    private SAPUIListener SAPUIListener;
    private int operation;
    private String ENTITY_SET="";

    public OfflineRequestListener(int operation, SAPUIListener SAPUIListener, String collectionName) {
        super();
        this.operation = operation;
        this.SAPUIListener = SAPUIListener;
        this.ENTITY_SET = collectionName;

    }

    public OfflineRequestListener(int operation, String collectionName) {
        super();
        this.operation = operation;
        this.ENTITY_SET = collectionName;

    }

    @Override
    public void requestStarted(ODataRequestExecution oDataRequestExecution) {

    }

    @Override
    public void requestCacheResponse(ODataRequestExecution oDataRequestExecution) {

    }

    @Override
    public void requestServerResponse(ODataRequestExecution oDataRequestExecution) {
        try {
            SAPUIListener.onRequestSuccess(operation,oDataRequestExecution);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void requestFailed(ODataRequestExecution oDataRequestExecution, ODataException e) {
        SAPUIListener.onRequestError(operation,e,oDataRequestExecution);
    }

    @Override
    public void requestFinished(ODataRequestExecution oDataRequestExecution) {
        try {
            SAPUIListener.onRequestFinished(oDataRequestExecution);
        } catch (ODataException | OfflineODataStoreException e) {
            e.printStackTrace();
        }
    }
}
