package com.alexiades.app;// {{ groupId}}.app
// import the rest service you created!
import com.alexiades.rest.ApiRestService;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class ApiRest extends Application {
    private Set<Object> singletons = new HashSet<Object>();
    public ApiRest() {
        singletons.add(new ApiRestService());
    }
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}