package org.example.ticketing.domain.payment.client;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataPlatformMockApiClient {

    public boolean sendorder(){
        return true;
    }

}
