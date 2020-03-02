package com.es2.bridge;

import java.util.HashMap;

public class APIRequest {

    protected HashMap<String, APIServiceInterface> services;

    public APIRequest() {
        services = new HashMap<>();
    }

    public String addService(APIServiceInterface service) {

        String serviceID = String.valueOf(services.size() + 1);
        services.put(serviceID, service);
        return serviceID;
    }

    public String getContent(String serviceId,
                             String contentId)
            throws ServiceNotFoundException {

        if (services.get(serviceId) == null) {

            throw new ServiceNotFoundException();
        }
        if (services.get(serviceId).getContent(contentId) != null) {

            return services.get(serviceId).getContent(contentId);
        } else {
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
