package com.firetech.blackghost.resources;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import com.firetech.blackghost.model.Recipient;
import com.firetech.blackghost.services.RecipientService;

@Path("mgmt")
@Produces(MediaType.APPLICATION_JSON)
public class RecipientResource {

    @Inject
    private RecipientService recipientService;

    @GET @Path("/recipients")
    public Response getRecipients() {
        List<Recipient> recipients = recipientService.getAllRecipients();
        return Response.ok(recipients).build();
    }
    
    @POST @Path("/recipients")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createRecipient(Recipient recipient, @Context UriInfo uriInfo) {
        recipient = recipientService.createRecipient(recipient);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path("" + recipient.getRecipientId());
        return Response.created(builder.build()).entity(recipient).build();
    }
    
    @PUT @Path("/recipients/{recipientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateRecipient(Recipient recipient) {
        recipientService.updateRecipient(recipient);
        return Response.ok().build();
    }
}
