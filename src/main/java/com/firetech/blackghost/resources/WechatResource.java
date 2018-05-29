package com.firetech.blackghost.resources;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.firetech.blackghost.Constants;
import com.firetech.blackghost.model.Delivery;
import com.firetech.blackghost.model.DeliveryStatus;
import com.firetech.blackghost.model.Driver;
import com.firetech.blackghost.model.Signature;
import com.firetech.blackghost.services.DeliveryService;


@Path("wechat")
@Produces(MediaType.APPLICATION_JSON)
public class WechatResource {

    @Inject
    private DeliveryService deliveryService;
    
    @Context
    private HttpServletRequest httpRequest;
    
    @GET @Path("/drivers/me")
    public Response getMe() {
        Driver driver = (Driver) httpRequest.getSession().getAttribute(Constants.SESSION_DRIVER);
        return Response.ok(driver).build();
    }
    
    @GET @Path("/drivers/{driverId}/deliveries")
    public Response getDeliveriesByDriverId(@PathParam("driverId") int driverId) {
        List<Delivery> deliveries = deliveryService.getDeliveriesByDriverId(driverId);
        return Response.ok(deliveries).build();
    }
    
    @PUT @Path("/drivers/{driverId}/deliveries/{deliveryId}/status")
    public Response updateDeliveryStatus(@PathParam("driverId") int driverId,
            @PathParam("deliveryId") int deliveryId,
            DeliveryStatus deliveryStatus) {
        Delivery delivery = deliveryService.getDeliveryById(deliveryId);
        delivery.setStatus(deliveryStatus.getStatus());
        deliveryService.updateDelivery(delivery);
        return Response.ok().build();
    }
    
    @GET @Path("/drivers/{driverId}/deliveries/{deliveryId}/signature")
    public Response getSignature(@PathParam("driverId") int driverId,
            @PathParam("deliveryId") int deliveryId) {
        Signature signature = deliveryService.getSignature(deliveryId);
        return Response.ok(signature).build();
    }
    
    @POST @Path("/drivers/{driverId}/deliveries/{deliveryId}/signature")
    public Response updateSignature(@PathParam("driverId") int driverId,
            @PathParam("deliveryId") int deliveryId,
            Signature signature) {
        deliveryService.saveSignature(deliveryId, signature);
        return Response.ok().build();
    }
}
