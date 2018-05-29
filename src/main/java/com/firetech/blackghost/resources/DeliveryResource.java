package com.firetech.blackghost.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.firetech.blackghost.model.Delivery;
import com.firetech.blackghost.model.Signature;
import com.firetech.blackghost.services.DeliveryService;

@Path("mgmt")
@Produces(MediaType.APPLICATION_JSON)
public class DeliveryResource {

    @Inject
    private DeliveryService deliveryService;
    
    @GET @Path("/deliveries")
    public Response getDeliveries(
            @DefaultValue("false") @QueryParam("search") boolean search,
            @QueryParam("keyword") String keyword) {
        List<Delivery> list = null;
        if (search) {
            list = deliveryService.searchDelivery(keyword);
        } else {
            list = deliveryService.getAllOpenDelivery();
        }
        return Response.ok(list).build();
    }
    
    @POST @Path("/deliveries")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDelivery(Delivery delivery, @Context UriInfo uriInfo) {
        delivery = deliveryService.createDelivery(delivery);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path("" + delivery.getDeliveryId());
        return Response.created(builder.build()).entity(delivery).build();
    }
    
    @PUT @Path("/deliveries/{deliveryId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDelivery(Delivery delivery) {
        deliveryService.updateDelivery(delivery);
        return Response.ok().build();
    }
    
    @GET @Path("/deliveries/{deliveryId}/signature")
    public Response getSignature(@PathParam("deliveryId") int deliveryId) {
        Signature signature = deliveryService.getSignature(deliveryId);
        return Response.ok(signature).build();
    }
}
