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

import com.firetech.blackghost.model.Customer;
import com.firetech.blackghost.services.CustomerService;

@Path("mgmt")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    @Inject
    private CustomerService customerService;

    @GET @Path("/customers")
    public Response getCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return Response.ok(customers).build();
    }
    
    @POST @Path("/customers")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer customer, @Context UriInfo uriInfo) {
        customer = customerService.createCustomer(customer);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path("" + customer.getCustomerId());
        return Response.created(builder.build()).entity(customer).build();
    }
    
    @PUT @Path("/customers/{customerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
        return Response.ok().build();
    }
}
