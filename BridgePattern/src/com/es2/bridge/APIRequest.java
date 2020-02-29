package com.es2.bridge;

import java.util.HashMap;
import java.util.Random;

public  class APIRequest {

    protected java.util.HashMap<java.lang.String, APIServiceInterface> services; //serviceID,APIServiceInterface

    public APIRequest() {
        services = new HashMap<>();
    }

    public String addService(APIServiceInterface service) {

        Random rand = new Random(); //instance of random class
        String serviceID = String.valueOf(services.size() + 1);
        services.put(serviceID, service);
        return serviceID;
    }

    public  java.lang.String getContent(java.lang.String serviceId,
                                       java.lang.String contentId)
            throws ServiceNotFoundException {

          if (services.get(serviceId) == null) {

              throw new ServiceNotFoundException();
          }
          if (services.get(serviceId).getContent(contentId) != null) {

              return services.get(serviceId).getContent(contentId);
          }
          else {
              return null;
          }
    }

    public java.lang.String setContent(java.lang.String serviceId,
                                       java.lang.String content)
            throws ServiceNotFoundException {

        if (!services.containsKey(serviceId)) {

            throw new ServiceNotFoundException();
        }

        return services.get(serviceId).setContent(content);
    }

}
