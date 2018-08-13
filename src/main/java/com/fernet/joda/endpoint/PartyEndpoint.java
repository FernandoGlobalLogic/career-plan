package com.fernet.joda.endpoint;

import com.fernet.joda.repository.PartyRepository;
import generated.GetPartyRequest;
import generated.GetPartyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Endpoint for party informtaionts.
 */
@Endpoint
public class PartyEndpoint {
//    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private PartyRepository partyRepository;

    @Autowired
    public PartyEndpoint(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    @PayloadRoot(localPart = "getPartyRequest")
    @ResponsePayload
    public GetPartyResponse getParties(@RequestPayload GetPartyRequest request) {
        GetPartyResponse response = new GetPartyResponse();
        response.setParty(partyRepository.findParty(request.getName()));

        return response;
    }
}
