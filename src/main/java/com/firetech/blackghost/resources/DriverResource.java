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

import com.firetech.blackghost.model.Driver;
import com.firetech.blackghost.services.DriverService;

@Path("mgmt")
@Produces(MediaType.APPLICATION_JSON)
public class DriverResource {

    @Inject
    private DriverService driverService;

    @GET @Path("/drivers")
    public Response getDrivers() {
        List<Driver> drivers = driverService.getAllDrivers();
        return Response.ok(drivers).build();
    }
    
    @POST @Path("/drivers")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDriver(Driver driver, @Context UriInfo uriInfo) {
        driver = driverService.createDriver(driver);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path("" + driver.getDriverId());
        return Response.created(builder.build()).entity(driver).build();
    }
    
    @PUT @Path("/drivers/{driverId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDriver(Driver driver) {
        driverService.updateDriver(driver);
        return Response.ok().build();
    }
}
