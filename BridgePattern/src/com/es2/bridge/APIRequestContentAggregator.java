package com.es2.bridge;

public class APIRequestContentAggregator extends APIRequest {

    public APIRequestContentAggregator() {

    }

    public java.lang.String getContent(java.lang.String serviceId,
                                       java.lang.String contentId)
            throws ServiceNotFoundException {


        if (services.get(serviceId).getContent(contentId) != null) {

            return services.get(serviceId).getContent(contentId);
        } else {

            throw new ServiceNotFoundException();
        }

    }

}
