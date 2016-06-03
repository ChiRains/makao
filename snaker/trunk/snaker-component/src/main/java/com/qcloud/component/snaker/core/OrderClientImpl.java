package com.qcloud.component.snaker.core;

import java.util.Map;
import org.snaker.engine.SnakerEngine;
import org.snaker.engine.entity.Order;
import org.snaker.engine.entity.Process;
import com.qcloud.component.snaker.IOrderClient;

public class OrderClientImpl implements IOrderClient {

    private SnakerEngine engine;

    public OrderClientImpl(SnakerEngine engine) {

        this.engine = engine;
    }

    @Override
    public Order createOrder(Process process, String operator, Map<String, Object> args) {

        return engine.order().createOrder(process, operator, args);
    }

    @Override
    public Order createOrder(Process process, String operator, Map<String, Object> args, String parentId, String parentNodeName) {

        return engine.order().createOrder(process, operator, args, parentId, parentNodeName);
    }

    @Override
    public void addVariable(String orderId, Map<String, Object> args) {

        engine.order().addVariable(orderId, args);
    }

    @Override
    public void createCCOrder(String orderId, String creator, String... actorIds) {

        engine.order().createCCOrder(orderId, creator, actorIds);
    }

    @Override
    public void complete(String orderId) {

        engine.order().complete(orderId);
    }

    @Override
    public void saveOrder(Order order) {

        engine.order().saveOrder(order);
    }

    @Override
    public void terminate(String orderId) {

        engine.order().terminate(orderId);
    }

    @Override
    public void terminate(String orderId, String operator) {

        engine.order().terminate(orderId, operator);
    }

    @Override
    public Order resume(String orderId) {

        return engine.order().resume(orderId);
    }

    @Override
    public void updateOrder(Order order) {

        engine.order().updateOrder(order);
    }

    @Override
    public void updateCCStatus(String orderId, String... actorIds) {

        engine.order().updateCCStatus(orderId, actorIds);
    }

    @Override
    public void deleteCCOrder(String orderId, String actorId) {

        engine.order().deleteCCOrder(orderId, actorId);
    }

    @Override
    public void cascadeRemove(String id) {

        engine.order().cascadeRemove(id);
    }
}
