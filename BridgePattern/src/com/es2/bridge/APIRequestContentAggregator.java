package com.es2.bridge;

public class APIRequestContentAggregator extends APIRequest {

    public APIRequestContentAggregator() {

    }

    public String getContent(String serviceId,
                             String contentId)
            throws ServiceNotFoundException {


        if (services.get(serviceId).getContent(contentId) != null) {

            return services.get(serviceId).getContent(contentId);
        } else {

            throw new ServiceNotFoundException();
        }

    }

}
