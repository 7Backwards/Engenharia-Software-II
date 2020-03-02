package com.es2.bridge;

import java.util.HashMap;
import java.util.Random;

public  class APIRequest {

    protected HashMap<String, APIServiceInterface> services; //serviceID,APIServiceInterface

    public APIRequest() {
        services = new HashMap<>();
    }

    public String addService(APIServiceInterface service) {

        Random rand = new Random(); //instance of random class
        String serviceID = String.valueOf(services.size() + 1);
        services.put(serviceID, service);
        return serviceID;
    }

    public  String getContent(String serviceId,
                                       String contentId)
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

    public String setContent(String serviceId,
                                       String content)
            throws ServiceNotFoundException {

        if (!services.containsKey(serviceId)) {

            throw new ServiceNotFoundException();
        }

        return services.get(serviceId).setContent(content);
    }

}
