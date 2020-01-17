package com.hemanthkaipa.sapostore.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.hemanthkaipa.sapostore.exceptions.OfflineODataStoreException;
import com.sap.smp.client.odata.exception.ODataException;
import com.sap.smp.client.odata.store.ODataRequestExecution;
import com.sap.smp.client.odata.store.ODataRequestListener;

public class OfflineRequestListener implements ODataRequestListener {
    private UIListener uiListener;
    private int operation;
    private String ENTITY_SET="";

    public OfflineRequestListener(int operation, UIListener uiListener, String collectionName) {
        super();
        this.operation = operation;
        this.uiListener = uiListener;
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
            uiListener.onRequestSuccess(operation,oDataRequestExecution);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    public void requestFailed(ODataRequestExecution oDataRequestExecution, ODataException e) {
        uiListener.onRequestError(operation,e,oDataRequestExecution);
    }

    @Override
    public void requestFinished(ODataRequestExecution oDataRequestExecution) {

    }
}
